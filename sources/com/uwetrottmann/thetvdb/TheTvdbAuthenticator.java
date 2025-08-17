package com.uwetrottmann.thetvdb;

import com.uwetrottmann.thetvdb.entities.LoginData;
import com.uwetrottmann.thetvdb.entities.Token;
import java.io.IOException;
import okhttp3.Authenticator;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

public class TheTvdbAuthenticator implements Authenticator {
    public static final String PATH_LOGIN = "/login";
    private TheTvdb theTvdb;

    public TheTvdbAuthenticator(TheTvdb theTvdb2) {
        this.theTvdb = theTvdb2;
    }

    public static Request handleRequest(Response response, TheTvdb theTvdb2) throws IOException {
        if (PATH_LOGIN.equals(response.request().url().encodedPath()) || responseCount(response) >= 2) {
            return null;
        }
        retrofit2.Response<Token> execute = theTvdb2.authentication().login(new LoginData(theTvdb2.apiKey())).execute();
        Token body = execute.body();
        if (!execute.isSuccessful() || body == null) {
            return null;
        }
        String str = body.token;
        theTvdb2.jsonWebToken(str);
        Request.Builder newBuilder = response.request().newBuilder();
        return newBuilder.header("Authorization", "Bearer " + str).build();
    }

    private static int responseCount(Response response) {
        int i2 = 1;
        while (true) {
            response = response.priorResponse();
            if (response == null) {
                return i2;
            }
            i2++;
        }
    }

    public Request authenticate(Route route, Response response) throws IOException {
        return handleRequest(response, this.theTvdb);
    }
}
