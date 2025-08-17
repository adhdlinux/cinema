package com.original.tase.helper.http.interceptor;

import com.facebook.common.util.UriUtil;
import com.original.tase.Logger;
import com.original.tase.helper.http.HttpHelper;
import java.io.IOException;
import java.util.Map;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class PostRedirectInterceptor implements Interceptor {
    public Response intercept(Interceptor.Chain chain) throws IOException {
        HttpUrl httpUrl;
        Request request = chain.request();
        Response proceed = chain.proceed(request);
        try {
            int code = proceed.code();
            if (!request.method().equalsIgnoreCase("POST")) {
                return proceed;
            }
            if (code != 301 && code != 302 && code != 307 && code != 308) {
                return proceed;
            }
            String v2 = HttpHelper.i().v(proceed, request.url().toString(), false, false, (Map<String, String>) null);
            if (v2.startsWith(UriUtil.HTTP_SCHEME)) {
                httpUrl = HttpUrl.parse(v2);
            } else {
                httpUrl = request.url().resolve(v2);
            }
            return chain.proceed(request.newBuilder().url(httpUrl).build());
        } catch (Throwable th) {
            Logger.d(th, new boolean[0]);
            return proceed;
        }
    }
}
