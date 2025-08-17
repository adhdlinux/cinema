package com.movie.data.api.alldebrid;

import com.original.tase.debrid.alldebrid.AllDebridCredentialsHelper;
import com.utils.Utils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class AllDebridModule {

    /* renamed from: a  reason: collision with root package name */
    private static Retrofit f31904a;

    /* renamed from: b  reason: collision with root package name */
    private static AllDebridApi f31905b;

    static OkHttpClient a() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return builder.connectTimeout(10, timeUnit).writeTimeout(10, timeUnit).readTimeout(30, timeUnit).addInterceptor(new Interceptor() {
            public Response intercept(Interceptor.Chain chain) throws IOException {
                if (AllDebridCredentialsHelper.b().getApikey().isEmpty() || AllDebridCredentialsHelper.c()) {
                    return null;
                }
                Request request = chain.request();
                return chain.proceed(request.newBuilder().url(request.url().newBuilder().addQueryParameter("agent", Utils.f37622o).addQueryParameter("apikey", AllDebridCredentialsHelper.b().getApikey()).build()).build());
            }
        }).build();
    }

    public static AllDebridApi b() {
        if (f31905b == null) {
            f31905b = (AllDebridApi) c().create(AllDebridApi.class);
        }
        return f31905b;
    }

    private static Retrofit c() {
        if (f31904a == null) {
            f31904a = new Retrofit.Builder().baseUrl("https://api.alldebrid.com/").addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(a()).build();
        }
        return f31904a;
    }
}
