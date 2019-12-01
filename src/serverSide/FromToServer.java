package serverSide;

import classes.ActionConstants;
import classes.User;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * 1 -> will be used for sign in
 * 2 -> will be used for signUp
 * 3 -> will be used for forgot password
 * 4 -> will be used for password change
 * 5 -> will be used for adding a new Song
 */

public class FromToServer implements Runnable, ActionConstants {

    private static int function;
    private static File[] files = getAvailableUsersFromDir();
    private static JTextArea jTextArea = new JTextArea();
    private static Socket socket;


    public FromToServer(Socket socket) {
        FromToServer.socket = socket;
    }


    private static File[] getAvailableUsersFromDir() {
        File file = new File("E:\\Server\\Users");
        return file.listFiles();
    }

    private static boolean isFileOfUsernameExists(String username) {
        if (files != null) {
            for (File file : files) {
                if (file.getName().equalsIgnoreCase(username)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isUsernamePasswordTrue(String username, String password) {
        String string = "E:\\Server\\Users" + "\\" + username + "user.dat";
        File file = new File(string);
        if (isFileOfUsernameExists(username)) {
            boolean isFound = false;
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
                Object object = objectInputStream.readObject();
                if (object instanceof User) {
                    User user = (User) (object);
                    if (user.getPassword().equals(password)) {
                        isFound = true;
                    }
                }

            } catch (IOException | ClassNotFoundException exception) {
                System.out.println("Exception Occurred in verifying password from file");
            }
            return isFound;
        } else {
            return false;
        }
    }


    private static void addUser(String name, String username, String password, String emailAddress) {

    }


    private static ServerSocket getServerSocket() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8000);
        } catch (IOException exception) {
            System.err.println("Exception in creating a server: " + exception.getMessage());
        }
        return serverSocket;
    }

    @Override
    public void run() {
        serverTextArea();
        if (function == SIGN_IN) {
            sendingBackSignInRequest();
        } else if (function == SIGN_UP) {

        } else if (function == FORGOT_PASSWORD) {

        } else if (function == PASSWORD_CHANGE) {

        } else if (function == ADD_SONG) {

        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        ServerPage();
        while (true) {
            Socket socket = serverSocket.accept();
            Thread thread = new Thread(new FromToServer(socket));
            thread.start();
        }
    }

    private static void ServerPage() {
        JFrame jFrame = new JFrame("Current Clients");
        jFrame.setSize(700, 400);


        JPanel panel = new JPanel();
        panel.setSize(400, 400);

        jTextArea.setSize(400, 400);

        panel.add(jTextArea);

        jFrame.add(panel, BorderLayout.CENTER);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private static String allowOrNot() {
        JFrame jFrame = new JFrame();
        String string = JOptionPane.showInputDialog(jFrame, "True for allow, False for Not");
        return string;
    }

    private static void serverTextArea() {
        try {
            String string = allowOrNot();
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            if (string.equalsIgnoreCase("true")) {
                InetAddress inetAddress = socket.getInetAddress();
                String clientAddress = "Client Name: " + inetAddress.getHostName() + " established at " +
                        new Date().toString() + " and IP of client is: " + inetAddress.getHostAddress() + " \n";
                dataOutputStream.writeInt(1);
                jTextArea.append(clientAddress);
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                int id = dataInputStream.readInt();
                function = id;
            } else {
                dataOutputStream.writeInt(0);
            }
        } catch (IOException exception) {
            System.out.println("Error in establishing Server");
        }
    }

    private static void sendingBackSignInRequest() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            Object username = objectInputStream.readObject();
            Object password = objectInputStream.readObject();

            if (username instanceof String && password instanceof String) {
                String user = (String)(username);
                String pass = (String)(password);
                boolean found = isUsernamePasswordTrue(user, pass);
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                if (found) {
                    dataOutputStream.writeInt(1);
                } else {
                    dataOutputStream.writeInt(0);
                }
            }
        } catch (IOException | ClassNotFoundException exception) {
            System.out.println("Exception Occurred while verifying from server in FromToServerClass: " + exception.getMessage());
        }
    }
}
