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
		T__9=10, T__10=11, T__11=12, USECASE=13, DESCRIPTION=14, ACTORS=15, FLOWS=16, 
		NEWLINE=17, STATEMENT=18, PHRASE=19, LETTER=20, NUMBER=21, WS=22;
	public static final int
		RULE_metaModel = 0, RULE_useCaseName = 1, RULE_useCaseDescription = 2, 
		RULE_actors = 3, RULE_precondition = 4, RULE_postcondition = 5, RULE_trigger = 6, 
		RULE_specialRequirement = 7, RULE_flows = 8, RULE_use_case_name = 9, RULE_use_case_description = 10, 
		RULE_actor_names = 11, RULE_actor_name = 12, RULE_pre_condition = 13, 
		RULE_post_condition = 14, RULE_trigger_info = 15, RULE_special_requirement = 16, 
		RULE_basicFlows = 17, RULE_specificAlternativeFlows = 18, RULE_globalAlternativeFlows = 19, 
		RULE_boundedAlternativeFlows = 20, RULE_basicStep = 21, RULE_specificAlternativeFlow = 22, 
		RULE_globalAlternativeFlow = 23, RULE_boundedAlternativeFlow = 24, RULE_step = 25, 
		RULE_aFlow = 26;
	private static String[] makeRuleNames() {
		return new String[] {
			"metaModel", "useCaseName", "useCaseDescription", "actors", "precondition", 
			"postcondition", "trigger", "specialRequirement", "flows", "use_case_name", 
			"use_case_description", "actor_names", "actor_name", "pre_condition", 
			"post_condition", "trigger_info", "special_requirement", "basicFlows", 
			"specificAlternativeFlows", "globalAlternativeFlows", "boundedAlternativeFlows", 
			"basicStep", "specificAlternativeFlow", "globalAlternativeFlow", "boundedAlternativeFlow", 
			"step", "aFlow"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'Precondition:'", "'Postcondition:'", "'Trigger:'", "'Special requirement:'", 
			"','", "'Basic flows:'", "'Specific alternative flows:'", "'Global alternative flows:'", 
			"'Bounded alternative flows:'", "':'", "'Step '", "'Flow '", "'Use case:'", 
			"'Brief description:'", "'Actors:'", "'Flows:'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "USECASE", "DESCRIPTION", "ACTORS", "FLOWS", "NEWLINE", "STATEMENT", 
			"PHRASE", "LETTER", "NUMBER", "WS"
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
			setState(54);
			useCaseName();
			setState(57);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(55);
				match(NEWLINE);
				setState(56);
				useCaseDescription();
				}
				break;
			}
			setState(59);
			match(NEWLINE);
			setState(60);
			actors();
			setState(63);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(61);
				match(NEWLINE);
				setState(62);
				precondition();
				}
				break;
			}
			setState(67);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(65);
				match(NEWLINE);
				setState(66);
				postcondition();
				}
				break;
			}
			setState(71);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(69);
				match(NEWLINE);
				setState(70);
				trigger();
				}
				break;
			}
			setState(75);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(73);
				match(NEWLINE);
				setState(74);
				specialRequirement();
				}
				break;
			}
			setState(77);
			match(NEWLINE);
			setState(78);
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
		public TerminalNode USECASE() { return getToken(FRSLParser.USECASE, 0); }
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
			setState(80);
			match(USECASE);
			setState(81);
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
		public TerminalNode DESCRIPTION() { return getToken(FRSLParser.DESCRIPTION, 0); }
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
			setState(83);
			match(DESCRIPTION);
			setState(84);
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
		public TerminalNode ACTORS() { return getToken(FRSLParser.ACTORS, 0); }
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
			setState(86);
			match(ACTORS);
			setState(87);
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
			setState(89);
			match(T__0);
			setState(90);
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
			setState(92);
			match(T__1);
			setState(93);
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
			setState(95);
			match(T__2);
			setState(96);
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
			setState(98);
			match(T__3);
			setState(99);
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
		public TerminalNode FLOWS() { return getToken(FRSLParser.FLOWS, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(FRSLParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(FRSLParser.NEWLINE, i);
		}
		public BasicFlowsContext basicFlows() {
			return getRuleContext(BasicFlowsContext.class,0);
		}
		public SpecificAlternativeFlowsContext specificAlternativeFlows() {
			return getRuleContext(SpecificAlternativeFlowsContext.class,0);
		}
		public GlobalAlternativeFlowsContext globalAlternativeFlows() {
			return getRuleContext(GlobalAlternativeFlowsContext.class,0);
		}
		public BoundedAlternativeFlowsContext boundedAlternativeFlows() {
			return getRuleContext(BoundedAlternativeFlowsContext.class,0);
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
			setState(101);
			match(FLOWS);
			setState(102);
			match(NEWLINE);
			setState(103);
			basicFlows();
			setState(106);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(104);
				match(NEWLINE);
				setState(105);
				specificAlternativeFlows();
				}
				break;
			}
			setState(110);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(108);
				match(NEWLINE);
				setState(109);
				globalAlternativeFlows();
				}
				break;
			}
			setState(114);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEWLINE) {
				{
				setState(112);
				match(NEWLINE);
				setState(113);
				boundedAlternativeFlows();
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
			setState(116);
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
			setState(118);
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
			setState(122); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(122);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__4:
					{
					setState(120);
					match(T__4);
					}
					break;
				case PHRASE:
					{
					setState(121);
					actor_name();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(124); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__4 || _la==PHRASE );
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
			setState(126);
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
			setState(128);
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
			setState(130);
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
			setState(132);
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
			setState(134);
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

	public static class BasicFlowsContext extends ParserRuleContext {
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
		public BasicFlowsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basicFlows; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRSLListener ) ((FRSLListener)listener).enterBasicFlows(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRSLListener ) ((FRSLListener)listener).exitBasicFlows(this);
		}
	}

	public final BasicFlowsContext basicFlows() throws RecognitionException {
		BasicFlowsContext _localctx = new BasicFlowsContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_basicFlows);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			match(T__5);
			setState(137);
			match(NEWLINE);
			setState(140); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(140);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__10:
						{
						setState(138);
						basicStep();
						}
						break;
					case NEWLINE:
						{
						setState(139);
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
				setState(142); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
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

	public static class SpecificAlternativeFlowsContext extends ParserRuleContext {
		public List<TerminalNode> NEWLINE() { return getTokens(FRSLParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(FRSLParser.NEWLINE, i);
		}
		public List<SpecificAlternativeFlowContext> specificAlternativeFlow() {
			return getRuleContexts(SpecificAlternativeFlowContext.class);
		}
		public SpecificAlternativeFlowContext specificAlternativeFlow(int i) {
			return getRuleContext(SpecificAlternativeFlowContext.class,i);
		}
		public SpecificAlternativeFlowsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_specificAlternativeFlows; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRSLListener ) ((FRSLListener)listener).enterSpecificAlternativeFlows(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRSLListener ) ((FRSLListener)listener).exitSpecificAlternativeFlows(this);
		}
	}

	public final SpecificAlternativeFlowsContext specificAlternativeFlows() throws RecognitionException {
		SpecificAlternativeFlowsContext _localctx = new SpecificAlternativeFlowsContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_specificAlternativeFlows);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			match(T__6);
			setState(145);
			match(NEWLINE);
			setState(148); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(148);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__11:
						{
						setState(146);
						specificAlternativeFlow();
						}
						break;
					case NEWLINE:
						{
						setState(147);
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
				setState(150); 
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

	public static class GlobalAlternativeFlowsContext extends ParserRuleContext {
		public List<TerminalNode> NEWLINE() { return getTokens(FRSLParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(FRSLParser.NEWLINE, i);
		}
		public List<GlobalAlternativeFlowContext> globalAlternativeFlow() {
			return getRuleContexts(GlobalAlternativeFlowContext.class);
		}
		public GlobalAlternativeFlowContext globalAlternativeFlow(int i) {
			return getRuleContext(GlobalAlternativeFlowContext.class,i);
		}
		public GlobalAlternativeFlowsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_globalAlternativeFlows; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRSLListener ) ((FRSLListener)listener).enterGlobalAlternativeFlows(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRSLListener ) ((FRSLListener)listener).exitGlobalAlternativeFlows(this);
		}
	}

	public final GlobalAlternativeFlowsContext globalAlternativeFlows() throws RecognitionException {
		GlobalAlternativeFlowsContext _localctx = new GlobalAlternativeFlowsContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_globalAlternativeFlows);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			match(T__7);
			setState(153);
			match(NEWLINE);
			setState(156); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(156);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__11:
						{
						setState(154);
						globalAlternativeFlow();
						}
						break;
					case NEWLINE:
						{
						setState(155);
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
				setState(158); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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

	public static class BoundedAlternativeFlowsContext extends ParserRuleContext {
		public List<TerminalNode> NEWLINE() { return getTokens(FRSLParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(FRSLParser.NEWLINE, i);
		}
		public List<BoundedAlternativeFlowContext> boundedAlternativeFlow() {
			return getRuleContexts(BoundedAlternativeFlowContext.class);
		}
		public BoundedAlternativeFlowContext boundedAlternativeFlow(int i) {
			return getRuleContext(BoundedAlternativeFlowContext.class,i);
		}
		public BoundedAlternativeFlowsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boundedAlternativeFlows; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRSLListener ) ((FRSLListener)listener).enterBoundedAlternativeFlows(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRSLListener ) ((FRSLListener)listener).exitBoundedAlternativeFlows(this);
		}
	}

	public final BoundedAlternativeFlowsContext boundedAlternativeFlows() throws RecognitionException {
		BoundedAlternativeFlowsContext _localctx = new BoundedAlternativeFlowsContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_boundedAlternativeFlows);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			match(T__8);
			setState(161);
			match(NEWLINE);
			setState(164); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(164);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__11:
					{
					setState(162);
					boundedAlternativeFlow();
					}
					break;
				case NEWLINE:
					{
					setState(163);
					match(NEWLINE);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(166); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__11 || _la==NEWLINE );
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
		enterRule(_localctx, 42, RULE_basicStep);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			step();
			setState(169);
			match(T__9);
			setState(170);
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

	public static class SpecificAlternativeFlowContext extends ParserRuleContext {
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
		public SpecificAlternativeFlowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_specificAlternativeFlow; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRSLListener ) ((FRSLListener)listener).enterSpecificAlternativeFlow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRSLListener ) ((FRSLListener)listener).exitSpecificAlternativeFlow(this);
		}
	}

	public final SpecificAlternativeFlowContext specificAlternativeFlow() throws RecognitionException {
		SpecificAlternativeFlowContext _localctx = new SpecificAlternativeFlowContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_specificAlternativeFlow);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			aFlow();
			setState(173);
			match(T__9);
			setState(174);
			match(PHRASE);
			setState(177); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(177);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__10:
						{
						setState(175);
						basicStep();
						}
						break;
					case NEWLINE:
						{
						setState(176);
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
				setState(179); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
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

	public static class GlobalAlternativeFlowContext extends ParserRuleContext {
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
		public GlobalAlternativeFlowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_globalAlternativeFlow; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRSLListener ) ((FRSLListener)listener).enterGlobalAlternativeFlow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRSLListener ) ((FRSLListener)listener).exitGlobalAlternativeFlow(this);
		}
	}

	public final GlobalAlternativeFlowContext globalAlternativeFlow() throws RecognitionException {
		GlobalAlternativeFlowContext _localctx = new GlobalAlternativeFlowContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_globalAlternativeFlow);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			aFlow();
			setState(182);
			match(T__9);
			setState(183);
			match(PHRASE);
			setState(186); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(186);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__10:
						{
						setState(184);
						basicStep();
						}
						break;
					case NEWLINE:
						{
						setState(185);
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
				setState(188); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
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

	public static class BoundedAlternativeFlowContext extends ParserRuleContext {
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
		public BoundedAlternativeFlowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boundedAlternativeFlow; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FRSLListener ) ((FRSLListener)listener).enterBoundedAlternativeFlow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FRSLListener ) ((FRSLListener)listener).exitBoundedAlternativeFlow(this);
		}
	}

	public final BoundedAlternativeFlowContext boundedAlternativeFlow() throws RecognitionException {
		BoundedAlternativeFlowContext _localctx = new BoundedAlternativeFlowContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_boundedAlternativeFlow);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			aFlow();
			setState(191);
			match(T__9);
			setState(192);
			match(PHRASE);
			setState(195); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(195);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__10:
						{
						setState(193);
						basicStep();
						}
						break;
					case NEWLINE:
						{
						setState(194);
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
				setState(197); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
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
		enterRule(_localctx, 50, RULE_step);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			match(T__10);
			setState(200);
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
		enterRule(_localctx, 52, RULE_aFlow);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			match(T__11);
			setState(203);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\30\u00d0\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\3\2\3\2\3\2\5\2<\n\2\3\2\3\2\3\2\3\2\5"+
		"\2B\n\2\3\2\3\2\5\2F\n\2\3\2\3\2\5\2J\n\2\3\2\3\2\5\2N\n\2\3\2\3\2\3\2"+
		"\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3"+
		"\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\5\nm\n\n\3\n\3\n\5\nq\n\n\3\n\3\n\5"+
		"\nu\n\n\3\13\3\13\3\f\3\f\3\r\3\r\6\r}\n\r\r\r\16\r~\3\16\3\16\3\17\3"+
		"\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\23\6\23\u008f\n\23"+
		"\r\23\16\23\u0090\3\24\3\24\3\24\3\24\6\24\u0097\n\24\r\24\16\24\u0098"+
		"\3\25\3\25\3\25\3\25\6\25\u009f\n\25\r\25\16\25\u00a0\3\26\3\26\3\26\3"+
		"\26\6\26\u00a7\n\26\r\26\16\26\u00a8\3\27\3\27\3\27\3\27\3\30\3\30\3\30"+
		"\3\30\3\30\6\30\u00b4\n\30\r\30\16\30\u00b5\3\31\3\31\3\31\3\31\3\31\6"+
		"\31\u00bd\n\31\r\31\16\31\u00be\3\32\3\32\3\32\3\32\3\32\6\32\u00c6\n"+
		"\32\r\32\16\32\u00c7\3\33\3\33\3\33\3\34\3\34\3\34\3\34\2\2\35\2\4\6\b"+
		"\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\66\2\2\2\u00cc\28\3"+
		"\2\2\2\4R\3\2\2\2\6U\3\2\2\2\bX\3\2\2\2\n[\3\2\2\2\f^\3\2\2\2\16a\3\2"+
		"\2\2\20d\3\2\2\2\22g\3\2\2\2\24v\3\2\2\2\26x\3\2\2\2\30|\3\2\2\2\32\u0080"+
		"\3\2\2\2\34\u0082\3\2\2\2\36\u0084\3\2\2\2 \u0086\3\2\2\2\"\u0088\3\2"+
		"\2\2$\u008a\3\2\2\2&\u0092\3\2\2\2(\u009a\3\2\2\2*\u00a2\3\2\2\2,\u00aa"+
		"\3\2\2\2.\u00ae\3\2\2\2\60\u00b7\3\2\2\2\62\u00c0\3\2\2\2\64\u00c9\3\2"+
		"\2\2\66\u00cc\3\2\2\28;\5\4\3\29:\7\23\2\2:<\5\6\4\2;9\3\2\2\2;<\3\2\2"+
		"\2<=\3\2\2\2=>\7\23\2\2>A\5\b\5\2?@\7\23\2\2@B\5\n\6\2A?\3\2\2\2AB\3\2"+
		"\2\2BE\3\2\2\2CD\7\23\2\2DF\5\f\7\2EC\3\2\2\2EF\3\2\2\2FI\3\2\2\2GH\7"+
		"\23\2\2HJ\5\16\b\2IG\3\2\2\2IJ\3\2\2\2JM\3\2\2\2KL\7\23\2\2LN\5\20\t\2"+
		"MK\3\2\2\2MN\3\2\2\2NO\3\2\2\2OP\7\23\2\2PQ\5\22\n\2Q\3\3\2\2\2RS\7\17"+
		"\2\2ST\5\24\13\2T\5\3\2\2\2UV\7\20\2\2VW\5\26\f\2W\7\3\2\2\2XY\7\21\2"+
		"\2YZ\5\30\r\2Z\t\3\2\2\2[\\\7\3\2\2\\]\5\34\17\2]\13\3\2\2\2^_\7\4\2\2"+
		"_`\5\36\20\2`\r\3\2\2\2ab\7\5\2\2bc\5 \21\2c\17\3\2\2\2de\7\6\2\2ef\5"+
		"\"\22\2f\21\3\2\2\2gh\7\22\2\2hi\7\23\2\2il\5$\23\2jk\7\23\2\2km\5&\24"+
		"\2lj\3\2\2\2lm\3\2\2\2mp\3\2\2\2no\7\23\2\2oq\5(\25\2pn\3\2\2\2pq\3\2"+
		"\2\2qt\3\2\2\2rs\7\23\2\2su\5*\26\2tr\3\2\2\2tu\3\2\2\2u\23\3\2\2\2vw"+
		"\7\25\2\2w\25\3\2\2\2xy\7\24\2\2y\27\3\2\2\2z}\7\7\2\2{}\5\32\16\2|z\3"+
		"\2\2\2|{\3\2\2\2}~\3\2\2\2~|\3\2\2\2~\177\3\2\2\2\177\31\3\2\2\2\u0080"+
		"\u0081\7\25\2\2\u0081\33\3\2\2\2\u0082\u0083\7\24\2\2\u0083\35\3\2\2\2"+
		"\u0084\u0085\7\24\2\2\u0085\37\3\2\2\2\u0086\u0087\7\24\2\2\u0087!\3\2"+
		"\2\2\u0088\u0089\7\24\2\2\u0089#\3\2\2\2\u008a\u008b\7\b\2\2\u008b\u008e"+
		"\7\23\2\2\u008c\u008f\5,\27\2\u008d\u008f\7\23\2\2\u008e\u008c\3\2\2\2"+
		"\u008e\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091"+
		"\3\2\2\2\u0091%\3\2\2\2\u0092\u0093\7\t\2\2\u0093\u0096\7\23\2\2\u0094"+
		"\u0097\5.\30\2\u0095\u0097\7\23\2\2\u0096\u0094\3\2\2\2\u0096\u0095\3"+
		"\2\2\2\u0097\u0098\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099"+
		"\'\3\2\2\2\u009a\u009b\7\n\2\2\u009b\u009e\7\23\2\2\u009c\u009f\5\60\31"+
		"\2\u009d\u009f\7\23\2\2\u009e\u009c\3\2\2\2\u009e\u009d\3\2\2\2\u009f"+
		"\u00a0\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1)\3\2\2\2"+
		"\u00a2\u00a3\7\13\2\2\u00a3\u00a6\7\23\2\2\u00a4\u00a7\5\62\32\2\u00a5"+
		"\u00a7\7\23\2\2\u00a6\u00a4\3\2\2\2\u00a6\u00a5\3\2\2\2\u00a7\u00a8\3"+
		"\2\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9+\3\2\2\2\u00aa\u00ab"+
		"\5\64\33\2\u00ab\u00ac\7\f\2\2\u00ac\u00ad\7\24\2\2\u00ad-\3\2\2\2\u00ae"+
		"\u00af\5\66\34\2\u00af\u00b0\7\f\2\2\u00b0\u00b3\7\25\2\2\u00b1\u00b4"+
		"\5,\27\2\u00b2\u00b4\7\23\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b2\3\2\2\2"+
		"\u00b4\u00b5\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6/\3"+
		"\2\2\2\u00b7\u00b8\5\66\34\2\u00b8\u00b9\7\f\2\2\u00b9\u00bc\7\25\2\2"+
		"\u00ba\u00bd\5,\27\2\u00bb\u00bd\7\23\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bb"+
		"\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf"+
		"\61\3\2\2\2\u00c0\u00c1\5\66\34\2\u00c1\u00c2\7\f\2\2\u00c2\u00c5\7\25"+
		"\2\2\u00c3\u00c6\5,\27\2\u00c4\u00c6\7\23\2\2\u00c5\u00c3\3\2\2\2\u00c5"+
		"\u00c4\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c7\u00c8\3\2"+
		"\2\2\u00c8\63\3\2\2\2\u00c9\u00ca\7\r\2\2\u00ca\u00cb\7\26\2\2\u00cb\65"+
		"\3\2\2\2\u00cc\u00cd\7\16\2\2\u00cd\u00ce\7\26\2\2\u00ce\67\3\2\2\2\32"+
		";AEIMlpt|~\u008e\u0090\u0096\u0098\u009e\u00a0\u00a6\u00a8\u00b3\u00b5"+
		"\u00bc\u00be\u00c5\u00c7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}