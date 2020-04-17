package frsl.metamodel;

import com.google.gson.Gson;

public class FlowEdge {
	
	private USLNode source;
	
	private USLNode target;
	
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
	
}
