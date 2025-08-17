package androidx.emoji2.text;

import android.os.Build;
import android.text.TextPaint;
import androidx.core.graphics.PaintCompat;
import androidx.emoji2.text.EmojiCompat;

class DefaultGlyphChecker implements EmojiCompat.GlyphChecker {

    /* renamed from: b  reason: collision with root package name */
    private static final ThreadLocal<StringBuilder> f3045b = new ThreadLocal<>();

    /* renamed from: a  reason: collision with root package name */
    private final TextPaint f3046a;

    DefaultGlyphChecker() {
        TextPaint textPaint = new TextPaint();
        this.f3046a = textPaint;
        textPaint.setTextSize(10.0f);
    }

    private static StringBuilder b() {
        ThreadLocal<StringBuilder> threadLocal = f3045b;
        if (threadLocal.get() == null) {
            threadLocal.set(new StringBuilder());
        }
        return threadLocal.get();
    }

    public boolean a(CharSequence charSequence, int i2, int i3, int i4) {
        int i5 = Build.VERSION.SDK_INT;
        if (i5 < 23 && i4 > i5) {
            return false;
        }
        StringBuilder b2 = b();
        b2.setLength(0);
        while (i2 < i3) {
            b2.append(charSequence.charAt(i2));
            i2++;
        }
        return PaintCompat.a(this.f3046a, b2.toString());
    }
}
