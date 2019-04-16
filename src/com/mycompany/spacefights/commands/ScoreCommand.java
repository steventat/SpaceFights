package com.mycompany.spacefights.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.spacefights.GameWorld;

public class ScoreCommand extends Command {
	private GameWorld temp;
	
	public ScoreCommand(GameWorld gw) {
		super("Score");
		temp = gw;
	}
	@Override
	
	public void actionPerformed(ActionEvent evt) {
		temp.scoring();
		System.out.println("Button pressed");
	}
}
