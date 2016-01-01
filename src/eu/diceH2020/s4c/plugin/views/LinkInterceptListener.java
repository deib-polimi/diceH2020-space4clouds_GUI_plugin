/**
 * 
 */
package eu.diceH2020.s4c.plugin.views;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.swt.browser.LocationEvent;
import org.eclipse.swt.browser.LocationListener;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.browser.IWebBrowser;

/**
 * @author ciavotta
 *
 */
public class LinkInterceptListener implements LocationListener {

	/* (non-Javadoc)
	 * @see org.eclipse.swt.browser.LocationListener#changed(org.eclipse.swt.browser.LocationEvent)
	 */
	@Override
	public void changed(LocationEvent arg0) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.eclipse.swt.browser.LocationListener#changing(org.eclipse.swt.browser.LocationEvent)
	 */
	@Override
	public void changing(LocationEvent event) {
		// Call user code to process link as desired and return
		// true if the link should be opened in place.
		
		try {
			final IWebBrowser browser = PlatformUI.getWorkbench().getBrowserSupport().createBrowser("ciao");
			URL url = new URL(event.location);
			browser.openURL(url);
		} catch (PartInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		boolean shouldOpenLinkInPlace = false;
 
		// Setting event.doit to false prevents the link from opening in place
		event.doit = shouldOpenLinkInPlace;
    }

	}

