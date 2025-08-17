package okhttp3.internal.http;

import com.google.android.gms.common.internal.ImagesContract;
import com.vungle.ads.internal.ui.AdActivity;
import java.net.Proxy;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import okhttp3.Request;

public final class RequestLine {
    public static final RequestLine INSTANCE = new RequestLine();

    private RequestLine() {
    }

    private final boolean includeAuthorityInRequestLine(Request request, Proxy.Type type) {
        return !request.isHttps() && type == Proxy.Type.HTTP;
    }

    public final String get(Request request, Proxy.Type type) {
        Intrinsics.f(request, AdActivity.REQUEST_KEY_EXTRA);
        Intrinsics.f(type, "proxyType");
        StringBuilder sb = new StringBuilder();
        sb.append(request.method());
        sb.append(' ');
        RequestLine requestLine = INSTANCE;
        if (requestLine.includeAuthorityInRequestLine(request, type)) {
            sb.append(request.url());
        } else {
            sb.append(requestLine.requestPath(request.url()));
        }
        sb.append(" HTTP/1.1");
        String sb2 = sb.toString();
        Intrinsics.e(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public final String requestPath(HttpUrl httpUrl) {
        Intrinsics.f(httpUrl, ImagesContract.URL);
        String encodedPath = httpUrl.encodedPath();
        String encodedQuery = httpUrl.encodedQuery();
        if (encodedQuery == null) {
            return encodedPath;
        }
        return encodedPath + '?' + encodedQuery;
    }
}
