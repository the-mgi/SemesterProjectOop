package classes;

import GUIs.LoginPage;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import static GUIs.LoginPage.*;
import static classes.GeneralPurpose.*;

public class Task implements Runnable, ActionConstants {

    private int function;

    public Task(int function) {
        this.function = function;
    }

    @Override
    public void run() {
        if (function == SIGN_IN) {
            if (checkForEmpty(usernameField) && checkForEmpty(passwordField)) {
                sendCommandToServer(SIGN_IN);
                sendSignInInfo();
            } else {

            }
        } else if (function == SIGN_UP) {

        } else if (function == FORGOT_PASSWORD) {

        } else if (function == PASSWORD_CHANGE) {

        } else if (function == ADD_SONG) {

        }
    }

    public static void sendSignInInfo() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        if ((isUsernameCorrect(username) && isPasswordCorrect(password))) {
            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                objectOutputStream.writeObject(username);
                objectOutputStream.writeObject(password);

                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                int isFound = dataInputStream.readInt();
                userPassVerified = isFound == 1;

            } catch (IOException exception) {
                System.out.println("Error while sending username and password to server " + exception.getMessage());
            }
        } else {
            userPassVerified = false;
        }
    }
}
