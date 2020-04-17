package frsl.metamodel.flow_step;

import com.google.gson.Gson;

public class SystemState extends SystemAction {
	
	public String toString() {
		return new Gson().toJson(this);
	}
	
}
