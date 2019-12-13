package listners;

import GUIs.SignUpPage;
import classes.ActionConstants;
import classes.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import static GUIs.LoginPage.socket;
import static GUIs.SignUpPage.*;

public class SignUpPageHandler implements ActionListener, ActionConstants {

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == signUp) {
            if (allHealthy()) {
                registeredOrNot.setText("Valid Information Provided");
                registeredOrNot.setForeground(new Color(31, 208, 0));
            } else {
                registeredOrNot.setText("Info Not Valid");
                registeredOrNot.setForeground(new Color(240, 29, 29));

            }
        }
    }

    private static void sendDataToServer() {
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataOutputStream.writeInt(SIGN_UP);

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            User user = new User(usernameField.getText(), nameField.getText(), emailField.getText(), passwordField.getText());
            objectOutputStream.writeObject(user);

            registeredOrNot.setText("SuccessFully Signed UP. Now You can Sign In");

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Exception Occurred in sendDataToServer in SignPageHandler");
        }

    }

}
