package frsl.gui;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JToolBar;

public class GuiUtil {
	
	public static JButton addToToolBar(JToolBar toolBar, AbstractAction action, String toolTip, String label) {
		JButton button = toolBar.add(action);
		if (toolTip != null) {
			button.setToolTipText(toolTip);
		}
		if (label == null) {
			button.setText(toolTip);
		} else {
			button.setText(label);
		}
		button.setIcon(null);
		return button;
	}
	
}
