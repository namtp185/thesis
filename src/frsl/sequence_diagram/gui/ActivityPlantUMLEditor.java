
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
import frsl.metamodel.Action;
import frsl.metamodel.Actor;
import frsl.metamodel.ActorAction;
import frsl.metamodel.ConditionNode;
import frsl.metamodel.ConditionStep;
import frsl.metamodel.Entity;
import frsl.metamodel.FlowStep;
import frsl.metamodel.Message;
import frsl.metamodel.Node;
import frsl.metamodel.SequenceMessage;
import frsl.metamodel.SequenceNode;
import frsl.metamodel.SequenceStep;
import frsl.metamodel.SystemAction;
import frsl.metamodel.USLNode;
import frsl.metamodel.UseCase;

public class ActivityPlantUMLEditor extends PlantUMLEditor {
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

	public ActivityPlantUMLEditor(String templateFile, UseCase usecase) {
		this.templateFile = templateFile;
		this.usecase = usecase;
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
//		for (Node node : model.getNodes()) {
//			if(node instanceof SequenceNode) {
//				SequenceNode sqNode = (SequenceNode)node;
//				sb.append(sqNode.toString());
//			}
//			if(node instanceof ConditionNode) {
//				ConditionNode cdNode = (ConditionNode)node;
//				sb.append(node.toString());
//			}
//		}
		
		
//		for (USLNode node : usecase.getUslNodes()) {
//			if(node instanceof FlowStep) {
//				
//			}
//			
//			if(node instanceof ConditionStep) {
//				
//			}
//			
//			if(node instanceof SequenceStep) {
//				
//			}
//		}
		
		sb.append("@enduml\n");
		textArea.setText(sb.toString());
	}
	

//	public void generateRenderInfo() {
//		// Context information here
//		// A state machine: state1: actor enter data
//		// state2: system validate data
//		// state3: system show error
//		// -> create a loop
//		
//		for(Node node: model.getNodes()) {
//			if(node instanceof SequenceNode) {
//				
//			}
//			System.out.println(node);
//			Action a = node.getAction();
//			if(a instanceof SystemAction) {
//				SystemAction sa = (SystemAction)a;
//				if(sa.isShowError()) {
//					
//				}
//			}
//			if(a instanceof ActorAction) {
//				ActorAction aa = (ActorAction)a;
//				
//			}
//		}
//		
//		// Context information here
//		// 
//		for(Message message: model.getMessages()) {
//			
//		}
//	}

	

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
