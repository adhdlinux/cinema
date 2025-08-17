package okhttp3.internal.ws;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.ws.WebSocketReader;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;

public final class RealWebSocket implements WebSocket, WebSocketReader.FrameCallback {
    private static final long CANCEL_AFTER_CLOSE_MILLIS = 60000;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final long DEFAULT_MINIMUM_DEFLATE_SIZE = 1024;
    private static final long MAX_QUEUE_SIZE = 16777216;
    private static final List<Protocol> ONLY_HTTP1 = CollectionsKt__CollectionsJVMKt.b(Protocol.HTTP_1_1);
    private boolean awaitingPong;
    private Call call;
    private boolean enqueuedClose;
    /* access modifiers changed from: private */
    public WebSocketExtensions extensions;
    private boolean failed;
    private final String key;
    private final WebSocketListener listener;
    /* access modifiers changed from: private */
    public final ArrayDeque<Object> messageAndCloseQueue = new ArrayDeque<>();
    private long minimumDeflateSize;
    /* access modifiers changed from: private */
    public String name;
    private final Request originalRequest;
    private final long pingIntervalMillis;
    private final ArrayDeque<ByteString> pongQueue = new ArrayDeque<>();
    private long queueSize;
    private final Random random;
    private WebSocketReader reader;
    private int receivedCloseCode = -1;
    private String receivedCloseReason;
    private int receivedPingCount;
    private int receivedPongCount;
    private int sentPingCount;
    private Streams streams;
    private TaskQueue taskQueue;
    private WebSocketWriter writer;
    private Task writerTask;

    public static final class Close {
        private final long cancelAfterCloseMillis;
        private final int code;
        private final ByteString reason;

        public Close(int i2, ByteString byteString, long j2) {
            this.code = i2;
            this.reason = byteString;
            this.cancelAfterCloseMillis = j2;
        }

        public final long getCancelAfterCloseMillis() {
            return this.cancelAfterCloseMillis;
        }

        public final int getCode() {
            return this.code;
        }

        public final ByteString getReason() {
            return this.reason;
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class Message {
        private final ByteString data;
        private final int formatOpcode;

        public Message(int i2, ByteString byteString) {
            Intrinsics.f(byteString, "data");
            this.formatOpcode = i2;
            this.data = byteString;
        }

        public final ByteString getData() {
            return this.data;
        }

        public final int getFormatOpcode() {
            return this.formatOpcode;
        }
    }

    public static abstract class Streams implements Closeable {
        private final boolean client;
        private final BufferedSink sink;
        private final BufferedSource source;

        public Streams(boolean z2, BufferedSource bufferedSource, BufferedSink bufferedSink) {
            Intrinsics.f(bufferedSource, "source");
            Intrinsics.f(bufferedSink, "sink");
            this.client = z2;
            this.source = bufferedSource;
            this.sink = bufferedSink;
        }

        public final boolean getClient() {
            return this.client;
        }

        public final BufferedSink getSink() {
            return this.sink;
        }

        public final BufferedSource getSource() {
            return this.source;
        }
    }

    private final class WriterTask extends Task {
        public WriterTask() {
            super(RealWebSocket.this.name + " writer", false, 2, (DefaultConstructorMarker) null);
        }

        public long runOnce() {
            try {
                if (RealWebSocket.this.writeOneFrame$okhttp()) {
                    return 0;
                }
                return -1;
            } catch (IOException e2) {
                RealWebSocket.this.failWebSocket(e2, (Response) null);
                return -1;
            }
        }
    }

    public RealWebSocket(TaskRunner taskRunner, Request request, WebSocketListener webSocketListener, Random random2, long j2, WebSocketExtensions webSocketExtensions, long j3) {
        Intrinsics.f(taskRunner, "taskRunner");
        Intrinsics.f(request, "originalRequest");
        Intrinsics.f(webSocketListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.f(random2, "random");
        this.originalRequest = request;
        this.listener = webSocketListener;
        this.random = random2;
        this.pingIntervalMillis = j2;
        this.extensions = webSocketExtensions;
        this.minimumDeflateSize = j3;
        this.taskQueue = taskRunner.newQueue();
        if (Intrinsics.a("GET", request.method())) {
            ByteString.Companion companion = ByteString.f41331e;
            byte[] bArr = new byte[16];
            random2.nextBytes(bArr);
            Unit unit = Unit.f40298a;
            this.key = ByteString.Companion.g(companion, bArr, 0, 0, 3, (Object) null).a();
            return;
        }
        throw new IllegalArgumentException(("Request must be GET: " + request.method()).toString());
    }

    /* access modifiers changed from: private */
    public final boolean isValid(WebSocketExtensions webSocketExtensions) {
        if (webSocketExtensions.unknownValues || webSocketExtensions.clientMaxWindowBits != null) {
            return false;
        }
        if (webSocketExtensions.serverMaxWindowBits == null || new IntRange(8, 15).contains(webSocketExtensions.serverMaxWindowBits.intValue())) {
            return true;
        }
        return false;
    }

    private final void runWriter() {
        if (!Util.assertionsEnabled || Thread.holdsLock(this)) {
            Task task = this.writerTask;
            if (task != null) {
                TaskQueue.schedule$default(this.taskQueue, task, 0, 2, (Object) null);
                return;
            }
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
    }

    public final void awaitTermination(long j2, TimeUnit timeUnit) throws InterruptedException {
        Intrinsics.f(timeUnit, "timeUnit");
        this.taskQueue.idleLatch().await(j2, timeUnit);
    }

    public void cancel() {
        Call call2 = this.call;
        Intrinsics.c(call2);
        call2.cancel();
    }

    public final void checkUpgradeSuccess$okhttp(Response response, Exchange exchange) throws IOException {
        Intrinsics.f(response, "response");
        if (response.code() == 101) {
            String header$default = Response.header$default(response, "Connection", (String) null, 2, (Object) null);
            if (StringsKt__StringsJVMKt.t("Upgrade", header$default, true)) {
                String header$default2 = Response.header$default(response, "Upgrade", (String) null, 2, (Object) null);
                if (StringsKt__StringsJVMKt.t("websocket", header$default2, true)) {
                    String header$default3 = Response.header$default(response, "Sec-WebSocket-Accept", (String) null, 2, (Object) null);
                    ByteString.Companion companion = ByteString.f41331e;
                    String a2 = companion.d(this.key + WebSocketProtocol.ACCEPT_MAGIC).t().a();
                    if (!Intrinsics.a(a2, header$default3)) {
                        throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + a2 + "' but was '" + header$default3 + '\'');
                    } else if (exchange == null) {
                        throw new ProtocolException("Web Socket exchange missing: bad interceptor?");
                    }
                } else {
                    throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + header$default2 + '\'');
                }
            } else {
                throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + header$default + '\'');
            }
        } else {
            throw new ProtocolException("Expected HTTP 101 response but was '" + response.code() + ' ' + response.message() + '\'');
        }
    }

