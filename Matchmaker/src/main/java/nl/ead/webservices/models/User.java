package nl.ead.webservices.models;

import com.wrapper.spotify.models.PlaylistTrack;
import java.util.*;

public class User {
    private int userId;
    private String spotifyUserId;
    private String facebookUserId = "natnael.abbai";
    private String playlistId;
    private String name;
    private Integer age;
    private List<User> matches = new ArrayList<User>();
    List<PlaylistTrack> userPlayList = null;

    public User(int userId, String spotifyUserId, String playlistId,String name, Integer age) {
        this.userId = userId;
        this.spotifyUserId = spotifyUserId;
        this.playlistId = playlistId;
        this.name = name;
        this.age = age;
    }

    public int getUserId() {
        return this.userId;
    }

    public String getSpotifyUserId() {
        return this.spotifyUserId;
    }
    public String getFacebookUserId() {
        return this.facebookUserId;
    }

    public String getSpotifyUserPlaylistId() {
        return this.playlistId;
    }

    public boolean setUserPlayList(List<PlaylistTrack> userPlayList) {
        if(userPlayList != null) {
            this.userPlayList = userPlayList;

            return true;
        }

        return false;
    }

    public List<PlaylistTrack> getUserPlayList() {
        return this.userPlayList;
    }

    public boolean addMatch(User match) {
        if(!matches.contains(match)) {
            matches.add(match);

            return true;
        }

        return false;
    }
}
