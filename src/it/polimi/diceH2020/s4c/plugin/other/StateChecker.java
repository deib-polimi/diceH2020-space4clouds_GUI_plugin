package it.polimi.diceH2020.s4c.plugin.other;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.TimerTask;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.widgets.Display;
import org.osgi.framework.Bundle;

import it.polimi.diceH2020.s4c.plugin.Activator;
import it.polimi.diceH2020.s4c.plugin.views.BrowserExended;
import it.polimi.diceH2020.s4c.plugin.views.PropertiesSingleton;

public class StateChecker extends TimerTask {

	private PropertiesSingleton prop = PropertiesSingleton.getInstance();
	private URL url;

	public StateChecker() {
		super();
		try {

			url = new URL("http://" + prop.getAddressString() + ":" + prop.getPortString() + "/state");
			// changed
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		System.out.println("Timer task started at:" + new Date());
		Display.getDefault().asyncExec(new Runnable() {
			
			@Override
			public void run() {
				BrowserExended br = prop.getBrowser();
				if (RestInteractor.askRemoteState(url)) {
					br.setPage("static/connected.html");
				} else
					br.setPage("static/home.html");
				
			}
		});

		System.out.println("Timer task finished at:" + new Date());
	}

}
