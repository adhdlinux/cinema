package com.google.android.exoplayer2.source.ads;

import android.net.Uri;
import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import o0.a;
import o0.b;

public final class AdPlaybackState implements Bundleable {

    /* renamed from: h  reason: collision with root package name */
    public static final AdPlaybackState f26018h = new AdPlaybackState((Object) null, new AdGroup[0], 0, -9223372036854775807L, 0);

    /* renamed from: i  reason: collision with root package name */
    private static final AdGroup f26019i = new AdGroup(0).i(0);

    /* renamed from: j  reason: collision with root package name */
    private static final String f26020j = Util.u0(1);

    /* renamed from: k  reason: collision with root package name */
    private static final String f26021k = Util.u0(2);

    /* renamed from: l  reason: collision with root package name */
    private static final String f26022l = Util.u0(3);

    /* renamed from: m  reason: collision with root package name */
    private static final String f26023m = Util.u0(4);

    /* renamed from: n  reason: collision with root package name */
    public static final Bundleable.Creator<AdPlaybackState> f26024n = new a();

    /* renamed from: b  reason: collision with root package name */
    public final Object f26025b;

    /* renamed from: c  reason: collision with root package name */
    public final int f26026c;

    /* renamed from: d  reason: collision with root package name */
    public final long f26027d;

    /* renamed from: e  reason: collision with root package name */
    public final long f26028e;

    /* renamed from: f  reason: collision with root package name */
    public final int f26029f;

    /* renamed from: g  reason: collision with root package name */
    private final AdGroup[] f26030g;

    public static final class AdGroup implements Bundleable {

        /* renamed from: j  reason: collision with root package name */
        private static final String f26031j = Util.u0(0);

        /* renamed from: k  reason: collision with root package name */
        private static final String f26032k = Util.u0(1);

        /* renamed from: l  reason: collision with root package name */
        private static final String f26033l = Util.u0(2);

        /* renamed from: m  reason: collision with root package name */
        private static final String f26034m = Util.u0(3);

        /* renamed from: n  reason: collision with root package name */
        private static final String f26035n = Util.u0(4);

        /* renamed from: o  reason: collision with root package name */
        private static final String f26036o = Util.u0(5);

        /* renamed from: p  reason: collision with root package name */
        private static final String f26037p = Util.u0(6);

        /* renamed from: q  reason: collision with root package name */
        private static final String f26038q = Util.u0(7);

        /* renamed from: r  reason: collision with root package name */
        public static final Bundleable.Creator<AdGroup> f26039r = new b();

        /* renamed from: b  reason: collision with root package name */
        public final long f26040b;

        /* renamed from: c  reason: collision with root package name */
        public final int f26041c;

        /* renamed from: d  reason: collision with root package name */
        public final int f26042d;

        /* renamed from: e  reason: collision with root package name */
        public final Uri[] f26043e;

        /* renamed from: f  reason: collision with root package name */
        public final int[] f26044f;

        /* renamed from: g  reason: collision with root package name */
        public final long[] f26045g;

        /* renamed from: h  reason: collision with root package name */
        public final long f26046h;

        /* renamed from: i  reason: collision with root package name */
        public final boolean f26047i;

        public AdGroup(long j2) {
            this(j2, -1, -1, new int[0], new Uri[0], new long[0], 0, false);
        }

        private static long[] b(long[] jArr, int i2) {
            int length = jArr.length;
            int max = Math.max(i2, length);
            long[] copyOf = Arrays.copyOf(jArr, max);
            Arrays.fill(copyOf, length, max, -9223372036854775807L);
            return copyOf;
        }

        private static int[] c(int[] iArr, int i2) {
            int length = iArr.length;
            int max = Math.max(i2, length);
            int[] copyOf = Arrays.copyOf(iArr, max);
            Arrays.fill(copyOf, length, max, 0);
            return copyOf;
        }

        /* access modifiers changed from: private */
        public static AdGroup d(Bundle bundle) {
            Uri[] uriArr;
            long[] jArr;
            long j2 = bundle.getLong(f26031j);
            int i2 = bundle.getInt(f26032k);
            int i3 = bundle.getInt(f26038q);
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(f26033l);
            int[] intArray = bundle.getIntArray(f26034m);
            long[] longArray = bundle.getLongArray(f26035n);
            long j3 = bundle.getLong(f26036o);
            boolean z2 = bundle.getBoolean(f26037p);
            if (intArray == null) {
                intArray = new int[0];
            }
            int[] iArr = intArray;
            if (parcelableArrayList == null) {
                uriArr = new Uri[0];
            } else {
                uriArr = (Uri[]) parcelableArrayList.toArray(new Uri[0]);
            }
            if (longArray == null) {
                jArr = new long[0];
            } else {
                jArr = longArray;
            }
            return new AdGroup(j2, i2, i3, iArr, uriArr, jArr, j3, z2);
        }

