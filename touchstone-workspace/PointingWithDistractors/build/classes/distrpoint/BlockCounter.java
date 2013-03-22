package distrpoint;

import java.awt.Font;
import fr.lri.swingstates.canvas.Canvas;

import fr.inria.insitu.touchstone.run.Platform;
import fr.inria.insitu.touchstone.run.exp.model.Experiment;

/**
 *
 * @touchstone.intertitle BlockCounter
 */
public class BlockCounter extends fr.inria.insitu.touchstone.run.exp.model.Intertitle {
	
	protected Canvas graphicalScene;
	
	protected static Font font = new Font("Verdana", Font.BOLD, 24);
    
	public BlockCounter() {
		super();
		graphicalScene = ((SwingStatesSetUp)(Platform.getExperiment().getSetUp())).getGraphicalScene();
	}

	public void beginIntertitle() {
		Integer nbBlocks = (Integer)Platform.getInstance().getMeasureValue(Experiment.MEASURE_EXPERIMENT_NB_BLOCK);
		Integer block = (Integer)Platform.getInstance().getMeasureValue(Experiment.MEASURE_EXPERIMENT_BLOCK);
		graphicalScene.newText(0, 0, "Press Space to begin a new block ("+block+"/"+nbBlocks+")", font)
		.setReferencePoint(0.5, 0.5)
		.translateTo(graphicalScene.getWidth()/2, graphicalScene.getHeight()/2-20);
		String sentence1 = "Press on red target as fast as possible.";
		graphicalScene.newText(0, 0, sentence1, font)
		.setReferencePoint(0.5, 0.5)
		.translateTo(graphicalScene.getWidth()/2, graphicalScene.getHeight()/2+20);
		graphicalScene.requestFocus();
	}

	public void endIntertitle() {
		graphicalScene.removeAllShapes();
	}
	
}
