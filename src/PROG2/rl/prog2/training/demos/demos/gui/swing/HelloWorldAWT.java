package rl.prog2.demos.gui.swing;

import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Simple application which opens a window showing a button with the text
 * "Hello World!" (AWT version).
 * 
 * @author Ruediger Lunde
 * 
 */
public class HelloWorldAWT {
	public static void main(String[] args) {
		// create a frame and set its title
		Frame frame = new Frame();
		frame.setTitle("My first GUI (AWT)");
		// exit the application when the frame's close button is pressed
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);	
			}});
		// create a button and set its text
		Button button = new Button("Hello World :-)");
		button.setFont(new Font("SansSerif", Font.PLAIN, 30));
		// add the button to the so called content pane of the frame
		frame.add(button);
		// set the size of the frame and show it to the user
		frame.setSize(300, 200);
		frame.setVisible(true);
	}
}
