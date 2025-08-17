package com.movie.data.api;

import android.app.Application;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.movie.data.api.caching.CacheManager;
import com.utils.Utils;
import dagger.Module;
import dagger.Provides;
import io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.inject.Named;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

@Module
public final class ApiModule {
    static OkHttpClient a(Application application) {
        Cache cache = new Cache(new File(application.getCacheDir(), Deobfuscator$app$ProductionRelease.a(-250130018808004L)), 52428800);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return builder.connectTimeout(10, timeUnit).writeTimeout(10, timeUnit).readTimeout(30, timeUnit).cache(cache).addNetworkInterceptor(CacheManager.a()).build();
    }

    static OkHttpClient b(Application application) {
        Cache cache = new Cache(new File(application.getCacheDir(), Deobfuscator$app$ProductionRelease.a(-250117133906116L)), 52428800);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return builder.connectTimeout(10, timeUnit).writeTimeout(10, timeUnit).readTimeout(30, timeUnit).cache(cache).addNetworkInterceptor(CacheManager.a()).addInterceptor(new Interceptor() {
            public Response intercept(Interceptor.Chain chain) throws IOException {
                String configKey = Utils.getConfigKey();
                String R = Utils.R();
                Request request = chain.request();
                Request.Builder addHeader = request.newBuilder().addHeader(Deobfuscator$app$ProductionRelease.a(-251242415337668L), configKey).addHeader(Deobfuscator$app$ProductionRelease.a(-251482933506244L), Utils.b()).addHeader(Deobfuscator$app$ProductionRelease.a(-251427098931396L), Integer.toString(Utils.b0())).addHeader(Deobfuscator$app$ProductionRelease.a(-251405624094916L), Utils.C()).addHeader(Deobfuscator$app$ProductionRelease.a(-249945335214276L), R);
                if (request.headers().get(Deobfuscator$app$ProductionRelease.a(-249962515083460L)) == null) {
                    addHeader.addHeader(Deobfuscator$app$ProductionRelease.a(-249919565410500L), Utils.t());
                }
                return chain.proceed(addHeader.build());
            }
        }).build();
    }

    /* access modifiers changed from: package-private */
    @Provides
    public OkHttpClient c(Application application) {
        return a(application);
    }

    /* access modifiers changed from: package-private */
    @Provides
    public Gson d() {
        return new GsonBuilder().f().e().b();
    }

    /* access modifiers changed from: package-private */
    @Provides
    public MoviesApi e(Retrofit retrofit) {
        return (MoviesApi) retrofit.create(MoviesApi.class);
    }

    /* access modifiers changed from: package-private */
    @Provides
    @Named("ApiModule")
    public OkHttpClient f(Application application) {
        return b(application);
    }

    /* access modifiers changed from: package-private */
    @Provides
    public Retrofit g(@Named("ApiModule") OkHttpClient okHttpClient, Gson gson) {
        return new Retrofit.Builder().baseUrl(Utils.Y()).client(okHttpClient).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create(gson)).addConverterFactory(ScalarsConverterFactory.create()).build();
    }
}
