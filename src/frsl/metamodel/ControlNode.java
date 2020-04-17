package frsl.metamodel;

import com.google.gson.Gson;

public class ControlNode extends USLNode {
	
	public String toString() {
		return new Gson().toJson(this);
	}
	
}
