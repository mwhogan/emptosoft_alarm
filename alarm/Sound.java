package alarm;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

public class Sound extends Thread {

 public AudioClip sound = null;
 public URL playSound;

  public Sound(URL sound){
    super();
    playSound = sound;
  }

  public void run(){
    try{
      sound = Applet.newAudioClip(playSound);
      sound.loop();
    } catch (Exception e) {
    }	
  }

  public void shutup(){
    sound.stop();
  }

}