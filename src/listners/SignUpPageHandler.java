package listners;

import GUIs.SignUpPage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static GUIs.SignUpPage.signUp;

public class SignUpPageHandler implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == signUp) {
            if (SignUpPage.areHealthyFields) {

            } else {
                SignUpPage.registeredOrNot.setText("Info Not Valid");
                SignUpPage.registeredOrNot.setForeground(new Color(240, 29, 29));

            }
        }
    }

}
