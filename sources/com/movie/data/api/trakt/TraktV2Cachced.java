package com.movie.data.api.trakt;

import com.facebook.common.util.UriUtil;
import com.movie.FreeMoviesApp;
import com.movie.data.api.caching.CacheManager;
import com.utils.Utils;
import com.uwetrottmann.trakt5.TraktV2;
import com.uwetrottmann.trakt5.TraktV2Interceptor;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;

public class TraktV2Cachced extends TraktV2 {

    /* renamed from: a  reason: collision with root package name */
    private OkHttpClient f31925a;

    private static class LanguageInterceptor implements Interceptor {
        private LanguageInterceptor() {
        }

        public Response intercept(Interceptor.Chain chain) throws IOException {
            return chain.proceed(chain.request().newBuilder().header("language", Locale.getDefault().getLanguage()).build());
        }
    }

    public TraktV2Cachced(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    public ExtendService a() {
        return (ExtendService) retrofit().create(ExtendService.class);
    }

    /* access modifiers changed from: protected */
    public synchronized OkHttpClient okHttpClient() {
        if (this.f31925a == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.addInterceptor(new TraktV2Interceptor(this));
            builder.authenticator(new TraktV2Authenticator(this));
            Cache cache = new Cache(new File(Utils.v().getCacheDir(), UriUtil.HTTP_SCHEME), 20971520);
            TimeUnit timeUnit = TimeUnit.SECONDS;
            builder.connectTimeout(10, timeUnit).writeTimeout(10, timeUnit).readTimeout(30, timeUnit).cache(cache).addNetworkInterceptor(CacheManager.a());
            if (FreeMoviesApp.p().getBoolean("pref_disable_non_english", false)) {
                builder.addInterceptor(new LanguageInterceptor());
            }
            this.f31925a = builder.build();
        }
        return this.f31925a;
    }
}
