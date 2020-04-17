package frsl.metamodel;

import com.google.gson.Gson;

public class AlternateFlowEdge extends FlowEdge {

	private String label;

	public String toString() {
		return new Gson().toJson(this);
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
