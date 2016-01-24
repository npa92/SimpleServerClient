import java.net.*;
import java.io.*;
import java.util.*;

public class myServer extends Thread {

    private static final int PORT = 2016;
	private ServerSocket serverSocket;

	public myServer(int port, InetAddress address) throws IOException {
		serverSocket = new ServerSocket(port);
		// serverSocket.setSoTimeout(15000);
	}

	public void run() {
		while (true) {
			try {
				System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + " come on mane");
				Socket server = serverSocket.accept();
				System.out.println("Just connected to " + server.getRemoteSocketAddress());
				DataInputStream in = new DataInputStream(server.getInputStream());
				System.out.println(in.readUTF());
				DataOutputStream out = new DataOutputStream(server.getOutputStream());
				out.writeUTF("Ayy yo thnx for connecting homie " + server.getLocalSocketAddress() + "\nLater fool");
				server.close();
			} catch (IOException io) {
				io.printStackTrace();
				break;
			}
		}
	}

	public static void main(String args[]) throws UnknownHostException {
		InetAddress address = InetAddress.getLocalHost();
		try {
//			Thread t = new myServer(PORT, address);
//			t.start();
			myServer server = new myServer(PORT, address);
			server.run();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
