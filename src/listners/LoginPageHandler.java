package listners;

import GUIs.SignUpPage;
import GUIs.loginPage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPageHandler implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == loginPage.signIn) {

        } else if (event.getSource() == loginPage.forgotPassword) {

        } else if (event.getSource() == loginPage.signUp) {
            new SignUpPage();
        }
    }
}
