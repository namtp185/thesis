package frsl.runtime.itf;

import java.io.IOException;

/**
 * This interface provides a common Plugin ClassLoader behaviour for Plugin
 * ClassLoaders. - This interface should only be used internally
 */

public interface IPluginClassLoader {

	/**
	 * Method to get the Plugin's Startup Class name
	 * 
	 */
	String getMainClassName() throws IOException;

	/**
	 * Method to load a specific class from the Plugin
	 */
	Class<?> loadClass(String className) throws ClassNotFoundException;

}
