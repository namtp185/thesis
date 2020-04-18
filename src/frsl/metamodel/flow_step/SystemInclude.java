package frsl.metamodel.flow_step;

import com.google.gson.Gson;

public class SystemInclude extends SystemAction {

	private String useCaseName;

	public String toString() {
		return new Gson().toJson(this);
	}

	public String getUseCaseName() {
		return useCaseName;
	}

	public void setUseCaseName(String useCaseName) {
		this.useCaseName = useCaseName;
	}

}
