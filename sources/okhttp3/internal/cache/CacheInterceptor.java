package okhttp3.internal.cache;

import com.uwetrottmann.trakt5.TraktV2;
import java.io.Closeable;
import java.io.IOException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.RealResponseBody;
import okio.Okio;
import okio.Sink;

public final class CacheInterceptor implements Interceptor {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Cache cache;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final Headers combine(Headers headers, Headers headers2) {
            Headers.Builder builder = new Headers.Builder();
            int size = headers.size();
            for (int i2 = 0; i2 < size; i2++) {
                String name = headers.name(i2);
                String value = headers.value(i2);
                if ((!StringsKt__StringsJVMKt.t("Warning", name, true) || !StringsKt__StringsJVMKt.G(value, "1", false, 2, (Object) null)) && (isContentSpecificHeader(name) || !isEndToEnd(name) || headers2.get(name) == null)) {
                    builder.addLenient$okhttp(name, value);
                }
            }
            int size2 = headers2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                String name2 = headers2.name(i3);
                if (!isContentSpecificHeader(name2) && isEndToEnd(name2)) {
                    builder.addLenient$okhttp(name2, headers2.value(i3));
                }
            }
            return builder.build();
        }

        private final boolean isContentSpecificHeader(String str) {
            if (StringsKt__StringsJVMKt.t("Content-Length", str, true) || StringsKt__StringsJVMKt.t("Content-Encoding", str, true) || StringsKt__StringsJVMKt.t(TraktV2.HEADER_CONTENT_TYPE, str, true)) {
                return true;
            }
            return false;
        }

        private final boolean isEndToEnd(String str) {
            if (StringsKt__StringsJVMKt.t("Connection", str, true) || StringsKt__StringsJVMKt.t("Keep-Alive", str, true) || StringsKt__StringsJVMKt.t("Proxy-Authenticate", str, true) || StringsKt__StringsJVMKt.t("Proxy-Authorization", str, true) || StringsKt__StringsJVMKt.t("TE", str, true) || StringsKt__StringsJVMKt.t("Trailers", str, true) || StringsKt__StringsJVMKt.t("Transfer-Encoding", str, true) || StringsKt__StringsJVMKt.t("Upgrade", str, true)) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: private */
        public final Response stripBody(Response response) {
            ResponseBody responseBody;
            if (response != null) {
                responseBody = response.body();
            } else {
                responseBody = null;
            }
            if (responseBody != null) {
                return response.newBuilder().body((ResponseBody) null).build();
            }
            return response;
        }
    }

    public CacheInterceptor(Cache cache2) {
        this.cache = cache2;
    }

    private final Response cacheWritingResponse(CacheRequest cacheRequest, Response response) throws IOException {
        if (cacheRequest == null) {
            return response;
        }
        Sink body = cacheRequest.body();
        ResponseBody body2 = response.body();
        Intrinsics.c(body2);
        CacheInterceptor$cacheWritingResponse$cacheWritingSource$1 cacheInterceptor$cacheWritingResponse$cacheWritingSource$1 = new CacheInterceptor$cacheWritingResponse$cacheWritingSource$1(body2.source(), cacheRequest, Okio.c(body));
        return response.newBuilder().body(new RealResponseBody(Response.header$default(response, TraktV2.HEADER_CONTENT_TYPE, (String) null, 2, (Object) null), response.body().contentLength(), Okio.d(cacheInterceptor$cacheWritingResponse$cacheWritingSource$1))).build();
    }

    public final Cache getCache$okhttp() {
        return this.cache;
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        Response response;
        EventListener eventListener;
        ResponseBody body;
        ResponseBody body2;
        Intrinsics.f(chain, "chain");
        Call call = chain.call();
        Cache cache2 = this.cache;
        RealCall realCall = null;
        if (cache2 != null) {
            response = cache2.get$okhttp(chain.request());
        } else {
            response = null;
        }
        CacheStrategy compute = new CacheStrategy.Factory(System.currentTimeMillis(), chain.request(), response).compute();
        Request networkRequest = compute.getNetworkRequest();
        Response cacheResponse = compute.getCacheResponse();
        Cache cache3 = this.cache;
        if (cache3 != null) {
            cache3.trackResponse$okhttp(compute);
        }
        if (call instanceof RealCall) {
            realCall = (RealCall) call;
        }
        if (realCall == null || (eventListener = realCall.getEventListener$okhttp()) == null) {
            eventListener = EventListener.NONE;
        }
        if (!(response == null || cacheResponse != null || (body2 = response.body()) == null)) {
            Util.closeQuietly((Closeable) body2);
        }
        if (networkRequest == null && cacheResponse == null) {
            Response build = new Response.Builder().request(chain.request()).protocol(Protocol.HTTP_1_1).code(504).message("Unsatisfiable Request (only-if-cached)").body(Util.EMPTY_RESPONSE).sentRequestAtMillis(-1).receivedResponseAtMillis(System.currentTimeMillis()).build();
            eventListener.satisfactionFailure(call, build);
            return build;
        } else if (networkRequest == null) {
            Intrinsics.c(cacheResponse);
            Response build2 = cacheResponse.newBuilder().cacheResponse(Companion.stripBody(cacheResponse)).build();
            eventListener.cacheHit(call, build2);
            return build2;
        } else {
            if (cacheResponse != null) {
                eventListener.cacheConditionalHit(call, cacheResponse);
            } else if (this.cache != null) {
                eventListener.cacheMiss(call);
            }
            try {
                Response proceed = chain.proceed(networkRequest);
                if (!(proceed != null || response == null || body == null)) {
                }
                if (cacheResponse != null) {
                    boolean z2 = false;
                    if (proceed != null && proceed.code() == 304) {
                        z2 = true;
                    }
                    if (z2) {
                        Response.Builder newBuilder = cacheResponse.newBuilder();
                        Companion companion = Companion;
                        Response build3 = newBuilder.headers(companion.combine(cacheResponse.headers(), proceed.headers())).sentRequestAtMillis(proceed.sentRequestAtMillis()).receivedResponseAtMillis(proceed.receivedResponseAtMillis()).cacheResponse(companion.stripBody(cacheResponse)).networkResponse(companion.stripBody(proceed)).build();
                        ResponseBody body3 = proceed.body();
                        Intrinsics.c(body3);
                        body3.close();
                        Cache cache4 = this.cache;
                        Intrinsics.c(cache4);
                        cache4.trackConditionalCacheHit$okhttp();
                        this.cache.update$okhttp(cacheResponse, build3);
                        eventListener.cacheHit(call, build3);
                        return build3;
                    }
                    ResponseBody body4 = cacheResponse.body();
                    if (body4 != null) {
                        Util.closeQuietly((Closeable) body4);
                    }
                }
                Intrinsics.c(proceed);
                Response.Builder newBuilder2 = proceed.newBuilder();
                Companion companion2 = Companion;
                Response build4 = newBuilder2.cacheResponse(companion2.stripBody(cacheResponse)).networkResponse(companion2.stripBody(proceed)).build();
                if (this.cache != null) {
                    if (HttpHeaders.promisesBody(build4) && CacheStrategy.Companion.isCacheable(build4, networkRequest)) {
                        Response cacheWritingResponse = cacheWritingResponse(this.cache.put$okhttp(build4), build4);
                        if (cacheResponse != null) {
                            eventListener.cacheMiss(call);
                        }
                        return cacheWritingResponse;
                    } else if (HttpMethod.INSTANCE.invalidatesCache(networkRequest.method())) {
                        try {
                            this.cache.remove$okhttp(networkRequest);
                        } catch (IOException unused) {
                        }
                    }
                }
                return build4;
            } finally {
                if (!(response == null || (body = response.body()) == null)) {
                    Util.closeQuietly((Closeable) body);
                }
            }
        }
    }
}
