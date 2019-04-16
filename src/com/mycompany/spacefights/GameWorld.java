/**
 * The GameWorld class initializes the GameObjects
 * and does the job of calling the necessary methods 
 * to respond to the user's inputs. Every method that
 * causes a change in the game world will call the method
 * notifyObservers to notify MapView and ScoreView to update.
 * @author Steven Tat 
 * @version 11.2.17
 */

package com.mycompany.spacefights;

import com.mycompany.spacefights.gameobjects.*;

import java.util.Observable;
import java.util.Random;

import com.mycompany.spacefights.sounds.BGSound;

public class GameWorld extends Observable {

	private int numAstrosIn;
	private int numAliensIn;
	private int remAstros;
	private int remAliens;
	private int initAliens;
	private int initAstros;
	private int maxScore = initAstros * 10;
	private int gameScore = 0;
	Random rand = new Random();
	private GameObjectCollection worldObjects = new GameObjectCollection();
	private boolean soundState = false;
	private BGSound bgSound = new BGSound("weirdy126.wav");
	private boolean bPause = false;

	/**
	 * Creates the initial game objects
	 */
	public void init(int x, int y, int width, int height) {
		Spaceship ship = Spaceship.getSpaceship();
		Alien kodos = new Alien(x, y, width, height);
		Alien kang = new Alien(x, y, width, height);
		Alien et = new Alien(x, y, width, height);
		Astronaut neil = new Astronaut();
		Astronaut will = new Astronaut();
		Astronaut jack = new Astronaut();
		Astronaut evan = new Astronaut();
		worldObjects.add(ship);
		worldObjects.add(kodos);
		worldObjects.add(kang);
		worldObjects.add(et);
		worldObjects.add(neil);
		worldObjects.add(will);
		worldObjects.add(jack);
		worldObjects.add(evan);
		countObjects();
		// this.pausePlayBG();
	}

	public void initOb() {
		setChanged();
		notifyObservers();
	}

	public void exit() {
		System.out.println("Exiting...");
		System.exit(0);
	}

	public GameObjectCollection getCollection() {
		return worldObjects;
	}

	public void onSound() {
		System.out.print("Sound on...");
		soundState = true;
		setChanged();
		notifyObservers();
	}

	public void offSound() {
		System.out.println("Sound off...");
		soundState = false;
		setChanged();
		notifyObservers();
	}

	public boolean soundOn() {
		return soundState;
	}

	
	public BGSound getBGSound() { 
		return bgSound; 
	}
	
	public void setPause() {
		bPause = !bPause;
	}
	  
	public void pausePlayBG() { 
		//bPause = !bPause; 
		if(bPause) {
			bgSound.pause();
		}
		else if(this.soundOn() != true)
			bgSound.pause();
		else
			bgSound.play();
	}
	 
	/**
	 * Counts the initial number of Alien and Astronaut objects and increments
	 * the initial counts before setting it equal to the altering count.
	 */
	public void countObjects() {
		for (int i = 0; i < worldObjects.size(); i++) {
			if (worldObjects.elementAt(i) instanceof Alien) {
				initAliens++;
			}
			if (worldObjects.elementAt(i) instanceof Astronaut) {
				initAstros++;
			}
			remAliens = initAliens;
			remAstros = initAstros;
		}
		setChanged();
		notifyObservers();
	}

	/**
	 * This method will create a new Alien in a random location when called.
	 */
	public void createAlien() {
		System.out.println("Creating alien...");
		int index = rand.nextInt(worldObjects.size());
		while (worldObjects.elementAt(index) instanceof Alien == false) {
			index = rand.nextInt(worldObjects.size());
		}
		worldObjects.add(new Alien(worldObjects.elementAt(index).getLocationX() + 10,
				worldObjects.elementAt(index).getLocationY() + 10));
		this.countObjects();
		setChanged();
		notifyObservers();
	}

	/**
	 * Checks for whether there are two Aliens, then picks one random Alien and
	 * generates a new Alien nearby. If there are less than 2 Aliens, there will
	 * be an error.
	 */
	public void collide() {
		System.out.println("Collision occurred");
		if (remAliens >= 2) {
			createAlien();
			remAliens++;
			this.countObjects();
			setChanged();
			notifyObservers();
		} else {
			System.err.println("Too little aliens");
		}
	}

