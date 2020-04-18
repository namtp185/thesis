package frsl.metamodel.flow_step;

import com.google.gson.Gson;

public class ActorRequest extends ActorAction {

	private String objectName;

	private String displayName;

	public String toString() {
		return new Gson().toJson(this);
	}

	public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

}
