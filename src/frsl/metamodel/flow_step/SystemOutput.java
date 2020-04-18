package frsl.metamodel.flow_step;

import com.google.gson.Gson;

public class SystemOutput extends SystemAction {
	
	private String displayName;
	
	public String toString() {
		return new Gson().toJson(this);
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
}
