package eu.diceH2020.s4c.plugin.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

class GroupProperties extends Composite {
	private PropertiesSingleton prop = PropertiesSingleton.getInstance();

	public GroupProperties(Composite parent, int style) {
		super(parent, SWT.NO_BACKGROUND | SWT.BORDER);
		this.setSize(parent.getSize());
		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		layout.makeColumnsEqualWidth = true;
		this.setLayout(layout);
		//TODO implement check on the value the user will introduce. 
		prop.setAddress(new TextExtended(this, "Backend address"));
		prop.setPort(new TextExtended(this, "Backend port"));		
		prop.setUsername(new TextExtended(this, "Username (To be impl.)"));
		prop.setPassword(new TextExtended(this, "Password (To be impl.)", SWT.PASSWORD));
		prop.setAccuracy(new TextExtended(this, "Accuracy"));
		prop.setCycles(new TextExtended(this, "Cycles"));
		
		new EmptyPanel(this);
		// propertiesFile = new FileChooser(this);
		SaveOpenButtons buttons = new SaveOpenButtons(this);

	}

}