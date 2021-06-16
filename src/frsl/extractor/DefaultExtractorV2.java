package frsl.extractor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import frsl.metamodel.Model;
import frsl.metamodel.UseCaseV2;

public class DefaultExtractorV2 implements ExtractorV2 {
	CoreExtractor extractor = new MockExtractor();
//	CoreExtractor extractor = new MockExtractor2();

	@Override
	public String extractAdditionalInfo(UseCaseV2 usecase, Model model) {
		return extractor.extract(usecase, model);
	}

	private String checkNextStep(String stepDescription) {
		Pattern r = Pattern.compile("(?= then )(?> then ).*step *([A-z0-9]+).*(?>\\.)");
		Matcher m = r.matcher(stepDescription.toLowerCase());
		if (m.find()) {
			String successorStep = m.group(1).trim();
			return successorStep;
		}
		return null;
	}

}