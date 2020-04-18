package frsl.grammar;

import java.util.ArrayList;

import frsl.metamodel.*;

public class FRSLWalker extends FRSLBaseListener {

	private UseCase metaModel;
	
	private String currentFlowName;

	public UseCase getMetaModel() {
		return metaModel;
	}

	public void enterMetaModel(FRSLParser.MetaModelContext ctx) {
		metaModel = new UseCase();
		metaModel.setDescriptionInfo(new DescriptionInfo());
		metaModel.setVariables(new ArrayList<Variable>());
		metaModel.setFlowEdges(new ArrayList<FlowEdge>());
		metaModel.setUslNodes(new ArrayList<USLNode>());
	}

	public void enterUse_case_name(FRSLParser.Use_case_nameContext ctx) {
		metaModel.getDescriptionInfo().setUseCaseName(ctx.getText().strip());
	}

	public void enterUse_case_description(FRSLParser.Use_case_descriptionContext ctx) {
		metaModel.getDescriptionInfo().setDescription(ctx.getText().strip());
	}

	public void enterActor_names(FRSLParser.Actor_namesContext ctx) {
		metaModel.getDescriptionInfo().setActors(new ArrayList<String>());
	}
	
	public void enterActor_name(FRSLParser.Actor_nameContext ctx) {
		metaModel.getDescriptionInfo().getActors().add(ctx.getText().strip());
	}
	
	public void enterPre_condition(FRSLParser.Pre_conditionContext ctx) {
		metaModel.getDescriptionInfo().setPostCondition(ctx.getText().strip());
	}
	
	public void enterPost_condition(FRSLParser.Post_conditionContext ctx) { 
		metaModel.getDescriptionInfo().setPostCondition(ctx.getText().strip());
	}
	
	public void enterTrigger_info(FRSLParser.Trigger_infoContext ctx) {
		metaModel.getDescriptionInfo().setTrigger(ctx.getText().strip());
	}
	
	public void enterSpecial_requirement(FRSLParser.Special_requirementContext ctx) {
		metaModel.getDescriptionInfo().setSpecialRequirement(ctx.getText().strip());
	}
	
	public void enterBasicFlow(FRSLParser.BasicFlowContext ctx) {
		currentFlowName = "Basic Flow";
	}
	
	public void enterAFlow(FRSLParser.AFlowContext ctx) {
		currentFlowName = ctx.LETTER().getText().strip() ;
	}
	
	public void enterBasicStep(FRSLParser.BasicStepContext ctx) {
		FlowStep flowStep = new FlowStep();
		flowStep.setType(currentFlowName);
		flowStep.setName(ctx.step().LETTER().getText().strip());
		flowStep.setDescription(ctx.STATEMENT().getText().strip());
		metaModel.getUslNodes().add(flowStep);
	}
	
	public void exitMetaModel(FRSLParser.MetaModelContext ctx) {
		// Extracted some basic information from text (write concreteSyntax)  and push to metalmodel (of abtractSystax).
		// Now, we are extracting more information,and push to metalmodel .
	};

}
