package com.startapp;

import android.content.Context;
import com.startapp.networkTest.data.TimeInfo;
import java.util.TimeZone;

public class w2 {
    public static String a(long j2) {
        return a(j2, false);
    }

    public static String b(long j2) {
        return a(j2, true);
    }

    public static i3 c(long j2) {
        return a(j2, TimeZone.getDefault().getOffset(j2));
    }

    public static String a(Context context) {
        return b(r2.d());
    }

    public static String b(int i2, int i3, int i4) {
        StringBuilder sb = new StringBuilder();
        if (i2 < 10) {
            sb.append("0");
        }
        sb.append(i2);
        sb.append("-");
        if (i3 < 10) {
            sb.append("0");
        }
        sb.append(i3);
        sb.append("-");
        if (i4 < 10) {
            sb.append("0");
        }
        sb.append(i4);
        return sb.toString();
    }

    private static String a(long j2, boolean z2) {
        i3 c2 = c(j2);
        return a(c2.f34678a, c2.f34679b, c2.f34680c, c2.f34681d, c2.f34682e, c2.f34683f, c2.f34684g, z2, c2.f34685h);
    }

    public static i3 a(long j2, int i2) {
        int i3;
        int i4;
        long j3 = ((long) i2) + j2;
        long j4 = j3 / 1000;
        int i5 = (int) (j3 % 1000);
        long j5 = j4 / 60;
        int i6 = (int) (j4 % 60);
        long j6 = j5 / 60;
        int i7 = (int) (j5 % 60);
        int i8 = (int) (j6 / 24);
        int i9 = (int) (j6 % 24);
        int i10 = 1970;
        int i11 = 365;
        int i12 = 0;
        boolean z2 = false;
        while (true) {
            i3 = 1;
            i4 = i8 + 1;
            if (i11 >= i4) {
                break;
            }
            i10++;
            int i13 = i11 + 365;
            if ((i10 % 4 != 0 || i10 % 100 == 0) && i10 % 400 != 0) {
                z2 = false;
            } else {
                i13++;
                z2 = true;
            }
            int i14 = i13;
            i12 = i11;
            i11 = i14;
        }
        int i15 = i4 - i12;
        int i16 = 31;
        int i17 = 0;
        while (i16 < i15) {
            i3++;
            i17 = i16;
            i16 = (!z2 || i3 != 2) ? i3 == 2 ? i16 + 28 : (i3 == 4 || i3 == 6 || i3 == 9 || i3 == 11) ? i16 + 30 : i16 + 31 : i16 + 29;
        }
        return new i3(i10, i3, i15 - i17, i9, i7, i6, i5, i2);
    }

    public static String a(int i2, int i3, int i4) {
        StringBuilder sb = new StringBuilder();
        sb.append(i2);
        sb.append("-");
        if (i3 < 10) {
            sb.append("0");
        }
        sb.append(i3);
        sb.append("-");
        if (i4 < 10) {
            sb.append("0");
        }
        sb.append(i4);
        return sb.toString();
    }

    public static String a(int i2, int i3, int i4, int i5, int i6, int i7) {
        StringBuilder sb = new StringBuilder();
        sb.append(i2);
        sb.append("-");
        if (i3 < 10) {
            sb.append("0");
        }
        sb.append(i3);
        sb.append("-");
        if (i4 < 10) {
            sb.append("0");
        }
        sb.append(i4);
        sb.append("-");
        if (i5 < 10) {
            sb.append("0");
        }
        sb.append(i5);
        sb.append("-");
        if (i6 < 10) {
            sb.append("0");
        }
        sb.append(i6);
        sb.append("-");
        if (i7 < 10) {
            sb.append("0");
        }
        sb.append(i7);
        return sb.toString();
    }

    public static String a(int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        String a2 = a(i2, i3, i4, i5, i6, i7);
        String str = "" + i8;
        if (i8 < 10) {
            str = "00" + i8;
        } else if (i8 < 100) {
            str = "0" + i8;
        }
        return a2 + "-" + str;
    }

    public static String a(int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z2, int i9) {
        int i10 = i3;
        int i11 = i4;
        int i12 = i5;
        int i13 = i6;
        int i14 = i7;
        int i15 = i8;
        int i16 = i9;
        String str = "" + i11;
        String str2 = "" + i10;
        String str3 = "" + i12;
        String str4 = "" + i13;
        String str5 = "" + i14;
        String str6 = "" + i15;
        if (i11 < 10) {
            str = "0" + i11;
        }
        if (i10 < 10) {
            str2 = "0" + i10;
        }
        if (i12 < 10) {
            str3 = "0" + i12;
        }
        if (i13 < 10) {
            str4 = "0" + i13;
        }
        if (i14 < 10) {
            str5 = "0" + i14;
        }
        if (i15 < 10) {
            str6 = "00" + i15;
        } else if (i15 < 100) {
            str6 = "0" + i15;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(i2);
        String str7 = "-";
        sb.append(str7);
        sb.append(str2);
        sb.append(str7);
        sb.append(str);
        sb.append(" ");
        sb.append(str3);
        sb.append(":");
        sb.append(str4);
        sb.append(":");
        sb.append(str5);
        sb.append(".");
        sb.append(str6);
        String sb2 = sb.toString();
        if (!z2) {
            return sb2;
        }
        int i17 = (i16 / 1000) / 60;
        if (i16 < 0) {
            i17 *= -1;
        } else {
            str7 = "+";
        }
        int i18 = i17 / 60;
        int i19 = i17 % 60;
        String str8 = "" + i18;
        String str9 = "" + i19;
        if (i18 < 10) {
            str8 = "0" + i18;
        }
        if (i19 < 10) {
            str9 = "0" + i19;
        }
        return sb2 + " " + str7 + str8 + str9;
    }

    public static TimeInfo a(TimeInfo timeInfo, long j2) {
        TimeInfo timeInfo2 = new TimeInfo();
        timeInfo2.DeviceDriftMillis = timeInfo.DeviceDriftMillis;
        timeInfo2.IsSynced = timeInfo.IsSynced;
        timeInfo2.MillisSinceLastSync = timeInfo.MillisSinceLastSync;
        timeInfo2.TimeSource = timeInfo.TimeSource;
        timeInfo2.TimestampDateTime = a(timeInfo.TimestampMillis + j2);
        timeInfo2.TimestampMillis = timeInfo.TimestampMillis + j2;
        timeInfo2.TimestampOffset = timeInfo.TimestampOffset;
        timeInfo2.TimestampTableau = b(timeInfo.TimestampMillis + j2);
        return timeInfo2;
    }
}
