package okio;

import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

public final class AsyncTimeout$sink$1 implements Sink {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ AsyncTimeout f41316b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Sink f41317c;

    AsyncTimeout$sink$1(AsyncTimeout asyncTimeout, Sink sink) {
        this.f41316b = asyncTimeout;
        this.f41317c = sink;
    }

    /* renamed from: a */
    public AsyncTimeout timeout() {
        return this.f41316b;
    }

    public void close() {
        AsyncTimeout asyncTimeout = this.f41316b;
        Sink sink = this.f41317c;
        asyncTimeout.enter();
        try {
            sink.close();
            Unit unit = Unit.f40298a;
            if (asyncTimeout.exit()) {
                throw asyncTimeout.access$newTimeoutException((IOException) null);
            }
        } catch (IOException e2) {
            e = e2;
            if (asyncTimeout.exit()) {
                e = asyncTimeout.access$newTimeoutException(e);
            }
            throw e;
        } finally {
            boolean exit = asyncTimeout.exit();
        }
    }

    public void flush() {
        AsyncTimeout asyncTimeout = this.f41316b;
        Sink sink = this.f41317c;
        asyncTimeout.enter();
        try {
            sink.flush();
            Unit unit = Unit.f40298a;
            if (asyncTimeout.exit()) {
                throw asyncTimeout.access$newTimeoutException((IOException) null);
            }
        } catch (IOException e2) {
            e = e2;
            if (asyncTimeout.exit()) {
                e = asyncTimeout.access$newTimeoutException(e);
            }
            throw e;
        } finally {
            boolean exit = asyncTimeout.exit();
        }
    }

    public String toString() {
        return "AsyncTimeout.sink(" + this.f41317c + ')';
    }

    public void write(Buffer buffer, long j2) {
        Intrinsics.f(buffer, "source");
        SegmentedByteString.b(buffer.size(), 0, j2);
        while (true) {
            long j3 = 0;
            if (j2 > 0) {
                Segment segment = buffer.f41320b;
                Intrinsics.c(segment);
                while (true) {
                    if (j3 >= 65536) {
                        break;
                    }
                    j3 += (long) (segment.f41379c - segment.f41378b);
                    if (j3 >= j2) {
                        j3 = j2;
                        break;
                    } else {
                        segment = segment.f41382f;
                        Intrinsics.c(segment);
                    }
                }
                AsyncTimeout asyncTimeout = this.f41316b;
                Sink sink = this.f41317c;
                asyncTimeout.enter();
                try {
                    sink.write(buffer, j3);
                    Unit unit = Unit.f40298a;
                    if (!asyncTimeout.exit()) {
                        j2 -= j3;
                    } else {
                        throw asyncTimeout.access$newTimeoutException((IOException) null);
                    }
                } catch (IOException e2) {
                    e = e2;
                    if (asyncTimeout.exit()) {
                        e = asyncTimeout.access$newTimeoutException(e);
                    }
                    throw e;
                } finally {
                    boolean exit = asyncTimeout.exit();
                }
            } else {
                return;
            }
        }
    }
}
