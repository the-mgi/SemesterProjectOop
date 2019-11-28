package listners;

import GUIs.ForgotPasswordPage;
import GUIs.LoginPage;
import GUIs.MainPage;
import GUIs.SignUpPage;
import classes.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static GUIs.LoginPage.*;

public class LoginPageHandler implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == signIn) {
            frameToClose.dispose();
            new MainPage(new User());

        } else if (event.getSource() == forgotPassword) {
            new ForgotPasswordPage();

        } else if (event.getSource() == signUp) {
            new SignUpPage();
        }
    }
}
