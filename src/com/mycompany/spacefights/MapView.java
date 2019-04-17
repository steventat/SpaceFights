package com.mycompany.spacefights;

import java.util.Observable;
import java.util.Observer;

import com.codename1.ui.Container;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

import com.mycompany.spacefights.gameobjects.*;

public class MapView extends Container implements Observer {

	GameObjectCollection worldObjects = new GameObjectCollection();

	private int minWidth;
	private int minHeight;
	private int maxWidth;
	private int maxHeight;

	/**
	 * Draws the object onto the screen.
	 * @param g
	 */
	@Override
	public void paint(Graphics g) {
		super.paint(g);

		IIterator iterator = worldObjects.getIterator();
		while (iterator.hasNext()) {
			GameObject gObject = iterator.getNext();
			if(gObject instanceof Opponent) {
				Point pCmpRelPrnt = new Point(this.getX() + (int) gObject.getLocationX(), this.getY() + (int) gObject.getLocationY());
				gObject.draw(g, pCmpRelPrnt);
			}
			else {
				Point pCmpRelPrnt = new Point(this.getX() + (int) gObject.getLocationX(), this.getY() + (int) gObject.getLocationY());
				gObject.draw(g, pCmpRelPrnt);
			}
		}
	}

	/*
	public void paint(Graphics g) {
		super.paint(g);

		IIterator iterator = worldObjects.getIterator();
		while (iterator.hasNext()) {
			GameObject gObject = iterator.getNext();
			if(gObject instanceof Opponent && (int) gObject.getLocationX() <= this.getX() ||
					gObject instanceof Opponent && (int) gObject.getLocationX() >= 1024 + this.getX()) {
				Opponent temp = (Opponent) gObject;
				temp.setDirection(temp.getDirection() + 180);
			}
			else if(gObject instanceof Opponent && (int) gObject.getLocationX() <= this.getY() ||
					gObject instanceof Opponent && (int) gObject.getLocationX() >= 768 + this.getY()) {
				Opponent temp = (Opponent) gObject;
				temp.setDirection(temp.getDirection() + 180);
			}
			Point pCmpRelPrnt = new Point(this.getX() + (int) gObject.getLocationX(), this.getY() + (int) gObject.getLocationY());
			gObject.draw(g, pCmpRelPrnt);
		}
	}
	 */


	@Override
	public void pointerPressed(int x, int y) {
		x = x - getParent().getAbsoluteX();
		y = y - getParent().getAbsoluteY();
		Point pPtrRelPrnt = new Point(x, y);
		Point pCmpRelPrnt = new Point(getX(), getY());
		IIterator itr = worldObjects.getIterator();
		while(itr.hasNext()) {
			GameObject gObject = itr.getNext();
			if(gObject instanceof Astronaut) {
				if(((Astronaut) gObject).contains(pPtrRelPrnt, pCmpRelPrnt)) {
					((Astronaut) gObject).setSelected(true);
				}
				else {
					((Astronaut) gObject).setSelected(false);
				}
			}
		}
		repaint();
	}


	public MapView() {
		System.out.println("Map Width: " + this.getX() + " " + this.getWidth() +
				", Map Height: " + this.getY() + " " + this.getHeight());
		minWidth = this.getX();
		minHeight = this.getY();
		maxWidth = this.getWidth();
		maxHeight = this.getHeight();
	}

	public MapView(Observable myModel) {
		myModel.addObserver(this);
	}

	public void update(Observable observable, Object data) {
		GameWorld gwUp = (GameWorld) observable;
		worldObjects = gwUp.getCollection();
		//printMap();
		this.repaint();
	}

	public void printMap() {
		for (int i = 0; i < worldObjects.size(); i++) {
			System.out.println(worldObjects.elementAt(i).toString());
		}
		System.out.println();
		System.out.println();
	}

}
