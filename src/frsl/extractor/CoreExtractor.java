package frsl.extractor;

import frsl.metamodel.Model;
import frsl.metamodel.UseCaseV2;

public interface CoreExtractor {
	public String extract(UseCaseV2 usecase, Model model);
}
