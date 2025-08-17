package io.reactivex.internal.queue;

import com.google.protobuf.CodedOutputStream;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.util.Pow2;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class SpscLinkedArrayQueue<T> implements SimplePlainQueue<T> {

    /* renamed from: j  reason: collision with root package name */
    static final int f39928j = Integer.getInteger("jctools.spsc.max.lookahead.step", CodedOutputStream.DEFAULT_BUFFER_SIZE).intValue();

    /* renamed from: k  reason: collision with root package name */
    private static final Object f39929k = new Object();

    /* renamed from: b  reason: collision with root package name */
    final AtomicLong f39930b = new AtomicLong();

    /* renamed from: c  reason: collision with root package name */
    int f39931c;

    /* renamed from: d  reason: collision with root package name */
    long f39932d;

    /* renamed from: e  reason: collision with root package name */
    final int f39933e;

    /* renamed from: f  reason: collision with root package name */
    AtomicReferenceArray<Object> f39934f;

    /* renamed from: g  reason: collision with root package name */
    final int f39935g;

    /* renamed from: h  reason: collision with root package name */
    AtomicReferenceArray<Object> f39936h;

    /* renamed from: i  reason: collision with root package name */
    final AtomicLong f39937i = new AtomicLong();

    public SpscLinkedArrayQueue(int i2) {
        int a2 = Pow2.a(Math.max(8, i2));
        int i3 = a2 - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(a2 + 1);
        this.f39934f = atomicReferenceArray;
        this.f39933e = i3;
        a(a2);
        this.f39936h = atomicReferenceArray;
        this.f39935g = i3;
        this.f39932d = (long) (i3 - 1);
        t(0);
    }

    private void a(int i2) {
        this.f39931c = Math.min(i2 / 4, f39928j);
    }

    private static int c(int i2) {
        return i2;
    }

    private static int d(long j2, int i2) {
        return c(((int) j2) & i2);
    }

    private long e() {
        return this.f39937i.get();
    }

    private long f() {
        return this.f39930b.get();
    }

    private long g() {
        return this.f39937i.get();
    }

    private static <E> Object h(AtomicReferenceArray<Object> atomicReferenceArray, int i2) {
        return atomicReferenceArray.get(i2);
    }

    private AtomicReferenceArray<Object> i(AtomicReferenceArray<Object> atomicReferenceArray, int i2) {
        int c2 = c(i2);
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) h(atomicReferenceArray, c2);
        r(atomicReferenceArray, c2, (Object) null);
        return atomicReferenceArray2;
    }

    private long j() {
        return this.f39930b.get();
    }

    private T k(AtomicReferenceArray<Object> atomicReferenceArray, long j2, int i2) {
        this.f39936h = atomicReferenceArray;
        return h(atomicReferenceArray, d(j2, i2));
    }

    private T l(AtomicReferenceArray<Object> atomicReferenceArray, long j2, int i2) {
        this.f39936h = atomicReferenceArray;
        int d2 = d(j2, i2);
        T h2 = h(atomicReferenceArray, d2);
        if (h2 != null) {
            r(atomicReferenceArray, d2, (Object) null);
            q(j2 + 1);
        }
        return h2;
    }

    private void o(AtomicReferenceArray<Object> atomicReferenceArray, long j2, int i2, T t2, long j3) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.f39934f = atomicReferenceArray2;
        this.f39932d = (j3 + j2) - 1;
        r(atomicReferenceArray2, i2, t2);
        s(atomicReferenceArray, atomicReferenceArray2);
        r(atomicReferenceArray, i2, f39929k);
        t(j2 + 1);
    }

    private void q(long j2) {
        this.f39937i.lazySet(j2);
    }

    private static void r(AtomicReferenceArray<Object> atomicReferenceArray, int i2, Object obj) {
        atomicReferenceArray.lazySet(i2, obj);
    }

    private void s(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        r(atomicReferenceArray, c(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private void t(long j2) {
        this.f39930b.lazySet(j2);
    }

    private boolean u(AtomicReferenceArray<Object> atomicReferenceArray, T t2, long j2, int i2) {
        r(atomicReferenceArray, i2, t2);
        t(j2 + 1);
        return true;
    }

    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    public boolean isEmpty() {
        return j() == g();
    }

    public boolean m(T t2, T t3) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f39934f;
        long j2 = j();
        int i2 = this.f39933e;
        long j3 = 2 + j2;
        if (h(atomicReferenceArray, d(j3, i2)) == null) {
            int d2 = d(j2, i2);
            r(atomicReferenceArray, d2 + 1, t3);
            r(atomicReferenceArray, d2, t2);
            t(j3);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.f39934f = atomicReferenceArray2;
        int d3 = d(j2, i2);
        r(atomicReferenceArray2, d3 + 1, t3);
        r(atomicReferenceArray2, d3, t2);
        s(atomicReferenceArray, atomicReferenceArray2);
        r(atomicReferenceArray, d3, f39929k);
        t(j3);
        return true;
    }

    public T n() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f39936h;
        long e2 = e();
        int i2 = this.f39935g;
        T h2 = h(atomicReferenceArray, d(e2, i2));
        if (h2 == f39929k) {
            return k(i(atomicReferenceArray, i2 + 1), e2, i2);
        }
        return h2;
    }

    public boolean offer(T t2) {
        if (t2 != null) {
            AtomicReferenceArray<Object> atomicReferenceArray = this.f39934f;
            long f2 = f();
            int i2 = this.f39933e;
            int d2 = d(f2, i2);
            if (f2 < this.f39932d) {
                return u(atomicReferenceArray, t2, f2, d2);
            }
            long j2 = ((long) this.f39931c) + f2;
            if (h(atomicReferenceArray, d(j2, i2)) == null) {
                this.f39932d = j2 - 1;
                return u(atomicReferenceArray, t2, f2, d2);
            } else if (h(atomicReferenceArray, d(1 + f2, i2)) == null) {
                return u(atomicReferenceArray, t2, f2, d2);
            } else {
                o(atomicReferenceArray, f2, d2, t2, (long) i2);
                return true;
            }
        } else {
            throw new NullPointerException("Null is not a valid element");
        }
    }

    public int p() {
        long g2 = g();
        while (true) {
            long j2 = j();
            long g3 = g();
            if (g2 == g3) {
                return (int) (j2 - g3);
            }
            g2 = g3;
        }
    }

    public T poll() {
        boolean z2;
        AtomicReferenceArray<Object> atomicReferenceArray = this.f39936h;
        long e2 = e();
        int i2 = this.f39935g;
        int d2 = d(e2, i2);
        T h2 = h(atomicReferenceArray, d2);
        if (h2 == f39929k) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (h2 != null && !z2) {
            r(atomicReferenceArray, d2, (Object) null);
            q(e2 + 1);
            return h2;
        } else if (z2) {
            return l(i(atomicReferenceArray, i2 + 1), e2, i2);
        } else {
            return null;
        }
    }
}
