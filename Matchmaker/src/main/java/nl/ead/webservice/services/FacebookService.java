package nl.ead.webservice.services;

import java.lang.*;
import java.util.ArrayList;
import facebook4j.*;
import facebook4j.Facebook;
import facebook4j.FacebookFactory;

public class FacebookService {
    static String APP_ID = "1595093644057953";
    static String APP_SECRET = "7af78682c8cb476ff1813695fefe75c7";

    public Facebook getApi() {
        Facebook facebook = new FacebookFactory().getInstance();
        facebook.setOAuthAppId(APP_ID, APP_ID);
        try {
            facebook.setOAuthAppId(APP_SECRET, APP_ID);
//            throw ("should throw IllegalStateException");
        } catch (IllegalStateException ignore) {}

        facebook.getAuthorization();

        return facebook;
    }

    public String getRelationshipData(nl.ead.webservices.models.User user)
    {
        String relStatus = null;
        Facebook facebook = this.getApi();
        try {
            User facebookuser = facebook.getUser(user.getFacebookUserId());
            relStatus = facebookuser.getRelationshipStatus();
        } catch (FacebookException ignore) {}

        return relStatus;
    }
}
