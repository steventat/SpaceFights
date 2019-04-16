package com.mycompany.spacefights;

import java.util.Observable;
import java.util.Observer;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.FlowLayout;

public class ScoreView extends Container implements Observer {
	
	private Label label1 = new Label("Total Score: 0");
	private Label label2 = new Label(" Astronauts Rescued: 0");
	private Label label3 = new Label(" Aliens Sneaked In: 0");
	private Label label4 = new Label(" Astronauts Remaining: 0");
	private Label label5 = new Label(" Aliens Sneaked In: 0");
	private Label label6 = new Label(" Sound: " + "OFF");
	
	public ScoreView() {
		this.setLayout(new FlowLayout(Component.CENTER));
		this.add(label1);
		this.add(label2);
		this.add(label3);
		this.add(label4);
		this.add(label5);
		this.add(label6);
	}
	
	public ScoreView(Observable myModel) {
		myModel.addObserver(this);
	}
	
	public void update(Observable observable, Object data) {
		GameWorld gwUp = (GameWorld) observable;
		
		label1.setText("Total Score: " + gwUp.getGameScore());
		label2.setText(" Astronauts Rescued: " + gwUp.getNumAstrosIn());
		label3.setText(" Aliens Sneaked In: " + gwUp.getNumAliensIn());
		label4.setText(" Astronauts Remaining: " + gwUp.getRemAstros());
		label5.setText(" Aliens Remaining: " + gwUp.getRemAliens());
		
		//Check if sound check box has been checked or not.
		if(gwUp.soundOn() != true) {
			label6.setText(" Sound: " + "OFF");
		}
		else {
			label6.setText(" Sound: " + "ON");
		}
		
	}

}
