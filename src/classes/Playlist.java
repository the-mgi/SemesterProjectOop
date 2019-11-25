package classes;

import java.util.ArrayList;

public class Playlist {
    private String playlistName;
    private ArrayList<Song> songs = new ArrayList<>();

    public Playlist(String playlistName) {
        this.playlistName = playlistName;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }


    public void addInPlaylist(Song song) {
        songs.add(song);
    }
}
