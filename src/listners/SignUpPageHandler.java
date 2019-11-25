package listners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUIs.SignUpPage;

public class SignUpPageHandler implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == SignUpPage.nameField) {
            System.out.println(SignUpPage.nameField.getText());
        }
    }


}
