package com.google.gson.internal.bind.util;

import java.util.TimeZone;

public class ISO8601Utils {

    /* renamed from: a  reason: collision with root package name */
    private static final TimeZone f31123a = TimeZone.getTimeZone("UTC");

    private ISO8601Utils() {
    }

    private static boolean a(String str, int i2, char c2) {
        return i2 < str.length() && str.charAt(i2) == c2;
    }

    private static int b(String str, int i2) {
        while (i2 < str.length()) {
            char charAt = str.charAt(i2);
            if (charAt < '0' || charAt > '9') {
                return i2;
            }
            i2++;
        }
        return str.length();
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x00d3 A[Catch:{ IllegalArgumentException | IndexOutOfBoundsException -> 0x01c0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01b8 A[Catch:{ IllegalArgumentException | IndexOutOfBoundsException -> 0x01c0 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Date c(java.lang.String r17, java.text.ParsePosition r18) throws java.text.ParseException {
        /*
            r1 = r17
            r2 = r18
            int r0 = r18.getIndex()     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            int r3 = r0 + 4
            int r0 = d(r1, r0, r3)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            r4 = 45
            boolean r5 = a(r1, r3, r4)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            if (r5 == 0) goto L_0x0018
            int r3 = r3 + 1
        L_0x0018:
            int r5 = r3 + 2
            int r3 = d(r1, r3, r5)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            boolean r6 = a(r1, r5, r4)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            if (r6 == 0) goto L_0x0026
            int r5 = r5 + 1
        L_0x0026:
            int r6 = r5 + 2
            int r5 = d(r1, r5, r6)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            r7 = 84
            boolean r7 = a(r1, r6, r7)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            r8 = 0
            r9 = 1
            if (r7 != 0) goto L_0x004d
            int r10 = r17.length()     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            if (r10 > r6) goto L_0x004d
            java.util.GregorianCalendar r4 = new java.util.GregorianCalendar     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            int r3 = r3 - r9
            r4.<init>(r0, r3, r5)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            r4.setLenient(r8)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            r2.setIndex(r6)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            java.util.Date r0 = r4.getTime()     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            return r0
        L_0x004d:
            r10 = 43
            r11 = 90
            r12 = 2
            if (r7 == 0) goto L_0x00c9
            int r6 = r6 + 1
            int r7 = r6 + 2
            int r6 = d(r1, r6, r7)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            r13 = 58
            boolean r14 = a(r1, r7, r13)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            if (r14 == 0) goto L_0x0066
            int r7 = r7 + 1
        L_0x0066:
            int r14 = r7 + 2
            int r7 = d(r1, r7, r14)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            boolean r13 = a(r1, r14, r13)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            if (r13 == 0) goto L_0x0074
            int r14 = r14 + 1
        L_0x0074:
            int r13 = r17.length()     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            if (r13 <= r14) goto L_0x00c4
            char r13 = r1.charAt(r14)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            if (r13 == r11) goto L_0x00c4
            if (r13 == r10) goto L_0x00c4
            if (r13 == r4) goto L_0x00c4
            int r13 = r14 + 2
            int r14 = d(r1, r14, r13)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            r15 = 59
            if (r14 <= r15) goto L_0x0094
            r15 = 63
            if (r14 >= r15) goto L_0x0094
            r14 = 59
        L_0x0094:
            r15 = 46
            boolean r15 = a(r1, r13, r15)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            if (r15 == 0) goto L_0x00bf
            int r13 = r13 + 1
            int r15 = r13 + 1
            int r15 = b(r1, r15)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            int r8 = r13 + 3
            int r8 = java.lang.Math.min(r15, r8)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            int r16 = d(r1, r13, r8)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            int r8 = r8 - r13
            if (r8 == r9) goto L_0x00b7
            if (r8 == r12) goto L_0x00b4
            goto L_0x00b9
        L_0x00b4:
            int r16 = r16 * 10
            goto L_0x00b9
        L_0x00b7:
            int r16 = r16 * 100
        L_0x00b9:
            r8 = r7
            r13 = r16
            r7 = r6
            r6 = r15
            goto L_0x00cd
        L_0x00bf:
            r8 = r7
            r7 = r6
            r6 = r13
            r13 = 0
            goto L_0x00cd
        L_0x00c4:
            r8 = r7
            r13 = 0
            r7 = r6
            r6 = r14
            goto L_0x00cc
        L_0x00c9:
            r7 = 0
            r8 = 0
            r13 = 0
        L_0x00cc:
            r14 = 0
        L_0x00cd:
            int r15 = r17.length()     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            if (r15 <= r6) goto L_0x01b8
            char r15 = r1.charAt(r6)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            r12 = 5
            if (r15 != r11) goto L_0x00df
            java.util.TimeZone r4 = f31123a     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            int r6 = r6 + r9
            goto L_0x0187
        L_0x00df:
            if (r15 == r10) goto L_0x0100
            if (r15 != r4) goto L_0x00e4
            goto L_0x0100
        L_0x00e4:
            java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            r3.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            java.lang.String r4 = "Invalid time zone indicator '"
            r3.append(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            r3.append(r15)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            java.lang.String r4 = "'"
            r3.append(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            java.lang.String r3 = r3.toString()     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            r0.<init>(r3)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            throw r0     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
        L_0x0100:
            java.lang.String r4 = r1.substring(r6)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            int r10 = r4.length()     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            if (r10 < r12) goto L_0x010b
            goto L_0x011c
        L_0x010b:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            r10.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            r10.append(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            java.lang.String r4 = "00"
            r10.append(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            java.lang.String r4 = r10.toString()     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
        L_0x011c:
            int r10 = r4.length()     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            int r6 = r6 + r10
            java.lang.String r10 = "+0000"
            boolean r10 = r4.equals(r10)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            if (r10 != 0) goto L_0x0185
            java.lang.String r10 = "+00:00"
            boolean r10 = r4.equals(r10)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            if (r10 == 0) goto L_0x0132
            goto L_0x0185
        L_0x0132:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            r10.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            java.lang.String r11 = "GMT"
            r10.append(r11)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            r10.append(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            java.lang.String r4 = r10.toString()     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            java.util.TimeZone r10 = java.util.TimeZone.getTimeZone(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            java.lang.String r11 = r10.getID()     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            boolean r15 = r11.equals(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            if (r15 != 0) goto L_0x0183
            java.lang.String r15 = ":"
            java.lang.String r12 = ""
            java.lang.String r11 = r11.replace(r15, r12)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            boolean r11 = r11.equals(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            if (r11 == 0) goto L_0x0160
            goto L_0x0183
        L_0x0160:
            java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            r3.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            java.lang.String r5 = "Mismatching time zone indicator: "
            r3.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            r3.append(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            java.lang.String r4 = " given, resolves to "
            r3.append(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            java.lang.String r4 = r10.getID()     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            r3.append(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            java.lang.String r3 = r3.toString()     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            r0.<init>(r3)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            throw r0     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
        L_0x0183:
            r4 = r10
            goto L_0x0187
        L_0x0185:
            java.util.TimeZone r4 = f31123a     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
        L_0x0187:
            java.util.GregorianCalendar r10 = new java.util.GregorianCalendar     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            r10.<init>(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            r4 = 0
            r10.setLenient(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            r10.set(r9, r0)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            int r3 = r3 - r9
            r0 = 2
            r10.set(r0, r3)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            r0 = 5
            r10.set(r0, r5)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            r0 = 11
            r10.set(r0, r7)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            r0 = 12
            r10.set(r0, r8)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            r0 = 13
            r10.set(r0, r14)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            r0 = 14
            r10.set(r0, r13)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            r2.setIndex(r6)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            java.util.Date r0 = r10.getTime()     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            return r0
        L_0x01b8:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            java.lang.String r3 = "No time zone indicator"
            r0.<init>(r3)     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
            throw r0     // Catch:{ IndexOutOfBoundsException -> 0x01c2, IllegalArgumentException -> 0x01c0 }
        L_0x01c0:
            r0 = move-exception
            goto L_0x01c3
        L_0x01c2:
            r0 = move-exception
        L_0x01c3:
            if (r1 != 0) goto L_0x01c7
            r1 = 0
            goto L_0x01db
        L_0x01c7:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r4 = 34
            r3.append(r4)
            r3.append(r1)
            r3.append(r4)
            java.lang.String r1 = r3.toString()
        L_0x01db:
            java.lang.String r3 = r0.getMessage()
            if (r3 == 0) goto L_0x01e7
            boolean r4 = r3.isEmpty()
            if (r4 == 0) goto L_0x0205
        L_0x01e7:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "("
            r3.append(r4)
            java.lang.Class r4 = r0.getClass()
            java.lang.String r4 = r4.getName()
            r3.append(r4)
            java.lang.String r4 = ")"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
        L_0x0205:
            java.text.ParseException r4 = new java.text.ParseException
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Failed to parse date ["
            r5.append(r6)
            r5.append(r1)
            java.lang.String r1 = "]: "
            r5.append(r1)
            r5.append(r3)
            java.lang.String r1 = r5.toString()
            int r2 = r18.getIndex()
            r4.<init>(r1, r2)
            r4.initCause(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.util.ISO8601Utils.c(java.lang.String, java.text.ParsePosition):java.util.Date");
    }

    private static int d(String str, int i2, int i3) throws NumberFormatException {
        int i4;
        int i5;
        if (i2 < 0 || i3 > str.length() || i2 > i3) {
            throw new NumberFormatException(str);
        }
        if (i2 < i3) {
            i5 = i2 + 1;
            int digit = Character.digit(str.charAt(i2), 10);
            if (digit >= 0) {
                i4 = -digit;
            } else {
                throw new NumberFormatException("Invalid number: " + str.substring(i2, i3));
            }
        } else {
            i4 = 0;
            i5 = i2;
        }
        while (i5 < i3) {
            int i6 = i5 + 1;
            int digit2 = Character.digit(str.charAt(i5), 10);
            if (digit2 >= 0) {
                i4 = (i4 * 10) - digit2;
                i5 = i6;
            } else {
                throw new NumberFormatException("Invalid number: " + str.substring(i2, i3));
            }
        }
        return -i4;
    }
}
