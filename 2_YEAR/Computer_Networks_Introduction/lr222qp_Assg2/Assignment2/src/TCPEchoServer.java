
import java.io.*;
import java.net.*;
import java.util.ArrayList;


public class TCPEchoServer {

    private static String DIRECTORY;
    private static int PORT;
    public static final int BUFSIZE = 1024;
    public static int ID = 1;
    private static Socket socket = new Socket();


    public TCPEchoServer (String [] args ){
        CheckIfParametersAreValid(args);
    }


    public void StartMethod() {

        try {
            byte[] buffer = new byte[BUFSIZE];

            /* Create socket */
            ServerSocket ServerSocket = null;
            try {
                ServerSocket = new ServerSocket(PORT);
            } catch (IOException e) {
                e.printStackTrace();
            }

            while (true) {
                socket = ServerSocket.accept();   // Listen to Client requests
                try {

                    TCP_Class Client = new TCP_Class(ID, socket, buffer, DIRECTORY);
                    System.out.println("------------------------------------");
                    System.out.println("Client "+ ID+ " is connected");
                    Thread newThread = new Thread(Client, "Client" + ID + " :");
                    newThread.start();


                    ID+=1;


                } catch (Exception e) {
                    e.printStackTrace();
                    socket.close();
                    Thread.currentThread().interrupt();

                }

            }
        }catch (IOException i){

        }

    }

    private void  CheckIfParametersAreValid(String [] args) {

        // 2 parameter expected, [PORT] and [DIRECTORY]

        if (args.length != 2) {
            System.err.printf("Incorrect input arguments. Please make sure to use the correct format (PORT , PATH/Directory)");
            System.exit(1);
        }
        PORT = Integer.parseInt(args[0]);

        if (Integer.parseInt(args[0])>= 0 && Integer.parseInt(args[0]) < 65535) {
            PORT = Integer.parseInt((args[0]));
        }
        DIRECTORY = args[1] ;

        File file = new File(DIRECTORY);
        if( !file.isDirectory()){
            System.err.printf("The following path/directory does not exist. Please make sure to input a valid one.");
            System.exit(1);
        }
        else{
            System.out.println("Server connected.");
        }

    }


}

class TCP_Class implements Runnable{

    private static Socket socket;
    private static byte[] Buffer;
    private static int ID;
    private HTTP_Protocol http = new HTTP_Protocol();
    InputStream Receiver = null;
    OutputStream Sender = null;
    private String directory;
    public TCP_Class (int ID, Socket socket, byte[] Buffer, String directory){

        this.ID  = ID;
        this.socket = socket;
        this.Buffer = Buffer;
        this.directory = directory;
    }


    /**
     * TO DELETE
     * The run method will take the data sent by the client with the InputStream.
     * Then it will call the method readHttpGetRequestLine from HttpProtocolHandler class.
     * This one will take care of all the data sent by the client and split it into multiple chunks
     * to make sure that later on it can be used. For instance, after doing that, we need to check,
     * if the client sent a GET, POST or PUT method. And from there, we decide what method to call and so on.
     * If something wrong happens it will close the client with the method closeClient().
     *
     */


    /**
     * TO COMPLETE
     */

    @Override
    public void run() {

        try {
            Receiver = socket.getInputStream();
            Sender = socket.getOutputStream();

            while(true) {


                int DataSize = Receiver.read(Buffer); //Takes all the information form the input stream, reads it and adds it to the buffer

                String Write = new String(Buffer, 0, DataSize); //compare sent and received string

                ArrayList<Byte> DataInBytes = new ArrayList<>();

                for (int i = 0; i < Buffer.length; i++) {
                    DataInBytes.add(Buffer[i]);
                }

                //Allows to check if there are still data into the stream
                while(Receiver.available()>0) {

                    DataSize = Receiver.read(Buffer);

                    Write += new String(Buffer, 0, DataSize);

                }

                http.requestLineGET(Write); //Will get all the data

                if(http.requestGET.equals("GET")){
                    sendToBrowser(directory);
                }

            }


        } catch (IOException e) {
            System.err.println("Connection lost with "+ID);
            try {
                socket.close();
                Thread.currentThread().interrupt();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

    /**
     * TO DELETE
     * This method will call readAll() method from HttpProtocolHandler and getResponseHeader().
     * After receiving all the data needed from HttpProtocolHandler, it will combine both bytes arrays.
     * After combining them, it will send them through OutputStream and the close.
     *
     * The byte array "data" will usually contains the HTML page (optional).
     * The byte array "headerData" will contain the response header.
     *
     * The combined array called "concatenated" will contain the whole Server response Message
     * (Response Header + Response Body (optional)).
     * @param getRootDirectory Takes the Directory where HTML files are located.
     *
     */

    /**
     * To Complete
     * @param getRootDirectory directory where the HTML files are located
     */

    private void sendToBrowser(String getRootDirectory){
        try {
            byte[] data = null;
            try {
                data = http.startReading(getRootDirectory);
            }catch (Exception e){

            }

            System.out.println(http.header);
            byte[] headerData = http.getResponseHeader().getBytes();

            ByteArrayOutputStream combined = new ByteArrayOutputStream();
            combined.write(headerData);

            try {
                combined.write(data);
            }catch (Exception e){

            }
            byte[] concatenated = combined.toByteArray();

            /* Send message*/
            Sender.write(concatenated);
            Sender.flush();
            Sender.close();
        }catch (IOException ie){
            try {
                socket.close();
                Thread.currentThread().interrupt();
            } catch (IOException e){

            }


        }
    }




}
