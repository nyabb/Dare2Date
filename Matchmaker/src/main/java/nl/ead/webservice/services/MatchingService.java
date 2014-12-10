package nl.ead.webservice.services;

import com.wrapper.spotify.models.PlaylistTrack;
import nl.ead.webservices.models.User;
import nl.ead.webservices.models.UserStorage;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MatchingService {

     private UserStorage userStorage;

    public MatchingService(UserStorage storage)
    {
        this.userStorage = storage;
    }

    public ArrayList<User> matches (User currentUser)
    {
        ArrayList<User> matches = null;
        for(User user : this.userStorage.getUsers())
        {
            if(user!=currentUser) {

                for (PlaylistTrack curUserPlaylist : currentUser.getUserPlayList()) {
                    for (PlaylistTrack userPlaylist : user.getUserPlayList())
                        if (curUserPlaylist.getTrack().getName().equals(userPlaylist.getTrack().getName())) {
                            matches.add(user);
                        }
                }

            }
        }
        return matches;
    }
}
