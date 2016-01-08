package it.polimi.diceH2020.s4c.plugin.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;

public class EmptyPanel {

	public EmptyPanel(Composite parent) {
		Composite emptyPanel = new Composite(parent, SWT.BORDER);
		GridData panelGridData = new GridData();
		panelGridData.horizontalAlignment = SWT.FILL;
		panelGridData.verticalAlignment = SWT.FILL;
		panelGridData.grabExcessHorizontalSpace = true;
		panelGridData.grabExcessVerticalSpace = true;
		emptyPanel.setLayoutData(panelGridData);
	}
}