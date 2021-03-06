package frsl.extractor;

import frsl.metamodel.Model;
import frsl.metamodel.UseCaseV2;

public interface ExtractorV2 {

	String extractAdditionalInfo(UseCaseV2 usecase, Model model);

}