package frsl.sequence_diagram.gui;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import frsl.grammar.AlternateFlow;
import frsl.metamodel.ConditionNode;
import frsl.metamodel.FlowStep;
import frsl.metamodel.Message;
import frsl.metamodel.Model;
import frsl.metamodel.NavigableStep;
import frsl.metamodel.SequenceNode;
import frsl.metamodel.UseCaseV2;
import frsl.sequence_diagram.util.ActivityDiagramSyntaxTreeBuilder;
import frsl.sequence_diagram.util.Block;
import frsl.sequence_diagram.util.Builder;
import frsl.sequence_diagram.util.InlineString;
import frsl.sequence_diagram.util.Sentence;

public class DefaultExtractorV2 implements ExtractorV2 {

	Queue<FlowStep> currentBasicSteps = new LinkedList<>();

	@Override
	public String extractAdditionalInfo(UseCaseV2 usecase, Model model) {
		return mock(usecase, model);
	}
	
	private String mock(UseCaseV2 usecase, Model model) {
		Context ctx = new Context();
		Builder builder = new Builder();
		Block treeRoot = new Block();
		Block currentNode = treeRoot;
		
		// iterate all alternate flow with starts and end
		for(AlternateFlow alternateFlow: usecase.getAlternateFlowsList()) {
			String start = alternateFlow.getStart();
			String end = alternateFlow.getEnd();
			
			// gather all step in range start to end in basic flow and alternate flow
			List<NavigableStep> basicSteps = gatherStep(usecase, start, end);
			
			for(NavigableStep step: basicSteps) {
				System.out.println(step.getName());
				System.out.println(step.getDescription());
			}
			
			// insert to basicFlow and alternateFlow block
			
			
			// insert two block to tree
			
			// update current node and start new iteration
			
		}
		
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
		currentNode.addChild(new InlineString(
				String.format("repeat while (%s) is (true) not (false)\n", usecase.getAlternateFlow("5a").getDescription())));
		
		currentNode.addChild(new InlineString("repeat\n"));
		currentNode.addChild(new SequenceNode(usecase.getStep("5").getDescription()));
		currentNode.addChild(new SequenceNode(usecase.getStep("6").getDescription()));
		currentNode.addChild(new InlineString("backward "));
		currentNode.addChild(new Sentence(":" + usecase.getAlternateFlow("7a").getFirstStep().getDescription() + ";"));
		currentNode.addChild(new InlineString(
				String.format("repeat while (%s) is (true) not (false)\n", usecase.getAlternateFlow("7a").getDescription())));
		
		
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
	
	private List<NavigableStep> gatherStep(UseCaseV2 usecase, String start, String end) {
		List<NavigableStep> steps = new ArrayList<>();

		System.out.println("debug");
		System.out.println(isGreaterThan(start, end));
		
		if(isGreaterThan(start, end)) {
			// swap start and end
			String swap = start;
			start = end;
			end = swap;
		}

		int startIdx = Integer.parseInt(start);
		
		if(end == null) return steps;
		
		int endIdx = Integer.parseInt(end);
		
		System.out.println(startIdx);
		System.out.println(endIdx);
		
		for(int i = startIdx; i < endIdx; i++) {
			steps.add(usecase.getStep(String.valueOf(i)));
		}
		
		return steps;
	}
	
	// assume end is greater than start when end is null
	private boolean isGreaterThan(String string1, String string2) {
		if(StringUtils.isNumeric(string1) && StringUtils.isNumeric(string2)) {
			int index1 = Integer.parseInt(string1);
			int index2 = Integer.parseInt(string2);
			return index1 > index2;
		} else {
			return false;
		}
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