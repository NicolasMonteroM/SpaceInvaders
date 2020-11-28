package view;

import model.Logic;
import processing.core.PApplet;

public class Main extends PApplet{
	
	private Logic logic;

	public static void main(String[] args) {
		PApplet.main(Main.class.getName());

	}
	
	public void settings() {
		size(400,600);
		
	}
	
	public void setup() {
		logic = Logic.getInstance();
		
	}
	
	public void draw() {
		
		
	}
	
	public void keyPressed() {
		
		
	}
	
	public void keyReleased() {
		
		
	}

}
