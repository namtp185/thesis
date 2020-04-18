package frsl.metamodel.control_node;

import com.google.gson.Gson;

import frsl.metamodel.ControlNode;
import frsl.metamodel.flow_step.Contraint;

public class InitalNode extends ControlNode {

	private Contraint preUC;

	public String toString() {
		return new Gson().toJson(this);
	}

	public Contraint getPreUC() {
		return preUC;
	}

	public void setPreUC(Contraint preUC) {
		this.preUC = preUC;
	}

}
