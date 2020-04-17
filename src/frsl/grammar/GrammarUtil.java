package frsl.grammar;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import frsl.metamodel.UseCase;
import frsl.util.IOUtil;

public class GrammarUtil {
	public static UseCase parseFromFile(String filepath) {
		String data = IOUtil.readFile(filepath);
		return parseFromText(data);
	}

	public static UseCase parseFromText(String text) {
		try {
			ANTLRInputStream antlrInputStream = new ANTLRInputStream(text);
			FRSLLexer lexer = new FRSLLexer(antlrInputStream);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			FRSLParser parser = new FRSLParser(tokens);
			ParseTree tree = parser.metaModel();
			ParseTreeWalker walker = new ParseTreeWalker();
			FRSLWalker FRSLWalker = new FRSLWalker();
			walker.walk(FRSLWalker, tree);
			return FRSLWalker.getMetaModel();
		} catch (Exception e) {
			return null;
		}
	}
}