        public int e() {
            return f(-1);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || AdGroup.class != obj.getClass()) {
                return false;
            }
            AdGroup adGroup = (AdGroup) obj;
            if (this.f26040b == adGroup.f26040b && this.f26041c == adGroup.f26041c && this.f26042d == adGroup.f26042d && Arrays.equals(this.f26043e, adGroup.f26043e) && Arrays.equals(this.f26044f, adGroup.f26044f) && Arrays.equals(this.f26045g, adGroup.f26045g) && this.f26046h == adGroup.f26046h && this.f26047i == adGroup.f26047i) {
                return true;
            }
            return false;
        }

        public int f(int i2) {
            int i3;
            int i4 = i2 + 1;
            while (true) {
                int[] iArr = this.f26044f;
                if (i4 >= iArr.length || this.f26047i || (i3 = iArr[i4]) == 0 || i3 == 1) {
                    return i4;
                }
                i4++;
            }
            return i4;
        }

        public boolean g() {
            if (this.f26041c == -1) {
                return true;
            }
            for (int i2 = 0; i2 < this.f26041c; i2++) {
                int i3 = this.f26044f[i2];
                if (i3 == 0 || i3 == 1) {
                    return true;
                }
            }
            return false;
        }

        public boolean h() {
            return this.f26041c == -1 || e() < this.f26041c;
        }

