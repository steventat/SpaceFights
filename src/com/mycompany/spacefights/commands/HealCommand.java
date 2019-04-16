package com.mycompany.spacefights.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

import com.mycompany.spacefights.GameWorld;

public class HealCommand extends Command {
	private GameWorld temp;
	
	public HealCommand(GameWorld gw) {
		super("Heal");
		temp = gw;
	}
	
	public void actionPerformed(ActionEvent evt) {
		
	}
}
