package frsl.metamodel;

import com.google.gson.Gson;

public class USLNode {
	
	private String id;

	public String toString() {
		return new Gson().toJson(this);
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
