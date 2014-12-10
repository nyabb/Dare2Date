package nl.ead.webservice.services;

import nl.ead.webservice.*;
import nl.ead.webservices.models.User;
import nl.ead.webservices.models.UserStorage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

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
        spotifyService.getPlaylist(user);

        PlayListResult result = new PlayListResult();
        result.setSucces(true);

        GetPlayListResponse response = new GetPlayListResponse();
        response.setResult(result);

        return response;
    }

    @PayloadRoot(localPart = "GetFindMatchesRequest", namespace = "http://www.han.nl/schemas/messages")
    @ResponsePayload
    public GetFindMatchesResponse findMatchesForUser(@RequestPayload GetFindMatchesRequest req) {

        //TODO fill response with the right result (all matches for the given user)
        GetFindMatchesResponse response = new GetFindMatchesResponse();

        return response;
    }



    @PayloadRoot(localPart = "GetMatchRequest", namespace = "http://www.han.nl/schemas/messages")
    @ResponsePayload
    public GetMatchResponse matchUserToUser(@RequestPayload GetMatchRequest req) {

        MatchResult result = new MatchResult();
        result.setSucces(false);

        //TODO fill response with the right result did the two users match?
        GetMatchResponse response = new GetMatchResponse();
        response.setResult(result);

        return response;
    }
}
