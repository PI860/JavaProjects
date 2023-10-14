//package rl.prog2.demos.gui.swing;
//
//import java.awt.Dimension;
//import java.lang.reflect.Method;
//import java.util.ArrayList;
//
//import javax.swing.JFrame;
//import javax.swing.JList;
//import javax.swing.JScrollPane;
//import javax.swing.event.ListSelectionEvent;
//import javax.swing.event.ListSelectionListener;
//
//import rl.prog2.demos.fileio.QuizStarterSwing;
//import rl.prog2.demos.gui.swing.dice.DiceSimulator1;
//import rl.prog2.demos.gui.swing.dice.DiceSimulator2;
//import rl.prog2.demos.gui.swing.dice.DiceSimulator5;
//import rl.prog2.demos.gui.swing.dice.ExtendedDiceSimulator;
//import rl.prog2.demos.gui.swing.graphics2d.ColorDemo1;
//import rl.prog2.demos.gui.swing.graphics2d.ColorDemo2;
//import rl.prog2.demos.gui.swing.graphics2d.PaintDemo;
//import rl.prog2.demos.gui.swing.graphics2d.TransformationDemo;
//import rl.prog2.demos.gui.swing.mvc.RPNCalculator;
//
///**
// * Simple starter for all swing demo applications.
// *
// * @author Ruediger Lunde
// */
//public class SwingDemoStarter {
//
//	/**
//	 * Collects the classes of all swing demos and shows the demo starter frame.
//	 */
//	public static void main(String[] args) {
//		new SwingDemoStarter().start();
//	}
//
//	private JFrame frame;
//	private JList<Object> list;
//	protected ArrayList<Object> demos;
//
//	/** Constructs the demo starter frame. */
//	public SwingDemoStarter() {
//		frame = new JFrame("Swing Demo Starter");
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		list = new JList<Object>();
//		list.addListSelectionListener(new ListSelectionListener() {
//			@Override
//			public void valueChanged(ListSelectionEvent e) {
//				JList<?> list = (JList<?>) e.getSource();
//				Object val = list.getSelectedValue();
//				if (!e.getValueIsAdjusting() && val instanceof Class<?>) {
//					try {
//						Class<?> c = (Class<?>) val;
//						Method m = c.getMethod("main", String[].class);
//						m.invoke(null, (Object) new String[] {});
//					} catch (Exception ex) {
//						ex.printStackTrace();
//					}
//				}
//			}
//		});
//		JScrollPane scroller = new JScrollPane(list);
//		scroller.setPreferredSize(new Dimension(400, 400));
//		frame.add(scroller);
//		demos = new ArrayList<Object>();
//	}
//
//	/**
//	 * Collects the classes of all swing demos and shows the demo starter frame.
//	 */
//	public void start() {
//		registerDemos();
//		list.setListData(demos.toArray());
//		frame.pack();
//		frame.setVisible(true);
//	}
//
//	/** Registers the demo classes. Override to customize the list. */
//	protected void registerDemos() {
//		demos.add("-- swing introduction --");
//		demos.add(HelloWorld.class);
//		demos.add(SwingComponentDemo.class);
//		demos.add(LayoutManagerDemo.class);
//		demos.add(DiceSimulator1.class);
//		demos.add(DiceSimulator2.class);
//		demos.add(DiceSimulator5.class);
//		demos.add(ExtendedDiceSimulator.class);
//		demos.add(ButtonModelDemo.class);
//		demos.add(RPNCalculator.class);
//		demos.add("-- swing advanced --");
//		demos.add(BorderDemo.class);
//		demos.add(DialogDemo.class);
//		demos.add(SwingContainerDemo.class);
//		demos.add(JTableDemo.class);
//		demos.add(QueueTableModelDemo.class);
//		demos.add(ColorDemo1.class);
//		demos.add(ColorDemo2.class);
//		demos.add(PaintDemo.class);
//		demos.add(TransformationDemo.class);
//		demos.add("-- file i/o --");
//		demos.add(QuizStarterSwing.class);
//	}
//}
