package frsl.util;

import java.util.ArrayList;
import java.util.List;

import frsl.metamodel.FlowEdge;
import frsl.metamodel.FlowStep;
import frsl.metamodel.USLNode;
import frsl.metamodel.UseCase;
import frsl.metamodel.control_node.ForkNode;
import frsl.metamodel.flow_step.ActorStep;
import frsl.metamodel.flow_step.SystemStep;

public class MetamodelUtil {

	public static List<ActorStep> getAllActorStep(UseCase metaModel) {
		List<ActorStep> actorSteps = new ArrayList<>();
		for (USLNode node : metaModel.getUslNodes()) {
			if (node instanceof ActorStep) {
				actorSteps.add((ActorStep) node);
			}
		}
		return actorSteps;
	}

	public static List<SystemStep> getAllSystemStep(UseCase metaModel) {
		List<SystemStep> systemSteps = new ArrayList<>();
		for (USLNode node : metaModel.getUslNodes()) {
			if (node instanceof SystemStep) {
				systemSteps.add((SystemStep) node);
			}
		}
		return systemSteps;
	}

	public static String isContainStepName(String sentence, UseCase metaModel) {
		sentence = sentence.toLowerCase();
		for (USLNode node : metaModel.getUslNodes()) {
			if (!(node instanceof FlowStep)) {
				continue;
			}
			FlowStep fs = (FlowStep) node;
			String stepName = "step ";
			if (fs.getType().equalsIgnoreCase("Basic Flow")) {
				stepName = stepName + fs.getName();
			} else {
				stepName = stepName + fs.getType().toLowerCase() + fs.getName();
			}
			if ((sentence.replace(".", " ").replace(",", " ")).contains(stepName + " ")) {
				return stepName;
			}
		}
		return null;
	}

	public static String findActorNameInSentence(String sentence, UseCase metaModel) {
		String actorName = null;
		for (String aName : metaModel.getDescriptionInfo().getActors()) {
			if (sentence.contains(aName.toLowerCase())) {
				actorName = aName;
				break;
			}
		}
		return actorName;
	}

	public static FlowStep findFlowStep(String stepname, UseCase metaModel) {
		if (stepname == null)
			return null;

		for (USLNode node : metaModel.getUslNodes()) {
			if (!(node instanceof FlowStep)) {
				continue;
			}
			String stepName = stepname.toLowerCase();
			String currentStepName;
			FlowStep fs = (FlowStep) node;
			if (fs.getType().equalsIgnoreCase("Basic Flow")) {
				currentStepName = fs.getName();
			} else {
				currentStepName = fs.getType() + fs.getName();
			}
			if (currentStepName.equalsIgnoreCase(stepName)) {
				return fs;
			}
		}
		return null;
	}

	public static FlowEdge findFlowEdge(USLNode node, UseCase metaModel) {
		for (FlowEdge flowEdge : metaModel.getFlowEdges()) {
			if (flowEdge.getId().equalsIgnoreCase(node.getId()) || flowEdge.getId().equalsIgnoreCase(node.getId()))
				return flowEdge;
		}
		return null;
	}

	public static String findStepName(FlowStep fs, UseCase metaModel) {
		String sentence = fs.getDescription().toLowerCase();
		String stepName = isContainStepName(sentence, metaModel);
		if (stepName != null) {
			stepName = stepName.replace("step", "").trim();
		}
		return stepName;
	}

	public static List<String> findListStepName(FlowStep fs, UseCase metaModel) {
		List<String> rs = new ArrayList<String>();
		String sentence = fs.getDescription().toLowerCase();
		String stepName = isContainStepName(sentence, metaModel);
		if (stepName != null) {
			stepName = stepName.replace("step", "").trim();
		}
		while (stepName != null) {
			rs.add(stepName);
			sentence = sentence.replace(stepName, "");
			stepName = isContainStepName(sentence, metaModel);
			if (stepName != null) {
				stepName = stepName.replace("step", "").trim();
			}
		}
		return rs;
	}

	public static boolean isTargetOfOneInFlowEdges(USLNode node, UseCase metaModel) {
		for (FlowEdge fe : metaModel.getFlowEdges()) {
			if (fe.getTarget().getId().equalsIgnoreCase(node.getId()))
				return true;
		}
		return false;
	}

	public static boolean isSourceOfOneInFlowEdges(USLNode node, UseCase metaModel) {
		for (FlowEdge fe : metaModel.getFlowEdges()) {
			if (fe.getSource().getId().equalsIgnoreCase(node.getId()))
				return true;
		}
		return false;
	}

	public static boolean isHasPreNode(USLNode curNode, UseCase metaModel) {
		List<FlowEdge> listFe = metaModel.getFlowEdges();
		for (FlowEdge fe : listFe) {
			if (fe.getTarget().getId().equalsIgnoreCase(curNode.getId()))
				return true;
		}
		return false;
	}

	public static boolean isConcurentlyRunning(USLNode node1, USLNode node2, UseCase metaModel) {
		String forkNodeId = null;
		for (FlowEdge fe : metaModel.getFlowEdges()) {
			if (fe.getSource() instanceof ForkNode && fe.getTarget().getId().equalsIgnoreCase(node1.getId())) {
				forkNodeId = fe.getSource().getId();
			}
		}
		if (forkNodeId == null) {
			return false;
		} else {
			for (FlowEdge fe : metaModel.getFlowEdges()) {
				if (fe.getSource().getId().equalsIgnoreCase(forkNodeId)
						&& fe.getTarget().getId().equalsIgnoreCase(node2.getId())) {
					return true;
				}
			}
			return false;
		}
	}

//	private static boolean isOnSameFlow(USLNode node1, USLNode node2, UseCase metaModel) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	private static List<String> findListParentForkNode(USLNode node, UseCase metaModel) {
//		List<String> rs = new ArrayList<String>();
//		for (FlowEdge fe : metaModel.getFlowEdges()) {
//			if(fe.getTarget() instanceof ForkNode && isChildOfFlowEdge(node,fe,metaModel)) {
//				rs.add(fe.getSource().getId());
//			}
//		}
//		return rs;
//	}
}
