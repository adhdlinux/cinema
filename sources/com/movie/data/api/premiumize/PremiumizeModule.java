package com.movie.data.api.premiumize;

import com.original.Constants;
import com.uwetrottmann.trakt5.TraktV2;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class PremiumizeModule {

    /* renamed from: a  reason: collision with root package name */
    private static Retrofit f31906a;

    /* renamed from: b  reason: collision with root package name */
    private static PremiumizeApi f31907b;

    static OkHttpClient a() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return builder.connectTimeout(10, timeUnit).writeTimeout(10, timeUnit).readTimeout(30, timeUnit).addInterceptor(new Interceptor() {
            public Response intercept(Interceptor.Chain chain) throws IOException {
                return chain.proceed(chain.request().newBuilder().addHeader("accept", TraktV2.CONTENT_TYPE_JSON).addHeader("User-Agent", Constants.C).build());
            }
        }).build();
    }

    public static PremiumizeApi b() {
        if (f31907b == null) {
            f31907b = (PremiumizeApi) c().create(PremiumizeApi.class);
        }
        return f31907b;
    }

    private static Retrofit c() {
        if (f31906a == null) {
            f31906a = new Retrofit.Builder().baseUrl("https://www.premiumize.me").addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(a()).build();
        }
        return f31906a;
    }
}
