package frsl.runtime.itf;

/**
 * Base interface for the Plugin Runtime to connect the Plugin Framework with
 * the application - this interface should only be used internally
 */

public interface IRuntime {

	/**
	 * Method to get a Extension Point by name
	 */
	IExtensionPoint getExtensionPoint(String extensionPoint);

}
