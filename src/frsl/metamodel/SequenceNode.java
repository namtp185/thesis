package frsl.metamodel;

import frsl.sequence_diagram.util.Builder;

public class SequenceNode extends Node {
	private Actor actor;
	private Action action;
	private String description;

	public SequenceNode(String stepName, String description) {
		this.description = description;
		this.stepName = stepName;
	}
	
	public void setActor(Actor actor) {
		this.actor = actor;
	}
	
	public Actor getActor() {
		return this.actor;
	}
	
	public void setAction(Action action) {
		this.action = action;
	}
	
	public Action getAction() {
		return this.action;
	}
	
	@Override
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public void visitChild(Builder builder) {
		builder.append(toString());
		return;
	}
	
	public String toString() {
		return String.format("%s\n|%s|\n:%s;\n", this.getName(), this.actor.getName(), this.description);
	}
}
