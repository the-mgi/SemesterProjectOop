package GUIs;

import listners.SignUpPageHandler;

import javax.swing.*;
import java.awt.*;

import static classes.GeneralPurpose.*;

public class SignUpPage extends JFrame {

    private static JLabel username, name, emailAddress, password, code;
    public static JLabel usernameComment, nameComment, emailComment, passwordComment, codeComment, registeredOrNot;
    public static JTextField usernameField, emailField, nameField, codeField;
    public static JPasswordField passwordField = new JPasswordField();
    public static JButton signUp;
    public static JProgressBar jProgressBar = new JProgressBar();

    public SignUpPage() {
        this.initializations();
        super.setTitle("SignUp Page");
        super.setSize(500, 500);
        super.setResizable(false);

        super.setLayout(new BorderLayout());

        super.add(getMainPanel(), BorderLayout.CENTER);
        super.add(getV(), BorderLayout.SOUTH);
        super.setAlwaysOnTop(false);
        super.setVisible(true);
    }

    private void initializations() {
        username = getLabel("Username");
        name = getLabel("Name");
        emailAddress = getLabel("Email Address");
        password = getLabel("Password");
        code = getLabel("VerificationCode");
        registeredOrNot = getLabel("");
        usernameComment = getLabel("");
        nameComment = getLabel("");
        emailComment = getLabel("");
        passwordComment = getLabel("");
        codeComment = getLabel("");

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

    public static boolean allHealthy() {
        return isEmailCorrect(emailField.getText()) && isNameCorrect(nameField.getText()) && isPasswordCorrect(passwordField.getText()) && isUsernameCorrect(usernameField.getText());
    }

    private Box getV() {
        Box vBox = Box.createVerticalBox();
        vBox.add(jProgressBar);

        Box hBox = Box.createHorizontalBox();
        hBox.add(Box.createHorizontalStrut(10));
        hBox.add(signUp);
        hBox.add(Box.createHorizontalStrut(10));
        hBox.add(registeredOrNot);

        vBox.add(Box.createVerticalStrut(20));
        vBox.add(hBox);
        return vBox;
    }


}
