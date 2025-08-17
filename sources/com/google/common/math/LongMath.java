package com.google.common.math;

import com.facebook.ads.internal.c.a;
import com.facebook.common.time.Clock;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import okhttp3.internal.connection.RealConnection;

public final class LongMath {

    /* renamed from: a  reason: collision with root package name */
    static final byte[] f30712a = {19, 18, 18, 18, 18, 17, 17, 17, 16, 16, 16, 15, 15, 15, 15, 14, 14, 14, 13, 13, 13, 12, 12, 12, 12, 11, 11, 11, 10, 10, 10, 9, 9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0};

    /* renamed from: b  reason: collision with root package name */
    static final long[] f30713b = {1, 10, 100, 1000, NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS, 100000, 1000000, 10000000, 100000000, 1000000000, RealConnection.IDLE_CONNECTION_HEALTHY_NS, 100000000000L, 1000000000000L, 10000000000000L, 100000000000000L, 1000000000000000L, 10000000000000000L, 100000000000000000L, 1000000000000000000L};

    /* renamed from: c  reason: collision with root package name */
    static final long[] f30714c = {3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, 3162277660L, 31622776601L, 316227766016L, 3162277660168L, 31622776601683L, 316227766016837L, 3162277660168379L, 31622776601683793L, 316227766016837933L, 3162277660168379331L};

