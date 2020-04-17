package frsl.metamodel;

import java.util.List;

import com.google.gson.Gson;

public class DescriptionInfo {

	private String useCaseName;

	private String description;

	private List<String> actors;

	private String scope;

	private String levelAbstract;

	private String trigger;

	private String preCondition;

	private String postCondition;

	private String specialRequirement;

	public String toString() {
		return new Gson().toJson(this);
	}

	public String getUseCaseName() {
		return useCaseName;
	}

	public void setUseCaseName(String useCaseName) {
		this.useCaseName = useCaseName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getActors() {
		return actors;
	}

	public void setActors(List<String> actors) {
		this.actors = actors;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getLevelAbstract() {
		return levelAbstract;
	}

	public void setLevelAbstract(String levelAbstract) {
		this.levelAbstract = levelAbstract;
	}

	public String getTrigger() {
		return trigger;
	}

	public void setTrigger(String trigger) {
		this.trigger = trigger;
	}

	public String getPreCondition() {
		return preCondition;
	}

	public void setPreCondition(String preCondition) {
		this.preCondition = preCondition;
	}

	public String getPostCondition() {
		return postCondition;
	}

	public void setPostCondition(String postCondition) {
		this.postCondition = postCondition;
	}

	public String getSpecialRequirement() {
		return specialRequirement;
	}

	public void setSpecialRequirement(String specialRequirement) {
		this.specialRequirement = specialRequirement;
	}

}
