package frsl.grammar;

import frsl.grammar.FRSLBaseListener;
import frsl.metamodel.UseCase;

public class FRSLWalker extends FRSLBaseListener {
	public static String test;

	private UseCase metaModel;

	public UseCase getMetaModel() {
		metaModel = new UseCase();
		System.out.println("parse to FRSL model");
		return metaModel;
	}

	@Override
	public void enterMetaModel(FRSLParser.MetaModelContext ctx) {
		test = ctx.useCaseName().use_case_name().getText().strip();
	}

}
