package eu.diceH2020.s4c.plugin.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

class GroupProperties extends Composite {


	private FileChooser propertiesFile;

	private PropertiesSingleton prop = PropertiesSingleton.getInstance();

	public GroupProperties(Composite parent, int style) {
		super(parent, SWT.NO_BACKGROUND | SWT.BORDER);
		this.setSize(parent.getSize());
		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		layout.makeColumnsEqualWidth = true;
		this.setLayout(layout);
		prop.setAddress(new TextExtended(this, "Backend address"));
		prop.setPort(new TextExtended(this, "Backend port"));		

		Composite emptyPanel = new Composite(this, SWT.BORDER);
		GridData panelGridData = new GridData();
		panelGridData.horizontalAlignment = SWT.FILL;
		panelGridData.verticalAlignment = SWT.FILL;
		panelGridData.grabExcessHorizontalSpace = true;
		panelGridData.grabExcessVerticalSpace = true;
		emptyPanel.setLayoutData(panelGridData);
		// propertiesFile = new FileChooser(this);
		SaveOpenButtons buttons = new SaveOpenButtons(this);

		

	}


	/**
	 * @return the propertiesFile
	 */
	public FileChooser getPropertiesFile() {
		return propertiesFile;
	}

}