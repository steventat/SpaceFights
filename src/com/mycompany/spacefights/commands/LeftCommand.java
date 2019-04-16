package com.mycompany.spacefights.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.spacefights.GameWorld;

public class LeftCommand extends Command {
	private GameWorld temp;
	
	public LeftCommand(GameWorld gw) {
		super("Left");
		temp = gw;
	}
	@Override
	
	public void actionPerformed(ActionEvent evt) {
		temp.moveRescuerLeft();
		System.out.println("Button pressed");
	}
}
