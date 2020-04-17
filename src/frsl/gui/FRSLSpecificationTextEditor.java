package frsl.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import frsl.util.IOUtil;

public class FRSLSpecificationTextEditor extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextArea textArea;

	public FRSLSpecificationTextEditor() {
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(1100, 500));
		textArea = new JTextArea();
		textArea.setTabSize(2);
		textArea.setMargin(new Insets(10, 10, 10, 10));
		textArea.setFont(new Font("Serif", Font.PLAIN, 15));
		JScrollPane scrollPane = new JScrollPane(textArea);
		add(scrollPane);
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
