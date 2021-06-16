package frsl.extractor;

import frsl.metamodel.Action;
import frsl.metamodel.ActorAction;
import frsl.metamodel.SystemAction;

public class SentenceTypeChecker {
	public static Action check(String sentence, String actionName) {
		if (sentence.contains("system")) {
			SystemAction a = new SystemAction(actionName);
			if (sentence.contains("get")) {
				a.getIsTrue();
			}
			if (sentence.contains("show") && sentence.contains("error")) {
				a.displayIsTrue();
			}
			if (sentence.contains("show") && !sentence.contains("error")) {
				a.errorIsTrue();
			}
			return a;
		} else {
			ActorAction a = new ActorAction(actionName);
			if(sentence.contains("click")) {
				a.triggerIsTrue();
			}
			if(sentence.contains("enter")) {
				a.enterIsTrue();
			}
			return a;
		}
	}
}
