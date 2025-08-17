package okhttp3.internal.http;

import com.uwetrottmann.trakt5.TraktV2;
import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okio.GzipSource;
import okio.Okio;

public final class BridgeInterceptor implements Interceptor {
    private final CookieJar cookieJar;

    public BridgeInterceptor(CookieJar cookieJar2) {
        Intrinsics.f(cookieJar2, "cookieJar");
        this.cookieJar = cookieJar2;
    }

    private final String cookieHeader(List<Cookie> list) {
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        for (Object next : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.o();
            }
            Cookie cookie = (Cookie) next;
            if (i2 > 0) {
                sb.append("; ");
            }
            sb.append(cookie.name());
            sb.append('=');
            sb.append(cookie.value());
            i2 = i3;
        }
        String sb2 = sb.toString();
        Intrinsics.e(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        ResponseBody body;
        Intrinsics.f(chain, "chain");
        Request request = chain.request();
        Request.Builder newBuilder = request.newBuilder();
        RequestBody body2 = request.body();
        if (body2 != null) {
            MediaType contentType = body2.contentType();
            if (contentType != null) {
                newBuilder.header(TraktV2.HEADER_CONTENT_TYPE, contentType.toString());
            }
            long contentLength = body2.contentLength();
            if (contentLength != -1) {
                newBuilder.header("Content-Length", String.valueOf(contentLength));
                newBuilder.removeHeader("Transfer-Encoding");
            } else {
                newBuilder.header("Transfer-Encoding", "chunked");
                newBuilder.removeHeader("Content-Length");
            }
        }
        boolean z2 = false;
        if (request.header("Host") == null) {
            newBuilder.header("Host", Util.toHostHeader$default(request.url(), false, 1, (Object) null));
        }
        if (request.header("Connection") == null) {
            newBuilder.header("Connection", "Keep-Alive");
        }
        if (request.header("Accept-Encoding") == null && request.header("Range") == null) {
            newBuilder.header("Accept-Encoding", "gzip");
            z2 = true;
        }
        List<Cookie> loadForRequest = this.cookieJar.loadForRequest(request.url());
        if (!loadForRequest.isEmpty()) {
            newBuilder.header("Cookie", cookieHeader(loadForRequest));
        }
        if (request.header("User-Agent") == null) {
            newBuilder.header("User-Agent", Util.userAgent);
        }
        Response proceed = chain.proceed(newBuilder.build());
        HttpHeaders.receiveHeaders(this.cookieJar, request.url(), proceed.headers());
        Response.Builder request2 = proceed.newBuilder().request(request);
        if (z2 && StringsKt__StringsJVMKt.t("gzip", Response.header$default(proceed, "Content-Encoding", (String) null, 2, (Object) null), true) && HttpHeaders.promisesBody(proceed) && (body = proceed.body()) != null) {
            GzipSource gzipSource = new GzipSource(body.source());
            request2.headers(proceed.headers().newBuilder().removeAll("Content-Encoding").removeAll("Content-Length").build());
            request2.body(new RealResponseBody(Response.header$default(proceed, TraktV2.HEADER_CONTENT_TYPE, (String) null, 2, (Object) null), -1, Okio.d(gzipSource)));
        }
        return request2.build();
    }
}
