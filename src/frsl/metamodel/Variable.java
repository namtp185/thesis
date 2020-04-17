package frsl.metamodel;

import com.google.gson.Gson;

public class Variable {
	
	public String toString() {
		return new Gson().toJson(this);
	}
	
}
