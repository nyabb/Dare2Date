package nl.ead.webservice.services;

import com.wrapper.spotify.models.PlaylistTrack;
import nl.ead.webservices.models.User;
import nl.ead.webservices.models.UserStorage;

import java.util.ArrayList;
import java.util.List;

public class MatchingService {

    private UserStorage userStorage;

    public MatchingService(UserStorage storage)
    {
        this.userStorage = storage;
    }

    public List<nl.ead.webservice.User> convertMatches(List<User> usersFromMatch) {
        List<nl.ead.webservice.User> userList = new ArrayList<nl.ead.webservice.User>();
        for(User unconvertedUser : usersFromMatch) {
            nl.ead.webservice.User userToBeAdded = new nl.ead.webservice.User();
            userToBeAdded.setGender("Male");
            userToBeAdded.setName("test");
            userToBeAdded.setUserId(unconvertedUser.getUserId());

            userList.add(userToBeAdded);
        }

        return userList;
    }

    public ArrayList<User> matches(User currentUser)
    {
        ArrayList<User> matches = new ArrayList<User>();

        for(User user : this.userStorage.getUsers())
        {
            if(user != currentUser)
            {
                for (PlaylistTrack playlistTrack : currentUser.getUserPlayList()) {
                    for (PlaylistTrack userPlaylistTrack : user.getUserPlayList()) {


                        if(playlistTrack.getTrack().getName().equals(userPlaylistTrack.getTrack().getName())) {
                            if(!matches.contains(user)) {
                                matches.add(user);
                            }
                            break;
                        }
                    }
                }
            }
        }

        return matches;
    }

    public boolean matchUsers(User user, User match) {
        user.addMatch(match);
        return match.addMatch(user);
    }
}
