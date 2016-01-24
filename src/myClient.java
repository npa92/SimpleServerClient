import java.net.*;
import java.io.*;
import java.util.*;

public class myClient {

	public static void main(String args[]) throws UnknownHostException {
		String serverName = "myServer";
		int port = 2016;
		InetAddress address = InetAddress.getLocalHost();
		try {
			System.out.println("Connecting to " + serverName + " on port " + port);
			Socket client = new Socket(address, port);
			System.out.println("Connected to " + serverName + " on port " + port);
			OutputStream toServer = client.getOutputStream();
			DataOutputStream out = new DataOutputStream(toServer);
			out.writeUTF("Sup? - from " + client.getLocalSocketAddress());
			 InputStream inFromServer = client.getInputStream();
	         DataInputStream in =
	                        new DataInputStream(inFromServer);
	         System.out.println("Sup wit you? " + in.readUTF());
	         client.close();
		} catch(IOException io) {
			io.printStackTrace();
		}
	}

}
