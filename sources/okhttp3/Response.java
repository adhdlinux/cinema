package okhttp3;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.vungle.ads.internal.ui.AdActivity;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.http.HttpHeaders;
import okio.Buffer;
import okio.BufferedSource;

public final class Response implements Closeable {
    private final ResponseBody body;
    private final Response cacheResponse;
    private final int code;
    private final Exchange exchange;
    private final Handshake handshake;
    private final Headers headers;
    private CacheControl lazyCacheControl;
    private final String message;
    private final Response networkResponse;
    private final Response priorResponse;
    private final Protocol protocol;
    private final long receivedResponseAtMillis;
    private final Request request;
    private final long sentRequestAtMillis;

    public Response(Request request2, Protocol protocol2, String str, int i2, Handshake handshake2, Headers headers2, ResponseBody responseBody, Response response, Response response2, Response response3, long j2, long j3, Exchange exchange2) {
        Intrinsics.f(request2, AdActivity.REQUEST_KEY_EXTRA);
        Intrinsics.f(protocol2, "protocol");
        Intrinsics.f(str, "message");
        Intrinsics.f(headers2, "headers");
        this.request = request2;
        this.protocol = protocol2;
        this.message = str;
        this.code = i2;
        this.handshake = handshake2;
        this.headers = headers2;
        this.body = responseBody;
        this.networkResponse = response;
        this.cacheResponse = response2;
        this.priorResponse = response3;
        this.sentRequestAtMillis = j2;
        this.receivedResponseAtMillis = j3;
        this.exchange = exchange2;
    }

    public static /* synthetic */ String header$default(Response response, String str, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        return response.header(str, str2);
    }

    /* renamed from: -deprecated_body  reason: not valid java name */
    public final ResponseBody m341deprecated_body() {
        return this.body;
    }

    /* renamed from: -deprecated_cacheControl  reason: not valid java name */
    public final CacheControl m342deprecated_cacheControl() {
        return cacheControl();
    }

    /* renamed from: -deprecated_cacheResponse  reason: not valid java name */
    public final Response m343deprecated_cacheResponse() {
        return this.cacheResponse;
    }

    /* renamed from: -deprecated_code  reason: not valid java name */
    public final int m344deprecated_code() {
        return this.code;
    }

    /* renamed from: -deprecated_handshake  reason: not valid java name */
    public final Handshake m345deprecated_handshake() {
        return this.handshake;
    }

    /* renamed from: -deprecated_headers  reason: not valid java name */
    public final Headers m346deprecated_headers() {
        return this.headers;
    }

    /* renamed from: -deprecated_message  reason: not valid java name */
    public final String m347deprecated_message() {
        return this.message;
    }

    /* renamed from: -deprecated_networkResponse  reason: not valid java name */
    public final Response m348deprecated_networkResponse() {
        return this.networkResponse;
    }

    /* renamed from: -deprecated_priorResponse  reason: not valid java name */
    public final Response m349deprecated_priorResponse() {
        return this.priorResponse;
    }

    /* renamed from: -deprecated_protocol  reason: not valid java name */
    public final Protocol m350deprecated_protocol() {
        return this.protocol;
    }

    /* renamed from: -deprecated_receivedResponseAtMillis  reason: not valid java name */
    public final long m351deprecated_receivedResponseAtMillis() {
        return this.receivedResponseAtMillis;
    }

    /* renamed from: -deprecated_request  reason: not valid java name */
    public final Request m352deprecated_request() {
        return this.request;
    }

    /* renamed from: -deprecated_sentRequestAtMillis  reason: not valid java name */
    public final long m353deprecated_sentRequestAtMillis() {
        return this.sentRequestAtMillis;
    }

    public final ResponseBody body() {
        return this.body;
    }

    public final CacheControl cacheControl() {
        CacheControl cacheControl = this.lazyCacheControl;
        if (cacheControl != null) {
            return cacheControl;
        }
        CacheControl parse = CacheControl.Companion.parse(this.headers);
        this.lazyCacheControl = parse;
        return parse;
    }

    public final Response cacheResponse() {
        return this.cacheResponse;
    }

    public final List<Challenge> challenges() {
        String str;
        Headers headers2 = this.headers;
        int i2 = this.code;
        if (i2 == 401) {
            str = "WWW-Authenticate";
        } else if (i2 != 407) {
            return CollectionsKt__CollectionsKt.f();
        } else {
            str = "Proxy-Authenticate";
        }
        return HttpHeaders.parseChallenges(headers2, str);
    }

    public void close() {
        ResponseBody responseBody = this.body;
        if (responseBody != null) {
            responseBody.close();
            return;
        }
        throw new IllegalStateException("response is not eligible for a body and must not be closed".toString());
    }

    public final int code() {
        return this.code;
    }

    public final Exchange exchange() {
        return this.exchange;
    }

    public final Handshake handshake() {
        return this.handshake;
    }

