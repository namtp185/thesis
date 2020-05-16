package frsl.util;

import frsl.metamodel.FlowStep;
import frsl.metamodel.UseCase;

public class FlowStepTypeChecker {
	public static int checkFlowStepType(FlowStep fs, UseCase metaModel) {
		String content = fs.getDescription().toLowerCase();
		int pOfSystemKeyword = content.indexOf("system");
		int pOfActorName = -1;
		String actorName = null;
		for (String aName : metaModel.getDescriptionInfo().getActors()) {
			int findResult = content.indexOf(aName.toLowerCase());
			if (findResult != -1) {
				actorName = aName;
				pOfActorName = findResult;
				break;
			}
		}
		if (pOfActorName != -1 && (pOfSystemKeyword == -1 || pOfActorName < pOfSystemKeyword)) {
			return 1;
		}
		if (pOfSystemKeyword != -1 && (pOfActorName == -1 || pOfSystemKeyword < pOfActorName)) {
			return 0;
		}
		return -1;
	}
}
