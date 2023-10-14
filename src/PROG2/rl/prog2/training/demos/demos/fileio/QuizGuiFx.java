package rl.prog2.training.demos.demos.fileio;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

/**
 * Simple application for electronic quiz card management. Quiz cards can be
 * shown, edited, loaded, saved, imported, and exported. The main purpose of
 * this application is to demonstrate how to save objects using files. See the
 * {@link QuizApp.DefaultPersistenceManager} for details.
 *
 * @author Ruediger Lunde
 */
public class QuizGuiFx {

	Stage stage;
	FileChooser fileChooser;

	MenuItem loadMenuItem;
	MenuItem saveMenuItem;

	Button prevButton;
	Button nextButton;
	Button showAnswerButton;
	ToggleButton editButton;
	Button createCardButton;
	Button removeCardButton;
	Node cardPanel;
	TextArea questionArea;
	TextArea answerArea;

	private QuizPersistenceManager pm;
	private List<QuizCard> cards = new ArrayList<QuizCard>();
	private int currCardIndex = -1;
	private boolean showAnswer;
	private boolean dirty;

	public QuizGuiFx(Stage stage) {
		Locale.setDefault(Locale.US);
		this.stage = stage;
		stage.setTitle("Quiz");
		stage.setOnCloseRequest(ev -> {
			updateTextsInCurrCard();
			if (!checkForUnsavedChanges())
				ev.consume();
		});

		fileChooser = new FileChooser();
		AppEventHandler listener = new AppEventHandler();
		MenuBar mBar = createMenuBar(listener);
		ToolBar tBar = createToolBar(listener);
		cardPanel = createCardPanel();

		VBox vbox = new VBox();
		vbox.getChildren().addAll(mBar, tBar);
		BorderPane root = new BorderPane();
		root.setTop(vbox);
		root.setCenter(cardPanel);

		stage.setScene(new Scene(root));
		update();
	}

	public Stage getStage() {
		return stage;
	}

	public void setCards(List<QuizCard> cards) {
		this.cards.clear();
		this.cards.addAll(cards);
		currCardIndex = cards.isEmpty() ? -1 : 0;
		update();
	}

	public void setPersistenceManager(QuizPersistenceManager pm) {
		this.pm = pm;
		ObservableList<ExtensionFilter> filters = fileChooser.getExtensionFilters();
		filters.clear();
		String[] exts = pm.getSupportedFileExtensions();
		String[] descrs = pm.getFileFormatDescriptions();
		for (int i = 0; i < exts.length; i++)
			filters.add(new ExtensionFilter(descrs[i], "*." + exts[i]));
		// fileChooser.setSelectedExtensionFilter(filters.get(0));
		update();
	}

	private MenuBar createMenuBar(EventHandler<ActionEvent> eventHandler) {
		MenuBar result = new MenuBar();
		Menu fMenu = new Menu("File");
		loadMenuItem = new MenuItem("Load Quiz Cards");
		loadMenuItem.setOnAction(eventHandler);
		saveMenuItem = new MenuItem("Save Quiz Cards");
		saveMenuItem.setOnAction(eventHandler);
		fMenu.getItems().addAll(loadMenuItem, saveMenuItem);

		Menu iMenu = new Menu("?");
		MenuItem item = new MenuItem("About");
		item.setOnAction(ev -> {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Info");
			alert.setHeaderText("About Quiz");
			alert.setContentText("Demonstrates file input and output.\nRuediger Lunde (2016)");
			alert.show();
		});
		iMenu.getItems().add(item);
		result.getMenus().addAll(fMenu, iMenu);
		return result;
	}

	private ToolBar createToolBar(EventHandler<ActionEvent> eventHandler) {
		ToolBar result = new ToolBar();
		prevButton = new Button("<");
		prevButton.setOnAction(eventHandler);
		nextButton = new Button(">");
		nextButton.setOnAction(eventHandler);

		showAnswerButton = new Button("Show Answer");
		showAnswerButton.setOnAction(eventHandler);

		editButton = new ToggleButton("Edit");
		editButton.setOnAction(eventHandler);

		createCardButton = new Button("Create Card");
		createCardButton.setOnAction(eventHandler);
		removeCardButton = new Button("Remove Card");
		removeCardButton.setOnAction(eventHandler);
		result.getItems().addAll(prevButton, nextButton, new Separator(), showAnswerButton, new Separator(), editButton,
				createCardButton, removeCardButton);
		return result;
	}

