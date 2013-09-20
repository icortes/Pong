package pong;

import jgame.Context;
import jgame.GObject;
import jgame.GSprite;
import jgame.ImageCache;
import jgame.controller.ControlScheme;
import jgame.controller.KeyboardLocationController;
import jgame.listener.ParentBoundsListener;

public class PongPaddle extends GSprite {
	public PongPaddle(ControlScheme cs) {
		super(ImageCache.forClass(Pong.class).get("paddle.png"));
		// Create a keyboard movement controller.
		KeyboardLocationController klc = new KeyboardLocationController(cs, 10);

		// Add the new controller.
		addController(klc);
		// Disable horizontal movement.
		klc.setHorizontalAllowed(false);
		// Disallow movement out of bounds.
		ParentBoundsListener limiter = new ParentBoundsListener() {
			@Override
			public void invoke(GObject target, Context context) {
				// Get the parent's center height.
				double parentHeight = getParent().getHeight();

				// Get our y position.
				double y = getY();

				// Get our height, adjusting for scale.
				double h = getHeight() * getScaleY();

				// Compare.
				if (y > parentHeight / 2) {
					// We're in the lower half.
					setY(parentHeight - h / 2);
				} else {
					// We're in the upper half.
					setY(h / 2);
				}
			}
		};

		// Vertical only.
		limiter.setValidateHorizontal(false);

		// Add the listener.
		addListener(limiter);
	}
}
// Jenny you mean short girl :3.
