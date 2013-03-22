package itemselectionwithflowermenu;

import fr.inria.insitu.touchstone.run.Platform;
import java.awt.event.InputEvent;
import javax.swing.Timer;
import fr.inria.insitu.touchstone.run.input.AxesEvent;
import com.illposed.osc.OSCMessage;
/**
 *
 * @touchstone.criterion RightItemSelected
 */
public class RightItemSelected extends fr.inria.insitu.touchstone.run.endConditions.AbstractEndCondition {
	public RightItemSelected() {
		super();
	}
	public String getEndCondition() {
		// TODO define here the message that you want to be logged when this condition is reached
		return null;
	}
	public boolean isReached(Timer timer, long when) {
		// This method is called each time a timer which is registered in the Platform expires
		return false;
	}
	public boolean isReached(InputEvent e) {
		// This method is called each time an event occurs on a graphical component that is registered in the Platform
		return false;
	}
	public boolean isReached(AxesEvent e) {
		// This method is called each time an axis which is listened by the Platform changes
		return false;
	}
	public boolean isReached(OSCMessage message, long when) {
		// This method is called each time the Platform receives an OSC message
		return false;
	}
	public void start() {
		// This method is called when this criterion is attached to an experiment component
	}
	public void stop() {
		// This method is called when this criterion is detached to an experiment component
	}
}
