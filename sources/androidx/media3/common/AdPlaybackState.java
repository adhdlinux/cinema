package androidx.media3.common;

import android.net.Uri;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import java.util.Arrays;

public final class AdPlaybackState {

    /* renamed from: g  reason: collision with root package name */
    public static final AdPlaybackState f3879g = new AdPlaybackState((Object) null, new AdGroup[0], 0, -9223372036854775807L, 0);

    /* renamed from: h  reason: collision with root package name */
    private static final AdGroup f3880h = new AdGroup(0).i(0);

    /* renamed from: i  reason: collision with root package name */
    private static final String f3881i = Util.B0(1);

    /* renamed from: j  reason: collision with root package name */
    private static final String f3882j = Util.B0(2);

    /* renamed from: k  reason: collision with root package name */
    private static final String f3883k = Util.B0(3);

    /* renamed from: l  reason: collision with root package name */
    private static final String f3884l = Util.B0(4);

    /* renamed from: a  reason: collision with root package name */
    public final Object f3885a;

    /* renamed from: b  reason: collision with root package name */
    public final int f3886b;

    /* renamed from: c  reason: collision with root package name */
    public final long f3887c;

    /* renamed from: d  reason: collision with root package name */
    public final long f3888d;

    /* renamed from: e  reason: collision with root package name */
    public final int f3889e;

    /* renamed from: f  reason: collision with root package name */
    private final AdGroup[] f3890f;

    public static final class AdGroup {

        /* renamed from: j  reason: collision with root package name */
        private static final String f3891j = Util.B0(0);

        /* renamed from: k  reason: collision with root package name */
        private static final String f3892k = Util.B0(1);

        /* renamed from: l  reason: collision with root package name */
        private static final String f3893l = Util.B0(2);

        /* renamed from: m  reason: collision with root package name */
        private static final String f3894m = Util.B0(3);

        /* renamed from: n  reason: collision with root package name */
        private static final String f3895n = Util.B0(4);

        /* renamed from: o  reason: collision with root package name */
        private static final String f3896o = Util.B0(5);

        /* renamed from: p  reason: collision with root package name */
        private static final String f3897p = Util.B0(6);

        /* renamed from: q  reason: collision with root package name */
        private static final String f3898q = Util.B0(7);

        /* renamed from: r  reason: collision with root package name */
        static final String f3899r = Util.B0(8);

        /* renamed from: a  reason: collision with root package name */
        public final long f3900a;

        /* renamed from: b  reason: collision with root package name */
        public final int f3901b;

        /* renamed from: c  reason: collision with root package name */
        public final int f3902c;
        @Deprecated

        /* renamed from: d  reason: collision with root package name */
        public final Uri[] f3903d;

        /* renamed from: e  reason: collision with root package name */
        public final MediaItem[] f3904e;

        /* renamed from: f  reason: collision with root package name */
        public final int[] f3905f;

        /* renamed from: g  reason: collision with root package name */
        public final long[] f3906g;

        /* renamed from: h  reason: collision with root package name */
        public final long f3907h;

        /* renamed from: i  reason: collision with root package name */
        public final boolean f3908i;

        public AdGroup(long j2) {
            this(j2, -1, -1, new int[0], new MediaItem[0], new long[0], 0, false);
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
        public boolean g() {
            return this.f3908i && this.f3900a == Long.MIN_VALUE && this.f3901b == -1;
        }

        public int d() {
            return e(-1);
        }

        public int e(int i2) {
            int i3;
            int i4 = i2 + 1;
            while (true) {
                int[] iArr = this.f3905f;
                if (i4 >= iArr.length || this.f3908i || (i3 = iArr[i4]) == 0 || i3 == 1) {
                    return i4;
                }
                i4++;
            }
            return i4;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || AdGroup.class != obj.getClass()) {
                return false;
            }
            AdGroup adGroup = (AdGroup) obj;
            if (this.f3900a == adGroup.f3900a && this.f3901b == adGroup.f3901b && this.f3902c == adGroup.f3902c && Arrays.equals(this.f3904e, adGroup.f3904e) && Arrays.equals(this.f3905f, adGroup.f3905f) && Arrays.equals(this.f3906g, adGroup.f3906g) && this.f3907h == adGroup.f3907h && this.f3908i == adGroup.f3908i) {
                return true;
            }
            return false;
        }

        public boolean f() {
            if (this.f3901b == -1) {
                return true;
            }
            for (int i2 = 0; i2 < this.f3901b; i2++) {
                int i3 = this.f3905f[i2];
                if (i3 == 0 || i3 == 1) {
                    return true;
                }
            }
            return false;
        }

        public boolean h() {
            return this.f3901b == -1 || d() < this.f3901b;
        }

