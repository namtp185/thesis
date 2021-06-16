package frsl.extractor;

import frsl.metamodel.Actor;
import frsl.metamodel.ActorAction;
import frsl.metamodel.SequenceMessage;
import frsl.metamodel.SystemAction;

public class SecondarySentenceTypeChecker {
	public static SequenceMessage check(String sentence) {
		SequenceMessage message = new SequenceMessage();
		message.setDescription(sentence);
		if (sentence.contains("system")) {
			SystemAction a = new SystemAction();
			String actorStr;
			if (sentence.contains("get")) {
				a.getIsTrue();
			}
			if (sentence.contains("show") && sentence.contains("error")) {
				a.displayIsTrue();
			}
			if (sentence.contains("show") && !sentence.contains("error")) {
				a.errorIsTrue();
			}
			if(sentence.contains("check")) {
				a.hasValidate();
				actorStr = sentence.split("check")[0].toLowerCase().replace("the ", "");
				message.setActor(new Actor(actorStr));
			}
			message.setAction(a);
		} else {
			ActorAction a = new ActorAction();
			if(sentence.contains("click")) {
				a.triggerIsTrue();
			}
			if(sentence.contains("enter")) {
				a.enterIsTrue();
			}
			message.setAction(a);
		}
		return message;
	}
}
