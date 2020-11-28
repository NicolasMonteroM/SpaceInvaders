package model;

import processing.core.PApplet;

public class Enemie extends Ship implements Runnable {

	public Enemie(PApplet app, int posX, int posY, int size, int speed) {
		super(app, posX, posY, 15, 3);

	}

	@Override
	public void drawShip() {
		app.noStroke();
		app.fill(255);
		app.ellipse(posX, posY, size, size);

	}

	@Override
	public void movement() {

		if (posX < app.width - 30) {

			speed *= 1;

		}

		if (posX >= app.width - 30 && posX > 30) {

			speed *= -1;
			setPosY(getPosY() + 15);

		} else if (posX < 30) {

			speed *= -1;
			setPosY(getPosY() + 15);
		}

		setPosX(getPosX() + getSpeed());

	}

	@Override
	public void run() {

		movement();

	}

}
