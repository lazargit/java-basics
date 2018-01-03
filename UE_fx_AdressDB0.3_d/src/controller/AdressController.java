package controller;

import java.net.URL;
import java.util.ResourceBundle;

import dao.MySQLPersonDAO;
import dao.PersonDAO;
import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;
import model.Person;

public class AdressController implements Initializable {

	private PersonDAO dao;

	@FXML
	private TextField vornameField;

	@FXML
	private Label infoLAbel;

	@FXML
	private TextField plzField;

	@FXML
	private TextField emailField;

	@FXML
	private TextField ortFielld;

	@FXML
	private TextField strasseField;

	@FXML
	private TextField nachnameField;

	@FXML
	private TextField telefonField;

	@FXML
	private TextField mobilField;

	@FXML
	private TableView<Person> tableView;

	@FXML
	private TableColumn<Person, Integer> idColumn;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// alternativ zum FXML <cellValuProperty>
		idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

		dao = new MySQLPersonDAO();// TODO DAOFactory

		tableView.setItems((ObservableList<Person>) dao.findAllPersons());

		// ArrayList zu ObservableList
		tableView.setItems(FXCollections.observableList(dao.findAllPersons()));

		/// delete ContextMenu
		ContextMenu cm = new ContextMenu();
		MenuItem deleteItem = new MenuItem("Delete");
		cm.getItems().add(deleteItem);
		tableView.setContextMenu(cm);
		
		
		tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE); //TODO

		deleteItem.setOnAction(e -> {
			Person p = tableView.getSelectionModel().getSelectedItem();
			boolean isDeleted =dao.deletePerson(p.getId());
			if(isDeleted){
				tableView.getItems().remove(p);// aus dem Model löschen
				setInfo("Datensatz gelöscht!");
			}
			
			//
		});
	}

	@FXML
	private void saveAction(ActionEvent event) {
		boolean isSaved = dao.savePerson(
				new Person(vornameField.getText(), nachnameField.getText(), ortFielld.getText(), plzField.getText(),
						strasseField.getText(), telefonField.getText(), mobilField.getText(), emailField.getText()));

		System.out.println(isSaved);
		if (isSaved) {
			setInfo("Datensatz gespeichert!");
		}

	}

	@FXML
	private void refreshAction(ActionEvent event) {
		tableView.setItems((ObservableList<Person>) dao.findAllPersons());
	}

	private void setInfo(String msg) {
		FadeTransition ft = new FadeTransition(Duration.seconds(1), infoLAbel);
		ft.setDelay(Duration.seconds(4));
		ft.setFromValue(1);
		ft.setToValue(0);
		ft.play();
		infoLAbel.setText(msg);
	}

}
