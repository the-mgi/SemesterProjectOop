package listners;

import GUIs.ForgotPasswordPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static GUIs.ForgotPasswordPage.verify;

public class ForgotPageHandler implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == verify) {
            ForgotPasswordPage.status.setText("Text Setter");
        }
    }

    private boolean verifyNameEmail(String username, String emailAddress) {

        return false;
    }

    private static String getTextFromField(JTextField textField) {
        return textField.getText();
    }

}
