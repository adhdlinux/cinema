package okhttp3.internal;

import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.vungle.ads.internal.ui.AdActivity;
import javax.net.ssl.SSLSocket;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Cache;
import okhttp3.ConnectionSpec;
import okhttp3.Cookie;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;

public final class Internal {
    public static final Headers.Builder addHeaderLenient(Headers.Builder builder, String str) {
        Intrinsics.f(builder, "builder");
        Intrinsics.f(str, "line");
        return builder.addLenient$okhttp(str);
    }

    public static final void applyConnectionSpec(ConnectionSpec connectionSpec, SSLSocket sSLSocket, boolean z2) {
        Intrinsics.f(connectionSpec, "connectionSpec");
        Intrinsics.f(sSLSocket, "sslSocket");
        connectionSpec.apply$okhttp(sSLSocket, z2);
    }

    public static final Response cacheGet(Cache cache, Request request) {
        Intrinsics.f(cache, "cache");
        Intrinsics.f(request, AdActivity.REQUEST_KEY_EXTRA);
        return cache.get$okhttp(request);
    }

    public static final String cookieToString(Cookie cookie, boolean z2) {
        Intrinsics.f(cookie, "cookie");
        return cookie.toString$okhttp(z2);
    }

    public static final Cookie parseCookie(long j2, HttpUrl httpUrl, String str) {
        Intrinsics.f(httpUrl, ImagesContract.URL);
        Intrinsics.f(str, "setCookie");
        return Cookie.Companion.parse$okhttp(j2, httpUrl, str);
    }

    public static final Headers.Builder addHeaderLenient(Headers.Builder builder, String str, String str2) {
        Intrinsics.f(builder, "builder");
        Intrinsics.f(str, "name");
        Intrinsics.f(str2, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        return builder.addLenient$okhttp(str, str2);
    }
}
