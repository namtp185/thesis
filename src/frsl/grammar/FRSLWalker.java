package frsl.grammar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import frsl.metamodel.DescriptionInfo;
import frsl.metamodel.FlowEdge;
import frsl.metamodel.FlowStep;
import frsl.metamodel.USLNode;
import frsl.metamodel.UseCase;
import frsl.metamodel.Variable;
import frsl.metamodel.control_node.DecisionNode;
import frsl.metamodel.control_node.FinalNode;
import frsl.metamodel.control_node.ForkNode;
import frsl.metamodel.control_node.InitialNode;
import frsl.metamodel.flow_step.ActorStep;
import frsl.metamodel.flow_step.Contraint;
import frsl.metamodel.flow_step.SystemStep;
import frsl.util.CloneFactory;
import frsl.util.FlowStepTypeChecker;
import frsl.util.MetamodelUtil;
import frsl.util.SentenceTypeChecker;

public class FRSLWalker extends FRSLBaseListener {

	private UseCase metaModel;

	private boolean isHasInitalNode = false;
	private boolean isHasFinalNode = false;
	private FinalNode finalNode;

	private Set<String> flows = new HashSet<String>();

	private String currentFlowName;

	public UseCase getMetaModel() {
		return metaModel;
	}

	public void enterMetaModel(FRSLParser.MetaModelContext ctx) {
		metaModel = new UseCase();
		metaModel.setDescriptionInfo(new DescriptionInfo());
		metaModel.setVariables(new ArrayList<Variable>());
		metaModel.setFlowEdges(new ArrayList<FlowEdge>());
		metaModel.setUslNodes(new ArrayList<USLNode>());
	}

	public void enterUse_case_name(FRSLParser.Use_case_nameContext ctx) {
		metaModel.getDescriptionInfo().setUseCaseName(ctx.getText().trim());
	}

	public void enterUse_case_description(FRSLParser.Use_case_descriptionContext ctx) {
		metaModel.getDescriptionInfo().setDescription(ctx.getText().trim());
	}

	public void enterActor_names(FRSLParser.Actor_namesContext ctx) {
		metaModel.getDescriptionInfo().setActors(new ArrayList<String>());
	}

	public void enterActor_name(FRSLParser.Actor_nameContext ctx) {
		metaModel.getDescriptionInfo().getActors().add(ctx.getText().trim());
	}

	public void enterPre_condition(FRSLParser.Pre_conditionContext ctx) {
		metaModel.getDescriptionInfo().setPostCondition(ctx.getText().trim());
	}

	public void enterPost_condition(FRSLParser.Post_conditionContext ctx) {
		metaModel.getDescriptionInfo().setPostCondition(ctx.getText().trim());
	}

	public void enterTrigger_info(FRSLParser.Trigger_infoContext ctx) {
		metaModel.getDescriptionInfo().setTrigger(ctx.getText().trim());
	}

	public void enterSpecial_requirement(FRSLParser.Special_requirementContext ctx) {
		metaModel.getDescriptionInfo().setSpecialRequirement(ctx.getText().trim());
	}

	public void enterBasicFlow(FRSLParser.BasicFlowContext ctx) {
		currentFlowName = "Basic Flow";
		flows.add(currentFlowName);
	}

	public void enterAFlow(FRSLParser.AFlowContext ctx) {
		currentFlowName = ctx.LETTER().getText().trim();
		flows.add(currentFlowName);
	}

	public void enterBasicStep(FRSLParser.BasicStepContext ctx) {
		FlowStep flowStep = new FlowStep();
		flowStep.setType(currentFlowName);
		flowStep.setName(ctx.step().LETTER().getText().trim().toLowerCase());
		flowStep.setDescription(ctx.STATEMENT().getText().trim());
		
		flowStep.setActionDescription(flowStep.getDescription().substring(0,flowStep.getDescription().indexOf(".")));
		flowStep.setValid(true);
		if (currentFlowName.equalsIgnoreCase("Basic Flow")) {
			flowStep.setId("Step_" + flowStep.getName());
		} else {
			flowStep.setId("Step_" + flowStep.getType().replace(" ", "") + flowStep.getName());
		}
		metaModel.getUslNodes().add(flowStep);
	}

