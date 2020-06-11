package frsl.util;

import frsl.metamodel.UseCase;

public class SentenceTypeChecker {
	public static int check(String sentence, UseCase metaModel) {
		sentence = sentence.toLowerCase();
		if (MetamodelUtil.isContainStepName(sentence, metaModel) != null) {
			if (sentence.contains(" go ") || sentence.contains(" goes ") || sentence.contains(" going ")) {
				if (sentence.contains("if ")) {
					return 1;
				} else
					// goto
					return 4;
			}
			if ((sentence.contains("until ") || sentence.contains("while "))
					&& (sentence.contains(" do ") || sentence.contains(" does "))) {
				// iteration
				return 2;
			}
			if ((sentence.contains("concurrently") || sentence.contains("concurrent"))
					&& (sentence.contains("executing") || sentence.contains("execute") || sentence.contains(" do ")
							|| sentence.contains(" does "))) {
				// concurrent
				return 3;
			}
			return -1;
		}
		// normal type
		return 0;
	}
}
