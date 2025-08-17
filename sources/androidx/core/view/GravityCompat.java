package androidx.core.view;

import android.graphics.Rect;
import android.view.Gravity;

public final class GravityCompat {

    static class Api17Impl {
        private Api17Impl() {
        }

        static void a(int i2, int i3, int i4, Rect rect, int i5, int i6, Rect rect2, int i7) {
            Gravity.apply(i2, i3, i4, rect, i5, i6, rect2, i7);
        }

        static void b(int i2, int i3, int i4, Rect rect, Rect rect2, int i5) {
            Gravity.apply(i2, i3, i4, rect, rect2, i5);
        }

        static void c(int i2, Rect rect, Rect rect2, int i3) {
            Gravity.applyDisplay(i2, rect, rect2, i3);
        }
    }

    private GravityCompat() {
    }

    public static void a(int i2, int i3, int i4, Rect rect, Rect rect2, int i5) {
        Api17Impl.b(i2, i3, i4, rect, rect2, i5);
    }

    public static int b(int i2, int i3) {
        return Gravity.getAbsoluteGravity(i2, i3);
    }
}
