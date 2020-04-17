package frsl.metamodel;

import com.google.gson.Gson;

public class FlowStep extends USLNode {

	private String name;

	private String description;

	private int maxloop = 1;

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

}
