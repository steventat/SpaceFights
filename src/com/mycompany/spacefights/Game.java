/**
 * The Game class serves as the primary class that bridges CodeNameOne's Starter class to the GameWorld class.
 * This class will initialize a GameWorld, and it will take in user inputs as single letters from the keyboard
 * , and it will feed those inputs into the GameWorld. This class will also start up a User Interface with buttons
 * and menus. 
 * @author Steven Tat
 * @version 11.2.17
 */

package com.mycompany.spacefights;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog; //Might be temporary
import com.codename1.ui.Form;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.UITimer;
import com.mycompany.spacefights.commands.*;

public class Game extends Form implements Runnable {
	private GameWorld gw;
	private MapView mv;
	private ScoreView sv;

	public Game() {

		UITimer gameTimer = new UITimer(this);
		gw = new GameWorld();
		mv = new MapView();
		sv = new ScoreView();
		gw.addObserver(mv);
		gw.addObserver(sv);

		System.out.println("X: " + mv.getX() + ",Y: " + mv.getY() + ", Width: " + mv.getWidth() +  ", Height: " + mv.getHeight());

		//gw.init();
		//gw.initOb();

		// Starting UITimer
		gameTimer.schedule(20, true, this);

		this.createGUI();

		System.out.println("X: " + mv.getX() + ",Y: " + mv.getY() + ", Width: " + mv.getWidth() +  ", Height: " + mv.getHeight());

		gw.init(mv.getX(), mv.getY(), mv.getWidth(), mv.getHeight());
		gw.initOb();
	}

	public void run() {
		gw.tick();
	}

