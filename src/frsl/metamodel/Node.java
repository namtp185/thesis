package frsl.metamodel;

import frsl.sequence_diagram.util.Builder;
import frsl.sequence_diagram.util.Token;

public abstract class Node implements Token {
	protected String description;
	protected String stepName;

	public Node() {
		
	}
	
	@Override
	public boolean isTerminal() {
		return false;
	}
	
	@Override
	public void visitChild(Builder builder) {
		builder.append(description + "\n");
		return;
	}

	public Node(String description) {
		this.setDescription(description);
	}
	
	public String getName() {
		return this.stepName;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return this.description;
	}

	@Override
	public String toString() {
		return this.description;
	}
}
