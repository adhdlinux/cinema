package androidx.media3.common.util;

import com.facebook.common.time.Clock;
import java.util.Arrays;

public final class TimedValueQueue<V> {

    /* renamed from: a  reason: collision with root package name */
    private long[] f4706a;

    /* renamed from: b  reason: collision with root package name */
    private V[] f4707b;

    /* renamed from: c  reason: collision with root package name */
    private int f4708c;

    /* renamed from: d  reason: collision with root package name */
    private int f4709d;

    public TimedValueQueue() {
        this(10);
    }

    private void b(long j2, V v2) {
        int i2 = this.f4708c;
        int i3 = this.f4709d;
        V[] vArr = this.f4707b;
        int length = (i2 + i3) % vArr.length;
        this.f4706a[length] = j2;
        vArr[length] = v2;
        this.f4709d = i3 + 1;
    }

    private void d(long j2) {
        int i2 = this.f4709d;
        if (i2 > 0) {
            if (j2 <= this.f4706a[((this.f4708c + i2) - 1) % this.f4707b.length]) {
                c();
            }
        }
    }

    private void e() {
        int length = this.f4707b.length;
        if (this.f4709d >= length) {
            int i2 = length * 2;
            long[] jArr = new long[i2];
            V[] f2 = f(i2);
            int i3 = this.f4708c;
            int i4 = length - i3;
            System.arraycopy(this.f4706a, i3, jArr, 0, i4);
            System.arraycopy(this.f4707b, this.f4708c, f2, 0, i4);
            int i5 = this.f4708c;
            if (i5 > 0) {
                System.arraycopy(this.f4706a, 0, jArr, i4, i5);
                System.arraycopy(this.f4707b, 0, f2, i4, this.f4708c);
            }
            this.f4706a = jArr;
            this.f4707b = f2;
            this.f4708c = 0;
        }
    }

    private static <V> V[] f(int i2) {
        return new Object[i2];
    }

    private V h(long j2, boolean z2) {
        V v2 = null;
        long j3 = Clock.MAX_TIME;
        while (this.f4709d > 0) {
            long j4 = j2 - this.f4706a[this.f4708c];
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
        if (this.f4709d > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.h(z2);
        V[] vArr = this.f4707b;
        int i2 = this.f4708c;
        V v2 = vArr[i2];
        vArr[i2] = null;
        this.f4708c = (i2 + 1) % vArr.length;
        this.f4709d--;
        return v2;
    }

    public synchronized void a(long j2, V v2) {
        d(j2);
        e();
        b(j2, v2);
    }

    public synchronized void c() {
        this.f4708c = 0;
        this.f4709d = 0;
        Arrays.fill(this.f4707b, (Object) null);
    }

    public synchronized V g(long j2) {
        return h(j2, false);
    }

    public synchronized V i() {
        V v2;
        if (this.f4709d == 0) {
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
        return this.f4709d;
    }

    public TimedValueQueue(int i2) {
        this.f4706a = new long[i2];
        this.f4707b = f(i2);
    }
}
