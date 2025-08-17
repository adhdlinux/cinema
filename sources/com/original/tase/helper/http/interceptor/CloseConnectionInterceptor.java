package com.original.tase.helper.http.interceptor;

import com.original.tase.Logger;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class CloseConnectionInterceptor implements Interceptor {
    public Response intercept(Interceptor.Chain chain) throws IOException {
        boolean z2;
        Request request = chain.request();
        String header = request.header("X-Request-CC");
        if (header == null || header.isEmpty() || !header.equalsIgnoreCase("true")) {
            z2 = false;
        } else {
            z2 = true;
        }
        Response proceed = chain.proceed(request.newBuilder().removeHeader("X-Request-CC").build());
        if (z2) {
            try {
                return proceed.newBuilder().removeHeader("X-Request-CC").addHeader("Connection", MRAIDPresenter.CLOSE).build();
            } catch (Throwable th) {
                Logger.d(th, new boolean[0]);
                return proceed;
            }
        } else {
            try {
                return proceed.newBuilder().removeHeader("X-Request-CC").build();
            } catch (Throwable th2) {
                Logger.d(th2, new boolean[0]);
                return proceed;
            }
        }
    }
}
