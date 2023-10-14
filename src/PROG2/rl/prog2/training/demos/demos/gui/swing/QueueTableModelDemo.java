package rl.prog2.demos.gui.swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;

/**
 * This demo shows how to use table models using a simple FIFO queue as an
 * example.
 * 
 * @author Ruediger Lunde
 * 
 */
public class QueueTableModelDemo {

	/** Starts the demo. */
	public static void main(String[] args) {
		new QueueTableModelDemo().start();
	}

	JTextField inputField;
	JTextField outputField;
	QueueWithTableModel queue;

	/** Creates the queue table model demo frame an shows it. */
	void start() {
		JFrame frame = new JFrame("Queue Table Model Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		queue = new QueueWithTableModel();

		JPanel panel = new JPanel();
		JLabel label = new JLabel("New Task: ");
		panel.add(label);
		inputField = new JTextField(30);
		panel.add(inputField);
		JButton button = new JButton("Add");
		panel.add(button);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				queue.add(new Task(inputField.getText()));
			}
		});
		frame.add(panel, BorderLayout.NORTH);

		JTable table = new JTable(queue.getTableModel());
		table.setDefaultRenderer(Date.class, new DateCellRenderer());
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(200, 200));
		frame.add(scrollPane, BorderLayout.CENTER);

		panel = new JPanel();
		label = new JLabel("Removed Task: ");
		panel.add(label);
		outputField = new JTextField(30);
		panel.add(outputField);
		button = new JButton("Remove");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!queue.isEmpty()) {
					Task task = queue.remove();
					outputField.setText(task.title + "  (" + task.date + ")");
				} else
					outputField.setText("");
			}
		});
		panel.add(button);
		frame.add(panel, BorderLayout.SOUTH);

		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Implements a simple FIFO queue. Method <code>getTableModel</code>
	 * provides a model which can be used to display the current queue state in
	 * a JTable.
	 * 
	 * @author Ruediger Lunde
	 */
	public static class QueueWithTableModel {
		LinkedList<Task> queue;
		QueueTableModel model;

		public QueueWithTableModel() {
			queue = new LinkedList<Task>();
			model = new QueueTableModel();
		}

		public TableModel getTableModel() {
			return model;
		}

		public boolean isEmpty() {
			return queue.isEmpty();
		}

		public boolean add(Task task) {
			boolean result = queue.add(task);
			model.queueStateChanged();
			return result;
		}

		public Task remove() {
			Task result = queue.remove();
			model.queueStateChanged();
			return result;
		}

		public Task element() {
			return queue.element();
		}

		/**
		 * The table model of the queue has access to the queue and needs to be
		 * informed about every change of the queue state (to be able to inform
		 * all views...). It is therefore implemented as inner class of the
		 * queue class.
		 * 
		 * @author Ruediger lunde
		 */
		@SuppressWarnings("serial")
		class QueueTableModel extends AbstractTableModel {

			@Override
			public String getColumnName(int col) {
				return col == 0 ? "Title" : "Time";
			}

			@Override
			public int getColumnCount() {
				return 2;
			}

			@Override
			public Class<?> getColumnClass(int col) { // for rendering!
				return col == 0 ? String.class : Date.class;
			}

			@Override
			public int getRowCount() {
				return queue.size();
			}

			@Override
			public Object getValueAt(int rowIndex, int columnIndex) {
				Task task = queue.get(rowIndex);
				return (columnIndex == 0 ? task.title : task.date);
			}

			public void queueStateChanged() {
				super.fireTableDataChanged();
			}
		}
	}

	/**
	 * Demonstrates how to change the way, values are shown in the table. Here,
	 * for date values only hours, minutes, and seconds are displayed.
	 * 
	 * @author Ruediger Lunde
	 */
	@SuppressWarnings("serial")
	public static class DateCellRenderer extends DefaultTableCellRenderer {
		@Override
		public void setValue(Object value) {
			if (value instanceof Date) {
				SimpleDateFormat df = new SimpleDateFormat("hh:mm:ss");
				setText(df.format((Date) value));
			} else
				super.setValue(value);
		}
	}

	/** A task consists of a title and a date. */
	public static class Task {
		String title;
		Date date;

		public Task(String title) {
			this.title = title;
			date = new Date();
		}
	}
}
