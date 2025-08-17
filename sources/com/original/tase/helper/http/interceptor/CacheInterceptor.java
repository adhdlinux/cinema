package com.original.tase.helper.http.interceptor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class CacheInterceptor implements Interceptor {
    public Response intercept(Interceptor.Chain chain) throws IOException {
        boolean z2;
        Request request = chain.request();
        ArrayList arrayList = new ArrayList();
        arrayList.add("no-store");
        arrayList.add("no-cache");
        arrayList.add("must-revalidate");
        arrayList.add("max-stale=0");
        Iterator it2 = arrayList.iterator();
        while (true) {
            if (!it2.hasNext()) {
                z2 = false;
                break;
            }
            String str = (String) it2.next();
            if (request.header("Cache-Control") != null && request.header("Cache-Control").contains(str)) {
                z2 = true;
                break;
            }
        }
        if (!z2) {
            return chain.proceed(request.newBuilder().cacheControl(new CacheControl.Builder().maxStale(1, TimeUnit.DAYS).build()).build());
        }
        return chain.proceed(request);
    }
}
