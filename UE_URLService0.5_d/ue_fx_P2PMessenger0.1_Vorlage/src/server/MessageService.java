package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import model.MessageObject;

public class MessageService extends Service<MessageObject> {
	private ObjectInputStream in;
	private Socket clientSocket;

	@Override
	protected Task<MessageObject> createTask() {
		return new Task<MessageObject>() {

			@Override
			protected MessageObject call() throws Exception {
				System.out.println("call.....");
				updateMessage("MessageService: call");
				MessageObject msgObj;
				
				// die Schleife wird nicht verlassen
				while ((msgObj = (MessageObject) in.readObject()) != null) {
					// msgObj schreiben -> updateValue
					
					System.out.println(msgObj);
					updateValue(msgObj);
				}
				return msgObj;// value
			}

		};
	}

	/*
	 * ObjectInputStream erzeugen
	 */
	public void createObjectInputstream(Socket clientSocket) throws IOException {
		in = new ObjectInputStream(clientSocket.getInputStream());
	}

}
