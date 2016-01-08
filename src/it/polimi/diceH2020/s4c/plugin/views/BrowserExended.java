package it.polimi.diceH2020.s4c.plugin.views;

import java.io.IOException;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.osgi.framework.Bundle;

import it.polimi.diceH2020.s4c.plugin.Activator;

public class BrowserExended {

	private static String page;

	private static Browser br;

	private static final LinkInterceptListener locationListener = new LinkInterceptListener();
	
	public Browser getBr() {
		return br;
	}

	public BrowserExended(Composite parent, String page) {
		br = new Browser(parent, SWT.MULTI | SWT.WRAP);	
		br.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		br.addListener(SWT.CHANGED, new Listener() {		
			@Override
			public void handleEvent(Event arg0) {
				
				
				Bundle plugin = Activator.getDefault().getBundle(); // Where Activator
																	// is my
																	// org.eclipse.core.runtime.Plugin
				IPath relativePagePath = new Path(BrowserExended.page);
				URL fileInPlugin = FileLocator.find(plugin, relativePagePath, null);
				URL pageUrl;
				try {
					pageUrl = FileLocator.toFileURL(fileInPlugin);
					br.removeLocationListener(BrowserExended.locationListener);
					br.setUrl(pageUrl.toString());
					br.addLocationListener(BrowserExended.locationListener);
				} catch (IOException e) {
					System.out.println("webpage not found");
				}
				
			}
		});
				this.setPage(page);

	}

	public void setPage(String path) {
		BrowserExended.page = path;
		br.notifyListeners(SWT.CHANGED, new Event());

	}

	public String getPage() {
		return BrowserExended.page;
	}

}
