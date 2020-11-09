public class RunServer {

    public static void main(String[] args) {
        TCPEchoServer server = new TCPEchoServer(args);
        server.StartMethod();
    }

}
