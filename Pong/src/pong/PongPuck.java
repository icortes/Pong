package pong;

import jgame.Context;
import jgame.GObject;
import jgame.GSprite;
import jgame.ImageCache;
import jgame.controller.ConstantMovementController;
import jgame.listener.BoundaryRemovalListener;
import jgame.listener.HitTestListener;

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
		add(puck);

		// Center the puck.
		snapChild(puck);
		// Remove the puck when it's outside the game bounds.
		addListener(new BoundaryRemovalListener());
		// inside the constructor

		HitTestListener htl = new HitTestListener(PongPaddle.class) {

			@Override
			public void invoke(GObject target, Context context) {
				flip();

			}
		};
		// Add the listener.
		addListener(htl);
		// Set the primitive shape to a circle.
		setPrimitive(PrimitiveShape.CIRCLE);
	}

	/**
	 * Flips this puck's movement parallel to the x-axis.
	 */
	public void flip() {
		// Set the x velocity to the opposite of the current value.
		cmc.setVelocityX(-cmc.getVelocityX());

	}
}
