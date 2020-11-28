package model;

import java.util.ArrayList;

import processing.core.PApplet;

public class Logic {

	private static Logic logicInstance;
	private PApplet app;

	private ArrayList<Enemie> enemies;
	private ArrayList<Bullet> bullets;
	private Player player;

	private Logic() {

		this.app = new PApplet();
	}

	public static Logic getInstance() {

		if (logicInstance == null) {
			logicInstance = new Logic();
		}

		return logicInstance;
	}

	public void startGame() {

	}

	public void lost() {

	}

	public void won() {

	}

	public void gameOver() {

	}

	public void drawGame() {

	}
	
	public void enemiesIndicator() {
		
		
	}
	
	public void playerControls(){
		
		
	}
}
