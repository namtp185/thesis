package frsl.sequence_diagram.gui;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import frsl.metamodel.ConditionMessage;
import frsl.metamodel.ConditionNode;
import frsl.metamodel.ConditionStep;
import frsl.metamodel.FlowStep;
import frsl.metamodel.Message;
import frsl.metamodel.Model;
import frsl.metamodel.SequenceMessage;
import frsl.metamodel.SequenceNode;
import frsl.metamodel.SequenceStep;
import frsl.metamodel.USLNode;
import frsl.metamodel.UseCase;
import frsl.sequence_diagram.util.ActivityDiagramSyntaxTreeBuilder;
import frsl.sequence_diagram.util.Block;
import frsl.sequence_diagram.util.Builder;
import frsl.sequence_diagram.util.InlineString;
import frsl.sequence_diagram.util.Sentence;

public class Extractor {

	private UseCase usecase;
	private Model model;
	
	Queue<FlowStep> currentBasicSteps = new LinkedList<>();

	public Extractor(UseCase usecase, Model model) {
		this.usecase = usecase;
		this.model = model;
	}

	public String extractAdditionalInfo() {
		List<Message> messages = new ArrayList<>();

		for (USLNode node : usecase.getUslNodes()) {
			if (node instanceof SequenceStep) {
				SequenceStep step = (SequenceStep) node;
				String sentence = step.getActionDescription();
				// 1 flow step can contain multiple sentence
				List<SequenceMessage> newMessages = TaggerService.getInstance().extractInfo(model, sentence);
				messages.addAll(newMessages);
				SequenceNode sequenceNode = new SequenceNode(step.getName(), sentence);
				sequenceNode.setActor(newMessages.get(0).getActor());
				model.addNode(sequenceNode.getName(), sequenceNode);
			}
			if (node instanceof ConditionStep) {
				ConditionStep step = (ConditionStep) node;
				String sentence = step.getActionDescription();
				ConditionMessage message = new ConditionMessage(sentence);
				messages.add(message);
				
				ConditionNode conditionNode = new ConditionNode(step.getName(), sentence);
				model.addNode(conditionNode.getName(), conditionNode);
			}

		}
		
		model.addMessages(messages);

		Context ctx = new Context();
		ActivityDiagramSyntaxTreeBuilder tree = new ActivityDiagramSyntaxTreeBuilder(model);
		Builder builder = new Builder();
		Block treeRoot = new Block();
		Block currentNode = treeRoot;
		//
		//
		// String testString = "The system executes the extending use case Search book.
		// Then going to step 3.";
		// testString = testString.toLowerCase();
		// Pattern r = Pattern.compile("(?= then )(?> then ).*step
		// *([A-z0-9]+).*(?>\\.)");
		// Matcher m = r.matcher(testString);
		// if (m.find()) {
		// String successorStep = m.group(1).trim();
		// System.out.println(successorStep);
		// }

		Integer nodeIndex = 0;
		while (true) {
			USLNode node = usecase.getUslNodes().get(nodeIndex);
//			if (nodeIndex == Integer.parseInt(usecase.getLastStepName())) {
//				break;
//			}

			if (node instanceof FlowStep) {
				
				FlowStep flowStep = (FlowStep) node;

				
				// start a new branch
				if (node instanceof ConditionStep) {
					ConditionStep conditionStep = (ConditionStep) flowStep;
					ctx.currentConditionStep = conditionStep;

					// true path
					Block basicFlow = new Block();
					Block alternateFlow = new Block();

					// TODO: validate all steps which followed by condition steps have their
					// correspond reference alternate flow

					// index of uslNode array list
					int startBranchStep;
					int endBranchStep = -1;
					
					// index of flowstep id
					int start;
					int end = -1;

					nodeIndex++;

					startBranchStep = nodeIndex;

					String stringNodeIndex = usecase.getFlowStepStringIndex(nodeIndex);
					start = Integer.parseInt(stringNodeIndex);
					String stringAlternateNodeIndex = usecase.getReferenceAlternateStep(stringNodeIndex);

					try {
						// validate if reference alternate node is found
						if (stringAlternateNodeIndex == null) {
							throw new Exception();
						}
						nodeIndex = usecase.getFlowStepIntIndex(stringAlternateNodeIndex);
						// iterate all step in the alternate flow
						String nextGoTo = null;
						while (true) {
							node = usecase.getUslNodes().get(nodeIndex);
							if (node instanceof FlowStep) {
								flowStep = (FlowStep) node;

								// problem scope: alternative flow cannot contain alternative flow
								if (node instanceof ConditionStep) {
									throw new Exception();
								}

								// append alternate flow child
								alternateFlow.addChild(model.getNode(flowStep.getName()));

								nextGoTo = checkNextStep(flowStep.getDescription());
								if (nextGoTo != null) {
									break;
								}

							}
							nodeIndex++;
						}

						// append basic flow child
						
						end = Integer.parseInt(nextGoTo);

						System.out.println("startend");
						System.out.println(start);
						System.out.println(end);
						if (start < end) {
							for (int i = start; i <= end; i++) {
								//FIXME
								FlowStep stepInBasicFlow = usecase.getFlowStep(i);
//								basicFlow.addChild(new Sentence(stepInBasicFlow.getDescription()));
								basicFlow.addChild(model.getNode(stepInBasicFlow.getName()));
								endBranchStep = usecase.getFlowStepIntIndex(nextGoTo);
							}
						} else if (start == end){
							for (int i = end; i <= start; i++) {
								FlowStep stepInBasicFlow = usecase.getFlowStep(i);
//								basicFlow.addChild(new SequenceNode(stepInBasicFlow.getDescription()));
								basicFlow.addChild(model.getNode(stepInBasicFlow.getName()));
								endBranchStep = startBranchStep + 1;
							}
						} else {
							for (int i = end; i <= start; i++) {
								FlowStep stepInBasicFlow = usecase.getFlowStep(i);
//								basicFlow.addChild(new SequenceNode(stepInBasicFlow.getDescription()));
//								basicFlow.addChild(model.getNode(stepInBasicFlow.getName()));
								endBranchStep = startBranchStep;
							}
							while(!currentBasicSteps.isEmpty()) {
								basicFlow.addChild(model.getNode(currentBasicSteps.poll().getName()));
							}
						}

						if (start < end) { // if else
							currentNode.addChild(new InlineString(
									String.format("if (%s) then(true) ", conditionStep.getDescription())));
							currentNode.addChild(basicFlow);
							currentNode.addChild(new InlineString(" else "));
							currentNode.addChild(alternateFlow);
							currentNode = basicFlow;
						} else if(start == end) {
							currentNode.addChild(new Sentence("repeat"));
							currentNode.addChild(basicFlow);
							currentNode.addChild(new InlineString("backward"));
							currentNode.addChild(alternateFlow);
							currentNode.addChild(new ConditionNode(
									conditionStep.getName(),
									String.format("repeat while (%s) is(false) not (true)",
											conditionStep.getDescription())));
							
							currentNode = alternateFlow;
						} else {
							currentNode.addChild(new Sentence("repeat"));
							currentNode.addChild(basicFlow);
							currentNode.addChild(new InlineString("backward"));
							currentNode.addChild(alternateFlow);
//							for(Node node: alternateFlow) {
//								
//							}
							currentNode = alternateFlow;
							
							currentNode.addChild(new ConditionNode( // repeat while
									conditionStep.getName(),
									String.format("repeat while (%s) is(false) not (true)",
											conditionStep.getDescription())));
						}
						nodeIndex = endBranchStep;
						System.out.println("debug nodeindex");
						System.out.println(nodeIndex);
						continue;

					} catch (Exception e) {
						e.printStackTrace();
					}

				}
				// currently in basic flow
//				if (node instanceof SequenceStep && ctx.currentConditionStep == null) {
//					SequenceStep sequenceStep = (SequenceStep) flowStep;
//					currentNode.addChild(model.getNode(sequenceStep.getName()));
//				}
//				// currently in alternate flow
//				if (node instanceof SequenceStep && ctx.currentConditionStep != null) {
//					SequenceStep sequenceStep = (SequenceStep) flowStep;
//					currentNode.addChild(model.getNode(sequenceStep.getName()));
//				}
				
				if (node instanceof SequenceStep) {
					SequenceStep sequenceStep = (SequenceStep) flowStep;
					currentBasicSteps.add(sequenceStep);
				}

				ctx.preStep = flowStep;
				
				
				if(flowStep.getName().equals(usecase.getLastStepName())) {
					break;
				}
				
			}

			// if (node instanceof SequenceStep) {
			// SequenceStep step = (SequenceStep) node;
			// String sentence = step.getActionDescription();
			// // 1 flow step can contain multiple sentence
			// List<SequenceMessage> newMessages =
			// TaggerService.getInstance().extractInfo(model, sentence);
			// messages.addAll(newMessages);
			// }
			// if (node instanceof ConditionStep) {
			// ConditionStep step = (ConditionStep) node;
			// String sentence = step.getActionDescription();
			// ConditionMessage message = new ConditionMessage(sentence);
			// messages.add(message);
			// }
			
			
			
			nodeIndex++;
			if(!(usecase.getUslNodes().get(nodeIndex) instanceof ConditionStep)) {
				String stringNodeIndex = usecase.getFlowStepStringIndex(nodeIndex);
				int start_ = Integer.parseInt(stringNodeIndex);
				System.out.println(start_);
			}
			
		} 

		treeRoot.visitChild(builder);
		System.out.println("render result:\n");
		String result = builder.render();
		System.out.println(result);
		return result;

		// for(Message message: messages) {
		// System.out.println(message.toString());
		// if(message instanceof SequenceMessage) {
		// SequenceMessage sqMessage = (SequenceMessage)message;
		// SequenceNode node = new SequenceNode();
		// node.setActor(sqMessage.getActor());
		// node.setAction(sqMessage.getAction());
		// node.setDescription(sqMessage.getDescription());
		// nodes.add(node);
		// }
		//
		// if(message instanceof ConditionMessage) {
		// ConditionMessage cdMessage = (ConditionMessage)message;
		// ConditionNode node = new ConditionNode(cdMessage.getDescription());
		// nodes.add(node);
		// }
		// }


	}

