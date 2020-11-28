package model;

import processing.core.PApplet;

public class Bullet implements Runnable {

	private int posX, posY, size, speed;
	private PApplet app;

	public Bullet(PApplet app, int posX, int posY, int size, int speed) {
		this.app = app;
		this.posX = posX;
		this.posY = posY;
		this.size = 10;
		this.speed = 5;

	}

	public void drawBullet() {
		app.noStroke();
		app.fill(208, 85, 244);
		app.ellipse(posX, posY, size, size);

	}

	public void movement() {

		posY -= speed;

	}

	@Override
	public void run() {

		movement();

	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public PApplet getApp() {
		return app;
	}

	public void setApp(PApplet app) {
		this.app = app;
	}

}
