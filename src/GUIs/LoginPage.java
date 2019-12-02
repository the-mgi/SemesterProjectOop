package GUIs;

import classes.ActionConstants;
import listners.LoginPageHandler;

import javax.swing.*;
import java.awt.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

import static classes.GeneralPurpose.getLabelOther;

public class LoginPage extends JFrame implements ActionConstants {

    public static JLabel username, password, serverStatus, usernamePasswordStatus;
    public static JTextField usernameField = new JTextField();
    public static JPasswordField passwordField = new JPasswordField();
    public static JFrame frameToClose;
    public static JButton signIn, signUp, forgotPassword;
    private static String ipAddress;
    public static Socket socket = null;
    public static boolean isServerUp = true;
    public static boolean userPassVerified = false;

    public LoginPage() {
        new SocketAndAddress();//for obtaining ip and port
        this.initializations();
        createSocket();

        super.setSize(400, 400);
        super.setTitle("Login Page");
        super.setResizable(false);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        super.setLayout(new BorderLayout());
        super.add(getPanelOne(), BorderLayout.CENTER);
        super.add(getPanel(), BorderLayout.SOUTH);
        super.add(getSpacing(), BorderLayout.EAST);
        super.add(getSpacing(), BorderLayout.WEST);
        super.add(getSpacing(), BorderLayout.NORTH);
        super.setVisible(true);

        frameToClose = this;
    }

    private JPanel getPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 2));
        panel.add(signIn);
        panel.add(signUp);
        panel.add(forgotPassword);
        return panel;
    }

    private JPanel getPanelOne() {
        JPanel panel1 = new JPanel(new GridLayout(6, 6));
        panel1.add(username);
        panel1.add(usernameField);
        panel1.add(password);
        panel1.add(passwordField);

        Box box = Box.createHorizontalBox();
        box.add(Box.createHorizontalStrut(20));
        box.add(serverStatus);
        box.add(Box.createHorizontalStrut(20));
        box.add(usernamePasswordStatus);


        panel1.add(box);
        return panel1;
    }

    static JPanel getSpacing() {
        JPanel panel = new JPanel();
        panel.setSize(200, 200);
        return panel;
    }

    private void initializations() {
        LoginPageHandler handler = new LoginPageHandler();
        username = getLabelOther("UserName");
        password = getLabelOther("Password");
        serverStatus = getLabelOther("");
        usernamePasswordStatus = getLabelOther("");
        signIn = new JButton("Sign In");
        signUp = new JButton("SignUp");
        forgotPassword = new JButton("ForgotPassword");
        signUp.addActionListener(handler);
        signIn.addActionListener(handler);
        forgotPassword.addActionListener(handler);
    }

    public static void main(String[] args) {
        new LoginPage();
    }

    private static void createSocket() {
        try {
            LoginPage.socket = new Socket(ipAddress, 8080);
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            int trueOrFalse = dataInputStream.readInt();
            if (trueOrFalse == 1) {
                up();
            } else {
                socket.close();
                down();
            }
        } catch (IOException ex) {
            down();
        }
    }

    private static void up() {
        serverStatus.setText("Server is UP :)");
        serverStatus.setForeground(new Color(31, 208, 0));
        isServerUp = true;
    }

    private static void down() {
        serverStatus.setText("Server is Down :(");
        isServerUp = false;
        serverStatus.setForeground(Color.RED);
        System.out.println("Exception While creating Client End Port");
    }

    class SocketAndAddress extends JFrame {
        SocketAndAddress() {
            ipAddress = JOptionPane.showInputDialog(this, "IP address of Server: ");
        }
    }
}
