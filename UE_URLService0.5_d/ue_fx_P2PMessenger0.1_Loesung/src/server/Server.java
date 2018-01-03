package server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

import javafx.application.Platform;

public class Server {

	private ServerSocket serverSocket;
	private MessageService messageService;

	/*
	 * ServerSocket und MessageService erzeuegen
	 */
	public Server() {
		try {
			serverSocket = new ServerSocket();
			messageService = new MessageService();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public MessageService getService() {
		return messageService;
	}

	public void setService(MessageService service) {
		this.messageService = service;
	}

	// Server binden (127.0.0.2)-> schon erledigt
	// Socket erzeugen (clientSocket) -> mit accept warten
	// createObjectInputstream des MessageService aufrufen
	// MessageService starten
	public void serverStart(String localIP) {
		// hier...

		System.out.println("Server wird gebunden...");
		try {
			serverSocket.bind(new InetSocketAddress(localIP, 1111));
			
			while (true) {
				System.out.println("Server.accept...");
				Socket clientSocket = serverSocket.accept();
				// MessageService
				messageService.createObjectInputstream(clientSocket);
				messageService.restart();
			}
//  
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
