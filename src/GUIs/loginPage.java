package GUIs;

import listners.LoginPageHandler;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;


public class loginPage extends JFrame {
    private static JLabel username, password;

    public static JTextField usernameField = new JTextField();
    public static JPasswordField passwordField = new JPasswordField();

    public static JButton signIn, signUp, forgotPassword;

    public loginPage() {
        this.initializations();

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


    }

    private JPanel getPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 2));
        panel.add(signIn);
        panel.add(signUp);
        panel.add(forgotPassword);
        return panel;
    }

    private JPanel getPanelOne() {
        JPanel panel1 = new JPanel(new GridLayout(7, 7));
        panel1.add(username);
        panel1.add(usernameField);
        panel1.add(password);
        panel1.add(passwordField);
        return panel1;
    }

    private JPanel getSpacing() {
        JPanel panel = new JPanel();
        panel.setSize(200, 200);
        return panel;
    }

    private void initializations() {
        LoginPageHandler handler = new LoginPageHandler();
        username = new JLabel("UserName");
        password = new JLabel("Password");
        signIn = new JButton("Sign In");
        signUp = new JButton("SignUp");
        forgotPassword = new JButton("ForgotPassword");
        signUp.addActionListener(handler);
        signIn.addActionListener(handler);
        forgotPassword.addActionListener(handler);
    }

    public static void main(String[] args) {
        new loginPage();
    }
}
