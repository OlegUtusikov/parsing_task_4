// Generated from /home/utusikov/pars/parsing_task_4/grammar/Grammar.g4 by ANTLR 4.7.1

#include <string>
#include "./../../src/Grammar.hpp"

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		DROP=1, RETS=2, START=3, EPS=4, ARROW=5, TERM_TOKEN=6, NTERM_TOKEN=7, 
		WHITESPACE=8, CODE=9, HEADER_CODE=10, STRING=11, ATTR=12, LB=13, RB=14, 
		LP=15, RP=16, LSQUARE=17, RSQUARE=18, COLON=19, SCOLON=20, STICK=21, PROCENT=22;
	public static final int
		RULE_st = 0, RULE_header = 1, RULE_lexicalRule = 2, RULE_rules = 3, RULE_ruleRight = 4, 
		RULE_gram = 5;
	public static final String[] ruleNames = {
		"st", "header", "lexicalRule", "rules", "ruleRight", "gram"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'drop'", "'returns'", "'start'", "'EPS'", "'->'", null, null, null, 
		null, null, null, null, "'{'", "'}'", "'('", "')'", "'['", "']'", "':'", 
		"';'", "'|'", "'%'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "DROP", "RETS", "START", "EPS", "ARROW", "TERM_TOKEN", "NTERM_TOKEN", 
		"WHITESPACE", "CODE", "HEADER_CODE", "STRING", "ATTR", "LB", "RB", "LP", 
		"RP", "LSQUARE", "RSQUARE", "COLON", "SCOLON", "STICK", "PROCENT"
	};
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
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StContext extends ParserRuleContext {
		public std::string startValue;
		public Token NTERM_TOKEN;
		public TerminalNode START() { return getToken(GrammarParser.START, 0); }
		public TerminalNode NTERM_TOKEN() { return getToken(GrammarParser.NTERM_TOKEN, 0); }
		public TerminalNode SCOLON() { return getToken(GrammarParser.SCOLON, 0); }
		public StContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_st; }
	}

	public final StContext st() throws RecognitionException {
		StContext _localctx = new StContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_st);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(12);
			match(START);
			setState(13);
			((StContext)_localctx).NTERM_TOKEN = match(NTERM_TOKEN);
			setState(14);
			match(SCOLON);
			 ((StContext)_localctx).startValue =  (((StContext)_localctx).NTERM_TOKEN!=null?((StContext)_localctx).NTERM_TOKEN.getText():null); 
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

	public static class HeaderContext extends ParserRuleContext {
		public std::string headerValue;
		public Token HEADER_CODE;
		public TerminalNode HEADER_CODE() { return getToken(GrammarParser.HEADER_CODE, 0); }
		public HeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_header; }
	}

	public final HeaderContext header() throws RecognitionException {
		HeaderContext _localctx = new HeaderContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_header);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(17);
			((HeaderContext)_localctx).HEADER_CODE = match(HEADER_CODE);
			 ((HeaderContext)_localctx).headerValue =  (((HeaderContext)_localctx).HEADER_CODE!=null?((HeaderContext)_localctx).HEADER_CODE.getText():null).substr(2, (((HeaderContext)_localctx).HEADER_CODE!=null?((HeaderContext)_localctx).HEADER_CODE.getText():null).size() - 4); 
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

	public static class LexicalRuleContext extends ParserRuleContext {
		public Terminal term;
		public bool droped;
		public Token TERM_TOKEN;
		public Token STRING;
		public TerminalNode TERM_TOKEN() { return getToken(GrammarParser.TERM_TOKEN, 0); }
		public TerminalNode COLON() { return getToken(GrammarParser.COLON, 0); }
		public TerminalNode STRING() { return getToken(GrammarParser.STRING, 0); }
		public TerminalNode SCOLON() { return getToken(GrammarParser.SCOLON, 0); }
		public TerminalNode ARROW() { return getToken(GrammarParser.ARROW, 0); }
		public TerminalNode DROP() { return getToken(GrammarParser.DROP, 0); }
		public LexicalRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lexicalRule; }
	}

	public final LexicalRuleContext lexicalRule() throws RecognitionException {
		LexicalRuleContext _localctx = new LexicalRuleContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_lexicalRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(20);
			((LexicalRuleContext)_localctx).TERM_TOKEN = match(TERM_TOKEN);
			setState(21);
			match(COLON);
			setState(22);
			((LexicalRuleContext)_localctx).STRING = match(STRING);
			 ((LexicalRuleContext)_localctx).droped =  false; 
			setState(27);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ARROW) {
				{
				setState(24);
				match(ARROW);
				setState(25);
				match(DROP);
				 ((LexicalRuleContext)_localctx).droped =  true; 
				}
			}

			setState(29);
			match(SCOLON);
			 ((LexicalRuleContext)_localctx).term =  Terminal((((LexicalRuleContext)_localctx).TERM_TOKEN!=null?((LexicalRuleContext)_localctx).TERM_TOKEN.getText():null), (((LexicalRuleContext)_localctx).STRING!=null?((LexicalRuleContext)_localctx).STRING.getText():null).substr(1, (((LexicalRuleContext)_localctx).STRING!=null?((LexicalRuleContext)_localctx).STRING.getText():null).size() - 2)); 
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

	public static class RulesContext extends ParserRuleContext {
		public NonTerminal nterm;
		public Token NTERM_TOKEN;
		public Token ATTR;
		public RuleRightContext ruleRight;
		public TerminalNode NTERM_TOKEN() { return getToken(GrammarParser.NTERM_TOKEN, 0); }
		public TerminalNode COLON() { return getToken(GrammarParser.COLON, 0); }
		public TerminalNode SCOLON() { return getToken(GrammarParser.SCOLON, 0); }
		public List<RuleRightContext> ruleRight() {
			return getRuleContexts(RuleRightContext.class);
		}
		public RuleRightContext ruleRight(int i) {
			return getRuleContext(RuleRightContext.class,i);
		}
		public List<TerminalNode> ATTR() { return getTokens(GrammarParser.ATTR); }
		public TerminalNode ATTR(int i) {
			return getToken(GrammarParser.ATTR, i);
		}
		public TerminalNode RETS() { return getToken(GrammarParser.RETS, 0); }
		public List<TerminalNode> STICK() { return getTokens(GrammarParser.STICK); }
		public TerminalNode STICK(int i) {
			return getToken(GrammarParser.STICK, i);
		}
		public RulesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rules; }
	}

	public final RulesContext rules() throws RecognitionException {
		RulesContext _localctx = new RulesContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_rules);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			((RulesContext)_localctx).NTERM_TOKEN = match(NTERM_TOKEN);
			 ((RulesContext)_localctx).nterm =  NonTerminal((((RulesContext)_localctx).NTERM_TOKEN!=null?((RulesContext)_localctx).NTERM_TOKEN.getText():null)); 
			setState(36);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ATTR) {
				{
				setState(34);
				((RulesContext)_localctx).ATTR = match(ATTR);
				 _localctx.nterm.arguments = (((RulesContext)_localctx).ATTR!=null?((RulesContext)_localctx).ATTR.getText():null).substr(1, (((RulesContext)_localctx).ATTR!=null?((RulesContext)_localctx).ATTR.getText():null).size() - 2);
				}
			}

			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RETS) {
				{
				setState(38);
				match(RETS);
				setState(39);
				((RulesContext)_localctx).ATTR = match(ATTR);
				 _localctx.nterm.returns = (((RulesContext)_localctx).ATTR!=null?((RulesContext)_localctx).ATTR.getText():null).substr(1, (((RulesContext)_localctx).ATTR!=null?((RulesContext)_localctx).ATTR.getText():null).size() - 2); 
				}
			}

			setState(43);
			match(COLON);
			{
			setState(44);
			((RulesContext)_localctx).ruleRight = ruleRight();
			 _localctx.nterm.addRule(std::move(((RulesContext)_localctx).ruleRight.rule)); 
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==STICK) {
				{
				{
				setState(46);
				match(STICK);
				setState(47);
				((RulesContext)_localctx).ruleRight = ruleRight();
				 _localctx.nterm.addRule(std::move(((RulesContext)_localctx).ruleRight.rule)); 
				}
				}
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			setState(55);
			match(SCOLON);
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

	public static class RuleRightContext extends ParserRuleContext {
		public Rule rule;
		public Token TERM_TOKEN;
		public Token NTERM_TOKEN;
		public Token ATTR;
		public Token CODE;
		public List<TerminalNode> TERM_TOKEN() { return getTokens(GrammarParser.TERM_TOKEN); }
		public TerminalNode TERM_TOKEN(int i) {
			return getToken(GrammarParser.TERM_TOKEN, i);
		}
		public List<TerminalNode> NTERM_TOKEN() { return getTokens(GrammarParser.NTERM_TOKEN); }
		public TerminalNode NTERM_TOKEN(int i) {
			return getToken(GrammarParser.NTERM_TOKEN, i);
		}
		public List<TerminalNode> CODE() { return getTokens(GrammarParser.CODE); }
		public TerminalNode CODE(int i) {
			return getToken(GrammarParser.CODE, i);
		}
		public List<TerminalNode> ATTR() { return getTokens(GrammarParser.ATTR); }
		public TerminalNode ATTR(int i) {
			return getToken(GrammarParser.ATTR, i);
		}
		public TerminalNode EPS() { return getToken(GrammarParser.EPS, 0); }
		public RuleRightContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruleRight; }
	}

	public final RuleRightContext ruleRight() throws RecognitionException {
		RuleRightContext _localctx = new RuleRightContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_ruleRight);
		int _la;
		try {
			setState(91);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TERM_TOKEN:
			case NTERM_TOKEN:
				enterOuterAlt(_localctx, 1);
				{
				setState(65);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case TERM_TOKEN:
					{
					setState(57);
					((RuleRightContext)_localctx).TERM_TOKEN = match(TERM_TOKEN);
					_localctx.rule.emplace_back((((RuleRightContext)_localctx).TERM_TOKEN!=null?((RuleRightContext)_localctx).TERM_TOKEN.getText():null));
					}
					break;
				case NTERM_TOKEN:
					{
					setState(59);
					((RuleRightContext)_localctx).NTERM_TOKEN = match(NTERM_TOKEN);
					 _localctx.rule.emplace_back((((RuleRightContext)_localctx).NTERM_TOKEN!=null?((RuleRightContext)_localctx).NTERM_TOKEN.getText():null)); 
					setState(63);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==ATTR) {
						{
						setState(61);
						((RuleRightContext)_localctx).ATTR = match(ATTR);
						 _localctx.rule.back().code = (((RuleRightContext)_localctx).ATTR!=null?((RuleRightContext)_localctx).ATTR.getText():null).substr(1, (((RuleRightContext)_localctx).ATTR!=null?((RuleRightContext)_localctx).ATTR.getText():null).size() - 2); 
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(79);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TERM_TOKEN) | (1L << NTERM_TOKEN) | (1L << CODE))) != 0)) {
					{
					setState(77);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case TERM_TOKEN:
						{
						setState(67);
						((RuleRightContext)_localctx).TERM_TOKEN = match(TERM_TOKEN);
						 _localctx.rule.emplace_back((((RuleRightContext)_localctx).TERM_TOKEN!=null?((RuleRightContext)_localctx).TERM_TOKEN.getText():null)); 
						}
						break;
					case NTERM_TOKEN:
						{
						setState(69);
						((RuleRightContext)_localctx).NTERM_TOKEN = match(NTERM_TOKEN);
						_localctx.rule.emplace_back((((RuleRightContext)_localctx).NTERM_TOKEN!=null?((RuleRightContext)_localctx).NTERM_TOKEN.getText():null));
						setState(73);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==ATTR) {
							{
							setState(71);
							((RuleRightContext)_localctx).ATTR = match(ATTR);
							_localctx.rule.back().code = (((RuleRightContext)_localctx).ATTR!=null?((RuleRightContext)_localctx).ATTR.getText():null).substr(1, (((RuleRightContext)_localctx).ATTR!=null?((RuleRightContext)_localctx).ATTR.getText():null).size() - 2);
							}
						}

						}
						break;
					case CODE:
						{
						setState(75);
						((RuleRightContext)_localctx).CODE = match(CODE);
						_localctx.rule.emplace_back("CODE", (((RuleRightContext)_localctx).CODE!=null?((RuleRightContext)_localctx).CODE.getText():null).substr(1, (((RuleRightContext)_localctx).CODE!=null?((RuleRightContext)_localctx).CODE.getText():null).size() - 2));
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(81);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case EPS:
				enterOuterAlt(_localctx, 2);
				{
				setState(82);
				match(EPS);
				_localctx.rule.emplace_back("EPS");
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CODE) {
					{
					{
					setState(84);
					((RuleRightContext)_localctx).CODE = match(CODE);
					_localctx.rule.emplace_back("CODE", (((RuleRightContext)_localctx).CODE!=null?((RuleRightContext)_localctx).CODE.getText():null).substr(1, (((RuleRightContext)_localctx).CODE!=null?((RuleRightContext)_localctx).CODE.getText():null).size() - 2));
					}
					}
					setState(90);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class GramContext extends ParserRuleContext {
		public Grammar g;
		public HeaderContext header;
		public StContext st;
		public LexicalRuleContext lexicalRule;
		public RulesContext rules;
		public StContext st() {
			return getRuleContext(StContext.class,0);
		}
		public HeaderContext header() {
			return getRuleContext(HeaderContext.class,0);
		}
		public List<LexicalRuleContext> lexicalRule() {
			return getRuleContexts(LexicalRuleContext.class);
		}
		public LexicalRuleContext lexicalRule(int i) {
			return getRuleContext(LexicalRuleContext.class,i);
		}
		public List<RulesContext> rules() {
			return getRuleContexts(RulesContext.class);
		}
		public RulesContext rules(int i) {
			return getRuleContext(RulesContext.class,i);
		}
		public GramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gram; }
	}

	public final GramContext gram() throws RecognitionException {
		GramContext _localctx = new GramContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_gram);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==HEADER_CODE) {
				{
				setState(93);
				((GramContext)_localctx).header = header();
				 _localctx.g.setHeader(((GramContext)_localctx).header.headerValue); 
				}
			}

			setState(98);
			((GramContext)_localctx).st = st();
			 _localctx.g.setStart(((GramContext)_localctx).st.startValue); 
			setState(106); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(106);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case TERM_TOKEN:
					{
					setState(100);
					((GramContext)_localctx).lexicalRule = lexicalRule();
					 _localctx.g.addTerminal(((GramContext)_localctx).lexicalRule.term, ((GramContext)_localctx).lexicalRule.droped); 
					}
					break;
				case NTERM_TOKEN:
					{
					setState(103);
					((GramContext)_localctx).rules = rules();
					 _localctx.g.addNonTerminal(std::move(((GramContext)_localctx).rules.nterm));
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(108); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==TERM_TOKEN || _la==NTERM_TOKEN );
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\30q\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\5\4\36\n\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\5\5\'"+
		"\n\5\3\5\3\5\3\5\5\5,\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5\65\n\5\f\5\16"+
		"\58\13\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\5\6B\n\6\5\6D\n\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\5\6L\n\6\3\6\3\6\7\6P\n\6\f\6\16\6S\13\6\3\6\3\6\3\6\3\6"+
		"\7\6Y\n\6\f\6\16\6\\\13\6\5\6^\n\6\3\7\3\7\3\7\5\7c\n\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\6\7m\n\7\r\7\16\7n\3\7\2\2\b\2\4\6\b\n\f\2\2\2y\2\16"+
		"\3\2\2\2\4\23\3\2\2\2\6\26\3\2\2\2\b\"\3\2\2\2\n]\3\2\2\2\fb\3\2\2\2\16"+
		"\17\7\5\2\2\17\20\7\t\2\2\20\21\7\26\2\2\21\22\b\2\1\2\22\3\3\2\2\2\23"+
		"\24\7\f\2\2\24\25\b\3\1\2\25\5\3\2\2\2\26\27\7\b\2\2\27\30\7\25\2\2\30"+
		"\31\7\r\2\2\31\35\b\4\1\2\32\33\7\7\2\2\33\34\7\3\2\2\34\36\b\4\1\2\35"+
		"\32\3\2\2\2\35\36\3\2\2\2\36\37\3\2\2\2\37 \7\26\2\2 !\b\4\1\2!\7\3\2"+
		"\2\2\"#\7\t\2\2#&\b\5\1\2$%\7\16\2\2%\'\b\5\1\2&$\3\2\2\2&\'\3\2\2\2\'"+
		"+\3\2\2\2()\7\4\2\2)*\7\16\2\2*,\b\5\1\2+(\3\2\2\2+,\3\2\2\2,-\3\2\2\2"+
		"-.\7\25\2\2./\5\n\6\2/\66\b\5\1\2\60\61\7\27\2\2\61\62\5\n\6\2\62\63\b"+
		"\5\1\2\63\65\3\2\2\2\64\60\3\2\2\2\658\3\2\2\2\66\64\3\2\2\2\66\67\3\2"+
		"\2\2\679\3\2\2\28\66\3\2\2\29:\7\26\2\2:\t\3\2\2\2;<\7\b\2\2<D\b\6\1\2"+
		"=>\7\t\2\2>A\b\6\1\2?@\7\16\2\2@B\b\6\1\2A?\3\2\2\2AB\3\2\2\2BD\3\2\2"+
		"\2C;\3\2\2\2C=\3\2\2\2DQ\3\2\2\2EF\7\b\2\2FP\b\6\1\2GH\7\t\2\2HK\b\6\1"+
		"\2IJ\7\16\2\2JL\b\6\1\2KI\3\2\2\2KL\3\2\2\2LP\3\2\2\2MN\7\13\2\2NP\b\6"+
		"\1\2OE\3\2\2\2OG\3\2\2\2OM\3\2\2\2PS\3\2\2\2QO\3\2\2\2QR\3\2\2\2R^\3\2"+
		"\2\2SQ\3\2\2\2TU\7\6\2\2UZ\b\6\1\2VW\7\13\2\2WY\b\6\1\2XV\3\2\2\2Y\\\3"+
		"\2\2\2ZX\3\2\2\2Z[\3\2\2\2[^\3\2\2\2\\Z\3\2\2\2]C\3\2\2\2]T\3\2\2\2^\13"+
		"\3\2\2\2_`\5\4\3\2`a\b\7\1\2ac\3\2\2\2b_\3\2\2\2bc\3\2\2\2cd\3\2\2\2d"+
		"e\5\2\2\2el\b\7\1\2fg\5\6\4\2gh\b\7\1\2hm\3\2\2\2ij\5\b\5\2jk\b\7\1\2"+
		"km\3\2\2\2lf\3\2\2\2li\3\2\2\2mn\3\2\2\2nl\3\2\2\2no\3\2\2\2o\r\3\2\2"+
		"\2\20\35&+\66ACKOQZ]bln";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}