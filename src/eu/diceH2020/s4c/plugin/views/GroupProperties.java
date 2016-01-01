package eu.diceH2020.s4c.plugin.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridData;

class GroupProperties extends Composite {

	private textExtended address;

	private textExtended port;

	private FileChooser propertiesFile;

	public GroupProperties(Composite parent, int style) {
		super(parent, SWT.NO_BACKGROUND | SWT.BORDER);
		this.setSize(parent.getSize());
		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		layout.makeColumnsEqualWidth = true;
		this.setLayout(layout);
		address = new textExtended(this, "Backend address");
		port = new textExtended(this, "Backend port");
		Composite emptyPanel = new Composite(this, SWT.BORDER);
		GridData panelGridData = new GridData();
		panelGridData.horizontalAlignment = SWT.FILL;
		panelGridData.verticalAlignment = SWT.FILL;
		panelGridData.grabExcessHorizontalSpace = true;
		panelGridData.grabExcessVerticalSpace = true;
		emptyPanel.setLayoutData(panelGridData);
		// propertiesFile = new FileChooser(this);
		SaveOpenButtons buttons = new SaveOpenButtons(this, address, port);

		// ((GridData) propertiesFile.getLayoutData()).verticalAlignment =
		// SWT.DOWN;

	}

	/**
	 * @return the address
	 */
	public textExtended getAddress() {
		return address;
	}

	/**
	 * @return the port
	 */
	public textExtended getPort() {
		return port;
	}

	/**
	 * @return the propertiesFile
	 */
	public FileChooser getPropertiesFile() {
		return propertiesFile;
	}

}