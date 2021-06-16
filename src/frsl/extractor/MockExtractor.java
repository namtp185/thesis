package frsl.extractor;

import java.util.List;

import frsl.grammar.AlternateFlow;
import frsl.metamodel.Model;
import frsl.metamodel.NavigableStep;
import frsl.metamodel.SequenceNode;
import frsl.metamodel.UseCaseV2;
import frsl.sequence_diagram.util.Block;
import frsl.sequence_diagram.util.Builder;
import frsl.sequence_diagram.util.InlineString;
import frsl.sequence_diagram.util.Sentence;
import frsl.util.ExtractorUtil;

public class MockExtractor implements CoreExtractor {

	@Override
	public String extract(UseCaseV2 usecase, Model model) {
		Context ctx = new Context();
		Builder builder = new Builder();
		Block treeRoot = new Block();
		Block currentNode = treeRoot;

		currentNode.addChild(new SequenceNode(usecase.getStep("1").getDescription()));
		currentNode.addChild(new SequenceNode(usecase.getStep("2").getDescription()));

		currentNode.addChild(new InlineString(
				String.format("if (%s) then(false)\n", usecase.getAlternateFlow("3a").getDescription())));
		currentNode.addChild(new InlineString(":;\n"));
		currentNode.addChild(new InlineString("else (true)\n"));
		currentNode.addChild(new Sentence(":" + usecase.getAlternateFlow("3a").getFirstStep().getDescription() + ";"));
		currentNode.addChild(new InlineString("endif\n"));

		currentNode.addChild(new InlineString("repeat\n"));
		currentNode.addChild(new SequenceNode(usecase.getStep("3").getDescription()));
		currentNode.addChild(new SequenceNode(usecase.getStep("4").getDescription()));
		currentNode.addChild(new InlineString("backward "));
		currentNode.addChild(new Sentence(":" + usecase.getAlternateFlow("5a").getFirstStep().getDescription() + ";"));
		currentNode.addChild(new InlineString(String.format("repeat while (%s) is (true) not (false)\n",
				usecase.getAlternateFlow("5a").getDescription())));

		currentNode.addChild(new InlineString("repeat\n"));
		currentNode.addChild(new SequenceNode(usecase.getStep("5").getDescription()));
		currentNode.addChild(new SequenceNode(usecase.getStep("6").getDescription()));
		currentNode.addChild(new InlineString("backward "));
		currentNode.addChild(new Sentence(":" + usecase.getAlternateFlow("7a").getFirstStep().getDescription() + ";"));
		currentNode.addChild(new InlineString(String.format("repeat while (%s) is (true) not (false)\n",
				usecase.getAlternateFlow("7a").getDescription())));

		currentNode.addChild(new SequenceNode(usecase.getStep("7").getDescription()));
		currentNode.addChild(new SequenceNode(usecase.getStep("8").getDescription()));

		currentNode.addChild(new InlineString(
				String.format("if (%s) then(false)\n", usecase.getAlternateFlow("8a").getDescription())));
		currentNode.addChild(new InlineString(":;\n"));
		currentNode.addChild(new InlineString("else (true)\n"));
		currentNode.addChild(new Sentence(":" + usecase.getAlternateFlow("8a").getFirstStep().getDescription() + ";"));
		// currentNode.addChild(new InlineString("end\n"));
		currentNode.addChild(new InlineString("endif\n"));

		currentNode.addChild(new SequenceNode(usecase.getStep("9").getDescription()));
		currentNode.addChild(new SequenceNode(usecase.getStep("10").getDescription()));
		currentNode.addChild(new SequenceNode(usecase.getStep("11").getDescription()));

		treeRoot.visitChild(builder);
		String result = builder.render();
		return result;
	}

}
