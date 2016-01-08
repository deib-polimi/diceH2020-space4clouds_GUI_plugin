package it.polimi.diceH2020.s4c.plugin.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

public class ExecuteButton extends Composite {

	public ExecuteButton(Composite parent) {
		super(parent, SWT.BORDER);
		GridLayout layout = new GridLayout(2, true);
		layout.makeColumnsEqualWidth = false;
		this.setLayout(layout);
		GridData panelDataGrid = new GridData();
		panelDataGrid.grabExcessHorizontalSpace = true;
		panelDataGrid.horizontalAlignment = SWT.FILL;
		panelDataGrid.grabExcessVerticalSpace = false;
		panelDataGrid.verticalAlignment = SWT.BOTTOM;
		this.setLayoutData(panelDataGrid);
//		this.setSize(parent.getSize());
		createContent();
	}

	private void createContent() {
		// TODO Auto-generated method stub
		Button empty = new Button(this, SWT.PUSH);
		GridData gridData1 = new GridData();
		gridData1.grabExcessHorizontalSpace = true;
		gridData1.grabExcessVerticalSpace = false;
		empty.setLayoutData(gridData1);
		empty.setVisible(false);
		Button execute = new Button(this, SWT.PUSH);
		execute.setText("Start");
		execute.setAlignment(SWT.RIGHT);
//		GridData gridData = new GridData();
//		gridData.grabExcessHorizontalSpace = false;
//		gridData.grabExcessVerticalSpace = false;
//		gridData.horizontalAlignment = SWT.RIGHT;
//		gridData.verticalAlignment = SWT.BOTTOM;
//		//gridData.horizontalIndent  = 150;
//		save.setLayoutData(gridData);
		
		execute.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}

}
