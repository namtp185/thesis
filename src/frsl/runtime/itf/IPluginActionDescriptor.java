package frsl.runtime.itf;

import frsl.runtime.PluginActionModel;

/**
 * This interface provides the Plugin Action Descriptor's behaviour. - This
 * interface should only be used internally
 */
public interface IPluginActionDescriptor {

	/**
	 * Method to get the Plugin's Action class
	 */
	public IPluginActionDelegate getActionClass();

	/**
	 * Method to get the Plugin Descriptor.
	 */
	public IPluginDescriptor getParent();

	/**
	 * Method to get the Plugin Action's Model object
	 */
	public PluginActionModel getPluginActionModel();
}
