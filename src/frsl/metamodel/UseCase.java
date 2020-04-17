package frsl.metamodel;

import java.util.List;

import com.google.gson.Gson;

public class UseCase {

	DescriptionInfo descriptionInfo;

	List<Variable> variables;

	List<FlowEdge> flowEdges;

	List<USLNode> uslNodes;

	List<Contraint> contraints;

	public String toString() {
		return new Gson().toJson(this);
	}

	public DescriptionInfo getDescriptionInfo() {
		return descriptionInfo;
	}

	public void setDescriptionInfo(DescriptionInfo descriptionInfo) {
		this.descriptionInfo = descriptionInfo;
	}

	public List<Variable> getVariables() {
		return variables;
	}

	public void setVariables(List<Variable> variables) {
		this.variables = variables;
	}

	public List<FlowEdge> getFlowEdges() {
		return flowEdges;
	}

	public void setFlowEdges(List<FlowEdge> flowEdges) {
		this.flowEdges = flowEdges;
	}

	public List<USLNode> getUslNodes() {
		return uslNodes;
	}

	public void setUslNodes(List<USLNode> uslNodes) {
		this.uslNodes = uslNodes;
	}

	public List<Contraint> getContraints() {
		return contraints;
	}

	public void setContraints(List<Contraint> contraints) {
		this.contraints = contraints;
	}

}