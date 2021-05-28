package frsl.sequence_diagram.util;

import frsl.metamodel.Model;

public class ActivityDiagramSyntaxTreeBuilder {
	
	private StringBuilder sb;
	private Model model;
	
	public ActivityDiagramSyntaxTreeBuilder(Model model) {
		this.model = model;
		this.sb = new StringBuilder();
	}
	
	public void append(String string) {
		this.sb.append(string);
	}
//	
//	public String render() {
//		sb.setLength(0);
//		sb.append("@startuml\n");
//		for (Node node : model.getNodes()) {
//			if(node instanceof SequenceNode) {
//				SequenceNode sqNode = (SequenceNode)node;
//				sb.append(sqNode.toString());
//			}
//			if(node instanceof ConditionNode) {
//				ConditionNode cdNode = (ConditionNode)node;
//				sb.append(node.toString());
//			}
//		}
//		sb.append("@enduml\n");
//
//		return sb.toString();
//	}
}
