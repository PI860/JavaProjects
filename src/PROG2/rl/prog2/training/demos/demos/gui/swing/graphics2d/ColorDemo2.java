package rl.prog2.demos.gui.swing.graphics2d;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class ColorDemo2 extends JFrame {

	private JSlider rslider = new JSlider(JSlider.VERTICAL, 0, 255, 128);
	private JSlider gslider = new JSlider(JSlider.VERTICAL, 0, 255, 128);
	private JSlider bslider = new JSlider(JSlider.VERTICAL, 0, 255, 128);
	private JSlider aslider = new JSlider(JSlider.VERTICAL, 0, 255, 128);
	private int rvalue = rslider.getValue();
	private int gvalue = gslider.getValue();
	private int bvalue = bslider.getValue();
	private int avalue = aslider.getValue();

	private JPanel sliderPanel = new JPanel();
	private JPanel paintPanel = new JPanel() {
		{ // uses an initializer block to set the preferred size
			this.setPreferredSize(new Dimension(500, 500));
		}
		public void paint(Graphics g) {
			super.paint(g);
			g.setColor(new Color(rvalue, 0, 0, avalue));
			g.fillRect(000, 100, 300, 300);

			g.setColor(new Color(0, gvalue, 0, avalue));
			g.fillRect(100, 000, 300, 300);

			g.setColor(new Color(0, 0, bvalue, avalue));
			g.fillRect(200, 200, 300, 300);
		}

	};

	public ColorDemo2() {
		super("Color Demo 2");

		initSlider(rslider, "R");
		initSlider(gslider, "G");
		initSlider(bslider, "B");
		initSlider(aslider, "Alpha");

		rslider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				rvalue = rslider.getValue();
				paintPanel.repaint();
			}
		});

		gslider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				gvalue = gslider.getValue();
				paintPanel.repaint();
			}
		});

		bslider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				bvalue = bslider.getValue();
				paintPanel.repaint();
			}
		});

		aslider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				avalue = aslider.getValue();
				paintPanel.repaint();
			}
		});

		sliderPanel.setLayout(new FlowLayout());

		setLayout(new BorderLayout());
		add(sliderPanel, BorderLayout.WEST);

		paintPanel.setSize(500, 500);
		paintPanel.setBackground(Color.WHITE);

		add(paintPanel, BorderLayout.CENTER);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void initSlider(JSlider slider, String label) {
		JPanel panel = new JPanel();
		panel.add(new JLabel(label));
		panel.add(slider);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		sliderPanel.add(panel);
		slider.setMajorTickSpacing(32);
		slider.setMinorTickSpacing(8);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);

	}

	public static void main(String[] args) {
		ColorDemo2 frame = new ColorDemo2();
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);
	}
}
