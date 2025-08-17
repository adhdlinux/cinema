package androidx.core.text;

import android.text.TextUtils;
import java.util.Locale;

public final class TextUtilsCompat {

    /* renamed from: a  reason: collision with root package name */
    private static final Locale f2720a = new Locale("", "");

    static class Api17Impl {
        private Api17Impl() {
        }

        static int a(Locale locale) {
            return TextUtils.getLayoutDirectionFromLocale(locale);
        }
    }

    private TextUtilsCompat() {
    }

    public static int a(Locale locale) {
        return Api17Impl.a(locale);
    }
}
