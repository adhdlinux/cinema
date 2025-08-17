package kotlinx.coroutines.internal;

import com.facebook.common.time.Clock;

final /* synthetic */ class SystemPropsKt__SystemProps_commonKt {
    public static final int a(String str, int i2, int i3, int i4) {
        return (int) SystemPropsKt.c(str, (long) i2, (long) i3, (long) i4);
    }

    public static final long b(String str, long j2, long j3, long j4) {
        String d2 = SystemPropsKt.d(str);
        if (d2 == null) {
            return j2;
        }
        Long m2 = StringsKt__StringNumberConversionsKt.m(d2);
        if (m2 != null) {
            long longValue = m2.longValue();
            boolean z2 = false;
            if (j3 <= longValue && longValue <= j4) {
                z2 = true;
            }
            if (z2) {
                return longValue;
            }
            throw new IllegalStateException(("System property '" + str + "' should be in range " + j3 + ".." + j4 + ", but is '" + longValue + '\'').toString());
        }
        throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + d2 + '\'').toString());
    }

    public static final String c(String str, String str2) {
        String d2 = SystemPropsKt.d(str);
        return d2 == null ? str2 : d2;
    }

    public static final boolean d(String str, boolean z2) {
        String d2 = SystemPropsKt.d(str);
        return d2 != null ? Boolean.parseBoolean(d2) : z2;
    }

    public static /* synthetic */ int e(String str, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            i3 = 1;
        }
        if ((i5 & 8) != 0) {
            i4 = Integer.MAX_VALUE;
        }
        return SystemPropsKt.b(str, i2, i3, i4);
    }

    public static /* synthetic */ long f(String str, long j2, long j3, long j4, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            j3 = 1;
        }
        long j5 = j3;
        if ((i2 & 8) != 0) {
            j4 = Clock.MAX_TIME;
        }
        return SystemPropsKt.c(str, j2, j5, j4);
    }
}
