package frsl.sequence_diagram.util;

public class InlineString implements Token {
	
	private String string;
	
	public boolean isTerminal() {
		return false;
	}
	
	public InlineString(String string) {
		this.string = string;
	}
	
	public void visitChild(Builder builder) {
		builder.append(string);
		return;
	}
}
