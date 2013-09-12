package pong;

import java.awt.Color;
import jgame.GRootContainer;
import jgame.Game;
import jgame.ImageCache;

public class Pong extends Game {
	
	public static void main(String[] args){
		ImageCache.create(Pong.class, "/pong/rsc/");
		//Create the Pong game
		//Create an instance and assign to a variable
		//Type name = new Type()
		Pong p1 = new Pong();
		//Start the Pong game
		p1.startGame();
	}
	
	public Pong(){
		
		GRootContainer root = new GRootContainer(Color.BLACK );
		setRootContainer(root);
		PongGameView pgv = new PongGameView();
		GameOverView gov = new GameOverView();
		root.addView(Views.GAME, pgv);
		root.addView(Views.GAME_OVER, gov);

	}
	
	
	/**	These are all of the views for this game
	 * @author eettlin
	 *
	 */
	public enum Views{
//		These are all of the views for this game
		MENU, GAME, GAME_OVER, INSTRUCTIONS,OTHER; 
	}
	
	

}
