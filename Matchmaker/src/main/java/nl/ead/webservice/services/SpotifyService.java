package nl.ead.webservice.services;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.SettableFuture;
import com.wrapper.spotify.Api;
import com.wrapper.spotify.methods.authentication.ClientCredentialsGrantRequest;
import com.wrapper.spotify.models.ClientCredentials;
import com.wrapper.spotify.models.Page;
import com.wrapper.spotify.models.PlaylistTrack;
import com.wrapper.spotify.methods.PlaylistTracksRequest;
import nl.ead.webservices.models.User;

public class SpotifyService {
    public String CLIENT_ID = "bb4f1b58db464014984939d9e9142438";
    public String CLIENT_SECRET = "156c23a5ac1d440aa7fb8e885b2c6b71";
    public String REDIRECT_URI = "http://localhost:8080";

    public Api getApi() {
        return Api.builder().clientId(CLIENT_ID).clientSecret(CLIENT_SECRET).redirectURI(REDIRECT_URI).build();
    }

    public void getPlaylist(User user) {
        Api api = this.getApi();
        setAccessToken(api);
        PlaylistTracksRequest request = api.getPlaylistTracks(user.getSpotifyUserId(), user.getSpotifyUserPlaylist()).build();

        try {
            final Page<PlaylistTrack> page = request.get();

            user.setUserPlayList(page.getItems());

        } catch (Exception e) {
            System.out.println("Something went wrong!" + e.getMessage());
        }
    }

    private void setAccessToken(final Api api) {
        ClientCredentialsGrantRequest request = api.clientCredentialsGrant().build();

        SettableFuture<ClientCredentials> responseFuture = request.getAsync();

        Futures.addCallback(responseFuture, new FutureCallback<ClientCredentials>() {
            @Override
            public void onSuccess(ClientCredentials clientCredentials) {
                System.out.println("Successfully retrieved an access token! " + clientCredentials.getAccessToken());
                System.out.println("The access token expires in " + clientCredentials.getExpiresIn() + " seconds");

                api.setAccessToken(clientCredentials.getAccessToken());
            }

            @Override
            public void onFailure(Throwable throwable) {
            }
        });
    }
}
