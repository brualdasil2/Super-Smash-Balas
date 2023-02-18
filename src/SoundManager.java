import java.io.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.util.concurrent.*;



public class SoundManager {
	
	private static boolean soundOn = true;
	private static final int MAX_THREADS = 10;
	private static final ExecutorService executor = Executors.newFixedThreadPool(MAX_THREADS);
	private static final ConcurrentLinkedQueue<Future<?>> futures = new ConcurrentLinkedQueue<>();
	
	 public static synchronized void play(String path, boolean loop)
	    {
		 Future<?> future = executor.submit(() -> {
		 		try {
                    Clip clip = AudioSystem.getClip();
                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(SoundManager.class.getResource(path));
                    clip.open(inputStream);
                    clip.start();
                    if (loop)
                    	clip.loop(Clip.LOOP_CONTINUOUSLY);
                    clip.drain();
                    inputStream.close();
                    
                    
                    
                } catch (Exception e) {
                    System.out.println("play sound error: " + e.getMessage() + " for " + path);
                }
		 	});		 	
		 futures.add(future);
	    }
	 
	 public static void clear() {
	        for (Future<?> future : futures) {
	            if (!future.isDone()) {
	                future.cancel(true);
	            }
	        }
	        futures.clear();
	    }
	 
	 public static void stop() {
	        executor.shutdownNow();
	        futures.clear();
	    }
	 
	 public static void muteSound() {
		 soundOn = false;
	 }
	 public static void unmuteSound() {
		 soundOn = true;
	 }
	 public static boolean isSoundOn() {
		 return soundOn;
	 }
	 
}
