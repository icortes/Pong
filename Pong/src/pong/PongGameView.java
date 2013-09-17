package pong;

import jgame.GContainer;

public class PongGameView extends GContainer {
	public PongGameView() {
		// Set the size.
		setSize(640, 480);

		// Create a paddle to add.
		PongPaddle paddle = new PongPaddle();

		// Add the paddle to the game view.
		add(paddle);
		// Set the paddle's location.
		paddle.setLocation(50, 480 / 2);
		// Create another paddle to add.
		PongPaddle paddle2 = new PongPaddle();

		// Add the paddle to the game view.
		add(paddle2);

		// Set the paddle's location.
		paddle2.setLocation(640 - 50, 480 / 2);
	}
}
