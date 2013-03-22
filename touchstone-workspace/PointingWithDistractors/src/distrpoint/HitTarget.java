package distrpoint;

import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

import javax.swing.Timer;

import fr.inria.insitu.touchstone.run.Platform;
import fr.inria.insitu.touchstone.run.endConditions.PressCondition;
import fr.inria.insitu.touchstone.run.input.AxesEvent;
import fr.lri.swingstates.canvas.CShape;
import fr.lri.swingstates.canvas.CTag;
import fr.lri.swingstates.canvas.Canvas;

/**
 *
 * @touchstone.criterion HitTarget
 */
public class HitTarget extends fr.inria.insitu.touchstone.run.endConditions.AbstractEndCondition {
	protected Canvas graphicalScene;
	
	public HitTarget() {
		super();
		SwingStatesSetUp setup = (SwingStatesSetUp)(Platform.getExperiment().getSetUp());
		graphicalScene = setup.getGraphicalScene();
	}
	
	public String getEndCondition() { return "Hit target"; }
	
	public boolean isReached(InputEvent e) {
		return e.getID() == MouseEvent.MOUSE_PRESSED 
		&& ((MouseEvent)e).getButton() == MouseEvent.BUTTON1 
		&& hitTarget();
	}
	
	public boolean hitTarget() {
		Double x = (Double)Platform.getInstance().getMeasureValue("Mouse.x");
		Double y = (Double)Platform.getInstance().getMeasureValue("Mouse.y");
		CShape picked = graphicalScene.pick(new Point2D.Double(x, y));
		if(picked == null) {
			Platform.getInstance().getMeasure("HitBG").incr(1);
			return false;
		} else {
			PointingWithDistractors block = (PointingWithDistractors)(Platform.getExperiment().getCurrentBlock());
			CTag t = block.getTargetTag();
			boolean target = picked.hasTag(t);
			if(!target) Platform.getInstance().getMeasure("HitDistractor").incr(1);
			return target;
		}
	}
}