    /* renamed from: d  reason: collision with root package name */
    static final long[] f30715d = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600, 6227020800L, 87178291200L, 1307674368000L, 20922789888000L, 355687428096000L, 6402373705728000L, 121645100408832000L, 2432902008176640000L};

    /* renamed from: e  reason: collision with root package name */
    static final int[] f30716e = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 3810779, 121977, 16175, 4337, 1733, 887, 534, 361, 265, Sdk$SDKError.Reason.AD_ALREADY_FAILED_VALUE, 169, 143, 125, 111, 101, 94, 88, 83, 79, 76, 74, 72, 70, 69, 68, 67, 67, 66, 66, 66, 66};

    /* renamed from: f  reason: collision with root package name */
    static final int[] f30717f = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 2642246, 86251, 11724, 3218, 1313, 684, 419, 287, Sdk$SDKError.Reason.INVALID_GZIP_BID_PAYLOAD_VALUE, 169, 139, 119, 105, 95, 87, 81, 76, 73, 70, 68, 66, 64, 63, 62, 62, 61, 61, 61};

    /* renamed from: g  reason: collision with root package name */
    private static final long[][] f30718g = {new long[]{291830, 126401071349994536L}, new long[]{885594168, 725270293939359937L, 3569819667048198375L}, new long[]{273919523040L, 15, 7363882082L, 992620450144556L}, new long[]{47636622961200L, 2, 2570940, 211991001, 3749873356L}, new long[]{7999252175582850L, 2, 4130806001517L, 149795463772692060L, 186635894390467037L, 3967304179347715805L}, new long[]{585226005592931976L, 2, 123635709730000L, 9233062284813009L, 43835965440333360L, 761179012939631437L, 1263739024124850375L}, new long[]{Clock.MAX_TIME, 2, 325, 9375, 28178, 450775, 9780504, 1795265022}};

    /* renamed from: com.google.common.math.LongMath$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f30719a;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                java.math.RoundingMode[] r0 = java.math.RoundingMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f30719a = r0
                java.math.RoundingMode r1 = java.math.RoundingMode.UNNECESSARY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f30719a     // Catch:{ NoSuchFieldError -> 0x001d }
                java.math.RoundingMode r1 = java.math.RoundingMode.DOWN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f30719a     // Catch:{ NoSuchFieldError -> 0x0028 }
                java.math.RoundingMode r1 = java.math.RoundingMode.FLOOR     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f30719a     // Catch:{ NoSuchFieldError -> 0x0033 }
                java.math.RoundingMode r1 = java.math.RoundingMode.UP     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f30719a     // Catch:{ NoSuchFieldError -> 0x003e }
                java.math.RoundingMode r1 = java.math.RoundingMode.CEILING     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f30719a     // Catch:{ NoSuchFieldError -> 0x0049 }
                java.math.RoundingMode r1 = java.math.RoundingMode.HALF_DOWN     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f30719a     // Catch:{ NoSuchFieldError -> 0x0054 }
                java.math.RoundingMode r1 = java.math.RoundingMode.HALF_UP     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f30719a     // Catch:{ NoSuchFieldError -> 0x0060 }
                java.math.RoundingMode r1 = java.math.RoundingMode.HALF_EVEN     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.LongMath.AnonymousClass1.<clinit>():void");
        }
    }

    private LongMath() {
    }

    public static long a(long j2, long j3) {
        boolean z2;
        long j4 = j2 + j3;
        boolean z3 = true;
        if ((j2 ^ j3) < 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if ((j2 ^ j4) < 0) {
            z3 = false;
        }
        MathPreconditions.c(z2 | z3, "checkedAdd", j2, j3);
        return j4;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004a, code lost:
        if (r10 > 0) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004d, code lost:
        if (r10 < 0) goto L_0x0058;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long b(long r9, long r11, java.math.RoundingMode r13) {
        /*
            com.google.common.base.Preconditions.l(r13)
            long r0 = r9 / r11
            long r2 = r11 * r0
            long r2 = r9 - r2
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 != 0) goto L_0x0010
            return r0
        L_0x0010:
            long r9 = r9 ^ r11
            r7 = 63
            long r9 = r9 >> r7
            int r10 = (int) r9
            r9 = 1
            r10 = r10 | r9
            int[] r7 = com.google.common.math.LongMath.AnonymousClass1.f30719a
            int r8 = r13.ordinal()
            r7 = r7[r8]
            r8 = 0
            switch(r7) {
                case 1: goto L_0x0050;
                case 2: goto L_0x0057;
                case 3: goto L_0x004d;
                case 4: goto L_0x0058;
                case 5: goto L_0x004a;
                case 6: goto L_0x0029;
                case 7: goto L_0x0029;
                case 8: goto L_0x0029;
                default: goto L_0x0023;
            }
        L_0x0023:
            java.lang.AssertionError r9 = new java.lang.AssertionError
            r9.<init>()
            throw r9
        L_0x0029:
            long r2 = java.lang.Math.abs(r2)
            long r11 = java.lang.Math.abs(r11)
            long r11 = r11 - r2
            long r2 = r2 - r11
            int r11 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r11 != 0) goto L_0x0047
            java.math.RoundingMode r11 = java.math.RoundingMode.HALF_UP
            if (r13 == r11) goto L_0x0058
            java.math.RoundingMode r11 = java.math.RoundingMode.HALF_EVEN
            if (r13 != r11) goto L_0x0057
            r11 = 1
            long r11 = r11 & r0
            int r13 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r13 == 0) goto L_0x0057
            goto L_0x0058
        L_0x0047:
            if (r11 <= 0) goto L_0x0057
            goto L_0x0058
        L_0x004a:
            if (r10 <= 0) goto L_0x0057
            goto L_0x0058
        L_0x004d:
            if (r10 >= 0) goto L_0x0057
            goto L_0x0058
        L_0x0050:
            if (r6 != 0) goto L_0x0053
            goto L_0x0054
        L_0x0053:
            r9 = 0
        L_0x0054:
            com.google.common.math.MathPreconditions.e(r9)
        L_0x0057:
            r9 = 0
        L_0x0058:
            if (r9 == 0) goto L_0x005c
            long r9 = (long) r10
            long r0 = r0 + r9
        L_0x005c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.LongMath.b(long, long, java.math.RoundingMode):long");
    }

    public static long c(long j2, long j3) {
        MathPreconditions.d(a.f20042a, j2);
        MathPreconditions.d("b", j3);
        if (j2 == 0) {
            return j3;
        }
        if (j3 == 0) {
            return j2;
        }
        int numberOfTrailingZeros = Long.numberOfTrailingZeros(j2);
        long j4 = j2 >> numberOfTrailingZeros;
        int numberOfTrailingZeros2 = Long.numberOfTrailingZeros(j3);
        long j5 = j3 >> numberOfTrailingZeros2;
        while (j4 != j5) {
            long j6 = j4 - j5;
            long j7 = (j6 >> 63) & j6;
            long j8 = (j6 - j7) - j7;
            j5 += j7;
            j4 = j8 >> Long.numberOfTrailingZeros(j8);
        }
        return j4 << Math.min(numberOfTrailingZeros, numberOfTrailingZeros2);
    }

    public static long d(long j2, long j3) {
        boolean z2;
        boolean z3;
        int numberOfLeadingZeros = Long.numberOfLeadingZeros(j2) + Long.numberOfLeadingZeros(~j2) + Long.numberOfLeadingZeros(j3) + Long.numberOfLeadingZeros(~j3);
        if (numberOfLeadingZeros > 65) {
            return j2 * j3;
        }
        long j4 = ((j2 ^ j3) >>> 63) + Clock.MAX_TIME;
        boolean z4 = true;
        if (numberOfLeadingZeros < 64) {
            z2 = true;
        } else {
            z2 = false;
        }
        int i2 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        if (i2 < 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (j3 != Long.MIN_VALUE) {
            z4 = false;
        }
        if (z2 || (z4 & z3)) {
            return j4;
        }
        long j5 = j2 * j3;
        if (i2 == 0 || j5 / j2 == j3) {
            return j5;
        }
        return j4;
    }
}
