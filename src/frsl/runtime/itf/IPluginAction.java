package frsl.runtime.itf;

import java.awt.event.ActionEvent;

import frsl.gui.MainWindow;

/**
 * This interface provides the Plugin Action Proxy's behaviour. - This interface
 * should only be used internally
 */
public interface IPluginAction {

	/**
	 * Method to execute the Plugin Action
	 */
	public void actionPerformed(ActionEvent event);

	/**
	 * Method to get the application's MainWindow object
	 */
	public MainWindow getParent();
}
