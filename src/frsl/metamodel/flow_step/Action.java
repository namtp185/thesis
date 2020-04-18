package frsl.metamodel.flow_step;

import com.google.gson.Gson;

public class Action {
	
	private Contraint preAction;
	
	private Contraint postAction;
	
	public String toString() {
		return new Gson().toJson(this);
	}

	public Contraint getPreAction() {
		return preAction;
	}

	public void setPreAction(Contraint preAction) {
		this.preAction = preAction;
	}

	public Contraint getPostAction() {
		return postAction;
	}

	public void setPostAction(Contraint postAction) {
		this.postAction = postAction;
	}
	
}
