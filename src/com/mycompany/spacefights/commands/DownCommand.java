package com.mycompany.spacefights.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.spacefights.GameWorld;

public class DownCommand extends Command {
	private GameWorld temp;
	
	public DownCommand(GameWorld gw) {
		super("Down");
		temp = gw;
	}
	@Override
	
	public void actionPerformed(ActionEvent evt) {
		temp.moveRescuerDown();
		System.out.println("Button pressed");
	}
}
