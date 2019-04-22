/**
 * The Alien class is another active object in the game. This Alien object needs to have its own
 * location, direction, size, speed, and color. The Alien object needs to be prepared to be generated
 * multiple times during the game due to the collision effects this game will have.
 * 
 * @author Steven Tat
 * @version %G%
 */

package com.mycompany.spacefights.gameobjects;

import java.util.Random;

import com.codename1.charts.util.ColorUtil;

public class Alien extends Opponent {
	private int constant = 1;
	private Random rnd = new Random();
	
	/**
	 * Creates an alien at a random location given origin, width, and height of GameWorld.
	 * Initializes the location, color, direction, size, and speed of the object.
	 * @param x - x coordinate of origin.
	 * @param y - y coordinate of origin.
	 * @param width - width of the GameWorld.
	 * @param height - length of the GameWorld.
	 */
	public Alien(int x, int y, int width, int height) {
		this.setBounds(x, y, width, height);
		this.setLocation(0 + (width - 0) * rnd.nextDouble(),
						0 + (height - 0) * rnd.nextDouble());
		this.setSize(rnd.nextInt(this.getMaxSize()- this.getMinSize())
					+ this.getMinSize());
		this.setSpeed(20 * constant);
		this.setColor(0, 255, 0);
		this.setDirection(rnd.nextInt(360));
	}
	/*public Alien() {
		this.setLocation(1024.0 * rnd.nextDouble(),
				768.0 * rnd.nextDouble());
		this.setSize(rnd.nextInt(this.getMaxSize()- this.getMinSize())
				+ this.getMinSize());
		this.setSpeed(20 * constant);
		this.setColor(0, 255, 0);
		this.setDirection(rnd.nextInt(360));
	}*/
	
	/**
	 * This constructor takes in an x and y coordinate beacuse
	 * it will be used when the alien objects collide and duplicate.
	 * A new alien object is generated near another alien object, thus it
	 * needs to be given that location.
	 * @param locX - the x-coordinate near the first alien object.
	 * @param locY - the y-coordinate near the first alien object.
	 */
	public Alien(double locX, double locY) {
		this.setLocation(locX, locY);
		this.setSize(rnd.nextInt(this.getMaxSize()- this.getMinSize())
					+ this.getMinSize());
		this.setSpeed(2 * constant);
		this.setColor(0, 255, 0);
		this.setDirection(rnd.nextInt(360));
	}
	
	/**
	 * The alien object needs to be able to change its direction randomly.
	 * This is accomplished using a Random.
	 */
	/*public void updateDirection() {
		this.changeDirection(rnd.nextInt(6) - 3);
	}*/
	
	/**
	 * Returns a String of the related data of the alien object: location, color,
	 * size, speed, and direction. Overrides the Object's toString() method.
	 * @returns a String of the object's data.
	 */
	public String toString() {
		String locatString = "loc=" + getLocationX() + "," + getLocationY();
		String colorString = "color: " + "[" + ColorUtil.red(this.getColor()) +
						"," + ColorUtil.green(this.getColor()) + "," + 
						ColorUtil.blue(this.getColor()) + "]";
		String sizeString = "size=" + this.getSize();
		String speedString = "speed=" + this.getSpeed();
		String dirString = "dir=" + this.getDirection();
		return "Alien: " + locatString + " " + colorString + " " + sizeString +
				" " + speedString + " " + dirString;
	}

}
