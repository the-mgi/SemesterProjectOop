package transfer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Transfer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        Socket socket = serverSocket.accept();
        
        File file = new File("E:\\CS\\Semester III\\OOP\\Semester Project\\src\\from\\24 7 Lak Hilna - Urwa Hocane, Ahmad Ali Butt  Punjab Nahi Jaongi.mp3");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        byte[] array = new byte[(int)file.length()];
        System.out.println("length out");

        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        dataOutputStream.write(array.length);
        System.out.println("written");
        dataOutputStream.flush();

        bufferedInputStream.read(array);

        for (byte b: array) {
            System.out.print(b + " ");
        }

        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
        System.out.println("started Writing data");
        outputStream.write(array);
        outputStream.flush();
        outputStream.close();
        System.out.println("transfer completed");
    }
}
