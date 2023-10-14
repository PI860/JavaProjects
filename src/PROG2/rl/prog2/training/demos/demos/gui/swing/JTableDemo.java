package rl.prog2.demos.gui.swing;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

/**
 * Simple demo showing how to display values within a two dimensional array
 * using a JTable.
 * 
 * @author Ruediger Lunde
 */
public class JTableDemo {

	/** Starts the demo. */
	public static void main(String[] args) {
		new JTableDemo().start();
	}

	/**
	 * Shows a JTable for a two dimensional array of data. Note that values are
	 * replaced by strings when editing fields - even if they were of other type
	 * before!
	 */
	void start() {
		JFrame frame = new JFrame("JTable Demo (try to edit fields!)");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		String[] header = new String[3];
		final Object[][] data = new Object[10][3];
		for (int col = 0; col < 3; col++) {
			header[col] = "Column " + col;
			for (int row = 0; row < 10; row++)
				data[row][col] = "(" + row + ", " + col + ")";
		}
		// JTable table = new JTable(data, header);
		JTable table = new JTable(new Integer[][] {{1, 2, 3}}, header);
		table.getModel().addTableModelListener(new TableModelListener() {
			@Override
			public void tableChanged(TableModelEvent e) {
				System.out.println("New value: "
						+ data[e.getFirstRow()][e.getColumn()] + " at ("
						+ e.getFirstRow() + ", " + e.getColumn() + ")");
			}
		});
		frame.add(new JScrollPane(table));

		frame.setSize(500, 300);
		frame.setVisible(true);
	}
}