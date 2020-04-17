package frsl.metamodel.flow_step;

import com.google.gson.Gson;

public class Parameter {
	
	public String toString() {
		return new Gson().toJson(this);
	}
	
}
