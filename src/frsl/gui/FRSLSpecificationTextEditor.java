package frsl.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.fife.ui.autocomplete.AutoCompletion;
import org.fife.ui.autocomplete.BasicCompletion;
import org.fife.ui.autocomplete.CompletionProvider;
import org.fife.ui.autocomplete.DefaultCompletionProvider;
import org.fife.ui.rsyntaxtextarea.AbstractTokenMakerFactory;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.TokenMakerFactory;
import org.fife.ui.rtextarea.RTextScrollPane;

import frsl.util.IOUtil;

public class FRSLSpecificationTextEditor extends JPanel {

	private static final long serialVersionUID = 1L;

	private static RSyntaxTextArea textArea;

	public FRSLSpecificationTextEditor() {
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(1100, 500));
		textArea = new RSyntaxTextArea();
		AbstractTokenMakerFactory atmf = (AbstractTokenMakerFactory) TokenMakerFactory.getDefaultInstance();
		atmf.putMapping("frsl", KeywordsHighlighting.class.getName());
		textArea.setSyntaxEditingStyle("frsl");
		textArea.setCodeFoldingEnabled(true);
		add(new RTextScrollPane(textArea));
		CompletionProvider provider = createCompletionProvider();
		AutoCompletion ac = new AutoCompletion(provider);
		ac.install(textArea);
		add(new RTextScrollPane(textArea));
	}

	private CompletionProvider createCompletionProvider() {
		DefaultCompletionProvider provider = new DefaultCompletionProvider();
		String[] listKeyWord = { "UseCase : ", "BriefDescription : ", "Actors : ", "Precondition : ",
				"Postcondition : ", "Trigger : ", "SpecialRequirement : ", "BasicFlow : ", "AlternativeFlows : ",
				"Flow ", "Step " };
		for (String keyWord : listKeyWord) {
			provider.addCompletion(new BasicCompletion(provider, keyWord));
		}
		return provider;

	}

	public static void loadFromFile(String filePath) {
		String frslSpecificationText = IOUtil.readFile(filePath);
		if (frslSpecificationText == null) {
			JOptionPane.showMessageDialog(null, "Can't read file");
		} else {
			textArea.setText(frslSpecificationText);
		}
	}

	public static String getFrslSpecificationText() {
		return textArea.getText();
	}

}
