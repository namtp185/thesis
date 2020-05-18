package frsl.util;

import java.util.ArrayList;
import java.util.List;

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
			if (sentence.contains(stepName)) {
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

	public static List<String> findStepNames(FlowStep fs, UseCase metaModel) {
		List<String> result = new ArrayList<>();
		String sentence = fs.getDescription().toLowerCase();
		String stepName = isContainStepName(sentence, metaModel);
		while (stepName == null) {
			result.add(stepName.replace("step ", ""));
			sentence = sentence.replace(stepName, "");
			stepName = isContainStepName(sentence, metaModel);
		}
		return result;
	}
	
	public static boolean checkNodeIsTargetOfOneInFlowEdges(USLNode node, UseCase metaModel) {
		return false;
	}
}
