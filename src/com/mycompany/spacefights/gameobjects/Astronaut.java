/**
 * The Astronaut class is an object class that will interact with other objects in the game. 
 * This object contains health that will influence the speed of the object within the game.
 * There is a given constant of 1 that is multiplied by the health to determine the speed.
 * @author Steven Tat
 * @version %G%
 */

package com.mycompany.spacefights.gameobjects;

import java.util.Random;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.geom.Point;

public class Astronaut extends Opponent implements ISelectable {
	
	private int health = 5;
	private int constant = 1;
	private Random rnd = new Random();
	private boolean isSelected;
	
	/**
	 * Creates an astronaut at a random location given origin, width, and height of GameWorld.
	 * Initializes the location, color, direction, size, and speed of the object.
	 * @param x - x coordinate of origin.
	 * @param y - y coordinate of origin.
	 * @param width - width of the GameWorld.
	 * @param height - length of the GameWorld.
	 */
	public Astronaut(int x, int y, int width, int height) {
		this.setBounds(x, y, width, height);
		this.setLocation(0 + (width - 0) * rnd.nextDouble(),
				0 + (height - 0) * rnd.nextDouble());
		this.setSpeed(health * constant);
		this.setColor(0, 0, 255);
		this.setDirection(rnd.nextInt(360));
		this.setSize(rnd.nextInt(this.getMaxSize() - this.getMinSize())
					+ this.getMinSize());
	}
	
	/**
	 * Returns the health of the astronaut.
	 * @return the int value representing the health.
	 */
	public int getHealth() {
		return health;
	}
	
	/**
	 * Decrements the health by 1 each time it is called.
	 * It will not decrease health beyond 0.
	 */
	public void decreHealth() {
		if(health > 0) {
			health--;
		}
	}
	
	/**
	 * Decreases the color of the astronaut, which is only blue in 
	 * this version. The amount of blue decreased is a fixed rate of 20.
	 */
	public void decreColor() {
		if(ColorUtil.blue(this.getColor()) > 0) {
			this.lowerBlue(20);
		}
	}
	
	/**
	 * Uses the superclass's setSpeed method, but this one will not need to take parameters.
	 */
	public void setSpeed() {
		super.setSpeed(health * constant);
	}
	
	/**
	 * Returns a String contain the data of the object: location, color
	 * size, speed, direction, and health. Overrides the object's toString()
	 * method.
	 * @returns - a String of the object's data.
	 */
	public String toString() {
		String locatString = "loc=" + getLocationX() + "," + getLocationY();
		String colorString = "color: " + "[" + ColorUtil.red(this.getColor()) +
						"," + ColorUtil.green(this.getColor()) + "," + 
						ColorUtil.blue(this.getColor()) + "]";
		String sizeString = "size=" + this.getSize();
		String speedString = "speed=" + this.getSpeed();
		String dirString = "dir=" + this.getDirection();
		String healthString = "health=" + this.getHealth();
		return "Astronaut: " + locatString + " " + colorString + " " + sizeString +
				" " + speedString + " " + dirString + " " + healthString;
	}
	
	

	public void setSelected(boolean yesNo) {
		isSelected = yesNo;
	}

	public boolean isSelected() {
		return isSelected;
	}

	public boolean contains(Point pPtrRelPrnt, Point pCmpRelPrnt) {
		int px = pPtrRelPrnt.getX();
		int py = pPtrRelPrnt.getY();
		int xLoc = (int) (pCmpRelPrnt.getX() + this.getLocationX());
		int yLoc = (int) (pCmpRelPrnt.getY() + this.getLocationY());
		
		if(px >= xLoc && px <= xLoc + this.getSize() &&
				py >= yLoc && py <= yLoc + this.getSize()) {
			return true;
		}
		else {
			return false;
		}
	}

}
