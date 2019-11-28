package listners;

import classes.User;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static GUIs.MainPage.*;
import static listView.TestListView.*;

public class MainPageHandler extends MouseAdapter implements ActionListener, ListSelectionListener {
    @Override
    public void valueChanged(ListSelectionEvent e) {
        User user = (User)(list.getSelectedValue());
        System.out.println(user);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == settings) {

        }
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        if (event.getSource() == followers) {

        } else if (event.getSource() == followed) {

        } else if (event.getSource() == likedTracks) {

        } else if (event.getSource() == playlists) {

        } else if (event.getSource() == creator) {

        } else if (event.getSource() == home) {

        }
    }

    @Override
    public void mouseEntered(MouseEvent event) {
        if (event.getSource() == followers) {
            followers.setFont(new Font(Font.SERIF, Font.BOLD, 25));

        } else if (event.getSource() == followed) {
            followed.setFont(new Font(Font.SERIF, Font.BOLD, 25));

        } else if (event.getSource() == likedTracks) {
            likedTracks.setFont(new Font(Font.SERIF, Font.BOLD, 25));

        } else if (event.getSource() == playlists) {
            playlists.setFont(new Font(Font.SERIF, Font.BOLD, 25));

        } else if (event.getSource() == creator) {
            creator.setFont(new Font(Font.SERIF, Font.BOLD, 25));

        } else if (event.getSource() == home) {
            home.setFont(new Font(Font.SERIF, Font.BOLD, 25));
        } else if (event.getSource() == list) {

        }
    }

    @Override
    public void mouseExited(MouseEvent event) {
        if (event.getSource() == followers) {
            followers.setFont(new Font(Font.SERIF, Font.BOLD, 20));

        } else if (event.getSource() == followed) {
            followed.setFont(new Font(Font.SERIF, Font.BOLD, 20));

        } else if (event.getSource() == likedTracks) {
            likedTracks.setFont(new Font(Font.SERIF, Font.BOLD, 20));

        } else if (event.getSource() == playlists) {
            playlists.setFont(new Font(Font.SERIF, Font.BOLD, 20));

        } else if (event.getSource() == creator) {
            creator.setFont(new Font(Font.SERIF, Font.BOLD, 20));

        } else if (event.getSource() == home) {
            home.setFont(new Font(Font.SERIF, Font.BOLD, 20));

        }
    }
}
