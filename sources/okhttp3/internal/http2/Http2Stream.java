package okhttp3.internal.http2;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.internal.Util;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class Http2Stream {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final long EMIT_BUFFER_SIZE = 16384;
    private final Http2Connection connection;
    private ErrorCode errorCode;
    private IOException errorException;
    private boolean hasResponseHeaders;
    private final ArrayDeque<Headers> headersQueue;
    private final int id;
    private long readBytesAcknowledged;
    private long readBytesTotal;
    private final StreamTimeout readTimeout = new StreamTimeout();
    private final FramingSink sink;
    private final FramingSource source;
    private long writeBytesMaximum;
    private long writeBytesTotal;
    private final StreamTimeout writeTimeout = new StreamTimeout();

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final class FramingSource implements Source {
        private boolean closed;
        private boolean finished;
        private final long maxByteCount;
        private final Buffer readBuffer = new Buffer();
        private final Buffer receiveBuffer = new Buffer();
        private Headers trailers;

        public FramingSource(long j2, boolean z2) {
            this.maxByteCount = j2;
            this.finished = z2;
        }

        private final void updateConnectionFlowControl(long j2) {
            Http2Stream http2Stream = Http2Stream.this;
            if (!Util.assertionsEnabled || !Thread.holdsLock(http2Stream)) {
                Http2Stream.this.getConnection().updateConnectionFlowControl$okhttp(j2);
                return;
            }
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + http2Stream);
        }

        public void close() throws IOException {
            long size;
            Http2Stream http2Stream = Http2Stream.this;
            synchronized (http2Stream) {
                this.closed = true;
                size = this.readBuffer.size();
                this.readBuffer.a();
                Intrinsics.d(http2Stream, "null cannot be cast to non-null type java.lang.Object");
                http2Stream.notifyAll();
                Unit unit = Unit.f40298a;
            }
            if (size > 0) {
                updateConnectionFlowControl(size);
            }
            Http2Stream.this.cancelStreamIfNecessary$okhttp();
        }

        public final boolean getClosed$okhttp() {
            return this.closed;
        }

        public final boolean getFinished$okhttp() {
            return this.finished;
        }

        public final Buffer getReadBuffer() {
            return this.readBuffer;
        }

        public final Buffer getReceiveBuffer() {
            return this.receiveBuffer;
        }

        public final Headers getTrailers() {
            return this.trailers;
        }

        /* JADX INFO: finally extract failed */
        public long read(Buffer buffer, long j2) throws IOException {
            boolean z2;
            Throwable th;
            long j3;
            boolean z3;
            Buffer buffer2 = buffer;
            long j4 = j2;
            Intrinsics.f(buffer2, "sink");
            long j5 = 0;
            if (j4 >= 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                while (true) {
                    Http2Stream http2Stream = Http2Stream.this;
                    synchronized (http2Stream) {
                        http2Stream.getReadTimeout$okhttp().enter();
                        try {
                            if (http2Stream.getErrorCode$okhttp() == null || this.finished) {
                                th = null;
                            } else {
                                th = http2Stream.getErrorException$okhttp();
                                if (th == null) {
                                    ErrorCode errorCode$okhttp = http2Stream.getErrorCode$okhttp();
                                    Intrinsics.c(errorCode$okhttp);
                                    th = new StreamResetException(errorCode$okhttp);
                                }
                            }
                            if (!this.closed) {
                                if (this.readBuffer.size() > j5) {
                                    Buffer buffer3 = this.readBuffer;
                                    j3 = buffer3.read(buffer2, Math.min(j4, buffer3.size()));
                                    http2Stream.setReadBytesTotal$okhttp(http2Stream.getReadBytesTotal() + j3);
                                    long readBytesTotal = http2Stream.getReadBytesTotal() - http2Stream.getReadBytesAcknowledged();
                                    if (th == null && readBytesTotal >= ((long) (http2Stream.getConnection().getOkHttpSettings().getInitialWindowSize() / 2))) {
                                        http2Stream.getConnection().writeWindowUpdateLater$okhttp(http2Stream.getId(), readBytesTotal);
                                        http2Stream.setReadBytesAcknowledged$okhttp(http2Stream.getReadBytesTotal());
                                    }
                                } else if (this.finished || th != null) {
                                    j3 = -1;
                                } else {
                                    http2Stream.waitForIo$okhttp();
                                    j3 = -1;
                                    z3 = true;
                                    http2Stream.getReadTimeout$okhttp().exitAndThrowIfTimedOut();
                                    Unit unit = Unit.f40298a;
                                }
                                z3 = false;
                                http2Stream.getReadTimeout$okhttp().exitAndThrowIfTimedOut();
                                Unit unit2 = Unit.f40298a;
                            } else {
                                throw new IOException("stream closed");
                            }
                        } catch (Throwable th2) {
                            http2Stream.getReadTimeout$okhttp().exitAndThrowIfTimedOut();
                            throw th2;
                        }
                    }
                    if (z3) {
                        j5 = 0;
                    } else if (j3 != -1) {
                        return j3;
                    } else {
                        if (th == null) {
                            return -1;
                        }
                        throw th;
                    }
                }
            } else {
                throw new IllegalArgumentException(("byteCount < 0: " + j4).toString());
            }
        }

        public final void receive$okhttp(BufferedSource bufferedSource, long j2) throws IOException {
            boolean z2;
            boolean z3;
            boolean z4;
            BufferedSource bufferedSource2 = bufferedSource;
            Intrinsics.f(bufferedSource2, "source");
            Http2Stream http2Stream = Http2Stream.this;
            if (!Util.assertionsEnabled || !Thread.holdsLock(http2Stream)) {
                long j3 = j2;
                while (j3 > 0) {
                    synchronized (Http2Stream.this) {
                        z2 = this.finished;
                        z3 = true;
                        if (this.readBuffer.size() + j3 > this.maxByteCount) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        Unit unit = Unit.f40298a;
                    }
                    if (z4) {
                        bufferedSource2.skip(j3);
                        Http2Stream.this.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
                        return;
                    } else if (z2) {
                        bufferedSource2.skip(j3);
                        return;
                    } else {
                        long read = bufferedSource2.read(this.receiveBuffer, j3);
                        if (read != -1) {
                            j3 -= read;
                            Http2Stream http2Stream2 = Http2Stream.this;
                            synchronized (http2Stream2) {
                                if (this.closed) {
                                    this.receiveBuffer.a();
                                } else {
                                    if (this.readBuffer.size() != 0) {
                                        z3 = false;
                                    }
                                    this.readBuffer.y(this.receiveBuffer);
                                    if (z3) {
                                        Intrinsics.d(http2Stream2, "null cannot be cast to non-null type java.lang.Object");
                                        http2Stream2.notifyAll();
                                    }
                                }
                            }
                        } else {
                            throw new EOFException();
                        }
                    }
                }
                updateConnectionFlowControl(j2);
                return;
            }
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + http2Stream);
        }

        public final void setClosed$okhttp(boolean z2) {
            this.closed = z2;
        }

        public final void setFinished$okhttp(boolean z2) {
            this.finished = z2;
        }

        public final void setTrailers(Headers headers) {
            this.trailers = headers;
        }

        public Timeout timeout() {
            return Http2Stream.this.getReadTimeout$okhttp();
        }
    }

    public final class StreamTimeout extends AsyncTimeout {
        public StreamTimeout() {
        }

        public final void exitAndThrowIfTimedOut() throws IOException {
            if (exit()) {
                throw newTimeoutException((IOException) null);
            }
        }

        /* access modifiers changed from: protected */
        public IOException newTimeoutException(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        /* access modifiers changed from: protected */
        public void timedOut() {
            Http2Stream.this.closeLater(ErrorCode.CANCEL);
            Http2Stream.this.getConnection().sendDegradedPingLater$okhttp();
        }
    }

    public Http2Stream(int i2, Http2Connection http2Connection, boolean z2, boolean z3, Headers headers) {
        Intrinsics.f(http2Connection, "connection");
        this.id = i2;
        this.connection = http2Connection;
        this.writeBytesMaximum = (long) http2Connection.getPeerSettings().getInitialWindowSize();
        ArrayDeque<Headers> arrayDeque = new ArrayDeque<>();
        this.headersQueue = arrayDeque;
        this.source = new FramingSource((long) http2Connection.getOkHttpSettings().getInitialWindowSize(), z3);
        this.sink = new FramingSink(z2);
        if (headers != null) {
            if (!isLocallyInitiated()) {
                arrayDeque.add(headers);
                return;
            }
            throw new IllegalStateException("locally-initiated streams shouldn't have headers yet".toString());
        } else if (!isLocallyInitiated()) {
            throw new IllegalStateException("remotely-initiated streams should have headers".toString());
        }
    }

    private final boolean closeInternal(ErrorCode errorCode2, IOException iOException) {
        if (!Util.assertionsEnabled || !Thread.holdsLock(this)) {
            synchronized (this) {
                if (this.errorCode != null) {
                    return false;
                }
                this.errorCode = errorCode2;
                this.errorException = iOException;
                Intrinsics.d(this, "null cannot be cast to non-null type java.lang.Object");
                notifyAll();
                if (this.source.getFinished$okhttp() && this.sink.getFinished()) {
                    return false;
                }
                Unit unit = Unit.f40298a;
                this.connection.removeStream$okhttp(this.id);
                return true;
            }
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }

    public final void addBytesToWriteWindow(long j2) {
        this.writeBytesMaximum += j2;
        if (j2 > 0) {
            Intrinsics.d(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
        }
    }

    public final void cancelStreamIfNecessary$okhttp() throws IOException {
        boolean z2;
        boolean isOpen;
        if (!Util.assertionsEnabled || !Thread.holdsLock(this)) {
            synchronized (this) {
                if (this.source.getFinished$okhttp() || !this.source.getClosed$okhttp() || (!this.sink.getFinished() && !this.sink.getClosed())) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                isOpen = isOpen();
                Unit unit = Unit.f40298a;
            }
            if (z2) {
                close(ErrorCode.CANCEL, (IOException) null);
            } else if (!isOpen) {
                this.connection.removeStream$okhttp(this.id);
            }
        } else {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
    }

    public final void checkOutNotClosed$okhttp() throws IOException {
        if (this.sink.getClosed()) {
            throw new IOException("stream closed");
        } else if (this.sink.getFinished()) {
            throw new IOException("stream finished");
        } else if (this.errorCode != null) {
            Throwable th = this.errorException;
            if (th == null) {
                ErrorCode errorCode2 = this.errorCode;
                Intrinsics.c(errorCode2);
                th = new StreamResetException(errorCode2);
            }
            throw th;
        }
    }

    public final void close(ErrorCode errorCode2, IOException iOException) throws IOException {
        Intrinsics.f(errorCode2, "rstStatusCode");
        if (closeInternal(errorCode2, iOException)) {
            this.connection.writeSynReset$okhttp(this.id, errorCode2);
        }
    }

    public final void closeLater(ErrorCode errorCode2) {
        Intrinsics.f(errorCode2, "errorCode");
        if (closeInternal(errorCode2, (IOException) null)) {
            this.connection.writeSynResetLater$okhttp(this.id, errorCode2);
        }
    }

    public final void enqueueTrailers(Headers headers) {
        Intrinsics.f(headers, "trailers");
        synchronized (this) {
            boolean z2 = true;
            if (!this.sink.getFinished()) {
                if (headers.size() == 0) {
                    z2 = false;
                }
                if (z2) {
                    this.sink.setTrailers(headers);
                    Unit unit = Unit.f40298a;
                } else {
                    throw new IllegalArgumentException("trailers.size() == 0".toString());
                }
            } else {
                throw new IllegalStateException("already finished".toString());
            }
        }
    }

    public final Http2Connection getConnection() {
        return this.connection;
    }

    public final synchronized ErrorCode getErrorCode$okhttp() {
        return this.errorCode;
    }

    public final IOException getErrorException$okhttp() {
        return this.errorException;
    }

    public final int getId() {
        return this.id;
    }

    public final long getReadBytesAcknowledged() {
        return this.readBytesAcknowledged;
    }

    public final long getReadBytesTotal() {
        return this.readBytesTotal;
    }

    public final StreamTimeout getReadTimeout$okhttp() {
        return this.readTimeout;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0011  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0017  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final okio.Sink getSink() {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.hasResponseHeaders     // Catch:{ all -> 0x0023 }
            if (r0 != 0) goto L_0x000e
            boolean r0 = r2.isLocallyInitiated()     // Catch:{ all -> 0x0023 }
            if (r0 == 0) goto L_0x000c
            goto L_0x000e
        L_0x000c:
            r0 = 0
            goto L_0x000f
        L_0x000e:
            r0 = 1
        L_0x000f:
            if (r0 == 0) goto L_0x0017
            kotlin.Unit r0 = kotlin.Unit.f40298a     // Catch:{ all -> 0x0023 }
            monitor-exit(r2)
            okhttp3.internal.http2.Http2Stream$FramingSink r0 = r2.sink
            return r0
        L_0x0017:
            java.lang.String r0 = "reply before requesting the sink"
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0023 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0023 }
            r1.<init>(r0)     // Catch:{ all -> 0x0023 }
            throw r1     // Catch:{ all -> 0x0023 }
        L_0x0023:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Stream.getSink():okio.Sink");
    }

    public final FramingSink getSink$okhttp() {
        return this.sink;
    }

    public final Source getSource() {
        return this.source;
    }

    public final FramingSource getSource$okhttp() {
        return this.source;
    }

    public final long getWriteBytesMaximum() {
        return this.writeBytesMaximum;
    }

    public final long getWriteBytesTotal() {
        return this.writeBytesTotal;
    }

    public final StreamTimeout getWriteTimeout$okhttp() {
        return this.writeTimeout;
    }

    public final boolean isLocallyInitiated() {
        boolean z2;
        if ((this.id & 1) == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.connection.getClient$okhttp() == z2) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x002f, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean isOpen() {
        /*
            r2 = this;
            monitor-enter(r2)
            okhttp3.internal.http2.ErrorCode r0 = r2.errorCode     // Catch:{ all -> 0x0031 }
            r1 = 0
            if (r0 == 0) goto L_0x0008
            monitor-exit(r2)
            return r1
        L_0x0008:
            okhttp3.internal.http2.Http2Stream$FramingSource r0 = r2.source     // Catch:{ all -> 0x0031 }
            boolean r0 = r0.getFinished$okhttp()     // Catch:{ all -> 0x0031 }
            if (r0 != 0) goto L_0x0018
            okhttp3.internal.http2.Http2Stream$FramingSource r0 = r2.source     // Catch:{ all -> 0x0031 }
            boolean r0 = r0.getClosed$okhttp()     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x002e
        L_0x0018:
            okhttp3.internal.http2.Http2Stream$FramingSink r0 = r2.sink     // Catch:{ all -> 0x0031 }
            boolean r0 = r0.getFinished()     // Catch:{ all -> 0x0031 }
            if (r0 != 0) goto L_0x0028
            okhttp3.internal.http2.Http2Stream$FramingSink r0 = r2.sink     // Catch:{ all -> 0x0031 }
            boolean r0 = r0.getClosed()     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x002e
        L_0x0028:
            boolean r0 = r2.hasResponseHeaders     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x002e
            monitor-exit(r2)
            return r1
        L_0x002e:
            monitor-exit(r2)
            r0 = 1
            return r0
        L_0x0031:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Stream.isOpen():boolean");
    }

    public final Timeout readTimeout() {
        return this.readTimeout;
    }

    public final void receiveData(BufferedSource bufferedSource, int i2) throws IOException {
        Intrinsics.f(bufferedSource, "source");
        if (!Util.assertionsEnabled || !Thread.holdsLock(this)) {
            this.source.receive$okhttp(bufferedSource, (long) i2);
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x004f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void receiveHeaders(okhttp3.Headers r3, boolean r4) {
        /*
            r2 = this;
            java.lang.String r0 = "headers"
            kotlin.jvm.internal.Intrinsics.f(r3, r0)
            boolean r0 = okhttp3.internal.Util.assertionsEnabled
            if (r0 == 0) goto L_0x0037
            boolean r0 = java.lang.Thread.holdsLock(r2)
            if (r0 != 0) goto L_0x0010
            goto L_0x0037
        L_0x0010:
            java.lang.AssertionError r3 = new java.lang.AssertionError
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r0 = "Thread "
            r4.append(r0)
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            java.lang.String r0 = r0.getName()
            r4.append(r0)
            java.lang.String r0 = " MUST NOT hold lock on "
            r4.append(r0)
            r4.append(r2)
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            throw r3
        L_0x0037:
            monitor-enter(r2)
            boolean r0 = r2.hasResponseHeaders     // Catch:{ all -> 0x006d }
            r1 = 1
            if (r0 == 0) goto L_0x0046
            if (r4 != 0) goto L_0x0040
            goto L_0x0046
        L_0x0040:
            okhttp3.internal.http2.Http2Stream$FramingSource r0 = r2.source     // Catch:{ all -> 0x006d }
            r0.setTrailers(r3)     // Catch:{ all -> 0x006d }
            goto L_0x004d
        L_0x0046:
            r2.hasResponseHeaders = r1     // Catch:{ all -> 0x006d }
            java.util.ArrayDeque<okhttp3.Headers> r0 = r2.headersQueue     // Catch:{ all -> 0x006d }
            r0.add(r3)     // Catch:{ all -> 0x006d }
        L_0x004d:
            if (r4 == 0) goto L_0x0054
            okhttp3.internal.http2.Http2Stream$FramingSource r3 = r2.source     // Catch:{ all -> 0x006d }
            r3.setFinished$okhttp(r1)     // Catch:{ all -> 0x006d }
        L_0x0054:
            boolean r3 = r2.isOpen()     // Catch:{ all -> 0x006d }
            java.lang.String r4 = "null cannot be cast to non-null type java.lang.Object"
            kotlin.jvm.internal.Intrinsics.d(r2, r4)     // Catch:{ all -> 0x006d }
            r2.notifyAll()     // Catch:{ all -> 0x006d }
            kotlin.Unit r4 = kotlin.Unit.f40298a     // Catch:{ all -> 0x006d }
            monitor-exit(r2)
            if (r3 != 0) goto L_0x006c
            okhttp3.internal.http2.Http2Connection r3 = r2.connection
            int r4 = r2.id
            r3.removeStream$okhttp(r4)
        L_0x006c:
            return
        L_0x006d:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Stream.receiveHeaders(okhttp3.Headers, boolean):void");
    }

    public final synchronized void receiveRstStream(ErrorCode errorCode2) {
        Intrinsics.f(errorCode2, "errorCode");
        if (this.errorCode == null) {
            this.errorCode = errorCode2;
            Intrinsics.d(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
        }
    }

    public final void setErrorCode$okhttp(ErrorCode errorCode2) {
        this.errorCode = errorCode2;
    }

    public final void setErrorException$okhttp(IOException iOException) {
        this.errorException = iOException;
    }

    public final void setReadBytesAcknowledged$okhttp(long j2) {
        this.readBytesAcknowledged = j2;
    }

    public final void setReadBytesTotal$okhttp(long j2) {
        this.readBytesTotal = j2;
    }

    public final void setWriteBytesMaximum$okhttp(long j2) {
        this.writeBytesMaximum = j2;
    }

    public final void setWriteBytesTotal$okhttp(long j2) {
        this.writeBytesTotal = j2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0044, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0045, code lost:
        r2.readTimeout.exitAndThrowIfTimedOut();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004a, code lost:
        throw r0;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized okhttp3.Headers takeHeaders() throws java.io.IOException {
        /*
            r2 = this;
            monitor-enter(r2)
            okhttp3.internal.http2.Http2Stream$StreamTimeout r0 = r2.readTimeout     // Catch:{ all -> 0x004b }
            r0.enter()     // Catch:{ all -> 0x004b }
        L_0x0006:
            java.util.ArrayDeque<okhttp3.Headers> r0 = r2.headersQueue     // Catch:{ all -> 0x0044 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0044 }
            if (r0 == 0) goto L_0x0016
            okhttp3.internal.http2.ErrorCode r0 = r2.errorCode     // Catch:{ all -> 0x0044 }
            if (r0 != 0) goto L_0x0016
            r2.waitForIo$okhttp()     // Catch:{ all -> 0x0044 }
            goto L_0x0006
        L_0x0016:
            okhttp3.internal.http2.Http2Stream$StreamTimeout r0 = r2.readTimeout     // Catch:{ all -> 0x004b }
            r0.exitAndThrowIfTimedOut()     // Catch:{ all -> 0x004b }
            java.util.ArrayDeque<okhttp3.Headers> r0 = r2.headersQueue     // Catch:{ all -> 0x004b }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x004b }
            r0 = r0 ^ 1
            if (r0 == 0) goto L_0x0034
            java.util.ArrayDeque<okhttp3.Headers> r0 = r2.headersQueue     // Catch:{ all -> 0x004b }
            java.lang.Object r0 = r0.removeFirst()     // Catch:{ all -> 0x004b }
            java.lang.String r1 = "headersQueue.removeFirst()"
            kotlin.jvm.internal.Intrinsics.e(r0, r1)     // Catch:{ all -> 0x004b }
            okhttp3.Headers r0 = (okhttp3.Headers) r0     // Catch:{ all -> 0x004b }
            monitor-exit(r2)
            return r0
        L_0x0034:
            java.io.IOException r0 = r2.errorException     // Catch:{ all -> 0x004b }
            if (r0 == 0) goto L_0x0039
            goto L_0x0043
        L_0x0039:
            okhttp3.internal.http2.StreamResetException r0 = new okhttp3.internal.http2.StreamResetException     // Catch:{ all -> 0x004b }
            okhttp3.internal.http2.ErrorCode r1 = r2.errorCode     // Catch:{ all -> 0x004b }
            kotlin.jvm.internal.Intrinsics.c(r1)     // Catch:{ all -> 0x004b }
            r0.<init>(r1)     // Catch:{ all -> 0x004b }
        L_0x0043:
            throw r0     // Catch:{ all -> 0x004b }
        L_0x0044:
            r0 = move-exception
            okhttp3.internal.http2.Http2Stream$StreamTimeout r1 = r2.readTimeout     // Catch:{ all -> 0x004b }
            r1.exitAndThrowIfTimedOut()     // Catch:{ all -> 0x004b }
            throw r0     // Catch:{ all -> 0x004b }
        L_0x004b:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Stream.takeHeaders():okhttp3.Headers");
    }

    public final synchronized Headers trailers() throws IOException {
        Headers trailers;
        if (this.source.getFinished$okhttp() && this.source.getReceiveBuffer().V() && this.source.getReadBuffer().V()) {
            trailers = this.source.getTrailers();
            if (trailers == null) {
                trailers = Util.EMPTY_HEADERS;
            }
        } else if (this.errorCode != null) {
            Throwable th = this.errorException;
            if (th == null) {
                ErrorCode errorCode2 = this.errorCode;
                Intrinsics.c(errorCode2);
                th = new StreamResetException(errorCode2);
            }
            throw th;
        } else {
            throw new IllegalStateException("too early; can't read the trailers yet");
        }
        return trailers;
    }

    public final void waitForIo$okhttp() throws InterruptedIOException {
        try {
            Intrinsics.d(this, "null cannot be cast to non-null type java.lang.Object");
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    public final void writeHeaders(List<Header> list, boolean z2, boolean z3) throws IOException {
        boolean z4;
        Intrinsics.f(list, "responseHeaders");
        if (!Util.assertionsEnabled || !Thread.holdsLock(this)) {
            synchronized (this) {
                z4 = true;
                this.hasResponseHeaders = true;
                if (z2) {
                    this.sink.setFinished(true);
                }
                Unit unit = Unit.f40298a;
            }
            if (!z3) {
                synchronized (this.connection) {
                    if (this.connection.getWriteBytesTotal() < this.connection.getWriteBytesMaximum()) {
                        z4 = false;
                    }
                }
                z3 = z4;
            }
            this.connection.writeHeaders$okhttp(this.id, z2, list);
            if (z3) {
                this.connection.flush();
                return;
            }
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }

    public final Timeout writeTimeout() {
        return this.writeTimeout;
    }

    public final class FramingSink implements Sink {
        private boolean closed;
        private boolean finished;
        private final Buffer sendBuffer;
        private Headers trailers;

        public FramingSink(boolean z2) {
            this.finished = z2;
            this.sendBuffer = new Buffer();
        }

        /* JADX INFO: finally extract failed */
        private final void emitFrame(boolean z2) throws IOException {
            long min;
            boolean z3;
            Http2Stream http2Stream = Http2Stream.this;
            synchronized (http2Stream) {
                http2Stream.getWriteTimeout$okhttp().enter();
                while (http2Stream.getWriteBytesTotal() >= http2Stream.getWriteBytesMaximum() && !this.finished && !this.closed && http2Stream.getErrorCode$okhttp() == null) {
                    try {
                        http2Stream.waitForIo$okhttp();
                    } catch (Throwable th) {
                        http2Stream.getWriteTimeout$okhttp().exitAndThrowIfTimedOut();
                        throw th;
                    }
                }
                http2Stream.getWriteTimeout$okhttp().exitAndThrowIfTimedOut();
                http2Stream.checkOutNotClosed$okhttp();
                min = Math.min(http2Stream.getWriteBytesMaximum() - http2Stream.getWriteBytesTotal(), this.sendBuffer.size());
                http2Stream.setWriteBytesTotal$okhttp(http2Stream.getWriteBytesTotal() + min);
                if (!z2 || min != this.sendBuffer.size()) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                Unit unit = Unit.f40298a;
            }
            Http2Stream.this.getWriteTimeout$okhttp().enter();
            try {
                Http2Stream.this.getConnection().writeData(Http2Stream.this.getId(), z3, this.sendBuffer, min);
            } finally {
                Http2Stream.this.getWriteTimeout$okhttp().exitAndThrowIfTimedOut();
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0053, code lost:
            if (r10.this$0.getSink$okhttp().finished != false) goto L_0x00b9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x005f, code lost:
            if (r10.sendBuffer.size() <= 0) goto L_0x0063;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0061, code lost:
            r0 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0063, code lost:
            r0 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0066, code lost:
            if (r10.trailers == null) goto L_0x006a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0068, code lost:
            r4 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x006a, code lost:
            r4 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x006b, code lost:
            if (r4 == false) goto L_0x0094;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0075, code lost:
            if (r10.sendBuffer.size() <= 0) goto L_0x007b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0077, code lost:
            emitFrame(false);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x007b, code lost:
            r0 = r10.this$0.getConnection();
            r2 = r10.this$0.getId();
            r4 = r10.trailers;
            kotlin.jvm.internal.Intrinsics.c(r4);
            r0.writeHeaders$okhttp(r2, r1, okhttp3.internal.Util.toHeaderList(r4));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0094, code lost:
            if (r0 == false) goto L_0x00a4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x009e, code lost:
            if (r10.sendBuffer.size() <= 0) goto L_0x00b9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x00a0, code lost:
            emitFrame(true);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x00a4, code lost:
            if (r1 == false) goto L_0x00b9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x00a6, code lost:
            r10.this$0.getConnection().writeData(r10.this$0.getId(), true, (okio.Buffer) null, 0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x00b9, code lost:
            r0 = r10.this$0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x00bb, code lost:
            monitor-enter(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
            r10.closed = true;
            r1 = kotlin.Unit.f40298a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x00c0, code lost:
            monitor-exit(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x00c1, code lost:
            r10.this$0.getConnection().flush();
            r10.this$0.cancelStreamIfNecessary$okhttp();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x00cf, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void close() throws java.io.IOException {
            /*
                r10 = this;
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this
                boolean r1 = okhttp3.internal.Util.assertionsEnabled
                if (r1 == 0) goto L_0x0034
                boolean r1 = java.lang.Thread.holdsLock(r0)
                if (r1 != 0) goto L_0x000d
                goto L_0x0034
            L_0x000d:
                java.lang.AssertionError r1 = new java.lang.AssertionError
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Thread "
                r2.append(r3)
                java.lang.Thread r3 = java.lang.Thread.currentThread()
                java.lang.String r3 = r3.getName()
                r2.append(r3)
                java.lang.String r3 = " MUST NOT hold lock on "
                r2.append(r3)
                r2.append(r0)
                java.lang.String r0 = r2.toString()
                r1.<init>(r0)
                throw r1
            L_0x0034:
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this
                monitor-enter(r0)
                boolean r1 = r10.closed     // Catch:{ all -> 0x00d3 }
                if (r1 == 0) goto L_0x003d
                monitor-exit(r0)
                return
            L_0x003d:
                okhttp3.internal.http2.ErrorCode r1 = r0.getErrorCode$okhttp()     // Catch:{ all -> 0x00d3 }
                r2 = 0
                r3 = 1
                if (r1 != 0) goto L_0x0047
                r1 = 1
                goto L_0x0048
            L_0x0047:
                r1 = 0
            L_0x0048:
                kotlin.Unit r4 = kotlin.Unit.f40298a     // Catch:{ all -> 0x00d3 }
                monitor-exit(r0)
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this
                okhttp3.internal.http2.Http2Stream$FramingSink r0 = r0.getSink$okhttp()
                boolean r0 = r0.finished
                if (r0 != 0) goto L_0x00b9
                okio.Buffer r0 = r10.sendBuffer
                long r4 = r0.size()
                r6 = 0
                int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r0 <= 0) goto L_0x0063
                r0 = 1
                goto L_0x0064
            L_0x0063:
                r0 = 0
            L_0x0064:
                okhttp3.Headers r4 = r10.trailers
                if (r4 == 0) goto L_0x006a
                r4 = 1
                goto L_0x006b
            L_0x006a:
                r4 = 0
            L_0x006b:
                if (r4 == 0) goto L_0x0094
            L_0x006d:
                okio.Buffer r0 = r10.sendBuffer
                long r4 = r0.size()
                int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r0 <= 0) goto L_0x007b
                r10.emitFrame(r2)
                goto L_0x006d
            L_0x007b:
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this
                okhttp3.internal.http2.Http2Connection r0 = r0.getConnection()
                okhttp3.internal.http2.Http2Stream r2 = okhttp3.internal.http2.Http2Stream.this
                int r2 = r2.getId()
                okhttp3.Headers r4 = r10.trailers
                kotlin.jvm.internal.Intrinsics.c(r4)
                java.util.List r4 = okhttp3.internal.Util.toHeaderList(r4)
                r0.writeHeaders$okhttp(r2, r1, r4)
                goto L_0x00b9
            L_0x0094:
                if (r0 == 0) goto L_0x00a4
            L_0x0096:
                okio.Buffer r0 = r10.sendBuffer
                long r0 = r0.size()
                int r2 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
                if (r2 <= 0) goto L_0x00b9
                r10.emitFrame(r3)
                goto L_0x0096
            L_0x00a4:
                if (r1 == 0) goto L_0x00b9
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this
                okhttp3.internal.http2.Http2Connection r4 = r0.getConnection()
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this
                int r5 = r0.getId()
                r6 = 1
                r7 = 0
                r8 = 0
                r4.writeData(r5, r6, r7, r8)
            L_0x00b9:
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this
                monitor-enter(r0)
                r10.closed = r3     // Catch:{ all -> 0x00d0 }
                kotlin.Unit r1 = kotlin.Unit.f40298a     // Catch:{ all -> 0x00d0 }
                monitor-exit(r0)
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this
                okhttp3.internal.http2.Http2Connection r0 = r0.getConnection()
                r0.flush()
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this
                r0.cancelStreamIfNecessary$okhttp()
                return
            L_0x00d0:
                r1 = move-exception
                monitor-exit(r0)
                throw r1
            L_0x00d3:
                r1 = move-exception
                monitor-exit(r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Stream.FramingSink.close():void");
        }

        public void flush() throws IOException {
            Http2Stream http2Stream = Http2Stream.this;
            if (!Util.assertionsEnabled || !Thread.holdsLock(http2Stream)) {
                Http2Stream http2Stream2 = Http2Stream.this;
                synchronized (http2Stream2) {
                    http2Stream2.checkOutNotClosed$okhttp();
                    Unit unit = Unit.f40298a;
                }
                while (this.sendBuffer.size() > 0) {
                    emitFrame(false);
                    Http2Stream.this.getConnection().flush();
                }
                return;
            }
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + http2Stream);
        }

        public final boolean getClosed() {
            return this.closed;
        }

        public final boolean getFinished() {
            return this.finished;
        }

        public final Headers getTrailers() {
            return this.trailers;
        }

        public final void setClosed(boolean z2) {
            this.closed = z2;
        }

        public final void setFinished(boolean z2) {
            this.finished = z2;
        }

        public final void setTrailers(Headers headers) {
            this.trailers = headers;
        }

        public Timeout timeout() {
            return Http2Stream.this.getWriteTimeout$okhttp();
        }

        public void write(Buffer buffer, long j2) throws IOException {
            Intrinsics.f(buffer, "source");
            Http2Stream http2Stream = Http2Stream.this;
            if (!Util.assertionsEnabled || !Thread.holdsLock(http2Stream)) {
                this.sendBuffer.write(buffer, j2);
                while (this.sendBuffer.size() >= 16384) {
                    emitFrame(false);
                }
                return;
            }
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + http2Stream);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ FramingSink(Http2Stream http2Stream, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? false : z2);
        }
    }
}
