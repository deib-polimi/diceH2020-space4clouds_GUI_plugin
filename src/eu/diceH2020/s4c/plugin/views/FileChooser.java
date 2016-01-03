package eu.diceH2020.s4c.plugin.views;

import java.io.File;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Text;

/**
 * @author ciavotta
 * Create a composite object that is a Text widget and a button
 */
public class FileChooser extends Composite {

	private Text textBox;
	private Button mButton;
	private String title = null;

	public FileChooser(Composite parent, String label) {
		super(parent, SWT.BORDER);
		GridLayout layout = new GridLayout(4, true);
		this.setLayout(layout);
		GridData panelDataGrid = new GridData();
		panelDataGrid.grabExcessHorizontalSpace = true;
		panelDataGrid.horizontalAlignment = SWT.FILL;
		panelDataGrid.grabExcessVerticalSpace = false;
		panelDataGrid.verticalAlignment = SWT.TOP;
		this.setLayoutData(panelDataGrid);
		this.setSize(parent.getSize());
		createContent( label);
	}

	public void createContent(String label) {


		textBox = new Text(this, SWT.SINGLE | SWT.BORDER| SWT.READ_ONLY);
		GridData textDataGrid = new GridData();
		textDataGrid.horizontalSpan = 2;
		textDataGrid.grabExcessHorizontalSpace = true;
		textDataGrid.grabExcessVerticalSpace = true;
		textDataGrid.verticalAlignment = SWT.FILL;
		textDataGrid.horizontalAlignment = SWT.FILL;
		textBox.setLayoutData(textDataGrid);
		textBox.setSize(100, 10);


		mButton = new Button(this, SWT.NONE);
		mButton.setText(label);
		GridData buttonDataGrid = new GridData();
		buttonDataGrid.horizontalSpan = 2;
		buttonDataGrid.grabExcessHorizontalSpace = true;
		buttonDataGrid.grabExcessVerticalSpace = true;
		buttonDataGrid.verticalAlignment = SWT.FILL;
		buttonDataGrid.horizontalAlignment = SWT.FILL;
		mButton.setLayoutData(buttonDataGrid);
		mButton.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog dlg = new FileDialog(mButton.getShell(),  SWT.OPEN  );
				dlg.setText("Open");
				String path = dlg.open();
				if (path == null) return;
				textBox.setText(path);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Fix this
				
			}
		});
	}

	public String getText() {
		return textBox.getText();

	}

	public Text getTextControl() {
		return textBox;		
	}

	public File getFile() {
		String text = textBox.getText();
		if (text.length() == 0) return null;
		return new File(text);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


}