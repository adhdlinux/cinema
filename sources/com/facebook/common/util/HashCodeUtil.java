package com.facebook.common.util;

import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public class HashCodeUtil {
    private static final int X = 31;

    public static int hashCode(int i2) {
        return i2 + 31;
    }

    public static int hashCode(int i2, int i3) {
        return ((i2 + 31) * 31) + i3;
    }

    public static int hashCode(int i2, int i3, int i4) {
        return ((((i2 + 31) * 31) + i3) * 31) + i4;
    }

    public static int hashCode(int i2, int i3, int i4, int i5) {
        return ((((((i2 + 31) * 31) + i3) * 31) + i4) * 31) + i5;
    }

    public static int hashCode(int i2, int i3, int i4, int i5, int i6) {
        return ((((((((i2 + 31) * 31) + i3) * 31) + i4) * 31) + i5) * 31) + i6;
    }

    public static int hashCode(int i2, int i3, int i4, int i5, int i6, int i7) {
        return ((((((((((i2 + 31) * 31) + i3) * 31) + i4) * 31) + i5) * 31) + i6) * 31) + i7;
    }

    public static int hashCode(Object obj) {
        return hashCode(obj == null ? 0 : obj.hashCode());
    }

    public static int hashCode(Object obj, Object obj2) {
        int i2 = 0;
        int hashCode = obj == null ? 0 : obj.hashCode();
        if (obj2 != null) {
            i2 = obj2.hashCode();
        }
        return hashCode(hashCode, i2);
    }

    public static int hashCode(Object obj, Object obj2, Object obj3) {
        int i2;
        int i3 = 0;
        int hashCode = obj == null ? 0 : obj.hashCode();
        if (obj2 == null) {
            i2 = 0;
        } else {
            i2 = obj2.hashCode();
        }
        if (obj3 != null) {
            i3 = obj3.hashCode();
        }
        return hashCode(hashCode, i2, i3);
    }

    public static int hashCode(Object obj, Object obj2, Object obj3, Object obj4) {
        int i2;
        int i3;
        int i4 = 0;
        int hashCode = obj == null ? 0 : obj.hashCode();
        if (obj2 == null) {
            i2 = 0;
        } else {
            i2 = obj2.hashCode();
        }
        if (obj3 == null) {
            i3 = 0;
        } else {
            i3 = obj3.hashCode();
        }
        if (obj4 != null) {
            i4 = obj4.hashCode();
        }
        return hashCode(hashCode, i2, i3, i4);
    }

    public static int hashCode(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        int i2;
        int i3;
        int i4;
        int i5 = 0;
        int hashCode = obj == null ? 0 : obj.hashCode();
        if (obj2 == null) {
            i2 = 0;
        } else {
            i2 = obj2.hashCode();
        }
        if (obj3 == null) {
            i3 = 0;
        } else {
            i3 = obj3.hashCode();
        }
        if (obj4 == null) {
            i4 = 0;
        } else {
            i4 = obj4.hashCode();
        }
        if (obj5 != null) {
            i5 = obj5.hashCode();
        }
        return hashCode(hashCode, i2, i3, i4, i5);
    }

    public static int hashCode(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int hashCode = obj == null ? 0 : obj.hashCode();
        if (obj2 == null) {
            i2 = 0;
        } else {
            i2 = obj2.hashCode();
        }
        if (obj3 == null) {
            i3 = 0;
        } else {
            i3 = obj3.hashCode();
        }
        if (obj4 == null) {
            i4 = 0;
        } else {
            i4 = obj4.hashCode();
        }
        if (obj5 == null) {
            i5 = 0;
        } else {
            i5 = obj5.hashCode();
        }
        if (obj6 == null) {
            i6 = 0;
        } else {
            i6 = obj6.hashCode();
        }
        return hashCode(hashCode, i2, i3, i4, i5, i6);
    }
}
