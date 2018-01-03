package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import service.ExtractURLService;
import service.URLService;

public class URLController implements Initializable {
	
	private URLService urlservice;
	
	private ExtractURLService extractURLService;
	
	@FXML
	private TextField urlTextField;
	@FXML
	private TextArea sourceTextArea;
	@FXML
	private ListView<String> linkListView;
	@FXML
	private Label satusLAbel;

	// Event Listener on TextField[#urlTextField].onKeyPressed
	@FXML
	public void onKeyPressed(KeyEvent event) {
		if(event.getCode()==KeyCode.ENTER){
			start();
		}
	}
	// Event Listener on Button.onAction
	@FXML
	public void startAction(ActionEvent event) {
		
		start();
	}
	private void start() {
		urlservice.setUrlStr(urlTextField.getText());
		urlservice.restart();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		urlTextField.setText("http://www.java2s.com/");//TODO weg
		// URLService erzeugen
		urlservice = new URLService();
		extractURLService = new ExtractURLService();
		
		sourceTextArea.textProperty().bind(urlservice.valueProperty());  //Result vom Service "holen"
		
		urlservice.setOnSucceeded(e ->{
			System.out.println("URLService fertig...");
			extractURLService.setSourceCode(sourceTextArea.getText());
			// hier den 2. Service starten
			extractURLService.restart();
			
		});
		
		
		extractURLService.valueProperty().addListener( (obsValue, oldValue, newValue)->{
			linkListView.setItems(FXCollections.observableArrayList(newValue));// List zu ObservableList konvertieren und zur ListView bringen
		});
	}
	
}
