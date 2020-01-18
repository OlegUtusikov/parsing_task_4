// Generated from /home/utusikov/pars/parsing_task_4/grammar/Grammar.g4 by ANTLR 4.7.1

#include <string>
#include "./../../src/Grammar.hpp"

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		DROP=1, RETS=2, START=3, EPS=4, ARROW=5, TERM_TOKEN=6, NTERM_TOKEN=7, 
		WHITESPACE=8, CODE=9, HEADER_CODE=10, STRING=11, ATTR=12, LB=13, RB=14, 
		LP=15, RP=16, LSQUARE=17, RSQUARE=18, COLON=19, SCOLON=20, STICK=21, PROCENT=22;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"DROP", "RETS", "START", "EPS", "ARROW", "TERM_TOKEN", "NTERM_TOKEN", 
		"WHITESPACE", "CODE", "HEADER_CODE", "STRING", "ATTR", "LB", "RB", "LP", 
		"RP", "LSQUARE", "RSQUARE", "COLON", "SCOLON", "STICK", "PROCENT"
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


	public GrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\30\u0096\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\2\3"+
		"\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5"+
		"\3\5\3\5\3\6\3\6\3\6\3\7\6\7K\n\7\r\7\16\7L\3\b\6\bP\n\b\r\b\16\bQ\3\t"+
		"\6\tU\n\t\r\t\16\tV\3\t\3\t\3\n\3\n\7\n]\n\n\f\n\16\n`\13\n\3\n\3\n\3"+
		"\13\3\13\3\13\3\13\3\f\3\f\7\fj\n\f\f\f\16\fm\13\f\3\f\3\f\3\f\7\fr\n"+
		"\f\f\f\16\fu\13\f\3\f\5\fx\n\f\3\r\3\r\7\r|\n\r\f\r\16\r\177\13\r\3\r"+
		"\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24"+
		"\3\24\3\25\3\25\3\26\3\26\3\27\3\27\6^ks}\2\30\3\3\5\4\7\5\t\6\13\7\r"+
		"\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25"+
		")\26+\27-\30\3\2\5\3\2C\\\3\2c|\5\2\13\f\17\17\"\"\2\u009d\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2"+
		"\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2"+
		"\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\3/\3\2\2\2\5\64\3\2\2"+
		"\2\7<\3\2\2\2\tB\3\2\2\2\13F\3\2\2\2\rJ\3\2\2\2\17O\3\2\2\2\21T\3\2\2"+
		"\2\23Z\3\2\2\2\25c\3\2\2\2\27w\3\2\2\2\31y\3\2\2\2\33\u0082\3\2\2\2\35"+
		"\u0084\3\2\2\2\37\u0086\3\2\2\2!\u0088\3\2\2\2#\u008a\3\2\2\2%\u008c\3"+
		"\2\2\2\'\u008e\3\2\2\2)\u0090\3\2\2\2+\u0092\3\2\2\2-\u0094\3\2\2\2/\60"+
		"\7f\2\2\60\61\7t\2\2\61\62\7q\2\2\62\63\7r\2\2\63\4\3\2\2\2\64\65\7t\2"+
		"\2\65\66\7g\2\2\66\67\7v\2\2\678\7w\2\289\7t\2\29:\7p\2\2:;\7u\2\2;\6"+
		"\3\2\2\2<=\7u\2\2=>\7v\2\2>?\7c\2\2?@\7t\2\2@A\7v\2\2A\b\3\2\2\2BC\7G"+
		"\2\2CD\7R\2\2DE\7U\2\2E\n\3\2\2\2FG\7/\2\2GH\7@\2\2H\f\3\2\2\2IK\t\2\2"+
		"\2JI\3\2\2\2KL\3\2\2\2LJ\3\2\2\2LM\3\2\2\2M\16\3\2\2\2NP\t\3\2\2ON\3\2"+
		"\2\2PQ\3\2\2\2QO\3\2\2\2QR\3\2\2\2R\20\3\2\2\2SU\t\4\2\2TS\3\2\2\2UV\3"+
		"\2\2\2VT\3\2\2\2VW\3\2\2\2WX\3\2\2\2XY\b\t\2\2Y\22\3\2\2\2Z^\5\33\16\2"+
		"[]\13\2\2\2\\[\3\2\2\2]`\3\2\2\2^_\3\2\2\2^\\\3\2\2\2_a\3\2\2\2`^\3\2"+
		"\2\2ab\5\35\17\2b\24\3\2\2\2cd\5-\27\2de\5\23\n\2ef\5-\27\2f\26\3\2\2"+
		"\2gk\7$\2\2hj\13\2\2\2ih\3\2\2\2jm\3\2\2\2kl\3\2\2\2ki\3\2\2\2ln\3\2\2"+
		"\2mk\3\2\2\2nx\7$\2\2os\7)\2\2pr\13\2\2\2qp\3\2\2\2ru\3\2\2\2st\3\2\2"+
		"\2sq\3\2\2\2tv\3\2\2\2us\3\2\2\2vx\7)\2\2wg\3\2\2\2wo\3\2\2\2x\30\3\2"+
		"\2\2y}\5#\22\2z|\13\2\2\2{z\3\2\2\2|\177\3\2\2\2}~\3\2\2\2}{\3\2\2\2~"+
		"\u0080\3\2\2\2\177}\3\2\2\2\u0080\u0081\5%\23\2\u0081\32\3\2\2\2\u0082"+
		"\u0083\7}\2\2\u0083\34\3\2\2\2\u0084\u0085\7\177\2\2\u0085\36\3\2\2\2"+
		"\u0086\u0087\7*\2\2\u0087 \3\2\2\2\u0088\u0089\7+\2\2\u0089\"\3\2\2\2"+
		"\u008a\u008b\7]\2\2\u008b$\3\2\2\2\u008c\u008d\7_\2\2\u008d&\3\2\2\2\u008e"+
		"\u008f\7<\2\2\u008f(\3\2\2\2\u0090\u0091\7=\2\2\u0091*\3\2\2\2\u0092\u0093"+
		"\7~\2\2\u0093,\3\2\2\2\u0094\u0095\7\'\2\2\u0095.\3\2\2\2\13\2LQV^ksw"+
		"}\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}