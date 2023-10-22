package ALGO.gs.lektion03;
import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class Pythagoras extends JFrame {

	
	private JPanel jContentPane = null;
	private JPanel pnlPaint = null;
	private JPanel pnlInput = null;
	private JLabel lblWinkel = null;
	private JTextField txtWinkel = null;
	private JLabel lblTiefe = null;
	private JTextField txtTiefe = null;
	private JLabel jLabel = null;
	private JCheckBox chkFarbig = null;
	/**
	 * This method initializes pnlPaint	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPnlPaint() {
		if (pnlPaint == null) {
			pnlPaint = new JPanel() {
				public void paint(Graphics g) {
					super.paint(g);
					try {
					int tiefe = Integer.parseInt(txtTiefe.getText());
					double winkel = Math.toRadians(Double.parseDouble(txtWinkel.getText()));
					paintPythagorasTree(tiefe, winkel, 300,20, 400, 20, g);
					}
					catch (NumberFormatException e) {
						
					}
				}
			};
		}
		return pnlPaint;
	}

	
	private void paintPythagorasTree(int tiefe, double alpha,
			double startx, double starty, 
			double endx, double endy, 
	        Graphics g) {
		if (tiefe >= 0) {
			
			double dx = endx - startx;
			double dy = endy - starty;
			int h = pnlPaint.getHeight();
			
			int[] xpos = {(int)startx, (int)(endx), (int)(endx-dy), (int) (startx-dy)};
			int[] ypos = {h-(int)starty, h-(int)(endy), h-(int)(endy+dx), h-(int) (starty+dx)};
			
			if (getChkFarbig().isSelected()) {
				//g.setColor(new Color(20 * tiefe % 256, 40 * tiefe % 256, 60 * tiefe % 256));

				g.setColor(new Color((int)(Math.random()*256),
				         (int)(Math.random()*256), 
				         (int)(Math.random()*256)));
				g.fillPolygon(xpos, ypos, 4);
				
			}
			else {
				g.drawPolygon(xpos, ypos, 4);				
			}



			double delta;  ;
			
			if (dx < 0)
				delta = Math.atan((double)dy / dx) + Math.PI;
			else
				delta = Math.atan((double)dy / dx);
			
			double c = Math.sqrt(dx * dx + dy * dy);
			double b = c * Math.cos(alpha);
			 
			double mittex = startx - dy + b * Math.cos(alpha + delta);
			double mittey = starty + dx + b * Math.sin(alpha + delta);
			

			paintPythagorasTree(tiefe-1, alpha, startx-dy, starty+dx, mittex, mittey, g);
			paintPythagorasTree(tiefe-1, alpha, mittex, mittey, endx-dy, endy+dx, g);
				
		}
	}
	
	/** This method initializes pnlInput	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPnlInput() {
		if (pnlInput == null) {
			jLabel = new JLabel();
			jLabel.setText("farbig:");
			lblTiefe = new JLabel();
			lblTiefe.setText("Tiefe: ");
			lblWinkel = new JLabel();
			lblWinkel.setText("Winkel: ");
			pnlInput = new JPanel();
			pnlInput.add(lblWinkel, null);
			pnlInput.add(getTxtWinkel(), null);
			pnlInput.add(lblTiefe, null);
			pnlInput.add(getTxtTiefe(), null);
			pnlInput.add(jLabel, null);
			pnlInput.add(getChkFarbig(), null);
		}
		return pnlInput;
	}

	/**
	 * This method initializes txtWinkel	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtWinkel() {
		if (txtWinkel == null) {
			txtWinkel = new JTextField();
			txtWinkel.setColumns(8);
			txtWinkel.setText("40");
			txtWinkel.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					pnlPaint.repaint();
				}
			});
		}
		return txtWinkel;
	}

	/**
	 * This method initializes txtTiefe	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtTiefe() {
		if (txtTiefe == null) {
			txtTiefe = new JTextField();
			txtTiefe.setColumns(8);
			txtTiefe.setText("4");
			txtTiefe.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					pnlPaint.repaint();
				}
			});
		}
		return txtTiefe;
	}

	/**
	 * @param args
	 */


	/**
	 * This is the default constructor
	 */
	public Pythagoras() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(700, 500);
		this.setPreferredSize(new java.awt.Dimension(600,400));
		this.setContentPane(getJContentPane());
		this.setTitle("Pythagoras-Baum");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getPnlPaint(), java.awt.BorderLayout.CENTER);
			jContentPane.add(getPnlInput(), java.awt.BorderLayout.SOUTH);
		}
		return jContentPane;
	}
	
	/**
	 * This method initializes chkFarbig	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getChkFarbig() {
		if (chkFarbig == null) {
			chkFarbig = new JCheckBox();
			chkFarbig.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
			          getPnlPaint().repaint(); 
				}
			});
		}
		return chkFarbig;
	}


	public static void main(String[] args) {
		Pythagoras frame = new Pythagoras();
		frame.setVisible(true);
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
