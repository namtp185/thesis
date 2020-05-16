package frsl.grammar;

import java.util.ArrayList;
import java.util.List;

import frsl.metamodel.DescriptionInfo;
import frsl.metamodel.FlowEdge;
import frsl.metamodel.FlowStep;
import frsl.metamodel.USLNode;
import frsl.metamodel.UseCase;
import frsl.metamodel.Variable;
import frsl.metamodel.control_node.InitalNode;
import frsl.metamodel.flow_step.ActorStep;
import frsl.metamodel.flow_step.Contraint;
import frsl.metamodel.flow_step.SystemStep;
import frsl.util.CloneFactory;
import frsl.util.FlowStepTypeChecker;
import frsl.util.MetamodelUtil;
import frsl.util.SentenceTypeChecker;

public class FRSLWalker extends FRSLBaseListener {

	private UseCase metaModel;

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
	}

	public void enterAFlow(FRSLParser.AFlowContext ctx) {
		currentFlowName = ctx.LETTER().getText().trim();
	}

	public void enterBasicStep(FRSLParser.BasicStepContext ctx) {
		FlowStep flowStep = new FlowStep();
		flowStep.setType(currentFlowName);
		flowStep.setName(ctx.step().LETTER().getText().trim().toLowerCase());
		flowStep.setDescription(ctx.STATEMENT().getText().trim());
		flowStep.setValid(true);
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
			int type = FlowStepTypeChecker.checkFlowStepType(fs,metaModel);
			// if SystemStep
			if (type == 0) {
				metaModel.getUslNodes().set(i, CloneFactory.fromFlowStep(SystemStep.class, fs));
			}
			// if ActorStep
			if (type == 1) {
				ActorStep as= (ActorStep)CloneFactory.fromFlowStep(ActorStep.class, fs);
				as.setActorName(MetamodelUtil.findActorNameInSentence(as.getDescription().toLowerCase(),metaModel));
				metaModel.getUslNodes().set(i,as);
			}
			if (type == -1) {
				fs.setValid(false);
				metaModel.getUslNodes().set(i,fs);
			}
		}
		
		// create FlowEdeg;
		List<FlowEdge> flowEdges = new ArrayList();	
		List<USLNode> newUslNodes = new ArrayList<>();
		List<USLNode> uslNodes = metaModel.getUslNodes();
		boolean isHasInitalNode = false;
		boolean isHasFinalNode = false;
		FlowStep preFlowStep = null;
		for (int i = 0; i < uslNodes.size(); i++) {
			if (!(metaModel.getUslNodes().get(i) instanceof FlowStep)) {
				continue;
			}
			FlowStep fs = (FlowStep)metaModel.getUslNodes().get(i);
			if(!fs.getType().equalsIgnoreCase("Basic Flow")) {
				continue;
			}
			if(!isHasInitalNode) {
				//create initalNode and first flowEdeg
				InitalNode initalNode = new InitalNode();
				//initalNode.setPreUC(new Contraint("Pre use case name"));
				FlowEdge firstFlowEdge = new FlowEdge();
				firstFlowEdge.setSource(initalNode);
				firstFlowEdge.setTarget(fs);
				//firstFlowEdge.setGuard(guard);
				flowEdges.add(firstFlowEdge);
				isHasInitalNode = true;
			}else {
				int type = SentenceTypeChecker.check(fs.getDescription(), metaModel);
				FlowEdge fe = new FlowEdge();
				if (type == 0) {
					//fe.setSource(source);
					//fe.setTarget(target);
				}				
			}
		}
	};

}
