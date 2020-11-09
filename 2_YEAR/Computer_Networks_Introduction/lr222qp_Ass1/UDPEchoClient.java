

import java.io.IOException;
import java.net.*;


public class UDPEchoClient {

    private static final int MYPORT = 0;
    private static final String MSG = "An Echo Message!";
    private static String IP;
    private static int PORT;
    private static int BUFFER_SIZE;
    private static int MSG_RATE;

	/* Create socket */
	private static DatagramSocket socket;

    public static void main(String[] args){

		CheckIfParametersAreValid(args);

		try {
			socket = new DatagramSocket(null);
			/* Create local endpoint using bind() */
			SocketAddress localBindPoint = new InetSocketAddress(MYPORT);
			socket.bind(localBindPoint);
		} catch (SocketException e) {
			e.printStackTrace();
		}
		while(true){
		System.out.println("=====  |1 SECOND PAST| =====");
		OneSecondDelay(MSG_RATE);
		}


	}

		public static void SendAndReceive() throws IOException {//Method that deals with sending and receiving information from the socket

			//Create  buffer
			byte[]buffer = new byte[BUFFER_SIZE];

			/* Create remote endpoint */
			SocketAddress remoteBindPoint = new InetSocketAddress(IP, PORT);

			/* Create datagram packet for sending message */
			DatagramPacket sendPacket = new DatagramPacket(MSG.getBytes(), MSG.length(), remoteBindPoint);

			/* Create datagram packet for receiving echoed message */
			DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);

			/* Send and receive message*/
			socket.send(sendPacket);
			//System.out.println("SAR");
			socket.receive(receivePacket);

			/* Compare sent and received message */
			String receivedString = new String(receivePacket.getData(), receivePacket.getOffset(), receivePacket.getLength());
			if (receivedString.compareTo(MSG) == 0)
				System.out.printf("%d bytes sent and received\n", receivePacket.getLength());
			else
				System.out.printf("Sent and received msg not equal!\n");


		}
	public static void OneSecondDelay (int MSG_RATE) {//During 1 second Sends and Receives X messages as the transfer rate
		long timer = System.currentTimeMillis();

		if (MSG_RATE == 0) { //If transfer rate is 0 print once and close
			try {
				SendAndReceive();
			} catch (IOException e) {
				e.printStackTrace();
			}
			socket.close();
			System.exit(1);

		}
		else{//Keeps running
			while((System.currentTimeMillis()- timer)<1000) {//This while condition runs until the difference between both timers equal to 1 second

				for (int i = 0; i < MSG_RATE; i++) {
					try {
						SendAndReceive();
					} catch (IOException e) {
						e.printStackTrace();
					}

				}
				MSG_RATE = 0;
			}
		}

        }

    public static void  CheckIfParametersAreValid(String args[]) { //Checks if the input is valid or not, relating the parameters expected in the cmd when running the client

		//4 parameter expected, IP,PORT,BUFFER_SIZE,MSG_RATE
		if (args.length != 4) {
			System.err.printf("usage: %s server_name port\n", args[1]);
			System.exit(1);
		}

		IP = args[0];
		PORT = Integer.parseInt(args[1]);
		BUFFER_SIZE = Integer.parseInt(args[2]);
		MSG_RATE = Integer.parseInt(args[3]);

		//Validating Ip - Splitting the ip in 4 numbers because they are dividied by ". " when we get from input
		String[] ipSeparated = args[0].split("\\.");

		if(ipSeparated.length<4 ){
			System.out.println("Invalid IP format.");
			System.exit(1);
		}
		if (ipSeparated.length == 4) {

			for (int i = 0; i < ipSeparated.length; i++) {
				if (Integer.valueOf(ipSeparated[i]) < 0 || Integer.valueOf(ipSeparated[i]) > 255 ) {//if ip is not complete i get error
					System.out.println("Invalid IP format.");
					System.exit(1);
				}else {
					IP = args[0];
				}
			}
		}
		//Validating Port - The Port number has to be between 0 adn 65535
		if (Integer.parseInt(args[1])>= 0 && Integer.parseInt(args[1]) < 65535) {
			PORT = Integer.parseInt((args[1]));
		}
		else {
			System.out.println("Invalid PORT Number.");
			System.exit(1);
		}
		//Validating Buffer - The Buffer Size ahs to be between 0 and 2048
		if (Integer.parseInt(args[2]) > 0 || Integer.parseInt(args[2]) < 2048) {
			BUFFER_SIZE = Integer.parseInt((args[2]));
		}

		else {
			System.out.println("Invalid Buffer Size.");
			System.exit(1);
		}
		//Checking the parameter order of the deserved place for message rate
		if (Integer.parseInt(args[3]) >= 0) {
			MSG_RATE = Integer.parseInt(args[3]);
		} else {
			System.out.println("Message RATE Invalid.");
			System.exit(1);
		}

	}
}









