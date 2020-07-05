package frsl.runtime.itf;

/**
 * This interface provides the basic startup class behaviour for the Plugin's
 * startup classes. - This interface should be implemented by a Plugin class if
 * the Plugin needs startup behaviour.
 */
public interface IPlugin {

	/**
	 * Method to get the Plugin's name
	 */
	String getName();

	/**
	 * Method to execute the startup Class of the Plugin in the actual Plugin
	 */
	void run(IPluginRuntime pluginRuntime) throws Exception;
}
