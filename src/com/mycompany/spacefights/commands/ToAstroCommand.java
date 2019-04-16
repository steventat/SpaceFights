package com.mycompany.spacefights.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.spacefights.GameWorld;

public class ToAstroCommand extends Command{
	private GameWorld temp;
	
	public ToAstroCommand(GameWorld gw) {
		super("MoveToAstronaut");
		temp = gw;
	}
	@Override
	
	public void actionPerformed(ActionEvent evt) {
		temp.transferO();;
		System.out.println("Button pressed");
	}
}
