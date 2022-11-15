// Generated from C:/Users/lenovo/IdeaProjects/compile/src/antlr\Compile.g4 by ANTLR 4.9
package antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CompileLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMPIL=1, INT=2, FLOAT=3, STRING=4, SCAN=5, PRINT=6, START=7, IF=8, THEN=9, 
		ELSE=10, DO=11, WHILE=12, AFF=13, PLUS=14, MINUS=15, MUL=16, DIV=17, SUP=18, 
		INF=19, SUPE=20, INFE=21, EQ=22, DIF=23, PARO=24, PARF=25, ACODO=26, ACODF=27, 
		PV=28, VER=29, ID=30, INTEGERVAL=31, FLOATVAL=32, STR=33, WS=34, COMMENTAIRE1=35, 
		COMMENTAIRE2=36;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"COMPIL", "INT", "FLOAT", "STRING", "SCAN", "PRINT", "START", "IF", "THEN", 
			"ELSE", "DO", "WHILE", "AFF", "PLUS", "MINUS", "MUL", "DIV", "SUP", "INF", 
			"SUPE", "INFE", "EQ", "DIF", "PARO", "PARF", "ACODO", "ACODF", "PV", 
			"VER", "ID", "INTEGERVAL", "FLOATVAL", "STR", "WS", "COMMENTAIRE1", "COMMENTAIRE2"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'compil'", "'intCompil'", "'floatCompil'", "'stringCompil'", "'scancompil'", 
			"'printcompil'", "'start'", "'if'", "'then'", "'else'", "'do'", "'while'", 
			"'='", "'+'", "'-'", "'*'", "'/'", "'>'", "'<'", "'>='", "'<='", "'=='", 
			"'!='", "'('", "')'", "'{'", "'}'", "';'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COMPIL", "INT", "FLOAT", "STRING", "SCAN", "PRINT", "START", "IF", 
			"THEN", "ELSE", "DO", "WHILE", "AFF", "PLUS", "MINUS", "MUL", "DIV", 
			"SUP", "INF", "SUPE", "INFE", "EQ", "DIF", "PARO", "PARF", "ACODO", "ACODF", 
			"PV", "VER", "ID", "INTEGERVAL", "FLOATVAL", "STR", "WS", "COMMENTAIRE1", 
			"COMMENTAIRE2"
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


	public CompileLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Compile.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2&\u0108\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13"+
		"\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\17"+
		"\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\25"+
		"\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\32\3\32\3\33"+
		"\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\7\37\u00d1\n\37\f\37\16"+
		"\37\u00d4\13\37\3 \3 \3 \7 \u00d9\n \f \16 \u00dc\13 \5 \u00de\n \3!\3"+
		"!\3!\3!\3\"\3\"\7\"\u00e6\n\"\f\"\16\"\u00e9\13\"\3\"\3\"\3#\3#\3#\3#"+
		"\3$\3$\3$\7$\u00f4\n$\f$\16$\u00f7\13$\3$\3$\3%\3%\3%\3%\7%\u00ff\n%\f"+
		"%\16%\u0102\13%\3%\3%\3%\3%\3%\4\u00e7\u0100\2&\3\3\5\4\7\5\t\6\13\7\r"+
		"\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25"+
		")\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&\3\2\b"+
		"\4\2C\\c|\6\2\62;C\\aac|\3\2\63;\3\2\62;\4\2\13\f\"\"\3\2\f\f\2\u010d"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2"+
		"\2\2I\3\2\2\2\3K\3\2\2\2\5R\3\2\2\2\7\\\3\2\2\2\th\3\2\2\2\13u\3\2\2\2"+
		"\r\u0080\3\2\2\2\17\u008c\3\2\2\2\21\u0092\3\2\2\2\23\u0095\3\2\2\2\25"+
		"\u009a\3\2\2\2\27\u009f\3\2\2\2\31\u00a2\3\2\2\2\33\u00a8\3\2\2\2\35\u00aa"+
		"\3\2\2\2\37\u00ac\3\2\2\2!\u00ae\3\2\2\2#\u00b0\3\2\2\2%\u00b2\3\2\2\2"+
		"\'\u00b4\3\2\2\2)\u00b6\3\2\2\2+\u00b9\3\2\2\2-\u00bc\3\2\2\2/\u00bf\3"+
		"\2\2\2\61\u00c2\3\2\2\2\63\u00c4\3\2\2\2\65\u00c6\3\2\2\2\67\u00c8\3\2"+
		"\2\29\u00ca\3\2\2\2;\u00cc\3\2\2\2=\u00ce\3\2\2\2?\u00dd\3\2\2\2A\u00df"+
		"\3\2\2\2C\u00e3\3\2\2\2E\u00ec\3\2\2\2G\u00f0\3\2\2\2I\u00fa\3\2\2\2K"+
		"L\7e\2\2LM\7q\2\2MN\7o\2\2NO\7r\2\2OP\7k\2\2PQ\7n\2\2Q\4\3\2\2\2RS\7k"+
		"\2\2ST\7p\2\2TU\7v\2\2UV\7E\2\2VW\7q\2\2WX\7o\2\2XY\7r\2\2YZ\7k\2\2Z["+
		"\7n\2\2[\6\3\2\2\2\\]\7h\2\2]^\7n\2\2^_\7q\2\2_`\7c\2\2`a\7v\2\2ab\7E"+
		"\2\2bc\7q\2\2cd\7o\2\2de\7r\2\2ef\7k\2\2fg\7n\2\2g\b\3\2\2\2hi\7u\2\2"+
		"ij\7v\2\2jk\7t\2\2kl\7k\2\2lm\7p\2\2mn\7i\2\2no\7E\2\2op\7q\2\2pq\7o\2"+
		"\2qr\7r\2\2rs\7k\2\2st\7n\2\2t\n\3\2\2\2uv\7u\2\2vw\7e\2\2wx\7c\2\2xy"+
		"\7p\2\2yz\7e\2\2z{\7q\2\2{|\7o\2\2|}\7r\2\2}~\7k\2\2~\177\7n\2\2\177\f"+
		"\3\2\2\2\u0080\u0081\7r\2\2\u0081\u0082\7t\2\2\u0082\u0083\7k\2\2\u0083"+
		"\u0084\7p\2\2\u0084\u0085\7v\2\2\u0085\u0086\7e\2\2\u0086\u0087\7q\2\2"+
		"\u0087\u0088\7o\2\2\u0088\u0089\7r\2\2\u0089\u008a\7k\2\2\u008a\u008b"+
		"\7n\2\2\u008b\16\3\2\2\2\u008c\u008d\7u\2\2\u008d\u008e\7v\2\2\u008e\u008f"+
		"\7c\2\2\u008f\u0090\7t\2\2\u0090\u0091\7v\2\2\u0091\20\3\2\2\2\u0092\u0093"+
		"\7k\2\2\u0093\u0094\7h\2\2\u0094\22\3\2\2\2\u0095\u0096\7v\2\2\u0096\u0097"+
		"\7j\2\2\u0097\u0098\7g\2\2\u0098\u0099\7p\2\2\u0099\24\3\2\2\2\u009a\u009b"+
		"\7g\2\2\u009b\u009c\7n\2\2\u009c\u009d\7u\2\2\u009d\u009e\7g\2\2\u009e"+
		"\26\3\2\2\2\u009f\u00a0\7f\2\2\u00a0\u00a1\7q\2\2\u00a1\30\3\2\2\2\u00a2"+
		"\u00a3\7y\2\2\u00a3\u00a4\7j\2\2\u00a4\u00a5\7k\2\2\u00a5\u00a6\7n\2\2"+
		"\u00a6\u00a7\7g\2\2\u00a7\32\3\2\2\2\u00a8\u00a9\7?\2\2\u00a9\34\3\2\2"+
		"\2\u00aa\u00ab\7-\2\2\u00ab\36\3\2\2\2\u00ac\u00ad\7/\2\2\u00ad \3\2\2"+
		"\2\u00ae\u00af\7,\2\2\u00af\"\3\2\2\2\u00b0\u00b1\7\61\2\2\u00b1$\3\2"+
		"\2\2\u00b2\u00b3\7@\2\2\u00b3&\3\2\2\2\u00b4\u00b5\7>\2\2\u00b5(\3\2\2"+
		"\2\u00b6\u00b7\7@\2\2\u00b7\u00b8\7?\2\2\u00b8*\3\2\2\2\u00b9\u00ba\7"+
		">\2\2\u00ba\u00bb\7?\2\2\u00bb,\3\2\2\2\u00bc\u00bd\7?\2\2\u00bd\u00be"+
		"\7?\2\2\u00be.\3\2\2\2\u00bf\u00c0\7#\2\2\u00c0\u00c1\7?\2\2\u00c1\60"+
		"\3\2\2\2\u00c2\u00c3\7*\2\2\u00c3\62\3\2\2\2\u00c4\u00c5\7+\2\2\u00c5"+
		"\64\3\2\2\2\u00c6\u00c7\7}\2\2\u00c7\66\3\2\2\2\u00c8\u00c9\7\177\2\2"+
		"\u00c98\3\2\2\2\u00ca\u00cb\7=\2\2\u00cb:\3\2\2\2\u00cc\u00cd\7.\2\2\u00cd"+
		"<\3\2\2\2\u00ce\u00d2\t\2\2\2\u00cf\u00d1\t\3\2\2\u00d0\u00cf\3\2\2\2"+
		"\u00d1\u00d4\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3>\3"+
		"\2\2\2\u00d4\u00d2\3\2\2\2\u00d5\u00de\7\62\2\2\u00d6\u00da\t\4\2\2\u00d7"+
		"\u00d9\t\5\2\2\u00d8\u00d7\3\2\2\2\u00d9\u00dc\3\2\2\2\u00da\u00d8\3\2"+
		"\2\2\u00da\u00db\3\2\2\2\u00db\u00de\3\2\2\2\u00dc\u00da\3\2\2\2\u00dd"+
		"\u00d5\3\2\2\2\u00dd\u00d6\3\2\2\2\u00de@\3\2\2\2\u00df\u00e0\5? \2\u00e0"+
		"\u00e1\7\60\2\2\u00e1\u00e2\5? \2\u00e2B\3\2\2\2\u00e3\u00e7\7$\2\2\u00e4"+
		"\u00e6\13\2\2\2\u00e5\u00e4\3\2\2\2\u00e6\u00e9\3\2\2\2\u00e7\u00e8\3"+
		"\2\2\2\u00e7\u00e5\3\2\2\2\u00e8\u00ea\3\2\2\2\u00e9\u00e7\3\2\2\2\u00ea"+
		"\u00eb\7$\2\2\u00ebD\3\2\2\2\u00ec\u00ed\t\6\2\2\u00ed\u00ee\3\2\2\2\u00ee"+
		"\u00ef\b#\2\2\u00efF\3\2\2\2\u00f0\u00f1\7\61\2\2\u00f1\u00f5\7\61\2\2"+
		"\u00f2\u00f4\n\7\2\2\u00f3\u00f2\3\2\2\2\u00f4\u00f7\3\2\2\2\u00f5\u00f3"+
		"\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f8\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f8"+
		"\u00f9\b$\2\2\u00f9H\3\2\2\2\u00fa\u00fb\7\61\2\2\u00fb\u00fc\7,\2\2\u00fc"+
		"\u0100\3\2\2\2\u00fd\u00ff\13\2\2\2\u00fe\u00fd\3\2\2\2\u00ff\u0102\3"+
		"\2\2\2\u0100\u0101\3\2\2\2\u0100\u00fe\3\2\2\2\u0101\u0103\3\2\2\2\u0102"+
		"\u0100\3\2\2\2\u0103\u0104\7,\2\2\u0104\u0105\7\61\2\2\u0105\u0106\3\2"+
		"\2\2\u0106\u0107\b%\2\2\u0107J\3\2\2\2\t\2\u00d2\u00da\u00dd\u00e7\u00f5"+
		"\u0100\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}