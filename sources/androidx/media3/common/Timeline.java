package androidx.media3.common;

import android.net.Uri;
import android.util.Pair;
import androidx.media3.common.AdPlaybackState;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;

public abstract class Timeline {

    /* renamed from: a  reason: collision with root package name */
    public static final Timeline f4346a = new Timeline() {
        public int b(Object obj) {
            return -1;
        }

        public Period g(int i2, Period period, boolean z2) {
            throw new IndexOutOfBoundsException();
        }

        public int i() {
            return 0;
        }

        public Object m(int i2) {
            throw new IndexOutOfBoundsException();
        }

        public Window o(int i2, Window window, long j2) {
            throw new IndexOutOfBoundsException();
        }

        public int p() {
            return 0;
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private static final String f4347b = Util.B0(0);

    /* renamed from: c  reason: collision with root package name */
    private static final String f4348c = Util.B0(1);

    /* renamed from: d  reason: collision with root package name */
    private static final String f4349d = Util.B0(2);

    public static final class Period {

        /* renamed from: h  reason: collision with root package name */
        private static final String f4350h = Util.B0(0);

        /* renamed from: i  reason: collision with root package name */
        private static final String f4351i = Util.B0(1);

        /* renamed from: j  reason: collision with root package name */
        private static final String f4352j = Util.B0(2);

        /* renamed from: k  reason: collision with root package name */
        private static final String f4353k = Util.B0(3);

        /* renamed from: l  reason: collision with root package name */
        private static final String f4354l = Util.B0(4);

        /* renamed from: a  reason: collision with root package name */
        public Object f4355a;

        /* renamed from: b  reason: collision with root package name */
        public Object f4356b;

        /* renamed from: c  reason: collision with root package name */
        public int f4357c;

        /* renamed from: d  reason: collision with root package name */
        public long f4358d;

        /* renamed from: e  reason: collision with root package name */
        public long f4359e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f4360f;

        /* renamed from: g  reason: collision with root package name */
        private AdPlaybackState f4361g = AdPlaybackState.f3879g;

        public int a(int i2) {
            return this.f4361g.a(i2).f3901b;
        }

        public long b(int i2, int i3) {
            AdPlaybackState.AdGroup a2 = this.f4361g.a(i2);
            if (a2.f3901b != -1) {
                return a2.f3906g[i3];
            }
            return -9223372036854775807L;
        }

        public int c() {
            return this.f4361g.f3886b;
        }

        public int d(long j2) {
            return this.f4361g.b(j2, this.f4358d);
        }

        public int e(long j2) {
            return this.f4361g.c(j2, this.f4358d);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !Period.class.equals(obj.getClass())) {
                return false;
            }
            Period period = (Period) obj;
            if (Util.c(this.f4355a, period.f4355a) && Util.c(this.f4356b, period.f4356b) && this.f4357c == period.f4357c && this.f4358d == period.f4358d && this.f4359e == period.f4359e && this.f4360f == period.f4360f && Util.c(this.f4361g, period.f4361g)) {
                return true;
            }
            return false;
        }

        public long f(int i2) {
            return this.f4361g.a(i2).f3900a;
        }

        public long g() {
            return this.f4361g.f3887c;
        }

        public int h(int i2, int i3) {
            AdPlaybackState.AdGroup a2 = this.f4361g.a(i2);
            if (a2.f3901b != -1) {
                return a2.f3905f[i3];
            }
            return 0;
        }

        public int hashCode() {
            int i2;
            Object obj = this.f4355a;
            int i3 = 0;
            if (obj == null) {
                i2 = 0;
            } else {
                i2 = obj.hashCode();
            }
            int i4 = (217 + i2) * 31;
            Object obj2 = this.f4356b;
            if (obj2 != null) {
                i3 = obj2.hashCode();
            }
            long j2 = this.f4358d;
            long j3 = this.f4359e;
            return ((((((((((i4 + i3) * 31) + this.f4357c) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + (this.f4360f ? 1 : 0)) * 31) + this.f4361g.hashCode();
        }

        public long i(int i2) {
            return this.f4361g.a(i2).f3907h;
        }

        public long j() {
            return this.f4358d;
        }

        public int k(int i2) {
            return this.f4361g.a(i2).d();
        }

        public int l(int i2, int i3) {
            return this.f4361g.a(i2).e(i3);
        }

        public long m() {
            return Util.t1(this.f4359e);
        }

        public long n() {
            return this.f4359e;
        }

        public int o() {
            return this.f4361g.f3889e;
        }

        public boolean p(int i2) {
            return !this.f4361g.a(i2).f();
        }

        public boolean q(int i2) {
            if (i2 != c() - 1 || !this.f4361g.d(i2)) {
                return false;
            }
            return true;
        }

        public boolean r(int i2) {
            return this.f4361g.a(i2).f3908i;
        }

        public Period s(Object obj, Object obj2, int i2, long j2, long j3) {
            return t(obj, obj2, i2, j2, j3, AdPlaybackState.f3879g, false);
        }

        public Period t(Object obj, Object obj2, int i2, long j2, long j3, AdPlaybackState adPlaybackState, boolean z2) {
            this.f4355a = obj;
            this.f4356b = obj2;
            this.f4357c = i2;
            this.f4358d = j2;
            this.f4359e = j3;
            this.f4361g = adPlaybackState;
            this.f4360f = z2;
            return this;
        }
    }

    public static final class Window {
        private static final String A = Util.B0(8);
        private static final String B = Util.B0(9);
        private static final String C = Util.B0(10);
        private static final String D = Util.B0(11);
        private static final String E = Util.B0(12);
        private static final String F = Util.B0(13);

        /* renamed from: q  reason: collision with root package name */
        public static final Object f4362q = new Object();

        /* renamed from: r  reason: collision with root package name */
        private static final Object f4363r = new Object();

        /* renamed from: s  reason: collision with root package name */
        private static final MediaItem f4364s = new MediaItem.Builder().c("androidx.media3.common.Timeline").g(Uri.EMPTY).a();

        /* renamed from: t  reason: collision with root package name */
        private static final String f4365t = Util.B0(1);

        /* renamed from: u  reason: collision with root package name */
        private static final String f4366u = Util.B0(2);

        /* renamed from: v  reason: collision with root package name */
        private static final String f4367v = Util.B0(3);

        /* renamed from: w  reason: collision with root package name */
        private static final String f4368w = Util.B0(4);

        /* renamed from: x  reason: collision with root package name */
        private static final String f4369x = Util.B0(5);

        /* renamed from: y  reason: collision with root package name */
        private static final String f4370y = Util.B0(6);

        /* renamed from: z  reason: collision with root package name */
        private static final String f4371z = Util.B0(7);

        /* renamed from: a  reason: collision with root package name */
        public Object f4372a = f4362q;
        @Deprecated

        /* renamed from: b  reason: collision with root package name */
        public Object f4373b;

        /* renamed from: c  reason: collision with root package name */
        public MediaItem f4374c = f4364s;

        /* renamed from: d  reason: collision with root package name */
        public Object f4375d;

        /* renamed from: e  reason: collision with root package name */
        public long f4376e;

        /* renamed from: f  reason: collision with root package name */
        public long f4377f;

        /* renamed from: g  reason: collision with root package name */
        public long f4378g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f4379h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f4380i;

        /* renamed from: j  reason: collision with root package name */
        public MediaItem.LiveConfiguration f4381j;

        /* renamed from: k  reason: collision with root package name */
        public boolean f4382k;

        /* renamed from: l  reason: collision with root package name */
        public long f4383l;

        /* renamed from: m  reason: collision with root package name */
        public long f4384m;

        /* renamed from: n  reason: collision with root package name */
        public int f4385n;

        /* renamed from: o  reason: collision with root package name */
        public int f4386o;

        /* renamed from: p  reason: collision with root package name */
        public long f4387p;

        public long a() {
            return Util.f0(this.f4378g);
        }

        public long b() {
            return Util.t1(this.f4383l);
        }

        public long c() {
            return this.f4383l;
        }

        public long d() {
            return Util.t1(this.f4384m);
        }

        public long e() {
            return this.f4387p;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !Window.class.equals(obj.getClass())) {
                return false;
            }
            Window window = (Window) obj;
            if (Util.c(this.f4372a, window.f4372a) && Util.c(this.f4374c, window.f4374c) && Util.c(this.f4375d, window.f4375d) && Util.c(this.f4381j, window.f4381j) && this.f4376e == window.f4376e && this.f4377f == window.f4377f && this.f4378g == window.f4378g && this.f4379h == window.f4379h && this.f4380i == window.f4380i && this.f4382k == window.f4382k && this.f4383l == window.f4383l && this.f4384m == window.f4384m && this.f4385n == window.f4385n && this.f4386o == window.f4386o && this.f4387p == window.f4387p) {
                return true;
            }
            return false;
        }

        public boolean f() {
            return this.f4381j != null;
        }

        public Window g(Object obj, MediaItem mediaItem, Object obj2, long j2, long j3, long j4, boolean z2, boolean z3, MediaItem.LiveConfiguration liveConfiguration, long j5, long j6, int i2, int i3, long j7) {
            MediaItem mediaItem2;
            Object obj3;
            MediaItem.LocalConfiguration localConfiguration;
            MediaItem mediaItem3 = mediaItem;
            this.f4372a = obj;
            if (mediaItem3 != null) {
                mediaItem2 = mediaItem3;
            } else {
                mediaItem2 = f4364s;
            }
            this.f4374c = mediaItem2;
            if (mediaItem3 == null || (localConfiguration = mediaItem3.f4079b) == null) {
                obj3 = null;
            } else {
                obj3 = localConfiguration.f4178h;
            }
            this.f4373b = obj3;
            this.f4375d = obj2;
            this.f4376e = j2;
            this.f4377f = j3;
            this.f4378g = j4;
            this.f4379h = z2;
            this.f4380i = z3;
            this.f4381j = liveConfiguration;
            this.f4383l = j5;
            this.f4384m = j6;
            this.f4385n = i2;
            this.f4386o = i3;
            this.f4387p = j7;
            this.f4382k = false;
            return this;
        }

        public int hashCode() {
            int i2;
            int hashCode = (((217 + this.f4372a.hashCode()) * 31) + this.f4374c.hashCode()) * 31;
            Object obj = this.f4375d;
            int i3 = 0;
            if (obj == null) {
                i2 = 0;
            } else {
                i2 = obj.hashCode();
            }
            int i4 = (hashCode + i2) * 31;
            MediaItem.LiveConfiguration liveConfiguration = this.f4381j;
            if (liveConfiguration != null) {
                i3 = liveConfiguration.hashCode();
            }
            long j2 = this.f4376e;
            long j3 = this.f4377f;
            long j4 = this.f4378g;
            long j5 = this.f4383l;
            long j6 = this.f4384m;
            long j7 = this.f4387p;
            return ((((((((((((((((((((((i4 + i3) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + (this.f4379h ? 1 : 0)) * 31) + (this.f4380i ? 1 : 0)) * 31) + (this.f4382k ? 1 : 0)) * 31) + ((int) (j5 ^ (j5 >>> 32)))) * 31) + ((int) (j6 ^ (j6 >>> 32)))) * 31) + this.f4385n) * 31) + this.f4386o) * 31) + ((int) (j7 ^ (j7 >>> 32)));
        }
    }

    protected Timeline() {
    }

    public int a(boolean z2) {
        return q() ? -1 : 0;
    }

    public abstract int b(Object obj);

    public int c(boolean z2) {
        if (q()) {
            return -1;
        }
        return p() - 1;
    }

    public final int d(int i2, Period period, Window window, int i3, boolean z2) {
        int i4 = f(i2, period).f4357c;
        if (n(i4, window).f4386o != i2) {
            return i2 + 1;
        }
        int e2 = e(i4, i3, z2);
        if (e2 == -1) {
            return -1;
        }
        return n(e2, window).f4385n;
    }

    public int e(int i2, int i3, boolean z2) {
        if (i3 != 0) {
            if (i3 == 1) {
                return i2;
            }
            if (i3 != 2) {
                throw new IllegalStateException();
            } else if (i2 == c(z2)) {
                return a(z2);
            } else {
                return i2 + 1;
            }
        } else if (i2 == c(z2)) {
            return -1;
        } else {
            return i2 + 1;
        }
    }

    public boolean equals(Object obj) {
        int c2;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Timeline)) {
            return false;
        }
        Timeline timeline = (Timeline) obj;
        if (timeline.p() != p() || timeline.i() != i()) {
            return false;
        }
        Window window = new Window();
        Period period = new Period();
        Window window2 = new Window();
        Period period2 = new Period();
        for (int i2 = 0; i2 < p(); i2++) {
            if (!n(i2, window).equals(timeline.n(i2, window2))) {
                return false;
            }
        }
        for (int i3 = 0; i3 < i(); i3++) {
            if (!g(i3, period, true).equals(timeline.g(i3, period2, true))) {
                return false;
            }
        }
        int a2 = a(true);
        if (a2 != timeline.a(true) || (c2 = c(true)) != timeline.c(true)) {
            return false;
        }
        while (a2 != c2) {
            int e2 = e(a2, 0, true);
            if (e2 != timeline.e(a2, 0, true)) {
                return false;
            }
            a2 = e2;
        }
        return true;
    }

    public final Period f(int i2, Period period) {
        return g(i2, period, false);
    }

    public abstract Period g(int i2, Period period, boolean z2);

    public Period h(Object obj, Period period) {
        return g(b(obj), period, true);
    }

    public int hashCode() {
        Window window = new Window();
        Period period = new Period();
        int p2 = 217 + p();
        for (int i2 = 0; i2 < p(); i2++) {
            p2 = (p2 * 31) + n(i2, window).hashCode();
        }
        int i3 = (p2 * 31) + i();
        for (int i4 = 0; i4 < i(); i4++) {
            i3 = (i3 * 31) + g(i4, period, true).hashCode();
        }
        int a2 = a(true);
        while (a2 != -1) {
            i3 = (i3 * 31) + a2;
            a2 = e(a2, 0, true);
        }
        return i3;
    }

    public abstract int i();

    public final Pair<Object, Long> j(Window window, Period period, int i2, long j2) {
        return (Pair) Assertions.f(k(window, period, i2, j2, 0));
    }

    public final Pair<Object, Long> k(Window window, Period period, int i2, long j2, long j3) {
        Assertions.c(i2, 0, p());
        o(i2, window, j3);
        if (j2 == -9223372036854775807L) {
            j2 = window.c();
            if (j2 == -9223372036854775807L) {
                return null;
            }
        }
        int i3 = window.f4385n;
        f(i3, period);
        while (i3 < window.f4386o && period.f4359e != j2) {
            int i4 = i3 + 1;
            if (f(i4, period).f4359e > j2) {
                break;
            }
            i3 = i4;
        }
        g(i3, period, true);
        long j4 = j2 - period.f4359e;
        long j5 = period.f4358d;
        if (j5 != -9223372036854775807L) {
            j4 = Math.min(j4, j5 - 1);
        }
        return Pair.create(Assertions.f(period.f4356b), Long.valueOf(Math.max(0, j4)));
    }

    public int l(int i2, int i3, boolean z2) {
        if (i3 != 0) {
            if (i3 == 1) {
                return i2;
            }
            if (i3 != 2) {
                throw new IllegalStateException();
            } else if (i2 == a(z2)) {
                return c(z2);
            } else {
                return i2 - 1;
            }
        } else if (i2 == a(z2)) {
            return -1;
        } else {
            return i2 - 1;
        }
    }

    public abstract Object m(int i2);

    public final Window n(int i2, Window window) {
        return o(i2, window, 0);
    }

    public abstract Window o(int i2, Window window, long j2);

    public abstract int p();

    public final boolean q() {
        return p() == 0;
    }

    public final boolean r(int i2, Period period, Window window, int i3, boolean z2) {
        return d(i2, period, window, i3, z2) == -1;
    }
}
