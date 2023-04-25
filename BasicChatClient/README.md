CURRENTLY AT: TIER 0.5

This assignment was set up in tiers.

Tier 1:  Your task is to write EITHER the Java code or the Python code to create a chat client and a chat server.  In 
this situation, the client establishes connection with the server saying it is available to chat with any other client 
that is available.  When a client first connects to the server, it also provides a name to the server to identify itself.  
A server needs to be able to have multiple clients attach to it.

Tier 2:  If another client is not available, the server informs the client.  If other clients are available, then the the 
list of other clients that are available is sent to the requesting client.  If a new client becomes available, then all 
currently connected clients are told a new connection is available.  

Tier 3:  A client can then communicate with another client THROUGH the server by sending a message to it in the format 
"targetClientName message" which will be routed through the server and sent to the appropriate client.

Example of Tier 3: 
If a client named psycho wants to send a message to a client named victim, the client psycho would type the following 
to victim:  "victim I will see you soon - muahahaha".  

The server would accept this message and send the following to victim:  "psycho says: I will see you soon - muahahaha"

Upon receipt the client victim might type back "psycho who are you?" which would then be sent to psycho as already 
described.
