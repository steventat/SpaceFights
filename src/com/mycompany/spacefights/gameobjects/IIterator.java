package com.mycompany.spacefights.gameobjects;

public interface IIterator {
	boolean hasNext();
	
	GameObject getNext();
	
	void remove();
}
