package com.mycompany.spacefights.gameobjects;

import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

public interface ISelectable {
	void setSelected(boolean yesNo);
	
	boolean isSelected();
	
	boolean contains(Point pPtrRelPrnt, Point pCmpRelPrnt);
	
	void draw(Graphics g, Point pCmpRelPrnt);
}
