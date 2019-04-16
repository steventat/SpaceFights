package com.mycompany.spacefights.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class ChangeCommand extends Command {
	public ChangeCommand() {
		super("Change");
	}
	@Override
	
	public void actionPerformed(ActionEvent ev) {
		System.out.println("Invoked Change command...");
	}
	
}
