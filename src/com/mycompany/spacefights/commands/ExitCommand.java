package com.mycompany.spacefights.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.spacefights.GameWorld;

public class ExitCommand extends Command {
	private GameWorld temp;
	
	public ExitCommand(GameWorld gw) {
		super("Exit");
		temp = gw;
	}
	@Override
	
	public void actionPerformed(ActionEvent evt) {
		temp.exit();
		System.out.println("Button pressed");
	}
}
