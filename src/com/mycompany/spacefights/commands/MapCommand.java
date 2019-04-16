package com.mycompany.spacefights.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

import com.mycompany.spacefights.MapView;

public class MapCommand extends Command {
	//Vector<GameObject> test = new Vector<GameObject>();
	MapView view;
	public MapCommand(MapView newView) {
		super("Map");
		view = newView;
	}
	@Override
	
	public void actionPerformed(ActionEvent ev) {
		view.printMap();
	}
}
