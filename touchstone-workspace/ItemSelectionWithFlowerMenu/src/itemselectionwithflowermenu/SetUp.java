package itemselectionwithflowermenu;

import fr.inria.insitu.touchstone.run.*;
/**
 * @touchstone.measure NoviceModeInvoked
 * 	id: NoviceModeInvoked
 * 	name: Number of times the novice mode is invoked
 * 	help: null
 * 	type: Integer

 *
 * @touchstone.intertitle SetUp
 */
public class SetUp extends fr.inria.insitu.touchstone.run.exp.model.Intertitle {
	public SetUp() {
		super();
		Platform.getInstance().addIntegerMeasure("NoviceModeInvoked");
		// TODO do not forget to register the graphical component that must be tracked 
		// with Platform.getInstance().registerComponent(componentToTrack).
		// This makes the platform able to update the values of Mouse.* and Keyboard.* measures
		// and evaluates the current criterion each time an input event occurs on this component.
	}
	public void beginIntertitle() { }
	public void endIntertitle() { }
}
