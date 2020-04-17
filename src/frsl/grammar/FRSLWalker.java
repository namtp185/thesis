package frsl.grammar;

import java.util.ArrayList;

import frsl.metamodel.*;

public class FRSLWalker extends FRSLBaseListener {

	private UseCase metaModel;

	public UseCase getMetaModel() {
		return metaModel;
	}

	public void enterMetaModel(FRSLParser.MetaModelContext ctx) {
		metaModel = new UseCase();
		metaModel.setDescriptionInfo(new DescriptionInfo());
		metaModel.setContraints(new ArrayList<Contraint>());
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

}
