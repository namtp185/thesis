package frsl.metamodel;

import com.google.gson.Gson;

public class Contraint {
	
	public String toString() {
		return new Gson().toJson(this);
	}
	
}
