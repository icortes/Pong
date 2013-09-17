package pong;

import jgame.GSprite;
import jgame.ImageCache;
import jgame.controller.ConstantMovementController;
import jgame.listener.BoundaryRemovalListener;

/**
 * The controller that causes the puck to move.
 */
public class PongPuck extends GSprite {
	private ConstantMovementController cmc;

	public PongPuck() {
		// Get the image cache, get the image, and call the super constructor.
		super(ImageCache.forClass(Pong.class).get("puck.png"));
		// Create the controller.
		cmc = new ConstantMovementController(-5, 0);

		// Add the controller.
		addController(cmc);
		// Create a puck.
		PongPuck puck = new PongPuck();

		// Add the puck.
		addAtCenter(puck);
		// Remove the puck when it's outside the game bounds.
		addListener(new BoundaryRemovalListener());
	}
}
