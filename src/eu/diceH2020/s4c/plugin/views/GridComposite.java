package eu.diceH2020.s4c.plugin.views;

import java.io.File;
import java.io.IOException;
import java.util.Timer;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import eu.diceH2020.s4c.plugin.other.App;
import eu.diceH2020.s4c.plugin.other.SendState;
import eu.diceH2020.s4c.plugin.other.Sender;
import eu.diceH2020.s4c.plugin.other.State;
import eu.diceH2020.s4c.plugin.other.StateChecker;
import eu.diceH2020.s4c.plugin.other.StateHandler;

class GridComposite extends Composite {

	  public GridComposite(Composite c) {
	    super(c, SWT.BORDER);
	    GridLayout gl = new GridLayout();
	    gl.numColumns = 2;
	    this.setLayout(gl);
	    
	    FileChooser fileChooser = new FileChooser(this);


		Button run1Button = new Button(this, SWT.WRAP);
		run1Button.setText("send file");
		run1Button.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {

				File file = fileChooser.getFile();
				if ( //JsonToJava.checkMatching(file, App.class)
					 true	) 
						{
					System.out.println("The selected file matches the format");
				}
				;
				String s = "/Users/tueguemliliane/Documents/runtime-EclipseApplication/RuntimeFiles/data.sh";
				Sender.askConnection(s);

			}
		});

		Button rnButton = new Button(this, SWT.WRAP);
		rnButton.setText("send first file");

		rnButton.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {
				String s = "/Users/tueguemliliane/Documents/runtime-EclipseApplication/RuntimeFiles/doc.json";
				Sender.askConnection(s);
			}
		});

		createAskStateButton(this);
		
		createSendRunningStateButton(this);

	  }
	  
		/**
		 * @param parent
		 */
		private void createSendRunningStateButton(Composite parent) {
			Button sendRunningStateButton = new Button(parent, SWT.WRAP);
			sendRunningStateButton.setText("Run");
			sendRunningStateButton.addListener(SWT.Selection, new Listener() {
				@Override
				public void handleEvent(Event event) {
					SendState.sendStateRunning();
				}
			});
		}

		private static void createAskStateButton(Composite parent) {
			Button askStateButton = new Button(parent, SWT.WRAP);
			askStateButton.setText("ask state");

			askStateButton.addListener(SWT.Selection, new Listener() {
				@Override
				public void handleEvent(Event event) {

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
			});
		}
	  
	  
	  
	}
