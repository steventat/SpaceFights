package com.mycompany.spacefights.commands;

import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.SideMenuBar;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.spacefights.GameWorld;

public class SoundCommand extends Command{
	private GameWorld temp;
	
	public SoundCommand(GameWorld gw) {
		super("Sound");
		temp = gw;
	}
	@Override
	
	public void actionPerformed(ActionEvent evt) {
		if(((CheckBox)evt.getComponent()).isSelected())
			temp.onSound();
		else {
			temp.offSound();
			temp.pausePlayBG();
		}
		System.out.println("Button pressed");
		SideMenuBar.closeCurrentMenu();
	}
}
