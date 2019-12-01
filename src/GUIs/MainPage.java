package GUIs;

import classes.User;
import listners.MainPageHandler;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import static classes.GeneralPurpose.getLabel;

public class MainPage extends JFrame {

    public static JLabel followers, followed, likedTracks, playlists, creator, home;
    private static Dimension screenResolution = Toolkit.getDefaultToolkit().getScreenSize();
    public static JButton settings;

    public MainPage(User user) {
//        Thread thread = new Thread(new Task(user));
//        thread.start(); //to initialize the list of the songs etc

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
            try {
                super.add(getScrollPane(), BorderLayout.CENTER);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }).start();
    }

    private JScrollPane getScrollPane() throws IOException {
        JScrollPane scrollPane = new JScrollPane();
        JPanel panel = new JPanel();

        Box hBox = Box.createHorizontalBox();

        JList<User> userJList = new JList<>();
        DefaultListModel<User> listModel = new DefaultListModel<User>();

        userJList.setModel(listModel);

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("E:\\CS\\Semester III\\OOP\\Semester Project\\src\\Files\\object.dat"));

        try {
            while (true) {
                Object object = objectInputStream.readObject();
                if (object instanceof User) {
                    User user = (User) (object);
                    listModel.addElement(user);
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            objectInputStream.close();
            System.out.println(e.toString());
        }

        hBox.add(userJList);
        panel.add(hBox);
        scrollPane.add(panel);
        return scrollPane;
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
