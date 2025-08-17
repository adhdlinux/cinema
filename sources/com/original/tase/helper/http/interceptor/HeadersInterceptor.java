package com.original.tase.helper.http.interceptor;

import com.original.tase.Logger;
import com.uwetrottmann.thetvdb.TheTvdb;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class HeadersInterceptor implements Interceptor {
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder newBuilder = request.newBuilder();
        try {
            String header = request.header(TheTvdb.HEADER_ACCEPT);
            if (header == null || header.trim().isEmpty()) {
                header = request.header("accept");
            }
            if (header == null || header.trim().isEmpty()) {
                newBuilder.addHeader(TheTvdb.HEADER_ACCEPT, "*/*");
                String header2 = request.header(TheTvdb.HEADER_ACCEPT_LANGUAGE);
                if (header2 == null || header2.trim().isEmpty()) {
                    header2 = request.header("accept-language");
                }
                if (header2 != null) {
                    if (!header2.trim().isEmpty()) {
                        return chain.proceed(request);
                    }
                }
                newBuilder.addHeader(TheTvdb.HEADER_ACCEPT_LANGUAGE, "en-US;q=0.6,en;q=0.4");
                return chain.proceed(newBuilder.build());
            }
        } catch (Throwable th) {
            Logger.d(th, new boolean[0]);
        }
        try {
            request.header("accept-language");
            newBuilder.header(TheTvdb.HEADER_ACCEPT_LANGUAGE, "en-US;q=0.6,en;q=0.4");
        } catch (Throwable th2) {
            Logger.d(th2, new boolean[0]);
        }
        return chain.proceed(newBuilder.build());
    }
}
