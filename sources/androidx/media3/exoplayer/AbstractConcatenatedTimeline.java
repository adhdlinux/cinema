package androidx.media3.exoplayer;

import android.util.Pair;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.exoplayer.source.ShuffleOrder;

public abstract class AbstractConcatenatedTimeline extends Timeline {

    /* renamed from: e  reason: collision with root package name */
    private final int f5113e;

    /* renamed from: f  reason: collision with root package name */
    private final ShuffleOrder f5114f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f5115g;

    public AbstractConcatenatedTimeline(boolean z2, ShuffleOrder shuffleOrder) {
        this.f5115g = z2;
        this.f5114f = shuffleOrder;
        this.f5113e = shuffleOrder.getLength();
    }

    private int B(int i2, boolean z2) {
        if (z2) {
            return this.f5114f.c(i2);
        }
        if (i2 < this.f5113e - 1) {
            return i2 + 1;
        }
        return -1;
    }

    private int C(int i2, boolean z2) {
        if (z2) {
            return this.f5114f.b(i2);
        }
        if (i2 > 0) {
            return i2 - 1;
        }
        return -1;
    }

    public static Object v(Object obj) {
        return ((Pair) obj).second;
    }

    public static Object w(Object obj) {
        return ((Pair) obj).first;
    }

    public static Object y(Object obj, Object obj2) {
        return Pair.create(obj, obj2);
    }

    /* access modifiers changed from: protected */
    public abstract int A(int i2);

    /* access modifiers changed from: protected */
    public abstract Timeline D(int i2);

    public int a(boolean z2) {
        if (this.f5113e == 0) {
            return -1;
        }
        int i2 = 0;
        if (this.f5115g) {
            z2 = false;
        }
        if (z2) {
            i2 = this.f5114f.f();
        }
        while (D(i2).q()) {
            i2 = B(i2, z2);
            if (i2 == -1) {
                return -1;
            }
        }
        return A(i2) + D(i2).a(z2);
    }

    public final int b(Object obj) {
        int b2;
        if (!(obj instanceof Pair)) {
            return -1;
        }
        Object w2 = w(obj);
        Object v2 = v(obj);
        int s2 = s(w2);
        if (s2 == -1 || (b2 = D(s2).b(v2)) == -1) {
            return -1;
        }
        return z(s2) + b2;
    }

    public int c(boolean z2) {
        int i2;
        int i3 = this.f5113e;
        if (i3 == 0) {
            return -1;
        }
        if (this.f5115g) {
            z2 = false;
        }
        if (z2) {
            i2 = this.f5114f.d();
        } else {
            i2 = i3 - 1;
        }
        while (D(i2).q()) {
            i2 = C(i2, z2);
            if (i2 == -1) {
                return -1;
            }
        }
        return A(i2) + D(i2).c(z2);
    }

    public int e(int i2, int i3, boolean z2) {
        int i4 = 0;
        if (this.f5115g) {
            if (i3 == 1) {
                i3 = 2;
            }
            z2 = false;
        }
        int u2 = u(i2);
        int A = A(u2);
        Timeline D = D(u2);
        int i5 = i2 - A;
        if (i3 != 2) {
            i4 = i3;
        }
        int e2 = D.e(i5, i4, z2);
        if (e2 != -1) {
            return A + e2;
        }
        int B = B(u2, z2);
        while (B != -1 && D(B).q()) {
            B = B(B, z2);
        }
        if (B != -1) {
            return A(B) + D(B).a(z2);
        }
        if (i3 == 2) {
            return a(z2);
        }
        return -1;
    }

    public final Timeline.Period g(int i2, Timeline.Period period, boolean z2) {
        int t2 = t(i2);
        int A = A(t2);
        D(t2).g(i2 - z(t2), period, z2);
        period.f4357c += A;
        if (z2) {
            period.f4356b = y(x(t2), Assertions.f(period.f4356b));
        }
        return period;
    }

    public final Timeline.Period h(Object obj, Timeline.Period period) {
        Object w2 = w(obj);
        Object v2 = v(obj);
        int s2 = s(w2);
        int A = A(s2);
        D(s2).h(v2, period);
        period.f4357c += A;
        period.f4356b = obj;
        return period;
    }

    public int l(int i2, int i3, boolean z2) {
        int i4 = 0;
        if (this.f5115g) {
            if (i3 == 1) {
                i3 = 2;
            }
            z2 = false;
        }
        int u2 = u(i2);
        int A = A(u2);
        Timeline D = D(u2);
        int i5 = i2 - A;
        if (i3 != 2) {
            i4 = i3;
        }
        int l2 = D.l(i5, i4, z2);
        if (l2 != -1) {
            return A + l2;
        }
        int C = C(u2, z2);
        while (C != -1 && D(C).q()) {
            C = C(C, z2);
        }
        if (C != -1) {
            return A(C) + D(C).c(z2);
        }
        if (i3 == 2) {
            return c(z2);
        }
        return -1;
    }

    public final Object m(int i2) {
        int t2 = t(i2);
        return y(x(t2), D(t2).m(i2 - z(t2)));
    }

    public final Timeline.Window o(int i2, Timeline.Window window, long j2) {
        int u2 = u(i2);
        int A = A(u2);
        int z2 = z(u2);
        D(u2).o(i2 - A, window, j2);
        Object x2 = x(u2);
        if (!Timeline.Window.f4362q.equals(window.f4372a)) {
            x2 = y(x2, window.f4372a);
        }
        window.f4372a = x2;
        window.f4385n += z2;
        window.f4386o += z2;
        return window;
    }

    /* access modifiers changed from: protected */
    public abstract int s(Object obj);

    /* access modifiers changed from: protected */
    public abstract int t(int i2);

    /* access modifiers changed from: protected */
    public abstract int u(int i2);

    /* access modifiers changed from: protected */
    public abstract Object x(int i2);

    /* access modifiers changed from: protected */
    public abstract int z(int i2);
}
