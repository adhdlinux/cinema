package androidx.core.os;

import android.os.Build;
import android.os.LocaleList;
import androidx.core.text.ICUCompat;
import java.util.Locale;

public final class LocaleListCompat {

    /* renamed from: b  reason: collision with root package name */
    private static final LocaleListCompat f2615b = a(new Locale[0]);

    /* renamed from: a  reason: collision with root package name */
    private final LocaleListInterface f2616a;

    static class Api21Impl {

        /* renamed from: a  reason: collision with root package name */
        private static final Locale[] f2617a = {new Locale("en", "XA"), new Locale("ar", "XB")};

        private Api21Impl() {
        }

        static Locale a(String str) {
            return Locale.forLanguageTag(str);
        }

        private static boolean b(Locale locale) {
            for (Locale equals : f2617a) {
                if (equals.equals(locale)) {
                    return true;
                }
            }
            return false;
        }

        static boolean c(Locale locale, Locale locale2) {
            if (locale.equals(locale2)) {
                return true;
            }
            if (!locale.getLanguage().equals(locale2.getLanguage()) || b(locale) || b(locale2)) {
                return false;
            }
            String a2 = ICUCompat.a(locale);
            if (!a2.isEmpty()) {
                return a2.equals(ICUCompat.a(locale2));
            }
            String country = locale.getCountry();
            if (country.isEmpty() || country.equals(locale2.getCountry())) {
                return true;
            }
            return false;
        }
    }

    static class Api24Impl {
        private Api24Impl() {
        }

        static LocaleList a(Locale... localeArr) {
            return new LocaleList(localeArr);
        }

        static LocaleList b() {
            return LocaleList.getAdjustedDefault();
        }

        static LocaleList c() {
            return LocaleList.getDefault();
        }
    }

    private LocaleListCompat(LocaleListInterface localeListInterface) {
        this.f2616a = localeListInterface;
    }

    public static LocaleListCompat a(Locale... localeArr) {
        if (Build.VERSION.SDK_INT >= 24) {
            return i(Api24Impl.a(localeArr));
        }
        return new LocaleListCompat(new LocaleListCompatWrapper(localeArr));
    }

    static Locale b(String str) {
        if (str.contains("-")) {
            String[] split = str.split("-", -1);
            if (split.length > 2) {
                return new Locale(split[0], split[1], split[2]);
            }
            if (split.length > 1) {
                return new Locale(split[0], split[1]);
            }
            if (split.length == 1) {
                return new Locale(split[0]);
            }
        } else if (!str.contains("_")) {
            return new Locale(str);
        } else {
            String[] split2 = str.split("_", -1);
            if (split2.length > 2) {
                return new Locale(split2[0], split2[1], split2[2]);
            }
            if (split2.length > 1) {
                return new Locale(split2[0], split2[1]);
            }
            if (split2.length == 1) {
                return new Locale(split2[0]);
            }
        }
        throw new IllegalArgumentException("Can not parse language tag: [" + str + "]");
    }

    public static LocaleListCompat c(String str) {
        if (str == null || str.isEmpty()) {
            return e();
        }
        String[] split = str.split(",", -1);
        int length = split.length;
        Locale[] localeArr = new Locale[length];
        for (int i2 = 0; i2 < length; i2++) {
            localeArr[i2] = Api21Impl.a(split[i2]);
        }
        return a(localeArr);
    }

    public static LocaleListCompat e() {
        return f2615b;
    }

    public static LocaleListCompat i(LocaleList localeList) {
        return new LocaleListCompat(new LocaleListPlatformWrapper(localeList));
    }

    public Locale d(int i2) {
        return this.f2616a.get(i2);
    }

    public boolean equals(Object obj) {
        return (obj instanceof LocaleListCompat) && this.f2616a.equals(((LocaleListCompat) obj).f2616a);
    }

    public boolean f() {
        return this.f2616a.isEmpty();
    }

    public int g() {
        return this.f2616a.size();
    }

    public String h() {
        return this.f2616a.a();
    }

    public int hashCode() {
        return this.f2616a.hashCode();
    }

    public String toString() {
        return this.f2616a.toString();
    }
}
