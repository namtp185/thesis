package frsl.runtime;

import java.util.Vector;

/**
 * The Plugin Model providing all Plugin meta information in the Application.
 */
public class PluginModel {

	private String id = null;
	private String name = null;
	private String version = null;
	private String pluginClass = null;
	private String publisher = null;

	private Vector<PluginActionModel> actions = null;

	/**
	 * Method to get the Plugin Action information
	 */
	public Vector<PluginActionModel> getActions() {
		if (this.actions == null) {
			this.actions = new Vector<PluginActionModel>();
		}
		return this.actions;
	}

	/**
	 * Method to get the Plugin's id.
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * Method to get the Plugin's name.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Method to get the Plugin's class name
	 */
	public String getPluginClass() {
		return this.pluginClass;
	}

	/**
	 * Method to get the Plugin's publisher name
	 */
	public String getPublisher() {
		return this.publisher;
	}

	public String getVersion() {
		return version;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Method to set the Plugin's Class name.
	 */
	public void setPluginClass(String pluginClass) {
		this.pluginClass = pluginClass;
	}

	/**
	 * Method to set the Plugin's publisher name.
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	/**
	 * Method to set the Plugin's Version.
	 */
	public void setVersion(String version) {
		this.version = version;
	}
}
