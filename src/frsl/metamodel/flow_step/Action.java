package frsl.metamodel.flow_step;

import java.util.List;

import com.google.gson.Gson;

public class Action {

	private Contraint preAction;

	private Contraint postAction;

	private List<String> parameters;

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

	public List<String> getParameters() {
		return parameters;
	}

	public void setParameters(List<String> parameters) {
		this.parameters = parameters;
	}

}
