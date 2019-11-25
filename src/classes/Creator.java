package classes;

import java.util.ArrayList;

public class Creator extends User {
    private ArrayList<Song> uploads = new ArrayList<>();

    public Creator(String userName, String name, String emailAddress, String password) {
        super(userName, name, emailAddress, password);
    }

    public Creator(User user) {
        super(user);
        super.setCreator(true);
    }

    public void addInPlaylist(Song song) {
        uploads.add(song);
    }

    public ArrayList<Song> getUploads() {
        return uploads;
    }
}