	private Node createCardPanel() {
		SplitPane result = new SplitPane();
		result.setOrientation(Orientation.VERTICAL);
		result.setPadding(new Insets(20, 20, 20, 20));
		questionArea = new TextArea();
		answerArea = new TextArea();
		result.getItems().addAll(createArea(questionArea, "Question"), createArea(answerArea, "Answer"));
		result.setDividerPosition(0, 0.3);
		return result;
	}

	private Pane createArea(TextArea textArea, String title) {
		BorderPane result = new BorderPane();
		textArea.setWrapText(true);
		result.setCenter(textArea);
		result.setTop(new Label(title));
		return result;
	}

	private boolean checkForUnsavedChanges() {
		if (dirty) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirm");
			alert.setHeaderText("Unsaved changes exist. Proceed anyway?");
			Optional<ButtonType> result = alert.showAndWait();
			if (result.isPresent() && result.get() == ButtonType.OK)
				dirty = false;
		}
		return !dirty;
	}

	private void showErrorDialog(Exception ex) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText(ex.getClass().getSimpleName());
		alert.setContentText(ex.getMessage());
		alert.showAndWait();
	}

	private QuizCard getCurrCard() {
		return currCardIndex != -1 ? cards.get(currCardIndex) : null;
	}

	private void update() {
		QuizCard currCard = getCurrCard();
		loadMenuItem.setDisable(pm == null);
		saveMenuItem.setDisable(pm == null);
		prevButton.setDisable(currCardIndex <= 0);
		nextButton.setDisable(currCardIndex >= cards.size() - 1);
		showAnswerButton.setDisable(currCard == null || showAnswer || editButton.isSelected());
		createCardButton.setDisable(!editButton.isSelected());
		removeCardButton.setDisable(!editButton.isSelected() || currCard == null);
		cardPanel.setVisible(currCard != null);
		if (currCard != null) {
			questionArea.setText(currCard.getQuestion());
			questionArea.setEditable(editButton.isSelected());
			answerArea.setText(currCard.getAnswer());
			answerArea.setEditable(editButton.isSelected());
			answerArea.setVisible(showAnswer || editButton.isSelected());
		}
	}

	private void updateTextsInCurrCard() {
		QuizCard currCard = getCurrCard();
		if (currCard != null) {
			String newText = questionArea.getText();
			if (!currCard.getQuestion().equals(newText)) {
				currCard.setQuestion(newText);
				dirty = true;
			}
			newText = answerArea.getText();
			if (!currCard.getAnswer().equals(newText)) {
				currCard.setAnswer(newText);
				dirty = true;
			}
		}
	}

	private class AppEventHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			updateTextsInCurrCard();
			showAnswer = false;
			if (e.getSource() == prevButton) {
				currCardIndex--;
			} else if (e.getSource() == nextButton) {
				currCardIndex++;
			} else if (e.getSource() == showAnswerButton) {
				showAnswer = true;
			} else if (e.getSource() == createCardButton) {
				cards.add(++currCardIndex, new QuizCard());
				dirty = true;
			} else if (e.getSource() == removeCardButton) {
				cards.remove(currCardIndex);
				if (currCardIndex == cards.size())
					currCardIndex--;
				dirty = true;
			} else if (e.getSource() == loadMenuItem) {
				if (checkForUnsavedChanges()) {
					File file = fileChooser.showOpenDialog(stage);
					if (file != null) {
						try {
							List<QuizCard> newCards;
							newCards = pm.loadCards(file);
							setCards(newCards);
						} catch (Exception ex) {
							showErrorDialog(ex);
						}
						editButton.setSelected(false);
					}
				}
			} else if (e.getSource() == saveMenuItem) {
				File file = fileChooser.showSaveDialog(stage);
				if (file != null) {
					try {
						pm.saveCards(file, cards);
					} catch (Exception ex) {
						showErrorDialog(ex);
					}
					dirty = false;
				}
			}

			update();
		}
	}
}
