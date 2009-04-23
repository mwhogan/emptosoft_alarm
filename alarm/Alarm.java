package alarm;

import java.awt.HeadlessException;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JOptionPane;

public class Alarm {

	private static final long serialVersionUID = 969759574997478732L;
	public static final String version = "1.0";
	public URL playSound;

	public Alarm() throws HeadlessException,InterruptedException,MalformedURLException{
		File f = new File("sound.wav");
		if(new File("sound.wav").exists()){
		    playSound = f.toURI().toURL();
		} else {
			playSound = this.getClass().getResource("nosound.wav");
		}
		int sleep = prompt();
		sleep = sleep * 60000;
		Thread.sleep(sleep);
		boolean exit = wake();
		while(exit == false){
			Thread.sleep(300000);
			exit = wake();
		}
		System.exit(0);
	}

	public int prompt(){
		String temp = JOptionPane.showInputDialog(null, "How many minutes do you want to sleep for?","Emptosoft Alarm v" + version,JOptionPane.QUESTION_MESSAGE);
		if(temp == null){
			System.exit(0);
		}
       	 	int sleep = Integer.parseInt(temp);
		return sleep;
	}

	public boolean wake(){
		Sound sound = new Sound(playSound);
		sound.start();
	        int result = JOptionPane.showConfirmDialog(null,"Wake up! Snooze? (5 minutes)", "Emptosoft Alarm v" + version,JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		sound.shutup();
	        if (result == JOptionPane.NO_OPTION) {
	          return true;
	        } else {
	          return false;
		}
	}
		

	public static void main(String[] args) throws HeadlessException,InterruptedException{
		try {
			new Alarm();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Emptosoft Alarm has encountered a problem and needs to close. Sorry for any inconvenience.","Emptosoft Alarm v" + version,JOptionPane.ERROR_MESSAGE);
		}
	}
}