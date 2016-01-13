package it.polimi.diceH2020.s4c.plugin.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

class GroupCommands extends Composite {

	private PropertiesSingleton prop = PropertiesSingleton.getInstance();

	public GroupCommands(Composite parent) {
		super(parent, SWT.NO_BACKGROUND | SWT.BORDER);
		this.setSize(parent.getSize());
		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		layout.makeColumnsEqualWidth = true;
		this.setLayout(layout);

		FileChooser fileChooser = new FileChooser(this, "Select file");
		prop.setInputData(fileChooser);
		new EmptyPanel(this);
		new ExecuteButton(this);

	}

}
