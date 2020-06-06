package frsl.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.fife.ui.autocomplete.AutoCompletion;
import org.fife.ui.autocomplete.BasicCompletion;
import org.fife.ui.autocomplete.CompletionProvider;
import org.fife.ui.autocomplete.DefaultCompletionProvider;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;

import frsl.util.IOUtil;

public class FRSLSpecificationTextEditor extends JPanel {

	private static final long serialVersionUID = 1L;

	private RSyntaxTextArea textArea;

	public FRSLSpecificationTextEditor() {
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(1100, 500));
		textArea = new RSyntaxTextArea();
//		textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
		textArea.setCodeFoldingEnabled(true);
		add(new RTextScrollPane(textArea));
		CompletionProvider provider = createCompletionProvider();
		AutoCompletion ac = new AutoCompletion(provider);
		ac.install(textArea);
		add(new RTextScrollPane(textArea));
	}

	private CompletionProvider createCompletionProvider() {
		DefaultCompletionProvider provider = new DefaultCompletionProvider();
		String[] listKeyWord = { "Use case: ", "Brief description: ", "Actors: ", "Precondition: ", "Postcondition: ",
				"Trigger: ", "Special requirement: ", "Basic flow: ", "Alternative flows: ", "Flow ", "Step " };
		for (String keyWord : listKeyWord) {
			provider.addCompletion(new BasicCompletion(provider, keyWord));
		}
//		provider.addCompletion(
//				new ShorthandCompletion(provider, "sysout", "System.out.println(", "System.out.println("));
//		provider.addCompletion(
//				new ShorthandCompletion(provider, "syserr", "System.err.println(", "System.err.println("));
		return provider;

	}

	public void loadFromFile(String filePath) {
		String frslSpecificationText = IOUtil.readFile(filePath);
		if (frslSpecificationText == null) {
			JOptionPane.showMessageDialog(null, "Can't read file");
		} else {
			textArea.setText(frslSpecificationText);
		}
	}

	public String getFrslSpecificationText() {
		return textArea.getText();
	}

}
