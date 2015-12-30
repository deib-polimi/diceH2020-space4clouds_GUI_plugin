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

public class FileChooser extends Composite {

	Text mText;
	Button mButton;
	String title = null;

	public FileChooser(Composite parent) {
		super(parent, SWT.NULL);
		createContent();
	}

	public void createContent() {
		GridLayout layout = new GridLayout(2, false);
		setLayout(layout);

		mText = new Text(this, SWT.SINGLE | SWT.BORDER);
		GridData gd = new GridData(GridData.FILL_BOTH);
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalAlignment = GridData.FILL;
		mText.setLayoutData(gd);


		mButton = new Button(this, SWT.NONE);
		mButton.setText("...");
		mButton.addSelectionListener(new SelectionListener() {

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