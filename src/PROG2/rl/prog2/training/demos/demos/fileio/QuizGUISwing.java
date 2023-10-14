//package rl.prog2.demos.fileio;
//
//import java.awt.BorderLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.WindowAdapter;
//import java.awt.event.WindowEvent;
//import java.io.File;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Locale;
//
//import javax.swing.BorderFactory;
//import javax.swing.JButton;
//import javax.swing.JComponent;
//import javax.swing.JFileChooser;
//import javax.swing.JFrame;
//import javax.swing.JMenu;
//import javax.swing.JMenuBar;
//import javax.swing.JMenuItem;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JSplitPane;
//import javax.swing.JTextArea;
//import javax.swing.JToggleButton;
//import javax.swing.JToolBar;
//import javax.swing.filechooser.FileFilter;
//
///**
// * Simple application for electronic quiz card management. Quiz cards can be
// * shown, edited, loaded, saved, imported, and exported. The main purpose of
// * this application is to demonstrate how to save objects using files. See the
// * {@link QuizStarterSwing.DefaultPersistenceManager} for details.
// *
// * @author Ruediger Lunde
// */
//public class QuizGUISwing {
//
//	JFrame frame;
//	JFileChooser fileChooser;
//
//	JMenuItem loadMenuItem;
//	JMenuItem saveMenuItem;
//
//	JButton prevButton;
//	JButton nextButton;
//	JButton showAnswerButton;
//	JToggleButton editButton;
//	JButton createCardButton;
//	JButton removeCardButton;
//	CardPanel cardPanel;
//
//	private QuizPersistenceManager pm;
//	private List<QuizCard> cards = new ArrayList<QuizCard>();
//	private int currCardIndex;
//	private boolean showAnswer;
//	private boolean dirty;
//
//	public QuizGUISwing() {
//		Locale.setDefault(Locale.US);
//		frame = new JFrame("Quiz");
//		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
//		// check for unsaved changes before leaving the application
//		frame.addWindowListener(new WindowAdapter() {
//			@Override
//			public void windowClosing(WindowEvent arg0) {
//				updateTextsInCurrCard();
//				if (checkForUnsavedChanges())
//					System.exit(0);
//			}
//		});
//
//		fileChooser = new JFileChooser();
//		AppActionListener listener = new AppActionListener();
//		initMenuBar(listener);
//		initToolBar(listener);
//		cardPanel = new CardPanel();
//		frame.add(cardPanel);
//
//		frame.setSize(400, 400);
//	}
//
//	public void start() {
//		update();
//		frame.setVisible(true);
//	}
//
//	public JFrame getFrame() {
//		return frame;
//	}
//
//	public void setCards(List<QuizCard> cards) {
//		this.cards.clear();
//		this.cards.addAll(cards);
//		currCardIndex = cards.isEmpty() ? -1 : 0;
//	}
//
//	public void setPersistenceManager(QuizPersistenceManager pm) {
//		this.pm = pm;
//		FileFilter[] filters = fileChooser.getChoosableFileFilters();
//		for (int i = 1; i < filters.length; i++)
//			// keep "All Files" filter
//			fileChooser.removeChoosableFileFilter(filters[i]);
//		String[] exts = pm.getSupportedFileExtensions();
//		String[] descrs = pm.getFileFormatDescriptions();
//		for (int i = 0; i < exts.length; i++)
//			fileChooser.addChoosableFileFilter(createFileFilter(exts[i],
//					descrs[i]));
//		filters = fileChooser.getChoosableFileFilters();
//		if (filters.length > 1) // use first extension as default
//			fileChooser.setFileFilter(filters[1]);
//	}
//
//	private FileFilter createFileFilter(final String ext, final String descr) {
//		FileFilter result = new FileFilter() {
//			@Override
//			public boolean accept(File file) {
//				return file.getName().endsWith("." + ext);
//			}
//
//			@Override
//			public String getDescription() {
//				return descr + " (" + ext + ")";
//			}
//		};
//		return result;
//	}
//
//	private void initMenuBar(ActionListener listener) {
//		JMenuBar menuBar = new JMenuBar();
//		frame.setJMenuBar(menuBar);
//		JMenu menu = new JMenu("File");
//		menuBar.add(menu);
//		loadMenuItem = new JMenuItem("Load Quiz Cards");
//		loadMenuItem.addActionListener(listener);
//		menu.add(loadMenuItem);
//		saveMenuItem = new JMenuItem("Save Quiz Cards");
//		saveMenuItem.addActionListener(listener);
//		menu.add(saveMenuItem);
//		menu = new JMenu("?");
//		menuBar.add(menu);
//		JMenuItem item = new JMenuItem("About");
//		item.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				JOptionPane
//						.showMessageDialog(
//								frame,
//								"Quiz\nDemonstrates file input and output.\nRuediger Lunde (2011)",
//								"Info", JOptionPane.INFORMATION_MESSAGE);
//			}
//		});
//		menu.add(item);
//	}
//
//	private void initToolBar(ActionListener listener) {
//		JToolBar toolBar = new JToolBar();
//		toolBar.setFloatable(false);
//		frame.add(toolBar, BorderLayout.NORTH);
//		prevButton = new JButton("<");
//		prevButton.addActionListener(listener);
//		toolBar.add(prevButton);
//		nextButton = new JButton(">");
//		nextButton.addActionListener(listener);
//		toolBar.add(nextButton);
//		toolBar.addSeparator();
//		showAnswerButton = new JButton("Show Answer");
//		showAnswerButton.addActionListener(listener);
//		toolBar.add(showAnswerButton);
//		toolBar.addSeparator();
//		editButton = new JToggleButton("Edit");
//		editButton.addActionListener(listener);
//		toolBar.add(editButton);
//		createCardButton = new JButton("Create Card");
//		createCardButton.addActionListener(listener);
//		toolBar.add(createCardButton);
//		removeCardButton = new JButton("Remove Card");
//		removeCardButton.addActionListener(listener);
//		toolBar.add(removeCardButton);
//	}
//
//	private boolean checkForUnsavedChanges() {
//		if (dirty
//				&& JOptionPane
//						.showConfirmDialog(frame,
//								"Unsaved changes exist. Proceed anyway?",
//								"Confirm", JOptionPane.YES_NO_OPTION,
//								JOptionPane.QUESTION_MESSAGE) //
//				== JOptionPane.YES_OPTION)
//			dirty = false;
//		return !dirty;
//	}
//
//	private void showErrorDialog(Exception ex) {
//		JOptionPane.showMessageDialog(frame, ex.getClass().getSimpleName()
//				+ ": " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//	}
//
//	private QuizCard getCurrCard() {
//		return currCardIndex != -1 ? cards.get(currCardIndex) : null;
//	}
//
//	private void update() {
//		QuizCard currCard = getCurrCard();
//		loadMenuItem.setEnabled(pm != null);
//		saveMenuItem.setEnabled(pm != null);
//		prevButton.setEnabled(currCardIndex > 0);
//		nextButton.setEnabled(currCardIndex < cards.size() - 1);
//		showAnswerButton.setEnabled(currCard != null && !showAnswer
//				&& !editButton.isSelected());
//		createCardButton.setEnabled(editButton.isSelected());
//		removeCardButton
//				.setEnabled(editButton.isSelected() && currCard != null);
//		cardPanel.setVisible(currCard != null);
//		if (currCard != null) {
//			cardPanel.questionArea.setText(currCard.getQuestion());
//			cardPanel.questionArea.setEditable(editButton.isSelected());
//			cardPanel.answerArea.setText(currCard.getAnswer());
//			cardPanel.answerArea.setEditable(editButton.isSelected());
//			cardPanel.answerArea.setVisible(showAnswer
//					|| editButton.isSelected());
//		}
//		frame.validate();
//	}
//
//	private void updateTextsInCurrCard() {
//		QuizCard currCard = getCurrCard();
//		if (currCard != null) {
//			String newText = cardPanel.questionArea.getText();
//			if (!currCard.getQuestion().equals(newText)) {
//				currCard.setQuestion(newText);
//				dirty = true;
//			}
//			newText = cardPanel.answerArea.getText();
//			if (!currCard.getAnswer().equals(newText)) {
//				currCard.setAnswer(newText);
//				dirty = true;
//			}
//		}
//	}
//
//	private class AppActionListener implements ActionListener {
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			updateTextsInCurrCard();
//			showAnswer = false;
//			if (e.getSource() == prevButton) {
//				currCardIndex--;
//			} else if (e.getSource() == nextButton) {
//				currCardIndex++;
//			} else if (e.getSource() == showAnswerButton) {
//				showAnswer = true;
//			} else if (e.getSource() == createCardButton) {
//				cards.add(++currCardIndex, new QuizCard());
//				dirty = true;
//			} else if (e.getSource() == removeCardButton) {
//				cards.remove(currCardIndex);
//				if (currCardIndex == cards.size())
//					currCardIndex--;
//				dirty = true;
//			} else if (e.getSource() == loadMenuItem) {
//				if (checkForUnsavedChanges()
//						&& fileChooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
//					try {
//						List<QuizCard> newCards;
//						newCards = pm.loadCards(fileChooser.getSelectedFile());
//						setCards(newCards);
//					} catch (Exception ex) {
//						showErrorDialog(ex);
//					}
//					editButton.setSelected(false);
//				}
//			} else if (e.getSource() == saveMenuItem) {
//				if (fileChooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
//					try {
//						pm.saveCards(fileChooser.getSelectedFile(), cards);
//					} catch (Exception ex) {
//						showErrorDialog(ex);
//					}
//					dirty = false;
//				}
//			}
//
//			update();
//		}
//	}
//
//	@SuppressWarnings("serial")
//	static class CardPanel extends JSplitPane {
//		JTextArea questionArea;
//		JTextArea answerArea;
//
//		CardPanel() {
//			super(JSplitPane.VERTICAL_SPLIT);
//			setDividerSize(4);
//			setDividerLocation(100);
//			setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
//			questionArea = new JTextArea();
//			setTopComponent(addScroller(questionArea, "Question"));
//			answerArea = new JTextArea();
//			setBottomComponent(addScroller(answerArea, "Answer"));
//		}
//
//		private JComponent addScroller(JTextArea textArea, String title) {
//			JPanel result = new JPanel(new BorderLayout());
//			textArea.setLineWrap(true);
//			textArea.setWrapStyleWord(true);
//			JScrollPane scroller = new JScrollPane(textArea);
//			scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//			result.add(scroller);
//			result.setBorder(BorderFactory.createTitledBorder(title));
//			return result;
//		}
//	}
//}
