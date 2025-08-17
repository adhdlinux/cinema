package com.movie.data.api.imdb;

import android.app.Application;
import com.facebook.common.util.UriUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.movie.data.api.GlobalVariable;
import com.movie.data.api.caching.CacheManager;
import dagger.Module;
import dagger.Provides;
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

@Module
public class IMDBModule {
    static OkHttpClient a(Application application) {
        Cache cache = new Cache(new File(application.getCacheDir(), UriUtil.HTTP_SCHEME), 52428800);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return builder.connectTimeout(10, timeUnit).writeTimeout(10, timeUnit).readTimeout(30, timeUnit).cache(cache).addNetworkInterceptor(CacheManager.a()).addInterceptor(new Interceptor() {
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request request = chain.request();
                return chain.proceed(request.newBuilder().url(request.url().newBuilder().addQueryParameter("api_key", GlobalVariable.c().b().getTmdb_api_keys().get(0)).build()).build());
            }
        }).build();
    }

    /* access modifiers changed from: package-private */
    @Provides
    @Named("IMDBM")
    public Gson b() {
        return new GsonBuilder().e().b();
    }

    /* access modifiers changed from: package-private */
    @Provides
    public IMDBApi c(@Named("IMDBM") Retrofit retrofit) {
        return (IMDBApi) retrofit.create(IMDBApi.class);
    }

    /* access modifiers changed from: package-private */
    @Provides
    @Named("IMDBM")
    public OkHttpClient d(Application application) {
        return a(application);
    }

    /* access modifiers changed from: package-private */
    @Provides
    @Named("IMDBM")
    public Retrofit e(@Named("IMDBM") OkHttpClient okHttpClient, @Named("IMDBM") Gson gson) {
        return new Retrofit.Builder().baseUrl("https://www.imdb.com/").client(okHttpClient).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create(gson)).build();
    }
}
