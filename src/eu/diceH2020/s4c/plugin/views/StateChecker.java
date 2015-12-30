package eu.diceH2020.s4c.plugin.views;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.TimerTask;

public class StateChecker extends TimerTask{
	
	private URL url; 
	
	public StateChecker() {
		super();
		try {
			url = new URL("http://localhost:8181/state"); //todo: this must be changed
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	 @Override
	    public void run() {
	        System.out.println("Timer task started at:"+new Date());	        
	        Caller.askWebServer(url); // the output field changes, modify asap
	        System.out.println("Timer task finished at:"+new Date());
	    }
	 
	   
	    
	}

