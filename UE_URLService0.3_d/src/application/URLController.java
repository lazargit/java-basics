package application;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
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
	private ListView<Hyperlink> linkListView;
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
		
		
		extractURLService.valueProperty().addListener( (obsValue, oldValue, newValueStrList)->{
			if(newValueStrList!=null){
				
				linkListView.setItems(createHyperlinkList(newValueStrList));// List zu ObservableList konvertieren und zur ListView bringen
			}
			
		});
	}
	
	
	private ObservableList<Hyperlink> createHyperlinkList(List<String> urlStrList){
		ObservableList<Hyperlink> linkObsList = FXCollections.observableArrayList();
		for (String  strLink : urlStrList) {
			Hyperlink hyperlink =new Hyperlink(strLink);
			hyperlink.setOnAction(e->{
				System.out.println("hyperlink....");
//				Hyperlink hLink = (Hyperlink) e.getSource();
//				System.out.println(hLink.getText());
				urlTextField.setText(strLink);
				urlservice.setUrlStr(strLink);
				urlservice.restart();
				
			});
			linkObsList.add(hyperlink);//TODO setOnAction
		}
		
		return linkObsList;
		
	}
}
