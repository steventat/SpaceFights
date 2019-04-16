package com.mycompany.spacefights.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.spacefights.GameWorld;

public class PausePlayCommand extends Command {
	private GameWorld temp;
	
	public PausePlayCommand(GameWorld gw) {
		super("Pause/Play");
		temp = gw;
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		temp.setPause();
		temp.pausePlayBG();
	}
}