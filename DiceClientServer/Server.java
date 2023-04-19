import java.net.*;
import java.util.Random;
import java.io.*;

public class Server {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public static void main(String[] args) throws IOException {
        Server server=new Server();
        server.start(6666);
    }
    
	public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        clientSocket = serverSocket.accept();
        
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        
        String inputLine = in.readLine();
        
        if ("hello server".equals(inputLine)) {
        	out.println("hello client");
        	
        	while ((inputLine = in.readLine()) != null) {
        		if (".".equals(inputLine)) {
        			out.println("goodbye");
        			break;
        		}
        		if (isInteger(inputLine) == true) {
        			int total = diceRoll(Integer.parseInt(inputLine));
        			out.println("Total: " + total);
        		}
        }
        	
        }
        else {
        	out.println("unrecognised greeting");
        }
        
    }
    
    public int diceRoll(int amount) {
    	Random rand = new Random();
    	int total = 0;
    	for (int i = 0; i < amount; i++) {
    		int roll = rand.nextInt(6) + 1;
    		total += roll;
    	}
    	return total;
    }
    
    public static boolean isInteger(String string) {
    	boolean isInt = true;
    	try {
    		Integer.parseInt(string);
    	} catch (NumberFormatException e) {
    		isInt = false;
    	}
    	return isInt;
    }

    public void stop() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }

}
