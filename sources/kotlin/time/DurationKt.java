package kotlin.time;

import com.facebook.common.time.Clock;
import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.CharRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.LongRange;

public final class DurationKt {
    /* access modifiers changed from: private */
    public static final long i(long j2, int i2) {
        return Duration.h((j2 << 1) + ((long) i2));
    }

    /* access modifiers changed from: private */
    public static final long j(long j2) {
        return Duration.h((j2 << 1) + 1);
    }

    /* access modifiers changed from: private */
    public static final long k(long j2) {
        if (new LongRange(-4611686018426L, 4611686018426L).e(j2)) {
            return l(n(j2));
        }
        return j(RangesKt___RangesKt.g(j2, -4611686018427387903L, 4611686018427387903L));
    }

    /* access modifiers changed from: private */
    public static final long l(long j2) {
        return Duration.h(j2 << 1);
    }

    /* access modifiers changed from: private */
    public static final long m(long j2) {
        if (new LongRange(-4611686018426999999L, 4611686018426999999L).e(j2)) {
            return l(j2);
        }
        return j(o(j2));
    }

    /* access modifiers changed from: private */
    public static final long n(long j2) {
        return j2 * ((long) 1000000);
    }

    /* access modifiers changed from: private */
    public static final long o(long j2) {
        return j2 / ((long) 1000000);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x00a6 A[EDGE_INSN: B:160:0x00a6->B:45:0x00a6 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x009a A[LOOP:1: B:33:0x006c->B:43:0x009a, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final long p(java.lang.String r27, boolean r28) {
        /*
            r6 = r27
            int r7 = r27.length()
            if (r7 == 0) goto L_0x02cf
            kotlin.time.Duration$Companion r8 = kotlin.time.Duration.f40567c
            long r9 = r8.b()
            java.lang.String r2 = "Infinity"
            r11 = 0
            char r0 = r6.charAt(r11)
            r1 = 43
            r3 = 45
            r12 = 1
            if (r0 != r1) goto L_0x001e
        L_0x001c:
            r13 = 1
            goto L_0x0022
        L_0x001e:
            if (r0 != r3) goto L_0x0021
            goto L_0x001c
        L_0x0021:
            r13 = 0
        L_0x0022:
            if (r13 <= 0) goto L_0x0026
            r14 = 1
            goto L_0x0027
        L_0x0026:
            r14 = 0
        L_0x0027:
            r0 = 2
            r15 = 0
            if (r14 == 0) goto L_0x0034
            boolean r1 = kotlin.text.StringsKt__StringsKt.A0(r6, r3, r11, r0, r15)
            if (r1 == 0) goto L_0x0034
            r16 = 1
            goto L_0x0036
        L_0x0034:
            r16 = 0
        L_0x0036:
            java.lang.String r5 = "No components"
            if (r7 <= r13) goto L_0x02c8
            char r1 = r6.charAt(r13)
            r3 = 80
            java.lang.String r4 = "this as java.lang.String).substring(startIndex)"
            r17 = r5
            java.lang.String r5 = "Unexpected order of duration components"
            r11 = 48
            java.lang.String r15 = "this as java.lang.String…ing(startIndex, endIndex)"
            java.lang.String r0 = "null cannot be cast to non-null type java.lang.String"
            if (r1 != r3) goto L_0x015c
            int r13 = r13 + r12
            if (r13 == r7) goto L_0x0156
            r1 = 0
            r2 = 0
        L_0x0053:
            if (r13 >= r7) goto L_0x02bb
            char r3 = r6.charAt(r13)
            r8 = 84
            if (r3 != r8) goto L_0x006b
            if (r1 != 0) goto L_0x0065
            int r13 = r13 + 1
            if (r13 == r7) goto L_0x0065
            r1 = 1
            goto L_0x0053
        L_0x0065:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>()
            throw r0
        L_0x006b:
            r3 = r13
        L_0x006c:
            int r8 = r27.length()
            if (r3 >= r8) goto L_0x00a2
            char r8 = r6.charAt(r3)
            kotlin.ranges.CharRange r14 = new kotlin.ranges.CharRange
            r12 = 57
            r14.<init>(r11, r12)
            boolean r14 = r14.e(r8)
            if (r14 != 0) goto L_0x0093
            java.lang.String r14 = "+-."
            r18 = r7
            r7 = 0
            r11 = 0
            r12 = 2
            boolean r8 = kotlin.text.StringsKt__StringsKt.K(r14, r8, r7, r12, r11)
            if (r8 == 0) goto L_0x0091
            goto L_0x0097
        L_0x0091:
            r7 = 0
            goto L_0x0098
        L_0x0093:
            r18 = r7
            r11 = 0
            r12 = 2
        L_0x0097:
            r7 = 1
        L_0x0098:
            if (r7 == 0) goto L_0x00a6
            int r3 = r3 + 1
            r7 = r18
            r11 = 48
            r12 = 1
            goto L_0x006c
        L_0x00a2:
            r18 = r7
            r11 = 0
            r12 = 2
        L_0x00a6:
            kotlin.jvm.internal.Intrinsics.d(r6, r0)
            java.lang.String r3 = r6.substring(r13, r3)
            kotlin.jvm.internal.Intrinsics.e(r3, r15)
            int r7 = r3.length()
            if (r7 != 0) goto L_0x00b8
            r7 = 1
            goto L_0x00b9
        L_0x00b8:
            r7 = 0
        L_0x00b9:
            if (r7 != 0) goto L_0x0150
            int r7 = r3.length()
            int r13 = r13 + r7
            if (r13 < 0) goto L_0x0139
            int r7 = kotlin.text.StringsKt__StringsKt.Q(r27)
            if (r13 > r7) goto L_0x0139
            char r7 = r6.charAt(r13)
            int r13 = r13 + 1
            kotlin.time.DurationUnit r7 = kotlin.time.DurationUnitKt__DurationUnitKt.d(r7, r1)
            if (r2 == 0) goto L_0x00e1
            int r2 = r2.compareTo(r7)
            if (r2 <= 0) goto L_0x00db
            goto L_0x00e1
        L_0x00db:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r5)
            throw r0
        L_0x00e1:
            r20 = 46
            r21 = 0
            r22 = 0
            r23 = 6
            r24 = 0
            r19 = r3
            int r2 = kotlin.text.StringsKt__StringsKt.V(r19, r20, r21, r22, r23, r24)
            kotlin.time.DurationUnit r8 = kotlin.time.DurationUnit.SECONDS
            if (r7 != r8) goto L_0x0125
            if (r2 <= 0) goto L_0x0125
            kotlin.jvm.internal.Intrinsics.d(r3, r0)
            r8 = 0
            java.lang.String r14 = r3.substring(r8, r2)
            kotlin.jvm.internal.Intrinsics.e(r14, r15)
            long r11 = q(r14)
            long r11 = s(r11, r7)
            long r9 = kotlin.time.Duration.A(r9, r11)
            kotlin.jvm.internal.Intrinsics.d(r3, r0)
            java.lang.String r2 = r3.substring(r2)
            kotlin.jvm.internal.Intrinsics.e(r2, r4)
            double r2 = java.lang.Double.parseDouble(r2)
            long r2 = r(r2, r7)
            long r9 = kotlin.time.Duration.A(r9, r2)
            goto L_0x0131
        L_0x0125:
            long r2 = q(r3)
            long r2 = s(r2, r7)
            long r9 = kotlin.time.Duration.A(r9, r2)
        L_0x0131:
            r2 = r7
            r7 = r18
            r11 = 48
            r12 = 1
            goto L_0x0053
        L_0x0139:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Missing unit for value "
            r1.append(r2)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0150:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>()
            throw r0
        L_0x0156:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>()
            throw r0
        L_0x015c:
            r18 = r7
            if (r28 != 0) goto L_0x02c2
            r3 = 0
            int r7 = r18 - r13
            r1 = 8
            int r7 = java.lang.Math.max(r7, r1)
            r11 = 1
            r1 = r0
            r12 = 57
            r0 = r27
            r25 = r1
            r1 = r13
            r26 = r4
            r4 = r7
            r7 = r5
            r12 = r17
            r5 = r11
            boolean r0 = kotlin.text.StringsKt__StringsJVMKt.w(r0, r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x0185
            long r9 = r8.a()
            goto L_0x02bb
        L_0x0185:
            r0 = r14 ^ 1
            if (r14 == 0) goto L_0x01a8
            char r1 = r6.charAt(r13)
            r2 = 40
            if (r1 != r2) goto L_0x01a8
            char r1 = kotlin.text.StringsKt___StringsKt.S0(r27)
            r2 = 41
            if (r1 != r2) goto L_0x01a8
            int r13 = r13 + 1
            int r0 = r18 + -1
            if (r13 == r0) goto L_0x01a2
            r1 = r0
            r0 = 1
            goto L_0x01aa
        L_0x01a2:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r12)
            throw r0
        L_0x01a8:
            r1 = r18
        L_0x01aa:
            r2 = 0
            r3 = 0
        L_0x01ac:
            if (r13 >= r1) goto L_0x02bb
            if (r2 == 0) goto L_0x01c8
            if (r0 == 0) goto L_0x01c8
        L_0x01b2:
            int r2 = r27.length()
            if (r13 >= r2) goto L_0x01c8
            char r2 = r6.charAt(r13)
            r4 = 32
            if (r2 != r4) goto L_0x01c2
            r2 = 1
            goto L_0x01c3
        L_0x01c2:
            r2 = 0
        L_0x01c3:
            if (r2 == 0) goto L_0x01c8
            int r13 = r13 + 1
            goto L_0x01b2
        L_0x01c8:
            r2 = r13
        L_0x01c9:
            int r4 = r27.length()
            if (r2 >= r4) goto L_0x01ef
            char r4 = r6.charAt(r2)
            kotlin.ranges.CharRange r5 = new kotlin.ranges.CharRange
            r8 = 57
            r11 = 48
            r5.<init>(r11, r8)
            boolean r5 = r5.e(r4)
            if (r5 != 0) goto L_0x01e9
            r5 = 46
            if (r4 != r5) goto L_0x01e7
            goto L_0x01e9
        L_0x01e7:
            r4 = 0
            goto L_0x01ea
        L_0x01e9:
            r4 = 1
        L_0x01ea:
            if (r4 == 0) goto L_0x01f3
            int r2 = r2 + 1
            goto L_0x01c9
        L_0x01ef:
            r8 = 57
            r11 = 48
        L_0x01f3:
            r4 = r25
            kotlin.jvm.internal.Intrinsics.d(r6, r4)
            java.lang.String r2 = r6.substring(r13, r2)
            kotlin.jvm.internal.Intrinsics.e(r2, r15)
            int r5 = r2.length()
            if (r5 != 0) goto L_0x0207
            r5 = 1
            goto L_0x0208
        L_0x0207:
            r5 = 0
        L_0x0208:
            if (r5 != 0) goto L_0x02b5
            int r5 = r2.length()
            int r13 = r13 + r5
            r5 = r13
        L_0x0210:
            int r12 = r27.length()
            if (r5 >= r12) goto L_0x0230
            char r12 = r6.charAt(r5)
            kotlin.ranges.CharRange r14 = new kotlin.ranges.CharRange
            r8 = 97
            r11 = 122(0x7a, float:1.71E-43)
            r14.<init>(r8, r11)
            boolean r8 = r14.e(r12)
            if (r8 == 0) goto L_0x0230
            int r5 = r5 + 1
            r8 = 57
            r11 = 48
            goto L_0x0210
        L_0x0230:
            kotlin.jvm.internal.Intrinsics.d(r6, r4)
            java.lang.String r5 = r6.substring(r13, r5)
            kotlin.jvm.internal.Intrinsics.e(r5, r15)
            int r8 = r5.length()
            int r13 = r13 + r8
            kotlin.time.DurationUnit r5 = kotlin.time.DurationUnitKt__DurationUnitKt.e(r5)
            if (r3 == 0) goto L_0x0252
            int r3 = r3.compareTo(r5)
            if (r3 <= 0) goto L_0x024c
            goto L_0x0252
        L_0x024c:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r7)
            throw r0
        L_0x0252:
            r20 = 46
            r21 = 0
            r22 = 0
            r23 = 6
            r24 = 0
            r19 = r2
            int r3 = kotlin.text.StringsKt__StringsKt.V(r19, r20, r21, r22, r23, r24)
            if (r3 <= 0) goto L_0x02a0
            kotlin.jvm.internal.Intrinsics.d(r2, r4)
            r8 = 0
            java.lang.String r11 = r2.substring(r8, r3)
            kotlin.jvm.internal.Intrinsics.e(r11, r15)
            long r11 = java.lang.Long.parseLong(r11)
            long r11 = s(r11, r5)
            long r9 = kotlin.time.Duration.A(r9, r11)
            kotlin.jvm.internal.Intrinsics.d(r2, r4)
            java.lang.String r2 = r2.substring(r3)
            r3 = r26
            kotlin.jvm.internal.Intrinsics.e(r2, r3)
            double r11 = java.lang.Double.parseDouble(r2)
            long r11 = r(r11, r5)
            long r9 = kotlin.time.Duration.A(r9, r11)
            if (r13 < r1) goto L_0x0298
            r26 = r3
            goto L_0x02af
        L_0x0298:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Fractional component must be last"
            r0.<init>(r1)
            throw r0
        L_0x02a0:
            r3 = r26
            r8 = 0
            long r11 = java.lang.Long.parseLong(r2)
            long r11 = s(r11, r5)
            long r9 = kotlin.time.Duration.A(r9, r11)
        L_0x02af:
            r25 = r4
            r3 = r5
            r2 = 1
            goto L_0x01ac
        L_0x02b5:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>()
            throw r0
        L_0x02bb:
            if (r16 == 0) goto L_0x02c1
            long r9 = kotlin.time.Duration.E(r9)
        L_0x02c1:
            return r9
        L_0x02c2:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>()
            throw r0
        L_0x02c8:
            r12 = r5
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r12)
            throw r0
        L_0x02cf:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "The string is empty"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.time.DurationKt.p(java.lang.String, boolean):long");
    }

    private static final long q(String str) {
        int i2;
        boolean z2;
        int length = str.length();
        if (length <= 0 || !StringsKt__StringsKt.K("+-", str.charAt(0), false, 2, (Object) null)) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        if (length - i2 > 16) {
            IntRange intRange = new IntRange(i2, StringsKt__StringsKt.Q(str));
            if (!(intRange instanceof Collection) || !((Collection) intRange).isEmpty()) {
                Iterator it2 = intRange.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    if (!new CharRange('0', '9').e(str.charAt(((IntIterator) it2).nextInt()))) {
                        z2 = false;
                        break;
                    }
                }
            }
            z2 = true;
            if (z2) {
                if (str.charAt(0) == '-') {
                    return Long.MIN_VALUE;
                }
                return Clock.MAX_TIME;
            }
        }
        if (StringsKt__StringsJVMKt.G(str, "+", false, 2, (Object) null)) {
            str = StringsKt___StringsKt.R0(str, 1);
        }
        return Long.parseLong(str);
    }

    public static final long r(double d2, DurationUnit durationUnit) {
        Intrinsics.f(durationUnit, "unit");
        double a2 = DurationUnitKt__DurationUnitJvmKt.a(d2, durationUnit, DurationUnit.NANOSECONDS);
        if (!Double.isNaN(a2)) {
            long c2 = MathKt__MathJVMKt.c(a2);
            if (new LongRange(-4611686018426999999L, 4611686018426999999L).e(c2)) {
                return l(c2);
            }
            return k(MathKt__MathJVMKt.c(DurationUnitKt__DurationUnitJvmKt.a(d2, durationUnit, DurationUnit.MILLISECONDS)));
        }
        throw new IllegalArgumentException("Duration value cannot be NaN.".toString());
    }

    public static final long s(long j2, DurationUnit durationUnit) {
        Intrinsics.f(durationUnit, "unit");
        DurationUnit durationUnit2 = DurationUnit.NANOSECONDS;
        long c2 = DurationUnitKt__DurationUnitJvmKt.c(4611686018426999999L, durationUnit2, durationUnit);
        if (new LongRange(-c2, c2).e(j2)) {
            return l(DurationUnitKt__DurationUnitJvmKt.c(j2, durationUnit, durationUnit2));
        }
        return j(RangesKt___RangesKt.g(DurationUnitKt__DurationUnitJvmKt.b(j2, durationUnit, DurationUnit.MILLISECONDS), -4611686018427387903L, 4611686018427387903L));
    }
}
