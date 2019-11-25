package GUIs;

import javax.swing.*;
import java.awt.*;
import listners.SignUpPageHandler;

public class SignUpPage extends JFrame {
    private static JLabel username, name, emailAddress, password, usernameComment, nameComment, emailComment, passwordComment;

    public static JTextField usernameField, emailField, nameField;

    public static JPasswordField passwordField = new JPasswordField();


    public SignUpPage() {
        this.initializations();
        super.setSize(400, 400);
        super.setVisible(true);

        JPanel jPanel = new JPanel(new GridLayout(10, 10));
        jPanel.add(nameField);
        jPanel.add(passwordField);


        SignUpPageHandler signUpPageHandler = new SignUpPageHandler();

        nameField.addActionListener(signUpPageHandler);

        BorderLayout borderLayout = new BorderLayout();

        super.setLayout(new BorderLayout());
        super.add(jPanel, BorderLayout.CENTER);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);




    }

    private void initializations() {
        username = new JLabel("Username");
        name = new JLabel("Name");
        emailAddress = new JLabel("Email Address");
        password = new JLabel("Password");
        usernameComment = new JLabel("");
        nameComment = new JLabel("");
        emailComment = new JLabel("");
        passwordComment = new JLabel("");

        usernameField = new JTextField();
        emailField = new JTextField();
        nameField = new JTextField();
    }

    public static void main(String[] args) {
        new SignUpPage();
    }


}
