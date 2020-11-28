package view;

import controller.Controller;
import exception.GameLost;
import exception.GameWon;
import processing.core.PApplet;

public class Main extends PApplet {

	private Controller controller;

	public static void main(String[] args) {
		PApplet.main(Main.class.getName());

	}

	public void settings() {
		size(400, 600);

	}

	public void setup() {
		controller = new Controller(this);
		controller.initializeGame();

	}

	public void draw() {

		controller.drawGameView();

		try {
			controller.endGame();
		} catch (GameWon | GameLost e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		controller.restartGame();
	}

	public void keyPressed() {
		controller.playerControls();

	}

}
