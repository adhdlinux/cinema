package okio;

import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

public final class AsyncTimeout$source$1 implements Source {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ AsyncTimeout f41318b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Source f41319c;

    AsyncTimeout$source$1(AsyncTimeout asyncTimeout, Source source) {
        this.f41318b = asyncTimeout;
        this.f41319c = source;
    }

    /* renamed from: a */
    public AsyncTimeout timeout() {
        return this.f41318b;
    }

    public void close() {
        AsyncTimeout asyncTimeout = this.f41318b;
        Source source = this.f41319c;
        asyncTimeout.enter();
        try {
            source.close();
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

    public long read(Buffer buffer, long j2) {
        Intrinsics.f(buffer, "sink");
        AsyncTimeout asyncTimeout = this.f41318b;
        Source source = this.f41319c;
        asyncTimeout.enter();
        try {
            long read = source.read(buffer, j2);
            if (!asyncTimeout.exit()) {
                return read;
            }
            throw asyncTimeout.access$newTimeoutException((IOException) null);
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
        return "AsyncTimeout.source(" + this.f41319c + ')';
    }
}
