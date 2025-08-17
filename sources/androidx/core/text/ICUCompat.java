package androidx.core.text;

import android.icu.util.ULocale;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

public final class ICUCompat {

    /* renamed from: a  reason: collision with root package name */
    private static Method f2694a;

    static class Api21Impl {
        private Api21Impl() {
        }

        static String a(Locale locale) {
            return locale.getScript();
        }
    }

    static class Api24Impl {
        private Api24Impl() {
        }

        static ULocale a(Object obj) {
            return ULocale.addLikelySubtags((ULocale) obj);
        }

        static ULocale b(Locale locale) {
            return ULocale.forLocale(locale);
        }

        static String c(Object obj) {
            return ((ULocale) obj).getScript();
        }
    }

    static {
        if (Build.VERSION.SDK_INT < 24) {
            try {
                f2694a = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", new Class[]{Locale.class});
            } catch (Exception e2) {
                throw new IllegalStateException(e2);
            }
        }
    }

    private ICUCompat() {
    }

    public static String a(Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return Api24Impl.c(Api24Impl.a(Api24Impl.b(locale)));
        }
        try {
            return Api21Impl.a((Locale) f2694a.invoke((Object) null, new Object[]{locale}));
        } catch (InvocationTargetException e2) {
            Log.w("ICUCompat", e2);
            return Api21Impl.a(locale);
        } catch (IllegalAccessException e3) {
            Log.w("ICUCompat", e3);
            return Api21Impl.a(locale);
        }
    }
}
