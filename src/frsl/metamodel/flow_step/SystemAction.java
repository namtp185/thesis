package frsl.metamodel.flow_step;

import com.google.gson.Gson;

public class SystemAction extends Action {
	
	public String toString() {
		return new Gson().toJson(this);
	}
	
}
