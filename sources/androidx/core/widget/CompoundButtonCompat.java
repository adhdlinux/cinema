package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

public final class CompoundButtonCompat {

    /* renamed from: a  reason: collision with root package name */
    private static Field f2935a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f2936b;

    static class Api21Impl {
        private Api21Impl() {
        }

        static ColorStateList a(CompoundButton compoundButton) {
            return compoundButton.getButtonTintList();
        }

        static PorterDuff.Mode b(CompoundButton compoundButton) {
            return compoundButton.getButtonTintMode();
        }

        static void c(CompoundButton compoundButton, ColorStateList colorStateList) {
            compoundButton.setButtonTintList(colorStateList);
        }

        static void d(CompoundButton compoundButton, PorterDuff.Mode mode) {
            compoundButton.setButtonTintMode(mode);
        }
    }

    static class Api23Impl {
        private Api23Impl() {
        }

        static Drawable a(CompoundButton compoundButton) {
            return compoundButton.getButtonDrawable();
        }
    }

    private CompoundButtonCompat() {
    }

    public static Drawable a(CompoundButton compoundButton) {
        if (Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.a(compoundButton);
        }
        if (!f2936b) {
            try {
                Field declaredField = CompoundButton.class.getDeclaredField("mButtonDrawable");
                f2935a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.i("CompoundButtonCompat", "Failed to retrieve mButtonDrawable field", e2);
            }
            f2936b = true;
        }
        Field field = f2935a;
        if (field != null) {
            try {
                return (Drawable) field.get(compoundButton);
            } catch (IllegalAccessException e3) {
                Log.i("CompoundButtonCompat", "Failed to get button drawable via reflection", e3);
                f2935a = null;
            }
        }
        return null;
    }

    public static void b(CompoundButton compoundButton, ColorStateList colorStateList) {
        Api21Impl.c(compoundButton, colorStateList);
    }

    public static void c(CompoundButton compoundButton, PorterDuff.Mode mode) {
        Api21Impl.d(compoundButton, mode);
    }
}
