package com.uwetrottmann.thetvdb;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class TheTvdbInterceptor implements Interceptor {
    private TheTvdb theTvdb;

    public TheTvdbInterceptor(TheTvdb theTvdb2) {
        this.theTvdb = theTvdb2;
    }

    public static Response handleIntercept(Interceptor.Chain chain, String str) throws IOException {
        Request request = chain.request();
        if (!TheTvdb.API_HOST.equals(request.url().host())) {
            return chain.proceed(request);
        }
        Request.Builder newBuilder = request.newBuilder();
        newBuilder.header(TheTvdb.HEADER_ACCEPT, "application/vnd.thetvdb.v2.2.0");
        if (hasNoAuthorizationHeader(request) && jsonWebTokenIsNotEmpty(str)) {
            newBuilder.header("Authorization", "Bearer " + str);
        }
        return chain.proceed(newBuilder.build());
    }

    private static boolean hasNoAuthorizationHeader(Request request) {
        if (request.header("Authorization") == null) {
            return true;
        }
        return false;
    }

    private static boolean jsonWebTokenIsNotEmpty(String str) {
        return (str == null || str.length() == 0) ? false : true;
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        return handleIntercept(chain, jsonWebToken());
    }

    public String jsonWebToken() {
        return this.theTvdb.jsonWebToken();
    }
}
