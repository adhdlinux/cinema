package com.original.tase.helper.http.interceptor;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;

public class RemoveHeadersInterceptor implements Interceptor {
    public Response intercept(Interceptor.Chain chain) throws IOException {
        return chain.proceed(chain.request().newBuilder().removeHeader("X-Request-CC").build());
    }
}
