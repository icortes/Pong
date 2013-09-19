package pong;

import java.util.List;

import jgame.Context;
import jgame.GContainer;
import jgame.GObject;
import jgame.controller.ControlScheme;
import jgame.listener.FrameListener;

public class PongGameView extends GContainer {
	public PongGameView() {
		// Set the size.
		setSize(640, 480);

		// Create a paddle to add.
		PongPaddle paddle = new PongPaddle(ControlScheme.WASD);

		// Add the paddle to the game view.
		add(paddle);
		// Set the paddle's location.
		paddle.setLocation(50, 480 / 2);
		// Create another paddle to add.
		PongPaddle paddle2 = new PongPaddle(ControlScheme.ARROW_KEYS);

		// Add the paddle to the game view.
		add(paddle2);

		// Set the paddle's location.
		paddle2.setLocation(640 - 50, 480 / 2);
		// Create a puck.
		PongPuck puck = new PongPuck();

		// Add the puck.
		add(puck);

		// Center the puck.
		snapChild(puck);
		FrameListener fl = new FrameListener() {

			@Override
			public void invoke(GObject target, Context context) {
				// Get all the pucks.
				List<PongPuck> pucks = context
						.getInstancesOfClass(PongPuck.class);

				// Is it empty?
				boolean noPucksLeft = pucks.isEmpty();
				// Set the current game view.
				if (noPucksLeft == true) {
					context.setCurrentGameView(Pong.Views.GAME_OVER);
				}
			}
		};
		addListener(fl);
	}

}
