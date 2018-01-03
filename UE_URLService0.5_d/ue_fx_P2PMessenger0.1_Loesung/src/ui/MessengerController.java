package ui;

import java.net.URL;
import java.time.LocalTime;
import java.util.ResourceBundle;

import client.Client;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.MessageObject;
import server.Server;

public class MessengerController implements Initializable{
	@FXML
	private TextField localServerTextField;
	@FXML
	private TextField nameTextField;
	@FXML
	private TextField messageTextField;
	@FXML
	private TextField toServerTextField;
	@FXML
	
	
	private TableView<MessageObject>messageTableView;
	
	//----------------------- Member---------------------------
	
	private Client client;
	private Server server;
	private ObservableList<MessageObject> messageList = FXCollections.observableArrayList();

	// Event Listener on Button.onAction
	@FXML
	public void serverStartAction(ActionEvent event) {
		System.out.println("serverStartAction");
		// Server starten in einem  Task-Thread -> wichtig!
		Task<String> task = new Task<String>() {

			@Override
			protected String call() throws Exception {

				server.serverStart(localServerTextField.getText());//127.0.0.2
				return "";
			}
		};
	
		new Thread(task).start();
		
	}
	/*
	 * // Nachricht (MessageObjekt) senden und in die ObservableList anhängen
	 */
	@FXML
	public void messageSendAction(ActionEvent event) {
		System.out.println("messageSendAction");
		MessageObject obj = new MessageObject(nameTextField.getText(), messageTextField.getText(), LocalTime.now());
		messageList.add(obj);
		client.writeMSG(obj);
	
	}
	
	/*
	 * Client->connect
	 */
	@FXML 
	public void connectToServerAction(ActionEvent event) {
		System.out.println("connectToServerAction");
		client.connect(toServerTextField.getText());
	
	}
	
	
	// Server und Client erzeugen
	// Listener für die empfangene Nachricht
	// Empfamgendes MessageObjekt an die ObservableList hängen
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		messageTableView.setItems(messageList);
		client = new Client();
		server = new Server();
		server.getService().valueProperty().addListener( (a,b,newMessageObject)->{
			
			if(newMessageObject!=null){
				messageList.add(newMessageObject);
			}
			
		});
	}
}
