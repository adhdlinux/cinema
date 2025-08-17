package org.threeten.bp.jdk8;

public final class Jdk8Methods {
    private Jdk8Methods() {
    }

    public static int compareInts(int i2, int i3) {
        if (i2 < i3) {
            return -1;
        }
        return i2 > i3 ? 1 : 0;
    }

    public static int compareLongs(long j2, long j3) {
        int i2 = (j2 > j3 ? 1 : (j2 == j3 ? 0 : -1));
        if (i2 < 0) {
            return -1;
        }
        return i2 > 0 ? 1 : 0;
    }

    public static boolean equals(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        if (obj2 == null) {
            return false;
        }
        return obj.equals(obj2);
    }

    public static long floorDiv(long j2, long j3) {
        return j2 >= 0 ? j2 / j3 : ((j2 + 1) / j3) - 1;
    }

    public static long floorMod(long j2, long j3) {
        return ((j2 % j3) + j3) % j3;
    }

    public static <T> T requireNonNull(T t2) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException("Value must not be null");
    }

    public static int safeAdd(int i2, int i3) {
        int i4 = i2 + i3;
        if ((i2 ^ i4) >= 0 || (i2 ^ i3) < 0) {
            return i4;
        }
        throw new ArithmeticException("Addition overflows an int: " + i2 + " + " + i3);
    }

    public static int safeMultiply(int i2, int i3) {
        long j2 = ((long) i2) * ((long) i3);
        if (j2 >= -2147483648L && j2 <= 2147483647L) {
            return (int) j2;
        }
        throw new ArithmeticException("Multiplication overflows an int: " + i2 + " * " + i3);
    }

    public static int safeSubtract(int i2, int i3) {
        int i4 = i2 - i3;
        if ((i2 ^ i4) >= 0 || (i2 ^ i3) >= 0) {
            return i4;
        }
        throw new ArithmeticException("Subtraction overflows an int: " + i2 + " - " + i3);
    }

    public static int safeToInt(long j2) {
        if (j2 <= 2147483647L && j2 >= -2147483648L) {
            return (int) j2;
        }
        throw new ArithmeticException("Calculation overflows an int: " + j2);
    }

    public static int floorDiv(int i2, int i3) {
        return i2 >= 0 ? i2 / i3 : ((i2 + 1) / i3) - 1;
    }

    public static int floorMod(long j2, int i2) {
        long j3 = (long) i2;
        return (int) (((j2 % j3) + j3) % j3);
    }

    public static <T> T requireNonNull(T t2, String str) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(str + " must not be null");
    }

    public static long safeAdd(long j2, long j3) {
        long j4 = j2 + j3;
        if ((j2 ^ j4) >= 0 || (j2 ^ j3) < 0) {
            return j4;
        }
        throw new ArithmeticException("Addition overflows a long: " + j2 + " + " + j3);
    }

    public static long safeMultiply(long j2, int i2) {
        if (i2 != -1) {
            if (i2 == 0) {
                return 0;
            }
            if (i2 == 1) {
                return j2;
            }
            long j3 = (long) i2;
            long j4 = j2 * j3;
            if (j4 / j3 == j2) {
                return j4;
            }
            throw new ArithmeticException("Multiplication overflows a long: " + j2 + " * " + i2);
        } else if (j2 != Long.MIN_VALUE) {
            return -j2;
        } else {
            throw new ArithmeticException("Multiplication overflows a long: " + j2 + " * " + i2);
        }
    }

    public static long safeSubtract(long j2, long j3) {
        long j4 = j2 - j3;
        if ((j2 ^ j4) >= 0 || (j2 ^ j3) >= 0) {
            return j4;
        }
        throw new ArithmeticException("Subtraction overflows a long: " + j2 + " - " + j3);
    }

    public static int floorMod(int i2, int i3) {
        return ((i2 % i3) + i3) % i3;
    }

    public static long safeMultiply(long j2, long j3) {
        if (j3 == 1) {
            return j2;
        }
        if (j2 == 1) {
            return j3;
        }
        if (j2 == 0 || j3 == 0) {
            return 0;
        }
        long j4 = j2 * j3;
        if (j4 / j3 == j2 && ((j2 != Long.MIN_VALUE || j3 != -1) && (j3 != Long.MIN_VALUE || j2 != -1))) {
            return j4;
        }
        throw new ArithmeticException("Multiplication overflows a long: " + j2 + " * " + j3);
    }
}
