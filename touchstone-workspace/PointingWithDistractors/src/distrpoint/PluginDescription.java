package distrpoint;

import java.util.Properties;
import fr.inria.insitu.touchstone.run.*;
import fr.inria.insitu.touchstone.run.input.Axes;
public class PluginDescription implements Plugin {
	private static final Properties PROPERTIES = new Properties();
	static {
		PROPERTIES.setProperty(PROPERTY_NAME, "distrpoint");
		PROPERTIES.setProperty(PROPERTY_AUTHOR, "caroline appert");
		PROPERTIES.setProperty(PROPERTY_URL, "XXXExperiment urlXXX");
		PROPERTIES.setProperty(PROPERTY_DESCRIPTION, "measures pointing performance when there are distractors on the trajectory.");
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
