package frsl.metamodel;

public class ActorAction extends Action {
	private boolean enterData;
	private boolean triggerEvent;
	
	public ActorAction() {
		
	}
	
	public ActorAction(String description) {
		this.description = description;
	}
	
	public void enterIsTrue() {
		this.enterData = true;
	}
	
	public void triggerIsTrue() {
		this.triggerEvent = true;
	}
	
	public boolean isEnterData() {
		return enterData;
	}
	
	public boolean isTriggerEvent() {
		return triggerEvent;
	}
}
