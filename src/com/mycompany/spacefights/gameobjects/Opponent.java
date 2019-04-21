/**
 * The Opponent abstract class is used to represent the objects that affects the player's
 * win chance. This class contains information such as the speed and direction of the objects, 
 * and it implements the Moveable class because these objects cannot be guided by the user. Thus,
 * they need to be able to move on their own.
 * 
 *  @author Steven Tat
 *  @version %G%
 */

package com.mycompany.spacefights.gameobjects;

import java.util.Random;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

public abstract class Opponent extends GameObject implements Moveable {
	private int speed;
	private int direction;
	private int maxSize = 50;
	private int minSize = 20;
	private Random rnd;
	
	/**
	 * An empty method that is protected to prevent outside tampering of
	 * the Opponent's size.
	 */
	protected void setSize() {
		
	}
	
	/**
	 * Returns the maximum possible size.
	 * @return the maximum possible size that can be used.
	 */
	public int getMaxSize() {
		return maxSize;
	}
	
	/**
	 * Returns the minimum possible size.
	 * @return the minumum possible size that can be used.
	 */
	public int getMinSize() {
		return minSize;
	}
	
	/**
	 * Sets the speed of the opponent.
	 * @param newSpeed - the new speed of the opponent. 
	 */
	public void setSpeed(int newSpeed) {
		speed = newSpeed;
	}
	
	/**
	 * Returns the speed.
	 * @return the int value of the speed.
	 */
	public int getSpeed() {
		return speed;
	}
	
	/**
	 * Returns the direction that opponent is facing.
	 * @return the int value of the direction.
	 */
	public int getDirection() {
		return direction;
	}
	
	/**
	 * Sets the new direction for the opponent.
	 * @param newDirection - the new direction the opponent will be facing
	 */
	public void setDirection(int newDirection) {
		direction = newDirection;
	}
	
	/**
	 * The direction of the opponent will change by the amount given.
	 * @param delta - the amount of direction that will be increased or 
	 * decreased.
	 */
	public void changeDirection(int delta) {
		direction = direction + delta;
	}

	/**
	 * Updates the direction of the object with a random angle between 0 and 180 degrees.
	 */
	public void updateDirection() {
		rnd = new Random();
		this.changeDirection(rnd.nextInt(180) - 0);
	}
	
	/**
	 * The opponent automatically moves when this method is called.
	 * The Math functions are used to calculate the change in distance
	 * as well as reduce the double to on decimal. If the object reaches the bounds
	 * of the GameWorld, then the object will change direction randomly.
	 */
	public void move(int timeMillis) {
		double deltaX = Math.cos(Math.toRadians(90-direction)) * speed;
		double deltaY = Math.sin(Math.toRadians(90-direction)) * speed;
		double newX = this.getLocationX() + deltaX;
		double newY = this.getLocationY() + deltaY;
		boolean withinBounds = this.setLocation(newX, newY);

		if(!withinBounds) {
			updateDirection();
		}
	}

	public void draw(Graphics g, Point pCmpRelPrnt) {
		g.setColor(this.getColor());
		g.drawRect(pCmpRelPrnt.getX(), pCmpRelPrnt.getY(), 20, 40);
	}
}
