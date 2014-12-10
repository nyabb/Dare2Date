package nl.ead.webservices.models;

import com.wrapper.spotify.models.PlaylistTrack;
import java.util.*;

public class User {
    private int userId;
    private String spotifyUserId;
    private String playlistId;
    List<PlaylistTrack> userPlayList = null;

    public User(int userId, String spotifyUserId, String playlistId) {
        this.userId = userId;
        this.spotifyUserId = spotifyUserId;
        this.playlistId = playlistId;
    }

    public String getSpotifyUserId() {
        return this.spotifyUserId;
    }

    public String getSpotifyUserPlaylistId() {
        return this.playlistId;
    }

    public void setUserPlayList(List<PlaylistTrack> userPlayList) {
        this.userPlayList = userPlayList;
    }


    public List<PlaylistTrack> getUserPlayList() {
        return this.userPlayList;
        }


}
