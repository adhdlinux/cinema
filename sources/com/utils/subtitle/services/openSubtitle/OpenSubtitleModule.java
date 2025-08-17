package com.utils.subtitle.services.openSubtitle;

import com.domain.network.api.openSubtitle.OpenSubtitleOAuthSettings;
import com.google.gson.GsonBuilder;
import dagger.Module;
import dagger.Provides;
import java.io.IOException;
import javax.inject.Singleton;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class OpenSubtitleModule {
    static final String BASE_URL = "https://api.opensubtitles.com/api/";

    /* access modifiers changed from: package-private */
    @Singleton
    @Provides
    public OpenSubtitleV1Api provideOpenSubtitleApi(OkHttpClient okHttpClient) {
        return (OpenSubtitleV1Api) new Retrofit.Builder().baseUrl(BASE_URL).client(okHttpClient.newBuilder().addInterceptor(new Interceptor() {
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request.Builder addHeader = chain.request().newBuilder().addHeader("User-Agent", "StarOneTv v1.2.3").addHeader("Api-Key", "awn58mirBRxoJiLKDzx6NWbjNHb8vKCd");
                String b2 = OpenSubtitleOAuthSettings.f19367a.b();
                if (!b2.isEmpty()) {
                    addHeader.addHeader("Authorization", "Bearer " + b2);
                }
                return chain.proceed(addHeader.build());
            }
        }).build()).addConverterFactory(GsonConverterFactory.create(new GsonBuilder().e().b())).build().create(OpenSubtitleV1Api.class);
    }
}
