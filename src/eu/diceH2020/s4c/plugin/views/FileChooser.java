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

	private Text mText;
	private Button mButton;
	private String title = null;

	public FileChooser(Composite parent) {
		super(parent, SWT.BORDER);
		GridData gridData = new GridData(); 
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = SWT.LEFT;
		gridData.verticalAlignment = SWT.END;
		this.setLayoutData(gridData);
		GridLayout layout = new GridLayout(2, false);
		this.setLayout(layout);

		//this.setSize(parent.getSize());		
		createContent();
	}

	public void createContent() {


		mText = new Text(this, SWT.SINGLE | SWT.BORDER);
		GridData textDataGrid = new GridData(GridData.FILL_BOTH);
		textDataGrid.grabExcessHorizontalSpace = true;
		textDataGrid.horizontalAlignment = GridData.FILL;
		mText.setLayoutData(textDataGrid);


		mButton = new Button(this, SWT.NONE);
		mButton.setText("...");
		GridData buttonGridData = new GridData();
		buttonGridData.verticalAlignment = GridData.FILL;
		buttonGridData.horizontalAlignment = GridData.FILL;
		buttonGridData.grabExcessVerticalSpace = true;
		buttonGridData.grabExcessHorizontalSpace = true;
		buttonGridData.horizontalSpan = 1;

		mButton.setLayoutData(buttonGridData);
		mButton.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog dlg = new FileDialog(mButton.getShell(),  SWT.OPEN  );
				dlg.setText("Open");
				String path = dlg.open();
				if (path == null) return;
				mText.setText(path);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Fix this
				
			}
		});
	}

	public String getText() {
		return mText.getText();

	}

	public Text getTextControl() {
		return mText;		
	}

	public File getFile() {
		String text = mText.getText();
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