        public int hashCode() {
            long j2 = this.f26040b;
            long j3 = this.f26046h;
            return (((((((((((((this.f26041c * 31) + this.f26042d) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + Arrays.hashCode(this.f26043e)) * 31) + Arrays.hashCode(this.f26044f)) * 31) + Arrays.hashCode(this.f26045g)) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + (this.f26047i ? 1 : 0);
        }

        public AdGroup i(int i2) {
            int[] c2 = c(this.f26044f, i2);
            long[] b2 = b(this.f26045g, i2);
            return new AdGroup(this.f26040b, i2, this.f26042d, c2, (Uri[]) Arrays.copyOf(this.f26043e, i2), b2, this.f26046h, this.f26047i);
        }

        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putLong(f26031j, this.f26040b);
            bundle.putInt(f26032k, this.f26041c);
            bundle.putInt(f26038q, this.f26042d);
            bundle.putParcelableArrayList(f26033l, new ArrayList(Arrays.asList(this.f26043e)));
            bundle.putIntArray(f26034m, this.f26044f);
            bundle.putLongArray(f26035n, this.f26045g);
            bundle.putLong(f26036o, this.f26046h);
            bundle.putBoolean(f26037p, this.f26047i);
            return bundle;
        }

        private AdGroup(long j2, int i2, int i3, int[] iArr, Uri[] uriArr, long[] jArr, long j3, boolean z2) {
            Assertions.a(iArr.length == uriArr.length);
            this.f26040b = j2;
            this.f26041c = i2;
            this.f26042d = i3;
            this.f26044f = iArr;
            this.f26043e = uriArr;
            this.f26045g = jArr;
            this.f26046h = j3;
            this.f26047i = z2;
        }
    }

    private AdPlaybackState(Object obj, AdGroup[] adGroupArr, long j2, long j3, int i2) {
        this.f26025b = obj;
        this.f26027d = j2;
        this.f26028e = j3;
        this.f26026c = adGroupArr.length + i2;
        this.f26030g = adGroupArr;
        this.f26029f = i2;
    }

    /* access modifiers changed from: private */
    public static AdPlaybackState b(Bundle bundle) {
        AdGroup[] adGroupArr;
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(f26020j);
        if (parcelableArrayList == null) {
            adGroupArr = new AdGroup[0];
        } else {
            AdGroup[] adGroupArr2 = new AdGroup[parcelableArrayList.size()];
            for (int i2 = 0; i2 < parcelableArrayList.size(); i2++) {
                adGroupArr2[i2] = AdGroup.f26039r.a((Bundle) parcelableArrayList.get(i2));
            }
            adGroupArr = adGroupArr2;
        }
        String str = f26021k;
        AdPlaybackState adPlaybackState = f26018h;
        return new AdPlaybackState((Object) null, adGroupArr, bundle.getLong(str, adPlaybackState.f26027d), bundle.getLong(f26022l, adPlaybackState.f26028e), bundle.getInt(f26023m, adPlaybackState.f26029f));
    }

    private boolean f(long j2, long j3, int i2) {
        if (j2 == Long.MIN_VALUE) {
            return false;
        }
        long j4 = c(i2).f26040b;
        return j4 == Long.MIN_VALUE ? j3 == -9223372036854775807L || j2 < j3 : j2 < j4;
    }

    public AdGroup c(int i2) {
        int i3 = this.f26029f;
        if (i2 < i3) {
            return f26019i;
        }
        return this.f26030g[i2 - i3];
    }

    public int d(long j2, long j3) {
        if (j2 == Long.MIN_VALUE) {
            return -1;
        }
        if (j3 != -9223372036854775807L && j2 >= j3) {
            return -1;
        }
        int i2 = this.f26029f;
        while (i2 < this.f26026c && ((c(i2).f26040b != Long.MIN_VALUE && c(i2).f26040b <= j2) || !c(i2).h())) {
            i2++;
        }
        if (i2 < this.f26026c) {
            return i2;
        }
        return -1;
    }

    public int e(long j2, long j3) {
        int i2 = this.f26026c - 1;
        while (i2 >= 0 && f(j2, j3, i2)) {
            i2--;
        }
        if (i2 < 0 || !c(i2).g()) {
            return -1;
        }
        return i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AdPlaybackState.class != obj.getClass()) {
            return false;
        }
        AdPlaybackState adPlaybackState = (AdPlaybackState) obj;
        if (Util.c(this.f26025b, adPlaybackState.f26025b) && this.f26026c == adPlaybackState.f26026c && this.f26027d == adPlaybackState.f26027d && this.f26028e == adPlaybackState.f26028e && this.f26029f == adPlaybackState.f26029f && Arrays.equals(this.f26030g, adPlaybackState.f26030g)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i2;
        int i3 = this.f26026c * 31;
        Object obj = this.f26025b;
        if (obj == null) {
            i2 = 0;
        } else {
            i2 = obj.hashCode();
        }
        return ((((((((i3 + i2) * 31) + ((int) this.f26027d)) * 31) + ((int) this.f26028e)) * 31) + this.f26029f) * 31) + Arrays.hashCode(this.f26030g);
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        ArrayList arrayList = new ArrayList();
        for (AdGroup bundle2 : this.f26030g) {
            arrayList.add(bundle2.toBundle());
        }
        if (!arrayList.isEmpty()) {
            bundle.putParcelableArrayList(f26020j, arrayList);
        }
        long j2 = this.f26027d;
        AdPlaybackState adPlaybackState = f26018h;
        if (j2 != adPlaybackState.f26027d) {
            bundle.putLong(f26021k, j2);
        }
        long j3 = this.f26028e;
        if (j3 != adPlaybackState.f26028e) {
            bundle.putLong(f26022l, j3);
        }
        int i2 = this.f26029f;
        if (i2 != adPlaybackState.f26029f) {
            bundle.putInt(f26023m, i2);
        }
        return bundle;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AdPlaybackState(adsId=");
        sb.append(this.f26025b);
        sb.append(", adResumePositionUs=");
        sb.append(this.f26027d);
        sb.append(", adGroups=[");
        for (int i2 = 0; i2 < this.f26030g.length; i2++) {
            sb.append("adGroup(timeUs=");
            sb.append(this.f26030g[i2].f26040b);
            sb.append(", ads=[");
            for (int i3 = 0; i3 < this.f26030g[i2].f26044f.length; i3++) {
                sb.append("ad(state=");
                int i4 = this.f26030g[i2].f26044f[i3];
                if (i4 == 0) {
                    sb.append('_');
                } else if (i4 == 1) {
                    sb.append('R');
                } else if (i4 == 2) {
                    sb.append('S');
                } else if (i4 == 3) {
                    sb.append('P');
                } else if (i4 != 4) {
                    sb.append('?');
                } else {
                    sb.append('!');
                }
                sb.append(", durationUs=");
                sb.append(this.f26030g[i2].f26045g[i3]);
                sb.append(')');
                if (i3 < this.f26030g[i2].f26044f.length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("])");
            if (i2 < this.f26030g.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("])");
        return sb.toString();
    }
}
