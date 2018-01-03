package application;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Person;

public class SampleController implements Initializable{

	
	private ObservableList<Person> personenList;  //TODO Local?
	@FXML
	private TextField vornameField;
	@FXML
	private TextField nachnameField;
	@FXML
	private DatePicker datePicker;
	@FXML
	private TableView<Person> tableView;
	
	// Event Listener on Button.onAction
	@FXML
	public void saveAction(ActionEvent event) {
		//TODO Felder prüfen
		String vorname = vornameField.getText();
		String nachname = nachnameField.getText();
		LocalDate date = datePicker.getValue();
		
		
		personenList.add(new Person(vorname, nachname, date));
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		personenList = FXCollections.observableArrayList();
		tableView.setItems(personenList);
		
	}
}
