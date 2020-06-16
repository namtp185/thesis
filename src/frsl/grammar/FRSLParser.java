// Generated from FRSL.g4 by ANTLR 4.8
package frsl.grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FRSLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, NEWLINE=14, STATEMENT=15, PHRASE=16, 
		LETTER=17, NUMBER=18, WS=19;
	public static final int
		RULE_metaModel = 0, RULE_useCaseName = 1, RULE_useCaseDescription = 2, 
		RULE_actors = 3, RULE_precondition = 4, RULE_postcondition = 5, RULE_trigger = 6, 
		RULE_specialRequirement = 7, RULE_flows = 8, RULE_use_case_name = 9, RULE_use_case_description = 10, 
		RULE_actor_names = 11, RULE_actor_name = 12, RULE_pre_condition = 13, 
		RULE_post_condition = 14, RULE_trigger_info = 15, RULE_special_requirement = 16, 
		RULE_basicFlow = 17, RULE_alternativeFlows = 18, RULE_basicStep = 19, 
		RULE_alternativeFlow = 20, RULE_step = 21, RULE_aFlow = 22;
	private static String[] makeRuleNames() {
		return new String[] {
			"metaModel", "useCaseName", "useCaseDescription", "actors", "precondition", 
			"postcondition", "trigger", "specialRequirement", "flows", "use_case_name", 
			"use_case_description", "actor_names", "actor_name", "pre_condition", 
			"post_condition", "trigger_info", "special_requirement", "basicFlow", 
			"alternativeFlows", "basicStep", "alternativeFlow", "step", "aFlow"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'UseCase :'", "'BriefDescription :'", "'Actors :'", "'Precondition :'", 
			"'Postcondition :'", "'Trigger :'", "'SpecialRequirement :'", "','", 
			"'BasicFlow :'", "'AlternativeFlows :'", "':'", "'Step '", "'Flow '"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "NEWLINE", "STATEMENT", "PHRASE", "LETTER", "NUMBER", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "FRSL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public FRSLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class MetaModelContext extends ParserRuleContext {
		public UseCaseNameContext useCaseName() {
			return getRuleContext(UseCaseNameContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(FRSLParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(FRSLParser.NEWLINE, i);
		}
		public ActorsContext actors() {
			return getRuleContext(ActorsContext.class,0);
		}
		public FlowsContext flows() {
			return getRuleContext(FlowsContext.class,0);
		}
		public UseCaseDescriptionContext useCaseDescription() {
			return getRuleContext(UseCaseDescriptionContext.class,0);
		}
		public PreconditionContext precondition() {
			return getRuleContext(PreconditionContext.class,0);
		}
		public PostconditionContext postcondition() {
			return getRuleContext(PostconditionContext.class,0);
		}
		public TriggerContext trigger() {
			return getRuleContext(TriggerContext.class,0);
		}
		public SpecialRequirementContext specialRequirement() {
			return getRuleContext(SpecialRequirementContext.class,0);
		}
		public MetaModelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_metaModel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRSLListener ) ((FRSLListener)listener).enterMetaModel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRSLListener ) ((FRSLListener)listener).exitMetaModel(this);
		}
	}

	public final MetaModelContext metaModel() throws RecognitionException {
		MetaModelContext _localctx = new MetaModelContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_metaModel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			useCaseName();
			setState(49);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(47);
				match(NEWLINE);
				setState(48);
				useCaseDescription();
				}
				break;
			}
			setState(51);
			match(NEWLINE);
			setState(52);
			actors();
			setState(55);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(53);
				match(NEWLINE);
				setState(54);
				precondition();
				}
				break;
			}
			setState(59);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(57);
				match(NEWLINE);
				setState(58);
				postcondition();
				}
				break;
			}
			setState(63);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(61);
				match(NEWLINE);
				setState(62);
				trigger();
				}
				break;
			}
			setState(67);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(65);
				match(NEWLINE);
				setState(66);
				specialRequirement();
				}
				break;
			}
			setState(69);
			match(NEWLINE);
			setState(70);
			flows();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UseCaseNameContext extends ParserRuleContext {
		public Use_case_nameContext use_case_name() {
			return getRuleContext(Use_case_nameContext.class,0);
		}
		public UseCaseNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_useCaseName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRSLListener ) ((FRSLListener)listener).enterUseCaseName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRSLListener ) ((FRSLListener)listener).exitUseCaseName(this);
		}
	}

	public final UseCaseNameContext useCaseName() throws RecognitionException {
		UseCaseNameContext _localctx = new UseCaseNameContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_useCaseName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			match(T__0);
			setState(73);
			use_case_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UseCaseDescriptionContext extends ParserRuleContext {
		public Use_case_descriptionContext use_case_description() {
			return getRuleContext(Use_case_descriptionContext.class,0);
		}
		public UseCaseDescriptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_useCaseDescription; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRSLListener ) ((FRSLListener)listener).enterUseCaseDescription(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRSLListener ) ((FRSLListener)listener).exitUseCaseDescription(this);
		}
	}

	public final UseCaseDescriptionContext useCaseDescription() throws RecognitionException {
		UseCaseDescriptionContext _localctx = new UseCaseDescriptionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_useCaseDescription);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			match(T__1);
			setState(76);
			use_case_description();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ActorsContext extends ParserRuleContext {
		public Actor_namesContext actor_names() {
			return getRuleContext(Actor_namesContext.class,0);
		}
		public ActorsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actors; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRSLListener ) ((FRSLListener)listener).enterActors(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRSLListener ) ((FRSLListener)listener).exitActors(this);
		}
	}

	public final ActorsContext actors() throws RecognitionException {
		ActorsContext _localctx = new ActorsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_actors);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(T__2);
			setState(79);
			actor_names();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PreconditionContext extends ParserRuleContext {
		public Pre_conditionContext pre_condition() {
			return getRuleContext(Pre_conditionContext.class,0);
		}
		public PreconditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_precondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRSLListener ) ((FRSLListener)listener).enterPrecondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRSLListener ) ((FRSLListener)listener).exitPrecondition(this);
		}
	}

	public final PreconditionContext precondition() throws RecognitionException {
		PreconditionContext _localctx = new PreconditionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_precondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(T__3);
			setState(82);
			pre_condition();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PostconditionContext extends ParserRuleContext {
		public Post_conditionContext post_condition() {
			return getRuleContext(Post_conditionContext.class,0);
		}
		public PostconditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postcondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRSLListener ) ((FRSLListener)listener).enterPostcondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRSLListener ) ((FRSLListener)listener).exitPostcondition(this);
		}
	}

	public final PostconditionContext postcondition() throws RecognitionException {
		PostconditionContext _localctx = new PostconditionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_postcondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(T__4);
			setState(85);
			post_condition();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TriggerContext extends ParserRuleContext {
		public Trigger_infoContext trigger_info() {
			return getRuleContext(Trigger_infoContext.class,0);
		}
		public TriggerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trigger; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRSLListener ) ((FRSLListener)listener).enterTrigger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRSLListener ) ((FRSLListener)listener).exitTrigger(this);
		}
	}

	public final TriggerContext trigger() throws RecognitionException {
		TriggerContext _localctx = new TriggerContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_trigger);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(T__5);
			setState(88);
			trigger_info();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SpecialRequirementContext extends ParserRuleContext {
		public Special_requirementContext special_requirement() {
			return getRuleContext(Special_requirementContext.class,0);
		}
		public SpecialRequirementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_specialRequirement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRSLListener ) ((FRSLListener)listener).enterSpecialRequirement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRSLListener ) ((FRSLListener)listener).exitSpecialRequirement(this);
		}
	}

	public final SpecialRequirementContext specialRequirement() throws RecognitionException {
		SpecialRequirementContext _localctx = new SpecialRequirementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_specialRequirement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			match(T__6);
			setState(91);
			special_requirement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FlowsContext extends ParserRuleContext {
		public BasicFlowContext basicFlow() {
			return getRuleContext(BasicFlowContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(FRSLParser.NEWLINE, 0); }
		public AlternativeFlowsContext alternativeFlows() {
			return getRuleContext(AlternativeFlowsContext.class,0);
		}
		public FlowsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_flows; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRSLListener ) ((FRSLListener)listener).enterFlows(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRSLListener ) ((FRSLListener)listener).exitFlows(this);
		}
	}

	public final FlowsContext flows() throws RecognitionException {
		FlowsContext _localctx = new FlowsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_flows);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			basicFlow();
			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEWLINE) {
				{
				setState(94);
				match(NEWLINE);
				setState(95);
				alternativeFlows();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Use_case_nameContext extends ParserRuleContext {
		public TerminalNode PHRASE() { return getToken(FRSLParser.PHRASE, 0); }
		public Use_case_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_use_case_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRSLListener ) ((FRSLListener)listener).enterUse_case_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRSLListener ) ((FRSLListener)listener).exitUse_case_name(this);
		}
	}

	public final Use_case_nameContext use_case_name() throws RecognitionException {
		Use_case_nameContext _localctx = new Use_case_nameContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_use_case_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			match(PHRASE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Use_case_descriptionContext extends ParserRuleContext {
		public TerminalNode STATEMENT() { return getToken(FRSLParser.STATEMENT, 0); }
		public Use_case_descriptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_use_case_description; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRSLListener ) ((FRSLListener)listener).enterUse_case_description(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRSLListener ) ((FRSLListener)listener).exitUse_case_description(this);
		}
	}

	public final Use_case_descriptionContext use_case_description() throws RecognitionException {
		Use_case_descriptionContext _localctx = new Use_case_descriptionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_use_case_description);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(STATEMENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Actor_namesContext extends ParserRuleContext {
		public List<Actor_nameContext> actor_name() {
			return getRuleContexts(Actor_nameContext.class);
		}
		public Actor_nameContext actor_name(int i) {
			return getRuleContext(Actor_nameContext.class,i);
		}
		public Actor_namesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actor_names; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRSLListener ) ((FRSLListener)listener).enterActor_names(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRSLListener ) ((FRSLListener)listener).exitActor_names(this);
		}
	}

	public final Actor_namesContext actor_names() throws RecognitionException {
		Actor_namesContext _localctx = new Actor_namesContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_actor_names);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(104);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__7:
					{
					setState(102);
					match(T__7);
					}
					break;
				case PHRASE:
					{
					setState(103);
					actor_name();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(106); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__7 || _la==PHRASE );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Actor_nameContext extends ParserRuleContext {
		public TerminalNode PHRASE() { return getToken(FRSLParser.PHRASE, 0); }
		public Actor_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actor_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRSLListener ) ((FRSLListener)listener).enterActor_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRSLListener ) ((FRSLListener)listener).exitActor_name(this);
		}
	}

	public final Actor_nameContext actor_name() throws RecognitionException {
		Actor_nameContext _localctx = new Actor_nameContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_actor_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(PHRASE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Pre_conditionContext extends ParserRuleContext {
		public TerminalNode STATEMENT() { return getToken(FRSLParser.STATEMENT, 0); }
		public Pre_conditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pre_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRSLListener ) ((FRSLListener)listener).enterPre_condition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRSLListener ) ((FRSLListener)listener).exitPre_condition(this);
		}
	}

	public final Pre_conditionContext pre_condition() throws RecognitionException {
		Pre_conditionContext _localctx = new Pre_conditionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_pre_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			match(STATEMENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Post_conditionContext extends ParserRuleContext {
		public TerminalNode STATEMENT() { return getToken(FRSLParser.STATEMENT, 0); }
		public Post_conditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_post_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRSLListener ) ((FRSLListener)listener).enterPost_condition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRSLListener ) ((FRSLListener)listener).exitPost_condition(this);
		}
	}

	public final Post_conditionContext post_condition() throws RecognitionException {
		Post_conditionContext _localctx = new Post_conditionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_post_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			match(STATEMENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Trigger_infoContext extends ParserRuleContext {
		public TerminalNode STATEMENT() { return getToken(FRSLParser.STATEMENT, 0); }
		public Trigger_infoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trigger_info; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRSLListener ) ((FRSLListener)listener).enterTrigger_info(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRSLListener ) ((FRSLListener)listener).exitTrigger_info(this);
		}
	}

	public final Trigger_infoContext trigger_info() throws RecognitionException {
		Trigger_infoContext _localctx = new Trigger_infoContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_trigger_info);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			match(STATEMENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Special_requirementContext extends ParserRuleContext {
		public TerminalNode STATEMENT() { return getToken(FRSLParser.STATEMENT, 0); }
		public Special_requirementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_special_requirement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRSLListener ) ((FRSLListener)listener).enterSpecial_requirement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRSLListener ) ((FRSLListener)listener).exitSpecial_requirement(this);
		}
	}

	public final Special_requirementContext special_requirement() throws RecognitionException {
		Special_requirementContext _localctx = new Special_requirementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_special_requirement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(STATEMENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BasicFlowContext extends ParserRuleContext {
		public List<TerminalNode> NEWLINE() { return getTokens(FRSLParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(FRSLParser.NEWLINE, i);
		}
		public List<BasicStepContext> basicStep() {
			return getRuleContexts(BasicStepContext.class);
		}
		public BasicStepContext basicStep(int i) {
			return getRuleContext(BasicStepContext.class,i);
		}
		public BasicFlowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basicFlow; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRSLListener ) ((FRSLListener)listener).enterBasicFlow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRSLListener ) ((FRSLListener)listener).exitBasicFlow(this);
		}
	}

	public final BasicFlowContext basicFlow() throws RecognitionException {
		BasicFlowContext _localctx = new BasicFlowContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_basicFlow);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			match(T__8);
			setState(119);
			match(NEWLINE);
			setState(122); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(122);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__11:
						{
						setState(120);
						basicStep();
						}
						break;
					case NEWLINE:
						{
						setState(121);
						match(NEWLINE);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(124); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AlternativeFlowsContext extends ParserRuleContext {
		public List<TerminalNode> NEWLINE() { return getTokens(FRSLParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(FRSLParser.NEWLINE, i);
		}
		public List<AlternativeFlowContext> alternativeFlow() {
			return getRuleContexts(AlternativeFlowContext.class);
		}
		public AlternativeFlowContext alternativeFlow(int i) {
			return getRuleContext(AlternativeFlowContext.class,i);
		}
		public AlternativeFlowsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alternativeFlows; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRSLListener ) ((FRSLListener)listener).enterAlternativeFlows(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRSLListener ) ((FRSLListener)listener).exitAlternativeFlows(this);
		}
	}

	public final AlternativeFlowsContext alternativeFlows() throws RecognitionException {
		AlternativeFlowsContext _localctx = new AlternativeFlowsContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_alternativeFlows);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(T__9);
			setState(127);
			match(NEWLINE);
			setState(130); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(130);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__12:
					{
					setState(128);
					alternativeFlow();
					}
					break;
				case NEWLINE:
					{
					setState(129);
					match(NEWLINE);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(132); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__12 || _la==NEWLINE );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BasicStepContext extends ParserRuleContext {
		public StepContext step() {
			return getRuleContext(StepContext.class,0);
		}
		public TerminalNode STATEMENT() { return getToken(FRSLParser.STATEMENT, 0); }
		public BasicStepContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basicStep; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRSLListener ) ((FRSLListener)listener).enterBasicStep(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRSLListener ) ((FRSLListener)listener).exitBasicStep(this);
		}
	}

	public final BasicStepContext basicStep() throws RecognitionException {
		BasicStepContext _localctx = new BasicStepContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_basicStep);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			step();
			setState(135);
			match(T__10);
			setState(136);
			match(STATEMENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AlternativeFlowContext extends ParserRuleContext {
		public AFlowContext aFlow() {
			return getRuleContext(AFlowContext.class,0);
		}
		public TerminalNode PHRASE() { return getToken(FRSLParser.PHRASE, 0); }
		public List<BasicStepContext> basicStep() {
			return getRuleContexts(BasicStepContext.class);
		}
		public BasicStepContext basicStep(int i) {
			return getRuleContext(BasicStepContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(FRSLParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(FRSLParser.NEWLINE, i);
		}
		public AlternativeFlowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alternativeFlow; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRSLListener ) ((FRSLListener)listener).enterAlternativeFlow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRSLListener ) ((FRSLListener)listener).exitAlternativeFlow(this);
		}
	}

	public final AlternativeFlowContext alternativeFlow() throws RecognitionException {
		AlternativeFlowContext _localctx = new AlternativeFlowContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_alternativeFlow);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			aFlow();
			setState(139);
			match(T__10);
			setState(140);
			match(PHRASE);
			setState(143); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(143);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__11:
						{
						setState(141);
						basicStep();
						}
						break;
					case NEWLINE:
						{
						setState(142);
						match(NEWLINE);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(145); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StepContext extends ParserRuleContext {
		public TerminalNode LETTER() { return getToken(FRSLParser.LETTER, 0); }
		public StepContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_step; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRSLListener ) ((FRSLListener)listener).enterStep(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRSLListener ) ((FRSLListener)listener).exitStep(this);
		}
	}

	public final StepContext step() throws RecognitionException {
		StepContext _localctx = new StepContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_step);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			match(T__11);
			setState(148);
			match(LETTER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AFlowContext extends ParserRuleContext {
		public TerminalNode LETTER() { return getToken(FRSLParser.LETTER, 0); }
		public AFlowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aFlow; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRSLListener ) ((FRSLListener)listener).enterAFlow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRSLListener ) ((FRSLListener)listener).exitAFlow(this);
		}
	}

	public final AFlowContext aFlow() throws RecognitionException {
		AFlowContext _localctx = new AFlowContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_aFlow);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			match(T__12);
			setState(151);
			match(LETTER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\25\u009c\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2\3\2\3"+
		"\2\5\2\64\n\2\3\2\3\2\3\2\3\2\5\2:\n\2\3\2\3\2\5\2>\n\2\3\2\3\2\5\2B\n"+
		"\2\3\2\3\2\5\2F\n\2\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3"+
		"\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\5\nc\n\n\3"+
		"\13\3\13\3\f\3\f\3\r\3\r\6\rk\n\r\r\r\16\rl\3\16\3\16\3\17\3\17\3\20\3"+
		"\20\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\23\6\23}\n\23\r\23\16\23~\3\24"+
		"\3\24\3\24\3\24\6\24\u0085\n\24\r\24\16\24\u0086\3\25\3\25\3\25\3\25\3"+
		"\26\3\26\3\26\3\26\3\26\6\26\u0092\n\26\r\26\16\26\u0093\3\27\3\27\3\27"+
		"\3\30\3\30\3\30\3\30\2\2\31\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \""+
		"$&(*,.\2\2\2\u0092\2\60\3\2\2\2\4J\3\2\2\2\6M\3\2\2\2\bP\3\2\2\2\nS\3"+
		"\2\2\2\fV\3\2\2\2\16Y\3\2\2\2\20\\\3\2\2\2\22_\3\2\2\2\24d\3\2\2\2\26"+
		"f\3\2\2\2\30j\3\2\2\2\32n\3\2\2\2\34p\3\2\2\2\36r\3\2\2\2 t\3\2\2\2\""+
		"v\3\2\2\2$x\3\2\2\2&\u0080\3\2\2\2(\u0088\3\2\2\2*\u008c\3\2\2\2,\u0095"+
		"\3\2\2\2.\u0098\3\2\2\2\60\63\5\4\3\2\61\62\7\20\2\2\62\64\5\6\4\2\63"+
		"\61\3\2\2\2\63\64\3\2\2\2\64\65\3\2\2\2\65\66\7\20\2\2\669\5\b\5\2\67"+
		"8\7\20\2\28:\5\n\6\29\67\3\2\2\29:\3\2\2\2:=\3\2\2\2;<\7\20\2\2<>\5\f"+
		"\7\2=;\3\2\2\2=>\3\2\2\2>A\3\2\2\2?@\7\20\2\2@B\5\16\b\2A?\3\2\2\2AB\3"+
		"\2\2\2BE\3\2\2\2CD\7\20\2\2DF\5\20\t\2EC\3\2\2\2EF\3\2\2\2FG\3\2\2\2G"+
		"H\7\20\2\2HI\5\22\n\2I\3\3\2\2\2JK\7\3\2\2KL\5\24\13\2L\5\3\2\2\2MN\7"+
		"\4\2\2NO\5\26\f\2O\7\3\2\2\2PQ\7\5\2\2QR\5\30\r\2R\t\3\2\2\2ST\7\6\2\2"+
		"TU\5\34\17\2U\13\3\2\2\2VW\7\7\2\2WX\5\36\20\2X\r\3\2\2\2YZ\7\b\2\2Z["+
		"\5 \21\2[\17\3\2\2\2\\]\7\t\2\2]^\5\"\22\2^\21\3\2\2\2_b\5$\23\2`a\7\20"+
		"\2\2ac\5&\24\2b`\3\2\2\2bc\3\2\2\2c\23\3\2\2\2de\7\22\2\2e\25\3\2\2\2"+
		"fg\7\21\2\2g\27\3\2\2\2hk\7\n\2\2ik\5\32\16\2jh\3\2\2\2ji\3\2\2\2kl\3"+
		"\2\2\2lj\3\2\2\2lm\3\2\2\2m\31\3\2\2\2no\7\22\2\2o\33\3\2\2\2pq\7\21\2"+
		"\2q\35\3\2\2\2rs\7\21\2\2s\37\3\2\2\2tu\7\21\2\2u!\3\2\2\2vw\7\21\2\2"+
		"w#\3\2\2\2xy\7\13\2\2y|\7\20\2\2z}\5(\25\2{}\7\20\2\2|z\3\2\2\2|{\3\2"+
		"\2\2}~\3\2\2\2~|\3\2\2\2~\177\3\2\2\2\177%\3\2\2\2\u0080\u0081\7\f\2\2"+
		"\u0081\u0084\7\20\2\2\u0082\u0085\5*\26\2\u0083\u0085\7\20\2\2\u0084\u0082"+
		"\3\2\2\2\u0084\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0084\3\2\2\2\u0086"+
		"\u0087\3\2\2\2\u0087\'\3\2\2\2\u0088\u0089\5,\27\2\u0089\u008a\7\r\2\2"+
		"\u008a\u008b\7\21\2\2\u008b)\3\2\2\2\u008c\u008d\5.\30\2\u008d\u008e\7"+
		"\r\2\2\u008e\u0091\7\22\2\2\u008f\u0092\5(\25\2\u0090\u0092\7\20\2\2\u0091"+
		"\u008f\3\2\2\2\u0091\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0091\3\2"+
		"\2\2\u0093\u0094\3\2\2\2\u0094+\3\2\2\2\u0095\u0096\7\16\2\2\u0096\u0097"+
		"\7\23\2\2\u0097-\3\2\2\2\u0098\u0099\7\17\2\2\u0099\u009a\7\23\2\2\u009a"+
		"/\3\2\2\2\20\639=AEbjl|~\u0084\u0086\u0091\u0093";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}