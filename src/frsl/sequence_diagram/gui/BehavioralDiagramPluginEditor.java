package frsl.sequence_diagram.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;

import org.fife.ui.rsyntaxtextarea.DocumentRange;
import org.fife.ui.rtextarea.RTextScrollPane;

import frsl.constant.Constant;
import frsl.gui.FRSLSpecificationTextEditor;
import frsl.metamodel.Model;
import frsl.metamodel.UseCase;
import frsl.util.IOUtil;

public class BehavioralDiagramPluginEditor extends JPanel {
	private static final long serialVersionUID = 1L;

	private UseCase usecase;
	private CustomRSyntaxArea textArea;
	private JToolBar toolBar;
	private JSplitPane mainSplitPane;
	private JSplitPane leftSplitPane;
	private JSplitPane rightSplitPane;

	public BehavioralDiagramPluginEditor(UseCase usecase) {
		this.usecase = usecase;
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(1100, 500));


		
		
		
		Model model = new Model(usecase);
		
		Extractor extractor = new Extractor(usecase, model);
		extractor.extractAdditionalInfo();
//		extractor.generateRenderInfo();
		
		
		
		textArea = new CustomRSyntaxArea(model);
//		String frslSpecificationText = loadFromFile(getResultFilePath());
		String frslSpecificationText = FRSLSpecificationTextEditor.getFrslSpecificationText();
		if (frslSpecificationText == null) {
			JOptionPane.showMessageDialog(null, "Can't read file");
		} else {
			textArea.setText(frslSpecificationText);
		}
		RTextScrollPane sp = new RTextScrollPane(textArea);
		
		
		SequencePlantUMLEditor sequenceEditor = new SequencePlantUMLEditor(Constant.FILE_OUTPUT);
		ActivityPlantUMLEditor activityEditor = new ActivityPlantUMLEditor(Constant.FILE_OUTPUT, usecase);
		DomainViewer domainViewer = new DomainViewer();
		model.registerObserver(domainViewer);
		model.registerObserver(sequenceEditor);
		model.registerObserver(activityEditor);
		
//		activityEditor.update(model);
		
		leftSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, sp, domainViewer);
		leftSplitPane.setDividerLocation(250);
		rightSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, activityEditor, sequenceEditor);
		rightSplitPane.setDividerLocation(250);
		
		
		mainSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftSplitPane, rightSplitPane);
		mainSplitPane.setDividerLocation(550);
		add(mainSplitPane);
		
		
		for(DocumentRange dRange: textArea.getMarkAllHighlightRanges()) {
			System.out.println(String.format("%d %d", dRange.getStartOffset(), dRange.getEndOffset()));
		}

//		toolBar = new JToolBar();
//		GuiUtil.addToToolBar(toolBar, new ViewSequenceDiagramAction(), "view sequence diagram in java",
//				"View generated sequence diagram");
//		add(toolBar, BorderLayout.PAGE_START);
	}

	public void updateTextArea() {
		String frslSpecificationText = FRSLSpecificationTextEditor.getFrslSpecificationText();
		if (frslSpecificationText == null) {
			JOptionPane.showMessageDialog(null, "Can't read file");
		} else {
			textArea.setText(frslSpecificationText);
		}
	}
	
	public String getResultFilePath() {
		String resultFileName = "activity_diagram.html";
		return System.getProperty("user.dir") + "\\public\\activity_diagram_result\\" + resultFileName;
	}

	public String loadFromFile(String filePath) {
		return IOUtil.readFile(filePath);
	}
}

class ViewSequenceDiagramAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

	@Override
	public void actionPerformed(ActionEvent evt) {
		
	}
}