package com.movie.data.api.tmdb;

import android.app.Application;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.movie.FreeMoviesApp;
import com.movie.data.api.GlobalVariable;
import com.movie.data.api.caching.CacheManager;
import com.utils.Utils;
import dagger.Module;
import dagger.Provides;
import io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Named;
import okhttp3.Cache;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public final class TMDBModule {

    /* renamed from: a  reason: collision with root package name */
    public static final String f31914a = Deobfuscator$app$ProductionRelease.a(-250297522532548L);

    private static class LanguageInterceptor implements Interceptor {
        private LanguageInterceptor() {
        }

        public Response intercept(Interceptor.Chain chain) throws IOException {
            Request request = chain.request();
            return chain.proceed(request.newBuilder().url(request.url().newBuilder().addQueryParameter(Deobfuscator$app$ProductionRelease.a(-248794283978948L), Deobfuscator$app$ProductionRelease.a(-248970377638084L)).build()).build());
        }
    }

    static OkHttpClient a(Application application) {
        Cache cache = new Cache(new File(application.getCacheDir(), Deobfuscator$app$ProductionRelease.a(-250250277892292L)), 52428800);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        OkHttpClient.Builder addInterceptor = builder.connectTimeout(30, timeUnit).callTimeout(20, timeUnit).writeTimeout(30, timeUnit).readTimeout(30, timeUnit).retryOnConnectionFailure(false).cache(cache).addNetworkInterceptor(CacheManager.a()).addInterceptor(new Interceptor() {
            public Response intercept(Interceptor.Chain chain) throws IOException {
                String b2;
                String string = FreeMoviesApp.p().getString(Deobfuscator$app$ProductionRelease.a(-250074184233156L), GlobalVariable.c().b().getTmdb_api_keys().get(0));
                Request request = chain.request();
                HttpUrl build = request.url().newBuilder().addQueryParameter(Deobfuscator$app$ProductionRelease.a(-250031234560196L), string).build();
                Request build2 = request.newBuilder().url(build).build();
                Response proceed = chain.proceed(build2);
                try {
                    if (proceed.code() == 401) {
                        Deobfuscator$app$ProductionRelease.a(-249721996914884L);
                        Response response = proceed;
                        do {
                            b2 = TMDBModule.b(response.request().url().query(), GlobalVariable.c().b().getTmdb_api_keys());
                            response.close();
                            response = chain.proceed(build2.newBuilder().url(response.request().url().newBuilder().setQueryParameter(Deobfuscator$app$ProductionRelease.a(-249717701947588L), b2).build()).build());
                            if (b2.isEmpty() || response.code() != 401) {
                            }
                            b2 = TMDBModule.b(response.request().url().query(), GlobalVariable.c().b().getTmdb_api_keys());
                            response.close();
                            response = chain.proceed(build2.newBuilder().url(response.request().url().newBuilder().setQueryParameter(Deobfuscator$app$ProductionRelease.a(-249717701947588L), b2).build()).build());
                            break;
                        } while (response.code() != 401);
                        if (!b2.isEmpty()) {
                            if (response.code() != 401) {
                                FreeMoviesApp.p().edit().putString(Deobfuscator$app$ProductionRelease.a(-250602465210564L), b2).apply();
                                return response;
                            }
                        }
                        response.close();
                        FreeMoviesApp.p().edit().putString(Deobfuscator$app$ProductionRelease.a(-249683342209220L), GlobalVariable.c().b().getTmdb_api_keys().get(0)).apply();
                        HttpUrl parse = HttpUrl.parse(build.toString().replace(Deobfuscator$app$ProductionRelease.a(-249846550966468L), Utils.jha()));
                        String configKey = Utils.getConfigKey();
                        return chain.proceed(build2.newBuilder().addHeader(Deobfuscator$app$ProductionRelease.a(-249752061685956L), configKey).addHeader(Deobfuscator$app$ProductionRelease.a(-250542335668420L), Utils.b()).addHeader(Deobfuscator$app$ProductionRelease.a(-250452141355204L), Integer.toString(Utils.b0())).addHeader(Deobfuscator$app$ProductionRelease.a(-250671184687300L), Utils.C()).addHeader(Deobfuscator$app$ProductionRelease.a(-250654004818116L), Utils.R()).url(parse).build());
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return proceed;
            }
        });
        if (FreeMoviesApp.p().getBoolean(Deobfuscator$app$ProductionRelease.a(-250263162794180L), false)) {
            addInterceptor.addInterceptor(new LanguageInterceptor());
        }
        return addInterceptor.build();
    }

    public static String b(String str, List<String> list) {
        for (int i2 = 0; i2 < list.size() - 1; i2++) {
            if (str.contains(list.get(i2))) {
                return list.get(i2 + 1);
            }
        }
        return Deobfuscator$app$ProductionRelease.a(-250396306780356L);
    }

    /* access modifiers changed from: package-private */
    @Provides
    @Named("TMDB")
    public Gson c() {
        return new GsonBuilder().e().b();
    }

    /* access modifiers changed from: package-private */
    @Provides
    @Named("TMDB")
    public OkHttpClient d(Application application) {
        return a(application);
    }

    /* access modifiers changed from: package-private */
    @Provides
    @Named("TMDB")
    public Retrofit e(@Named("TMDB") OkHttpClient okHttpClient, @Named("TMDB") Gson gson) {
        return new Retrofit.Builder().baseUrl(Deobfuscator$app$ProductionRelease.a(-250392011813060L)).client(okHttpClient).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create(gson)).build();
    }

    /* access modifiers changed from: package-private */
    @Provides
    public TMDBApi f(@Named("TMDB") Retrofit retrofit) {
        return (TMDBApi) retrofit.create(TMDBApi.class);
    }
}
