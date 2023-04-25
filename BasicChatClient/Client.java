import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Client {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private Scanner chat;

    public static void main(String[] args) {
    	try {
    		Client client = new Client();
    		client.startConnection("127.0.0.1", 6666);
    	}
    	catch(IOException ioe) {
    		System.out.println("an I/O error occurred in Client.main()");
    	}
    }
    
    public void startConnection(String ip, int port) throws UnknownHostException, IOException {
        clientSocket = new Socket(ip, port);
        
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        
        out.println("CLIENT AVAILABLE");
        
        chat = new Scanner(System.in);
        System.out.println("Enter a message: ");
        
        String done = "";
        while (!done.equals("bye")) {
        		done = chat.nextLine();
        		out.println(done);
        }
        
        stopConnection();
        
    }


    public void stopConnection() throws IOException {
    	System.out.println("SHUTTING DOWN THE CLIENT");
        in.close();
        out.close();
        clientSocket.close();
        chat.close();
        System.out.println("CLIENT SHUT DOWN");
        
    }
}


//String msg = scanner.nextLine();

