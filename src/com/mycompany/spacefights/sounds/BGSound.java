package com.mycompany.spacefights.sounds;

import java.io.InputStream;

import com.codename1.media.Media;
import com.codename1.media.MediaManager;
import com.codename1.ui.Display;

/** This class encapsulates a sound file as an Media inside a
* �Sound� object, and provides a method for playing the Sound.
*/
public class BGSound implements Runnable {
	private Media m;
	public BGSound(String fileName) {
		try{
			InputStream is = Display.getInstance().getResourceAsStream(getClass(),
			"/"+fileName);
			m = MediaManager.createMedia(is, "audio/wav", this);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void pause() {
		m.pause();	//Pause the sound
	}
	public void play() {
		m.play();	//Resumes sound from where it left off
	}
	
	public void run() {
		m.setTime(0);
		m.play();
	}
}
