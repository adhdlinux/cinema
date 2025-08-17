package com.movie.data.api.caching;

import com.original.tase.utils.NetworkUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Response;

public class CacheManager {
    public static Interceptor a() {
        return new Interceptor() {
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Response proceed = chain.proceed(chain.request());
                if (NetworkUtils.a()) {
                    return proceed.newBuilder().header("Cache-Control", new CacheControl.Builder().noCache().build().toString()).build();
                }
                return proceed.newBuilder().header("Cache-Control", new CacheControl.Builder().maxAge(12, TimeUnit.HOURS).build().toString()).build();
            }
        };
    }
}