	public boolean createGUI() {
		// Creating ToolBar
		Toolbar myToolbar = new Toolbar();
		this.setToolbar(myToolbar);
		this.setTitle("Space Fights Game");

		// Initialize Commands
		MapCommand mCommand = new MapCommand(mv);
		ExpandCommand eCommand = new ExpandCommand(gw);
		ContractCommand cCommand = new ContractCommand(gw);
		ScoreCommand sCommand = new ScoreCommand(gw);
		RightCommand rCommand = new RightCommand(gw);
		LeftCommand lCommand = new LeftCommand(gw);
		UpCommand uCommand = new UpCommand(gw);
		DownCommand dCommand = new DownCommand(gw);
		ToAstroCommand oCommand = new ToAstroCommand(gw);
		ToAlienCommand aCommand = new ToAlienCommand(gw);
		NewAlienCommand wCommand = new NewAlienCommand(gw);
		AAFightCommand fCommand = new AAFightCommand(gw);
		TickCommand tCommand = new TickCommand(gw);
		ExitCommand xCommand = new ExitCommand(gw);
		SoundCommand soundCommand = new SoundCommand(gw);
		ScoreCommand sideMenu1 = new ScoreCommand(gw);
		HelpCommand rightBar1 = new HelpCommand();
		Command aboutInfo = new Command("About") {
			public void actionPerformed(ActionEvent ev) {
				String info = "This is my first CodeNameOneApp.";
				Dialog.show("About", info, "Ok", null);
			}
		};
		PausePlayCommand ppCommand = new PausePlayCommand(gw);
		HealCommand hCommand = new HealCommand(gw);

		// Command Key Listeners
		addKeyListener('m', mCommand);
		addKeyListener('e', eCommand);
		addKeyListener('r', rCommand);
		addKeyListener('l', lCommand);
		addKeyListener('u', uCommand);
		addKeyListener('d', dCommand);
		addKeyListener('c', cCommand);
		addKeyListener('s', sCommand);
		addKeyListener('o', oCommand);
		addKeyListener('a', aCommand);
		addKeyListener('w', wCommand);
		addKeyListener('f', fCommand);
		addKeyListener('t', tCommand);
		addKeyListener('x', xCommand);

		// Create Buttons and CheckBox
		Button expandButton = new Button("Expand");
		expandButton.setCommand(eCommand);
		Button rightButton = new Button("Right");
		rightButton.setCommand(rCommand);
		Button leftButton = new Button("Left");
		leftButton.setCommand(lCommand);
		Button upButton = new Button("Up");
		upButton.setCommand(uCommand);
		Button downButton = new Button("Down");
		downButton.setCommand(dCommand);
		Button contractButton = new Button("Contract");
		contractButton.setCommand(cCommand);
		Button scoreButton = new Button("Score");
		scoreButton.setCommand(sCommand);
		Button toAstroButton = new Button("MoveToAstronaut");
		toAstroButton.setCommand(oCommand);
		Button toAlienButton = new Button("MoveToAlien");
		toAlienButton.setCommand(aCommand);
		CheckBox soundBox = new CheckBox("Sound");
		soundBox.setCommand(soundCommand);
		Button exitButton = new Button("Exit");
		exitButton.setCommand(xCommand);
		Button aboutButton = new Button("About");
		aboutButton.setCommand(aboutInfo);
		Button ppButton = new Button("Pause/Play");
		ppButton.setCommand(ppCommand);
		Button hButton = new Button("Heal");
		hButton.setCommand(hCommand);

		// Styling buttons
		expandButton.getAllStyles().setBgTransparency(255);
		expandButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		expandButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		expandButton.getAllStyles().setPadding(10, 10, 10, 10);

		upButton.getAllStyles().setBgTransparency(255);
		upButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		upButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		upButton.getAllStyles().setPadding(10, 10, 10, 10);

		leftButton.getAllStyles().setBgTransparency(255);
		leftButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		leftButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		leftButton.getAllStyles().setPadding(10, 10, 10, 10);

		toAstroButton.getAllStyles().setBgTransparency(255);
		toAstroButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		toAstroButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		toAstroButton.getAllStyles().setPadding(10, 10, 10, 10);

		contractButton.getAllStyles().setBgTransparency(255);
		contractButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		contractButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		contractButton.getAllStyles().setPadding(10, 10, 10, 10);

		downButton.getAllStyles().setBgTransparency(255);
		downButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		downButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		downButton.getAllStyles().setPadding(10, 10, 10, 10);

		rightButton.getAllStyles().setBgTransparency(255);
		rightButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		rightButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		rightButton.getAllStyles().setPadding(10, 10, 10, 10);

		toAlienButton.getAllStyles().setBgTransparency(255);
		toAlienButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		toAlienButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		toAlienButton.getAllStyles().setPadding(10, 10, 10, 10);

		scoreButton.getAllStyles().setBgTransparency(255);
		scoreButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		scoreButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		scoreButton.getAllStyles().setPadding(10, 10, 10, 10);

		ppButton.getAllStyles().setBgTransparency(255);
		ppButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		ppButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		ppButton.getAllStyles().setPadding(10, 10, 10, 10);

		hButton.getAllStyles().setBgTransparency(255);
		hButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		hButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		hButton.getAllStyles().setPadding(10, 10, 10, 10);


		// Setting Toolbar and Sidebar
		myToolbar.addCommandToSideMenu(sideMenu1);
		myToolbar.addComponentToSideMenu(soundBox);
		myToolbar.addComponentToSideMenu(aboutButton);
		myToolbar.addComponentToSideMenu(exitButton);
		myToolbar.addCommandToRightBar(rightBar1);

		// Setting Layouts, Containers, Buttons
		this.setLayout(new BorderLayout());
		this.add(BorderLayout.NORTH, sv);
		this.add(BorderLayout.CENTER, mv);
		Container bottomContainer = new Container(new BoxLayout(BoxLayout.X_AXIS));
		bottomContainer.add(ppButton);
		bottomContainer.add(hButton);
		this.add(BorderLayout.SOUTH, bottomContainer);
		Container leftContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
		leftContainer.add(expandButton);
		leftContainer.add(upButton);
		leftContainer.add(leftButton);
		leftContainer.add(toAstroButton);
		this.add(BorderLayout.WEST, leftContainer);
		Container rightContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
		rightContainer.add(contractButton);
		rightContainer.add(downButton);
		rightContainer.add(rightButton);
		rightContainer.add(toAlienButton);
		rightContainer.add(scoreButton);
		this.add(BorderLayout.EAST, rightContainer);

		this.show();

		return true;
	}
}