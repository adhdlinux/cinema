package com.google.android.exoplayer2;

import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Pair;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.source.ads.AdPlaybackState;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.BundleUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;

public abstract class Timeline implements Bundleable {

    /* renamed from: b  reason: collision with root package name */
    public static final Timeline f23481b = new Timeline() {
        public int f(Object obj) {
            return -1;
        }

        public Period k(int i2, Period period, boolean z2) {
            throw new IndexOutOfBoundsException();
        }

        public int m() {
            return 0;
        }

        public Object q(int i2) {
            throw new IndexOutOfBoundsException();
        }

        public Window s(int i2, Window window, long j2) {
            throw new IndexOutOfBoundsException();
        }

        public int t() {
            return 0;
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private static final String f23482c = Util.u0(0);

    /* renamed from: d  reason: collision with root package name */
    private static final String f23483d = Util.u0(1);

    /* renamed from: e  reason: collision with root package name */
    private static final String f23484e = Util.u0(2);

    /* renamed from: f  reason: collision with root package name */
    public static final Bundleable.Creator<Timeline> f23485f = new f2();

    public static final class Period implements Bundleable {

        /* renamed from: i  reason: collision with root package name */
        private static final String f23486i = Util.u0(0);

        /* renamed from: j  reason: collision with root package name */
        private static final String f23487j = Util.u0(1);

        /* renamed from: k  reason: collision with root package name */
        private static final String f23488k = Util.u0(2);

        /* renamed from: l  reason: collision with root package name */
        private static final String f23489l = Util.u0(3);

        /* renamed from: m  reason: collision with root package name */
        private static final String f23490m = Util.u0(4);

        /* renamed from: n  reason: collision with root package name */
        public static final Bundleable.Creator<Period> f23491n = new g2();

        /* renamed from: b  reason: collision with root package name */
        public Object f23492b;

        /* renamed from: c  reason: collision with root package name */
        public Object f23493c;

        /* renamed from: d  reason: collision with root package name */
        public int f23494d;

        /* renamed from: e  reason: collision with root package name */
        public long f23495e;

        /* renamed from: f  reason: collision with root package name */
        public long f23496f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f23497g;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public AdPlaybackState f23498h = AdPlaybackState.f26018h;

        /* access modifiers changed from: private */
        public static Period c(Bundle bundle) {
            AdPlaybackState adPlaybackState;
            int i2 = bundle.getInt(f23486i, 0);
            long j2 = bundle.getLong(f23487j, -9223372036854775807L);
            long j3 = bundle.getLong(f23488k, 0);
            boolean z2 = bundle.getBoolean(f23489l, false);
            Bundle bundle2 = bundle.getBundle(f23490m);
            if (bundle2 != null) {
                adPlaybackState = AdPlaybackState.f26024n.a(bundle2);
            } else {
                adPlaybackState = AdPlaybackState.f26018h;
            }
            AdPlaybackState adPlaybackState2 = adPlaybackState;
            Period period = new Period();
            period.v((Object) null, (Object) null, i2, j2, j3, adPlaybackState2, z2);
            return period;
        }

        public int d(int i2) {
            return this.f23498h.c(i2).f26041c;
        }

        public long e(int i2, int i3) {
            AdPlaybackState.AdGroup c2 = this.f23498h.c(i2);
            if (c2.f26041c != -1) {
                return c2.f26045g[i3];
            }
            return -9223372036854775807L;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !Period.class.equals(obj.getClass())) {
                return false;
            }
            Period period = (Period) obj;
            if (Util.c(this.f23492b, period.f23492b) && Util.c(this.f23493c, period.f23493c) && this.f23494d == period.f23494d && this.f23495e == period.f23495e && this.f23496f == period.f23496f && this.f23497g == period.f23497g && Util.c(this.f23498h, period.f23498h)) {
                return true;
            }
            return false;
        }

        public int f() {
            return this.f23498h.f26026c;
        }

        public int g(long j2) {
            return this.f23498h.d(j2, this.f23495e);
        }

        public int h(long j2) {
            return this.f23498h.e(j2, this.f23495e);
        }

        public int hashCode() {
            int i2;
            Object obj = this.f23492b;
            int i3 = 0;
            if (obj == null) {
                i2 = 0;
            } else {
                i2 = obj.hashCode();
            }
            int i4 = (217 + i2) * 31;
            Object obj2 = this.f23493c;
            if (obj2 != null) {
                i3 = obj2.hashCode();
            }
            long j2 = this.f23495e;
            long j3 = this.f23496f;
            return ((((((((((i4 + i3) * 31) + this.f23494d) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + (this.f23497g ? 1 : 0)) * 31) + this.f23498h.hashCode();
        }

        public long i(int i2) {
            return this.f23498h.c(i2).f26040b;
        }

        public long j() {
            return this.f23498h.f26027d;
        }

        public int k(int i2, int i3) {
            AdPlaybackState.AdGroup c2 = this.f23498h.c(i2);
            if (c2.f26041c != -1) {
                return c2.f26044f[i3];
            }
            return 0;
        }

        public long l(int i2) {
            return this.f23498h.c(i2).f26046h;
        }

        public long m() {
            return this.f23495e;
        }

        public int n(int i2) {
            return this.f23498h.c(i2).e();
        }

        public int o(int i2, int i3) {
            return this.f23498h.c(i2).f(i3);
        }

        public long p() {
            return Util.i1(this.f23496f);
        }

        public long q() {
            return this.f23496f;
        }

        public int r() {
            return this.f23498h.f26029f;
        }

        public boolean s(int i2) {
            return !this.f23498h.c(i2).g();
        }

        public boolean t(int i2) {
            return this.f23498h.c(i2).f26047i;
        }

        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            int i2 = this.f23494d;
            if (i2 != 0) {
                bundle.putInt(f23486i, i2);
            }
            long j2 = this.f23495e;
            if (j2 != -9223372036854775807L) {
                bundle.putLong(f23487j, j2);
            }
            long j3 = this.f23496f;
            if (j3 != 0) {
                bundle.putLong(f23488k, j3);
            }
            boolean z2 = this.f23497g;
            if (z2) {
                bundle.putBoolean(f23489l, z2);
            }
            if (!this.f23498h.equals(AdPlaybackState.f26018h)) {
                bundle.putBundle(f23490m, this.f23498h.toBundle());
            }
            return bundle;
        }

        public Period u(Object obj, Object obj2, int i2, long j2, long j3) {
            return v(obj, obj2, i2, j2, j3, AdPlaybackState.f26018h, false);
        }

        public Period v(Object obj, Object obj2, int i2, long j2, long j3, AdPlaybackState adPlaybackState, boolean z2) {
            this.f23492b = obj;
            this.f23493c = obj2;
            this.f23494d = i2;
            this.f23495e = j2;
            this.f23496f = j3;
            this.f23498h = adPlaybackState;
            this.f23497g = z2;
            return this;
        }
    }

    public static final class RemotableTimeline extends Timeline {

        /* renamed from: g  reason: collision with root package name */
        private final ImmutableList<Window> f23499g;

        /* renamed from: h  reason: collision with root package name */
        private final ImmutableList<Period> f23500h;

        /* renamed from: i  reason: collision with root package name */
        private final int[] f23501i;

        /* renamed from: j  reason: collision with root package name */
        private final int[] f23502j;

        public RemotableTimeline(ImmutableList<Window> immutableList, ImmutableList<Period> immutableList2, int[] iArr) {
            boolean z2;
            if (immutableList.size() == iArr.length) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.a(z2);
            this.f23499g = immutableList;
            this.f23500h = immutableList2;
            this.f23501i = iArr;
            this.f23502j = new int[iArr.length];
            for (int i2 = 0; i2 < iArr.length; i2++) {
                this.f23502j[iArr[i2]] = i2;
            }
        }

        public int e(boolean z2) {
            if (u()) {
                return -1;
            }
            if (z2) {
                return this.f23501i[0];
            }
            return 0;
        }

        public int f(Object obj) {
            throw new UnsupportedOperationException();
        }

        public int g(boolean z2) {
            if (u()) {
                return -1;
            }
            if (z2) {
                return this.f23501i[t() - 1];
            }
            return t() - 1;
        }

        public int i(int i2, int i3, boolean z2) {
            if (i3 == 1) {
                return i2;
            }
            if (i2 == g(z2)) {
                if (i3 == 2) {
                    return e(z2);
                }
                return -1;
            } else if (z2) {
                return this.f23501i[this.f23502j[i2] + 1];
            } else {
                return i2 + 1;
            }
        }

        public Period k(int i2, Period period, boolean z2) {
            Period period2 = this.f23500h.get(i2);
            period.v(period2.f23492b, period2.f23493c, period2.f23494d, period2.f23495e, period2.f23496f, period2.f23498h, period2.f23497g);
            return period;
        }

        public int m() {
            return this.f23500h.size();
        }

        public int p(int i2, int i3, boolean z2) {
            if (i3 == 1) {
                return i2;
            }
            if (i2 == e(z2)) {
                if (i3 == 2) {
                    return g(z2);
                }
                return -1;
            } else if (z2) {
                return this.f23501i[this.f23502j[i2] - 1];
            } else {
                return i2 - 1;
            }
        }

        public Object q(int i2) {
            throw new UnsupportedOperationException();
        }

        public Window s(int i2, Window window, long j2) {
            Window window2 = window;
            Window window3 = this.f23499g.get(i2);
            Object obj = window3.f23511b;
            MediaItem mediaItem = window3.f23513d;
            MediaItem mediaItem2 = mediaItem;
            Window window4 = window3;
            Window window5 = window;
            window5.i(obj, mediaItem2, window3.f23514e, window3.f23515f, window3.f23516g, window3.f23517h, window3.f23518i, window3.f23519j, window3.f23521l, window3.f23523n, window4.f23524o, window4.f23525p, window4.f23526q, window4.f23527r);
            Window window6 = window;
            window6.f23522m = window4.f23522m;
            return window6;
        }

        public int t() {
            return this.f23499g.size();
        }
    }

    public static final class Window implements Bundleable {
        private static final String A = Util.u0(6);
        private static final String B = Util.u0(7);
        private static final String C = Util.u0(8);
        private static final String D = Util.u0(9);
        private static final String E = Util.u0(10);
        private static final String F = Util.u0(11);
        private static final String G = Util.u0(12);
        private static final String H = Util.u0(13);
        public static final Bundleable.Creator<Window> I = new h2();

        /* renamed from: s  reason: collision with root package name */
        public static final Object f23503s = new Object();

        /* renamed from: t  reason: collision with root package name */
        private static final Object f23504t = new Object();

        /* renamed from: u  reason: collision with root package name */
        private static final MediaItem f23505u = new MediaItem.Builder().d("com.google.android.exoplayer2.Timeline").i(Uri.EMPTY).a();

        /* renamed from: v  reason: collision with root package name */
        private static final String f23506v = Util.u0(1);

        /* renamed from: w  reason: collision with root package name */
        private static final String f23507w = Util.u0(2);

        /* renamed from: x  reason: collision with root package name */
        private static final String f23508x = Util.u0(3);

        /* renamed from: y  reason: collision with root package name */
        private static final String f23509y = Util.u0(4);

        /* renamed from: z  reason: collision with root package name */
        private static final String f23510z = Util.u0(5);

        /* renamed from: b  reason: collision with root package name */
        public Object f23511b = f23503s;
        @Deprecated

        /* renamed from: c  reason: collision with root package name */
        public Object f23512c;

        /* renamed from: d  reason: collision with root package name */
        public MediaItem f23513d = f23505u;

        /* renamed from: e  reason: collision with root package name */
        public Object f23514e;

        /* renamed from: f  reason: collision with root package name */
        public long f23515f;

        /* renamed from: g  reason: collision with root package name */
        public long f23516g;

        /* renamed from: h  reason: collision with root package name */
        public long f23517h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f23518i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f23519j;
        @Deprecated

        /* renamed from: k  reason: collision with root package name */
        public boolean f23520k;

        /* renamed from: l  reason: collision with root package name */
        public MediaItem.LiveConfiguration f23521l;

        /* renamed from: m  reason: collision with root package name */
        public boolean f23522m;

        /* renamed from: n  reason: collision with root package name */
        public long f23523n;

        /* renamed from: o  reason: collision with root package name */
        public long f23524o;

        /* renamed from: p  reason: collision with root package name */
        public int f23525p;

        /* renamed from: q  reason: collision with root package name */
        public int f23526q;

        /* renamed from: r  reason: collision with root package name */
        public long f23527r;

        /* access modifiers changed from: private */
        public static Window b(Bundle bundle) {
            MediaItem mediaItem;
            MediaItem.LiveConfiguration liveConfiguration;
            Bundle bundle2 = bundle;
            Bundle bundle3 = bundle2.getBundle(f23506v);
            if (bundle3 != null) {
                mediaItem = MediaItem.f23127p.a(bundle3);
            } else {
                mediaItem = MediaItem.f23121j;
            }
            MediaItem mediaItem2 = mediaItem;
            long j2 = bundle2.getLong(f23507w, -9223372036854775807L);
            long j3 = bundle2.getLong(f23508x, -9223372036854775807L);
            long j4 = bundle2.getLong(f23509y, -9223372036854775807L);
            boolean z2 = bundle2.getBoolean(f23510z, false);
            boolean z3 = bundle2.getBoolean(A, false);
            Bundle bundle4 = bundle2.getBundle(B);
            if (bundle4 != null) {
                liveConfiguration = MediaItem.LiveConfiguration.f23191m.a(bundle4);
            } else {
                liveConfiguration = null;
            }
            MediaItem.LiveConfiguration liveConfiguration2 = liveConfiguration;
            boolean z4 = bundle2.getBoolean(C, false);
            long j5 = bundle2.getLong(D, 0);
            long j6 = bundle2.getLong(E, -9223372036854775807L);
            int i2 = bundle2.getInt(F, 0);
            int i3 = bundle2.getInt(G, 0);
            long j7 = bundle2.getLong(H, 0);
            Window window = r0;
            Window window2 = new Window();
            window.i(f23504t, mediaItem2, (Object) null, j2, j3, j4, z2, z3, liveConfiguration2, j5, j6, i2, i3, j7);
            window2.f23522m = z4;
            return window2;
        }

        public long c() {
            return Util.c0(this.f23517h);
        }

        public long d() {
            return Util.i1(this.f23523n);
        }

        public long e() {
            return this.f23523n;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !Window.class.equals(obj.getClass())) {
                return false;
            }
            Window window = (Window) obj;
            if (Util.c(this.f23511b, window.f23511b) && Util.c(this.f23513d, window.f23513d) && Util.c(this.f23514e, window.f23514e) && Util.c(this.f23521l, window.f23521l) && this.f23515f == window.f23515f && this.f23516g == window.f23516g && this.f23517h == window.f23517h && this.f23518i == window.f23518i && this.f23519j == window.f23519j && this.f23522m == window.f23522m && this.f23523n == window.f23523n && this.f23524o == window.f23524o && this.f23525p == window.f23525p && this.f23526q == window.f23526q && this.f23527r == window.f23527r) {
                return true;
            }
            return false;
        }

        public long f() {
            return Util.i1(this.f23524o);
        }

        public long g() {
            return this.f23527r;
        }

        public boolean h() {
            boolean z2;
            boolean z3;
            boolean z4 = this.f23520k;
            if (this.f23521l != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z4 == z2) {
                z3 = true;
            } else {
                z3 = false;
            }
            Assertions.g(z3);
            if (this.f23521l != null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i2;
            int hashCode = (((217 + this.f23511b.hashCode()) * 31) + this.f23513d.hashCode()) * 31;
            Object obj = this.f23514e;
            int i3 = 0;
            if (obj == null) {
                i2 = 0;
            } else {
                i2 = obj.hashCode();
            }
            int i4 = (hashCode + i2) * 31;
            MediaItem.LiveConfiguration liveConfiguration = this.f23521l;
            if (liveConfiguration != null) {
                i3 = liveConfiguration.hashCode();
            }
            long j2 = this.f23515f;
            long j3 = this.f23516g;
            long j4 = this.f23517h;
            long j5 = this.f23523n;
            long j6 = this.f23524o;
            long j7 = this.f23527r;
            return ((((((((((((((((((((((i4 + i3) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + (this.f23518i ? 1 : 0)) * 31) + (this.f23519j ? 1 : 0)) * 31) + (this.f23522m ? 1 : 0)) * 31) + ((int) (j5 ^ (j5 >>> 32)))) * 31) + ((int) (j6 ^ (j6 >>> 32)))) * 31) + this.f23525p) * 31) + this.f23526q) * 31) + ((int) (j7 ^ (j7 >>> 32)));
        }

        public Window i(Object obj, MediaItem mediaItem, Object obj2, long j2, long j3, long j4, boolean z2, boolean z3, MediaItem.LiveConfiguration liveConfiguration, long j5, long j6, int i2, int i3, long j7) {
            MediaItem mediaItem2;
            Object obj3;
            boolean z4;
            MediaItem.LocalConfiguration localConfiguration;
            MediaItem mediaItem3 = mediaItem;
            MediaItem.LiveConfiguration liveConfiguration2 = liveConfiguration;
            this.f23511b = obj;
            if (mediaItem3 != null) {
                mediaItem2 = mediaItem3;
            } else {
                mediaItem2 = f23505u;
            }
            this.f23513d = mediaItem2;
            if (mediaItem3 == null || (localConfiguration = mediaItem3.f23129c) == null) {
                obj3 = null;
            } else {
                obj3 = localConfiguration.f23209h;
            }
            this.f23512c = obj3;
            this.f23514e = obj2;
            this.f23515f = j2;
            this.f23516g = j3;
            this.f23517h = j4;
            this.f23518i = z2;
            this.f23519j = z3;
            if (liveConfiguration2 != null) {
                z4 = true;
            } else {
                z4 = false;
            }
            this.f23520k = z4;
            this.f23521l = liveConfiguration2;
            this.f23523n = j5;
            this.f23524o = j6;
            this.f23525p = i2;
            this.f23526q = i3;
            this.f23527r = j7;
            this.f23522m = false;
            return this;
        }

        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            if (!MediaItem.f23121j.equals(this.f23513d)) {
                bundle.putBundle(f23506v, this.f23513d.toBundle());
            }
            long j2 = this.f23515f;
            if (j2 != -9223372036854775807L) {
                bundle.putLong(f23507w, j2);
            }
            long j3 = this.f23516g;
            if (j3 != -9223372036854775807L) {
                bundle.putLong(f23508x, j3);
            }
            long j4 = this.f23517h;
            if (j4 != -9223372036854775807L) {
                bundle.putLong(f23509y, j4);
            }
            boolean z2 = this.f23518i;
            if (z2) {
                bundle.putBoolean(f23510z, z2);
            }
            boolean z3 = this.f23519j;
            if (z3) {
                bundle.putBoolean(A, z3);
            }
            MediaItem.LiveConfiguration liveConfiguration = this.f23521l;
            if (liveConfiguration != null) {
                bundle.putBundle(B, liveConfiguration.toBundle());
            }
            boolean z4 = this.f23522m;
            if (z4) {
                bundle.putBoolean(C, z4);
            }
            long j5 = this.f23523n;
            if (j5 != 0) {
                bundle.putLong(D, j5);
            }
            long j6 = this.f23524o;
            if (j6 != -9223372036854775807L) {
                bundle.putLong(E, j6);
            }
            int i2 = this.f23525p;
            if (i2 != 0) {
                bundle.putInt(F, i2);
            }
            int i3 = this.f23526q;
            if (i3 != 0) {
                bundle.putInt(G, i3);
            }
            long j7 = this.f23527r;
            if (j7 != 0) {
                bundle.putLong(H, j7);
            }
            return bundle;
        }
    }

    protected Timeline() {
    }

    /* access modifiers changed from: private */
    public static Timeline b(Bundle bundle) {
        ImmutableList<Window> c2 = c(Window.I, BundleUtil.a(bundle, f23482c));
        ImmutableList<Period> c3 = c(Period.f23491n, BundleUtil.a(bundle, f23483d));
        int[] intArray = bundle.getIntArray(f23484e);
        if (intArray == null) {
            intArray = d(c2.size());
        }
        return new RemotableTimeline(c2, c3, intArray);
    }

    private static <T extends Bundleable> ImmutableList<T> c(Bundleable.Creator<T> creator, IBinder iBinder) {
        if (iBinder == null) {
            return ImmutableList.r();
        }
        ImmutableList.Builder builder = new ImmutableList.Builder();
        ImmutableList<Bundle> a2 = BundleListRetriever.a(iBinder);
        for (int i2 = 0; i2 < a2.size(); i2++) {
            builder.d(creator.a(a2.get(i2)));
        }
        return builder.k();
    }

    private static int[] d(int i2) {
        int[] iArr = new int[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            iArr[i3] = i3;
        }
        return iArr;
    }

    public int e(boolean z2) {
        return u() ? -1 : 0;
    }

    public boolean equals(Object obj) {
        int g2;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Timeline)) {
            return false;
        }
        Timeline timeline = (Timeline) obj;
        if (timeline.t() != t() || timeline.m() != m()) {
            return false;
        }
        Window window = new Window();
        Period period = new Period();
        Window window2 = new Window();
        Period period2 = new Period();
        for (int i2 = 0; i2 < t(); i2++) {
            if (!r(i2, window).equals(timeline.r(i2, window2))) {
                return false;
            }
        }
        for (int i3 = 0; i3 < m(); i3++) {
            if (!k(i3, period, true).equals(timeline.k(i3, period2, true))) {
                return false;
            }
        }
        int e2 = e(true);
        if (e2 != timeline.e(true) || (g2 = g(true)) != timeline.g(true)) {
            return false;
        }
        while (e2 != g2) {
            int i4 = i(e2, 0, true);
            if (i4 != timeline.i(e2, 0, true)) {
                return false;
            }
            e2 = i4;
        }
        return true;
    }

    public abstract int f(Object obj);

    public int g(boolean z2) {
        if (u()) {
            return -1;
        }
        return t() - 1;
    }

    public final int h(int i2, Period period, Window window, int i3, boolean z2) {
        int i4 = j(i2, period).f23494d;
        if (r(i4, window).f23526q != i2) {
            return i2 + 1;
        }
        int i5 = i(i4, i3, z2);
        if (i5 == -1) {
            return -1;
        }
        return r(i5, window).f23525p;
    }

    public int hashCode() {
        Window window = new Window();
        Period period = new Period();
        int t2 = 217 + t();
        for (int i2 = 0; i2 < t(); i2++) {
            t2 = (t2 * 31) + r(i2, window).hashCode();
        }
        int m2 = (t2 * 31) + m();
        for (int i3 = 0; i3 < m(); i3++) {
            m2 = (m2 * 31) + k(i3, period, true).hashCode();
        }
        int e2 = e(true);
        while (e2 != -1) {
            m2 = (m2 * 31) + e2;
            e2 = i(e2, 0, true);
        }
        return m2;
    }

    public int i(int i2, int i3, boolean z2) {
        if (i3 != 0) {
            if (i3 == 1) {
                return i2;
            }
            if (i3 != 2) {
                throw new IllegalStateException();
            } else if (i2 == g(z2)) {
                return e(z2);
            } else {
                return i2 + 1;
            }
        } else if (i2 == g(z2)) {
            return -1;
        } else {
            return i2 + 1;
        }
    }

    public final Period j(int i2, Period period) {
        return k(i2, period, false);
    }

    public abstract Period k(int i2, Period period, boolean z2);

    public Period l(Object obj, Period period) {
        return k(f(obj), period, true);
    }

    public abstract int m();

    public final Pair<Object, Long> n(Window window, Period period, int i2, long j2) {
        return (Pair) Assertions.e(o(window, period, i2, j2, 0));
    }

    public final Pair<Object, Long> o(Window window, Period period, int i2, long j2, long j3) {
        Assertions.c(i2, 0, t());
        s(i2, window, j3);
        if (j2 == -9223372036854775807L) {
            j2 = window.e();
            if (j2 == -9223372036854775807L) {
                return null;
            }
        }
        int i3 = window.f23525p;
        j(i3, period);
        while (i3 < window.f23526q && period.f23496f != j2) {
            int i4 = i3 + 1;
            if (j(i4, period).f23496f > j2) {
                break;
            }
            i3 = i4;
        }
        k(i3, period, true);
        long j4 = j2 - period.f23496f;
        long j5 = period.f23495e;
        if (j5 != -9223372036854775807L) {
            j4 = Math.min(j4, j5 - 1);
        }
        return Pair.create(Assertions.e(period.f23493c), Long.valueOf(Math.max(0, j4)));
    }

    public int p(int i2, int i3, boolean z2) {
        if (i3 != 0) {
            if (i3 == 1) {
                return i2;
            }
            if (i3 != 2) {
                throw new IllegalStateException();
            } else if (i2 == e(z2)) {
                return g(z2);
            } else {
                return i2 - 1;
            }
        } else if (i2 == e(z2)) {
            return -1;
        } else {
            return i2 - 1;
        }
    }

    public abstract Object q(int i2);

    public final Window r(int i2, Window window) {
        return s(i2, window, 0);
    }

    public abstract Window s(int i2, Window window, long j2);

    public abstract int t();

    public final Bundle toBundle() {
        ArrayList arrayList = new ArrayList();
        int t2 = t();
        Window window = new Window();
        for (int i2 = 0; i2 < t2; i2++) {
            arrayList.add(s(i2, window, 0).toBundle());
        }
        ArrayList arrayList2 = new ArrayList();
        int m2 = m();
        Period period = new Period();
        for (int i3 = 0; i3 < m2; i3++) {
            arrayList2.add(k(i3, period, false).toBundle());
        }
        int[] iArr = new int[t2];
        if (t2 > 0) {
            iArr[0] = e(true);
        }
        for (int i4 = 1; i4 < t2; i4++) {
            iArr[i4] = i(iArr[i4 - 1], 0, true);
        }
        Bundle bundle = new Bundle();
        BundleUtil.c(bundle, f23482c, new BundleListRetriever(arrayList));
        BundleUtil.c(bundle, f23483d, new BundleListRetriever(arrayList2));
        bundle.putIntArray(f23484e, iArr);
        return bundle;
    }

    public final boolean u() {
        return t() == 0;
    }

    public final boolean v(int i2, Period period, Window window, int i3, boolean z2) {
        return h(i2, period, window, i3, z2) == -1;
    }
}
