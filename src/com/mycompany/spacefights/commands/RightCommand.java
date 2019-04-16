package com.mycompany.spacefights.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.spacefights.GameWorld;

public class RightCommand extends Command {
	private GameWorld temp;
	
	public RightCommand(GameWorld gw) {
		super("Right");
		temp = gw;
	}
	@Override
	
	public void actionPerformed(ActionEvent evt) {
		temp.moveRescuerRight();
		System.out.println("Button pressed");
	}
}
