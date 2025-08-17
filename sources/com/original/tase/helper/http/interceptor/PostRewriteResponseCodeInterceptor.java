package com.original.tase.helper.http.interceptor;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class PostRewriteResponseCodeInterceptor implements Interceptor {
    public Response intercept(Interceptor.Chain chain) throws IOException {
        int i2;
        Request request = chain.request();
        if (!request.method().equalsIgnoreCase("POST")) {
            return chain.proceed(request);
        }
        Response proceed = chain.proceed(request);
        if (proceed.code() != 301 && proceed.code() != 302) {
            return proceed;
        }
        Response.Builder newBuilder = proceed.newBuilder();
        if (proceed.code() == 301) {
            i2 = 308;
        } else {
            i2 = 307;
        }
        return newBuilder.code(i2).build();
    }
}
