package frsl.util;

import java.util.ArrayList;
import java.util.List;

import frsl.metamodel.ControlNode;
import frsl.metamodel.FlowEdge;
import frsl.metamodel.FlowStep;
import frsl.metamodel.USLNode;
import frsl.metamodel.UseCase;
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
				stepName = stepName + fs.getType() + fs.getName();
			}
			if ((sentence.replace(".", " ").replace(",", " ")).contains(stepName+" ")) {
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
		if(stepname==null) return null;

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

	public static String findStepName(FlowStep fs, UseCase metaModel) {
		List<String> result = new ArrayList<>();
		String sentence = fs.getDescription().toLowerCase();
		return isContainStepName(sentence, metaModel).replace("step", "").trim();
	}

	public static boolean checkNodeIsTargetOfOneInFlowEdges(USLNode node, UseCase metaModel) {
		for (FlowEdge fe : metaModel.getFlowEdges()) {
			if (fe.getTarget() instanceof FlowStep && node instanceof FlowStep
					&& ((FlowStep) fe.getTarget()).getType().equalsIgnoreCase(((FlowStep) node).getType())
					&& ((FlowStep) fe.getTarget()).getName().equalsIgnoreCase(((FlowStep) node).getName()))
				return true;
			if (fe.getTarget() instanceof ControlNode && node instanceof ControlNode
					&& ((ControlNode) fe.getTarget()).getDescription().equalsIgnoreCase(((ControlNode) node).getDescription())
					) return true;
		}
		return false;
	}
}
