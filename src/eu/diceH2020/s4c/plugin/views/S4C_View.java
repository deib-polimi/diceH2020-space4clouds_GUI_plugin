package eu.diceH2020.s4c.plugin.views;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Timer;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
//import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;
import org.osgi.framework.Bundle;

import eu.diceH2020.s4c.plugin.Activator;
import eu.diceH2020.s4c.plugin.other.JsonToJava;

/**
 * @author ciavotta This View shows the widgets to interact with SPACE4Cloud WS
 */
public class S4C_View extends ViewPart {
	public static final String ID = "S4C_View";

	String lstNameFiles = null;

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
		ti2.setText("Grid");
		ti2.setControl(new GridComposite(tf));

		Browser br = new Browser(topPanel, SWT.MULTI | SWT.WRAP);
		Bundle plugin = Activator.getDefault().getBundle(); // Where Activator
															// is my
															// org.eclipse.core.runtime.Plugin
		IPath relativePagePath = new Path("static/home.html");
		URL fileInPlugin = FileLocator.find(plugin, relativePagePath, null);
		URL pageUrl;
		try {
			pageUrl = FileLocator.toFileURL(fileInPlugin);
			br.setUrl(pageUrl.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 br.addLocationListener(new LinkInterceptListener());
		br.setLayoutData(new GridData(GridData.FILL_BOTH));

	}

	@Override
	public void setFocus() {

	}

}
