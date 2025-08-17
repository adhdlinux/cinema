package okhttp3;

import com.google.android.gms.common.internal.ImagesContract;
import com.vungle.ads.internal.ui.AdActivity;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public abstract class EventListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final EventListener NONE = new EventListener$Companion$NONE$1();

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public interface Factory {
        EventListener create(Call call);
    }

    public void cacheConditionalHit(Call call, Response response) {
        Intrinsics.f(call, "call");
        Intrinsics.f(response, "cachedResponse");
    }

    public void cacheHit(Call call, Response response) {
        Intrinsics.f(call, "call");
        Intrinsics.f(response, "response");
    }

    public void cacheMiss(Call call) {
        Intrinsics.f(call, "call");
    }

    public void callEnd(Call call) {
        Intrinsics.f(call, "call");
    }

    public void callFailed(Call call, IOException iOException) {
        Intrinsics.f(call, "call");
        Intrinsics.f(iOException, "ioe");
    }

    public void callStart(Call call) {
        Intrinsics.f(call, "call");
    }

    public void canceled(Call call) {
        Intrinsics.f(call, "call");
    }

    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        Intrinsics.f(call, "call");
        Intrinsics.f(inetSocketAddress, "inetSocketAddress");
        Intrinsics.f(proxy, "proxy");
    }

    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
        Intrinsics.f(call, "call");
        Intrinsics.f(inetSocketAddress, "inetSocketAddress");
        Intrinsics.f(proxy, "proxy");
        Intrinsics.f(iOException, "ioe");
    }

    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        Intrinsics.f(call, "call");
        Intrinsics.f(inetSocketAddress, "inetSocketAddress");
        Intrinsics.f(proxy, "proxy");
    }

    public void connectionAcquired(Call call, Connection connection) {
        Intrinsics.f(call, "call");
        Intrinsics.f(connection, "connection");
    }

    public void connectionReleased(Call call, Connection connection) {
        Intrinsics.f(call, "call");
        Intrinsics.f(connection, "connection");
    }

    public void dnsEnd(Call call, String str, List<InetAddress> list) {
        Intrinsics.f(call, "call");
        Intrinsics.f(str, "domainName");
        Intrinsics.f(list, "inetAddressList");
    }

    public void dnsStart(Call call, String str) {
        Intrinsics.f(call, "call");
        Intrinsics.f(str, "domainName");
    }

    public void proxySelectEnd(Call call, HttpUrl httpUrl, List<Proxy> list) {
        Intrinsics.f(call, "call");
        Intrinsics.f(httpUrl, ImagesContract.URL);
        Intrinsics.f(list, "proxies");
    }

    public void proxySelectStart(Call call, HttpUrl httpUrl) {
        Intrinsics.f(call, "call");
        Intrinsics.f(httpUrl, ImagesContract.URL);
    }

    public void requestBodyEnd(Call call, long j2) {
        Intrinsics.f(call, "call");
    }

    public void requestBodyStart(Call call) {
        Intrinsics.f(call, "call");
    }

    public void requestFailed(Call call, IOException iOException) {
        Intrinsics.f(call, "call");
        Intrinsics.f(iOException, "ioe");
    }

    public void requestHeadersEnd(Call call, Request request) {
        Intrinsics.f(call, "call");
        Intrinsics.f(request, AdActivity.REQUEST_KEY_EXTRA);
    }

    public void requestHeadersStart(Call call) {
        Intrinsics.f(call, "call");
    }

    public void responseBodyEnd(Call call, long j2) {
        Intrinsics.f(call, "call");
    }

    public void responseBodyStart(Call call) {
        Intrinsics.f(call, "call");
    }

    public void responseFailed(Call call, IOException iOException) {
        Intrinsics.f(call, "call");
        Intrinsics.f(iOException, "ioe");
    }

    public void responseHeadersEnd(Call call, Response response) {
        Intrinsics.f(call, "call");
        Intrinsics.f(response, "response");
    }

    public void responseHeadersStart(Call call) {
        Intrinsics.f(call, "call");
    }

    public void satisfactionFailure(Call call, Response response) {
        Intrinsics.f(call, "call");
        Intrinsics.f(response, "response");
    }

    public void secureConnectEnd(Call call, Handshake handshake) {
        Intrinsics.f(call, "call");
    }

    public void secureConnectStart(Call call) {
        Intrinsics.f(call, "call");
    }
}
