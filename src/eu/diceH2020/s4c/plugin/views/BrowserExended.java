package eu.diceH2020.s4c.plugin.views;

import java.io.IOException;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.osgi.framework.Bundle;

import eu.diceH2020.s4c.plugin.Activator;

public class BrowserExended {

	private String page;

	private Browser br;
	
	public Browser getBr() {
		return br;
	}

	public BrowserExended(Composite parent, String page) {
		br = new Browser(parent, SWT.MULTI | SWT.WRAP);
		this.setPage(page);
	//	br.addLocationListener(new LinkInterceptListener());
		br.setLayoutData(new GridData(GridData.FILL_BOTH));
	}

	public void setPage(String path) {
		this.page = path;
		Bundle plugin = Activator.getDefault().getBundle(); // Where Activator
															// is my
															// org.eclipse.core.runtime.Plugin
		IPath relativePagePath = new Path(path);
		URL fileInPlugin = FileLocator.find(plugin, relativePagePath, null);
		URL pageUrl;
		try {
			pageUrl = FileLocator.toFileURL(fileInPlugin);
			br.setUrl(pageUrl.toString());
		} catch (IOException e) {
			System.out.println("webpage not found");
		}
	}
	public String getPage(){
		return this.page;
	}
	
	
}
