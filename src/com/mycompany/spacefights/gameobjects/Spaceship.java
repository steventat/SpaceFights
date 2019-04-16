/**
 * The Spaceship class represents one of the main objects that the user will be
 * able to interact with in the game. Data values of the spaceship are initialized
 * from here. This class sets up the doorSize so that it may
 * be utilized by the GameWorld class and has a toString() method, so that the user
 * can quickly obtain the object's data values.
 * @author Steven Tat
 * @version %G%
 */

package com.mycompany.spacefights.gameobjects;

import com.codename1.charts.util.ColorUtil;

import java.util.Random;

public class Spaceship extends Rescuer {
	
	private static Random rnd = new Random();
	private int doorSize = rnd.nextInt((1024-50) + 50);
	private static int initSize = 100;
	boolean doorOpen = false;
	private static Spaceship mySpaceship;
	/**
	 * Constructor for the spaceship. It generates a random location
	 * for the object and sets the color and size. 
	 */
	private Spaceship() {
		/*this.setLocation(1024.0 * rnd.nextDouble(), 
						768.0 * rnd.nextDouble());
		this.setColor(255, 0, 0);
		this.setSize(initSize);*/
	}
	
	public static Spaceship getSpaceship() {
		if (mySpaceship == null) {
			mySpaceship = new Spaceship();
			mySpaceship.setLocation(1024.0 * rnd.nextDouble(), 
					768.0 * rnd.nextDouble());
			mySpaceship.setColor(255, 0, 0);
			mySpaceship.setSize(initSize);
		}
		return mySpaceship;
	}
	
	/**
	 * Increases the doorsize by 
	 * half its size at a time.
	 */
	public void upDoorSize() {
		doorSize += doorSize/2;
	}
	
	/**
	 * Decreases the doorsize by
	 * half of its size at a time.
	 */
	public void downDoorSize() {
		doorSize -= doorSize/2;
	}
	
	/**
	 * Sets the door of the spaceship to open.
	 */
	public void openDoor() {
		doorOpen = true;
	}
	
	/**
	 * Returns the location, color, and size of the
	 * spaceship together as a String. Overrides the 
	 * Object class's original String method.
	 * @returns - String containing the data of the spaceship.
	 */
	public String toString() {
		String locatString = "loc=" + getLocationX() + "," + getLocationY();
		String colorString = "color: " + "[" + ColorUtil.red(this.getColor()) +
						"," + ColorUtil.green(this.getColor()) + "," + 
						ColorUtil.blue(this.getColor()) + "]";
		String sizeString = "size=" + this.getSize();
		return "Spaceship: " + locatString + " " + colorString + " " + sizeString; 
	}
}