	/**
	 * Checks if there are any Aliens remaining before running. If there are any
	 * Aliens, a random Astronaut will lose some health and lose color. Speed
	 * will be altered accordingly.
	 */
	public void fight() {
		if (remAliens != 0) {
			System.out.println("Fight occuring");
			int index = rand.nextInt(worldObjects.size());
			while (worldObjects.elementAt(index) instanceof Astronaut == false) {
				index = rand.nextInt(worldObjects.size());
			}
			Astronaut temp = (Astronaut) worldObjects.elementAt(index);
			temp.decreHealth();
			temp.setSpeed();
			temp.decreColor();
			this.countObjects();
			setChanged();
			notifyObservers();
		} else {
			System.err.println("No more aliens to fight");
		}
	}

	/**
	 * Opens the spaceship door and updates the game score depending on whether
	 * the spaceship's location the same as an Astronaut or Alien.
	 */
	public void scoring() {
		int index = 0;
		for (int i = 0; i < worldObjects.size(); i++) {
			if (worldObjects.elementAt(i) instanceof Spaceship) {
				index = i;
				i = worldObjects.size();
			}
		}
		Spaceship obj = (Spaceship) worldObjects.elementAt(index);
		obj.openDoor();

		for (int i = 0; i < worldObjects.size(); i++) {
			if (worldObjects.elementAt(i) instanceof Alien) {
				Alien al = (Alien) worldObjects.elementAt(i);

				if (al.getLocationX() == obj.getLocationX() && al.getLocationY() == obj.getLocationY()) {
					gameScore = gameScore - 10;
					numAliensIn++;
					remAliens--;
					worldObjects.remove(i);
				}
			}
			if (worldObjects.elementAt(i) instanceof Astronaut) {
				Astronaut astro = (Astronaut) worldObjects.elementAt(i);
				if (astro.getLocationX() == obj.getLocationX() && astro.getLocationY() == obj.getLocationY()) {
					gameScore = gameScore + astro.getHealth();
					if (gameScore > maxScore) {
						gameScore = maxScore;
					}
					numAstrosIn++;
					remAstros--;
					worldObjects.remove(i);
				}
			}
		}
		System.out.println("Scoring...");
		this.countObjects();
		setChanged();
		notifyObservers();
	}

	/**
	 * Will move a Rescuer object to the right. Currently, there is only a
	 * Spaceship object that extends the Rescuer class.
	 */
	public void moveRescuerRight() {
		if(bPause) {
			
		}
		else {
			for (int i = 0; i < worldObjects.size(); i++) {
				if (worldObjects.elementAt(i) instanceof Rescuer) {
					if (worldObjects.elementAt(i) instanceof Spaceship) {
						Spaceship obj = (Spaceship) worldObjects.elementAt(i);
						obj.moveRight();
					}
				}
			}
			System.out.println("Spaceship moving to the right...");
			setChanged();
			notifyObservers();
		}
	}

	/**
	 * Will move a Rescuer object to the left. Currently, there is only a
	 * Spaceship object that extends the Rescuer class.
	 */
	public void moveRescuerLeft() {
		if(bPause) {
			
		}
		else {
			for (int i = 0; i < worldObjects.size(); i++) {
				if (worldObjects.elementAt(i) instanceof Rescuer) {
					if (worldObjects.elementAt(i) instanceof Spaceship) {
						Spaceship obj = (Spaceship) worldObjects.elementAt(i);
						obj.moveLeft();
					}
				}
			}
			System.out.println("Spaceship moving to the left...");
			setChanged();
			notifyObservers();
		}
	}

	/**
	 * Will move a Rescuer object up. Currently, there is only a Spaceship
	 * object that extends the Rescuer class.
	 */
	public void moveRescuerUp() {
		if(bPause) {
			
		}
		else {
			for (int i = 0; i < worldObjects.size(); i++) {
				if (worldObjects.elementAt(i) instanceof Rescuer) {
					if (worldObjects.elementAt(i) instanceof Spaceship) {
						Spaceship obj = (Spaceship) worldObjects.elementAt(i);
						obj.moveUp();
					}
				}
			}
			System.out.println("Spaceship moving up...");
			setChanged();
			notifyObservers();
		}
	}

	/**
	 * Will move a Rescuer object down. Currently, there is only a Spaceship
	 * object that extends the Rescuer class.
	 */
	public void moveRescuerDown() {
		if(bPause) {
			
		}
		else {
			for (int i = 0; i < worldObjects.size(); i++) {
				if (worldObjects.elementAt(i) instanceof Rescuer) {
					if (worldObjects.elementAt(i) instanceof Spaceship) {
						Spaceship obj = (Spaceship) worldObjects.elementAt(i);
						obj.moveDown();
					}
				}
			}
			System.out.println("Spaceship moving down...");
			setChanged();
			notifyObservers();
		}
	}

