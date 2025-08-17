package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CheckedTextView;

public final class CheckedTextViewCompat {

    private static class Api16Impl {
        private Api16Impl() {
        }

        static Drawable a(CheckedTextView checkedTextView) {
            return checkedTextView.getCheckMarkDrawable();
        }
    }

    private static class Api21Impl {
        private Api21Impl() {
        }

        static void a(CheckedTextView checkedTextView, ColorStateList colorStateList) {
            checkedTextView.setCheckMarkTintList(colorStateList);
        }

        static void b(CheckedTextView checkedTextView, PorterDuff.Mode mode) {
            checkedTextView.setCheckMarkTintMode(mode);
        }
    }

    private CheckedTextViewCompat() {
    }

    public static Drawable a(CheckedTextView checkedTextView) {
        return Api16Impl.a(checkedTextView);
    }

    public static void b(CheckedTextView checkedTextView, ColorStateList colorStateList) {
        Api21Impl.a(checkedTextView, colorStateList);
    }

    public static void c(CheckedTextView checkedTextView, PorterDuff.Mode mode) {
        Api21Impl.b(checkedTextView, mode);
    }
}
