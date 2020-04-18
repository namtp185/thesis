package frsl.metamodel.flow_step;

import com.google.gson.Gson;

public class SystemDisplay extends SystemAction {
	
	private String displayName;
	
	private String senderName;
	
	public String toString() {
		return new Gson().toJson(this);
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	
	
}
