package frsl.sequence_diagram.util;

public interface Token {
	public boolean isTerminal();
	public void visitChild(Builder builder);
}
