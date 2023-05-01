import java.net.*;
import java.io.*;

public class Server {
	private ServerSocket serverSocket;
	
	public static void main(String[] args) throws IOException {		// main method
		Server server = new Server();
		server.start(6666);
	}
	
	public void start(int port) throws IOException {				// creates the serverSocket
		serverSocket = new ServerSocket(port);
		while(true)													// this loop constantly checks for a new client
			new ClientHandler(serverSocket.accept()).start();		// attempting to connect to the server
	}
	
	public void stop() throws IOException {							// closes the serverSocket
		serverSocket.close();
	}
	
	private static class ClientHandler extends Thread {		// subclass to handle multiple Client connections
		private Socket clientSocket;
		private PrintWriter out;
		private BufferedReader in;
		
		public ClientHandler(Socket socket) {
			this.clientSocket = socket;
		}
		
		public void run() {
			try {
				out = new PrintWriter(clientSocket.getOutputStream(), true);							// output stream (to-client)
				in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));			// input stream (from-client)
				
				Thread.currentThread().setName(in.readLine());											// this block prints a message within the server console
				System.out.println("CLIENT '" + Thread.currentThread().getName() + "' AVAILABLE");		// saying which client is available and renames their thread
				
				if (Thread.activeCount() - 2 != 0) {													// if/else block that tells the client how many other users
				out.println("There are: " + (Thread.activeCount() - 2) + " other users online");		// are online
				}
				else {
					out.println("Nobody is available to chat with.");
				}
				
				boolean done = false;
				while (!done) {																			// loop to keep connection live until "bye" is sent
					try {
						String inputLine = in.readLine();
						System.out.println(Thread.currentThread().getName() + ": " + inputLine);
						done = inputLine.equals("bye");
					}
					catch (IOException ioe) {
						done = true;
					}
				}
				
				in.close();																				// postloop that closes the input/output streams and the clientSocket
				out.close();
				clientSocket.close();
				
			} catch (IOException ioe) {
				System.out.println("an I/O error occurred in ClientHandler.run()");
			}

		}
	
	}
}

