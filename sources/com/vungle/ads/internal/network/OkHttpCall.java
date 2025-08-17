package com.vungle.ads.internal.network;

import com.vungle.ads.internal.network.converters.Converter;
import java.io.IOException;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;

public final class OkHttpCall<T> implements Call<T> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "OkHttpCall";
    private volatile boolean canceled;
    private final Call rawCall;
    private final Converter<ResponseBody, T> responseConverter;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final void throwIfFatal(Throwable th) {
            if (th instanceof VirtualMachineError) {
                throw th;
            } else if (th instanceof ThreadDeath) {
                throw th;
            } else if (th instanceof LinkageError) {
                throw th;
            }
        }
    }

    public static final class ExceptionCatchingResponseBody extends ResponseBody {
        private final ResponseBody delegate;
        private final BufferedSource delegateSource;
        private IOException thrownException;

        public ExceptionCatchingResponseBody(ResponseBody responseBody) {
            Intrinsics.f(responseBody, "delegate");
            this.delegate = responseBody;
            this.delegateSource = Okio.d(new ForwardingSource(this, responseBody.source()) {
                final /* synthetic */ ExceptionCatchingResponseBody this$0;

                {
                    this.this$0 = r1;
                }

                public long read(Buffer buffer, long j2) throws IOException {
                    Intrinsics.f(buffer, "sink");
                    try {
                        return super.read(buffer, j2);
                    } catch (IOException e2) {
                        this.this$0.setThrownException(e2);
                        throw e2;
                    }
                }
            });
        }

        public void close() {
            this.delegate.close();
        }

        public long contentLength() {
            return this.delegate.contentLength();
        }

        public MediaType contentType() {
            return this.delegate.contentType();
        }

        public final IOException getThrownException() {
            return this.thrownException;
        }

        public final void setThrownException(IOException iOException) {
            this.thrownException = iOException;
        }

        public BufferedSource source() {
            return this.delegateSource;
        }

        public final void throwIfCaught() throws IOException {
            IOException iOException = this.thrownException;
            if (iOException != null) {
                throw iOException;
            }
        }
    }

    public static final class NoContentResponseBody extends ResponseBody {
        private final long contentLength;
        private final MediaType contentType;

        public NoContentResponseBody(MediaType mediaType, long j2) {
            this.contentType = mediaType;
            this.contentLength = j2;
        }

        public long contentLength() {
            return this.contentLength;
        }

        public MediaType contentType() {
            return this.contentType;
        }

        public BufferedSource source() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    public OkHttpCall(Call call, Converter<ResponseBody, T> converter) {
        Intrinsics.f(call, "rawCall");
        Intrinsics.f(converter, "responseConverter");
        this.rawCall = call;
        this.responseConverter = converter;
    }

    private final ResponseBody buffer(ResponseBody responseBody) throws IOException {
        Buffer buffer = new Buffer();
        responseBody.source().i0(buffer);
        return ResponseBody.Companion.create((BufferedSource) buffer, responseBody.contentType(), responseBody.contentLength());
    }

    public void cancel() {
        Call call;
        this.canceled = true;
        synchronized (this) {
            call = this.rawCall;
            Unit unit = Unit.f40298a;
        }
        call.cancel();
    }

    public void enqueue(Callback<T> callback) {
        Call call;
        Intrinsics.f(callback, "callback");
        Objects.requireNonNull(callback, "callback == null");
        synchronized (this) {
            call = this.rawCall;
            Unit unit = Unit.f40298a;
        }
        if (this.canceled) {
            call.cancel();
        }
        call.enqueue(new OkHttpCall$enqueue$2(this, callback));
    }

    public Response<T> execute() throws IOException {
        Call call;
        synchronized (this) {
            call = this.rawCall;
            Unit unit = Unit.f40298a;
        }
        if (this.canceled) {
            call.cancel();
        }
        return parseResponse(call.execute());
    }

    public boolean isCanceled() {
        boolean isCanceled;
        if (this.canceled) {
            return true;
        }
        synchronized (this) {
            isCanceled = this.rawCall.isCanceled();
        }
        return isCanceled;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x006c, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x006d, code lost:
        kotlin.io.CloseableKt.a(r0, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0070, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.vungle.ads.internal.network.Response<T> parseResponse(okhttp3.Response r7) throws java.io.IOException {
        /*
            r6 = this;
            java.lang.String r0 = "rawResp"
            kotlin.jvm.internal.Intrinsics.f(r7, r0)
            okhttp3.ResponseBody r0 = r7.body()
            r1 = 0
            if (r0 != 0) goto L_0x000d
            return r1
        L_0x000d:
            okhttp3.Response$Builder r7 = r7.newBuilder()
            com.vungle.ads.internal.network.OkHttpCall$NoContentResponseBody r2 = new com.vungle.ads.internal.network.OkHttpCall$NoContentResponseBody
            okhttp3.MediaType r3 = r0.contentType()
            long r4 = r0.contentLength()
            r2.<init>(r3, r4)
            okhttp3.Response$Builder r7 = r7.body(r2)
            okhttp3.Response r7 = r7.build()
            int r2 = r7.code()
            r3 = 200(0xc8, float:2.8E-43)
            if (r2 < r3) goto L_0x005c
            r3 = 300(0x12c, float:4.2E-43)
            if (r2 < r3) goto L_0x0033
            goto L_0x005c
        L_0x0033:
            r3 = 204(0xcc, float:2.86E-43)
            if (r2 == r3) goto L_0x0052
            r3 = 205(0xcd, float:2.87E-43)
            if (r2 == r3) goto L_0x0052
            com.vungle.ads.internal.network.OkHttpCall$ExceptionCatchingResponseBody r1 = new com.vungle.ads.internal.network.OkHttpCall$ExceptionCatchingResponseBody
            r1.<init>(r0)
            com.vungle.ads.internal.network.converters.Converter<okhttp3.ResponseBody, T> r0 = r6.responseConverter     // Catch:{ RuntimeException -> 0x004d }
            java.lang.Object r0 = r0.convert(r1)     // Catch:{ RuntimeException -> 0x004d }
            com.vungle.ads.internal.network.Response$Companion r2 = com.vungle.ads.internal.network.Response.Companion     // Catch:{ RuntimeException -> 0x004d }
            com.vungle.ads.internal.network.Response r7 = r2.success(r0, r7)     // Catch:{ RuntimeException -> 0x004d }
            return r7
        L_0x004d:
            r7 = move-exception
            r1.throwIfCaught()
            throw r7
        L_0x0052:
            r0.close()
            com.vungle.ads.internal.network.Response$Companion r0 = com.vungle.ads.internal.network.Response.Companion
            com.vungle.ads.internal.network.Response r7 = r0.success(r1, r7)
            return r7
        L_0x005c:
            okhttp3.ResponseBody r2 = r6.buffer(r0)     // Catch:{ all -> 0x006a }
            com.vungle.ads.internal.network.Response$Companion r3 = com.vungle.ads.internal.network.Response.Companion     // Catch:{ all -> 0x006a }
            com.vungle.ads.internal.network.Response r7 = r3.error(r2, r7)     // Catch:{ all -> 0x006a }
            kotlin.io.CloseableKt.a(r0, r1)
            return r7
        L_0x006a:
            r7 = move-exception
            throw r7     // Catch:{ all -> 0x006c }
        L_0x006c:
            r1 = move-exception
            kotlin.io.CloseableKt.a(r0, r7)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.network.OkHttpCall.parseResponse(okhttp3.Response):com.vungle.ads.internal.network.Response");
    }
}
