package com.mycompany.spacefights.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.spacefights.GameWorld;

public class TickCommand extends Command {
	private GameWorld temp;
	
	public TickCommand(GameWorld gw) {
		super("Tick");
		temp = gw;
	}
	@Override
	
	public void actionPerformed(ActionEvent evt) {
		temp.tick();
		System.out.println("Button pressed");
	}
}
