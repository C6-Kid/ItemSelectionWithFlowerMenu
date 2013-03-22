package distrpoint;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import fr.inria.insitu.touchstone.run.*;
import fr.lri.swingstates.canvas.Canvas;

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
	
	protected Canvas graphicalScene;
	
	public SwingStatesSetUp() {
		super();
		Platform.getInstance().addIntegerMeasure("HitDistractor");
		Platform.getInstance().addIntegerMeasure("HitBG");
		// TODO do not forget to register the graphical component that must be tracked 
		// with Platform.getInstance().registerComponent(componentToTrack).
		// This makes the platform able to update the values of Mouse.* and Keyboard.* measures
		// and evaluates the current criterion each time an input event occurs on this component.
	}
	
	public void beginIntertitle() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		graphicalScene = new Canvas((int)screenSize.getWidth(), (int)screenSize.getHeight());
		Platform.getInstance().registerComponent(graphicalScene);
		JFrame mainFrame = new JFrame("Experiment");
		mainFrame.getContentPane().add(graphicalScene);
		mainFrame.pack();
		mainFrame.setVisible(true);
		mainFrame.requestFocus(); 
	}
	
	public void endIntertitle() { }
	
	public Canvas getGraphicalScene() {
		return graphicalScene;
	}
	
	public void setGraphicalScene(Canvas graphicalScene) {
		this.graphicalScene = graphicalScene;
	}
}
