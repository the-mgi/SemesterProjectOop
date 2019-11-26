package GUIs;

import listners.ForgotPageHandler;

import javax.swing.*;
import java.awt.*;

public class ForgotPasswordPage extends JFrame {
    private static JLabel username, emailAddress;

    public static JLabel status;

    public static JButton verify;

    public static JTextField usernameField, emailField;

    public ForgotPasswordPage() {
        this.initializations();
        super.setTitle("Forgot Password Page");
        super.setVisible(true);
        super.setSize(400, 400);
        super.setResizable(false);

        JPanel jPanel = new JPanel(new GridLayout(6, 6));
        jPanel.add(username);
        jPanel.add(usernameField);
        jPanel.add(emailAddress);
        jPanel.add(emailField);

        JPanel button = new JPanel();
        button.add(verify);
        button.add(status);

        verify.addActionListener(new ForgotPageHandler());

        super.setLayout(new BorderLayout());
        super.add(jPanel, BorderLayout.CENTER);
        super.add(button, BorderLayout.SOUTH);
        super.add(LoginPage.getSpacing(), BorderLayout.EAST);
        super.add(LoginPage.getSpacing(), BorderLayout.WEST);
    }


    public void initializations() {
        username = MainPage.getLabel("Username");
        emailAddress = MainPage.getLabel("Email Address");
        status = MainPage.getLabel("");

        verify = new JButton("Verify");

        usernameField = new JTextField();
        emailField = new JTextField();
    }

}