    public final String header(String str) {
        Intrinsics.f(str, "name");
        return header$default(this, str, (String) null, 2, (Object) null);
    }

    public final String header(String str, String str2) {
        Intrinsics.f(str, "name");
        String str3 = this.headers.get(str);
        if (str3 == null) {
            return str2;
        }
        return str3;
    }

    public final Headers headers() {
        return this.headers;
    }

    public final boolean isRedirect() {
        int i2 = this.code;
        if (!(i2 == 307 || i2 == 308)) {
            switch (i2) {
                case 300:
                case 301:
                case INVALID_IFA_STATUS_VALUE:
                case 303:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    public final boolean isSuccessful() {
        int i2 = this.code;
        return 200 <= i2 && i2 < 300;
    }

    public final String message() {
        return this.message;
    }

    public final Response networkResponse() {
        return this.networkResponse;
    }

    public final Builder newBuilder() {
        return new Builder(this);
    }

    public final ResponseBody peekBody(long j2) throws IOException {
        ResponseBody responseBody = this.body;
        Intrinsics.c(responseBody);
        BufferedSource peek = responseBody.source().peek();
        Buffer buffer = new Buffer();
        peek.request(j2);
        buffer.y0(peek, Math.min(j2, peek.c().size()));
        return ResponseBody.Companion.create((BufferedSource) buffer, this.body.contentType(), buffer.size());
    }

    public final Response priorResponse() {
        return this.priorResponse;
    }

    public final Protocol protocol() {
        return this.protocol;
    }

    public final long receivedResponseAtMillis() {
        return this.receivedResponseAtMillis;
    }

    public final Request request() {
        return this.request;
    }

    public final long sentRequestAtMillis() {
        return this.sentRequestAtMillis;
    }

    public String toString() {
        return "Response{protocol=" + this.protocol + ", code=" + this.code + ", message=" + this.message + ", url=" + this.request.url() + '}';
    }

    public final Headers trailers() throws IOException {
        Exchange exchange2 = this.exchange;
        if (exchange2 != null) {
            return exchange2.trailers();
        }
        throw new IllegalStateException("trailers not available".toString());
    }

    public final List<String> headers(String str) {
        Intrinsics.f(str, "name");
        return this.headers.values(str);
    }

    public static class Builder {
        private ResponseBody body;
        private Response cacheResponse;
        private int code;
        private Exchange exchange;
        private Handshake handshake;
        private Headers.Builder headers;
        private String message;
        private Response networkResponse;
        private Response priorResponse;
        private Protocol protocol;
        private long receivedResponseAtMillis;
        private Request request;
        private long sentRequestAtMillis;

        public Builder() {
            this.code = -1;
            this.headers = new Headers.Builder();
        }

        private final void checkPriorResponse(Response response) {
            if (response != null) {
                if (!(response.body() == null)) {
                    throw new IllegalArgumentException("priorResponse.body != null".toString());
                }
            }
        }

        private final void checkSupportResponse(String str, Response response) {
            boolean z2;
            boolean z3;
            boolean z4;
            if (response != null) {
                boolean z5 = true;
                if (response.body() == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    if (response.networkResponse() == null) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (z3) {
                        if (response.cacheResponse() == null) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (z4) {
                            if (response.priorResponse() != null) {
                                z5 = false;
                            }
                            if (!z5) {
                                throw new IllegalArgumentException((str + ".priorResponse != null").toString());
                            }
                            return;
                        }
                        throw new IllegalArgumentException((str + ".cacheResponse != null").toString());
                    }
                    throw new IllegalArgumentException((str + ".networkResponse != null").toString());
                }
                throw new IllegalArgumentException((str + ".body != null").toString());
            }
        }

        public Builder addHeader(String str, String str2) {
            Intrinsics.f(str, "name");
            Intrinsics.f(str2, AppMeasurementSdk.ConditionalUserProperty.VALUE);
            this.headers.add(str, str2);
            return this;
        }

        public Builder body(ResponseBody responseBody) {
            this.body = responseBody;
            return this;
        }

        public Response build() {
            boolean z2;
            int i2 = this.code;
            if (i2 >= 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                Request request2 = this.request;
                if (request2 != null) {
                    Protocol protocol2 = this.protocol;
                    if (protocol2 != null) {
                        String str = this.message;
                        if (str != null) {
                            return new Response(request2, protocol2, str, i2, this.handshake, this.headers.build(), this.body, this.networkResponse, this.cacheResponse, this.priorResponse, this.sentRequestAtMillis, this.receivedResponseAtMillis, this.exchange);
                        }
                        throw new IllegalStateException("message == null".toString());
                    }
                    throw new IllegalStateException("protocol == null".toString());
                }
                throw new IllegalStateException("request == null".toString());
            }
            throw new IllegalStateException(("code < 0: " + this.code).toString());
        }

        public Builder cacheResponse(Response response) {
            checkSupportResponse("cacheResponse", response);
            this.cacheResponse = response;
            return this;
        }

        public Builder code(int i2) {
            this.code = i2;
            return this;
        }

        public final ResponseBody getBody$okhttp() {
            return this.body;
        }

        public final Response getCacheResponse$okhttp() {
            return this.cacheResponse;
        }

        public final int getCode$okhttp() {
            return this.code;
        }

        public final Exchange getExchange$okhttp() {
            return this.exchange;
        }

        public final Handshake getHandshake$okhttp() {
            return this.handshake;
        }

        public final Headers.Builder getHeaders$okhttp() {
            return this.headers;
        }

        public final String getMessage$okhttp() {
            return this.message;
        }

        public final Response getNetworkResponse$okhttp() {
            return this.networkResponse;
        }

        public final Response getPriorResponse$okhttp() {
            return this.priorResponse;
        }

        public final Protocol getProtocol$okhttp() {
            return this.protocol;
        }

        public final long getReceivedResponseAtMillis$okhttp() {
            return this.receivedResponseAtMillis;
        }

        public final Request getRequest$okhttp() {
            return this.request;
        }

        public final long getSentRequestAtMillis$okhttp() {
            return this.sentRequestAtMillis;
        }

        public Builder handshake(Handshake handshake2) {
            this.handshake = handshake2;
            return this;
        }

        public Builder header(String str, String str2) {
            Intrinsics.f(str, "name");
            Intrinsics.f(str2, AppMeasurementSdk.ConditionalUserProperty.VALUE);
            this.headers.set(str, str2);
            return this;
        }

        public Builder headers(Headers headers2) {
            Intrinsics.f(headers2, "headers");
            this.headers = headers2.newBuilder();
            return this;
        }

        public final void initExchange$okhttp(Exchange exchange2) {
            Intrinsics.f(exchange2, "deferredTrailers");
            this.exchange = exchange2;
        }

        public Builder message(String str) {
            Intrinsics.f(str, "message");
            this.message = str;
            return this;
        }

        public Builder networkResponse(Response response) {
            checkSupportResponse("networkResponse", response);
            this.networkResponse = response;
            return this;
        }

        public Builder priorResponse(Response response) {
            checkPriorResponse(response);
            this.priorResponse = response;
            return this;
        }

        public Builder protocol(Protocol protocol2) {
            Intrinsics.f(protocol2, "protocol");
            this.protocol = protocol2;
            return this;
        }

        public Builder receivedResponseAtMillis(long j2) {
            this.receivedResponseAtMillis = j2;
            return this;
        }

        public Builder removeHeader(String str) {
            Intrinsics.f(str, "name");
            this.headers.removeAll(str);
            return this;
        }

        public Builder request(Request request2) {
            Intrinsics.f(request2, AdActivity.REQUEST_KEY_EXTRA);
            this.request = request2;
            return this;
        }

        public Builder sentRequestAtMillis(long j2) {
            this.sentRequestAtMillis = j2;
            return this;
        }

        public final void setBody$okhttp(ResponseBody responseBody) {
            this.body = responseBody;
        }

        public final void setCacheResponse$okhttp(Response response) {
            this.cacheResponse = response;
        }

        public final void setCode$okhttp(int i2) {
            this.code = i2;
        }

        public final void setExchange$okhttp(Exchange exchange2) {
            this.exchange = exchange2;
        }

        public final void setHandshake$okhttp(Handshake handshake2) {
            this.handshake = handshake2;
        }

        public final void setHeaders$okhttp(Headers.Builder builder) {
            Intrinsics.f(builder, "<set-?>");
            this.headers = builder;
        }

        public final void setMessage$okhttp(String str) {
            this.message = str;
        }

        public final void setNetworkResponse$okhttp(Response response) {
            this.networkResponse = response;
        }

        public final void setPriorResponse$okhttp(Response response) {
            this.priorResponse = response;
        }

        public final void setProtocol$okhttp(Protocol protocol2) {
            this.protocol = protocol2;
        }

        public final void setReceivedResponseAtMillis$okhttp(long j2) {
            this.receivedResponseAtMillis = j2;
        }

        public final void setRequest$okhttp(Request request2) {
            this.request = request2;
        }

        public final void setSentRequestAtMillis$okhttp(long j2) {
            this.sentRequestAtMillis = j2;
        }

        public Builder(Response response) {
            Intrinsics.f(response, "response");
            this.code = -1;
            this.request = response.request();
            this.protocol = response.protocol();
            this.code = response.code();
            this.message = response.message();
            this.handshake = response.handshake();
            this.headers = response.headers().newBuilder();
            this.body = response.body();
            this.networkResponse = response.networkResponse();
            this.cacheResponse = response.cacheResponse();
            this.priorResponse = response.priorResponse();
            this.sentRequestAtMillis = response.sentRequestAtMillis();
            this.receivedResponseAtMillis = response.receivedResponseAtMillis();
            this.exchange = response.exchange();
        }
    }
}
