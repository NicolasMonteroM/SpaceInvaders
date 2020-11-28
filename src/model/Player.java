package model;

import processing.core.PApplet;

public class Player extends Ship implements Runnable {

	public Player(PApplet app, int posX, int posY, int size, int speed) {
		super(app, app.width / 2, app.height - 60, 20, 8);

	}

	@Override
	public void drawShip() {
		app.noStroke();
		app.fill(208, 85, 244);
		app.ellipse(posX, posY, size, size);

	}

	@Override
	public void movement() {

		if (app.keyCode == 37 && posX >= 30) {
			
			setPosX(getPosX() - getSpeed());
		}

		if (app.keyCode == 39 && posX <= app.width - 30) {
			
			setPosX(getPosX() + getSpeed());
		}

	}

	@Override
	public void run() {

		movement();

	}
}
