package controller;

import exception.GameLost;
import exception.GameWon;
import model.Logic;
import processing.core.PApplet;

public class Controller {

	private Logic logic;
	private PApplet app;

	public Controller(PApplet app) {
		this.app = app;
		logic = new Logic(app);

	}

	public void initializeGame() {
		logic.startGame();

	}

	/**
	 * 
	 * @throws GameWon
	 * @throws GameLost
	 */

	public void endGame() throws GameWon, GameLost {
		logic.gameOver();

	}

	public void restartGame() {

		if (app.keyCode == 82 && logic.isGameOver()) {
			logic.restartGame();

		}
	}

	public void drawGameView() {
		logic.drawGame();

	}

	public void playerControls() {
		logic.playerMovements();
		logic.shoot();

	}

}