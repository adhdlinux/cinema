package androidx.core.graphics;

import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import androidx.core.util.Pair;

public final class PaintCompat {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal<Pair<Rect, Rect>> f2546a = new ThreadLocal<>();

    static class Api23Impl {
        private Api23Impl() {
        }

        static boolean a(Paint paint, String str) {
            return paint.hasGlyph(str);
        }
    }

    private PaintCompat() {
    }

    public static boolean a(Paint paint, String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.a(paint, str);
        }
        int length = str.length();
        if (length == 1 && Character.isWhitespace(str.charAt(0))) {
            return true;
        }
        float measureText = paint.measureText("󟿽");
        float measureText2 = paint.measureText("m");
        float measureText3 = paint.measureText(str);
        float f2 = 0.0f;
        if (measureText3 == 0.0f) {
            return false;
        }
        if (str.codePointCount(0, str.length()) > 1) {
            if (measureText3 > measureText2 * 2.0f) {
                return false;
            }
            int i2 = 0;
            while (i2 < length) {
                int charCount = Character.charCount(str.codePointAt(i2)) + i2;
                f2 += paint.measureText(str, i2, charCount);
                i2 = charCount;
            }
            if (measureText3 >= f2) {
                return false;
            }
        }
        if (measureText3 != measureText) {
            return true;
        }
        Pair<Rect, Rect> b2 = b();
        paint.getTextBounds("󟿽", 0, 2, (Rect) b2.f2721a);
        paint.getTextBounds(str, 0, length, (Rect) b2.f2722b);
        return !((Rect) b2.f2721a).equals(b2.f2722b);
    }

    private static Pair<Rect, Rect> b() {
        ThreadLocal<Pair<Rect, Rect>> threadLocal = f2546a;
        Pair<Rect, Rect> pair = threadLocal.get();
        if (pair == null) {
            Pair<Rect, Rect> pair2 = new Pair<>(new Rect(), new Rect());
            threadLocal.set(pair2);
            return pair2;
        }
        ((Rect) pair.f2721a).setEmpty();
        ((Rect) pair.f2722b).setEmpty();
        return pair;
    }
}
