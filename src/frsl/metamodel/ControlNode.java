package frsl.metamodel;

import com.google.gson.Gson;

public class ControlNode extends USLNode {

	String description;

	public String toString() {
		return new Gson().toJson(this);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
