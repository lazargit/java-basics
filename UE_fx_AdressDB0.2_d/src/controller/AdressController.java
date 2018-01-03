package controller;


import java.net.URL;
import java.util.ResourceBundle;

import dao.MySQLPersonDAO;
import dao.PersonDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
	}
	
	
	 @FXML
	    void saveAction(ActionEvent event) {

	    }

	    @FXML
	    void refreshAction(ActionEvent event) {

	    }


}
