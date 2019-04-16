package com.mycompany.spacefights.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.spacefights.GameWorld;

public class UpCommand extends Command {
private GameWorld temp;
	
	public UpCommand(GameWorld gw) {
		super("Up");
		temp = gw;
	}
	@Override
	
	public void actionPerformed(ActionEvent evt) {
		temp.moveRescuerUp();
		System.out.println("Button pressed");
	}
}
