package frsl.sequence_diagram.util;

import java.util.ArrayList;
import java.util.List;

public class Block implements Token {
	
	protected List<Token> children;
	
	public Block() {
		this.children = new ArrayList<>();
	}
	
	
	public boolean isTerminal() {
		return false;
	}
	
	public void addChild(Token token) {
		children.add(token);
	}
	
	public void visitChild(Builder builder) {
		// preorder traverse
		for(Token token: children) {
			token.visitChild(builder);
		}
	}
}
