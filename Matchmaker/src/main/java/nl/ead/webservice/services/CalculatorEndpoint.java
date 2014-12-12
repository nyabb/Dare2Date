package nl.ead.webservice.services;

import java.util.*;
import nl.ead.webservice.*;
import nl.ead.webservices.models.User;
import nl.ead.webservices.models.UserStorage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;

@Endpoint
public class CalculatorEndpoint {
    private UserStorage usersStorage = null;

    @Autowired
    public CalculatorEndpoint(UserStorage userStorage) {
        this.usersStorage = userStorage;
    }

    @PayloadRoot(localPart = "GetPlayListRequest", namespace = "http://www.han.nl/schemas/messages")
    @ResponsePayload
    public GetPlayListResponse matchPlaylistToUser(@RequestPayload GetPlayListRequest req) {
        int userId = req.getInput().getUserId();
        User user = this.usersStorage.getUser(userId);

        SpotifyService spotifyService = new SpotifyService();
        PlayListResult result = new PlayListResult();
        result.setSucces(spotifyService.getPlaylist(user));

        GetPlayListResponse response = new GetPlayListResponse();
        response.setResult(result);

        return response;
    }

    @PayloadRoot(localPart = "GetFindMatchesRequest", namespace = "http://www.han.nl/schemas/messages")
    @ResponsePayload
    public GetFindMatchesResponse findMatchesForUser(@RequestPayload GetFindMatchesRequest req) {
        int findMatchForUser = req.getInput().getUserId();

        MatchingService matchingService = new MatchingService(this.usersStorage);
        ArrayList<User> matches = matchingService.matches(this.usersStorage.getUser(findMatchForUser));

        UserList userList = new UserList();
        List<nl.ead.webservice.User> userListVector = userList.getUser();

        //Has reference so should not be set anymore as userList.
        userListVector.addAll(matchingService.convertMatches(matches));

        FindMatchesResult result = new FindMatchesResult();
        result.setUser(userList);

        GetFindMatchesResponse response = new GetFindMatchesResponse();
        response.setResult(result);

        return response;
    }

    @PayloadRoot(localPart = "GetMatchRequest", namespace = "http://www.han.nl/schemas/messages")
    @ResponsePayload
    public GetMatchResponse matchUserToUser(@RequestPayload GetMatchRequest req) {
        MatchingService matchingService = new MatchingService(this.usersStorage);

        FacebookService facebookService = new FacebookService();
        System.out.print(facebookService.getRelationshipData(this.usersStorage.getUser(0)) + " <- STATUS");

        User user = this.usersStorage.getUser(req.getInput().getUserId());
        User match = this.usersStorage.getUser(req.getInput().getMatchId());

        MatchResult result = new MatchResult();
        result.setSucces(matchingService.matchUsers(user, match));

        GetMatchResponse response = new GetMatchResponse();
        response.setResult(result);

        return response;
    }
}
