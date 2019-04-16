/**
 * The purpose of this interface is to provide an interface that allows the user
 * to control and tell objects to move in specific directions.
 * @author Steven Tat
 * @version 10.5.17
 */

package com.mycompany.spacefights.gameobjects;

public interface Guided {
	
	/**
	 * A method for the leftward movement.
	 */
	void moveLeft();
	
	/**
	 * A method for the rightward movement.
	 */
	void moveRight();
	
	/**
	 * A method for moving upwards.
	 */
	void moveUp();
	
	/**
	 * A method for moving downwards.
	 */
	void moveDown();
	
	/**
	 * Certain objects may also need to be able to
	 * instantly move from one location to the next.
	 * @param locX - The x-coordinate to transfer to.
	 * @param locY - The y-coordinate to transfer to.
	 */
	void jump(double locX, double locY);

}
