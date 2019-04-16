package com.mycompany.spacefights.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.spacefights.GameWorld;

public class ContractCommand extends Command {
private GameWorld temp;
	
	public ContractCommand(GameWorld gw) {
		super("Contract");
		temp = gw;
	}
	@Override
	
	public void actionPerformed(ActionEvent evt) {
		temp.contractDoor();
		System.out.println("Button pressed");
	}
}
