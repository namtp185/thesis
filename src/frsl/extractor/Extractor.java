package frsl.extractor;

import frsl.metamodel.Model;
import frsl.metamodel.UseCase;

public interface Extractor {

	String extractAdditionalInfo(UseCase usecase, Model model);

}