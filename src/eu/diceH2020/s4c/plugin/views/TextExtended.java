package eu.diceH2020.s4c.plugin.views;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class TextExtended extends Composite {

	private Text textBox;
	public void setTextBox(Text textBox) {
		this.textBox = textBox;
	}

	private Label labelTextBox;
	
	public Text getTextBox() {
		return textBox;
	}

	public TextExtended(Composite parent, String label) {
		super(parent, SWT.BORDER);
		GridLayout layout = new GridLayout(2, true);
		this.setLayout(layout);
		GridData panelDataGrid = new GridData();
		panelDataGrid.grabExcessHorizontalSpace = true;
		panelDataGrid.horizontalAlignment = SWT.FILL;
		panelDataGrid.grabExcessVerticalSpace  = false;
		panelDataGrid.verticalAlignment = SWT.TOP;
		this.setLayoutData(panelDataGrid);
		this.setSize(parent.getSize());
		createContent(label);
		
	}

	private void createContent(String label) {
		textBox = new Text(this, SWT.SINGLE | SWT.BORDER);
	    textBox.setText("");
		GridData textDataGrid = new GridData();
		textDataGrid.grabExcessHorizontalSpace = true;
		textDataGrid.grabExcessVerticalSpace = true;
		textDataGrid.verticalAlignment = SWT.FILL;
		textDataGrid.horizontalAlignment = SWT.FILL;
		textBox.setLayoutData(textDataGrid);	
		textBox.setSize(100, 10);
		
	    labelTextBox = new Label(this, SWT.SINGLE);
		GridData labelDataGrid = new GridData();
		labelDataGrid.grabExcessHorizontalSpace = true;
		textDataGrid.grabExcessVerticalSpace = true;
		labelDataGrid.verticalAlignment = SWT.FILL;
		labelDataGrid.horizontalAlignment = SWT.FILL;
		labelTextBox.setLayoutData(labelDataGrid);
	    labelTextBox.setText(label);
		
	}

}
