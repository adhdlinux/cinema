package kotlin.text;

import kotlin.jvm.internal.Intrinsics;

class StringsKt__StringNumberConversionsKt extends StringsKt__StringNumberConversionsJVMKt {
    public static final Void j(String str) {
        Intrinsics.f(str, "input");
        throw new NumberFormatException("Invalid number format: '" + str + '\'');
    }

    public static Integer k(String str) {
        Intrinsics.f(str, "<this>");
        return l(str, 10);
    }

    public static final Integer l(String str, int i2) {
        int i3;
        boolean z2;
        int i4;
        Intrinsics.f(str, "<this>");
        int unused = CharsKt__CharJVMKt.a(i2);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i5 = 0;
        char charAt = str.charAt(0);
        int i6 = -2147483647;
        if (Intrinsics.h(charAt, 48) < 0) {
            i3 = 1;
            if (length == 1) {
                return null;
            }
            if (charAt == '-') {
                i6 = Integer.MIN_VALUE;
                z2 = true;
            } else if (charAt != '+') {
                return null;
            } else {
                z2 = false;
            }
        } else {
            z2 = false;
            i3 = 0;
        }
        int i7 = -59652323;
        while (i3 < length) {
            int b2 = CharsKt__CharJVMKt.b(str.charAt(i3), i2);
            if (b2 < 0) {
                return null;
            }
            if ((i5 < i7 && (i7 != -59652323 || i5 < (i7 = i6 / i2))) || (i4 = i5 * i2) < i6 + b2) {
                return null;
            }
            i5 = i4 - b2;
            i3++;
        }
        if (z2) {
            return Integer.valueOf(i5);
        }
        return Integer.valueOf(-i5);
    }

    public static Long m(String str) {
        Intrinsics.f(str, "<this>");
        return n(str, 10);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x007a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Long n(java.lang.String r18, int r19) {
        /*
            r0 = r18
            r1 = r19
            java.lang.String r2 = "<this>"
            kotlin.jvm.internal.Intrinsics.f(r0, r2)
            int unused = kotlin.text.CharsKt__CharJVMKt.a(r19)
            int r2 = r18.length()
            r3 = 0
            if (r2 != 0) goto L_0x0014
            return r3
        L_0x0014:
            r4 = 0
            char r5 = r0.charAt(r4)
            r6 = 48
            int r6 = kotlin.jvm.internal.Intrinsics.h(r5, r6)
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r6 >= 0) goto L_0x0039
            r6 = 1
            if (r2 != r6) goto L_0x002a
            return r3
        L_0x002a:
            r9 = 45
            if (r5 != r9) goto L_0x0032
            r7 = -9223372036854775808
            r4 = 1
            goto L_0x003a
        L_0x0032:
            r9 = 43
            if (r5 != r9) goto L_0x0038
            r4 = 1
            goto L_0x0039
        L_0x0038:
            return r3
        L_0x0039:
            r6 = 0
        L_0x003a:
            r9 = -256204778801521550(0xfc71c71c71c71c72, double:-2.772000429909333E291)
            r11 = 0
            r13 = r9
        L_0x0042:
            if (r4 >= r2) goto L_0x0073
            char r5 = r0.charAt(r4)
            int r5 = kotlin.text.CharsKt__CharJVMKt.b(r5, r1)
            if (r5 >= 0) goto L_0x004f
            return r3
        L_0x004f:
            int r15 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r15 >= 0) goto L_0x005f
            int r15 = (r13 > r9 ? 1 : (r13 == r9 ? 0 : -1))
            if (r15 != 0) goto L_0x005e
            long r13 = (long) r1
            long r13 = r7 / r13
            int r15 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r15 >= 0) goto L_0x005f
        L_0x005e:
            return r3
        L_0x005f:
            long r9 = (long) r1
            long r11 = r11 * r9
            long r9 = (long) r5
            long r16 = r7 + r9
            int r5 = (r11 > r16 ? 1 : (r11 == r16 ? 0 : -1))
            if (r5 >= 0) goto L_0x006a
            return r3
        L_0x006a:
            long r11 = r11 - r9
            int r4 = r4 + 1
            r9 = -256204778801521550(0xfc71c71c71c71c72, double:-2.772000429909333E291)
            goto L_0x0042
        L_0x0073:
            if (r6 == 0) goto L_0x007a
            java.lang.Long r0 = java.lang.Long.valueOf(r11)
            goto L_0x007f
        L_0x007a:
            long r0 = -r11
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
        L_0x007f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.StringsKt__StringNumberConversionsKt.n(java.lang.String, int):java.lang.Long");
    }
}
