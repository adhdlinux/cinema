package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.util.Assertions;

public abstract class AbstractConcatenatedTimeline extends Timeline {

    /* renamed from: g  reason: collision with root package name */
    private final int f22780g;

    /* renamed from: h  reason: collision with root package name */
    private final ShuffleOrder f22781h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f22782i;

    public AbstractConcatenatedTimeline(boolean z2, ShuffleOrder shuffleOrder) {
        this.f22782i = z2;
        this.f22781h = shuffleOrder;
        this.f22780g = shuffleOrder.getLength();
    }

    public static Object A(Object obj) {
        return ((Pair) obj).first;
    }

    public static Object C(Object obj, Object obj2) {
        return Pair.create(obj, obj2);
    }

    private int F(int i2, boolean z2) {
        if (z2) {
            return this.f22781h.c(i2);
        }
        if (i2 < this.f22780g - 1) {
            return i2 + 1;
        }
        return -1;
    }

    private int G(int i2, boolean z2) {
        if (z2) {
            return this.f22781h.b(i2);
        }
        if (i2 > 0) {
            return i2 - 1;
        }
        return -1;
    }

    public static Object z(Object obj) {
        return ((Pair) obj).second;
    }

    /* access modifiers changed from: protected */
    public abstract Object B(int i2);

    /* access modifiers changed from: protected */
    public abstract int D(int i2);

    /* access modifiers changed from: protected */
    public abstract int E(int i2);

    /* access modifiers changed from: protected */
    public abstract Timeline H(int i2);

    public int e(boolean z2) {
        if (this.f22780g == 0) {
            return -1;
        }
        int i2 = 0;
        if (this.f22782i) {
            z2 = false;
        }
        if (z2) {
            i2 = this.f22781h.f();
        }
        while (H(i2).u()) {
            i2 = F(i2, z2);
            if (i2 == -1) {
                return -1;
            }
        }
        return E(i2) + H(i2).e(z2);
    }

    public final int f(Object obj) {
        int f2;
        if (!(obj instanceof Pair)) {
            return -1;
        }
        Object A = A(obj);
        Object z2 = z(obj);
        int w2 = w(A);
        if (w2 == -1 || (f2 = H(w2).f(z2)) == -1) {
            return -1;
        }
        return D(w2) + f2;
    }

    public int g(boolean z2) {
        int i2;
        int i3 = this.f22780g;
        if (i3 == 0) {
            return -1;
        }
        if (this.f22782i) {
            z2 = false;
        }
        if (z2) {
            i2 = this.f22781h.d();
        } else {
            i2 = i3 - 1;
        }
        while (H(i2).u()) {
            i2 = G(i2, z2);
            if (i2 == -1) {
                return -1;
            }
        }
        return E(i2) + H(i2).g(z2);
    }

    public int i(int i2, int i3, boolean z2) {
        int i4 = 0;
        if (this.f22782i) {
            if (i3 == 1) {
                i3 = 2;
            }
            z2 = false;
        }
        int y2 = y(i2);
        int E = E(y2);
        Timeline H = H(y2);
        int i5 = i2 - E;
        if (i3 != 2) {
            i4 = i3;
        }
        int i6 = H.i(i5, i4, z2);
        if (i6 != -1) {
            return E + i6;
        }
        int F = F(y2, z2);
        while (F != -1 && H(F).u()) {
            F = F(F, z2);
        }
        if (F != -1) {
            return E(F) + H(F).e(z2);
        }
        if (i3 == 2) {
            return e(z2);
        }
        return -1;
    }

    public final Timeline.Period k(int i2, Timeline.Period period, boolean z2) {
        int x2 = x(i2);
        int E = E(x2);
        H(x2).k(i2 - D(x2), period, z2);
        period.f23494d += E;
        if (z2) {
            period.f23493c = C(B(x2), Assertions.e(period.f23493c));
        }
        return period;
    }

    public final Timeline.Period l(Object obj, Timeline.Period period) {
        Object A = A(obj);
        Object z2 = z(obj);
        int w2 = w(A);
        int E = E(w2);
        H(w2).l(z2, period);
        period.f23494d += E;
        period.f23493c = obj;
        return period;
    }

    public int p(int i2, int i3, boolean z2) {
        int i4 = 0;
        if (this.f22782i) {
            if (i3 == 1) {
                i3 = 2;
            }
            z2 = false;
        }
        int y2 = y(i2);
        int E = E(y2);
        Timeline H = H(y2);
        int i5 = i2 - E;
        if (i3 != 2) {
            i4 = i3;
        }
        int p2 = H.p(i5, i4, z2);
        if (p2 != -1) {
            return E + p2;
        }
        int G = G(y2, z2);
        while (G != -1 && H(G).u()) {
            G = G(G, z2);
        }
        if (G != -1) {
            return E(G) + H(G).g(z2);
        }
        if (i3 == 2) {
            return g(z2);
        }
        return -1;
    }

    public final Object q(int i2) {
        int x2 = x(i2);
        return C(B(x2), H(x2).q(i2 - D(x2)));
    }

    public final Timeline.Window s(int i2, Timeline.Window window, long j2) {
        int y2 = y(i2);
        int E = E(y2);
        int D = D(y2);
        H(y2).s(i2 - E, window, j2);
        Object B = B(y2);
        if (!Timeline.Window.f23503s.equals(window.f23511b)) {
            B = C(B, window.f23511b);
        }
        window.f23511b = B;
        window.f23525p += D;
        window.f23526q += D;
        return window;
    }

    /* access modifiers changed from: protected */
    public abstract int w(Object obj);

    /* access modifiers changed from: protected */
    public abstract int x(int i2);

    /* access modifiers changed from: protected */
    public abstract int y(int i2);
}
