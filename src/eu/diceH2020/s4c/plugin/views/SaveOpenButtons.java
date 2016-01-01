package eu.diceH2020.s4c.plugin.views;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;

public class SaveOpenButtons extends Composite {

	public SaveOpenButtons(Composite parent, textExtended address, textExtended port) {
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
		createContent(address, port);

	}

	private void createContent(textExtended address, textExtended port) {
		Button save = new Button(this, SWT.PUSH);
		save.setText("Save");

		save.addSelectionListener(new SelectionListener() {

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
					prop.setProperty("address", address.getTextBox().getText());
					prop.setProperty("port", port.getTextBox().getText());

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
					address.getTextBox().setText(properties.getProperty("address"));
					port.getTextBox().setText(properties.getProperty("port"));
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
	}

}
