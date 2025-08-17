package kotlin.collections;

public final class SlidingWindowKt {
    public static final void a(int i2, int i3) {
        boolean z2;
        String str;
        if (i2 <= 0 || i3 <= 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (!z2) {
            if (i2 != i3) {
                str = "Both size " + i2 + " and step " + i3 + " must be greater than zero.";
            } else {
                str = "size " + i2 + " must be greater than zero.";
            }
            throw new IllegalArgumentException(str.toString());
        }
    }
}
