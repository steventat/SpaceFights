package com.mycompany.spacefights.sounds;

import java.io.InputStream;
import com.codename1.media.Media;
import com.codename1.media.MediaManager;
import com.codename1.ui.Display;


public class Sound {
	private Media m;
	public Sound(String fileName) {
		try{
			InputStream is = Display.getInstance().getResourceAsStream(getClass(),
			"/"+fileName);
			m = MediaManager.createMedia(is, "audio/wav");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void play() {
		//start playing the sound from time zero (beginning of the sound file)
		m.setTime(0);
		m.play();
	}
}
