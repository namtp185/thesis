package frsl.metamodel;

public class SequenceMessage extends Message {
	private Actor actor;
	private Action action;
	private Entity entity;
	private String start;
	private String end;
	
	public Actor getActor() {
		return actor;
	}
	
	public Action getAction() {
		return action;
	}
	
	public Entity getEntity() {
		return entity;
	}
	
	public void setActor(Actor actor) {
		this.actor = actor;
	}
	
	public void setAction(Action action) {
		this.action = action;
	}
	
	public void setEntity(Entity entity) {
		this.entity = entity;
	}
	
	@Override
	public String toString() {
		return String.format("%s -- %s: %s", start, end, action);
	}
	
}
