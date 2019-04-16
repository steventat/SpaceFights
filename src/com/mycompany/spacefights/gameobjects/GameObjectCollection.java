package com.mycompany.spacefights.gameobjects;

import java.util.Vector;

public class GameObjectCollection implements ICollection {
	private Vector<GameObject> worldObjects = new Vector<GameObject>();

	public void add(GameObject ob) {
		worldObjects.add(ob);
		
	}

	public IIterator getIterator() {
		return new GameObjectIterator(worldObjects);
	}
	
	private class GameObjectIterator implements IIterator {
	
		private Vector<GameObject> list;
		private int counter = 0;
		public GameObjectIterator(Vector<GameObject> worldObjects) {
			list = worldObjects;
		}
	
		public boolean hasNext() {
			if(counter < list.size()) {
				return true;
			}
			return false;
		}
		
		public GameObject getNext() {
			if(counter < list.size()) {
				counter++;
				return list.elementAt(counter - 1);
			}
			return null;
		}
	
		public void remove() {
			if(list.isEmpty()) {
				System.err.println("Iterator is empty");
			}
			list.remove(list.elementAt(counter -1));
		}
		
	}
	public GameObject elementAt(int i) {
		return worldObjects.elementAt(i);
	}
	
	public int size() {
		return worldObjects.size();
	}

	public void remove(int i) {
		worldObjects.remove(i);
		
	}
}