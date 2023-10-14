//package rl.prog2.demos.gui.fx;
//
//import javafx.application.Application;
//import javafx.beans.property.SimpleStringProperty;
//import javafx.beans.property.StringProperty;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.geometry.Insets;
//import javafx.scene.Group;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableColumn.CellEditEvent;
//import javafx.scene.control.TableView;
//import javafx.scene.control.TextField;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.control.cell.TextFieldTableCell;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.VBox;
//import javafx.scene.text.Font;
//import javafx.stage.Stage;
//
//// vm-options (java > 8): --module-path ${PATH_TO_FX} --add-modules javafx.controls,javafx.fxml
//
///**
// * Table view example. It is a modified version of:
// * http://docs.oracle.com/javafx/2/ui_controls/table-view.htm
// *
// * @author Ruediger Lunde
// */
//public class TableViewSample extends Application {
//
//	/** The data for the table view. */
//	private final ObservableList<Person> data = FXCollections.observableArrayList(
//			new Person("Jacob", "Smith", "jacob.smith@example.com"),
//			new Person("Isabella", "Johnson", "isabella.johnson@example.com"),
//			new Person("Ethan", "Williams", "ethan.williams@example.com"),
//			new Person("Emma", "Jones", "emma.jones@example.com"),
//			new Person("Michael", "Brown", "michael.brown@example.com"));
//
//
//	public static void main(String[] args) {
//		launch(args);
//	}
//
//	@Override
//	public void start(Stage primaryStage) {
//		Stage secondaryStage = new Stage();
//		showTable(primaryStage);
//		showTable(secondaryStage);
//	}
//
//
//	public void showTable(Stage stage) {
//		VBox vbox = new VBox();
//		vbox.setSpacing(5);
//		vbox.setPadding(new Insets(10, 10, 10, 10));
//		Group rootPane = new Group();
//		rootPane.getChildren().add(vbox);
//		Scene scene = new Scene(rootPane);
//		stage.setTitle("Table View Sample");
//
//		final Label label = new Label("Address Book");
//		label.setFont(new Font("Arial", 20));
//
//		// A table view, which will visualize a list of persons.
//		TableView<Person> table = new TableView<>();
//		table.setEditable(true);
//
//		// Column definitions
//		TableColumn<Person, String> firstNameCol = new TableColumn<>("First Name");
//		firstNameCol.setMinWidth(100);
//		firstNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
//		// for editing:
//		firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
//		firstNameCol.setOnEditCommit(new EventHandler<CellEditEvent<Person, String>>() {
//			@Override
//			public void handle(CellEditEvent<Person, String> t) {
//				((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())).setFirstName(t.getNewValue());
//			}
//		});
//
//		TableColumn<Person, String> lastNameCol = new TableColumn<>("Last Name");
//		lastNameCol.setMinWidth(100);
//		lastNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
//		// for editing:
//		lastNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
//		lastNameCol.setOnEditCommit(new EventHandler<CellEditEvent<Person, String>>() {
//			@Override
//			public void handle(CellEditEvent<Person, String> t) {
//				((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())).setLastName(t.getNewValue());
//			}
//		});
//
//		TableColumn<Person, String> emailCol = new TableColumn<>("Email");
//		emailCol.setMinWidth(200);
//		emailCol.setCellValueFactory(new PropertyValueFactory<Person, String>("email"));
//		// for editing:
//		emailCol.setCellFactory(TextFieldTableCell.forTableColumn());
//		emailCol.setOnEditCommit(new EventHandler<CellEditEvent<Person, String>>() {
//			@Override
//			public void handle(CellEditEvent<Person, String> t) {
//				((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())).setEmail(t.getNewValue());
//			}
//		});
//
//		table.getColumns().add(firstNameCol);
//		table.getColumns().add(lastNameCol);
//		table.getColumns().add(emailCol);
//		table.setItems(data);
//
//		// rest of the layout
//
//		vbox.getChildren().addAll(label, table);
//
//		HBox hb = createControlsForAddingRows(firstNameCol, lastNameCol, emailCol);
//		vbox.getChildren().add(hb);
//
//		stage.setScene(scene);
//		stage.show();
//	}
//
//	private HBox createControlsForAddingRows(TableColumn<Person, String> firstNameCol,
//			TableColumn<Person, String> lastNameCol, TableColumn<Person, String> emailCol) {
//		HBox hb = new HBox();
//		final TextField addFirstName = new TextField();
//		addFirstName.setPromptText("First Name");
//		addFirstName.setMaxWidth(firstNameCol.getPrefWidth());
//		final TextField addLastName = new TextField();
//		addLastName.setMaxWidth(lastNameCol.getPrefWidth());
//		addLastName.setPromptText("Last Name");
//		final TextField addEmail = new TextField();
//		addEmail.setMaxWidth(emailCol.getPrefWidth());
//		addEmail.setPromptText("Email");
//
//		final Button addButton = new Button("Add");
//		addButton.setOnAction(new EventHandler<ActionEvent>() {
//			@Override
//			public void handle(ActionEvent e) {
//				data.add(new Person(addFirstName.getText(), addLastName.getText(), addEmail.getText()));
//				addFirstName.clear();
//				addLastName.clear();
//				addEmail.clear();
//			}
//		});
//
//		hb.getChildren().addAll(addFirstName, addLastName, addEmail, addButton);
//		hb.setSpacing(3);
//		return hb;
//	}
//
//	public static class Person {
//
//		private final StringProperty firstName;
//		private final StringProperty lastName;
//		private final StringProperty email;
//
//		private Person(String fName, String lName, String email) {
//			this.firstName = new SimpleStringProperty(fName);
//			this.lastName = new SimpleStringProperty(lName);
//			this.email = new SimpleStringProperty(email);
//		}
//
//		// If edits in one view shall be visible in other views
//		// this property access methods are necessary.
//
//		public StringProperty firstNameProperty() {
//			return firstName;
//		}
//
//		public StringProperty lastNameProperty() {
//			return lastName;
//		}
//
//		public StringProperty emailProperty() {
//			return email;
//		}
//
//		// If property methods are not available, the table view
//		// accesses the data via get and set methods. But
//		// synchronization will not be perfect!
//
//		public String getFirstName() {
//			return firstName.get();
//		}
//
//		public void setFirstName(String fName) {
//			firstName.set(fName);
//		}
//
//		public String getLastName() {
//			return lastName.get();
//		}
//
//		public void setLastName(String fName) {
//			lastName.set(fName);
//		}
//
//		public String getEmail() {
//			return email.get();
//		}
//
//		public void setEmail(String fName) {
//			email.set(fName);
//		}
//	}
//}
