package frsl.metamodel.flow_step;

import com.google.gson.Gson;

import frsl.metamodel.FlowStep;

public class ActorStep extends FlowStep {
	
	public String toString() {
		return new Gson().toJson(this);
	}
	
}
