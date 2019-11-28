package listners;

import GUIs.SignUpPage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static GUIs.SignUpPage.*;

public class SignUpPageHandler implements ActionListener {

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

}
