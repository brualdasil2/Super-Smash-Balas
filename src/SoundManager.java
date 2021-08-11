import java.io.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;



public class SoundManager {
	
	
	 public static synchronized void play(String path, boolean loop)
	    {
	       
	        new Thread(new Runnable() {
	            public void run() {
	                try {
	                    Clip clip = AudioSystem.getClip();
	                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(SoundManager.class.getResource(path));
	                    clip.open(inputStream);
	                    clip.start();
	                    if (loop)
	                    	clip.loop(Clip.LOOP_CONTINUOUSLY);
	                    
	                } catch (Exception e) {
	                    System.out.println("play sound error: " + e.getMessage() + " for " + path);
	                }
	            }
	        }).start();
	        
	        
	    }
}
