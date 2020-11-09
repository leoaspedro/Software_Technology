import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;


public class TCPEchoClient {
    //private static final int MYPORT = 0;
    private static final String MSG = "An Echo Message!";
    private static String IP;
    private static int PORT;
    private static int BUFFER_SIZE;
    private static int MSG_RATE;
    private static Socket socket = new Socket();


    public static void main(String[] args) {

        CheckIfParametersAreValid(args);
        try {

            InetAddress inetAddr = InetAddress.getByName(IP);
            InetSocketAddress addr = new InetSocketAddress(inetAddr,PORT);
            socket.connect(addr, 2000);


        } catch (Exception e) {
            System.out.println("Cannot connect to the server!");

        }

        while(true){
                System.out.println("=====  |1 SECOND PAST| =====");
                OneSecondDelay(MSG_RATE);
            }
    }

    public static void OneSecondDelay (int MSG_RATE) {//Every second sends X messages

        long timer = System.currentTimeMillis();

        if (MSG_RATE == 0) { //If transfer rate is 0 print once and close

                SendAndReceive();

            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.exit(1);

        }
        else{
            while((System.currentTimeMillis()- timer)<1000) {//Until the timer difference is less than 1 second the loop runs

                for (int i = 0; i < MSG_RATE; i++) {

                        SendAndReceive();


                }
                MSG_RATE = 0;
            }
        }

    }


    public static void SendAndReceive()  {
        //Create  buffer
        byte[]buffer = new byte[BUFFER_SIZE];
        try {
            //Sender and Receiver
            OutputStream Sender = socket.getOutputStream();
            Sender.write(MSG.getBytes());//Writes all bytes from the specified byte array starting at offset off to this output stream.

            InputStream Receiver = socket.getInputStream();
            int NumberOfBytes = Receiver.read(buffer);

            String Read = new String(buffer, 0, NumberOfBytes);

            while (Receiver.available() > 0) { //If there are bytes left to read, it reads it again

                NumberOfBytes = Receiver.read(buffer);
                Read += new String(buffer, 0, NumberOfBytes);

            }
            Read = Read.trim();
            if (Read.compareTo(MSG) == 0)
                System.out.printf("%d bytes sent and received\n", Read.length());
            else
                System.out.printf("Sent and received msg not equal!\n");

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Connection lost... Please try again ");
        }
    }
    public static void  CheckIfParametersAreValid(String args[]) {
        //4 parameter expected, IP,PORT,BUFFER_SIZE,MSG_RATE
        if (args.length != 4) {
            System.err.printf("usage: %s server_name port\n", args[1]);
            System.exit(1);
        }

        IP = args[0];
        PORT = Integer.parseInt(args[1]);
        BUFFER_SIZE = Integer.parseInt(args[2]);
        MSG_RATE = Integer.parseInt(args[3]);


        String[] ipSeparated = args[0].split("\\.");

        if(ipSeparated.length<4){
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

        if (Integer.parseInt(args[1])>= 0 && Integer.parseInt(args[1]) < 65535) {
            PORT = Integer.parseInt((args[1]));
        }
        else {
            System.out.println("Invalid PORT Number.");
            System.exit(1);
        }
        if (Integer.parseInt(args[2]) > 0 || Integer.parseInt(args[2]) < 2048) {
            BUFFER_SIZE = Integer.parseInt((args[2]));
        }

        else {
            System.out.println("Invalid Buffer Size.");
            System.exit(1);
        }
        if (Integer.parseInt(args[3]) >= 0) {
            MSG_RATE = Integer.parseInt(args[3]);
        } else {
            System.out.println("Message RATE Invalid.");
            System.exit(1);
        }

    }

}

