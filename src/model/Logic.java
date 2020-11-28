package model;

import java.util.ArrayList;

import exception.GameLost;
import exception.GameWon;
import processing.core.PApplet;
import processing.core.PConstants;

public class Logic {

	private PApplet app;

	private ArrayList<Enemie> enemies;
	private ArrayList<Enemie> enemiesCopy;
	private ArrayList<Bullet> bullets;
	private Player player;

	private int shotEnemies, bulletsLimit;
	private boolean gameOver, lost, won;

	public Logic(PApplet app) {

		this.app = app;
		enemies = new ArrayList<Enemie>();
		setBullets(new ArrayList<Bullet>());

	}

	public void startGame() {

		gameOver = false;
		won = false;
		lost = false;

		shotEnemies = 0;
		bulletsLimit = 4;

		int enemiesPerLine = 7;
		int lines = 5;

		for (int i = 0; i < enemiesPerLine; i++) {
			for (int j = 0; j < lines; j++) {
				int distance = 30;
				enemies.add(new Enemie(app, (i * distance) + distance, 100 + (j * distance), 0, 0));
			}
		}

		enemiesCopy = enemies;

		player = new Player(app, 0, 0, 0, 0);

	}

	/**
	 * Game lost check method
	 */

	public void lost() throws GameLost {

		for (int i = 0; i < enemies.size(); i++) {
			if (enemies.get(i).getPosY() >= player.getPosY()) {
				throw new GameLost();
			}
		}
	}

	/**
	 * Game won check method
	 */

	public void won() throws GameWon {

		if (enemies.size() == 0) {
			throw new GameWon();
		}
	}

	/**
	 * Try and catch Won and Lost exceptions method
	 * 
	 * @throws GameWon
	 * @throws GameLost
	 */

	public void gameOver() throws GameWon, GameLost {

		String message = "";

		try {
			won();
			lost();
		}

		catch (GameLost | GameWon e) {

			if (e instanceof GameLost) {
				message = e.getMessage();
				gameOver = true;
				lost = true;
			}
			if (e instanceof GameWon) {
				message = e.getMessage();
				gameOver = true;
				won = true;
			}
		}

		System.out.println(message);
	}

	public void drawGame() {

		if (gameOver != true) {

			app.background(20);
			drawEnemies();
			drawPlayer();
			drawBullets();
			impactEnemie();
			enemiesIndicator();
			instructions();

		} else if (gameOver) {

			app.background(208, 85, 244);
			app.fill(20);
			drawMessage();

		}

	}

	public void restartGame() {

		lost = false;
		won = false;
		gameOver = false;
		
		enemies.clear();
		bullets.clear();

		startGame();

	}

	public void instructions() {

		app.fill(100);
		app.text("Press LEFT and RIGHT arrows to move. Press SPACE to shoot.", app.width / 2, app.height - 20);
	}

	public void drawMessage() {

		if (won) {
			app.text("You won", app.width / 2, app.height / 2);
		}

		if (lost) {
			app.text("You lost", app.width / 2, app.height / 2);
		}

		app.text("Press R to restart", app.width / 2, (app.height / 2) + 30);

	}

	/**
	 * Drawing enemies and movement thread creation method
	 */

	public void drawEnemies() {

		for (Enemie e : enemies) {
			e.drawShip();

			if (gameOver != true) {
				Thread enemieMovement = new Thread(e);
				enemieMovement.start();

			}
		}
	}

	public void drawPlayer() {

		player.drawShip();

	}

	/**
	 * Drawing bullets and movement thread creation method
	 */

	public void drawBullets() {

		for (Bullet b : bullets) {
			b.drawBullet();

			Thread bulletMovement = new Thread(b);
			bulletMovement.start();
		}

		for (int i = 0; i < bullets.size(); i++) {
			if (bullets.get(i).getPosY() < 50) {
				bullets.remove(i);

			}
		}
	}

	public void enemiesIndicator() {

		app.textAlign(PConstants.CENTER);
		app.text("Enemies left:" + enemies.size(), app.width / 2, 20);
		app.text("Shot enemies:" + shotEnemies, app.width / 2, 40);

	}

	/**
	 * Player movement thread creation method
	 */

	public void playerMovements() {

		Thread playerMovement = new Thread(player);
		playerMovement.start();

	}

	public void shoot() {

		if (app.keyCode == 32 && bullets.size() < bulletsLimit) {
			bullets.add(new Bullet(app, player.getPosX(), player.getPosY(), 0, 5));

		}
	}

	public void impactEnemie() {

		for (int i = 0; i < enemiesCopy.size(); i++) {

			int enemiePosX = enemiesCopy.get(i).getPosX();
			int enemiePosY = enemiesCopy.get(i).getPosY();

			for (int j = 0; j < bullets.size(); j++) {

				int bulletPosX = bullets.get(j).getPosX();
				int bulletPosY = bullets.get(j).getPosY();

				if (PApplet.dist(enemiePosX, enemiePosY, bulletPosX, bulletPosY) < 10) {
					enemies.remove(i);
					bullets.remove(j);
					shotEnemies++;

				}
			}
		}
	}

	public ArrayList<Bullet> getBullets() {
		return bullets;
	}

	public void setBullets(ArrayList<Bullet> bullets) {
		this.bullets = bullets;
	}

	public boolean isGameOver() {
		return gameOver;
	}

	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

}