    public boolean close(int i2, String str) {
        return close(i2, str, CANCEL_AFTER_CLOSE_MILLIS);
    }

    public final void connect(OkHttpClient okHttpClient) {
        Intrinsics.f(okHttpClient, "client");
        if (this.originalRequest.header("Sec-WebSocket-Extensions") != null) {
            failWebSocket(new ProtocolException("Request header not permitted: 'Sec-WebSocket-Extensions'"), (Response) null);
            return;
        }
        OkHttpClient build = okHttpClient.newBuilder().eventListener(EventListener.NONE).protocols(ONLY_HTTP1).build();
        Request build2 = this.originalRequest.newBuilder().header("Upgrade", "websocket").header("Connection", "Upgrade").header("Sec-WebSocket-Key", this.key).header("Sec-WebSocket-Version", "13").header("Sec-WebSocket-Extensions", "permessage-deflate").build();
        RealCall realCall = new RealCall(build, build2, true);
        this.call = realCall;
        Intrinsics.c(realCall);
        realCall.enqueue(new RealWebSocket$connect$1(this, build2));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r4.listener.onFailure(r4, r5, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0039, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003a, code lost:
        if (r0 != null) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003c, code lost:
        okhttp3.internal.Util.closeQuietly((java.io.Closeable) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003f, code lost:
        if (r2 != null) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0041, code lost:
        okhttp3.internal.Util.closeQuietly((java.io.Closeable) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0044, code lost:
        if (r3 != null) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0046, code lost:
        okhttp3.internal.Util.closeQuietly((java.io.Closeable) r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0049, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void failWebSocket(java.lang.Exception r5, okhttp3.Response r6) {
        /*
            r4 = this;
            java.lang.String r0 = "e"
            kotlin.jvm.internal.Intrinsics.f(r5, r0)
            monitor-enter(r4)
            boolean r0 = r4.failed     // Catch:{ all -> 0x004a }
            if (r0 == 0) goto L_0x000c
            monitor-exit(r4)
            return
        L_0x000c:
            r0 = 1
            r4.failed = r0     // Catch:{ all -> 0x004a }
            okhttp3.internal.ws.RealWebSocket$Streams r0 = r4.streams     // Catch:{ all -> 0x004a }
            r1 = 0
            r4.streams = r1     // Catch:{ all -> 0x004a }
            okhttp3.internal.ws.WebSocketReader r2 = r4.reader     // Catch:{ all -> 0x004a }
            r4.reader = r1     // Catch:{ all -> 0x004a }
            okhttp3.internal.ws.WebSocketWriter r3 = r4.writer     // Catch:{ all -> 0x004a }
            r4.writer = r1     // Catch:{ all -> 0x004a }
            okhttp3.internal.concurrent.TaskQueue r1 = r4.taskQueue     // Catch:{ all -> 0x004a }
            r1.shutdown()     // Catch:{ all -> 0x004a }
            kotlin.Unit r1 = kotlin.Unit.f40298a     // Catch:{ all -> 0x004a }
            monitor-exit(r4)
            okhttp3.WebSocketListener r1 = r4.listener     // Catch:{ all -> 0x0039 }
            r1.onFailure(r4, r5, r6)     // Catch:{ all -> 0x0039 }
            if (r0 == 0) goto L_0x002e
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r0)
        L_0x002e:
            if (r2 == 0) goto L_0x0033
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r2)
        L_0x0033:
            if (r3 == 0) goto L_0x0038
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r3)
        L_0x0038:
            return
        L_0x0039:
            r5 = move-exception
            if (r0 == 0) goto L_0x003f
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r0)
        L_0x003f:
            if (r2 == 0) goto L_0x0044
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r2)
        L_0x0044:
            if (r3 == 0) goto L_0x0049
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r3)
        L_0x0049:
            throw r5
        L_0x004a:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.RealWebSocket.failWebSocket(java.lang.Exception, okhttp3.Response):void");
    }

    public final WebSocketListener getListener$okhttp() {
        return this.listener;
    }

    public final void initReaderAndWriter(String str, Streams streams2) throws IOException {
        Intrinsics.f(str, "name");
        Intrinsics.f(streams2, "streams");
        WebSocketExtensions webSocketExtensions = this.extensions;
        Intrinsics.c(webSocketExtensions);
        synchronized (this) {
            this.name = str;
            this.streams = streams2;
            this.writer = new WebSocketWriter(streams2.getClient(), streams2.getSink(), this.random, webSocketExtensions.perMessageDeflate, webSocketExtensions.noContextTakeover(streams2.getClient()), this.minimumDeflateSize);
            this.writerTask = new WriterTask();
            long j2 = this.pingIntervalMillis;
            if (j2 != 0) {
                long nanos = TimeUnit.MILLISECONDS.toNanos(j2);
                TaskQueue taskQueue2 = this.taskQueue;
                taskQueue2.schedule(new RealWebSocket$initReaderAndWriter$lambda$3$$inlined$schedule$1(str + " ping", this, nanos), nanos);
            }
            if (!this.messageAndCloseQueue.isEmpty()) {
                runWriter();
            }
            Unit unit = Unit.f40298a;
        }
        this.reader = new WebSocketReader(streams2.getClient(), streams2.getSource(), this, webSocketExtensions.perMessageDeflate, webSocketExtensions.noContextTakeover(!streams2.getClient()));
    }

    public final void loopReader() throws IOException {
        while (this.receivedCloseCode == -1) {
            WebSocketReader webSocketReader = this.reader;
            Intrinsics.c(webSocketReader);
            webSocketReader.processNextFrame();
        }
    }

    /* JADX WARNING: type inference failed for: r1v1, types: [okhttp3.internal.ws.WebSocketWriter, okhttp3.internal.ws.WebSocketReader, okhttp3.internal.ws.RealWebSocket$Streams] */
    /* JADX WARNING: type inference failed for: r1v2, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onReadClose(int r5, java.lang.String r6) {
        /*
            r4 = this;
            java.lang.String r0 = "reason"
            kotlin.jvm.internal.Intrinsics.f(r6, r0)
            r0 = 1
            r1 = 0
            r2 = -1
            if (r5 == r2) goto L_0x000c
            r3 = 1
            goto L_0x000d
        L_0x000c:
            r3 = 0
        L_0x000d:
            if (r3 == 0) goto L_0x007d
            monitor-enter(r4)
            int r3 = r4.receivedCloseCode     // Catch:{ all -> 0x007a }
            if (r3 != r2) goto L_0x0015
            goto L_0x0016
        L_0x0015:
            r0 = 0
        L_0x0016:
            if (r0 == 0) goto L_0x006e
            r4.receivedCloseCode = r5     // Catch:{ all -> 0x007a }
            r4.receivedCloseReason = r6     // Catch:{ all -> 0x007a }
            boolean r0 = r4.enqueuedClose     // Catch:{ all -> 0x007a }
            r1 = 0
            if (r0 == 0) goto L_0x003c
            java.util.ArrayDeque<java.lang.Object> r0 = r4.messageAndCloseQueue     // Catch:{ all -> 0x007a }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x007a }
            if (r0 == 0) goto L_0x003c
            okhttp3.internal.ws.RealWebSocket$Streams r0 = r4.streams     // Catch:{ all -> 0x007a }
            r4.streams = r1     // Catch:{ all -> 0x007a }
            okhttp3.internal.ws.WebSocketReader r2 = r4.reader     // Catch:{ all -> 0x007a }
            r4.reader = r1     // Catch:{ all -> 0x007a }
            okhttp3.internal.ws.WebSocketWriter r3 = r4.writer     // Catch:{ all -> 0x007a }
            r4.writer = r1     // Catch:{ all -> 0x007a }
            okhttp3.internal.concurrent.TaskQueue r1 = r4.taskQueue     // Catch:{ all -> 0x007a }
            r1.shutdown()     // Catch:{ all -> 0x007a }
            r1 = r0
            goto L_0x003e
        L_0x003c:
            r2 = r1
            r3 = r2
        L_0x003e:
            kotlin.Unit r0 = kotlin.Unit.f40298a     // Catch:{ all -> 0x007a }
            monitor-exit(r4)
            okhttp3.WebSocketListener r0 = r4.listener     // Catch:{ all -> 0x005d }
            r0.onClosing(r4, r5, r6)     // Catch:{ all -> 0x005d }
            if (r1 == 0) goto L_0x004d
            okhttp3.WebSocketListener r0 = r4.listener     // Catch:{ all -> 0x005d }
            r0.onClosed(r4, r5, r6)     // Catch:{ all -> 0x005d }
        L_0x004d:
            if (r1 == 0) goto L_0x0052
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r1)
        L_0x0052:
            if (r2 == 0) goto L_0x0057
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r2)
        L_0x0057:
            if (r3 == 0) goto L_0x005c
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r3)
        L_0x005c:
            return
        L_0x005d:
            r5 = move-exception
            if (r1 == 0) goto L_0x0063
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r1)
        L_0x0063:
            if (r2 == 0) goto L_0x0068
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r2)
        L_0x0068:
            if (r3 == 0) goto L_0x006d
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r3)
        L_0x006d:
            throw r5
        L_0x006e:
            java.lang.String r5 = "already closed"
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException     // Catch:{ all -> 0x007a }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x007a }
            r6.<init>(r5)     // Catch:{ all -> 0x007a }
            throw r6     // Catch:{ all -> 0x007a }
        L_0x007a:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        L_0x007d:
            java.lang.String r5 = "Failed requirement."
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r5 = r5.toString()
            r6.<init>(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.RealWebSocket.onReadClose(int, java.lang.String):void");
    }

    public void onReadMessage(String str) throws IOException {
        Intrinsics.f(str, "text");
        this.listener.onMessage((WebSocket) this, str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0028, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onReadPing(okio.ByteString r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            java.lang.String r0 = "payload"
            kotlin.jvm.internal.Intrinsics.f(r2, r0)     // Catch:{ all -> 0x0029 }
            boolean r0 = r1.failed     // Catch:{ all -> 0x0029 }
            if (r0 != 0) goto L_0x0027
            boolean r0 = r1.enqueuedClose     // Catch:{ all -> 0x0029 }
            if (r0 == 0) goto L_0x0017
            java.util.ArrayDeque<java.lang.Object> r0 = r1.messageAndCloseQueue     // Catch:{ all -> 0x0029 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0029 }
            if (r0 == 0) goto L_0x0017
            goto L_0x0027
        L_0x0017:
            java.util.ArrayDeque<okio.ByteString> r0 = r1.pongQueue     // Catch:{ all -> 0x0029 }
            r0.add(r2)     // Catch:{ all -> 0x0029 }
            r1.runWriter()     // Catch:{ all -> 0x0029 }
            int r2 = r1.receivedPingCount     // Catch:{ all -> 0x0029 }
            int r2 = r2 + 1
            r1.receivedPingCount = r2     // Catch:{ all -> 0x0029 }
            monitor-exit(r1)
            return
        L_0x0027:
            monitor-exit(r1)
            return
        L_0x0029:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.RealWebSocket.onReadPing(okio.ByteString):void");
    }

    public synchronized void onReadPong(ByteString byteString) {
        Intrinsics.f(byteString, "payload");
        this.receivedPongCount++;
        this.awaitingPong = false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0023, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean pong(okio.ByteString r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            java.lang.String r0 = "payload"
            kotlin.jvm.internal.Intrinsics.f(r2, r0)     // Catch:{ all -> 0x0025 }
            boolean r0 = r1.failed     // Catch:{ all -> 0x0025 }
            if (r0 != 0) goto L_0x0022
            boolean r0 = r1.enqueuedClose     // Catch:{ all -> 0x0025 }
            if (r0 == 0) goto L_0x0017
            java.util.ArrayDeque<java.lang.Object> r0 = r1.messageAndCloseQueue     // Catch:{ all -> 0x0025 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0025 }
            if (r0 == 0) goto L_0x0017
            goto L_0x0022
        L_0x0017:
            java.util.ArrayDeque<okio.ByteString> r0 = r1.pongQueue     // Catch:{ all -> 0x0025 }
            r0.add(r2)     // Catch:{ all -> 0x0025 }
            r1.runWriter()     // Catch:{ all -> 0x0025 }
            monitor-exit(r1)
            r2 = 1
            return r2
        L_0x0022:
            monitor-exit(r1)
            r2 = 0
            return r2
        L_0x0025:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.RealWebSocket.pong(okio.ByteString):boolean");
    }

    public final boolean processNextFrame() throws IOException {
        try {
            WebSocketReader webSocketReader = this.reader;
            Intrinsics.c(webSocketReader);
            webSocketReader.processNextFrame();
            if (this.receivedCloseCode == -1) {
                return true;
            }
            return false;
        } catch (Exception e2) {
            failWebSocket(e2, (Response) null);
            return false;
        }
    }

    public synchronized long queueSize() {
        return this.queueSize;
    }

    public final synchronized int receivedPingCount() {
        return this.receivedPingCount;
    }

    public final synchronized int receivedPongCount() {
        return this.receivedPongCount;
    }

    public Request request() {
        return this.originalRequest;
    }

    public boolean send(String str) {
        Intrinsics.f(str, "text");
        return send(ByteString.f41331e.d(str), 1);
    }

    public final synchronized int sentPingCount() {
        return this.sentPingCount;
    }

    public final void tearDown() throws InterruptedException {
        this.taskQueue.shutdown();
        this.taskQueue.idleLatch().await(10, TimeUnit.SECONDS);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0078, code lost:
        if (r2 == null) goto L_0x0083;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        kotlin.jvm.internal.Intrinsics.c(r0);
        r0.writePong(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0085, code lost:
        if ((r4 instanceof okhttp3.internal.ws.RealWebSocket.Message) == false) goto L_0x00ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0087, code lost:
        r4 = (okhttp3.internal.ws.RealWebSocket.Message) r4;
        kotlin.jvm.internal.Intrinsics.c(r0);
        r0.writeMessageFrame(r4.getFormatOpcode(), r4.getData());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0097, code lost:
        monitor-enter(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        r12.queueSize -= (long) r4.getData().size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        monitor-exit(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00ad, code lost:
        if ((r4 instanceof okhttp3.internal.ws.RealWebSocket.Close) == false) goto L_0x00d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00af, code lost:
        r4 = (okhttp3.internal.ws.RealWebSocket.Close) r4;
        kotlin.jvm.internal.Intrinsics.c(r0);
        r0.writeClose(r4.getCode(), r4.getReason());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00bf, code lost:
        if (r5 == null) goto L_0x00c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00c1, code lost:
        r0 = r12.listener;
        kotlin.jvm.internal.Intrinsics.c(r7);
        r0.onClosed(r12, r1, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00c9, code lost:
        if (r5 == null) goto L_0x00ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00cb, code lost:
        okhttp3.internal.Util.closeQuietly((java.io.Closeable) r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00ce, code lost:
        if (r8 == null) goto L_0x00d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00d0, code lost:
        okhttp3.internal.Util.closeQuietly((java.io.Closeable) r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00d3, code lost:
        if (r9 == null) goto L_0x00d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00d5, code lost:
        okhttp3.internal.Util.closeQuietly((java.io.Closeable) r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00d8, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00de, code lost:
        throw new java.lang.AssertionError();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00df, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00e0, code lost:
        if (r5 != null) goto L_0x00e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00e2, code lost:
        okhttp3.internal.Util.closeQuietly((java.io.Closeable) r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00e5, code lost:
        if (r8 != null) goto L_0x00e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00e7, code lost:
        okhttp3.internal.Util.closeQuietly((java.io.Closeable) r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00ea, code lost:
        if (r9 != null) goto L_0x00ec;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00ec, code lost:
        okhttp3.internal.Util.closeQuietly((java.io.Closeable) r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00ef, code lost:
        throw r0;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean writeOneFrame$okhttp() throws java.io.IOException {
        /*
            r12 = this;
            monitor-enter(r12)
            boolean r0 = r12.failed     // Catch:{ all -> 0x00f0 }
            r1 = 0
            if (r0 == 0) goto L_0x0008
            monitor-exit(r12)
            return r1
        L_0x0008:
            okhttp3.internal.ws.WebSocketWriter r0 = r12.writer     // Catch:{ all -> 0x00f0 }
            java.util.ArrayDeque<okio.ByteString> r2 = r12.pongQueue     // Catch:{ all -> 0x00f0 }
            java.lang.Object r2 = r2.poll()     // Catch:{ all -> 0x00f0 }
            r3 = 1
            r4 = 0
            r5 = -1
            if (r2 != 0) goto L_0x0070
            java.util.ArrayDeque<java.lang.Object> r6 = r12.messageAndCloseQueue     // Catch:{ all -> 0x00f0 }
            java.lang.Object r6 = r6.poll()     // Catch:{ all -> 0x00f0 }
            boolean r7 = r6 instanceof okhttp3.internal.ws.RealWebSocket.Close     // Catch:{ all -> 0x00f0 }
            if (r7 == 0) goto L_0x0066
            int r1 = r12.receivedCloseCode     // Catch:{ all -> 0x00f0 }
            java.lang.String r7 = r12.receivedCloseReason     // Catch:{ all -> 0x00f0 }
            if (r1 == r5) goto L_0x0038
            okhttp3.internal.ws.RealWebSocket$Streams r5 = r12.streams     // Catch:{ all -> 0x00f0 }
            r12.streams = r4     // Catch:{ all -> 0x00f0 }
            okhttp3.internal.ws.WebSocketReader r8 = r12.reader     // Catch:{ all -> 0x00f0 }
            r12.reader = r4     // Catch:{ all -> 0x00f0 }
            okhttp3.internal.ws.WebSocketWriter r9 = r12.writer     // Catch:{ all -> 0x00f0 }
            r12.writer = r4     // Catch:{ all -> 0x00f0 }
            okhttp3.internal.concurrent.TaskQueue r4 = r12.taskQueue     // Catch:{ all -> 0x00f0 }
            r4.shutdown()     // Catch:{ all -> 0x00f0 }
        L_0x0036:
            r4 = r6
            goto L_0x0075
        L_0x0038:
            r5 = r6
            okhttp3.internal.ws.RealWebSocket$Close r5 = (okhttp3.internal.ws.RealWebSocket.Close) r5     // Catch:{ all -> 0x00f0 }
            long r8 = r5.getCancelAfterCloseMillis()     // Catch:{ all -> 0x00f0 }
            okhttp3.internal.concurrent.TaskQueue r5 = r12.taskQueue     // Catch:{ all -> 0x00f0 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f0 }
            r10.<init>()     // Catch:{ all -> 0x00f0 }
            java.lang.String r11 = r12.name     // Catch:{ all -> 0x00f0 }
            r10.append(r11)     // Catch:{ all -> 0x00f0 }
            java.lang.String r11 = " cancel"
            r10.append(r11)     // Catch:{ all -> 0x00f0 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x00f0 }
            java.util.concurrent.TimeUnit r11 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x00f0 }
            long r8 = r11.toNanos(r8)     // Catch:{ all -> 0x00f0 }
            okhttp3.internal.ws.RealWebSocket$writeOneFrame$lambda$8$$inlined$execute$default$1 r11 = new okhttp3.internal.ws.RealWebSocket$writeOneFrame$lambda$8$$inlined$execute$default$1     // Catch:{ all -> 0x00f0 }
            r11.<init>(r10, r3, r12)     // Catch:{ all -> 0x00f0 }
            r5.schedule(r11, r8)     // Catch:{ all -> 0x00f0 }
            r5 = r4
            r8 = r5
            r9 = r8
            goto L_0x0036
        L_0x0066:
            if (r6 != 0) goto L_0x006a
            monitor-exit(r12)
            return r1
        L_0x006a:
            r5 = r4
            r7 = r5
            r8 = r7
            r9 = r8
            r4 = r6
            goto L_0x0074
        L_0x0070:
            r5 = r4
            r7 = r5
            r8 = r7
            r9 = r8
        L_0x0074:
            r1 = -1
        L_0x0075:
            kotlin.Unit r6 = kotlin.Unit.f40298a     // Catch:{ all -> 0x00f0 }
            monitor-exit(r12)
            if (r2 == 0) goto L_0x0083
            kotlin.jvm.internal.Intrinsics.c(r0)     // Catch:{ all -> 0x00df }
            okio.ByteString r2 = (okio.ByteString) r2     // Catch:{ all -> 0x00df }
            r0.writePong(r2)     // Catch:{ all -> 0x00df }
            goto L_0x00c9
        L_0x0083:
            boolean r2 = r4 instanceof okhttp3.internal.ws.RealWebSocket.Message     // Catch:{ all -> 0x00df }
            if (r2 == 0) goto L_0x00ab
            okhttp3.internal.ws.RealWebSocket$Message r4 = (okhttp3.internal.ws.RealWebSocket.Message) r4     // Catch:{ all -> 0x00df }
            kotlin.jvm.internal.Intrinsics.c(r0)     // Catch:{ all -> 0x00df }
            int r1 = r4.getFormatOpcode()     // Catch:{ all -> 0x00df }
            okio.ByteString r2 = r4.getData()     // Catch:{ all -> 0x00df }
            r0.writeMessageFrame(r1, r2)     // Catch:{ all -> 0x00df }
            monitor-enter(r12)     // Catch:{ all -> 0x00df }
            long r0 = r12.queueSize     // Catch:{ all -> 0x00a8 }
            okio.ByteString r2 = r4.getData()     // Catch:{ all -> 0x00a8 }
            int r2 = r2.size()     // Catch:{ all -> 0x00a8 }
            long r6 = (long) r2     // Catch:{ all -> 0x00a8 }
            long r0 = r0 - r6
            r12.queueSize = r0     // Catch:{ all -> 0x00a8 }
            monitor-exit(r12)     // Catch:{ all -> 0x00df }
            goto L_0x00c9
        L_0x00a8:
            r0 = move-exception
            monitor-exit(r12)     // Catch:{ all -> 0x00df }
            throw r0     // Catch:{ all -> 0x00df }
        L_0x00ab:
            boolean r2 = r4 instanceof okhttp3.internal.ws.RealWebSocket.Close     // Catch:{ all -> 0x00df }
            if (r2 == 0) goto L_0x00d9
            okhttp3.internal.ws.RealWebSocket$Close r4 = (okhttp3.internal.ws.RealWebSocket.Close) r4     // Catch:{ all -> 0x00df }
            kotlin.jvm.internal.Intrinsics.c(r0)     // Catch:{ all -> 0x00df }
            int r2 = r4.getCode()     // Catch:{ all -> 0x00df }
            okio.ByteString r4 = r4.getReason()     // Catch:{ all -> 0x00df }
            r0.writeClose(r2, r4)     // Catch:{ all -> 0x00df }
            if (r5 == 0) goto L_0x00c9
            okhttp3.WebSocketListener r0 = r12.listener     // Catch:{ all -> 0x00df }
            kotlin.jvm.internal.Intrinsics.c(r7)     // Catch:{ all -> 0x00df }
            r0.onClosed(r12, r1, r7)     // Catch:{ all -> 0x00df }
        L_0x00c9:
            if (r5 == 0) goto L_0x00ce
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r5)
        L_0x00ce:
            if (r8 == 0) goto L_0x00d3
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r8)
        L_0x00d3:
            if (r9 == 0) goto L_0x00d8
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r9)
        L_0x00d8:
            return r3
        L_0x00d9:
            java.lang.AssertionError r0 = new java.lang.AssertionError     // Catch:{ all -> 0x00df }
            r0.<init>()     // Catch:{ all -> 0x00df }
            throw r0     // Catch:{ all -> 0x00df }
        L_0x00df:
            r0 = move-exception
            if (r5 == 0) goto L_0x00e5
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r5)
        L_0x00e5:
            if (r8 == 0) goto L_0x00ea
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r8)
        L_0x00ea:
            if (r9 == 0) goto L_0x00ef
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r9)
        L_0x00ef:
            throw r0
        L_0x00f0:
            r0 = move-exception
            monitor-exit(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.RealWebSocket.writeOneFrame$okhttp():boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0022, code lost:
        if (r1 == -1) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0024, code lost:
        failWebSocket(new java.net.SocketTimeoutException("sent ping but didn't receive pong within " + r7.pingIntervalMillis + "ms (after " + (r1 - 1) + " successful ping/pongs)"), (okhttp3.Response) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004d, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r0.writePing(okio.ByteString.f41332f);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0054, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0055, code lost:
        failWebSocket(r0, (okhttp3.Response) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void writePingFrame$okhttp() {
        /*
            r7 = this;
            monitor-enter(r7)
            boolean r0 = r7.failed     // Catch:{ all -> 0x0059 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r7)
            return
        L_0x0007:
            okhttp3.internal.ws.WebSocketWriter r0 = r7.writer     // Catch:{ all -> 0x0059 }
            if (r0 != 0) goto L_0x000d
            monitor-exit(r7)
            return
        L_0x000d:
            boolean r1 = r7.awaitingPong     // Catch:{ all -> 0x0059 }
            r2 = -1
            if (r1 == 0) goto L_0x0015
            int r1 = r7.sentPingCount     // Catch:{ all -> 0x0059 }
            goto L_0x0016
        L_0x0015:
            r1 = -1
        L_0x0016:
            int r3 = r7.sentPingCount     // Catch:{ all -> 0x0059 }
            r4 = 1
            int r3 = r3 + r4
            r7.sentPingCount = r3     // Catch:{ all -> 0x0059 }
            r7.awaitingPong = r4     // Catch:{ all -> 0x0059 }
            kotlin.Unit r3 = kotlin.Unit.f40298a     // Catch:{ all -> 0x0059 }
            monitor-exit(r7)
            r3 = 0
            if (r1 == r2) goto L_0x004e
            java.net.SocketTimeoutException r0 = new java.net.SocketTimeoutException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "sent ping but didn't receive pong within "
            r2.append(r5)
            long r5 = r7.pingIntervalMillis
            r2.append(r5)
            java.lang.String r5 = "ms (after "
            r2.append(r5)
            int r1 = r1 - r4
            r2.append(r1)
            java.lang.String r1 = " successful ping/pongs)"
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            r7.failWebSocket(r0, r3)
            return
        L_0x004e:
            okio.ByteString r1 = okio.ByteString.f41332f     // Catch:{ IOException -> 0x0054 }
            r0.writePing(r1)     // Catch:{ IOException -> 0x0054 }
            goto L_0x0058
        L_0x0054:
            r0 = move-exception
            r7.failWebSocket(r0, r3)
        L_0x0058:
            return
        L_0x0059:
            r0 = move-exception
            monitor-exit(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.RealWebSocket.writePingFrame$okhttp():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0058, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean close(int r9, java.lang.String r10, long r11) {
        /*
            r8 = this;
            monitor-enter(r8)
            okhttp3.internal.ws.WebSocketProtocol r0 = okhttp3.internal.ws.WebSocketProtocol.INSTANCE     // Catch:{ all -> 0x0059 }
            r0.validateCloseCode(r9)     // Catch:{ all -> 0x0059 }
            r0 = 0
            r1 = 1
            if (r10 == 0) goto L_0x003c
            okio.ByteString$Companion r2 = okio.ByteString.f41331e     // Catch:{ all -> 0x0059 }
            okio.ByteString r2 = r2.d(r10)     // Catch:{ all -> 0x0059 }
            int r3 = r2.size()     // Catch:{ all -> 0x0059 }
            long r3 = (long) r3     // Catch:{ all -> 0x0059 }
            r5 = 123(0x7b, double:6.1E-322)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 > 0) goto L_0x001d
            r3 = 1
            goto L_0x001e
        L_0x001d:
            r3 = 0
        L_0x001e:
            if (r3 == 0) goto L_0x0021
            goto L_0x003d
        L_0x0021:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0059 }
            r9.<init>()     // Catch:{ all -> 0x0059 }
            java.lang.String r11 = "reason.size() > 123: "
            r9.append(r11)     // Catch:{ all -> 0x0059 }
            r9.append(r10)     // Catch:{ all -> 0x0059 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0059 }
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0059 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0059 }
            r10.<init>(r9)     // Catch:{ all -> 0x0059 }
            throw r10     // Catch:{ all -> 0x0059 }
        L_0x003c:
            r2 = 0
        L_0x003d:
            boolean r10 = r8.failed     // Catch:{ all -> 0x0059 }
            if (r10 != 0) goto L_0x0057
            boolean r10 = r8.enqueuedClose     // Catch:{ all -> 0x0059 }
            if (r10 == 0) goto L_0x0046
            goto L_0x0057
        L_0x0046:
            r8.enqueuedClose = r1     // Catch:{ all -> 0x0059 }
            java.util.ArrayDeque<java.lang.Object> r10 = r8.messageAndCloseQueue     // Catch:{ all -> 0x0059 }
            okhttp3.internal.ws.RealWebSocket$Close r0 = new okhttp3.internal.ws.RealWebSocket$Close     // Catch:{ all -> 0x0059 }
            r0.<init>(r9, r2, r11)     // Catch:{ all -> 0x0059 }
            r10.add(r0)     // Catch:{ all -> 0x0059 }
            r8.runWriter()     // Catch:{ all -> 0x0059 }
            monitor-exit(r8)
            return r1
        L_0x0057:
            monitor-exit(r8)
            return r0
        L_0x0059:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.RealWebSocket.close(int, java.lang.String, long):boolean");
    }

    public void onReadMessage(ByteString byteString) throws IOException {
        Intrinsics.f(byteString, "bytes");
        this.listener.onMessage((WebSocket) this, byteString);
    }

    public boolean send(ByteString byteString) {
        Intrinsics.f(byteString, "bytes");
        return send(byteString, 2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003d, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized boolean send(okio.ByteString r7, int r8) {
        /*
            r6 = this;
            monitor-enter(r6)
            boolean r0 = r6.failed     // Catch:{ all -> 0x003e }
            r1 = 0
            if (r0 != 0) goto L_0x003c
            boolean r0 = r6.enqueuedClose     // Catch:{ all -> 0x003e }
            if (r0 == 0) goto L_0x000b
            goto L_0x003c
        L_0x000b:
            long r2 = r6.queueSize     // Catch:{ all -> 0x003e }
            int r0 = r7.size()     // Catch:{ all -> 0x003e }
            long r4 = (long) r0     // Catch:{ all -> 0x003e }
            long r2 = r2 + r4
            r4 = 16777216(0x1000000, double:8.289046E-317)
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x0022
            r7 = 1001(0x3e9, float:1.403E-42)
            r8 = 0
            r6.close(r7, r8)     // Catch:{ all -> 0x003e }
            monitor-exit(r6)
            return r1
        L_0x0022:
            long r0 = r6.queueSize     // Catch:{ all -> 0x003e }
            int r2 = r7.size()     // Catch:{ all -> 0x003e }
            long r2 = (long) r2     // Catch:{ all -> 0x003e }
            long r0 = r0 + r2
            r6.queueSize = r0     // Catch:{ all -> 0x003e }
            java.util.ArrayDeque<java.lang.Object> r0 = r6.messageAndCloseQueue     // Catch:{ all -> 0x003e }
            okhttp3.internal.ws.RealWebSocket$Message r1 = new okhttp3.internal.ws.RealWebSocket$Message     // Catch:{ all -> 0x003e }
            r1.<init>(r8, r7)     // Catch:{ all -> 0x003e }
            r0.add(r1)     // Catch:{ all -> 0x003e }
            r6.runWriter()     // Catch:{ all -> 0x003e }
            monitor-exit(r6)
            r7 = 1
            return r7
        L_0x003c:
            monitor-exit(r6)
            return r1
        L_0x003e:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.RealWebSocket.send(okio.ByteString, int):boolean");
    }
}
