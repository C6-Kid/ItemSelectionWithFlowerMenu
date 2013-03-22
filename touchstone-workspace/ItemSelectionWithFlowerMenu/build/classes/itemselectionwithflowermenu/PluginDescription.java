package itemselectionwithflowermenu;

import java.util.Properties;
import fr.inria.insitu.touchstone.run.*;
import fr.inria.insitu.touchstone.run.input.Axes;
public class PluginDescription implements Plugin {
	private static final Properties PROPERTIES = new Properties();
	static {
		PROPERTIES.setProperty(PROPERTY_NAME, "itemselectionwithflowermenu");
		PROPERTIES.setProperty(PROPERTY_AUTHOR, "hantang liu and shaiful alam");
		PROPERTIES.setProperty(PROPERTY_URL, "XXXExperiment urlXXX");
		PROPERTIES.setProperty(PROPERTY_DESCRIPTION, "ask participants to perform the selection tasks without invoking the novice mode.if they do it we will give score 1 to them and maximize it to encourage participants.if they invoke the novice mode then they will get 0.   the participants will do the same task in grouping flower menus and original flower menus. in this way we can cpmpare which menu is better.");
	}

	public static void main(String[] args) {
		LaunchExperiment.main(args);
	}

	public String getName() {
		return (String)PROPERTIES.get(PROPERTY_NAME);
	}

	public Properties getProperties() {
		return PROPERTIES;
	}

	public Axes getAxes() {
		return null;
	}

	public void install(Platform platform) { }

	public void desinstall(Platform platform) { }

}
