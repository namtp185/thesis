package frsl.runtime;

import java.nio.file.Path;
import java.nio.file.Paths;

import frsl.runtime.itf.IRuntime;

public class RuntimeUtil {
	public static IRuntime loadPlugin() {
		IRuntime pluginRuntime = null;
		Path pluginDirURL = Paths.get("./plugins/");
		Log.verbose("Plugin path: [" + pluginDirURL + "]");
		try {
			pluginRuntime = (IRuntime) MainPluginRuntime.run(pluginDirURL);
			Log.debug("Starting plugin runtime, got class [" + pluginRuntime.getClass() + "]");
		} catch (Exception e) {
			e.printStackTrace();
			Log.error("FATAL ERROR.");
			System.exit(1);
		}
		return pluginRuntime;
	}
}
