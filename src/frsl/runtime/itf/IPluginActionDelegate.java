package frsl.runtime.itf;

/**
 * This interface provides the Plugin Action's behaviour implemented by the
 * Plugin. - This interface should be implemented by any Plugin providing
 * Actions.
 */
public interface IPluginActionDelegate {

	/**
	 * Method to execute the Plugin's Action with the given Plugin Action.
	 */
	public void performAction(IPluginAction pluginAction);
}
