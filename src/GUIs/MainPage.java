package GUIs;

import classes.Task;
import classes.User;
import listners.MainPageHandler;

import javax.swing.*;
import java.awt.*;

public class MainPage extends JFrame {
    public static JLabel followers, followed, likedTracks, playlists, creator, home;
    private static Dimension screenResolution = Toolkit.getDefaultToolkit().getScreenSize();

    public static JButton settings;

    public MainPage(User user) {
        Thread thread = new Thread(new Task(user));
        thread.start(); //to initialize the list of the songs etc

        new Thread(() -> {
            this.initializations();
            super.setTitle("theMGI");
            super.setSize((int) (screenResolution.getWidth()), (int) (screenResolution.getHeight()));
            super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            super.setVisible(true);

            super.setLayout(new BorderLayout());

            Box hBox = Box.createHorizontalBox();
            hBox.add(Box.createHorizontalStrut(900));
            hBox.add(settings);

            super.add(getVbox(), BorderLayout.WEST);
            super.add(hBox, BorderLayout.NORTH);

        }).start();
    }

    private void initializations() {
        home = getLabel("Home");
        followers = getLabel("Followers");
        followed = getLabel("Followed");
        likedTracks = getLabel("Liked Tracks");
        playlists = getLabel("Playlists");
        creator = getLabel("Creator Tab");

        settings = new JButton("Settings");
        settings.addActionListener(new MainPageHandler());
    }

    public static JLabel getLabel(String string) {
        JLabel jLabel = new JLabel(string);
        jLabel.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        jLabel.addMouseListener(new MainPageHandler());
        return jLabel;
    }

    private Box getVbox() {
        Box vBox = Box.createVerticalBox();
        vBox.add(Box.createVerticalStrut(270));
        vBox.add(home);
        vBox.add(followers);
        vBox.add(likedTracks);
        vBox.add(playlists);
        vBox.add(creator);
        vBox.add(followed);
        vBox.add(Box.createHorizontalStrut(20));
        return vBox;
    }

    public static void main(String[] args) {
        new MainPage(new User());
    }
}
