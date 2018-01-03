package client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import model.MessageObject;

public class Client {

	private ObjectOutputStream out;

	private Socket serverSocket;
	
	
	/*
	 * - Socket erzeugen -> Achtung nicht close oder AutoClose!
	 * - ObjectOutputStream 
	 * - true zurückgeben, wenn connected
	 */
	public boolean connect(String remoteHost) {
		try {
			serverSocket = new Socket(remoteHost, 1111);
			out = new ObjectOutputStream(serverSocket.getOutputStream());
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return serverSocket.isConnected();
	}

	/*
	 * Nachricht schreiben - writeObject
	 */
	public void writeMSG(MessageObject msgObj) {
		try {
			out.writeObject(msgObj);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
