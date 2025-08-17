package androidx.core.util;

import java.io.PrintWriter;
import org.joda.time.DateTimeConstants;

public final class TimeUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f2726a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static char[] f2727b = new char[24];

    private TimeUtils() {
    }

    private static int a(int i2, int i3, boolean z2, int i4) {
        if (i2 > 99 || (z2 && i4 >= 3)) {
            return i3 + 3;
        }
        if (i2 > 9 || (z2 && i4 >= 2)) {
            return i3 + 2;
        }
        if (z2 || i2 > 0) {
            return i3 + 1;
        }
        return 0;
    }

    public static void b(long j2, long j3, PrintWriter printWriter) {
        if (j2 == 0) {
            printWriter.print("--");
        } else {
            d(j2 - j3, printWriter, 0);
        }
    }

    public static void c(long j2, PrintWriter printWriter) {
        d(j2, printWriter, 0);
    }

    public static void d(long j2, PrintWriter printWriter, int i2) {
        synchronized (f2726a) {
            printWriter.print(new String(f2727b, 0, e(j2, i2)));
        }
    }

    private static int e(long j2, int i2) {
        char c2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        boolean z2;
        boolean z3;
        int i8;
        boolean z4;
        int i9;
        boolean z5;
        int i10;
        int i11;
        boolean z6;
        boolean z7;
        boolean z8;
        int i12;
        long j3 = j2;
        int i13 = i2;
        if (f2727b.length < i13) {
            f2727b = new char[i13];
        }
        char[] cArr = f2727b;
        int i14 = (j3 > 0 ? 1 : (j3 == 0 ? 0 : -1));
        if (i14 == 0) {
            int i15 = i13 - 1;
            while (i15 > 0) {
                cArr[0] = ' ';
            }
            cArr[0] = '0';
            return 1;
        }
        if (i14 > 0) {
            c2 = '+';
        } else {
            j3 = -j3;
            c2 = '-';
        }
        int i16 = (int) (j3 % 1000);
        int floor = (int) Math.floor((double) (j3 / 1000));
        if (floor > 86400) {
            i3 = floor / DateTimeConstants.SECONDS_PER_DAY;
            floor -= DateTimeConstants.SECONDS_PER_DAY * i3;
        } else {
            i3 = 0;
        }
        if (floor > 3600) {
            i4 = floor / DateTimeConstants.SECONDS_PER_HOUR;
            floor -= i4 * DateTimeConstants.SECONDS_PER_HOUR;
        } else {
            i4 = 0;
        }
        if (floor > 60) {
            int i17 = floor / 60;
            i5 = floor - (i17 * 60);
            i6 = i17;
        } else {
            i5 = floor;
            i6 = 0;
        }
        if (i13 != 0) {
            int a2 = a(i3, 1, false, 0);
            if (a2 > 0) {
                z6 = true;
            } else {
                z6 = false;
            }
            int a3 = a2 + a(i4, 1, z6, 2);
            if (a3 > 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            int a4 = a3 + a(i6, 1, z7, 2);
            if (a4 > 0) {
                z8 = true;
            } else {
                z8 = false;
            }
            int a5 = a4 + a(i5, 1, z8, 2);
            if (a5 > 0) {
                i12 = 3;
            } else {
                i12 = 0;
            }
            i7 = 0;
            for (int a6 = a5 + a(i16, 2, true, i12) + 1; a6 < i13; a6++) {
                cArr[i7] = ' ';
                i7++;
            }
        } else {
            i7 = 0;
        }
        cArr[i7] = c2;
        int i18 = i7 + 1;
        if (i13 != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        int i19 = i18;
        int f2 = f(cArr, i3, 'd', i18, false, 0);
        if (f2 != i19) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z2) {
            i8 = 2;
        } else {
            i8 = 0;
        }
        int f3 = f(cArr, i4, 'h', f2, z3, i8);
        if (f3 != i19) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z2) {
            i9 = 2;
        } else {
            i9 = 0;
        }
        int f4 = f(cArr, i6, 'm', f3, z4, i9);
        if (f4 != i19) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z2) {
            i10 = 2;
        } else {
            i10 = 0;
        }
        int f5 = f(cArr, i5, 's', f4, z5, i10);
        if (!z2 || f5 == i19) {
            i11 = 0;
        } else {
            i11 = 3;
        }
        int f6 = f(cArr, i16, 'm', f5, true, i11);
        cArr[f6] = 's';
        return f6 + 1;
    }

    private static int f(char[] cArr, int i2, char c2, int i3, boolean z2, int i4) {
        int i5;
        if (!z2 && i2 <= 0) {
            return i3;
        }
        if ((!z2 || i4 < 3) && i2 <= 99) {
            i5 = i3;
        } else {
            int i6 = i2 / 100;
            cArr[i3] = (char) (i6 + 48);
            i5 = i3 + 1;
            i2 -= i6 * 100;
        }
        if ((z2 && i4 >= 2) || i2 > 9 || i3 != i5) {
            int i7 = i2 / 10;
            cArr[i5] = (char) (i7 + 48);
            i5++;
            i2 -= i7 * 10;
        }
        cArr[i5] = (char) (i2 + 48);
        int i8 = i5 + 1;
        cArr[i8] = c2;
        return i8 + 1;
    }
}
