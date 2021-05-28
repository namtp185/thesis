package frsl.sequence_diagram.util;

public class Sentence implements Token {
	
	private String sentence;
	
	public boolean isTerminal() {
		return false;
	}
	
	public Sentence(String sentence) {
		this.sentence = sentence;
	}
	
	public void visitChild(Builder builder) {
		builder.append(sentence + "\n");
		return;
	}
}
