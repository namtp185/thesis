package frsl.runtime;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import frsl.runtime.itf.IExtensionPoint;
import frsl.runtime.itf.IPluginDescriptor;
import frsl.runtime.itf.IPluginRuntime;

public class PluginRuntime implements IPluginRuntime {

	private static IPluginRuntime instance = new PluginRuntime();

	/**
	 * Method returning the Singleton instance of the PluginRuntime
	 */
	public static IPluginRuntime getInstance() {
		return instance;
	}

	private Map<String, IPluginDescriptor> registeredPlugins = new HashMap<String, IPluginDescriptor>();

	public IExtensionPoint getExtensionPoint(String extensionPoint) {
		if (extensionPoint.equals("action")) {
			return ActionExtensionPoint.getInstance();
		} else
			return null;
	}

	/**
	 * Method to get a Plugin by it's name.
	 */
	public IPluginDescriptor getPlugin(String pluginName) {
		return this.registeredPlugins.get(pluginName);
	}

	public Map<String, IPluginDescriptor> getPlugins() {
		return this.registeredPlugins;
	}

	public void registerPlugin(String pluginFilename, URL pluginURL) {
		URL newPluginURL;
		try {
			newPluginURL = new URL(pluginURL + pluginFilename);
			PluginRegistry pluginRegistry = PluginRegistry.getInstance();
			IPluginDescriptor currentPluginDescriptor = pluginRegistry.registerPlugin(newPluginURL);
			if (currentPluginDescriptor == null) {
				return;
			}

			IPluginDescriptor otherPlugin = getPlugin(currentPluginDescriptor.getPluginModel().getName());
			if (otherPlugin != null) {
				return;
			}

			getPlugins().put(currentPluginDescriptor.getPluginModel().getName(), currentPluginDescriptor);
		} catch (MalformedURLException mfurle) {
//			Log.error("No valid URL given to register plugin: " + mfurle);
		}
	}
}
