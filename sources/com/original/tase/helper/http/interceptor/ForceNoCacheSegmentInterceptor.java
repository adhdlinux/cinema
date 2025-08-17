package com.original.tase.helper.http.interceptor;

import com.original.tase.Logger;
import java.io.IOException;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class ForceNoCacheSegmentInterceptor implements Interceptor {
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        try {
            if (request.url().toString().contains("##forceNoCache##")) {
                return chain.proceed(request.newBuilder().url(request.url().toString().replace("##forceNoCache##", "")).removeHeader("Pragma").removeHeader("C3-Cache-Control").removeHeader("X-Cache").removeHeader("X-Cache-Hit").removeHeader("pragma").removeHeader("c3-cache-control").removeHeader("x-cache").removeHeader("x-cache-hit").cacheControl(CacheControl.FORCE_NETWORK).build());
            }
        } catch (Throwable th) {
            Logger.d(th, new boolean[0]);
        }
        return chain.proceed(request);
    }
}
