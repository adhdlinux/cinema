package com.movie.data.api.realdebrid;

import android.app.Application;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.original.Constants;
import com.original.tase.debrid.realdebrid.RealDebridCredentialsHelper;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.debrid.realdebrid.RealDebridCredentialsInfo;
import com.original.tase.model.debrid.realdebrid.RealDebridGetTokenResult;
import com.original.tase.utils.Utils;
import dagger.Module;
import dagger.Provides;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import javax.inject.Named;
import javax.inject.Singleton;
import okhttp3.Authenticator;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RealDebridModule {
    static OkHttpClient a(Application application) {
        new Cache(new File(application.getCacheDir(), "httprd"), 52428800);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return builder.connectTimeout(30, timeUnit).writeTimeout(30, timeUnit).readTimeout(30, timeUnit).authenticator(new Authenticator() {
            public Request authenticate(Route route, Response response) throws IOException {
                String clientId = RealDebridCredentialsHelper.d().getClientId();
                String clientSecret = RealDebridCredentialsHelper.d().getClientSecret();
                String refreshToken = RealDebridCredentialsHelper.d().getRefreshToken();
                HashMap hashMap = new HashMap();
                hashMap.put("User-Agent", Constants.C);
                HttpHelper i2 = HttpHelper.i();
                String q2 = i2.q("https://api.real-debrid.com/oauth/v2/token", "client_id=" + Utils.k(clientId, new boolean[0]) + "&client_secret=" + Utils.k(clientSecret, new boolean[0]) + "&code=" + Utils.k(refreshToken, new boolean[0]) + "&grant_type=http://oauth.net/grant_type/device/1.0", false, hashMap);
                if (!q2.contains("access_token")) {
                    return null;
                }
                RealDebridGetTokenResult realDebridGetTokenResult = (RealDebridGetTokenResult) new Gson().l(q2, RealDebridGetTokenResult.class);
                RealDebridCredentialsInfo realDebridCredentialsInfo = new RealDebridCredentialsInfo();
                realDebridCredentialsInfo.setAccessToken(realDebridGetTokenResult.getAccess_token());
                realDebridCredentialsInfo.setRefreshToken(realDebridGetTokenResult.getRefresh_token());
                realDebridCredentialsInfo.setClientId(clientId);
                realDebridCredentialsInfo.setClientSecret(clientSecret);
                RealDebridCredentialsHelper.e(realDebridCredentialsInfo);
                Request.Builder newBuilder = response.request().newBuilder();
                Request.Builder header = newBuilder.header("Authorization", "Bearer " + realDebridGetTokenResult.getAccess_token());
                return header.header("User-Agent", "Bearer " + Constants.C).build();
            }
        }).addInterceptor(new Interceptor() {
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Response proceed = chain.proceed(chain.request());
                if (proceed.code() != 503) {
                    return proceed;
                }
                return chain.proceed(chain.request().newBuilder().build());
            }
        }).addInterceptor(new Interceptor() {
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request.Builder newBuilder = chain.request().newBuilder();
                Request.Builder addHeader = newBuilder.addHeader("Authorization", "Bearer " + RealDebridCredentialsHelper.d().getAccessToken());
                return chain.proceed(addHeader.addHeader("User-Agent", "Bearer " + Constants.C).build());
            }
        }).build();
    }

    /* access modifiers changed from: package-private */
    @Provides
    @Named("RealDebrid")
    public Gson b() {
        return new GsonBuilder().e().b();
    }

    /* access modifiers changed from: package-private */
    @Named("RealDebrid")
    @Singleton
    @Provides
    public OkHttpClient c(Application application) {
        return a(application);
    }

    /* access modifiers changed from: package-private */
    @Provides
    public RealDebridApi d(@Named("RealDebrid") Retrofit retrofit) {
        return (RealDebridApi) retrofit.create(RealDebridApi.class);
    }

    /* access modifiers changed from: package-private */
    @Named("RealDebrid")
    @Singleton
    @Provides
    public Retrofit e(@Named("RealDebrid") OkHttpClient okHttpClient, @Named("RealDebrid") Gson gson) {
        return new Retrofit.Builder().baseUrl("https://api.real-debrid.com/").client(okHttpClient).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create(gson)).build();
    }
}
