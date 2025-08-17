package com.movie.data.api.tvmaze;

import android.app.Application;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.movie.data.api.caching.CacheManager;
import dagger.Module;
import dagger.Provides;
import io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease;
import java.io.File;
import java.util.concurrent.TimeUnit;
import javax.inject.Named;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public final class TVMazeModule {
    static OkHttpClient a(Application application) {
        Cache cache = new Cache(new File(application.getCacheDir(), Deobfuscator$app$ProductionRelease.a(-247759196860612L)), 52428800);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return builder.connectTimeout(10, timeUnit).writeTimeout(10, timeUnit).readTimeout(30, timeUnit).cache(cache).addNetworkInterceptor(CacheManager.a()).build();
    }

    /* access modifiers changed from: package-private */
    @Provides
    @Named("TVMaze")
    public Gson b() {
        return new GsonBuilder().e().b();
    }

    /* access modifiers changed from: package-private */
    @Provides
    @Named("TVMaze")
    public OkHttpClient c(Application application) {
        return a(application);
    }

    /* access modifiers changed from: package-private */
    @Provides
    @Named("TVMaze")
    public Retrofit d(@Named("TVMaze") OkHttpClient okHttpClient, @Named("TVMaze") Gson gson) {
        return new Retrofit.Builder().baseUrl(Deobfuscator$app$ProductionRelease.a(-247703362285764L)).client(okHttpClient).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create(gson)).build();
    }

    /* access modifiers changed from: package-private */
    @Provides
    public TVMazeApi e(@Named("TVMaze") Retrofit retrofit) {
        return (TVMazeApi) retrofit.create(TVMazeApi.class);
    }
}
