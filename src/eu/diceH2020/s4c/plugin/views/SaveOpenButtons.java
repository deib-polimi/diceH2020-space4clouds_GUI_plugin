package eu.diceH2020.s4c.plugin.views;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import java.util.Timer;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;

import eu.diceH2020.s4c.plugin.other.State;
import eu.diceH2020.s4c.plugin.other.StateChecker;
import eu.diceH2020.s4c.plugin.other.StateHandler;

public class SaveOpenButtons extends Composite {

	private PropertiesSingleton propSingleton = PropertiesSingleton.getInstance();
	
	public SaveOpenButtons(Composite parent) {
		super(parent, SWT.BORDER);
		GridLayout layout = new GridLayout(3, true);
		layout.makeColumnsEqualWidth = true;
		this.setLayout(layout);
		GridData panelDataGrid = new GridData();
		panelDataGrid.grabExcessHorizontalSpace = true;
		panelDataGrid.horizontalAlignment = SWT.FILL;
		panelDataGrid.grabExcessVerticalSpace = false;
		panelDataGrid.verticalAlignment = SWT.BOTTOM;
		this.setLayoutData(panelDataGrid);
		this.setSize(parent.getSize());
		createContent();

	}

	private void createContent() {
		Button save = new Button(this, SWT.PUSH);
		save.setText("Save");

		save.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog dlg = new FileDialog(save.getShell(), SWT.SAVE);
				dlg.setText("Save");
				dlg.setFilterExtensions(new String[] { "*.properties" });
				dlg.setFileName("save.properties");
				String path = dlg.open();
				if (path == null)
					return;
				Properties prop = new Properties();
				OutputStream output = null;

				try {
					output = new FileOutputStream(path);

					// set the properties value
					prop.setProperty("address", propSingleton.getAddressString());
					prop.setProperty("port", propSingleton.getPortString());
					prop.setProperty("username", propSingleton.getUsernameString());
					prop.setProperty("password", propSingleton.getPasswordString());
					prop.setProperty("accuracy", propSingleton.getAccuracyString());
					prop.setProperty("cycles", propSingleton.getCyclesString());
					// save properties to project root folder
					prop.store(output, null);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Fix this

			}
		});

		Button open = new Button(this, SWT.PUSH);
		open.setText("Open");
		open.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog dlg = new FileDialog(save.getShell(), SWT.OPEN);
				dlg.setText("open");
				dlg.setFilterExtensions(new String[] { "*.properties" });
				dlg.setFileName("save.properties");
				String path = dlg.open();
				if (path == null)
					return;
				Properties properties = new Properties();
				try {
					properties.load(new FileInputStream(path));
					propSingleton.setAddressString(properties.getProperty("address"));
					propSingleton.setPortString(properties.getProperty("port"));
					propSingleton.setUsernameString(properties.getProperty("username"));
					propSingleton.setPasswordString(properties.getProperty("password"));
					propSingleton.setAccuracyString(properties.getProperty("accuracy"));
					propSingleton.setCyclesString(properties.getProperty("cycles"));
				} catch (IOException ex) {
				} 
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Fix this

			}
		});

		Button connect = new Button(this, SWT.PUSH);
		connect.setText("Connect");

		connect.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				StateChecker checker = new StateChecker();
				// running timer task as daemon thread
				Timer scheduler = new Timer(true);
				// in this way the timer task is executed in a cyclic
				// way
				scheduler.scheduleAtFixedRate(checker, 0, 10 * 1000);
				System.out.println("TimerTask started");

				// todo: this cannot work
				StateHandler stateHandler = new StateHandler();
				if (stateHandler.getCurrentState() == State.RUNNING)
					scheduler.cancel();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Fix this

			}
		});

	}

}
