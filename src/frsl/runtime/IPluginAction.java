package frsl.runtime;

import java.awt.event.ActionEvent;

import frsl.gui.MainWindow;


/**
 * This interface provides the Plugin Action Proxy's behaviour. - This interface
 * should only be used internally
 * 
 * @author Roman Asendorf
 */
public interface IPluginAction {

	/**
	 * Method to execute the Plugin Action
	 * 
	 * @param event
	 *            The ActionEvent
	 */
	public void actionPerformed(ActionEvent event);

	/**
	 * Method to get the application's MainWindow object
	 * 
	 * @return The MainWindow object
	 */
	public MainWindow getParent();
}
