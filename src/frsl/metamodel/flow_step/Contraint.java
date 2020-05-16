package frsl.metamodel.flow_step;

import com.google.gson.Gson;

public class Contraint {

	private String name;
	
	public Contraint() {
	}
	
	public Contraint(String name) {
		this.name = name;
	}

	public String toString() {
		return new Gson().toJson(this);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
