package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.selects.SelectInstance;

public class SemaphoreImpl {

    /* renamed from: c  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f40855c;

    /* renamed from: d  reason: collision with root package name */
    private static final AtomicLongFieldUpdater f40856d;

    /* renamed from: e  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f40857e;

    /* renamed from: f  reason: collision with root package name */
    private static final AtomicLongFieldUpdater f40858f;

    /* renamed from: g  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f40859g;
    private volatile int _availablePermits;

    /* renamed from: a  reason: collision with root package name */
    private final int f40860a;

    /* renamed from: b  reason: collision with root package name */
    private final Function1<Throwable, Unit> f40861b;
    private volatile long deqIdx;
    private volatile long enqIdx;
    private volatile Object head;
    private volatile Object tail;

    static {
        Class<SemaphoreImpl> cls = SemaphoreImpl.class;
        Class<Object> cls2 = Object.class;
        f40855c = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "head");
        f40856d = AtomicLongFieldUpdater.newUpdater(cls, "deqIdx");
        f40857e = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "tail");
        f40858f = AtomicLongFieldUpdater.newUpdater(cls, "enqIdx");
        f40859g = AtomicIntegerFieldUpdater.newUpdater(cls, "_availablePermits");
    }

    public SemaphoreImpl(int i2, int i3) {
        boolean z2;
        this.f40860a = i2;
        boolean z3 = true;
        if (i2 > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            if ((i3 < 0 || i3 > i2) ? false : z3) {
                SemaphoreSegment semaphoreSegment = new SemaphoreSegment(0, (SemaphoreSegment) null, 2);
                this.head = semaphoreSegment;
                this.tail = semaphoreSegment;
                this._availablePermits = i2 - i3;
                this.f40861b = new SemaphoreImpl$onCancellationRelease$1(this);
                return;
            }
            throw new IllegalArgumentException(("The number of acquired permits should be in 0.." + i2).toString());
        }
        throw new IllegalArgumentException(("Semaphore should have at least 1 permit, but had " + i2).toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0051, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0037, code lost:
        r10 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean d(kotlinx.coroutines.Waiter r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r2 = f40857e
            java.lang.Object r3 = r2.get(r0)
            kotlinx.coroutines.sync.SemaphoreSegment r3 = (kotlinx.coroutines.sync.SemaphoreSegment) r3
            java.util.concurrent.atomic.AtomicLongFieldUpdater r4 = f40858f
            long r4 = r4.getAndIncrement(r0)
            kotlinx.coroutines.sync.SemaphoreImpl$addAcquireToQueue$createNewSegment$1 r6 = kotlinx.coroutines.sync.SemaphoreImpl$addAcquireToQueue$createNewSegment$1.f40862c
            int r7 = kotlinx.coroutines.sync.SemaphoreKt.f40870f
            long r7 = (long) r7
            long r7 = r4 / r7
        L_0x001b:
            java.lang.Object r9 = kotlinx.coroutines.internal.ConcurrentLinkedListKt.b(r3, r7, r6)
            boolean r10 = kotlinx.coroutines.internal.SegmentOrClosed.c(r9)
            if (r10 != 0) goto L_0x005e
            kotlinx.coroutines.internal.Segment r10 = kotlinx.coroutines.internal.SegmentOrClosed.b(r9)
        L_0x0029:
            java.lang.Object r13 = r2.get(r0)
            kotlinx.coroutines.internal.Segment r13 = (kotlinx.coroutines.internal.Segment) r13
            long r14 = r13.f40770d
            long r11 = r10.f40770d
            int r16 = (r14 > r11 ? 1 : (r14 == r11 ? 0 : -1))
            if (r16 < 0) goto L_0x0039
        L_0x0037:
            r10 = 1
            goto L_0x0051
        L_0x0039:
            boolean r11 = r10.p()
            if (r11 != 0) goto L_0x0041
            r10 = 0
            goto L_0x0051
        L_0x0041:
            boolean r11 = androidx.concurrent.futures.a.a(r2, r0, r13, r10)
            if (r11 == 0) goto L_0x0054
            boolean r10 = r13.l()
            if (r10 == 0) goto L_0x0037
            r13.j()
            goto L_0x0037
        L_0x0051:
            if (r10 == 0) goto L_0x001b
            goto L_0x005e
        L_0x0054:
            boolean r11 = r10.l()
            if (r11 == 0) goto L_0x0029
            r10.j()
            goto L_0x0029
        L_0x005e:
            kotlinx.coroutines.internal.Segment r2 = kotlinx.coroutines.internal.SegmentOrClosed.b(r9)
            kotlinx.coroutines.sync.SemaphoreSegment r2 = (kotlinx.coroutines.sync.SemaphoreSegment) r2
            int r3 = kotlinx.coroutines.sync.SemaphoreKt.f40870f
            long r6 = (long) r3
            long r4 = r4 % r6
            int r3 = (int) r4
            java.util.concurrent.atomic.AtomicReferenceArray r4 = r2.q()
            r5 = 0
            boolean r4 = p1.a.a(r4, r3, r5, r1)
            if (r4 == 0) goto L_0x007b
            r1.a(r2, r3)
            r1 = 1
            return r1
        L_0x007b:
            kotlinx.coroutines.internal.Symbol r4 = kotlinx.coroutines.sync.SemaphoreKt.f40866b
            kotlinx.coroutines.internal.Symbol r5 = kotlinx.coroutines.sync.SemaphoreKt.f40867c
            java.util.concurrent.atomic.AtomicReferenceArray r2 = r2.q()
            boolean r2 = p1.a.a(r2, r3, r4, r5)
            if (r2 == 0) goto L_0x00c9
            boolean r2 = r1 instanceof kotlinx.coroutines.CancellableContinuation
            if (r2 == 0) goto L_0x00a1
            java.lang.String r2 = "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>"
            kotlin.jvm.internal.Intrinsics.d(r1, r2)
            kotlinx.coroutines.CancellableContinuation r1 = (kotlinx.coroutines.CancellableContinuation) r1
            kotlin.Unit r2 = kotlin.Unit.f40298a
            kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit> r3 = r0.f40861b
            r1.d(r2, r3)
        L_0x009f:
            r1 = 1
            goto L_0x00ad
        L_0x00a1:
            boolean r2 = r1 instanceof kotlinx.coroutines.selects.SelectInstance
            if (r2 == 0) goto L_0x00ae
            kotlinx.coroutines.selects.SelectInstance r1 = (kotlinx.coroutines.selects.SelectInstance) r1
            kotlin.Unit r2 = kotlin.Unit.f40298a
            r1.a(r2)
            goto L_0x009f
        L_0x00ad:
            return r1
        L_0x00ae:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "unexpected: "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            java.lang.String r1 = r1.toString()
            r2.<init>(r1)
            throw r2
        L_0x00c9:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.SemaphoreImpl.d(kotlinx.coroutines.Waiter):boolean");
    }

    /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    private final void e() {
        /*
            r3 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = f40859g
            int r1 = r0.get(r3)
            int r2 = r3.f40860a
            if (r1 <= r2) goto L_0x0010
            boolean r0 = r0.compareAndSet(r3, r1, r2)
            if (r0 == 0) goto L_0x0000
        L_0x0010:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.SemaphoreImpl.e():void");
    }

    private final int f() {
        int andDecrement;
        do {
            andDecrement = f40859g.getAndDecrement(this);
        } while (andDecrement > this.f40860a);
        return andDecrement;
    }

    private final boolean j(Object obj) {
        if (obj instanceof CancellableContinuation) {
            Intrinsics.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            CancellableContinuation cancellableContinuation = (CancellableContinuation) obj;
            Object e2 = cancellableContinuation.e(Unit.f40298a, (Object) null, this.f40861b);
            if (e2 == null) {
                return false;
            }
            cancellableContinuation.h(e2);
            return true;
        } else if (obj instanceof SelectInstance) {
            return ((SelectInstance) obj).b(this, Unit.f40298a);
        } else {
            throw new IllegalStateException(("unexpected: " + obj).toString());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x004f, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0035, code lost:
        r9 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean k() {
        /*
            r16 = this;
            r0 = r16
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = f40855c
            java.lang.Object r2 = r1.get(r0)
            kotlinx.coroutines.sync.SemaphoreSegment r2 = (kotlinx.coroutines.sync.SemaphoreSegment) r2
            java.util.concurrent.atomic.AtomicLongFieldUpdater r3 = f40856d
            long r3 = r3.getAndIncrement(r0)
            int r5 = kotlinx.coroutines.sync.SemaphoreKt.f40870f
            long r5 = (long) r5
            long r5 = r3 / r5
            kotlinx.coroutines.sync.SemaphoreImpl$tryResumeNextFromQueue$createNewSegment$1 r7 = kotlinx.coroutines.sync.SemaphoreImpl$tryResumeNextFromQueue$createNewSegment$1.f40864c
        L_0x0019:
            java.lang.Object r8 = kotlinx.coroutines.internal.ConcurrentLinkedListKt.b(r2, r5, r7)
            boolean r9 = kotlinx.coroutines.internal.SegmentOrClosed.c(r8)
            if (r9 != 0) goto L_0x005c
            kotlinx.coroutines.internal.Segment r9 = kotlinx.coroutines.internal.SegmentOrClosed.b(r8)
        L_0x0027:
            java.lang.Object r12 = r1.get(r0)
            kotlinx.coroutines.internal.Segment r12 = (kotlinx.coroutines.internal.Segment) r12
            long r13 = r12.f40770d
            long r10 = r9.f40770d
            int r15 = (r13 > r10 ? 1 : (r13 == r10 ? 0 : -1))
            if (r15 < 0) goto L_0x0037
        L_0x0035:
            r9 = 1
            goto L_0x004f
        L_0x0037:
            boolean r10 = r9.p()
            if (r10 != 0) goto L_0x003f
            r9 = 0
            goto L_0x004f
        L_0x003f:
            boolean r10 = androidx.concurrent.futures.a.a(r1, r0, r12, r9)
            if (r10 == 0) goto L_0x0052
            boolean r9 = r12.l()
            if (r9 == 0) goto L_0x0035
            r12.j()
            goto L_0x0035
        L_0x004f:
            if (r9 == 0) goto L_0x0019
            goto L_0x005c
        L_0x0052:
            boolean r10 = r9.l()
            if (r10 == 0) goto L_0x0027
            r9.j()
            goto L_0x0027
        L_0x005c:
            kotlinx.coroutines.internal.Segment r1 = kotlinx.coroutines.internal.SegmentOrClosed.b(r8)
            kotlinx.coroutines.sync.SemaphoreSegment r1 = (kotlinx.coroutines.sync.SemaphoreSegment) r1
            r1.b()
            long r7 = r1.f40770d
            int r2 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r2 <= 0) goto L_0x006d
            r2 = 0
            return r2
        L_0x006d:
            int r2 = kotlinx.coroutines.sync.SemaphoreKt.f40870f
            long r5 = (long) r2
            long r3 = r3 % r5
            int r2 = (int) r3
            kotlinx.coroutines.internal.Symbol r3 = kotlinx.coroutines.sync.SemaphoreKt.f40866b
            java.util.concurrent.atomic.AtomicReferenceArray r4 = r1.q()
            java.lang.Object r3 = r4.getAndSet(r2, r3)
            if (r3 != 0) goto L_0x00b0
            int r3 = kotlinx.coroutines.sync.SemaphoreKt.f40865a
            r10 = 0
        L_0x0087:
            if (r10 >= r3) goto L_0x009d
            java.util.concurrent.atomic.AtomicReferenceArray r4 = r1.q()
            java.lang.Object r4 = r4.get(r2)
            kotlinx.coroutines.internal.Symbol r5 = kotlinx.coroutines.sync.SemaphoreKt.f40867c
            if (r4 != r5) goto L_0x0099
            r4 = 1
            return r4
        L_0x0099:
            r4 = 1
            int r10 = r10 + 1
            goto L_0x0087
        L_0x009d:
            r4 = 1
            kotlinx.coroutines.internal.Symbol r3 = kotlinx.coroutines.sync.SemaphoreKt.f40866b
            kotlinx.coroutines.internal.Symbol r5 = kotlinx.coroutines.sync.SemaphoreKt.f40868d
            java.util.concurrent.atomic.AtomicReferenceArray r1 = r1.q()
            boolean r1 = p1.a.a(r1, r2, r3, r5)
            r1 = r1 ^ r4
            return r1
        L_0x00b0:
            kotlinx.coroutines.internal.Symbol r1 = kotlinx.coroutines.sync.SemaphoreKt.f40869e
            if (r3 != r1) goto L_0x00b8
            r1 = 0
            return r1
        L_0x00b8:
            boolean r1 = r0.j(r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.SemaphoreImpl.k():boolean");
    }

    /* access modifiers changed from: protected */
    public final void c(CancellableContinuation<? super Unit> cancellableContinuation) {
        while (f() <= 0) {
            Intrinsics.d(cancellableContinuation, "null cannot be cast to non-null type kotlinx.coroutines.Waiter");
            if (d((Waiter) cancellableContinuation)) {
                return;
            }
        }
        cancellableContinuation.d(Unit.f40298a, this.f40861b);
    }

    public int g() {
        return Math.max(f40859g.get(this), 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void h() {
        /*
            r3 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = f40859g
            int r0 = r0.getAndIncrement(r3)
            int r1 = r3.f40860a
            if (r0 >= r1) goto L_0x0014
            if (r0 < 0) goto L_0x000d
            return
        L_0x000d:
            boolean r0 = r3.k()
            if (r0 == 0) goto L_0x0000
            return
        L_0x0014:
            r3.e()
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "The number of released permits cannot be greater than "
            r1.append(r2)
            int r2 = r3.f40860a
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.SemaphoreImpl.h():void");
    }

    public boolean i() {
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f40859g;
            int i2 = atomicIntegerFieldUpdater.get(this);
            if (i2 > this.f40860a) {
                e();
            } else if (i2 <= 0) {
                return false;
            } else {
                if (atomicIntegerFieldUpdater.compareAndSet(this, i2, i2 - 1)) {
                    return true;
                }
            }
        }
    }
}
