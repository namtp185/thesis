package frsl.extractor;

import java.util.List;

import frsl.grammar.AlternateFlow;
import frsl.metamodel.Model;
import frsl.metamodel.NavigableStep;
import frsl.metamodel.UseCaseV2;
import frsl.sequence_diagram.util.Block;
import frsl.sequence_diagram.util.Builder;
import frsl.util.ExtractorUtil;

public class MockExtractor2 implements CoreExtractor {

	@Override
	public String extract(UseCaseV2 usecase, Model model) {
		Context ctx = new Context();
		Builder builder = new Builder();
		Block treeRoot = new Block();
		Block currentNode = treeRoot;

		// iterate all alternate flow with starts and end
		for (AlternateFlow alternateFlow : usecase.getAlternateFlowsList()) {
			String start = alternateFlow.getStart();
			String end = alternateFlow.getEnd();

			// gather all step in range start to end in basic flow and alternate flow
			List<NavigableStep> basicSteps = ExtractorUtil.gatherStep(usecase, start, end);

			for (NavigableStep step : basicSteps) {
//				System.out.println(step.getName());
//				System.out.println(step.getDescription());
			}

			// insert to basicFlow and alternateFlow block

			// insert two block to tree

			// update current node and start new iteration

		}

		treeRoot.visitChild(builder);
		String result = builder.render();
		return result;
	}

}
