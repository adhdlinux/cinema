package com.uwetrottmann.thetvdb;

import com.uwetrottmann.thetvdb.services.TheTvdbAuthentication;
import com.uwetrottmann.thetvdb.services.TheTvdbEpisodes;
import com.uwetrottmann.thetvdb.services.TheTvdbLanguages;
import com.uwetrottmann.thetvdb.services.TheTvdbSearch;
import com.uwetrottmann.thetvdb.services.TheTvdbSeries;
import com.uwetrottmann.thetvdb.services.TheTvdbUpdated;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TheTvdb {
    public static final String API_HOST = "api.thetvdb.com";
    public static final String API_URL = "https://api.thetvdb.com/";
    public static final String API_VERSION = "2.2.0";
    public static final String HEADER_ACCEPT = "Accept";
    public static final String HEADER_ACCEPT_LANGUAGE = "Accept-Language";
    public static final String HEADER_AUTHORIZATION = "Authorization";
    private String apiKey;
    private String currentJsonWebToken;
    private OkHttpClient okHttpClient;
    private Retrofit retrofit;

    public TheTvdb(String str) {
        this.apiKey = str;
    }

    public String apiKey() {
        return this.apiKey;
    }

    public TheTvdbAuthentication authentication() {
        return (TheTvdbAuthentication) getRetrofit().create(TheTvdbAuthentication.class);
    }

    public TheTvdbEpisodes episodes() {
        return (TheTvdbEpisodes) getRetrofit().create(TheTvdbEpisodes.class);
    }

    /* access modifiers changed from: protected */
    public Retrofit getRetrofit() {
        if (this.retrofit == null) {
            this.retrofit = retrofitBuilder().build();
        }
        return this.retrofit;
    }

    public String jsonWebToken() {
        return this.currentJsonWebToken;
    }

    public TheTvdbLanguages languages() {
        return (TheTvdbLanguages) getRetrofit().create(TheTvdbLanguages.class);
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

    /* access modifiers changed from: protected */
    public Retrofit.Builder retrofitBuilder() {
        return new Retrofit.Builder().baseUrl(API_URL).addConverterFactory(GsonConverterFactory.create()).client(okHttpClient());
    }

    public TheTvdbSearch search() {
        return (TheTvdbSearch) getRetrofit().create(TheTvdbSearch.class);
    }

    public TheTvdbSeries series() {
        return (TheTvdbSeries) getRetrofit().create(TheTvdbSeries.class);
    }

    /* access modifiers changed from: protected */
    public void setOkHttpClientDefaults(OkHttpClient.Builder builder) {
        builder.addNetworkInterceptor(new TheTvdbInterceptor(this)).authenticator(new TheTvdbAuthenticator(this));
    }

    public TheTvdbUpdated updated() {
        return (TheTvdbUpdated) getRetrofit().create(TheTvdbUpdated.class);
    }

    public void apiKey(String str) {
        this.apiKey = str;
    }

    public void jsonWebToken(String str) {
        this.currentJsonWebToken = str;
    }
}
