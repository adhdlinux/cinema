package okhttp3.logging;

import com.google.android.gms.common.internal.ImagesContract;
import com.vungle.ads.internal.ui.AdActivity;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public final class LoggingEventListener extends EventListener {
    private final HttpLoggingInterceptor.Logger logger;
    private long startNs;

    public static class Factory implements EventListener.Factory {
        private final HttpLoggingInterceptor.Logger logger;

        public Factory() {
            this((HttpLoggingInterceptor.Logger) null, 1, (DefaultConstructorMarker) null);
        }

        public Factory(HttpLoggingInterceptor.Logger logger2) {
            Intrinsics.g(logger2, "logger");
            this.logger = logger2;
        }

        public EventListener create(Call call) {
            Intrinsics.g(call, "call");
            return new LoggingEventListener(this.logger, (DefaultConstructorMarker) null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Factory(HttpLoggingInterceptor.Logger logger2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? HttpLoggingInterceptor.Logger.DEFAULT : logger2);
        }
    }

    public /* synthetic */ LoggingEventListener(HttpLoggingInterceptor.Logger logger2, DefaultConstructorMarker defaultConstructorMarker) {
        this(logger2);
    }

    private final void logWithTime(String str) {
        long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - this.startNs);
        HttpLoggingInterceptor.Logger logger2 = this.logger;
        logger2.log('[' + millis + " ms] " + str);
    }

    public void cacheConditionalHit(Call call, Response response) {
        Intrinsics.g(call, "call");
        Intrinsics.g(response, "cachedResponse");
        logWithTime("cacheConditionalHit: " + response);
    }

    public void cacheHit(Call call, Response response) {
        Intrinsics.g(call, "call");
        Intrinsics.g(response, "response");
        logWithTime("cacheHit: " + response);
    }

    public void cacheMiss(Call call) {
        Intrinsics.g(call, "call");
        logWithTime("cacheMiss");
    }

    public void callEnd(Call call) {
        Intrinsics.g(call, "call");
        logWithTime("callEnd");
    }

    public void callFailed(Call call, IOException iOException) {
        Intrinsics.g(call, "call");
        Intrinsics.g(iOException, "ioe");
        logWithTime("callFailed: " + iOException);
    }

    public void callStart(Call call) {
        Intrinsics.g(call, "call");
        this.startNs = System.nanoTime();
        logWithTime("callStart: " + call.request());
    }

    public void canceled(Call call) {
        Intrinsics.g(call, "call");
        logWithTime("canceled");
    }

    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        Intrinsics.g(call, "call");
        Intrinsics.g(inetSocketAddress, "inetSocketAddress");
        Intrinsics.g(proxy, "proxy");
        logWithTime("connectEnd: " + protocol);
    }

    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
        Intrinsics.g(call, "call");
        Intrinsics.g(inetSocketAddress, "inetSocketAddress");
        Intrinsics.g(proxy, "proxy");
        Intrinsics.g(iOException, "ioe");
        logWithTime("connectFailed: " + protocol + ' ' + iOException);
    }

    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        Intrinsics.g(call, "call");
        Intrinsics.g(inetSocketAddress, "inetSocketAddress");
        Intrinsics.g(proxy, "proxy");
        logWithTime("connectStart: " + inetSocketAddress + ' ' + proxy);
    }

    public void connectionAcquired(Call call, Connection connection) {
        Intrinsics.g(call, "call");
        Intrinsics.g(connection, "connection");
        logWithTime("connectionAcquired: " + connection);
    }

    public void connectionReleased(Call call, Connection connection) {
        Intrinsics.g(call, "call");
        Intrinsics.g(connection, "connection");
        logWithTime("connectionReleased");
    }

    public void dnsEnd(Call call, String str, List<? extends InetAddress> list) {
        Intrinsics.g(call, "call");
        Intrinsics.g(str, "domainName");
        Intrinsics.g(list, "inetAddressList");
        logWithTime("dnsEnd: " + list);
    }

    public void dnsStart(Call call, String str) {
        Intrinsics.g(call, "call");
        Intrinsics.g(str, "domainName");
        logWithTime("dnsStart: " + str);
    }

    public void proxySelectEnd(Call call, HttpUrl httpUrl, List<? extends Proxy> list) {
        Intrinsics.g(call, "call");
        Intrinsics.g(httpUrl, ImagesContract.URL);
        Intrinsics.g(list, "proxies");
        logWithTime("proxySelectEnd: " + list);
    }

    public void proxySelectStart(Call call, HttpUrl httpUrl) {
        Intrinsics.g(call, "call");
        Intrinsics.g(httpUrl, ImagesContract.URL);
        logWithTime("proxySelectStart: " + httpUrl);
    }

    public void requestBodyEnd(Call call, long j2) {
        Intrinsics.g(call, "call");
        logWithTime("requestBodyEnd: byteCount=" + j2);
    }

    public void requestBodyStart(Call call) {
        Intrinsics.g(call, "call");
        logWithTime("requestBodyStart");
    }

    public void requestFailed(Call call, IOException iOException) {
        Intrinsics.g(call, "call");
        Intrinsics.g(iOException, "ioe");
        logWithTime("requestFailed: " + iOException);
    }

    public void requestHeadersEnd(Call call, Request request) {
        Intrinsics.g(call, "call");
        Intrinsics.g(request, AdActivity.REQUEST_KEY_EXTRA);
        logWithTime("requestHeadersEnd");
    }

    public void requestHeadersStart(Call call) {
        Intrinsics.g(call, "call");
        logWithTime("requestHeadersStart");
    }

    public void responseBodyEnd(Call call, long j2) {
        Intrinsics.g(call, "call");
        logWithTime("responseBodyEnd: byteCount=" + j2);
    }

    public void responseBodyStart(Call call) {
        Intrinsics.g(call, "call");
        logWithTime("responseBodyStart");
    }

    public void responseFailed(Call call, IOException iOException) {
        Intrinsics.g(call, "call");
        Intrinsics.g(iOException, "ioe");
        logWithTime("responseFailed: " + iOException);
    }

    public void responseHeadersEnd(Call call, Response response) {
        Intrinsics.g(call, "call");
        Intrinsics.g(response, "response");
        logWithTime("responseHeadersEnd: " + response);
    }

    public void responseHeadersStart(Call call) {
        Intrinsics.g(call, "call");
        logWithTime("responseHeadersStart");
    }

    public void satisfactionFailure(Call call, Response response) {
        Intrinsics.g(call, "call");
        Intrinsics.g(response, "response");
        logWithTime("satisfactionFailure: " + response);
    }

    public void secureConnectEnd(Call call, Handshake handshake) {
        Intrinsics.g(call, "call");
        logWithTime("secureConnectEnd: " + handshake);
    }

    public void secureConnectStart(Call call) {
        Intrinsics.g(call, "call");
        logWithTime("secureConnectStart");
    }

    private LoggingEventListener(HttpLoggingInterceptor.Logger logger2) {
        this.logger = logger2;
    }
}
