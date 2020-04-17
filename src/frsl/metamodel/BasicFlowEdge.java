package frsl.metamodel;

import com.google.gson.Gson;

public class BasicFlowEdge extends FlowEdge {
	
	public String toString() {
		return new Gson().toJson(this);
	}
	
}
