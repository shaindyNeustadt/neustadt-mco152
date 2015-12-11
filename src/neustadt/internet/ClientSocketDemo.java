package neustadt.internet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSocketDemo {

	public static void main (String [] args) throws UnknownHostException, IOException{
		//client sends message and reads one line of response
		String serverIP = "192.168.117.168"; 
		Socket socket = new Socket(serverIP, 52746);
		
		PrintWriter out = new PrintWriter(socket.getOutputStream());
		out.write("Hi There :)\n");
		out.flush();
		
		InputStream in = socket.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		
		String response = reader.readLine();
		System.out.println("RESPONSE ");
		System.out.println(response);
		
		socket.close();
	}
}
