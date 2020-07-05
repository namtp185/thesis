package frsl.runtime.itf;

import java.net.URL;

import frsl.runtime.PluginModel;

/**
 * This interface provides the Plugin Descriptor's behaviour. - This interface
 * should only be used internally
 */
public interface IPluginDescriptor extends IDescriptor {

	/**
	 * Method to get the Plugin's startup class
	 */
	public IPlugin getPluginClass();

	/**
	 * Method to get the Plugin's ClassLoader
	 */
	public IPluginClassLoader getPluginClassLoader();

	/**
	 * Method to get the Plugin's path as URL.
	 * 
	 * @return The Plugin's path
	 */
	public URL getPluginLocation();

	/**
	 * Method to get the Plugin's Model object
	 */
	public PluginModel getPluginModel();
}
