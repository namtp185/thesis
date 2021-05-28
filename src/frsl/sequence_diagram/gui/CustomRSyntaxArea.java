package frsl.sequence_diagram.gui;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;

import frsl.constant.StringProcess;
import frsl.metamodel.Actor;
import frsl.metamodel.Entity;
import frsl.metamodel.Model;

public class CustomRSyntaxArea extends RSyntaxTextArea {
	private static final long serialVersionUID = 1L;
	
	
	private JMenu markerMenu;
	private JMenuItem markAsSubject;
	private JMenuItem markAsObject;
	private JMenuItem markAsActor;
	
	Model model;
	String selectionTmp;
	
	public CustomRSyntaxArea(Model model) {
		this.model = model;
	}
	
	@Override
	protected JPopupMenu createPopupMenu() {
		JPopupMenu menu = super.createPopupMenu();
		menu.addSeparator();
		appendMarkerMenu(menu);
		return menu;
	}
	
	@Override
	protected RTAMouseListener createMouseListener() {
		return new CustomRTAMouseListener(this);
	}
	
	// https://stackoverflow.com/a/15859323/14264970
	protected class CustomRTAMouseListener extends RTextAreaMutableCaretEvent {
		
		private static final long serialVersionUID = 1L;
		
		public CustomRTAMouseListener(CustomRSyntaxArea textArea) {
			super(textArea);
		}
		
		@Override
		public void mouseReleased(MouseEvent e) {
			super.mouseReleased(e);
		    if (getSelectedText() != null) { // See if they selected something 
		        selectionTmp = getSelectedText();
		    }
		}
	}
	
	
	
	protected void appendMarkerMenu(JPopupMenu popup) {
		markerMenu = new JMenu("Mark");
		
		AbstractAction markAsObjectAction = new MarkTextAction(this, ActionType.OBJECT);
		markAsObjectAction.putValue("Name", "Mark as an object");
		
		AbstractAction markAsActorAction = new MarkTextAction(this, ActionType.ACTOR);
		markAsActorAction.putValue("Name", "Mark as an actor");
		
		markerMenu.add(createPopupMenuItem(markAsObjectAction));
		markerMenu.add(createPopupMenuItem(markAsActorAction));		
		
		popup.add(markerMenu);
		
		
	}
	
	protected JMenuItem createPopupMenuItem(String name, Action a) {
		JMenuItem item2 = new JMenuItem(name);
		item2.setAction(a);
		item2.setAccelerator(null);
		return item2;
	}
	
	protected JMenuItem createPopupMenuItem(Action a) {
		JMenuItem item = new JMenuItem();
		item.setAction(a);
		return item;
	}
}

class MarkTextAction extends AbstractAction {
	private static final long serialVersionUID = 1L;
	
	private String actionType;
	private CustomRSyntaxArea textArea;
	
	public MarkTextAction(CustomRSyntaxArea textArea, String actionType) {
		this.actionType = actionType;
		this.textArea = textArea;
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		String selected = StringProcess.processString(textArea.selectionTmp);
		switch(actionType) {
		case ActionType.OBJECT:
	        textArea.model.addEntity(new Entity(selected));
			break;
		case ActionType.ACTOR:
			textArea.model.addActor(new Actor(selected));
			break;
		}
	}
}

class ActionType {
	public static final String OBJECT = "object";
	public static final String ACTOR = "actor";
}
