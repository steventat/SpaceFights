package com.mycompany.spacefights.gameobjects;

public interface ICollection {
	void add(GameObject ob);
	
	IIterator getIterator();
}
