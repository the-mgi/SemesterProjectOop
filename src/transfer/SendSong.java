package transfer;

import javax.xml.crypto.Data;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SendSong {
    public static void main(String[] args) throws Exception {
        File file = new File("E:\\CS\\Semester III\\OOP\\Semester Project\\src\\from\\24 7 Lak Hilna - Urwa Hocane, Ahmad Ali Butt  Punjab Nahi Jaongi.mp3");
        byte[] arrayToTransfer = new byte[(int) file.length()];

        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        int number = bufferedInputStream.read(arrayToTransfer, 0, arrayToTransfer.length);


        ServerSocket serverSocket = new ServerSocket(8080);
        Socket socket = serverSocket.accept();
        System.out.println("socket Accepted");

        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        dataOutputStream.write(arrayToTransfer);

        dataOutputStream.flush();
        dataOutputStream.close();

        System.out.println("File Transferred");


    }
}
