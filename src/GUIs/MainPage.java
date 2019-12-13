package GUIs;

import classes.User;
import listners.MainPageHandler;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import static classes.GeneralPurpose.getLabel;

public class MainPage extends JFrame {

    public static JLabel followers, followed, likedTracks, playlists, creator, home;
    private static Dimension screenResolution = Toolkit.getDefaultToolkit().getScreenSize();
    public static JButton settings;

    public MainPage(User user) {

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


            super.add(getVBox(), BorderLayout.WEST);
            super.add(hBox, BorderLayout.NORTH);
            try {
                JPanel panel = new JPanel();
                panel.add(getScrollPane());
                super.add(panel, BorderLayout.CENTER);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }).start();
    }

    private JScrollPane getScrollPane() throws IOException {
        JScrollPane jScrollPane = new JScrollPane();
        JTable table = new JTable();
        DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();

        File file = new File("E:\\Songs\\Songs\\ClipGrab\\New folder\\New folder\\New folder\\New folder");
        File[] array = file.listFiles();

        Object[] arrayObjects = new Object[3];

        if (array != null) {
            for (int i = 0; i < array.length; i++) {
                File gotFileFromArray = array[i];
                arrayObjects[0] = gotFileFromArray.getName();
                arrayObjects[1] = gotFileFromArray.getAbsolutePath();
                arrayObjects[2] = gotFileFromArray.getParentFile();
                defaultTableModel.addRow(arrayObjects);
            }
        }
        return jScrollPane;
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

    private Box getVBox() {
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
