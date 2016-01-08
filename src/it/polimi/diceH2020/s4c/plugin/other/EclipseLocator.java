package it.polimi.diceH2020.s4c.plugin.other;

import java.io.IOException;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;

import it.polimi.diceH2020.SPACE4Cloud.shared.Locator;

public class EclipseLocator implements Locator {

	@Override
	public URL resolve(URL url) {
		try {
			return FileLocator.resolve(url);
		} catch (IOException e) {
			return null;
		}
	}

}
