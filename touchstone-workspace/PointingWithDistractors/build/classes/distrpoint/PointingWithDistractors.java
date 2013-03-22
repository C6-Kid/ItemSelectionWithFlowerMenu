package distrpoint;

import java.awt.Color;
import java.awt.Point;

import fr.inria.insitu.touchstone.run.*;
import fr.inria.insitu.touchstone.run.Platform.EndCondition;
import fr.inria.insitu.touchstone.run.exp.model.Experiment;
import fr.lri.swingstates.canvas.CExtensionalTag;
import fr.lri.swingstates.canvas.Canvas;

/**
 *
 * @touchstone.block PointingWithDistractors
 */
public class PointingWithDistractors extends fr.inria.insitu.touchstone.run.exp.model.Block {
	protected Point sceneCenter;
	protected Point[] targetLocations;
	protected Canvas graphicalScene;
	protected CExtensionalTag targetTag = new CExtensionalTag() { };
	protected CExtensionalTag distractorTag = new CExtensionalTag() { };
	
	public PointingWithDistractors() {
		super();
		graphicalScene = ((SwingStatesSetUp)(Platform.getExperiment().getSetUp())).getGraphicalScene();
	}
	
	public void beginBlock() {
		// compute target locations for this block
		Integer nbTrials = (Integer)Platform.getInstance().getMeasureValue(Experiment.MEASURE_EXPERIMENT_NB_TRIAL);
		int amplitude = Platform.getInstance().getFactor("A").getIntValue(); // amplitude
		sceneCenter = new Point(
    			(int)graphicalScene.getPreferredSize().getWidth() / 2,
    			(int)graphicalScene.getPreferredSize().getHeight() / 2);
    	double stepAngle = 2*Math.PI / nbTrials;
    	targetLocations = new Point[nbTrials+1];
    	double angle = -stepAngle;
    	for (int i = 0; i <= nbTrials; i++) {
    		if(i%2 == 0) {
    			angle += (Math.PI + stepAngle);
    		} else {
    			angle += Math.PI;
    		}
    		targetLocations[i] = new Point(
			(int)(sceneCenter.x + amplitude/2*Math.cos(angle)),
			(int)(sceneCenter.y + amplitude/2*Math.sin(angle)));
		}
	}
	
	public void beginTrial() { 
		Integer numTrial = Platform.getInstance().getMeasure(Experiment.MEASURE_EXPERIMENT_TRIAL).getIntValue();
//    	DistractorGenerator.A = ((Integer)Platform.getInstance().getFactorValue("A")).intValue(); // amplitude
//    	DistractorGenerator.W = ((Integer)Platform.getInstance().getFactorValue("W")).intValue(); // width
		DistractorGenerator.A = (Integer)Platform.getInstance().getFactorValue("A");
    	DistractorGenerator.W = (Integer)Platform.getInstance().getFactorValue("W");
    	
    	// DistractorGenerator.D = Float.parseFloat(Platform.getInstance().getFactorValue("D").toString()); // density
		String density = Platform.getInstance().getFactorValue("D").toString(); // density
		if(density.equals("low")) DistractorGenerator.D = 0.0f;
		else if(density.equals("medium")) DistractorGenerator.D = 0.5f;
		else if(density.equals("high")) DistractorGenerator.D = 1.0f;
    	DistractorGenerator.InS = 10;
    	
    	Point lastTargetLocation = targetLocations[numTrial-1];
    	Point currentTargetLocation = targetLocations[numTrial];
    	DistractorGenerator.translate = new Point(lastTargetLocation.x, lastTargetLocation.y);
    	double hyp = lastTargetLocation.distance(currentTargetLocation);
    	DistractorGenerator.A = (int)hyp; // because laying out targets around a circle as ISO recommends does not ensure the exact amplitude for each trial
    	double adj = currentTargetLocation.x - lastTargetLocation.x;
    	DistractorGenerator.direction = (float)Math.acos(adj/hyp);
    	if(currentTargetLocation.y < lastTargetLocation.y)
    		DistractorGenerator.direction = -DistractorGenerator.direction;
    	Point[] points = DistractorGenerator.generate();
    	
    	// display distractors
    	for (int j = 0; j < points.length; j++) {
    		// j == 0 --> starting point
    		// j == 1 --> target
    		if(j > 1)
    			graphicalScene.newEllipse(points[j].x - DistractorGenerator.W/2, points[j].y - DistractorGenerator.W/2, DistractorGenerator.W, DistractorGenerator.W).setFillPaint(Color.YELLOW).addTag(distractorTag);
    	}
    	// display target
    	graphicalScene.newEllipse(currentTargetLocation.x - DistractorGenerator.W/2, currentTargetLocation.y - DistractorGenerator.W/2, DistractorGenerator.W, DistractorGenerator.W).setFillPaint(Color.RED).addTag(targetTag);
	}
	
	public void endTrial(EndCondition ec) {
		graphicalScene.removeShapes(distractorTag);
		graphicalScene.removeShapes(targetTag);
	}
	
	public void endBlock() { }

	public CExtensionalTag getTargetTag() {
		return targetTag;
	}

	public void setTargetTag(CExtensionalTag targetTag) {
		this.targetTag = targetTag;
	}
}
