package frsl.metamodel.flow_step;

import com.google.gson.Gson;

public class SystemRequest extends SystemAction {

	private String objectRequest;

	public String toString() {
		return new Gson().toJson(this);
	}

	public String getObjectRequest() {
		return objectRequest;
	}

	public void setObjectRequest(String objectRequest) {
		this.objectRequest = objectRequest;
	}

}