	public static void findFlowStep(String stepname, UseCase metaModel) {

		String stepName = stepname.toLowerCase();
		FlowStep step = metaModel.getFlowStep(stepName);
		//
		// for (USLNode node : metaModel.getUslNodes()) {
		// if (!(node instanceof FlowStep)) {
		// continue;
		// }
		// String stepName = stepname.toLowerCase();
		// String currentStepName;
		// FlowStep fs = (FlowStep) node;
		// if (fs.getType().equalsIgnoreCase("Basic Flow")) {
		// currentStepName = fs.getName();
		// } else {
		// currentStepName = fs.getType() + fs.getName();
		// }
		// if (currentStepName.equalsIgnoreCase(stepName)) {
		// return fs;
		// }
		// }
		// return null;
	}

	public String checkNextStep(String stepDescription) {
		Pattern r = Pattern.compile("(?= then )(?> then ).*step *([A-z0-9]+).*(?>\\.)");
		Matcher m = r.matcher(stepDescription.toLowerCase());
		if (m.find()) {
			String successorStep = m.group(1).trim();
			return successorStep;
		}
		return null;
	}

}

class Context {
	// null: currently in basic flow
	// non-null: currently in alternate flow
	FlowStep currentConditionStep = null;
	FlowStep currentSequenceStep;
	FlowStep preStep = null;
}