package com.mycompany.spacefights.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.spacefights.GameWorld;

public class NewAlienCommand extends Command {
	private GameWorld temp;
	
	public NewAlienCommand(GameWorld gw) {
		super("NewAlien");
		temp = gw;
	}
	@Override
	
	public void actionPerformed(ActionEvent evt) {
		temp.createAlien();
		System.out.println("Button pressed");
	}
}
