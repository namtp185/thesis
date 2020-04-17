package frsl.metamodel.flow_step;

import com.google.gson.Gson;

public class ActorRequest extends ActorAction{
	
	public String toString() {
		return new Gson().toJson(this);
	}
	
}
