package frsl.runtime;

import java.net.URL;
import java.util.Map;

/**
 * This interface provides the Plugin Runtime's behaviour. It extends the common
 * IRuntime behaviour. - This interface is also needed to give Plugin startup
 * classes access to the Plugin Framework's functionality.
 * 
 * @author Roman Asendorf
 */
public interface IPluginRuntime extends IRuntime {

	public Map<String, IPluginDescriptor> getPlugins();

	public IPluginDescriptor getPlugin(String pluginName);

	public void registerPlugin(String pluginFilename, URL pluginURL);

}
