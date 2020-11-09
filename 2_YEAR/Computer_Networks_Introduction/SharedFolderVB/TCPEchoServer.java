
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;



public class TCPEchoServer {

    public static final int BUFSIZE= 1024;
    public static final int MYPORT= 5000;
    public static int ID = 1;
    private static Socket socket;

    public static void main(String[] args) throws IOException {


        byte[] buffer = new byte[BUFSIZE];

        /* Create socket */
        ServerSocket ServerSocket =new ServerSocket(MYPORT);

        while(true) {
            try{
                socket = ServerSocket.accept();   // Listen to Client requests
                TCP_Class Client = new TCP_Class(ID,socket,buffer);
                Thread Thread = new Thread(Client);
                Thread.start();
            } catch (IOException e) {
                e.printStackTrace();
                socket.close();
            }

        }

        }
}

class TCP_Class implements Runnable{



    private static Socket socket;
    private static byte[] Buffer;
    private static int ID;


    public TCP_Class (int ID, Socket socket, byte[] Buffer){

       this.ID  = ID;
       this.socket = socket;
       this.Buffer = Buffer;

    }
    @Override
    public void run() {

        try {
            InputStream Receiver = socket.getInputStream();
            OutputStream Sender = socket.getOutputStream();

            while(true){
                Receiver.read(Buffer); //Takes all the information form the input stream, reads it and adds it to the buffer


                String Write = new String(Buffer);
                Write.trim(); //Clears both right and left side empty/blank spaces

                Sender.write(Buffer, 0,Write.length());  //Writes all bytes from the specified byte array starting at offset off to this output stream.
                System.out.println("IP: "+socket.getInetAddress().getHostAddress());
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Connection lost with "+ID);
            try {
                socket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }


}
