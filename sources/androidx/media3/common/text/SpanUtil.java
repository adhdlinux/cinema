package androidx.media3.common.text;

import android.text.Spannable;
import android.text.style.RelativeSizeSpan;

public final class SpanUtil {
    private SpanUtil() {
    }

    public static void a(Spannable spannable, float f2, int i2, int i3, int i4) {
        for (RelativeSizeSpan relativeSizeSpan : (RelativeSizeSpan[]) spannable.getSpans(i2, i3, RelativeSizeSpan.class)) {
            if (spannable.getSpanStart(relativeSizeSpan) <= i2 && spannable.getSpanEnd(relativeSizeSpan) >= i3) {
                f2 *= relativeSizeSpan.getSizeChange();
            }
            c(spannable, relativeSizeSpan, i2, i3, i4);
        }
        spannable.setSpan(new RelativeSizeSpan(f2), i2, i3, i4);
    }

    public static void b(Spannable spannable, Object obj, int i2, int i3, int i4) {
        for (Object c2 : spannable.getSpans(i2, i3, obj.getClass())) {
            c(spannable, c2, i2, i3, i4);
        }
        spannable.setSpan(obj, i2, i3, i4);
    }

    private static void c(Spannable spannable, Object obj, int i2, int i3, int i4) {
        if (spannable.getSpanStart(obj) == i2 && spannable.getSpanEnd(obj) == i3 && spannable.getSpanFlags(obj) == i4) {
            spannable.removeSpan(obj);
        }
    }
}
