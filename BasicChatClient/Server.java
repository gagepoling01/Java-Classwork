import java.net.*;
import java.io.*;

public class Server {
	private ServerSocket serverSocket;
	
	public static void main(String[] args) throws IOException {
		Server server = new Server();
		server.start(6666);
	}
	
	public void start(int port) throws IOException {
		serverSocket = new ServerSocket(port);
		while(true)
			new ClientHandler(serverSocket.accept()).start();
	}
	
	public void stop() throws IOException {
		serverSocket.close();
	}
	
	private static class ClientHandler extends Thread {
		private Socket clientSocket;
		private PrintWriter out;
		private BufferedReader in;
		
		public ClientHandler(Socket socket) {
			this.clientSocket = socket;
		}
		
		public void run() {
			try {
				out = new PrintWriter(clientSocket.getOutputStream(), true);
				in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				
				boolean done = false;
				while (!done) {
					try {
						String inputLine = in.readLine();
						System.out.println(inputLine);
						done = inputLine.equals("bye");
					}
					catch (IOException ioe) {
						done = true;
					}
				}
				
				in.close();
				out.close();
				clientSocket.close();
				
			} catch (IOException ioe) {
				System.out.println("an I/O error occurred in ClientHandler.run()");
			}

		}
	
	}
}

