package clientserver1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public Server() {
		try (ServerSocket serverSocket = new ServerSocket(1111)) {
			System.out.println("Server startet..." + serverSocket.getLocalSocketAddress());

			while (true) {
				Socket clientSocket = serverSocket.accept();// wartet auf
															// Anfrage und
															// liefert die
															// Verbindung zum
															// Client
				InputStream in = clientSocket.getInputStream();
				OutputStream out = clientSocket.getOutputStream();

				// Protokoll?
				int a = in.read();
				int b = in.read();

				out.write(a + b);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Server();

	}

}
