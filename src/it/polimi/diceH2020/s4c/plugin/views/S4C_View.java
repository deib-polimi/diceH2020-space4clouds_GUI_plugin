package it.polimi.diceH2020.s4c.plugin.views;

import java.io.IOException;
import java.net.URL;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.ui.part.ViewPart;
import org.osgi.framework.Bundle;

import it.polimi.diceH2020.s4c.plugin.Activator;

/**
 * @author ciavotta This View shows the widgets to interact with SPACE4Cloud WS
 */
public class S4C_View extends ViewPart {
	public static final String ID = "S4C_View";

	String lstNameFiles = null;
	private BrowserExended browser;

	private PropertiesSingleton prop = PropertiesSingleton.getInstance();
	@Override
	public void createPartControl(Composite parent) {

		
		
		Composite topPanel = new Composite(parent, SWT.NONE);// embedded
																// Composite
		// setup the layout of top to be GridLayout.
		GridLayout layout = new GridLayout();
		layout.marginHeight = 1;
		layout.marginWidth = 1;
		layout.numColumns = 2;
		layout.makeColumnsEqualWidth = true;
		topPanel.setLayout(layout);

		TabFolder tf = new TabFolder(topPanel, SWT.BORDER);
		tf.setLayoutData(new GridData(GridData.FILL_BOTH));

		TabItem ti1 = new TabItem(tf, SWT.BORDER);
		ti1.setText("Properties");
		ti1.setControl(new GroupProperties(tf, SWT.SHADOW_ETCHED_IN));

		TabItem ti2 = new TabItem(tf, SWT.BORDER);
		ti2.setText("Command panel");
		ti2.setControl(new GroupCommands(tf));

		browser = new BrowserExended(topPanel, "static/home.html");
		
//		browser.setPage("static/home.html");
		prop.setBrowser(browser);
	}


	/**
	 * @param br
	 */


	@Override
	public void setFocus() {

	}

}
