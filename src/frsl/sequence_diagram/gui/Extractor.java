package frsl.sequence_diagram.gui;

import frsl.metamodel.Model;
import frsl.metamodel.UseCase;

public interface Extractor {

	String extractAdditionalInfo(UseCase usecase, Model model);

}