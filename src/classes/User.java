package classes;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
    private String userName;
    private String name;
    private String emailAddress;
    private String password;
    private boolean isCreator = false;
    private ArrayList<Playlist> playlists = new ArrayList<>();
    private ArrayList<Song> likedSongs = new ArrayList<>();
    private ArrayList<User> followers = new ArrayList<>();
    private ArrayList<User> thisUserFollowed = new ArrayList<>();

    public User(String userName, String name, String emailAddress, String password) {
        this.userName = userName;
        this.name = name;
        this.emailAddress = emailAddress;
        this.password = password;
    }

    public User(User user) {
        this(user.userName, user.name, user.emailAddress, user.password);
    }

    public boolean isCreator() {
        return isCreator;
    }

    public void setCreator(boolean creator) {
        isCreator = creator;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addNewPlaylist(Playlist playlist) {
        playlists.add(playlist);
    }

    public void addToLikedSongs(Song song) {
        likedSongs.add(song);
    }

    public void addToFollowers(User user) {
        followers.add(user);
    }

    public void addToThisUserFollowed(User user) {
        thisUserFollowed.add(user);
    }

    public void removerFromPlaylist(Playlist playlist) {
        playlists.remove(playlist);
    }

    public void removerFromLikedSongs(Song song) {
        likedSongs.remove(song);
    }

    public void removeFollower(User user) {
        followers.remove(user);
    }

    public void removerFromThisUserFollowed(User user) {
        thisUserFollowed.remove(user);
    }

    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    public ArrayList<Song> getLikedSongs() {
        return likedSongs;
    }

    public ArrayList<User> getFollowers() {
        return followers;
    }

    public ArrayList<User> getThisUserFollowed() {
        return thisUserFollowed;
    }

    @Override
    public String toString() {
        return "Username: " + this.userName + "\nName: " + name + "\nEmail Address: " + this.emailAddress +
                "\nPassword: " + this.password + "\n";
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof User) {
            User user = (User)(object);
            return this.emailAddress.equalsIgnoreCase(user.emailAddress) && this.name.equalsIgnoreCase(user.name);
        }
        return false;
    }
}
