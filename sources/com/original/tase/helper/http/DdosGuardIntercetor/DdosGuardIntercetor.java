package com.original.tase.helper.http.DdosGuardIntercetor;

import com.original.tase.Logger;
import java.io.IOException;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Response;

public class DdosGuardIntercetor implements Interceptor {
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Response proceed = chain.proceed(chain.request());
        if (proceed.code() != 403 || proceed.header("Server") == null || !proceed.header("Server").toLowerCase().contains("ddos-guard")) {
            return proceed;
        }
        try {
            return chain.proceed(DdosGuardHelper.a(proceed));
        } catch (InterruptedException e2) {
            Logger.d(e2, new boolean[0]);
            return chain.proceed(proceed.request().newBuilder().cacheControl(CacheControl.FORCE_NETWORK).build());
        } catch (IOException e3) {
            Logger.d(e3, new boolean[0]);
            return chain.proceed(proceed.request().newBuilder().cacheControl(CacheControl.FORCE_NETWORK).build());
        } catch (DdosGuardException e4) {
            Logger.d(e4, new boolean[0]);
            return chain.proceed(proceed.request().newBuilder().cacheControl(CacheControl.FORCE_NETWORK).build());
        }
    }
}
