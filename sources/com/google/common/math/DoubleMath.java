package com.google.common.math;

import java.math.RoundingMode;

public final class DoubleMath {

    /* renamed from: a  reason: collision with root package name */
    private static final double f30703a = Math.log(2.0d);

    /* renamed from: b  reason: collision with root package name */
    static final double[] f30704b = {1.0d, 2.0922789888E13d, 2.631308369336935E35d, 1.2413915592536073E61d, 1.2688693218588417E89d, 7.156945704626381E118d, 9.916779348709496E149d, 1.974506857221074E182d, 3.856204823625804E215d, 5.5502938327393044E249d, 4.7147236359920616E284d};

    /* renamed from: com.google.common.math.DoubleMath$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f30705a;

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
                f30705a = r0
                java.math.RoundingMode r1 = java.math.RoundingMode.UNNECESSARY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f30705a     // Catch:{ NoSuchFieldError -> 0x001d }
                java.math.RoundingMode r1 = java.math.RoundingMode.FLOOR     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f30705a     // Catch:{ NoSuchFieldError -> 0x0028 }
                java.math.RoundingMode r1 = java.math.RoundingMode.CEILING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f30705a     // Catch:{ NoSuchFieldError -> 0x0033 }
                java.math.RoundingMode r1 = java.math.RoundingMode.DOWN     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f30705a     // Catch:{ NoSuchFieldError -> 0x003e }
                java.math.RoundingMode r1 = java.math.RoundingMode.UP     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f30705a     // Catch:{ NoSuchFieldError -> 0x0049 }
                java.math.RoundingMode r1 = java.math.RoundingMode.HALF_EVEN     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f30705a     // Catch:{ NoSuchFieldError -> 0x0054 }
                java.math.RoundingMode r1 = java.math.RoundingMode.HALF_UP     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f30705a     // Catch:{ NoSuchFieldError -> 0x0060 }
                java.math.RoundingMode r1 = java.math.RoundingMode.HALF_DOWN     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.DoubleMath.AnonymousClass1.<clinit>():void");
        }
    }

    private DoubleMath() {
    }

    public static boolean a(double d2) {
        if (!DoubleUtils.b(d2) || (d2 != 0.0d && 52 - Long.numberOfTrailingZeros(DoubleUtils.a(d2)) > Math.getExponent(d2))) {
            return false;
        }
        return true;
    }

    static double b(double d2, RoundingMode roundingMode) {
        int i2;
        if (DoubleUtils.b(d2)) {
            switch (AnonymousClass1.f30705a[roundingMode.ordinal()]) {
                case 1:
                    MathPreconditions.e(a(d2));
                    return d2;
                case 2:
                    if (d2 >= 0.0d || a(d2)) {
                        return d2;
                    }
                    return (double) (((long) d2) - 1);
                case 3:
                    if (d2 <= 0.0d || a(d2)) {
                        return d2;
                    }
                    return (double) (((long) d2) + 1);
                case 4:
                    return d2;
                case 5:
                    if (a(d2)) {
                        return d2;
                    }
                    long j2 = (long) d2;
                    if (d2 > 0.0d) {
                        i2 = 1;
                    } else {
                        i2 = -1;
                    }
                    return (double) (j2 + ((long) i2));
                case 6:
                    return Math.rint(d2);
                case 7:
                    double rint = Math.rint(d2);
                    if (Math.abs(d2 - rint) == 0.5d) {
                        return d2 + Math.copySign(0.5d, d2);
                    }
                    return rint;
                case 8:
                    double rint2 = Math.rint(d2);
                    if (Math.abs(d2 - rint2) == 0.5d) {
                        return d2;
                    }
                    return rint2;
                default:
                    throw new AssertionError();
            }
        } else {
            throw new ArithmeticException("input is infinite or NaN");
        }
    }

    public static long c(double d2, RoundingMode roundingMode) {
        boolean z2;
        double b2 = b(d2, roundingMode);
        boolean z3 = true;
        if (-9.223372036854776E18d - b2 < 1.0d) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (b2 >= 9.223372036854776E18d) {
            z3 = false;
        }
        MathPreconditions.a(z2 & z3, d2, roundingMode);
        return (long) b2;
    }
}
