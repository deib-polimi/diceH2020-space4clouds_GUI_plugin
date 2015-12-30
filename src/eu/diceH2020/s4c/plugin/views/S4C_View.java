package eu.diceH2020.s4c.plugin.views;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Timer;

import org.apache.commons.io.FileUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
//import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;

import eu.diceH2020.s4c.plugin.other.JsonToJava;

/**
 * @author ciavotta This View shows the widgets to interact with SPACE4Cloud WS
 */
public class S4C_View extends ViewPart {
	public static final String ID = "S4C_View";

	String lstNameFiles = null;

	@Override
	public void createPartControl(Composite parent) {

		Composite top = new Composite(parent, SWT.NONE);// embedded Composite

		// setup the layout of top to be GridLayout.
		GridLayout layout = new GridLayout();
		layout.marginHeight = 10;
		layout.marginWidth = 10;
		layout.numColumns = 2;
		top.setLayout(layout);

		// top banner
		Composite panel = new Composite(top, SWT.NONE);// banner is added to
		// "top"
		GridData panelGridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL, GridData.VERTICAL_ALIGN_BEGINNING, true,
				false);
		panelGridData.grabExcessHorizontalSpace = true;
		panelGridData.grabExcessVerticalSpace = true;
		panel.setLayoutData(panelGridData);
		GridLayout gridLayout = new GridLayout();
		gridLayout.marginHeight = 5;
		gridLayout.marginWidth = 5;
		gridLayout.numColumns = 2;
		gridLayout.makeColumnsEqualWidth = true;
		panel.setLayout(gridLayout);

		final FileChooser fileChooser = new FileChooser(panel);

		// first button
		Button selectButton = new Button(panel, SWT.WRAP);
		selectButton.setText("Select a File");
		
		// message contents
		final Text text = new Text(panel, SWT.MULTI | SWT.BORDER);
		// here like the banner, text is added to "top".
		text.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		// Declaration of button run
		selectButton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				String list = fileChooser.getText();
				String temp = list;
				text.append(temp + "\n");
				lstNameFiles = list;
				try {
					copyfile(lstNameFiles);
				} catch (IOException e) {
					System.out.println("error");
					e.printStackTrace();
				}
			}
		});


		Button run1Button = new Button(panel, SWT.WRAP);
		run1Button.setText("send file");

		// message contents
		//final Text tex = new Text(top, SWT.MULTI | SWT.WRAP);

		// // here like the banner, text is added to "top".
		// tex.setText("000");
		// tex.setLayoutData(new GridData(GridData.FILL_BOTH));

		run1Button.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {

				File file = fileChooser.getFile();
				try {
					copyfile(file.getAbsolutePath());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				try {
					if (JsonToJava.checkMatching(file, App.class)) {
						System.out.println("The selected file matches the format");
					}
				} catch (IOException e) {
					System.out.println("The selected file does not match the format");
					e.printStackTrace();
				}
				;
				String s = "/Users/tueguemliliane/Documents/runtime-EclipseApplication/RuntimeFiles/data.sh";
				Sender.askConnection(s);

			}
		});

		Button rnButton = new Button(panel, SWT.WRAP);
		rnButton.setText("send first file");

		// message contents
		// final Text tx = new Text(top, SWT.MULTI | SWT.WRAP);
		//
		// // here like the banner, text is added to "top".
		// tx.setText("000");
		// tx.setLayoutData(new GridData(GridData.FILL_BOTH));

		rnButton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				String s = "/Users/tueguemliliane/Documents/runtime-EclipseApplication/RuntimeFiles/doc.json";
				Sender.askconnection2(s);
			}
		});

		Button rubutton = new Button(panel, SWT.WRAP);
		rubutton.setText("ask state");

		// // message contents
		// final Text texi = new Text(top, SWT.MULTI | SWT.WRAP);
		// // here like the banner, text is added to "top".
		// texi.setText("000");
		// texi.setLayoutData(new GridData(GridData.FILL_BOTH));

		rubutton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {

				Thread insideThread = new Thread() {
					public void run() {
						System.out.println("Inside the thread : " + Thread.currentThread().getName());
						StateChecker checker = new StateChecker();

						// running timer task as daemon thread
						Timer scheduler = new Timer(true);

						// in this way the timer task is executed in a cyclic
						// way
						scheduler.scheduleAtFixedRate(checker, 0, 10 * 1000);
						System.out.println("TimerTask started");
					}
				};
				insideThread.start();

				// todo: this cannot work
				StateHandler stateHandler = new StateHandler();
				if (stateHandler.getCurrentState() == State.RUNNING)
					insideThread.stop(); // todo Questa cosa si deve sistemare
											// al più presto.
			}
		});

		Button rButton = new Button(panel, SWT.WRAP);
		rButton.setText("reset state");

		// final Label label = new Label(parent, SWT.NONE);
		// message contents
		final Text texti = new Text(top, SWT.MULTI | SWT.WRAP);
		// here like the banner, text is added to "top".
		texti.setText("");
		texti.setLayoutData(new GridData(GridData.FILL_BOTH));

		rButton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				SendState.invio();
			}
		});
	}

	public void copyfile(String name) throws IOException {

		File file = new File(name);
		File file1 = new File("/Users/tueguemliliane/Documents/runtime-EclipseApplication/RuntimeFiles/data.sh"); // "booking.json");
		File file2 = new File("/Users/tueguemliliane/Documents/runtime-EclipseApplication/RuntimeFiles/doc.json");
		BufferedReader br = new BufferedReader(new FileReader(file));

		String x = br.readLine();
		String line = x;
		String line2;
		while (x != null && !x.contains("}")) {
			x = br.readLine();
			line = line + x;
		}
		FileUtils.writeStringToFile(file1, line);
		x = br.readLine();
		line2 = "";// x;
		while (x != null) {
			line2 = line2 + "\n" + x;
			x = br.readLine();
		}
		FileUtils.writeStringToFile(file2, line2);
		System.out.println("done");
		br.close();
	}

	@Override
	public void setFocus() {

	}

}
