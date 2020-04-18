package frsl.metamodel;

import com.google.gson.Gson;

import frsl.metamodel.flow_step.Contraint;

public class FlowEdge {

	private USLNode source;

	private USLNode target;

	private Contraint guard;

	public String toString() {
		return new Gson().toJson(this);
	}

	public USLNode getSource() {
		return source;
	}

	public void setSource(USLNode source) {
		this.source = source;
	}

	public USLNode getTarget() {
		return target;
	}

	public void setTarget(USLNode target) {
		this.target = target;
	}

	public Contraint getGuard() {
		return guard;
	}

	public void setGuard(Contraint guard) {
		this.guard = guard;
	}

}
