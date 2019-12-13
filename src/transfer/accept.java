package transfer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class accept {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        Socket socket = serverSocket.accept();
        System.out.println("socket accepted");




    }
}
