import java.net.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.*;

public class ClientIntegrationTest {
	
	private Client client;
	
	@Before
	public void setUp() throws UnknownHostException, IOException {
		client = new Client();
		client.startConnection("127.0.0.1", 6666);
	}
	
	@Test
	public void testCallAndResponse() throws IOException {
		String response = client.sendMessage("hello server");
		String diceTotal = client.sendMessage("34");
		String close = client.sendMessage(".");
		
		assertEquals("hello client", response);
		assertNotNull(diceTotal);
		assertEquals("goodbye", close);
	}
	
	@After
	public void tearDown() throws IOException {
		client.stopConnection();
	}
}
