package kotlin.text;

import kotlin.ranges.IntRange;

class CharsKt__CharKt extends CharsKt__CharJVMKt {
    public static char d(int i2) {
        if (new IntRange(0, 9).contains(i2)) {
            return (char) (i2 + 48);
        }
        throw new IllegalArgumentException("Int " + i2 + " is not a decimal digit");
    }

    public static final boolean e(char c2, char c3, boolean z2) {
        if (c2 == c3) {
            return true;
        }
        if (!z2) {
            return false;
        }
        char upperCase = Character.toUpperCase(c2);
        char upperCase2 = Character.toUpperCase(c3);
        if (upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2)) {
            return true;
        }
        return false;
    }

    public static String f(char c2) {
        return _OneToManyTitlecaseMappingsKt.a(c2);
    }
}
