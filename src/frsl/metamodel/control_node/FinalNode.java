package frsl.metamodel.control_node;

import com.google.gson.Gson;

import frsl.metamodel.ControlNode;
import frsl.metamodel.flow_step.Contraint;

public class FinalNode extends ControlNode {

	private Contraint postUC;

	public String toString() {
		return new Gson().toJson(this);
	}

	public Contraint getPostUC() {
		return postUC;
	}

	public void setPostUC(Contraint postUC) {
		this.postUC = postUC;
	}
}
