package okhttp3.internal.connection;

import com.uwetrottmann.trakt5.TraktV2;
import com.vungle.ads.internal.ui.AdActivity;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketException;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.internal.ws.RealWebSocket;
import okio.Buffer;
import okio.ForwardingSink;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

public final class Exchange {
    private final RealCall call;
    private final ExchangeCodec codec;
    private final RealConnection connection;
    private final EventListener eventListener;
    private final ExchangeFinder finder;
    private boolean hasFailure;
    private boolean isDuplex;

    private final class RequestBodySink extends ForwardingSink {
        private long bytesReceived;
        private boolean closed;
        private boolean completed;
        private final long contentLength;
        final /* synthetic */ Exchange this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public RequestBodySink(Exchange exchange, Sink sink, long j2) {
            super(sink);
            Intrinsics.f(sink, "delegate");
            this.this$0 = exchange;
            this.contentLength = j2;
        }

        private final <E extends IOException> E complete(E e2) {
            if (this.completed) {
                return e2;
            }
            this.completed = true;
            return this.this$0.bodyComplete(this.bytesReceived, false, true, e2);
        }

        public void close() throws IOException {
            if (!this.closed) {
                this.closed = true;
                long j2 = this.contentLength;
                if (j2 == -1 || this.bytesReceived == j2) {
                    try {
                        super.close();
                        complete((IOException) null);
                    } catch (IOException e2) {
                        throw complete(e2);
                    }
                } else {
                    throw new ProtocolException("unexpected end of stream");
                }
            }
        }

        public void flush() throws IOException {
            try {
                super.flush();
            } catch (IOException e2) {
                throw complete(e2);
            }
        }

        public void write(Buffer buffer, long j2) throws IOException {
            Intrinsics.f(buffer, "source");
            if (!this.closed) {
                long j3 = this.contentLength;
                if (j3 == -1 || this.bytesReceived + j2 <= j3) {
                    try {
                        super.write(buffer, j2);
                        this.bytesReceived += j2;
                    } catch (IOException e2) {
                        throw complete(e2);
                    }
                } else {
                    throw new ProtocolException("expected " + this.contentLength + " bytes but received " + (this.bytesReceived + j2));
                }
            } else {
                throw new IllegalStateException("closed".toString());
            }
        }
    }

    public final class ResponseBodySource extends ForwardingSource {
        private long bytesReceived;
        private boolean closed;
        private boolean completed;
        private final long contentLength;
        private boolean invokeStartEvent = true;
        final /* synthetic */ Exchange this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ResponseBodySource(Exchange exchange, Source source, long j2) {
            super(source);
            Intrinsics.f(source, "delegate");
            this.this$0 = exchange;
            this.contentLength = j2;
            if (j2 == 0) {
                complete((IOException) null);
            }
        }

        public void close() throws IOException {
            if (!this.closed) {
                this.closed = true;
                try {
                    super.close();
                    complete((IOException) null);
                } catch (IOException e2) {
                    throw complete(e2);
                }
            }
        }

        public final <E extends IOException> E complete(E e2) {
            if (this.completed) {
                return e2;
            }
            this.completed = true;
            if (e2 == null && this.invokeStartEvent) {
                this.invokeStartEvent = false;
                this.this$0.getEventListener$okhttp().responseBodyStart(this.this$0.getCall$okhttp());
            }
            return this.this$0.bodyComplete(this.bytesReceived, true, false, e2);
        }

        public long read(Buffer buffer, long j2) throws IOException {
            Intrinsics.f(buffer, "sink");
            if (!this.closed) {
                try {
                    long read = delegate().read(buffer, j2);
                    if (this.invokeStartEvent) {
                        this.invokeStartEvent = false;
                        this.this$0.getEventListener$okhttp().responseBodyStart(this.this$0.getCall$okhttp());
                    }
                    if (read == -1) {
                        complete((IOException) null);
                        return -1;
                    }
                    long j3 = this.bytesReceived + read;
                    long j4 = this.contentLength;
                    if (j4 != -1) {
                        if (j3 > j4) {
                            throw new ProtocolException("expected " + this.contentLength + " bytes but received " + j3);
                        }
                    }
                    this.bytesReceived = j3;
                    if (j3 == j4) {
                        complete((IOException) null);
                    }
                    return read;
                } catch (IOException e2) {
                    throw complete(e2);
                }
            } else {
                throw new IllegalStateException("closed".toString());
            }
        }
    }

    public Exchange(RealCall realCall, EventListener eventListener2, ExchangeFinder exchangeFinder, ExchangeCodec exchangeCodec) {
        Intrinsics.f(realCall, "call");
        Intrinsics.f(eventListener2, "eventListener");
        Intrinsics.f(exchangeFinder, "finder");
        Intrinsics.f(exchangeCodec, "codec");
        this.call = realCall;
        this.eventListener = eventListener2;
        this.finder = exchangeFinder;
        this.codec = exchangeCodec;
        this.connection = exchangeCodec.getConnection();
    }

