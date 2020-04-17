package frsl.metamodel.flow_step;

import com.google.gson.Gson;

public class SystemExtend extends SystemAction {
	
	public String toString() {
		return new Gson().toJson(this);
	}
	
}