	/**
	 * Transfers a Spaceship to the location of a randomly selected Alien. An
	 * error will be given if there are no aliens to transfer to.
	 */
	public void transferA() {
		if(bPause) {
			
		}
		else {
			if (this.getRemAliens() != 0) {
				int index = rand.nextInt(worldObjects.size());
				while (worldObjects.elementAt(index) instanceof Alien == false) {
					index = rand.nextInt(worldObjects.size());
				}
	
				for (int i = 0; i < worldObjects.size(); i++) {
					if (worldObjects.elementAt(i) instanceof Spaceship) {
						Spaceship obj = (Spaceship) worldObjects.elementAt(i);
						obj.jump(worldObjects.elementAt(index).getLocationX(),
								worldObjects.elementAt(index).getLocationY());
					}
				}
				setChanged();
				notifyObservers();
			} else {
				System.err.println("No more aliens");
			}
		}
	}

	/**
	 * Transfers a Spaceship to the location of a randomly selected Astronaut.
	 * An error will be given if there are no astronauts to transfer to.
	 */
	public void transferO() {
		if(bPause) {
			
		}
		else {
			if (this.getRemAstros() != 0) {
				int index = rand.nextInt(worldObjects.size());
				while (worldObjects.elementAt(index) instanceof Astronaut == false) {
					index = rand.nextInt(worldObjects.size());
				}
	
				for (int i = 0; i < worldObjects.size(); i++) {
					if (worldObjects.elementAt(i) instanceof Spaceship) {
						Spaceship obj = (Spaceship) worldObjects.elementAt(i);
						obj.jump(worldObjects.elementAt(index).getLocationX(),
								worldObjects.elementAt(index).getLocationY());
					}
				}
				System.out.println("Transferring to astronaut");
				setChanged();
				notifyObservers();
			} else {
				System.err.println("No more astronauts");
			}
		}
	}

	/**
	 * Increases the size of the spaceship's door.
	 */
	public void expandDoor() {
		if(bPause) {
			
		}
		else {
			for (int i = 0; i < worldObjects.size(); i++) {
				if (worldObjects.elementAt(i) instanceof Spaceship) {
					Spaceship obj = (Spaceship) worldObjects.elementAt(i);
					obj.upDoorSize();
				}
			}
			System.out.println("Expanding door");
			setChanged();
			notifyObservers();
		}
	}

	/**
	 * Shortens the size of the spaceship's door.
	 */
	public void contractDoor() {
		if(bPause) {
			
		}
		else {
			for (int i = 0; i < worldObjects.size(); i++) {
				if (worldObjects.elementAt(i) instanceof Spaceship) {
					Spaceship obj = (Spaceship) worldObjects.elementAt(i);
					obj.downDoorSize();
				}
			}
			System.out.println("Contracting door");
			setChanged();
			notifyObservers();
		}
	}

	/**
	 * Gets the number of astronauts obtained by the spaceship.
	 * 
	 * @return an int value for the number of astronauts obtained by the
	 *         spaceship
	 */
	public int getNumAstrosIn() {
		return numAstrosIn;
	}

	/**
	 * Gets the number of aliens obtained by the spaceship.
	 * 
	 * @return the int value for the number of aliens that snuck into the
	 *         spaceship.
	 */
	public int getNumAliensIn() {
		return numAliensIn;
	}

	/**
	 * Gets the remaining number of astronauts still in the game world.
	 * 
	 * @return the int value of astronauts that can still be gathered by the
	 *         spaceship.
	 */
	public int getRemAstros() {
		return remAstros;
	}

	/**
	 * Gets the remaining number of aliens still in the game world.
	 * 
	 * @return the int value of the remaining number of aliens that are still in
	 *         the game world.
	 */
	public int getRemAliens() {
		return remAliens;
	}

	/**
	 * Gets the player's game score of the game.
	 * 
	 * @return the int value of the player's score.
	 */
	public int getGameScore() {
		return gameScore;
	}

	/**
	 * Borrows from the appendix section of the assigning. Calls the move method
	 * for every object that implements the Moveable interface.
	 */
	public void tick() {
		if(bPause) {
			
		}
		else {
			for (int i = 0; i < worldObjects.size(); i++) {
				if (worldObjects.elementAt(i) instanceof Moveable) {
					Moveable mObj = (Moveable) worldObjects.elementAt(i);
					mObj.move();
					// put statements to change direction if going OOB
				}
			}
			setChanged();
			notifyObservers();
		}
	}
}
