package frsl.metamodel.flow_step;

import com.google.gson.Gson;

public class ActorInput extends ActorAction{
	
	public String toString() {
		return new Gson().toJson(this);
	}
	
}
