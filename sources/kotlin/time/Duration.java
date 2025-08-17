package kotlin.time;

import b0.y;
import com.facebook.common.time.Clock;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.LongRange;
import okhttp3.internal.http2.Http2Connection;

public final class Duration implements Comparable<Duration> {

    /* renamed from: c  reason: collision with root package name */
    public static final Companion f40567c = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final long f40568d = h(0);
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final long f40569e = DurationKt.j(4611686018427387903L);

    /* renamed from: f  reason: collision with root package name */
    private static final long f40570f = DurationKt.j(-4611686018427387903L);

    /* renamed from: b  reason: collision with root package name */
    private final long f40571b;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a() {
            return Duration.f40569e;
        }

        public final long b() {
            return Duration.f40568d;
        }

        public final long c(String str) {
            Intrinsics.f(str, AppMeasurementSdk.ConditionalUserProperty.VALUE);
            try {
                return DurationKt.p(str, true);
            } catch (IllegalArgumentException e2) {
                throw new IllegalArgumentException("Invalid ISO duration string format: '" + str + "'.", e2);
            }
        }
    }

    private /* synthetic */ Duration(long j2) {
        this.f40571b = j2;
    }

    public static final long A(long j2, long j3) {
        if (y(j2)) {
            if (v(j3) || (j3 ^ j2) >= 0) {
                return j2;
            }
            throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
        } else if (y(j3)) {
            return j3;
        } else {
            if ((((int) j2) & 1) == (((int) j3) & 1)) {
                long t2 = t(j2) + t(j3);
                if (x(j2)) {
                    return DurationKt.m(t2);
                }
                return DurationKt.k(t2);
            } else if (w(j2)) {
                return c(j2, t(j2), t(j3));
            } else {
                return c(j2, t(j3), t(j2));
            }
        }
    }

    public static final String B(long j2) {
        boolean z2;
        boolean z3;
        StringBuilder sb = new StringBuilder();
        if (z(j2)) {
            sb.append('-');
        }
        sb.append("PT");
        long j3 = j(j2);
        long m2 = m(j3);
        int p2 = p(j3);
        int r2 = r(j3);
        int q2 = q(j3);
        if (y(j2)) {
            m2 = 9999999999999L;
        }
        boolean z4 = true;
        if (m2 != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (r2 == 0 && q2 == 0) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (p2 == 0 && (!z3 || !z2)) {
            z4 = false;
        }
        if (z2) {
            sb.append(m2);
            sb.append('H');
        }
        if (z4) {
            sb.append(p2);
            sb.append('M');
        }
        if (z3 || (!z2 && !z4)) {
            d(j2, sb, r2, q2, 9, "S", true);
        }
        String sb2 = sb.toString();
        Intrinsics.e(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public static final long C(long j2, DurationUnit durationUnit) {
        Intrinsics.f(durationUnit, "unit");
        if (j2 == f40569e) {
            return Clock.MAX_TIME;
        }
        if (j2 == f40570f) {
            return Long.MIN_VALUE;
        }
        return DurationUnitKt__DurationUnitJvmKt.b(t(j2), s(j2), durationUnit);
    }

    public static String D(long j2) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        if (j2 == 0) {
            return "0s";
        }
        if (j2 == f40569e) {
            return "Infinity";
        }
        if (j2 == f40570f) {
            return "-Infinity";
        }
        boolean z6 = z(j2);
        StringBuilder sb = new StringBuilder();
        if (z6) {
            sb.append('-');
        }
        long j3 = j(j2);
        long l2 = l(j3);
        int k2 = k(j3);
        int p2 = p(j3);
        int r2 = r(j3);
        int q2 = q(j3);
        int i2 = 0;
        if (l2 != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (k2 != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (p2 != 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (r2 == 0 && q2 == 0) {
            z5 = false;
        } else {
            z5 = true;
        }
        if (z2) {
            sb.append(l2);
            sb.append('d');
            i2 = 1;
        }
        if (z3 || (z2 && (z4 || z5))) {
            int i3 = i2 + 1;
            if (i2 > 0) {
                sb.append(' ');
            }
            sb.append(k2);
            sb.append('h');
            i2 = i3;
        }
        if (z4 || (z5 && (z3 || z2))) {
            int i4 = i2 + 1;
            if (i2 > 0) {
                sb.append(' ');
            }
            sb.append(p2);
            sb.append('m');
            i2 = i4;
        }
        if (z5) {
            int i5 = i2 + 1;
            if (i2 > 0) {
                sb.append(' ');
            }
            if (r2 != 0 || z2 || z3 || z4) {
                d(j2, sb, r2, q2, 9, "s", false);
            } else if (q2 >= 1000000) {
                d(j2, sb, q2 / 1000000, q2 % 1000000, 6, "ms", false);
            } else if (q2 >= 1000) {
                d(j2, sb, q2 / 1000, q2 % 1000, 3, "us", false);
            } else {
                sb.append(q2);
                sb.append("ns");
            }
            i2 = i5;
        }
        if (z6 && i2 > 1) {
            sb.insert(1, '(').append(')');
        }
        String sb2 = sb.toString();
        Intrinsics.e(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public static final long E(long j2) {
        return DurationKt.i(-t(j2), ((int) j2) & 1);
    }

    private static final long c(long j2, long j3, long j4) {
        long g2 = DurationKt.o(j4);
        long j5 = j3 + g2;
        if (!new LongRange(-4611686018426L, 4611686018426L).e(j5)) {
            return DurationKt.j(RangesKt___RangesKt.g(j5, -4611686018427387903L, 4611686018427387903L));
        }
        return DurationKt.l(DurationKt.n(j5) + (j4 - DurationKt.n(g2)));
    }

    private static final void d(long j2, StringBuilder sb, int i2, int i3, int i4, String str, boolean z2) {
        boolean z3;
        sb.append(i2);
        if (i3 != 0) {
            sb.append('.');
            String g02 = StringsKt__StringsKt.g0(String.valueOf(i3), i4, '0');
            int i5 = -1;
            int length = g02.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i6 = length - 1;
                    if (g02.charAt(length) != '0') {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (z3) {
                        i5 = length;
                        break;
                    } else if (i6 < 0) {
                        break;
                    } else {
                        length = i6;
                    }
                }
            }
            int i7 = i5 + 1;
            if (z2 || i7 >= 3) {
                sb.append(g02, 0, ((i7 + 2) / 3) * 3);
                Intrinsics.e(sb, "this.append(value, startIndex, endIndex)");
            } else {
                sb.append(g02, 0, i7);
                Intrinsics.e(sb, "this.append(value, startIndex, endIndex)");
            }
        }
        sb.append(str);
    }

    public static final /* synthetic */ Duration e(long j2) {
        return new Duration(j2);
    }

    public static int g(long j2, long j3) {
        long j4 = j2 ^ j3;
        if (j4 < 0 || (((int) j4) & 1) == 0) {
            return Intrinsics.i(j2, j3);
        }
        int i2 = (((int) j2) & 1) - (((int) j3) & 1);
        if (z(j2)) {
            return -i2;
        }
        return i2;
    }

    public static long h(long j2) {
        if (DurationJvmKt.a()) {
            if (x(j2)) {
                if (!new LongRange(-4611686018426999999L, 4611686018426999999L).e(t(j2))) {
                    throw new AssertionError(t(j2) + " ns is out of nanoseconds range");
                }
            } else if (!new LongRange(-4611686018427387903L, 4611686018427387903L).e(t(j2))) {
                throw new AssertionError(t(j2) + " ms is out of milliseconds range");
            } else if (new LongRange(-4611686018426L, 4611686018426L).e(t(j2))) {
                throw new AssertionError(t(j2) + " ms is denormalized");
            }
        }
        return j2;
    }

    public static boolean i(long j2, Object obj) {
        return (obj instanceof Duration) && j2 == ((Duration) obj).F();
    }

    public static final long j(long j2) {
        return z(j2) ? E(j2) : j2;
    }

    public static final int k(long j2) {
        if (y(j2)) {
            return 0;
        }
        return (int) (m(j2) % ((long) 24));
    }

    public static final long l(long j2) {
        return C(j2, DurationUnit.DAYS);
    }

    public static final long m(long j2) {
        return C(j2, DurationUnit.HOURS);
    }

    public static final long n(long j2) {
        return C(j2, DurationUnit.MINUTES);
    }

    public static final long o(long j2) {
        return C(j2, DurationUnit.SECONDS);
    }

    public static final int p(long j2) {
        if (y(j2)) {
            return 0;
        }
        return (int) (n(j2) % ((long) 60));
    }

    public static final int q(long j2) {
        long j3;
        if (y(j2)) {
            return 0;
        }
        if (w(j2)) {
            j3 = DurationKt.n(t(j2) % ((long) 1000));
        } else {
            j3 = t(j2) % ((long) Http2Connection.DEGRADED_PONG_TIMEOUT_NS);
        }
        return (int) j3;
    }

    public static final int r(long j2) {
        if (y(j2)) {
            return 0;
        }
        return (int) (o(j2) % ((long) 60));
    }

    private static final DurationUnit s(long j2) {
        return x(j2) ? DurationUnit.NANOSECONDS : DurationUnit.MILLISECONDS;
    }

    private static final long t(long j2) {
        return j2 >> 1;
    }

    public static int u(long j2) {
        return y.a(j2);
    }

    public static final boolean v(long j2) {
        return !y(j2);
    }

    private static final boolean w(long j2) {
        return (((int) j2) & 1) == 1;
    }

    private static final boolean x(long j2) {
        return (((int) j2) & 1) == 0;
    }

    public static final boolean y(long j2) {
        return j2 == f40569e || j2 == f40570f;
    }

    public static final boolean z(long j2) {
        return j2 < 0;
    }

    public final /* synthetic */ long F() {
        return this.f40571b;
    }

    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return f(((Duration) obj).F());
    }

    public boolean equals(Object obj) {
        return i(this.f40571b, obj);
    }

    public int f(long j2) {
        return g(this.f40571b, j2);
    }

    public int hashCode() {
        return u(this.f40571b);
    }

    public String toString() {
        return D(this.f40571b);
    }
}