	public void exitMetaModel(FRSLParser.MetaModelContext ctx) {
		// Extracted some basic information from text (write concreteSyntax) and push to
		// metalmodel (of abtractSystax).
		// Now, we are extracting more information,and push to metalmodel .

		// First, check type of flow step
		for (int i = 0; i < metaModel.getUslNodes().size(); i++) {
			if (!(metaModel.getUslNodes().get(i) instanceof FlowStep)) {
				continue;
			}
			FlowStep fs = (FlowStep) metaModel.getUslNodes().get(i);
			int type = FlowStepTypeChecker.checkFlowStepType(fs, metaModel);
			// if SystemStep
			if (type == 0) {
				metaModel.getUslNodes().set(i, CloneFactory.fromFlowStep(SystemStep.class, fs));
			}
			// if ActorStep
			if (type == 1) {
				ActorStep as = (ActorStep) CloneFactory.fromFlowStep(ActorStep.class, fs);
				as.setActorName(MetamodelUtil.findActorNameInSentence(as.getDescription().toLowerCase(), metaModel));
				metaModel.getUslNodes().set(i, as);
			}
			if (type == -1) {
				fs.setValid(false);
				metaModel.getUslNodes().set(i, fs);
			}
		}

		// create FlowEdeg;
		List<USLNode> uslNodes = metaModel.getUslNodes();
		USLNode preNode = null;
		for (String flow : flows) {
			preNode = null;
			for (int i = 0; i < uslNodes.size(); i++) {
				if (!(metaModel.getUslNodes().get(i) instanceof FlowStep)) {
					continue;
				}
				FlowStep fs = (FlowStep) metaModel.getUslNodes().get(i);
				if (!fs.getType().equalsIgnoreCase(flow)) {
					continue;
				}
				if (!isHasInitalNode) {
					// create initialNode
					InitialNode initialNode = new InitialNode();
					initialNode.setId("InitialNode");
					preNode = initialNode;
					isHasInitalNode = true;
				}
				if (preNode == null) {
					if (MetamodelUtil.checkNodeIsTargetOfOneInFlowEdges(fs, metaModel)) {
					} else {
						fs.setValid(false);
						preNode = fs;
						continue;
					}
				} else {
					FlowEdge fe = new FlowEdge();
					fe.setSource(preNode);
					fe.setTarget(fs);
					fe = CloneFactory.validateFlowEdgeType(fe);
					metaModel.getFlowEdges().add(fe);
				}

				int type = SentenceTypeChecker.check(fs.getDescription(), metaModel);
				if (type == 0) {
					// normal
					preNode = fs;
				}
				if (type == 1) {
					// condition

					DecisionNode decisionNode = new DecisionNode();
					decisionNode.setId("DecisionNode" + fs.getId());
					FlowEdge feFSToDN = new FlowEdge();
					feFSToDN.setSource(fs);
					feFSToDN.setTarget(decisionNode);
					feFSToDN = CloneFactory.validateFlowEdgeType(feFSToDN);
					metaModel.getFlowEdges().add(feFSToDN);

					String description = fs.getDescription().toLowerCase();
					if (description.contains("else")) {
						// if condition then.... else...
						Pattern r = Pattern.compile(
								"(?<=if)(.*)(?=then)(?>then).*step *([A-z0-9]+).*(?>else).*step *([A-z0-9]+).*(?>\\.)");
						Matcher m = r.matcher(description);
						if (m.find()) {
							String condition = m.group(1).trim();
							String trueStep = m.group(2);
							String falseStep = m.group(3);
							decisionNode.setDescription(condition);

							FlowEdge trueFlowEdge = new FlowEdge();
							trueFlowEdge.setSource(decisionNode);
							trueFlowEdge.setTarget(MetamodelUtil.findFlowStep(trueStep, metaModel));
							Contraint trueContraint = new Contraint("Condition is true");
							trueFlowEdge.setGuard(trueContraint);
							trueFlowEdge = CloneFactory.validateFlowEdgeType(trueFlowEdge);
							metaModel.getFlowEdges().add(trueFlowEdge);

							FlowEdge falseFlowEdge = new FlowEdge();
							falseFlowEdge.setSource(decisionNode);
							falseFlowEdge.setTarget(MetamodelUtil.findFlowStep(falseStep, metaModel));
							Contraint falseContraint = new Contraint("Condition is false");
							falseFlowEdge.setGuard(falseContraint);
							falseFlowEdge = CloneFactory.validateFlowEdgeType(falseFlowEdge);
							metaModel.getFlowEdges().add(falseFlowEdge);

							preNode = null;
						}
					} else {
						// if condition then.... (default else is next step of flow)
						Pattern r = Pattern.compile("(?<=if)(.*)(?=then)(?>then).*step *([A-z0-9]+).*(?>\\.)");
						Matcher m = r.matcher(description);
						if (m.find()) {
							String condition = m.group(1).trim();
							String trueStep = m.group(2);
							decisionNode.setDescription(condition);

							FlowEdge trueFlowEdge = new FlowEdge();
							trueFlowEdge.setSource(decisionNode);
							trueFlowEdge.setTarget(MetamodelUtil.findFlowStep(trueStep, metaModel));
							Contraint trueContraint = new Contraint("Condition is true");
							trueFlowEdge.setGuard(trueContraint);
							trueFlowEdge = CloneFactory.validateFlowEdgeType(trueFlowEdge);
							metaModel.getFlowEdges().add(trueFlowEdge);

							preNode = decisionNode;
						}
					}

				}
				if (type == 2) {
					// iteration
				}
				if (type == 3) {
					// concurrent
					ForkNode forkNode = new ForkNode();
					forkNode.setDescription(fs.getDescription());
					preNode = forkNode;

				}
				if (type == 4) {
					// go to
					preNode = null;
					String targetStepName = MetamodelUtil.findStepName(fs, metaModel);
					if (targetStepName == null) {
						preNode = null;
					}
					FlowStep targetStep = MetamodelUtil.findFlowStep(targetStepName, metaModel);
					FlowEdge feToOtherNode = new FlowEdge();
					feToOtherNode.setSource(fs);
					feToOtherNode.setTarget(targetStep);
					feToOtherNode = CloneFactory.validateFlowEdgeType(feToOtherNode);
					metaModel.getFlowEdges().add(feToOtherNode);
				}
				if (type == 5) {
					if (!isHasFinalNode) {
						// create initialNode
						finalNode = new FinalNode();
						finalNode.setId("FinalNode");
						isHasFinalNode = true;
					}
					FlowEdge feToEndNode = new FlowEdge();
					feToEndNode.setSource(fs);
					feToEndNode.setTarget(finalNode);
					feToEndNode = CloneFactory.validateFlowEdgeType(feToEndNode);
					metaModel.getFlowEdges().add(feToEndNode);
					preNode = null;
				}
			}
		}
	};

}
