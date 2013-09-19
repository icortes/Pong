package pong;

import java.util.List;

import jgame.Context;
import jgame.GObject;
import jgame.GSprite;
import jgame.ImageCache;
import jgame.controller.ConstantMovementController;
import jgame.listener.BoundaryRemovalListener;
import jgame.listener.HitTestListener;
import jgame.listener.ParentBoundsListener;

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
		// Remove the puck when it's outside the game bounds.
		addListener(new BoundaryRemovalListener());
		// inside the constructor

		HitTestListener htl = new HitTestListener(PongPaddle.class) {

			@Override
			public void invoke(GObject target, Context context) {
				flip();
				// Get a list of all paddles hit.
				List<PongPaddle> paddlesHit = context
						.hitTestClass(PongPaddle.class);
				// Get the relevant paddle.
			    // Get the vertical distance between the centers.
			    double offset = getY() - paddlesHit.get(0).getY();

			    // Move vertically.
			    cmc.setVelocityY(cmc.getVelocityY() + offset * 0.1);
			}

		};
		// Add the listener.
		addListener(htl);
		// Set the primitive shape to a circle.
		setPrimitive(PrimitiveShape.CIRCLE);
		// Create the bounce listener.
		ParentBoundsListener bounce = new ParentBoundsListener() {
		    @Override
		    public void invoke(GObject target, Context context) {
		    	// Get the current velocity.
		    	double vx = cmc.getVelocityX();

		    	// Test the sign.
		    	if (vx > 0) {
		    	    vx += 0.01;
		    	} else if (vx < 0) {
		    	    vx -= 0.01;
		    	} else {
		    	    // It's zero; do nothing.
		    	}

		    	// Set the velocity.
		    	cmc.setVelocityX(vx);
		    }
		};

		// Only bounce vertically.
		bounce.setValidateHorizontal(false);

		// Add the bounce listener.
		addListener(bounce);
	}

	/**
	 * Flips this puck's movement parallel to the x-axis.
	 */
	public void flip() {
		// Set the x velocity to the opposite of the current value.
		cmc.setVelocityX(-cmc.getVelocityX());

	}
}
