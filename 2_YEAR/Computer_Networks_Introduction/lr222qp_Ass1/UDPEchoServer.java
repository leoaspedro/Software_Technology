/*
  UDPEchoServer.java
  A simple echo server with no error handling
*/


import java.io.IOException;
import java.net.*;

public class UDPEchoServer {
    //public static final int BUFSIZE= 1024;
    public static final int MYPORT= 4950;

    public static void main(String[] args)  {

	//Only one parameter expected on the server -> BufferSize
	if(args.length != 1 ){
		System.err.printf("usage: %s server_name port\n", args[1]);
		System.exit(1);
	}
		byte[] buf = new byte[Integer.parseInt(args[0])];
	try{
	/* Create socket */
	DatagramSocket socket= new DatagramSocket(null);

	/* Create local bind point */
	SocketAddress localBindPoint= new InetSocketAddress(MYPORT);
	socket.bind(localBindPoint);
	while (true) {
		/* Create datagram packet for receiving message */
		DatagramPacket receivePacket = new DatagramPacket(buf, buf.length);

		/* Receiving message */
		socket.receive(receivePacket);

		/* Create datagram packet for sending message */
		DatagramPacket sendPacket =
				new DatagramPacket(receivePacket.getData(),
						receivePacket.getLength(),
						receivePacket.getAddress(),
						receivePacket.getPort());

		/* Send message*/
		socket.send(sendPacket);
		System.out.printf("UDP echo request from %s", receivePacket.getAddress().getHostAddress());
		System.out.printf(" using port %d\n", receivePacket.getPort());
	}
	}catch (Exception e ){
		System.out.println("Server shutting down");
		System.exit(1);
	}
    } 
}