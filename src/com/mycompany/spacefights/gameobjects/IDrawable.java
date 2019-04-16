package com.mycompany.spacefights.gameobjects;

import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

public interface IDrawable {
	//Is Point imported correctly?
	void draw(Graphics g, Point pCmpRelPrnt);
}
