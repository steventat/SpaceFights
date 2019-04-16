package com.mycompany.spacefights.commands;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;

public class HelpCommand extends Command {
	public HelpCommand() {
		super("Help");
	}
	@Override
	
	public void actionPerformed(ActionEvent evt) {
		System.out.println("Help button pressed");
		String info = "e: Expand the door. c: Contract the door."
				+ "s: Open the door and update the score. r: Move"
				+ "the spaceship right. l: Move the spaceship left."
				+ "u: Move the spaceship up. d: Move the spaceship"
				+ " down. o: Move the spaceship to an astronaut location."
				+ "a: Move the spaceship to an alien location. x: Exit game. Side Menu: turn sound on or off, "
				+ "give about information. Right bar menu: Help information"
				+ "(You're here now!)";
		Dialog.show("Help", info, "Ok", null);
	}
}
