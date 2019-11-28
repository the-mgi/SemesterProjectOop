package serverSide;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class FromToServer implements Runnable{

    private ServerSocket serverSocket = getServerSocket();

    private static ServerSocket getServerSocket() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8000);
        } catch (IOException exception) {
            System.err.println("Exception in creating a server: " + exception.getMessage());
        }
        return serverSocket;
    }
//
//    private static boolean isUsernamePasswordTrue(String username, String password) {
//
//    }

    private static void addUser(String name, String username, String password, String emailAddress) {
        StringBuilder stringBuilder = new StringBuilder("E:\\Server\\Users");
        System.out.println(new File(stringBuilder.toString()).exists());
        stringBuilder.append("\\");
        stringBuilder.append(username);
        File file = new File(stringBuilder.toString());
        System.out.println(file.mkdir());

    }

    @Override
    public void run() {

    }

    public static void main(String[] args) throws IOException{
        ServerSocket serverSocket = getServerSocket();
        while (true) {
            Socket socket = serverSocket.accept();
            Thread thread = new Thread(new FromToServer());

        }
    }
}
