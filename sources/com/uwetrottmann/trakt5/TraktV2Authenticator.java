package com.uwetrottmann.trakt5;

import com.uwetrottmann.trakt5.entities.AccessToken;
import java.io.IOException;
import okhttp3.Authenticator;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

public class TraktV2Authenticator implements Authenticator {
    public final TraktV2 trakt;

    public TraktV2Authenticator(TraktV2 traktV2) {
        this.trakt = traktV2;
    }

    public static Request handleAuthenticate(Response response, TraktV2 traktV2) throws IOException {
        String refreshToken;
        if (traktV2.apiHost().equals(response.request().url().host()) && responseCount(response) < 2 && (refreshToken = traktV2.refreshToken()) != null && refreshToken.length() != 0) {
            retrofit2.Response<AccessToken> refreshAccessToken = traktV2.refreshAccessToken(refreshToken);
            AccessToken body = refreshAccessToken.body();
            if (refreshAccessToken.isSuccessful() && body != null) {
                String str = body.access_token;
                traktV2.accessToken(str);
                traktV2.refreshToken(body.refresh_token);
                Request.Builder newBuilder = response.request().newBuilder();
                return newBuilder.header("Authorization", "Bearer " + str).build();
            }
        }
        return null;
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
        return handleAuthenticate(response, this.trakt);
    }
}
