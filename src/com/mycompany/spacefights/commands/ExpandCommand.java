package com.mycompany.spacefights.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.spacefights.GameWorld;

public class ExpandCommand extends Command {
	private GameWorld temp;
	
	public ExpandCommand(GameWorld gw) {
		super("Expand");
		temp = gw;
	}
	@Override
	
	public void actionPerformed(ActionEvent evt) {
		System.out.println("Expanding...");
		temp.expandDoor();
	}
}
