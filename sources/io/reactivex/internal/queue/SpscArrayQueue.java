package io.reactivex.internal.queue;

import com.google.protobuf.CodedOutputStream;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.util.Pow2;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class SpscArrayQueue<E> extends AtomicReferenceArray<E> implements SimplePlainQueue<E> {

    /* renamed from: g  reason: collision with root package name */
    private static final Integer f39922g = Integer.getInteger("jctools.spsc.max.lookahead.step", CodedOutputStream.DEFAULT_BUFFER_SIZE);

    /* renamed from: b  reason: collision with root package name */
    final int f39923b = (length() - 1);

    /* renamed from: c  reason: collision with root package name */
    final AtomicLong f39924c = new AtomicLong();

    /* renamed from: d  reason: collision with root package name */
    long f39925d;

    /* renamed from: e  reason: collision with root package name */
    final AtomicLong f39926e = new AtomicLong();

    /* renamed from: f  reason: collision with root package name */
    final int f39927f;

    public SpscArrayQueue(int i2) {
        super(Pow2.a(i2));
        this.f39927f = Math.min(i2 / 4, f39922g.intValue());
    }

    /* access modifiers changed from: package-private */
    public int a(long j2) {
        return this.f39923b & ((int) j2);
    }

    /* access modifiers changed from: package-private */
    public int c(long j2, int i2) {
        return ((int) j2) & i2;
    }

    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public E d(int i2) {
        return get(i2);
    }

    /* access modifiers changed from: package-private */
    public void e(long j2) {
        this.f39926e.lazySet(j2);
    }

    /* access modifiers changed from: package-private */
    public void f(int i2, E e2) {
        lazySet(i2, e2);
    }

    /* access modifiers changed from: package-private */
    public void g(long j2) {
        this.f39924c.lazySet(j2);
    }

    public boolean isEmpty() {
        return this.f39924c.get() == this.f39926e.get();
    }

    public boolean offer(E e2) {
        if (e2 != null) {
            int i2 = this.f39923b;
            long j2 = this.f39924c.get();
            int c2 = c(j2, i2);
            if (j2 >= this.f39925d) {
                long j3 = ((long) this.f39927f) + j2;
                if (d(c(j3, i2)) == null) {
                    this.f39925d = j3;
                } else if (d(c2) != null) {
                    return false;
                }
            }
            f(c2, e2);
            g(j2 + 1);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    public E poll() {
        long j2 = this.f39926e.get();
        int a2 = a(j2);
        E d2 = d(a2);
        if (d2 == null) {
            return null;
        }
        e(j2 + 1);
        f(a2, (Object) null);
        return d2;
    }
}
