/**
 * The GameObject class is an abstract class that will be used by all of the different
 * objects specialized for this game. 
 * @author Steven Tat
 * @version %G%
 */

package com.mycompany.spacefights.gameobjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

public abstract class GameObject implements IDrawable {
	private int size = 0;
	private double locationX = 0;
	private double locationY = 0;
	private int color;

	// Ppt 14
	/*public void draw(Graphics g, Point pCmpRelPrnt) {
		g.setColor(color);
		g.drawRect(pCmpRelPrnt.getX(), pCmpRelPrnt.getY(), 20, 40);
	}*/

	/**
	 * Gets the size of the game object.
	 * 
	 * @return the int value for the object's size.
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Sets the size of the object to the newly given size.
	 * 
	 * @param newSize - The new size of the object.
	 */
	public void setSize(int newSize) {
		size = newSize;
	}

	/**
	 * Returns the x-coordinate of the object.
	 * 
	 * @return the double value of the x-coordinate of the object.
	 */
	public double getLocationX() {
		return Math.round(locationX);
	}

	/**
	 * Returns the y-coordinate of the object.
	 * 
	 * @return the double value of the y-coordinate of the object.
	 */
	public double getLocationY() {
		return Math.round(locationY);
	}

	/**
	 * Given a new x-coordinate and y-coordinate, this method will set the
	 * location of the object to these new coordinates.
	 * 
	 * @param newLocationX
	 *            - the new x-coordinate.
	 * @param newLocationY
	 *            - the new y-coordinate.
	 */
	public void setLocation(double newLocationX, double newLocationY) {
		locationX = newLocationX;
		locationY = newLocationY;
	}

	/**
	 * Will change only the x-coordinate of the object.
	 * 
	 * @param newLocationX
	 *            - the new x-coordinate.
	 */
	public void setLocationX(double newLocationX) {
		locationX = newLocationX;
	}

	/**
	 * Will change only the y-coordinate of the object.
	 * 
	 * @param newLocationY
	 *            - the new y-coordinate.
	 */
	public void setLocationY(double newLocationY) {
		locationY = newLocationY;
	}

	/**
	 * Returns the combined color of the object.
	 * 
	 * @return a single int value representing the color
	 */
	public int getColor() {
		return color;
	}

	/**
	 * Sets the color of the object by entering a desired amount of red, green,
	 * and blue.
	 * 
	 * @param r - an int value between 0-255 for red.
	 * @param g - an int value between 0-255 for green.
	 * @param b - an int value between 0-255 for blue.
	 */
	public void setColor(int r, int g, int b) {
		color = ColorUtil.rgb(r, g, b);
	}

	/**
	 * Will decrease the red color of the object.
	 * 
	 * @param red
	 *            - the amount of red that will be decreased.
	 */
	public void lowerRed(int red) {
		color = ColorUtil.rgb(ColorUtil.red(color) - red, ColorUtil.green(color), ColorUtil.blue(color));
	}

	/**
	 * Will decrease the green color of the object.
	 * 
	 * @param green
	 *            - the amount of green that will be decreased.
	 */
	public void lowerGreen(int green) {
		color = ColorUtil.rgb(ColorUtil.red(color), ColorUtil.green(color) - green, ColorUtil.blue(color));
	}

	/**
	 * Will decrease the blue color of the object.
	 * @param blue- the amount of blue that will be decreased.
	 */
	public void lowerBlue(int blue) {
		color = ColorUtil.rgb(ColorUtil.red(color), ColorUtil.green(color), ColorUtil.blue(color) - blue);
	}

}
