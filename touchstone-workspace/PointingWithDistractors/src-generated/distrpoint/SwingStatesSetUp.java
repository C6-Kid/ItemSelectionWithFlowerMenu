package distrpoint;

import fr.inria.insitu.touchstone.run.*;
/**
 * @touchstone.measure HitDistractor
 * 	id: HitDistractor
 * 	name: Press on distractor
 * 	help: null
 * 	type: Integer

 * @touchstone.measure HitBG
 * 	id: HitBG
 * 	name: Press on background
 * 	help: null
 * 	type: Integer

 *
 * @touchstone.intertitle SwingStatesSetUp
 */
public class SwingStatesSetUp extends fr.inria.insitu.touchstone.run.exp.model.Intertitle {
	public SwingStatesSetUp() {
		super();
		Platform.getInstance().addIntegerMeasure("HitDistractor");
		Platform.getInstance().addIntegerMeasure("HitBG");
		// TODO do not forget to register the graphical component that must be tracked 
		// with Platform.getInstance().registerComponent(componentToTrack).
		// This makes the platform able to update the values of Mouse.* and Keyboard.* measures
		// and evaluates the current criterion each time an input event occurs on this component.
	}
	public void beginIntertitle() { }
	public void endIntertitle() { }
}
