package frsl.metamodel;

import frsl.sequence_diagram.util.Builder;

public class ConditionNode extends Node {
	public ConditionNode() {

	}

	public ConditionNode(String stepName, String description) {
		this.stepName = stepName;
		this.setDescription(description);
	}
	
	@Override
	public void visitChild(Builder builder) {
		builder.append(toString());
		return;
	}
	
	@Override
	public String toString() {
		return String.format("%s\n", this.description);
	}
}
