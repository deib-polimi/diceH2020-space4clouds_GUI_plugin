package it.polimi.diceH2020.s4c.plugin.views;

import javax.swing.text.Style;

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

	public TextExtended(Composite parent, String label, int... style) {
		super(parent, SWT.BORDER);
		addContent(parent, label, style);
	}

	/**
	 * @param parent
	 * @param label
	 * @param style
	 */
	private void addContent(Composite parent, String label, int[] style) {
		GridLayout layout = new GridLayout(2, true);
		this.setLayout(layout);
		GridData panelDataGrid = new GridData();
		panelDataGrid.grabExcessHorizontalSpace = true;
		panelDataGrid.horizontalAlignment = SWT.FILL;
		panelDataGrid.grabExcessVerticalSpace = false;
		panelDataGrid.verticalAlignment = SWT.TOP;
		this.setLayoutData(panelDataGrid);
		this.setSize(parent.getSize());
		createContent(label, style);
	}

	private void createContent(String label, int[] style) {
		if (style.length > 0)
			textBox = new Text(this, SWT.SINGLE | SWT.BORDER | style[0]);
		else
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
		labelDataGrid.grabExcessVerticalSpace = true;
		labelDataGrid.verticalAlignment = SWT.FILL;
		labelDataGrid.horizontalAlignment = SWT.FILL;
		labelTextBox.setLayoutData(labelDataGrid);
		labelTextBox.setText(label);

	}

}
