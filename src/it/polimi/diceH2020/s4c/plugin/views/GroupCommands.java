package it.polimi.diceH2020.s4c.plugin.views;

import java.io.File;
import java.io.IOException;
import java.util.Timer;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

class GroupCommands extends Composite {

	  public GroupCommands(Composite parent) {
	    super(parent, SWT.NO_BACKGROUND | SWT.BORDER);
	    this.setSize(parent.getSize());
	    GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		layout.makeColumnsEqualWidth = true;
		this.setLayout(layout);
	    
	    FileChooser fileChooser = new FileChooser(this, "Select file");
	    new EmptyPanel(this);
	    new ExecuteButton(this);

//		Button run1Button = new Button(this, SWT.WRAP);
//		run1Button.setText("send file");
//		run1Button.addListener(SWT.Selection, new Listener() {
//			@Override
//			public void handleEvent(Event event) {
//
//				File file = fileChooser.getFile();
//				if ( //JsonToJava.checkMatching(file, App.class)
//					 true	) 
//						{
//					System.out.println("The selected file matches the format");
//				}
//				;
//				String s = "/Users/tueguemliliane/Documents/runtime-EclipseApplication/RuntimeFiles/data.sh";
//				Sender.askConnection(s);
//
//			}
//		});
//
//		Button rnButton = new Button(this, SWT.WRAP);
//		rnButton.setText("send first file");
//
//		rnButton.addListener(SWT.Selection, new Listener() {
//			@Override
//			public void handleEvent(Event event) {
//				String s = "/Users/tueguemliliane/Documents/runtime-EclipseApplication/RuntimeFiles/doc.json";
//				Sender.askConnection(s);
//			}
//		});
//
//		createAskStateButton(this);
//		
//		createSendRunningStateButton(this);

	  }
  
	}
