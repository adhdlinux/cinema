package com.facebook.common.internal;

public final class Preconditions {
    private Preconditions() {
    }

    private static String badElementIndex(int i2, int i3, String str) {
        if (i2 < 0) {
            return format("%s (%s) must not be negative", str, Integer.valueOf(i2));
        } else if (i3 >= 0) {
            return format("%s (%s) must be less than size (%s)", str, Integer.valueOf(i2), Integer.valueOf(i3));
        } else {
            throw new IllegalArgumentException("negative size: " + i3);
        }
    }

    private static String badPositionIndex(int i2, int i3, String str) {
        if (i2 < 0) {
            return format("%s (%s) must not be negative", str, Integer.valueOf(i2));
        } else if (i3 >= 0) {
            return format("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i2), Integer.valueOf(i3));
        } else {
            throw new IllegalArgumentException("negative size: " + i3);
        }
    }

    private static String badPositionIndexes(int i2, int i3, int i4) {
        if (i2 < 0 || i2 > i4) {
            return badPositionIndex(i2, i4, "start index");
        }
        if (i3 < 0 || i3 > i4) {
            return badPositionIndex(i3, i4, "end index");
        }
        return format("end index (%s) must not be less than start index (%s)", Integer.valueOf(i3), Integer.valueOf(i2));
    }

    public static void checkArgument(Boolean bool) {
        if (bool != null && !bool.booleanValue()) {
            throw new IllegalArgumentException();
        }
    }

    public static int checkElementIndex(int i2, int i3) {
        return checkElementIndex(i2, i3, "index");
    }

    public static <T> T checkNotNull(T t2) {
        t2.getClass();
        return t2;
    }

    public static int checkPositionIndex(int i2, int i3) {
        return checkPositionIndex(i2, i3, "index");
    }

    public static void checkPositionIndexes(int i2, int i3, int i4) {
        if (i2 < 0 || i3 < i2 || i3 > i4) {
            throw new IndexOutOfBoundsException(badPositionIndexes(i2, i3, i4));
        }
    }

    public static void checkState(boolean z2) {
        if (!z2) {
            throw new IllegalStateException();
        }
    }

    static String format(String str, Object... objArr) {
        int indexOf;
        String valueOf = String.valueOf(str);
        StringBuilder sb = new StringBuilder(valueOf.length() + (objArr.length * 16));
        int i2 = 0;
        int i3 = 0;
        while (i2 < objArr.length && (indexOf = valueOf.indexOf("%s", i3)) != -1) {
            sb.append(valueOf.substring(i3, indexOf));
            sb.append(objArr[i2]);
            int i4 = i2 + 1;
            i3 = indexOf + 2;
            i2 = i4;
        }
        sb.append(valueOf.substring(i3));
        if (i2 < objArr.length) {
            sb.append(" [");
            sb.append(objArr[i2]);
            for (int i5 = i2 + 1; i5 < objArr.length; i5++) {
                sb.append(", ");
                sb.append(objArr[i5]);
            }
            sb.append(']');
        }
        return sb.toString();
    }

    public static int checkElementIndex(int i2, int i3, String str) {
        if (i2 >= 0 && i2 < i3) {
            return i2;
        }
        throw new IndexOutOfBoundsException(badElementIndex(i2, i3, str));
    }

    public static <T> T checkNotNull(T t2, Object obj) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static int checkPositionIndex(int i2, int i3, String str) {
        if (i2 >= 0 && i2 <= i3) {
            return i2;
        }
        throw new IndexOutOfBoundsException(badPositionIndex(i2, i3, str));
    }

    public static void checkState(boolean z2, Object obj) {
        if (!z2) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void checkArgument(boolean z2, Object obj) {
        if (!z2) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static <T> T checkNotNull(T t2, String str, Object... objArr) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(format(str, objArr));
    }

    public static void checkState(boolean z2, String str, Object... objArr) {
        if (!z2) {
            throw new IllegalStateException(format(str, objArr));
        }
    }

    public static void checkArgument(boolean z2, String str, Object... objArr) {
        if (!z2) {
            throw new IllegalArgumentException(format(str, objArr));
        }
    }
}
