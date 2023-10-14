package rl.prog2.demos.gui.swing;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Simple application which opens a window showing a button with the text
 * "Hello World!".
 * 
 * @author Ruediger Lunde
 * 
 */
public class HelloWorld {
	public static void main(String[] args) {
		// create a frame and set its title
		JFrame frame = new JFrame();
		frame.setTitle("My first GUI");
		// exit the application when the frame's close button is pressed
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// create a button and set its text
		JButton button = new JButton("Hello World :-)");
		button.setFont(new Font("SansSerif", Font.PLAIN, 30));
		// add the button to the so called content pane of the frame
		frame.add(button);
		// set the size of the frame and show it to the user
		frame.setSize(300, 200);
		frame.setVisible(true);
	}
}
