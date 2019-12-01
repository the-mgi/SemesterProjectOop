package classes;

import listners.MainPageHandler;

import javax.swing.*;
import java.awt.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import static GUIs.LoginPage.frameToClose;
import static GUIs.LoginPage.socket;

public class GeneralPurpose {
    public static boolean isNameCorrect(String string) {
        if (string.length() < 5) {
            return false;
        }
        char[] array = string.toCharArray();
        for (char character: array) {
            System.out.println(character);
            if (!Character.isAlphabetic(character) && !Character.isSpaceChar(character)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isUsernameCorrect(String string) {
        if(string.length() < 8) {
            return false;
        }
        char[] array = string.toCharArray();
        int number = 0;
        int alphabet = 0;
        for (char character: array) {
            if (Character.isAlphabetic(character)) {
                alphabet += 1;
            }
            if (Character.isDigit(character)) {
                number += 1;
            }
        }
        return (alphabet > 2 && number > 2) && (alphabet + number) == string.length();
    }

    public static boolean isEmailCorrect(String string) {
        if (string.length() < 12) {
            return false;
        }
        String str = string.substring(string.length() - 4, string.length());
        System.out.println(str);
        return string.contains("@") && (str.contains(".com") ^ str.contains(".pk"));
    }

    public static boolean isPasswordCorrect(String string) {
        if (string.length() < 8) {
            return false;
        }
        char[] array = string.toCharArray();
        int alphabet = 0;
        int sign = 0;
        int number = 0;
        for (char character : array) {
            if (Character.isAlphabetic(character) || Character.isSpaceChar(character)) {
                alphabet += 1;
            }
            if (Character.isDigit(character)) {
                number += 1;
            }
            if (character >= 33 && character <= 47) {
                sign += 1;
            }
        }
        return (alphabet > 5 && number > 1 && sign > 0) && (number + sign + alphabet) == string.length();
    }

    public static JLabel getLabel(String string) {
        JLabel jLabel = new JLabel(string);
        jLabel.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        jLabel.addMouseListener(new MainPageHandler());
        return jLabel;
    }

    public static void closeAppServerNotRunning() {
        JFrame jFrame = new JFrame();
        JOptionPane.showMessageDialog(jFrame, "Server Not Running");
        jFrame.setVisible(true);
        frameToClose.dispose();
        System.exit(0);
    }

    public static User getUser() {
        User user = null;
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            Object object = objectInputStream.readObject();
            if (object instanceof User) {
                user = (User) (object);
            }
        } catch (IOException | ClassNotFoundException exception) {
            System.out.println("Error in obtaining user from Server: " + exception.getMessage());
        }
        return user;
    }
}
