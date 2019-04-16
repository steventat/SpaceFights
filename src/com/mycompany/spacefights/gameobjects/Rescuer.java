/**
 * The Rescuer class is an abstract class that inherits the GameObject class and Guided Interface. 
 * This class implements the methods in the Guided Interface to provide guidable movement that can
 * be utilized by objects that extend this class.
 * @author Steven Tat 
 * @version %G%
 */

package com.mycompany.spacefights.gameobjects;

public abstract class Rescuer extends GameObject implements Guided {
	
	/**
	 * Will move the object to the left by decreasing
	 * the x-coordinate by 1.
	 */
	public void moveLeft() {
		this.setLocationX(this.getLocationX() - 15);
	}
	
	/**
	 * Will move the object to the right by increasing
	 * the x-coordinate by 1.
	 */
	public void moveRight() {
		this.setLocationX(this.getLocationX() + 15);
	}
	
	/**
	 * Will move the object upwards by increasing the
	 * y-coordinate by 1.
	 */
	public void moveUp() {
		this.setLocationY(this.getLocationY() - 15);
	}
	
	/**
	 * Will move the object downwards by decreasing the
	 * y-coordinate by 1.
	 */
	public void moveDown() {
		this.setLocationY(this.getLocationY() + 15);
	}
	
	/**
	 * Transfers the object to given xy coordinates.
	 */
	public void jump(double locX, double locY) {
		this.setLocation(locX, locY);
	}

}
