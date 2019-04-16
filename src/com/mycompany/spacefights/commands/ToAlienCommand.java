package com.mycompany.spacefights.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.spacefights.GameWorld;

public class ToAlienCommand extends Command {
private GameWorld temp;
	
	public ToAlienCommand(GameWorld gw) {
		super("MoveToAlien");
		temp = gw;
	}
	@Override
	
	public void actionPerformed(ActionEvent evt) {
		temp.transferA();;
		System.out.println("Button pressed");
	}
}
