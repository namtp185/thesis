package frsl.metamodel;

import com.google.gson.Gson;

public class FlowStep extends USLNode {
	
	private String name;

	private String description;

	private int maxloop = 1;

	private String type;

	private boolean isValid;

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

}
