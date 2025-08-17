package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.Segment;

final class SemaphoreSegment extends Segment<SemaphoreSegment> {

    /* renamed from: f  reason: collision with root package name */
    private final AtomicReferenceArray f40871f = new AtomicReferenceArray(SemaphoreKt.f40870f);

    public SemaphoreSegment(long j2, SemaphoreSegment semaphoreSegment, int i2) {
        super(j2, semaphoreSegment, i2);
    }

    public int m() {
        return SemaphoreKt.f40870f;
    }

    public void n(int i2, Throwable th, CoroutineContext coroutineContext) {
        q().set(i2, SemaphoreKt.f40869e);
        o();
    }

    public final AtomicReferenceArray q() {
        return this.f40871f;
    }

    public String toString() {
        return "SemaphoreSegment[id=" + this.f40770d + ", hashCode=" + hashCode() + ']';
    }
}
