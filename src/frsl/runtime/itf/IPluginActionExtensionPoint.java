package frsl.runtime.itf;

import java.util.Map;

import frsl.gui.MainWindow;
import frsl.runtime.PluginActionProxy;

/**
 * This interface provides the behaviour of the Plugin Action Extension Point.
 */
public interface IPluginActionExtensionPoint extends IExtensionPoint {

	/**
	 * Method to register Plugin Actions from the given Plugin Descriptor
	 */
	void registerActions(IDescriptor pluginDescriptor);

	/**
	 * Method to create Plugin Action Proxies for the current application's state.
	 */
	Map<Map<String, String>, PluginActionProxy> createPluginActions(MainWindow mainWindow);

}
