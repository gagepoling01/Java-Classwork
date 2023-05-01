import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Client {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private Scanner chat;
    private String name;

    public static void main(String[] args) {														// main method
    	try {
    		Client client = new Client();
    		client.startConnection("127.0.0.1", 6666);
    	}
    	catch(IOException ioe) {
    		System.out.println("an I/O error occurred in Client.main()");
    	}
    }
    
    public void startConnection(String ip, int port) throws UnknownHostException, IOException {		// starts the connection	
        clientSocket = new Socket(ip, port);														// creates clientSocket
        
        out = new PrintWriter(clientSocket.getOutputStream(), true);								// output stream (to-server)
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));				// input stream (from-server)
                
        chat = new Scanner(System.in);																// scans for input from user
    	System.out.println("Enter your name to begin chatting: ");
    	setName(chat.nextLine());																	// blocks until a name is entered
  
    	out.println(getName());																		// sends name to the server so it can rename the thread
    	
    	System.out.println(in.readLine());															// prints out how many active users are connected
 
        System.out.println("Enter a message: ");
        
        String done = "";
        while (!done.equals("bye")) {																// loop that holds the connection until "bye" is entered
        		done = chat.nextLine();
        		out.println(done);
        }
        
        stopConnection();
        
    }
    
    public void setName(String name) {																// sets name
    	this.name = name;
    }
    
    public String getName() {																		// gets name
    	return name;
    }
    


    public void stopConnection() throws IOException {												// stops the connection
    	System.out.println("SHUTTING DOWN THE CLIENT");
        in.close();
        out.close();
        clientSocket.close();
        chat.close();
        System.out.println("CLIENT SHUT DOWN");
        
    }
}