    private final void trackFailure(IOException iOException) {
        this.hasFailure = true;
        this.finder.trackFailure(iOException);
        this.codec.getConnection().trackFailure$okhttp(this.call, iOException);
    }

    public final <E extends IOException> E bodyComplete(long j2, boolean z2, boolean z3, E e2) {
        if (e2 != null) {
            trackFailure(e2);
        }
        if (z3) {
            if (e2 != null) {
                this.eventListener.requestFailed(this.call, e2);
            } else {
                this.eventListener.requestBodyEnd(this.call, j2);
            }
        }
        if (z2) {
            if (e2 != null) {
                this.eventListener.responseFailed(this.call, e2);
            } else {
                this.eventListener.responseBodyEnd(this.call, j2);
            }
        }
        return this.call.messageDone$okhttp(this, z3, z2, e2);
    }

    public final void cancel() {
        this.codec.cancel();
    }

    public final Sink createRequestBody(Request request, boolean z2) throws IOException {
        Intrinsics.f(request, AdActivity.REQUEST_KEY_EXTRA);
        this.isDuplex = z2;
        RequestBody body = request.body();
        Intrinsics.c(body);
        long contentLength = body.contentLength();
        this.eventListener.requestBodyStart(this.call);
        return new RequestBodySink(this, this.codec.createRequestBody(request, contentLength), contentLength);
    }

    public final void detachWithViolence() {
        this.codec.cancel();
        this.call.messageDone$okhttp(this, true, true, null);
    }

    public final void finishRequest() throws IOException {
        try {
            this.codec.finishRequest();
        } catch (IOException e2) {
            this.eventListener.requestFailed(this.call, e2);
            trackFailure(e2);
            throw e2;
        }
    }

    public final void flushRequest() throws IOException {
        try {
            this.codec.flushRequest();
        } catch (IOException e2) {
            this.eventListener.requestFailed(this.call, e2);
            trackFailure(e2);
            throw e2;
        }
    }

    public final RealCall getCall$okhttp() {
        return this.call;
    }

    public final RealConnection getConnection$okhttp() {
        return this.connection;
    }

    public final EventListener getEventListener$okhttp() {
        return this.eventListener;
    }

    public final ExchangeFinder getFinder$okhttp() {
        return this.finder;
    }

    public final boolean getHasFailure$okhttp() {
        return this.hasFailure;
    }

    public final boolean isCoalescedConnection$okhttp() {
        return !Intrinsics.a(this.finder.getAddress$okhttp().url().host(), this.connection.route().address().url().host());
    }

    public final boolean isDuplex$okhttp() {
        return this.isDuplex;
    }

    public final RealWebSocket.Streams newWebSocketStreams() throws SocketException {
        this.call.timeoutEarlyExit();
        return this.codec.getConnection().newWebSocketStreams$okhttp(this);
    }

    public final void noNewExchangesOnConnection() {
        this.codec.getConnection().noNewExchanges$okhttp();
    }

    public final void noRequestBody() {
        this.call.messageDone$okhttp(this, true, false, null);
    }

    public final ResponseBody openResponseBody(Response response) throws IOException {
        Intrinsics.f(response, "response");
        try {
            String header$default = Response.header$default(response, TraktV2.HEADER_CONTENT_TYPE, (String) null, 2, (Object) null);
            long reportedContentLength = this.codec.reportedContentLength(response);
            return new RealResponseBody(header$default, reportedContentLength, Okio.d(new ResponseBodySource(this, this.codec.openResponseBodySource(response), reportedContentLength)));
        } catch (IOException e2) {
            this.eventListener.responseFailed(this.call, e2);
            trackFailure(e2);
            throw e2;
        }
    }

    public final Response.Builder readResponseHeaders(boolean z2) throws IOException {
        try {
            Response.Builder readResponseHeaders = this.codec.readResponseHeaders(z2);
            if (readResponseHeaders != null) {
                readResponseHeaders.initExchange$okhttp(this);
            }
            return readResponseHeaders;
        } catch (IOException e2) {
            this.eventListener.responseFailed(this.call, e2);
            trackFailure(e2);
            throw e2;
        }
    }

    public final void responseHeadersEnd(Response response) {
        Intrinsics.f(response, "response");
        this.eventListener.responseHeadersEnd(this.call, response);
    }

    public final void responseHeadersStart() {
        this.eventListener.responseHeadersStart(this.call);
    }

    public final Headers trailers() throws IOException {
        return this.codec.trailers();
    }

    public final void webSocketUpgradeFailed() {
        bodyComplete(-1, true, true, (IOException) null);
    }

    public final void writeRequestHeaders(Request request) throws IOException {
        Intrinsics.f(request, AdActivity.REQUEST_KEY_EXTRA);
        try {
            this.eventListener.requestHeadersStart(this.call);
            this.codec.writeRequestHeaders(request);
            this.eventListener.requestHeadersEnd(this.call, request);
        } catch (IOException e2) {
            this.eventListener.requestFailed(this.call, e2);
            trackFailure(e2);
            throw e2;
        }
    }
}
