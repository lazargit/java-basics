package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import model.Person;

public class SampleController implements Initializable{

	@FXML private TableView<Person> tableView;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		ObservableList<Person> pList = FXCollections.observableArrayList();
		
		pList.add(new Person("Max", "Meier", 23));
		pList.add(new Person("Marta", "Müller", 43));
		pList.add(new Person("Olaf", "Schultz", 23));
		pList.add(new Person("Igor", "Lehmann", 26));
		tableView.setItems(pList);
		
		ArrayList<Integer> arr = new ArrayList<>(); 
		
		arr.add(1);

		
	}
	
	
	
}
