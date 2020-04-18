package frsl.metamodel.flow_step;

import com.google.gson.Gson;

public class SystemState extends SystemAction {
	
	private String conceptName;
	
	public String toString() {
		return new Gson().toJson(this);
	}

	public String getConceptName() {
		return conceptName;
	}

	public void setConceptName(String conceptName) {
		this.conceptName = conceptName;
	}
	
	
}
