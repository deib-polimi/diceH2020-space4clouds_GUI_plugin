package it.polimi.diceH2020.s4c.plugin.views;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

import it.polimi.diceH2020.s4c.plugin.other.RestInteractor;

public class ExecuteButton extends Composite {


	private PropertiesSingleton prop = PropertiesSingleton.getInstance();
	
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

		createContent();
	}

	private void createContent() {
		Button empty = new Button(this, SWT.PUSH);
		GridData gridData1 = new GridData();
		gridData1.grabExcessHorizontalSpace = true;
		gridData1.grabExcessVerticalSpace = false;
		empty.setLayoutData(gridData1);
		empty.setVisible(false);
		Button execute = new Button(this, SWT.PUSH);
		execute.setText("Start");
		execute.setAlignment(SWT.RIGHT);
		
		execute.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				if (prop.getInputData().isJsonLoaded()) {
					URL url;
					try {
						url = new URL("http://" + prop.getAddressString() + ":" + prop.getPortString() + "/inputdata");
						String json = prop.getInputData().getJson();
						RestInteractor.postData(json, url);
					} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}

}
