package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class SampleController implements Initializable{  // new SampleController()
	@FXML
	private TextField textField;/// FXML -> fx:id textField
	@FXML
	private Label label;
	
	public SampleController() {
		// TODO Auto-generated constructor stub
	}
	
	

	// Event Listener on Button.onAction
	@FXML
	public void go(ActionEvent event) {
		
		
		Button b = (Button) event.getSource();
		b.getStyleClass().add("shadow");
		label.setText(textField.getText());
	}
	// Event Listener on MenuItem.onAction
	@FXML
	public void exitAction(ActionEvent event) {
		Platform.exit();
	}
	@Override// als Konstruktor-Ersatz, wird nach dem Konstruktor aufgerufen (automatisch)
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		System.out.println("init....");
		
	}
//	@FXML 	public void initialize(){			
//		
//	}
}
