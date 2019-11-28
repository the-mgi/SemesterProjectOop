package classes;

import java.io.Serializable;

public class Song implements Serializable {
    private String name;
    private String lyricist;
    private String singer;
    private long numberOfLikes;
    private String path;

    public Song(String name, String lyricist, String singer, String path) {
        this(name, lyricist, singer, 0, path);
    }

    public Song(String name, String lyricist, String singer, long numberOfLikes, String path) {
        this.name = name;
        this.lyricist = lyricist;
        this.singer = singer;
        this.numberOfLikes = numberOfLikes;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public String getLyricist() {
        return lyricist;
    }

    public void setLyricist(String lyricist) {
        this.lyricist = lyricist;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public long getNumberOfLikes() {
        return numberOfLikes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfLikes(long numberOfLikes) {
        this.numberOfLikes = numberOfLikes;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "\nName: " + this.name + "\nLyricist: " + this.lyricist +
                "\nSinger: " + singer + "\nNumberOfLikes: " + this.numberOfLikes +
                "\nPath: " + this.path;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        } else if (object instanceof Song) {
            Song song = (Song) (object);
            return song.lyricist.equalsIgnoreCase(this.lyricist) &&
                    song.name.equalsIgnoreCase(this.name) &&
                    song.numberOfLikes == this.numberOfLikes &&
                    song.path.equalsIgnoreCase(this.path) &&
                    song.singer.equalsIgnoreCase(this.singer);
        }
        return false;
    }
}
