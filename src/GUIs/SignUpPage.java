package GUIs;

import listners.SignUpPageHandler;

import javax.swing.*;
import java.awt.*;

public class SignUpPage extends JFrame {
    private static JLabel username, name, emailAddress, password, code;

    public static JLabel usernameComment, nameComment, emailComment, passwordComment, codeComment, registeredOrNot;

    public static JTextField usernameField, emailField, nameField, codeField;

    public static JPasswordField passwordField = new JPasswordField();

    public static JButton signUp;

    public static boolean areHealthyFields = false;


    public SignUpPage() {
        this.initializations();
        super.setTitle("SignUp Page");
        super.setSize(500, 500);
        super.setResizable(false);

        super.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.add(signUp);
        panel.add(registeredOrNot);

        super.add(getMainPanel(), BorderLayout.CENTER);
        super.add(panel, BorderLayout.SOUTH);
        super.setAlwaysOnTop(false);
        super.setVisible(true);
    }

    private void initializations() {
        username = new JLabel("Username");
        name = new JLabel("Name");
        emailAddress = new JLabel("Email Address");
        password = new JLabel("Password");
        code = new JLabel("VerificationCode");
        registeredOrNot = new JLabel("");
        usernameComment = new JLabel("");
        nameComment = new JLabel("");
        emailComment = new JLabel("");
        passwordComment = new JLabel("");
        codeComment = new JLabel("");

        usernameField = new JTextField();
        emailField = new JTextField();
        nameField = new JTextField();
        codeField = new JTextField();
        passwordField.setEditable(false);

        signUp = new JButton("SignUp");

        signUp.addActionListener(new SignUpPageHandler());
    }

    private JPanel getMainPanel() {
        JPanel panel = new JPanel(new GridLayout(16, 2));

        panel.add(name);
        panel.add(nameField);
        panel.add(nameComment);

        panel.add(username);
        panel.add(usernameField);
        panel.add(usernameComment);

        panel.add(emailAddress);
        panel.add(emailField);
        panel.add(emailComment);

        panel.add(code);
        panel.add(codeField);
        panel.add(codeComment);

        panel.add(password);
        panel.add(passwordField);
        panel.add(passwordComment);
        return panel;
    }

    public static void main(String[] args) {
        new SignUpPage();
    }
}
