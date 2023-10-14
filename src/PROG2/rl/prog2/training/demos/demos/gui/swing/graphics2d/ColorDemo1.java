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
public class ColorDemo1 extends JFrame {

	private JSlider rslider = new JSlider(JSlider.VERTICAL, 0, 255, 255);
	private JSlider gslider = new JSlider(JSlider.VERTICAL, 0, 255, 255);
	private JSlider bslider = new JSlider(JSlider.VERTICAL, 0, 255, 255);
	private int rvalue = rslider.getValue();
	private int gvalue = gslider.getValue();
	private int bvalue = bslider.getValue();

	private JPanel sliderPanel = new JPanel();

	private JPanel paintPanel = new JPanel() {
		{ // uses an initializer block to set the preferred size
			this.setPreferredSize(new Dimension(300, 200));
		}

		public void paint(Graphics g) {
			super.paint(g);
			g.setColor(new Color(rvalue, 0, 0));
			g.fillRect(000, 100, 100, 100);
			g.setColor(Color.black);
			g.drawString("(" + rvalue + ",0,0)", 0, 215);

			g.setColor(new Color(0, gvalue, 0));
			g.fillRect(100, 000, 100, 100);
			g.setColor(Color.black);
			g.drawString("(0," + gvalue + ",0)", 200, 15);

			g.setColor(new Color(0, 0, bvalue));
			g.fillRect(200, 100, 100, 100);
			g.setColor(Color.black);
			g.drawString("(0,0," + bvalue + ")", 200, 215);

			g.setColor(new Color(rvalue, gvalue, bvalue));
			g.fillRect(100, 100, 100, 100);
			g.setColor(Color.black);
			g.drawString("(" + rvalue + "," + gvalue + "," + bvalue + ")", 100,
					215);
		}
	};

	public ColorDemo1() {
		super("Color Demo 1");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		initSlider(rslider, "R");
		initSlider(gslider, "G");
		initSlider(bslider, "B");

		add(sliderPanel, BorderLayout.WEST);

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

		sliderPanel.setLayout(new FlowLayout());
		setLayout(new BorderLayout());
		this.add(sliderPanel, BorderLayout.WEST);

		this.add(paintPanel, BorderLayout.CENTER);

	}

	private void initSlider(JSlider slider, String label) {
		JPanel panel = new JPanel();
		panel.add(new JLabel(label));
		panel.add(slider);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		slider.setMajorTickSpacing(32);
		slider.setMinorTickSpacing(8);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);

		sliderPanel.add(panel);

	}

	public static void main(String[] args) {
		ColorDemo1 frame = new ColorDemo1();
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);
	}
}