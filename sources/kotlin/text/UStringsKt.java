package kotlin.text;

import com.facebook.imageutils.JfifUtil;
import kotlin.KotlinNothingValueException;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;

public final class UStringsKt {
    public static final byte a(String str) {
        Intrinsics.f(str, "<this>");
        UByte b2 = b(str);
        if (b2 != null) {
            return b2.f();
        }
        StringsKt__StringNumberConversionsKt.j(str);
        throw new KotlinNothingValueException();
    }

    public static final UByte b(String str) {
        Intrinsics.f(str, "<this>");
        return c(str, 10);
    }

    public static final UByte c(String str, int i2) {
        Intrinsics.f(str, "<this>");
        UInt f2 = f(str, i2);
        if (f2 == null) {
            return null;
        }
        int f3 = f2.f();
        if (Integer.compare(f3 ^ Integer.MIN_VALUE, UInt.b(JfifUtil.MARKER_FIRST_BYTE) ^ Integer.MIN_VALUE) > 0) {
            return null;
        }
        return UByte.a(UByte.b((byte) f3));
    }

    public static final int d(String str) {
        Intrinsics.f(str, "<this>");
        UInt e2 = e(str);
        if (e2 != null) {
            return e2.f();
        }
        StringsKt__StringNumberConversionsKt.j(str);
        throw new KotlinNothingValueException();
    }

    public static final UInt e(String str) {
        Intrinsics.f(str, "<this>");
        return f(str, 10);
    }

    public static final UInt f(String str, int i2) {
        int i3;
        Intrinsics.f(str, "<this>");
        int unused = CharsKt__CharJVMKt.a(i2);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i4 = 0;
        char charAt = str.charAt(0);
        if (Intrinsics.h(charAt, 48) < 0) {
            i3 = 1;
            if (length == 1 || charAt != '+') {
                return null;
            }
        } else {
            i3 = 0;
        }
        int b2 = UInt.b(i2);
        int i5 = 119304647;
        while (i3 < length) {
            int b3 = CharsKt__CharJVMKt.b(str.charAt(i3), i2);
            if (b3 < 0) {
                return null;
            }
            if (Integer.compare(i4 ^ Integer.MIN_VALUE, i5 ^ Integer.MIN_VALUE) > 0) {
                if (i5 == 119304647) {
                    i5 = d.a(-1, b2);
                    if (Integer.compare(i4 ^ Integer.MIN_VALUE, i5 ^ Integer.MIN_VALUE) > 0) {
                    }
                }
                return null;
            }
            int b4 = UInt.b(i4 * b2);
            int b5 = UInt.b(UInt.b(b3) + b4);
            if (Integer.compare(b5 ^ Integer.MIN_VALUE, b4 ^ Integer.MIN_VALUE) < 0) {
                return null;
            }
            i3++;
            i4 = b5;
        }
        return UInt.a(i4);
    }

    public static final long g(String str) {
        Intrinsics.f(str, "<this>");
        ULong h2 = h(str);
        if (h2 != null) {
            return h2.f();
        }
        StringsKt__StringNumberConversionsKt.j(str);
        throw new KotlinNothingValueException();
    }

    public static final ULong h(String str) {
        Intrinsics.f(str, "<this>");
        return i(str, 10);
    }

    public static final ULong i(String str, int i2) {
        String str2 = str;
        int i3 = i2;
        Intrinsics.f(str2, "<this>");
        int unused = CharsKt__CharJVMKt.a(i2);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i4 = 0;
        char charAt = str2.charAt(0);
        if (Intrinsics.h(charAt, 48) < 0) {
            i4 = 1;
            if (length == 1 || charAt != '+') {
                return null;
            }
        }
        long b2 = ULong.b((long) i3);
        long j2 = 0;
        long j3 = 512409557603043100L;
        while (i4 < length) {
            int b3 = CharsKt__CharJVMKt.b(str2.charAt(i4), i3);
            if (b3 < 0) {
                return null;
            }
            if (Long.compare(j2 ^ Long.MIN_VALUE, j3 ^ Long.MIN_VALUE) > 0) {
                if (j3 == 512409557603043100L) {
                    j3 = c.a(-1, b2);
                    if (Long.compare(j2 ^ Long.MIN_VALUE, j3 ^ Long.MIN_VALUE) > 0) {
                    }
                }
                return null;
            }
            long b4 = ULong.b(j2 * b2);
            long b5 = ULong.b(ULong.b(((long) UInt.b(b3)) & 4294967295L) + b4);
            if (Long.compare(b5 ^ Long.MIN_VALUE, b4 ^ Long.MIN_VALUE) < 0) {
                return null;
            }
            i4++;
            j2 = b5;
        }
        return ULong.a(j2);
    }

    public static final short j(String str) {
        Intrinsics.f(str, "<this>");
        UShort k2 = k(str);
        if (k2 != null) {
            return k2.f();
        }
        StringsKt__StringNumberConversionsKt.j(str);
        throw new KotlinNothingValueException();
    }

    public static final UShort k(String str) {
        Intrinsics.f(str, "<this>");
        return l(str, 10);
    }

    public static final UShort l(String str, int i2) {
        Intrinsics.f(str, "<this>");
        UInt f2 = f(str, i2);
        if (f2 == null) {
            return null;
        }
        int f3 = f2.f();
        if (Integer.compare(f3 ^ Integer.MIN_VALUE, UInt.b(65535) ^ Integer.MIN_VALUE) > 0) {
            return null;
        }
        return UShort.a(UShort.b((short) f3));
    }
}
