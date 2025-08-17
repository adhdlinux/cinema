package com.uwetrottmann.trakt5;

import com.uwetrottmann.trakt5.entities.AccessToken;
import com.uwetrottmann.trakt5.entities.AccessTokenRefreshRequest;
import com.uwetrottmann.trakt5.entities.AccessTokenRequest;
import com.uwetrottmann.trakt5.entities.CheckinError;
import com.uwetrottmann.trakt5.entities.ClientId;
import com.uwetrottmann.trakt5.entities.DeviceCode;
import com.uwetrottmann.trakt5.entities.DeviceCodeAccessTokenRequest;
import com.uwetrottmann.trakt5.entities.TraktError;
import com.uwetrottmann.trakt5.entities.TraktOAuthError;
import com.uwetrottmann.trakt5.services.Authentication;
import com.uwetrottmann.trakt5.services.Calendars;
import com.uwetrottmann.trakt5.services.Checkin;
import com.uwetrottmann.trakt5.services.Comments;
import com.uwetrottmann.trakt5.services.Episodes;
import com.uwetrottmann.trakt5.services.Genres;
import com.uwetrottmann.trakt5.services.Movies;
import com.uwetrottmann.trakt5.services.People;
import com.uwetrottmann.trakt5.services.Recommendations;
import com.uwetrottmann.trakt5.services.Scrobble;
import com.uwetrottmann.trakt5.services.Search;
import com.uwetrottmann.trakt5.services.Seasons;
import com.uwetrottmann.trakt5.services.Shows;
import com.uwetrottmann.trakt5.services.Sync;
import com.uwetrottmann.trakt5.services.Users;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Annotation;
import java.net.URLEncoder;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TraktV2 {
    public static final String API_HOST = "api.trakt.tv";
    public static final String API_STAGING_HOST = "api-staging.trakt.tv";
    public static final String API_STAGING_URL = "https://api-staging.trakt.tv/";
    public static final String API_URL = "https://api.trakt.tv/";
    public static final String API_VERSION = "2";
    public static final String CONTENT_TYPE_JSON = "application/json";
    public static final String HEADER_AUTHORIZATION = "Authorization";
    public static final String HEADER_CONTENT_TYPE = "Content-Type";
    public static final String HEADER_TRAKT_API_KEY = "trakt-api-key";
    public static final String HEADER_TRAKT_API_VERSION = "trakt-api-version";
    public static final String OAUTH2_AUTHORIZATION_URL = "https://trakt.tv/oauth/authorize";
    public static final String SITE_URL = "https://trakt.tv";
    private String accessToken;
    private final HttpUrl apiBaseUrl;
    private String apiKey;
    private String clientSecret;
    private OkHttpClient okHttpClient;
    private String redirectUri;
    private String refreshToken;
    private Retrofit retrofit;

    public TraktV2(String str) {
        this(str, false);
    }

    private String urlEncode(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            throw new UnsupportedOperationException(e2);
        }
    }

    public String accessToken() {
        return this.accessToken;
    }

    public String apiHost() {
        return this.apiBaseUrl.host();
    }

    public String apiKey() {
        return this.apiKey;
    }

    public Authentication authentication() {
        return (Authentication) retrofit().create(Authentication.class);
    }

    public String buildAuthorizationUrl(String str) {
        if (this.redirectUri != null) {
            return OAUTH2_AUTHORIZATION_URL + "?" + "response_type=code" + "&" + "redirect_uri=" + urlEncode(this.redirectUri) + "&" + "state=" + urlEncode(str) + "&" + "client_id=" + urlEncode(apiKey());
        }
        throw new IllegalStateException("redirectUri not provided");
    }

    public Calendars calendars() {
        return (Calendars) retrofit().create(Calendars.class);
    }

    public CheckinError checkForCheckinError(Response<?> response) {
        if (response.code() != 409) {
            return null;
        }
        try {
            return retrofit().responseBodyConverter(CheckinError.class, new Annotation[0]).convert(response.errorBody());
        } catch (IOException unused) {
            return new CheckinError();
        }
    }

    public TraktError checkForTraktError(Response<?> response) {
        if (response.isSuccessful()) {
            return null;
        }
        try {
            return retrofit().responseBodyConverter(TraktError.class, new Annotation[0]).convert(response.errorBody());
        } catch (IOException unused) {
            return new TraktError();
        }
    }

    public TraktOAuthError checkForTraktOAuthError(Response<?> response) {
        if (response.isSuccessful()) {
            return null;
        }
        Converter<ResponseBody, TraktOAuthError> responseBodyConverter = retrofit().responseBodyConverter(TraktOAuthError.class, new Annotation[0]);
        if (response.errorBody() != null) {
            try {
                return responseBodyConverter.convert(response.errorBody());
            } catch (IOException unused) {
            }
        }
        return new TraktOAuthError();
    }

    public Checkin checkin() {
        return (Checkin) retrofit().create(Checkin.class);
    }

    public Comments comments() {
        return (Comments) retrofit().create(Comments.class);
    }

    public Episodes episodes() {
        return (Episodes) retrofit().create(Episodes.class);
    }

    public Response<AccessToken> exchangeCodeForAccessToken(String str) throws IOException {
        if (this.clientSecret == null) {
            throw new IllegalStateException("clientSecret not provided");
        } else if (this.redirectUri != null) {
            return authentication().exchangeCodeForAccessToken(new AccessTokenRequest(str, apiKey(), this.clientSecret, this.redirectUri)).execute();
        } else {
            throw new IllegalStateException("redirectUri not provided");
        }
    }

    public Response<AccessToken> exchangeDeviceCodeForAccessToken(String str) throws IOException {
        if (this.clientSecret != null) {
            DeviceCodeAccessTokenRequest deviceCodeAccessTokenRequest = new DeviceCodeAccessTokenRequest();
            deviceCodeAccessTokenRequest.client_id = this.apiKey;
            deviceCodeAccessTokenRequest.client_secret = this.clientSecret;
            deviceCodeAccessTokenRequest.code = str;
            return authentication().exchangeDeviceCodeForAccessToken(deviceCodeAccessTokenRequest).execute();
        }
        throw new IllegalStateException("clientSecret not provided");
    }

    public Response<DeviceCode> generateDeviceCode() throws IOException {
        ClientId clientId = new ClientId();
        clientId.client_id = this.apiKey;
        return authentication().generateDeviceCode(clientId).execute();
    }

    public Genres genres() {
        return (Genres) retrofit().create(Genres.class);
    }

    public Movies movies() {
        return (Movies) retrofit().create(Movies.class);
    }

    /* access modifiers changed from: protected */
    public synchronized OkHttpClient okHttpClient() {
        if (this.okHttpClient == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            setOkHttpClientDefaults(builder);
            this.okHttpClient = builder.build();
        }
        return this.okHttpClient;
    }

    public People people() {
        return (People) retrofit().create(People.class);
    }

    public Recommendations recommendations() {
        return (Recommendations) retrofit().create(Recommendations.class);
    }

    public Response<AccessToken> refreshAccessToken(String str) throws IOException {
        if (this.clientSecret == null) {
            throw new IllegalStateException("clientSecret not provided");
        } else if (this.redirectUri != null) {
            return authentication().refreshAccessToken(new AccessTokenRefreshRequest(str, apiKey(), this.clientSecret, this.redirectUri)).execute();
        } else {
            throw new IllegalStateException("redirectUri not provided");
        }
    }

    public String refreshToken() {
        return this.refreshToken;
    }

    /* access modifiers changed from: protected */
    public Retrofit retrofit() {
        if (this.retrofit == null) {
            this.retrofit = retrofitBuilder().build();
        }
        return this.retrofit;
    }

    /* access modifiers changed from: protected */
    public Retrofit.Builder retrofitBuilder() {
        return new Retrofit.Builder().baseUrl(this.apiBaseUrl).addConverterFactory(GsonConverterFactory.create(TraktV2Helper.getGsonBuilder().b())).client(okHttpClient());
    }

    public Scrobble scrobble() {
        return (Scrobble) retrofit().create(Scrobble.class);
    }

    public Search search() {
        return (Search) retrofit().create(Search.class);
    }

    public Seasons seasons() {
        return (Seasons) retrofit().create(Seasons.class);
    }

    /* access modifiers changed from: protected */
    public void setOkHttpClientDefaults(OkHttpClient.Builder builder) {
        builder.addInterceptor(new TraktV2Interceptor(this));
        builder.authenticator(new TraktV2Authenticator(this));
    }

    public Shows shows() {
        return (Shows) retrofit().create(Shows.class);
    }

    public Sync sync() {
        return (Sync) retrofit().create(Sync.class);
    }

    public Users users() {
        return (Users) retrofit().create(Users.class);
    }

    public TraktV2(String str, String str2, String str3) {
        this(str, str2, str3, false);
    }

    public TraktV2 accessToken(String str) {
        this.accessToken = str;
        return this;
    }

    public TraktV2 apiKey(String str) {
        this.apiKey = str;
        return this;
    }

    public TraktV2 refreshToken(String str) {
        this.refreshToken = str;
        return this;
    }

    public TraktV2(String str, boolean z2) {
        this.apiKey = str;
        this.apiBaseUrl = HttpUrl.get(z2 ? API_STAGING_URL : API_URL);
    }

    public TraktV2(String str, String str2, String str3, boolean z2) {
        this(str, z2);
        this.clientSecret = str2;
        this.redirectUri = str3;
    }
}
