package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http1.HeadersReader;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Options;
import okio.Source;
import okio.Timeout;

public final class MultipartReader implements Closeable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Options afterBoundaryOptions;
    private final String boundary;
    private boolean closed;
    private final ByteString crlfDashDashBoundary;
    /* access modifiers changed from: private */
    public PartSource currentPart;
    private final ByteString dashDashBoundary;
    private boolean noMoreParts;
    private int partCount;
    /* access modifiers changed from: private */
    public final BufferedSource source;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Options getAfterBoundaryOptions() {
            return MultipartReader.afterBoundaryOptions;
        }
    }

    public static final class Part implements Closeable {
        private final BufferedSource body;
        private final Headers headers;

        public Part(Headers headers2, BufferedSource bufferedSource) {
            Intrinsics.f(headers2, "headers");
            Intrinsics.f(bufferedSource, "body");
            this.headers = headers2;
            this.body = bufferedSource;
        }

        public final BufferedSource body() {
            return this.body;
        }

        public void close() {
            this.body.close();
        }

        public final Headers headers() {
            return this.headers;
        }
    }

    private final class PartSource implements Source {
        private final Timeout timeout = new Timeout();

        public PartSource() {
        }

        public void close() {
            if (Intrinsics.a(MultipartReader.this.currentPart, this)) {
                MultipartReader.this.currentPart = null;
            }
        }

        public long read(Buffer buffer, long j2) {
            boolean z2;
            long j3;
            long j4;
            Buffer buffer2 = buffer;
            long j5 = j2;
            Intrinsics.f(buffer2, "sink");
            if (j5 >= 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                throw new IllegalArgumentException(("byteCount < 0: " + j5).toString());
            } else if (Intrinsics.a(MultipartReader.this.currentPart, this)) {
                Timeout timeout2 = MultipartReader.this.source.timeout();
                Timeout timeout3 = this.timeout;
                MultipartReader multipartReader = MultipartReader.this;
                long timeoutNanos = timeout2.timeoutNanos();
                long a2 = Timeout.Companion.a(timeout3.timeoutNanos(), timeout2.timeoutNanos());
                TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                timeout2.timeout(a2, timeUnit);
                if (timeout2.hasDeadline()) {
                    long deadlineNanoTime = timeout2.deadlineNanoTime();
                    if (timeout3.hasDeadline()) {
                        timeout2.deadlineNanoTime(Math.min(timeout2.deadlineNanoTime(), timeout3.deadlineNanoTime()));
                    }
                    try {
                        long access$currentPartBytesRemaining = multipartReader.currentPartBytesRemaining(j5);
                        if (access$currentPartBytesRemaining == 0) {
                            j4 = -1;
                        } else {
                            j4 = multipartReader.source.read(buffer2, access$currentPartBytesRemaining);
                        }
                        timeout2.timeout(timeoutNanos, timeUnit);
                        if (timeout3.hasDeadline()) {
                            timeout2.deadlineNanoTime(deadlineNanoTime);
                        }
                        return j4;
                    } catch (Throwable th) {
                        timeout2.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                        if (timeout3.hasDeadline()) {
                            timeout2.deadlineNanoTime(deadlineNanoTime);
                        }
                        throw th;
                    }
                } else {
                    if (timeout3.hasDeadline()) {
                        timeout2.deadlineNanoTime(timeout3.deadlineNanoTime());
                    }
                    try {
                        long access$currentPartBytesRemaining2 = multipartReader.currentPartBytesRemaining(j5);
                        if (access$currentPartBytesRemaining2 == 0) {
                            j3 = -1;
                        } else {
                            j3 = multipartReader.source.read(buffer2, access$currentPartBytesRemaining2);
                        }
                        timeout2.timeout(timeoutNanos, timeUnit);
                        if (timeout3.hasDeadline()) {
                            timeout2.clearDeadline();
                        }
                        return j3;
                    } catch (Throwable th2) {
                        timeout2.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                        if (timeout3.hasDeadline()) {
                            timeout2.clearDeadline();
                        }
                        throw th2;
                    }
                }
            } else {
                throw new IllegalStateException("closed".toString());
            }
        }

        public Timeout timeout() {
            return this.timeout;
        }
    }

    static {
        Options.Companion companion = Options.f41357e;
        ByteString.Companion companion2 = ByteString.f41331e;
        afterBoundaryOptions = companion.d(companion2.d("\r\n"), companion2.d("--"), companion2.d(" "), companion2.d("\t"));
    }

    public MultipartReader(BufferedSource bufferedSource, String str) throws IOException {
        Intrinsics.f(bufferedSource, "source");
        Intrinsics.f(str, "boundary");
        this.source = bufferedSource;
        this.boundary = str;
        this.dashDashBoundary = new Buffer().w("--").w(str).c0();
        this.crlfDashDashBoundary = new Buffer().w("\r\n--").w(str).c0();
    }

    /* access modifiers changed from: private */
    public final long currentPartBytesRemaining(long j2) {
        this.source.N((long) this.crlfDashDashBoundary.size());
        long B = this.source.c().B(this.crlfDashDashBoundary);
        if (B == -1) {
            return Math.min(j2, (this.source.c().size() - ((long) this.crlfDashDashBoundary.size())) + 1);
        }
        return Math.min(j2, B);
    }

    public final String boundary() {
        return this.boundary;
    }

    public void close() throws IOException {
        if (!this.closed) {
            this.closed = true;
            this.currentPart = null;
            this.source.close();
        }
    }

    public final Part nextPart() throws IOException {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        } else if (this.noMoreParts) {
            return null;
        } else {
            if (this.partCount != 0 || !this.source.x(0, this.dashDashBoundary)) {
                while (true) {
                    long currentPartBytesRemaining = currentPartBytesRemaining(8192);
                    if (currentPartBytesRemaining == 0) {
                        break;
                    }
                    this.source.skip(currentPartBytesRemaining);
                }
                this.source.skip((long) this.crlfDashDashBoundary.size());
            } else {
                this.source.skip((long) this.dashDashBoundary.size());
            }
            boolean z2 = false;
            while (true) {
                int n02 = this.source.n0(afterBoundaryOptions);
                if (n02 == -1) {
                    throw new ProtocolException("unexpected characters after boundary");
                } else if (n02 == 0) {
                    this.partCount++;
                    Headers readHeaders = new HeadersReader(this.source).readHeaders();
                    PartSource partSource = new PartSource();
                    this.currentPart = partSource;
                    return new Part(readHeaders, Okio.d(partSource));
                } else if (n02 != 1) {
                    if (n02 == 2 || n02 == 3) {
                        z2 = true;
                    }
                } else if (z2) {
                    throw new ProtocolException("unexpected characters after boundary");
                } else if (this.partCount != 0) {
                    this.noMoreParts = true;
                    return null;
                } else {
                    throw new ProtocolException("expected at least 1 part");
                }
            }
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MultipartReader(okhttp3.ResponseBody r3) throws java.io.IOException {
        /*
            r2 = this;
            java.lang.String r0 = "response"
            kotlin.jvm.internal.Intrinsics.f(r3, r0)
            okio.BufferedSource r0 = r3.source()
            okhttp3.MediaType r3 = r3.contentType()
            if (r3 == 0) goto L_0x001b
            java.lang.String r1 = "boundary"
            java.lang.String r3 = r3.parameter(r1)
            if (r3 == 0) goto L_0x001b
            r2.<init>(r0, r3)
            return
        L_0x001b:
            java.net.ProtocolException r3 = new java.net.ProtocolException
            java.lang.String r0 = "expected the Content-Type to have a boundary parameter"
            r3.<init>(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.MultipartReader.<init>(okhttp3.ResponseBody):void");
    }
}
