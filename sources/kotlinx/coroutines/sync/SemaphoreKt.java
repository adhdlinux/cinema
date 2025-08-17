package kotlinx.coroutines.sync;

import kotlinx.coroutines.internal.Symbol;

public final class SemaphoreKt {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final int f40865a = SystemPropsKt__SystemProps_commonKt.e("kotlinx.coroutines.semaphore.maxSpinCycles", 100, 0, 0, 12, (Object) null);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final Symbol f40866b = new Symbol("PERMIT");
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final Symbol f40867c = new Symbol("TAKEN");
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final Symbol f40868d = new Symbol("BROKEN");
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final Symbol f40869e = new Symbol("CANCELLED");
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final int f40870f = SystemPropsKt__SystemProps_commonKt.e("kotlinx.coroutines.semaphore.segmentSize", 16, 0, 0, 12, (Object) null);

    /* access modifiers changed from: private */
    public static final SemaphoreSegment h(long j2, SemaphoreSegment semaphoreSegment) {
        return new SemaphoreSegment(j2, semaphoreSegment, 0);
    }
}
