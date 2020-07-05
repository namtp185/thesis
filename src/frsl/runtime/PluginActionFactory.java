package frsl.runtime;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import frsl.gui.MainWindow;
import frsl.runtime.itf.IPluginActionDescriptor;


/**
 * This class provides the Plugin Action Proxy Factory to create Plugin Action Proxies.
 */

public class PluginActionFactory {

	private static PluginActionFactory instance = new PluginActionFactory();

	/**
	 * Method returning the Singleton instance of the PluginActionFactory
	 */
	public static PluginActionFactory getInstance() {
		return instance;
	}

	private PluginActionFactory() {
	}

	/**
	 * Method to create the Plugin Action Proxies.
	 */
	public Map<Map<String, String>, PluginActionProxy> createPluginActions(Vector<IPluginActionDescriptor> actions,
			MainWindow mainWindow) {

		Map<Map<String, String>, PluginActionProxy> actionsMap = new HashMap<Map<String, String>, PluginActionProxy>();

		for (IPluginActionDescriptor currentActionDescriptor : actions) {
			Map<String, String> currentActionDescMap = new HashMap<String, String>();
			
			PluginActionModel currentActionModel = currentActionDescriptor.getPluginActionModel();
			
			currentActionDescMap.put("menu", currentActionModel.getMenu());
			currentActionDescMap
					.put("tooltip", currentActionModel.getTooltip());
			currentActionDescMap.put("menuitem", currentActionModel
					.getMenuitem());
			currentActionDescMap.put("toolbaritem", currentActionModel
					.getToolbaritem());
			actionsMap.put(currentActionDescMap, new PluginActionProxy(
					currentActionDescriptor, mainWindow));
		}
		
		return actionsMap;
	}
}
