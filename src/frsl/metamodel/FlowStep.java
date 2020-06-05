package frsl.metamodel;

import java.util.List;

import com.google.gson.Gson;

import frsl.metamodel.flow_step.Action;

public class FlowStep extends USLNode {

	private String name;

	private String description;

	private int maxloop = 1;

	private String type;

	private boolean isValid;

	private String actionDescription;

	private List<Action> actions;

	public String toString() {
		return new Gson().toJson(this);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getMaxloop() {
		return maxloop;
	}

	public void setMaxloop(int maxloop) {
		this.maxloop = maxloop;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	public List<Action> getActions() {
		return actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

	public String getActionDescription() {
		return actionDescription;
	}

	public void setActionDescription(String actionDescription) {
		this.actionDescription = actionDescription;
	}

}
