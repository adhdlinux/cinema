package com.google.android.exoplayer2.util;

import com.facebook.common.time.Clock;
import java.util.Arrays;

public final class TimedValueQueue<V> {

    /* renamed from: a  reason: collision with root package name */
    private long[] f28800a;

    /* renamed from: b  reason: collision with root package name */
    private V[] f28801b;

    /* renamed from: c  reason: collision with root package name */
    private int f28802c;

    /* renamed from: d  reason: collision with root package name */
    private int f28803d;

    public TimedValueQueue() {
        this(10);
    }

    private void b(long j2, V v2) {
        int i2 = this.f28802c;
        int i3 = this.f28803d;
        V[] vArr = this.f28801b;
        int length = (i2 + i3) % vArr.length;
        this.f28800a[length] = j2;
        vArr[length] = v2;
        this.f28803d = i3 + 1;
    }

    private void d(long j2) {
        int i2 = this.f28803d;
        if (i2 > 0) {
            if (j2 <= this.f28800a[((this.f28802c + i2) - 1) % this.f28801b.length]) {
                c();
            }
        }
    }

    private void e() {
        int length = this.f28801b.length;
        if (this.f28803d >= length) {
            int i2 = length * 2;
            long[] jArr = new long[i2];
            V[] f2 = f(i2);
            int i3 = this.f28802c;
            int i4 = length - i3;
            System.arraycopy(this.f28800a, i3, jArr, 0, i4);
            System.arraycopy(this.f28801b, this.f28802c, f2, 0, i4);
            int i5 = this.f28802c;
            if (i5 > 0) {
                System.arraycopy(this.f28800a, 0, jArr, i4, i5);
                System.arraycopy(this.f28801b, 0, f2, i4, this.f28802c);
            }
            this.f28800a = jArr;
            this.f28801b = f2;
            this.f28802c = 0;
        }
    }

    private static <V> V[] f(int i2) {
        return new Object[i2];
    }

    private V h(long j2, boolean z2) {
        V v2 = null;
        long j3 = Clock.MAX_TIME;
        while (this.f28803d > 0) {
            long j4 = j2 - this.f28800a[this.f28802c];
            if (j4 < 0 && (z2 || (-j4) >= j3)) {
                break;
            }
            v2 = k();
            j3 = j4;
        }
        return v2;
    }

    private V k() {
        boolean z2;
        if (this.f28803d > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.g(z2);
        V[] vArr = this.f28801b;
        int i2 = this.f28802c;
        V v2 = vArr[i2];
        vArr[i2] = null;
        this.f28802c = (i2 + 1) % vArr.length;
        this.f28803d--;
        return v2;
    }

    public synchronized void a(long j2, V v2) {
        d(j2);
        e();
        b(j2, v2);
    }

    public synchronized void c() {
        this.f28802c = 0;
        this.f28803d = 0;
        Arrays.fill(this.f28801b, (Object) null);
    }

    public synchronized V g(long j2) {
        return h(j2, false);
    }

    public synchronized V i() {
        V v2;
        if (this.f28803d == 0) {
            v2 = null;
        } else {
            v2 = k();
        }
        return v2;
    }

    public synchronized V j(long j2) {
        return h(j2, true);
    }

    public synchronized int l() {
        return this.f28803d;
    }

    public TimedValueQueue(int i2) {
        this.f28800a = new long[i2];
        this.f28801b = f(i2);
    }
}