        public int hashCode() {
            long j2 = this.f3900a;
            long j3 = this.f3907h;
            return (((((((((((((this.f3901b * 31) + this.f3902c) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + Arrays.hashCode(this.f3904e)) * 31) + Arrays.hashCode(this.f3905f)) * 31) + Arrays.hashCode(this.f3906g)) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + (this.f3908i ? 1 : 0);
        }

        public AdGroup i(int i2) {
            int[] c2 = c(this.f3905f, i2);
            long[] b2 = b(this.f3906g, i2);
            return new AdGroup(this.f3900a, i2, this.f3902c, c2, (MediaItem[]) Arrays.copyOf(this.f3904e, i2), b2, this.f3907h, this.f3908i);
        }

        private AdGroup(long j2, int i2, int i3, int[] iArr, MediaItem[] mediaItemArr, long[] jArr, long j3, boolean z2) {
            int i4 = 0;
            Assertions.a(iArr.length == mediaItemArr.length);
            this.f3900a = j2;
            this.f3901b = i2;
            this.f3902c = i3;
            this.f3905f = iArr;
            this.f3904e = mediaItemArr;
            this.f3906g = jArr;
            this.f3907h = j3;
            this.f3908i = z2;
            this.f3903d = new Uri[mediaItemArr.length];
            while (true) {
                Uri[] uriArr = this.f3903d;
                if (i4 < uriArr.length) {
                    MediaItem mediaItem = mediaItemArr[i4];
                    uriArr[i4] = mediaItem == null ? null : ((MediaItem.LocalConfiguration) Assertions.f(mediaItem.f4079b)).f4171a;
                    i4++;
                } else {
                    return;
                }
            }
        }
    }

    private AdPlaybackState(Object obj, AdGroup[] adGroupArr, long j2, long j3, int i2) {
        this.f3885a = obj;
        this.f3887c = j2;
        this.f3888d = j3;
        this.f3886b = adGroupArr.length + i2;
        this.f3890f = adGroupArr;
        this.f3889e = i2;
    }

    private boolean e(long j2, long j3, int i2) {
        if (j2 == Long.MIN_VALUE) {
            return false;
        }
        AdGroup a2 = a(i2);
        long j4 = a2.f3900a;
        if (j4 == Long.MIN_VALUE) {
            if (j3 == -9223372036854775807L || ((a2.f3908i && a2.f3901b == -1) || j2 < j3)) {
                return true;
            }
            return false;
        } else if (j2 < j4) {
            return true;
        } else {
            return false;
        }
    }

    public AdGroup a(int i2) {
        int i3 = this.f3889e;
        if (i2 < i3) {
            return f3880h;
        }
        return this.f3890f[i2 - i3];
    }

    public int b(long j2, long j3) {
        if (j2 == Long.MIN_VALUE) {
            return -1;
        }
        if (j3 != -9223372036854775807L && j2 >= j3) {
            return -1;
        }
        int i2 = this.f3889e;
        while (i2 < this.f3886b && ((a(i2).f3900a != Long.MIN_VALUE && a(i2).f3900a <= j2) || !a(i2).h())) {
            i2++;
        }
        if (i2 < this.f3886b) {
            return i2;
        }
        return -1;
    }

    public int c(long j2, long j3) {
        int i2 = this.f3886b - 1;
        int i3 = i2 - (d(i2) ? 1 : 0);
        while (i3 >= 0 && e(j2, j3, i3)) {
            i3--;
        }
        if (i3 < 0 || !a(i3).f()) {
            return -1;
        }
        return i3;
    }

    public boolean d(int i2) {
        return i2 == this.f3886b - 1 && a(i2).g();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AdPlaybackState.class != obj.getClass()) {
            return false;
        }
        AdPlaybackState adPlaybackState = (AdPlaybackState) obj;
        if (Util.c(this.f3885a, adPlaybackState.f3885a) && this.f3886b == adPlaybackState.f3886b && this.f3887c == adPlaybackState.f3887c && this.f3888d == adPlaybackState.f3888d && this.f3889e == adPlaybackState.f3889e && Arrays.equals(this.f3890f, adPlaybackState.f3890f)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i2;
        int i3 = this.f3886b * 31;
        Object obj = this.f3885a;
        if (obj == null) {
            i2 = 0;
        } else {
            i2 = obj.hashCode();
        }
        return ((((((((i3 + i2) * 31) + ((int) this.f3887c)) * 31) + ((int) this.f3888d)) * 31) + this.f3889e) * 31) + Arrays.hashCode(this.f3890f);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AdPlaybackState(adsId=");
        sb.append(this.f3885a);
        sb.append(", adResumePositionUs=");
        sb.append(this.f3887c);
        sb.append(", adGroups=[");
        for (int i2 = 0; i2 < this.f3890f.length; i2++) {
            sb.append("adGroup(timeUs=");
            sb.append(this.f3890f[i2].f3900a);
            sb.append(", ads=[");
            for (int i3 = 0; i3 < this.f3890f[i2].f3905f.length; i3++) {
                sb.append("ad(state=");
                int i4 = this.f3890f[i2].f3905f[i3];
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
                sb.append(this.f3890f[i2].f3906g[i3]);
                sb.append(')');
                if (i3 < this.f3890f[i2].f3905f.length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("])");
            if (i2 < this.f3890f.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("])");
        return sb.toString();
    }
}
