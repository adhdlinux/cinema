package com.movie.data.api.trakt;

import com.original.tase.helper.trakt.TraktCredentialsHelper;
import com.original.tase.model.trakt.TraktCredentialsInfo;
import com.uwetrottmann.trakt5.TraktV2;
import com.uwetrottmann.trakt5.entities.AccessToken;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Authenticator;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

public final class TraktV2Authenticator implements Authenticator {

    /* renamed from: b  reason: collision with root package name */
    public static final Companion f31923b = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final TraktV2 f31924a;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final int b(Response response) {
            int i2 = 1;
            for (Response priorResponse = response.priorResponse(); priorResponse != null; priorResponse = priorResponse.priorResponse()) {
                i2++;
            }
            return i2;
        }

        public final Request a(Response response, TraktV2 traktV2) {
            String refreshToken;
            Intrinsics.f(response, "response");
            Intrinsics.f(traktV2, "trakt");
            if (!Intrinsics.a(traktV2.apiHost(), response.request().url().host()) || b(response) >= 2 || (refreshToken = traktV2.refreshToken()) == null) {
                return null;
            }
            retrofit2.Response<AccessToken> refreshAccessToken = traktV2.refreshAccessToken(refreshToken);
            Intrinsics.e(refreshAccessToken, "refreshAccessToken(...)");
            AccessToken body = refreshAccessToken.body();
            if (!refreshAccessToken.isSuccessful() || body == null) {
                return null;
            }
            String str = body.access_token;
            traktV2.accessToken(str);
            traktV2.refreshToken(body.refresh_token);
            TraktCredentialsHelper.c(new TraktCredentialsInfo(TraktCredentialsHelper.b().getUserName(), str, body.access_token));
            Request.Builder newBuilder = response.request().newBuilder();
            return newBuilder.header("Authorization", "Bearer " + str).build();
        }
    }

    public TraktV2Authenticator(TraktV2 traktV2) {
        Intrinsics.f(traktV2, "trakt");
        this.f31924a = traktV2;
    }

    public Request authenticate(Route route, Response response) {
        Intrinsics.f(response, "response");
        return f31923b.a(response, this.f31924a);
    }
}
