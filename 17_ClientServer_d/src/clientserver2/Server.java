package clientserver2;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public Server() {
		try (ServerSocket serverSocket = new ServerSocket(1111)) {
			System.out.println("Server startet..." + serverSocket.getLocalSocketAddress());

			while (true) {
				Socket clientSocket = serverSocket.accept();// 
				
				
				// Achtun Reihenfolge ist relevant!!!
				// Reihenfolge der Streamerzeugung muss beim Client umgekehrt sein
				ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
				ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
				
				String s = String.valueOf(in.readObject());
				
				out.writeObject(s.toUpperCase());
			}

		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Server();

	}

}
