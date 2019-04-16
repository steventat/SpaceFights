package com.mycompany.spacefights.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.spacefights.GameWorld;

public class AAFightCommand extends Command {
	private GameWorld temp;
	
	public AAFightCommand(GameWorld gw) {
		super("Fight");
		temp = gw;
	}
	@Override
	
	public void actionPerformed(ActionEvent evt) {
		temp.collide();
		System.out.println("Button pressed");
	}
}
