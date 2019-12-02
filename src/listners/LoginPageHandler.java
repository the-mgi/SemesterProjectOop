package listners;

import GUIs.ForgotPasswordPage;
import GUIs.MainPage;
import GUIs.SignUpPage;
import classes.ActionConstants;
import classes.Task;
import classes.User;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static GUIs.LoginPage.*;
import static classes.GeneralPurpose.closeAppServerNotRunning;
import static classes.GeneralPurpose.getUser;

public class LoginPageHandler implements ActionListener, ActionConstants {

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == signIn) {
            if (!isServerUp) {
                closeAppServerNotRunning();
            } else {
                try {
                    Thread thread = new Thread(new Task(SIGN_IN));
                    thread.start();
                    thread.join();
                } catch (InterruptedException e) {
                    System.out.println("Thread for sign is interrupted.");
                }
                if (userPassVerified) {
                    User user = getUser();
                    if (user != null) {
                        new MainPage(user);
                    }
                    usernamePasswordStatus.setText("Username and Password has been  verified form the server");
                    usernamePasswordStatus.setForeground(new Color(31, 208, 0));
                } else {
                    usernamePasswordStatus.setText("Record Not Found");
                    usernamePasswordStatus.setForeground(Color.RED);
                }

            }

        } else if (event.getSource() == forgotPassword) {
            if (!isServerUp) {
                closeAppServerNotRunning();
            } else {
                new ForgotPasswordPage();
            }

        } else if (event.getSource() == signUp) {
            if (!isServerUp) {
                closeAppServerNotRunning();
            } else {
                new SignUpPage();
            }
        }
    }
}
