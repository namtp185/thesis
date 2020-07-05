package frsl.runtime;

import java.util.Map;
import java.util.Vector;

import frsl.gui.MainWindow;
import frsl.runtime.itf.IDescriptor;
import frsl.runtime.itf.IPluginActionDescriptor;
import frsl.runtime.itf.IPluginActionExtensionPoint;
import frsl.runtime.itf.IPluginDescriptor;


/**
 * This class provides the implementation of the Action Extension Point.The
 * referenced interface should be located in the application elsewhere.
 */
public class ActionExtensionPoint implements IPluginActionExtensionPoint {

	private static ActionExtensionPoint instance = new ActionExtensionPoint();

	/**
	 * Method returning the Singleton instance of the ActionExtensionPoint
	 */
	public static IPluginActionExtensionPoint getInstance() {
		return instance;
	}

	private ActionExtensionPoint() {
	}

	private Vector<IPluginActionDescriptor> registeredActions;

	public Map<Map<String, String>, PluginActionProxy> createPluginActions(MainWindow mainWindow) {
		PluginActionFactory actionFactory = PluginActionFactory.getInstance();
		return actionFactory.createPluginActions(getPluginActions(),
				mainWindow);
	}

	private Vector<IPluginActionDescriptor> getPluginActions() {
		if (this.registeredActions == null) {
			this.registeredActions = new Vector<IPluginActionDescriptor>();
		}
		return this.registeredActions;
	}

	private void registerAction(IPluginActionDescriptor pluginActionDescriptor) {
		getPluginActions().add(pluginActionDescriptor);
	}

	public void registerActions(IDescriptor pluginDescriptor) {
		ActionRegistry actionRegistry = ActionRegistry.getInstance();

		IPluginDescriptor currentPluginDescriptor = (IPluginDescriptor) pluginDescriptor;

		Vector<PluginActionModel> pluginActions = currentPluginDescriptor.getPluginModel().getActions();

		for (int cntPluginActions = 0; cntPluginActions < pluginActions.size();) {
			PluginActionModel currentPluginActionModel = pluginActions.get(cntPluginActions);
			IPluginActionDescriptor currentPluginActionDescriptor = actionRegistry
					.registerPluginAction(currentPluginDescriptor,
							currentPluginActionModel);

			registerAction(currentPluginActionDescriptor);
			cntPluginActions++;
		}
	}
}
