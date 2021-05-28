
package frsl.sequence_diagram.gui;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rtextarea.RTextScrollPane;

import frsl.constant.Constant;
import frsl.metamodel.Actor;
import frsl.metamodel.Entity;
import frsl.metamodel.Message;
import frsl.metamodel.SequenceMessage;

public class SequencePlantUMLEditor extends PlantUMLEditor {
	private static final long serialVersionUID = 1L;	
	
	private StringBuilder sb;
	private RSyntaxTextArea textArea;
	private RTextScrollPane sp;
	private BufferedWriter writer = null;
	private String templateFile;
	
	protected JButton createBtnGenDiagram() {
		JButton btn = new JButton("Generate diagram");

		DiagramWindow d = new DiagramWindow(Constant.FILE_OUTPUT.replace(".puml", ".png"));
		btn.addActionListener((evt) -> {
			try {
				writer = new BufferedWriter(new FileWriter(new File(
						// Constant.DOMAIN_ELEMENTS_OUTPUT
						getTemplateFilePath())));
				writer.write(textArea.getText());
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			genImage();
			d.repaint();
		});
		return btn;
	}

	protected void genImage() {
		try {
			RunShellCommand.runProcess("java -jar lib/plantuml.1.2020.15.jar -tpng " + Constant.FILE_OUTPUT);
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	public SequencePlantUMLEditor(String templateFile) {
		this.templateFile = templateFile;
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(300, 200));
		textArea = new RSyntaxTextArea();
		sp = new RTextScrollPane(textArea);
		add(sp);
		sb = new StringBuilder();
		add(createBtnGenDiagram(), BorderLayout.NORTH);
	}

	protected String getTemplateFilePath() {
		return System.getProperty("user.dir") + "/" + this.templateFile;
	}

	@Override
	protected void render() {
		sb.setLength(0);
		sb.append("@startuml\n");
		for (Entity e : model.getEntities().values()) {
			sb.append(e.toString());
		}
		for (Actor a : model.getActors().values()) {
			sb.append(a.toString());
		}
		for (Message message : model.getMessages()) {
			System.out.println(message);
		}
		sb.append("@enduml\n");
		textArea.setText(sb.toString());
	}

	

	class DiagramWindow extends JDialog {
		private static final long serialVersionUID = 1L;

		class DiagramWindowPanel extends Canvas {
			private static final long serialVersionUID = 1L;
			private String templateFile;
			
			public DiagramWindowPanel(String templateFile) {
				this.templateFile = templateFile;
			}
			
			public void paint(Graphics g) {

				Toolkit t = Toolkit.getDefaultToolkit();
				Image img = t.getImage(this.templateFile);
				g.drawImage(img, 0, 0, this);
			}
		}

		public DiagramWindow(String templateFile) {
			add(new DiagramWindowPanel(templateFile));
			setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			pack();
			setVisible(true);
		}
	}
}
