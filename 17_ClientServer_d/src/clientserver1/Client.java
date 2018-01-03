package clientserver1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
	
	public Client() {
		try (Socket serverSocket = new Socket("localhost", 1111) ){
			
			OutputStream out = serverSocket.getOutputStream();
			InputStream in = serverSocket.getInputStream();
			out.write(3);// zum Server schreiben
			out.write(5);
			
			System.out.println(in.read());// vom Server lesen
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Client();
	}

}
