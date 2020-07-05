package frsl.runtime;

import java.io.File;
import java.io.FilenameFilter;
import java.net.MalformedURLException;
import java.nio.file.Path;

import frsl.runtime.itf.IPluginActionExtensionPoint;
import frsl.runtime.itf.IPluginDescriptor;
import frsl.runtime.itf.IPluginRuntime;
import frsl.runtime.itf.IRuntime;

/**
 * This is the Plugin Runtime's main class. It will be called from the USE main
 * class if the Plugin Framework is enabled.
 */
public class MainPluginRuntime {

	/**
	 * Jar filename Filter
	 */
	public static class JarFilter implements FilenameFilter {
		public boolean accept(File dir, String name) {
			return (name.endsWith(".jar"));
		}
	}

	/**
	 * Method to get all filename with jar-extension in the given location.
	 */
	private static String[] getJarFileNames(Path pluginDirURL) {

		String[] fileNames = null;
		File pluginDir = pluginDirURL.toFile();
		JarFilter jarFilter = new JarFilter();
		fileNames = pluginDir.list(jarFilter);

		if (fileNames == null) {
			return new String[0];
		}

		StringBuilder verboseMsg = new StringBuilder("Plugin filename(s) [");
		verboseMsg.append("]");
		return fileNames;
	}

	/**
	 * Method to startup the Plugin Runtime using the given location path.
	 */
	public static IRuntime run(Path pluginDirURL) {

		String[] pluginFileNames;
		pluginFileNames = getJarFileNames(pluginDirURL);

		IPluginRuntime pluginRuntime = PluginRuntime.getInstance();
		for (int cntFiles = 0; cntFiles < pluginFileNames.length;) {
			String pluginFilename = pluginFileNames[cntFiles];
			try {
				pluginRuntime.registerPlugin(pluginFilename, pluginDirURL.toUri().toURL());
			} catch (MalformedURLException e) {
				continue;
			}
			cntFiles++;
		}

		IPluginActionExtensionPoint actionExtensionPoint = (IPluginActionExtensionPoint) pluginRuntime
				.getExtensionPoint("action");

		for (IPluginDescriptor currentPluginDescriptor : pluginRuntime.getPlugins().values()) {
			Log.debug("Main: Registering actions");
			actionExtensionPoint.registerActions(currentPluginDescriptor);
		}
		return pluginRuntime;
	}
}
