package clientserver2;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
	
	public Client() {
		try (Socket serverSocket = new Socket("localhost", 1111) ){
			
			ObjectOutputStream out = new ObjectOutputStream(serverSocket.getOutputStream());
			ObjectInputStream in = new ObjectInputStream(serverSocket.getInputStream());
			
			out.writeObject("hallo Server");
			
			System.out.println(in.readObject());
			
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Client();
	}

}
