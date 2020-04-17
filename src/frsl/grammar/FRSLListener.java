// Generated from FRSL.g4 by ANTLR 4.8
package frsl.grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FRSLParser}.
 */
public interface FRSLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link FRSLParser#metaModel}.
	 * @param ctx the parse tree
	 */
	void enterMetaModel(FRSLParser.MetaModelContext ctx);
	/**
	 * Exit a parse tree produced by {@link FRSLParser#metaModel}.
	 * @param ctx the parse tree
	 */
	void exitMetaModel(FRSLParser.MetaModelContext ctx);
	/**
	 * Enter a parse tree produced by {@link FRSLParser#useCaseName}.
	 * @param ctx the parse tree
	 */
	void enterUseCaseName(FRSLParser.UseCaseNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link FRSLParser#useCaseName}.
	 * @param ctx the parse tree
	 */
	void exitUseCaseName(FRSLParser.UseCaseNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link FRSLParser#useCaseDescription}.
	 * @param ctx the parse tree
	 */
	void enterUseCaseDescription(FRSLParser.UseCaseDescriptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FRSLParser#useCaseDescription}.
	 * @param ctx the parse tree
	 */
	void exitUseCaseDescription(FRSLParser.UseCaseDescriptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FRSLParser#actors}.
	 * @param ctx the parse tree
	 */
	void enterActors(FRSLParser.ActorsContext ctx);
	/**
	 * Exit a parse tree produced by {@link FRSLParser#actors}.
	 * @param ctx the parse tree
	 */
	void exitActors(FRSLParser.ActorsContext ctx);
	/**
	 * Enter a parse tree produced by {@link FRSLParser#precondition}.
	 * @param ctx the parse tree
	 */
	void enterPrecondition(FRSLParser.PreconditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FRSLParser#precondition}.
	 * @param ctx the parse tree
	 */
	void exitPrecondition(FRSLParser.PreconditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FRSLParser#postcondition}.
	 * @param ctx the parse tree
	 */
	void enterPostcondition(FRSLParser.PostconditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FRSLParser#postcondition}.
	 * @param ctx the parse tree
	 */
	void exitPostcondition(FRSLParser.PostconditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FRSLParser#trigger}.
	 * @param ctx the parse tree
	 */
	void enterTrigger(FRSLParser.TriggerContext ctx);
	/**
	 * Exit a parse tree produced by {@link FRSLParser#trigger}.
	 * @param ctx the parse tree
	 */
	void exitTrigger(FRSLParser.TriggerContext ctx);
	/**
	 * Enter a parse tree produced by {@link FRSLParser#specialRequirement}.
	 * @param ctx the parse tree
	 */
	void enterSpecialRequirement(FRSLParser.SpecialRequirementContext ctx);
	/**
	 * Exit a parse tree produced by {@link FRSLParser#specialRequirement}.
	 * @param ctx the parse tree
	 */
	void exitSpecialRequirement(FRSLParser.SpecialRequirementContext ctx);
	/**
	 * Enter a parse tree produced by {@link FRSLParser#flows}.
	 * @param ctx the parse tree
	 */
	void enterFlows(FRSLParser.FlowsContext ctx);
	/**
	 * Exit a parse tree produced by {@link FRSLParser#flows}.
	 * @param ctx the parse tree
	 */
	void exitFlows(FRSLParser.FlowsContext ctx);
	/**
	 * Enter a parse tree produced by {@link FRSLParser#use_case_name}.
	 * @param ctx the parse tree
	 */
	void enterUse_case_name(FRSLParser.Use_case_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link FRSLParser#use_case_name}.
	 * @param ctx the parse tree
	 */
	void exitUse_case_name(FRSLParser.Use_case_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link FRSLParser#use_case_description}.
	 * @param ctx the parse tree
	 */
	void enterUse_case_description(FRSLParser.Use_case_descriptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FRSLParser#use_case_description}.
	 * @param ctx the parse tree
	 */
	void exitUse_case_description(FRSLParser.Use_case_descriptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FRSLParser#actor_names}.
	 * @param ctx the parse tree
	 */
	void enterActor_names(FRSLParser.Actor_namesContext ctx);
	/**
	 * Exit a parse tree produced by {@link FRSLParser#actor_names}.
	 * @param ctx the parse tree
	 */
	void exitActor_names(FRSLParser.Actor_namesContext ctx);
	/**
	 * Enter a parse tree produced by {@link FRSLParser#actor_name}.
	 * @param ctx the parse tree
	 */
	void enterActor_name(FRSLParser.Actor_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link FRSLParser#actor_name}.
	 * @param ctx the parse tree
	 */
	void exitActor_name(FRSLParser.Actor_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link FRSLParser#pre_condition}.
	 * @param ctx the parse tree
	 */
	void enterPre_condition(FRSLParser.Pre_conditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FRSLParser#pre_condition}.
	 * @param ctx the parse tree
	 */
	void exitPre_condition(FRSLParser.Pre_conditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FRSLParser#post_condition}.
	 * @param ctx the parse tree
	 */
	void enterPost_condition(FRSLParser.Post_conditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FRSLParser#post_condition}.
	 * @param ctx the parse tree
	 */
	void exitPost_condition(FRSLParser.Post_conditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FRSLParser#trigger_info}.
	 * @param ctx the parse tree
	 */
	void enterTrigger_info(FRSLParser.Trigger_infoContext ctx);
	/**
	 * Exit a parse tree produced by {@link FRSLParser#trigger_info}.
	 * @param ctx the parse tree
	 */
	void exitTrigger_info(FRSLParser.Trigger_infoContext ctx);
	/**
	 * Enter a parse tree produced by {@link FRSLParser#special_requirement}.
	 * @param ctx the parse tree
	 */
	void enterSpecial_requirement(FRSLParser.Special_requirementContext ctx);
	/**
	 * Exit a parse tree produced by {@link FRSLParser#special_requirement}.
	 * @param ctx the parse tree
	 */
	void exitSpecial_requirement(FRSLParser.Special_requirementContext ctx);
	/**
	 * Enter a parse tree produced by {@link FRSLParser#basicFlows}.
	 * @param ctx the parse tree
	 */
	void enterBasicFlows(FRSLParser.BasicFlowsContext ctx);
	/**
	 * Exit a parse tree produced by {@link FRSLParser#basicFlows}.
	 * @param ctx the parse tree
	 */
	void exitBasicFlows(FRSLParser.BasicFlowsContext ctx);
	/**
	 * Enter a parse tree produced by {@link FRSLParser#alternativeFlows}.
	 * @param ctx the parse tree
	 */
	void enterAlternativeFlows(FRSLParser.AlternativeFlowsContext ctx);
	/**
	 * Exit a parse tree produced by {@link FRSLParser#alternativeFlows}.
	 * @param ctx the parse tree
	 */
	void exitAlternativeFlows(FRSLParser.AlternativeFlowsContext ctx);
	/**
	 * Enter a parse tree produced by {@link FRSLParser#basicStep}.
	 * @param ctx the parse tree
	 */
	void enterBasicStep(FRSLParser.BasicStepContext ctx);
	/**
	 * Exit a parse tree produced by {@link FRSLParser#basicStep}.
	 * @param ctx the parse tree
	 */
	void exitBasicStep(FRSLParser.BasicStepContext ctx);
	/**
	 * Enter a parse tree produced by {@link FRSLParser#alternativeFlow}.
	 * @param ctx the parse tree
	 */
	void enterAlternativeFlow(FRSLParser.AlternativeFlowContext ctx);
	/**
	 * Exit a parse tree produced by {@link FRSLParser#alternativeFlow}.
	 * @param ctx the parse tree
	 */
	void exitAlternativeFlow(FRSLParser.AlternativeFlowContext ctx);
	/**
	 * Enter a parse tree produced by {@link FRSLParser#step}.
	 * @param ctx the parse tree
	 */
	void enterStep(FRSLParser.StepContext ctx);
	/**
	 * Exit a parse tree produced by {@link FRSLParser#step}.
	 * @param ctx the parse tree
	 */
	void exitStep(FRSLParser.StepContext ctx);
	/**
	 * Enter a parse tree produced by {@link FRSLParser#aFlow}.
	 * @param ctx the parse tree
	 */
	void enterAFlow(FRSLParser.AFlowContext ctx);
	/**
	 * Exit a parse tree produced by {@link FRSLParser#aFlow}.
	 * @param ctx the parse tree
	 */
	void exitAFlow(FRSLParser.AFlowContext ctx);
}