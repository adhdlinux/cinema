package okhttp3.internal.http;

import okhttp3.Interceptor;

public final class CallServerInterceptor implements Interceptor {
    private final boolean forWebSocket;

    public CallServerInterceptor(boolean z2) {
        this.forWebSocket = z2;
    }

    private final boolean shouldIgnoreAndWaitForRealResponse(int i2) {
        if (i2 == 100) {
            return true;
        }
        return 102 <= i2 && i2 < 200;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0090, code lost:
        if (r3.isDuplex() == false) goto L_0x0092;
     */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a8 A[SYNTHETIC, Splitter:B:40:0x00a8] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00df A[Catch:{ IOException -> 0x019e }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x011a A[Catch:{ IOException -> 0x019e }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0129 A[Catch:{ IOException -> 0x019e }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0163 A[Catch:{ IOException -> 0x019e }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0168 A[Catch:{ IOException -> 0x019e }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0170 A[Catch:{ IOException -> 0x019e }] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01a7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public okhttp3.Response intercept(okhttp3.Interceptor.Chain r14) throws java.io.IOException {
        /*
            r13 = this;
            java.lang.String r0 = "Connection"
            java.lang.String r1 = "close"
            java.lang.String r2 = "chain"
            kotlin.jvm.internal.Intrinsics.f(r14, r2)
            okhttp3.internal.http.RealInterceptorChain r14 = (okhttp3.internal.http.RealInterceptorChain) r14
            okhttp3.internal.connection.Exchange r2 = r14.getExchange$okhttp()
            kotlin.jvm.internal.Intrinsics.c(r2)
            okhttp3.Request r14 = r14.getRequest$okhttp()
            okhttp3.RequestBody r3 = r14.body()
            long r4 = java.lang.System.currentTimeMillis()
            r6 = 0
            r7 = 1
            r8 = 0
            r2.writeRequestHeaders(r14)     // Catch:{ IOException -> 0x0099 }
            java.lang.String r9 = r14.method()     // Catch:{ IOException -> 0x0099 }
            boolean r9 = okhttp3.internal.http.HttpMethod.permitsRequestBody(r9)     // Catch:{ IOException -> 0x0099 }
            if (r9 == 0) goto L_0x0085
            if (r3 == 0) goto L_0x0085
            java.lang.String r9 = "100-continue"
            java.lang.String r10 = "Expect"
            java.lang.String r10 = r14.header(r10)     // Catch:{ IOException -> 0x0099 }
            boolean r9 = kotlin.text.StringsKt__StringsJVMKt.t(r9, r10, r7)     // Catch:{ IOException -> 0x0099 }
            if (r9 == 0) goto L_0x004c
            r2.flushRequest()     // Catch:{ IOException -> 0x0099 }
            okhttp3.Response$Builder r9 = r2.readResponseHeaders(r7)     // Catch:{ IOException -> 0x0099 }
            r2.responseHeadersStart()     // Catch:{ IOException -> 0x004a }
            r10 = 0
            goto L_0x004e
        L_0x004a:
            r3 = move-exception
            goto L_0x009b
        L_0x004c:
            r9 = r8
            r10 = 1
        L_0x004e:
            if (r9 != 0) goto L_0x0074
            boolean r11 = r3.isDuplex()     // Catch:{ IOException -> 0x0097 }
            if (r11 == 0) goto L_0x0065
            r2.flushRequest()     // Catch:{ IOException -> 0x0097 }
            okio.Sink r11 = r2.createRequestBody(r14, r7)     // Catch:{ IOException -> 0x0097 }
            okio.BufferedSink r11 = okio.Okio.c(r11)     // Catch:{ IOException -> 0x0097 }
            r3.writeTo(r11)     // Catch:{ IOException -> 0x0097 }
            goto L_0x008a
        L_0x0065:
            okio.Sink r11 = r2.createRequestBody(r14, r6)     // Catch:{ IOException -> 0x0097 }
            okio.BufferedSink r11 = okio.Okio.c(r11)     // Catch:{ IOException -> 0x0097 }
            r3.writeTo(r11)     // Catch:{ IOException -> 0x0097 }
            r11.close()     // Catch:{ IOException -> 0x0097 }
            goto L_0x008a
        L_0x0074:
            r2.noRequestBody()     // Catch:{ IOException -> 0x0097 }
            okhttp3.internal.connection.RealConnection r11 = r2.getConnection$okhttp()     // Catch:{ IOException -> 0x0097 }
            boolean r11 = r11.isMultiplexed$okhttp()     // Catch:{ IOException -> 0x0097 }
            if (r11 != 0) goto L_0x008a
            r2.noNewExchangesOnConnection()     // Catch:{ IOException -> 0x0097 }
            goto L_0x008a
        L_0x0085:
            r2.noRequestBody()     // Catch:{ IOException -> 0x0099 }
            r9 = r8
            r10 = 1
        L_0x008a:
            if (r3 == 0) goto L_0x0092
            boolean r3 = r3.isDuplex()     // Catch:{ IOException -> 0x0097 }
            if (r3 != 0) goto L_0x0095
        L_0x0092:
            r2.finishRequest()     // Catch:{ IOException -> 0x0097 }
        L_0x0095:
            r3 = r8
            goto L_0x00a6
        L_0x0097:
            r3 = move-exception
            goto L_0x009c
        L_0x0099:
            r3 = move-exception
            r9 = r8
        L_0x009b:
            r10 = 1
        L_0x009c:
            boolean r11 = r3 instanceof okhttp3.internal.http2.ConnectionShutdownException
            if (r11 != 0) goto L_0x01a7
            boolean r11 = r2.getHasFailure$okhttp()
            if (r11 == 0) goto L_0x01a6
        L_0x00a6:
            if (r9 != 0) goto L_0x00b5
            okhttp3.Response$Builder r9 = r2.readResponseHeaders(r6)     // Catch:{ IOException -> 0x019e }
            kotlin.jvm.internal.Intrinsics.c(r9)     // Catch:{ IOException -> 0x019e }
            if (r10 == 0) goto L_0x00b5
            r2.responseHeadersStart()     // Catch:{ IOException -> 0x019e }
            r10 = 0
        L_0x00b5:
            okhttp3.Response$Builder r9 = r9.request(r14)     // Catch:{ IOException -> 0x019e }
            okhttp3.internal.connection.RealConnection r11 = r2.getConnection$okhttp()     // Catch:{ IOException -> 0x019e }
            okhttp3.Handshake r11 = r11.handshake()     // Catch:{ IOException -> 0x019e }
            okhttp3.Response$Builder r9 = r9.handshake(r11)     // Catch:{ IOException -> 0x019e }
            okhttp3.Response$Builder r9 = r9.sentRequestAtMillis(r4)     // Catch:{ IOException -> 0x019e }
            long r11 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x019e }
            okhttp3.Response$Builder r9 = r9.receivedResponseAtMillis(r11)     // Catch:{ IOException -> 0x019e }
            okhttp3.Response r9 = r9.build()     // Catch:{ IOException -> 0x019e }
            int r11 = r9.code()     // Catch:{ IOException -> 0x019e }
            boolean r12 = r13.shouldIgnoreAndWaitForRealResponse(r11)     // Catch:{ IOException -> 0x019e }
            if (r12 == 0) goto L_0x010f
            okhttp3.Response$Builder r6 = r2.readResponseHeaders(r6)     // Catch:{ IOException -> 0x019e }
            kotlin.jvm.internal.Intrinsics.c(r6)     // Catch:{ IOException -> 0x019e }
            if (r10 == 0) goto L_0x00eb
            r2.responseHeadersStart()     // Catch:{ IOException -> 0x019e }
        L_0x00eb:
            okhttp3.Response$Builder r14 = r6.request(r14)     // Catch:{ IOException -> 0x019e }
            okhttp3.internal.connection.RealConnection r6 = r2.getConnection$okhttp()     // Catch:{ IOException -> 0x019e }
            okhttp3.Handshake r6 = r6.handshake()     // Catch:{ IOException -> 0x019e }
            okhttp3.Response$Builder r14 = r14.handshake(r6)     // Catch:{ IOException -> 0x019e }
            okhttp3.Response$Builder r14 = r14.sentRequestAtMillis(r4)     // Catch:{ IOException -> 0x019e }
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x019e }
            okhttp3.Response$Builder r14 = r14.receivedResponseAtMillis(r4)     // Catch:{ IOException -> 0x019e }
            okhttp3.Response r9 = r14.build()     // Catch:{ IOException -> 0x019e }
            int r11 = r9.code()     // Catch:{ IOException -> 0x019e }
        L_0x010f:
            r2.responseHeadersEnd(r9)     // Catch:{ IOException -> 0x019e }
            boolean r14 = r13.forWebSocket     // Catch:{ IOException -> 0x019e }
            if (r14 == 0) goto L_0x0129
            r14 = 101(0x65, float:1.42E-43)
            if (r11 != r14) goto L_0x0129
            okhttp3.Response$Builder r14 = r9.newBuilder()     // Catch:{ IOException -> 0x019e }
            okhttp3.ResponseBody r4 = okhttp3.internal.Util.EMPTY_RESPONSE     // Catch:{ IOException -> 0x019e }
            okhttp3.Response$Builder r14 = r14.body(r4)     // Catch:{ IOException -> 0x019e }
            okhttp3.Response r14 = r14.build()     // Catch:{ IOException -> 0x019e }
            goto L_0x0139
        L_0x0129:
            okhttp3.Response$Builder r14 = r9.newBuilder()     // Catch:{ IOException -> 0x019e }
            okhttp3.ResponseBody r4 = r2.openResponseBody(r9)     // Catch:{ IOException -> 0x019e }
            okhttp3.Response$Builder r14 = r14.body(r4)     // Catch:{ IOException -> 0x019e }
            okhttp3.Response r14 = r14.build()     // Catch:{ IOException -> 0x019e }
        L_0x0139:
            okhttp3.Request r4 = r14.request()     // Catch:{ IOException -> 0x019e }
            java.lang.String r4 = r4.header(r0)     // Catch:{ IOException -> 0x019e }
            boolean r4 = kotlin.text.StringsKt__StringsJVMKt.t(r1, r4, r7)     // Catch:{ IOException -> 0x019e }
            if (r4 != 0) goto L_0x0152
            r4 = 2
            java.lang.String r0 = okhttp3.Response.header$default(r14, r0, r8, r4, r8)     // Catch:{ IOException -> 0x019e }
            boolean r0 = kotlin.text.StringsKt__StringsJVMKt.t(r1, r0, r7)     // Catch:{ IOException -> 0x019e }
            if (r0 == 0) goto L_0x0155
        L_0x0152:
            r2.noNewExchangesOnConnection()     // Catch:{ IOException -> 0x019e }
        L_0x0155:
            r0 = 204(0xcc, float:2.86E-43)
            if (r11 == r0) goto L_0x015d
            r0 = 205(0xcd, float:2.87E-43)
            if (r11 != r0) goto L_0x019d
        L_0x015d:
            okhttp3.ResponseBody r0 = r14.body()     // Catch:{ IOException -> 0x019e }
            if (r0 == 0) goto L_0x0168
            long r0 = r0.contentLength()     // Catch:{ IOException -> 0x019e }
            goto L_0x016a
        L_0x0168:
            r0 = -1
        L_0x016a:
            r4 = 0
            int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r2 <= 0) goto L_0x019d
            java.net.ProtocolException r0 = new java.net.ProtocolException     // Catch:{ IOException -> 0x019e }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x019e }
            r1.<init>()     // Catch:{ IOException -> 0x019e }
            java.lang.String r2 = "HTTP "
            r1.append(r2)     // Catch:{ IOException -> 0x019e }
            r1.append(r11)     // Catch:{ IOException -> 0x019e }
            java.lang.String r2 = " had non-zero Content-Length: "
            r1.append(r2)     // Catch:{ IOException -> 0x019e }
            okhttp3.ResponseBody r14 = r14.body()     // Catch:{ IOException -> 0x019e }
            if (r14 == 0) goto L_0x0192
            long r4 = r14.contentLength()     // Catch:{ IOException -> 0x019e }
            java.lang.Long r8 = java.lang.Long.valueOf(r4)     // Catch:{ IOException -> 0x019e }
        L_0x0192:
            r1.append(r8)     // Catch:{ IOException -> 0x019e }
            java.lang.String r14 = r1.toString()     // Catch:{ IOException -> 0x019e }
            r0.<init>(r14)     // Catch:{ IOException -> 0x019e }
            throw r0     // Catch:{ IOException -> 0x019e }
        L_0x019d:
            return r14
        L_0x019e:
            r14 = move-exception
            if (r3 == 0) goto L_0x01a5
            kotlin.ExceptionsKt__ExceptionsKt.a(r3, r14)
            throw r3
        L_0x01a5:
            throw r14
        L_0x01a6:
            throw r3
        L_0x01a7:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http.CallServerInterceptor.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }
}
