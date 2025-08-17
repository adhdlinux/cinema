package androidx.core.os;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.ext.SdkExtensions;
import java.util.Locale;

public class BuildCompat {
    @SuppressLint({"CompileTimeConstant"})

    /* renamed from: a  reason: collision with root package name */
    public static final int f2600a;
    @SuppressLint({"CompileTimeConstant"})

    /* renamed from: b  reason: collision with root package name */
    public static final int f2601b;
    @SuppressLint({"CompileTimeConstant"})

    /* renamed from: c  reason: collision with root package name */
    public static final int f2602c;
    @SuppressLint({"CompileTimeConstant"})

    /* renamed from: d  reason: collision with root package name */
    public static final int f2603d;

    private static final class Extensions30Impl {

        /* renamed from: a  reason: collision with root package name */
        static final int f2604a = SdkExtensions.getExtensionVersion(30);

        /* renamed from: b  reason: collision with root package name */
        static final int f2605b = SdkExtensions.getExtensionVersion(31);

        /* renamed from: c  reason: collision with root package name */
        static final int f2606c = SdkExtensions.getExtensionVersion(33);

        /* renamed from: d  reason: collision with root package name */
        static final int f2607d = SdkExtensions.getExtensionVersion(1000000);

        private Extensions30Impl() {
        }
    }

    static {
        int i2;
        int i3;
        int i4;
        int i5 = Build.VERSION.SDK_INT;
        int i6 = 0;
        if (i5 >= 30) {
            i2 = Extensions30Impl.f2604a;
        } else {
            i2 = 0;
        }
        f2600a = i2;
        if (i5 >= 30) {
            i3 = Extensions30Impl.f2605b;
        } else {
            i3 = 0;
        }
        f2601b = i3;
        if (i5 >= 30) {
            i4 = Extensions30Impl.f2606c;
        } else {
            i4 = 0;
        }
        f2602c = i4;
        if (i5 >= 30) {
            i6 = Extensions30Impl.f2607d;
        }
        f2603d = i6;
    }

    private BuildCompat() {
    }

    protected static boolean a(String str, String str2) {
        if ("REL".equals(str2)) {
            return false;
        }
        Locale locale = Locale.ROOT;
        if (str2.toUpperCase(locale).compareTo(str.toUpperCase(locale)) >= 0) {
            return true;
        }
        return false;
    }

    @Deprecated
    public static boolean b() {
        return Build.VERSION.SDK_INT >= 30;
    }

    @SuppressLint({"RestrictedApi"})
    @Deprecated
    public static boolean c() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 31 || (i2 >= 30 && a("S", Build.VERSION.CODENAME))) {
            return true;
        }
        return false;
    }

    public static boolean d() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 33 || (i2 >= 32 && a("Tiramisu", Build.VERSION.CODENAME))) {
            return true;
        }
        return false;
    }

    public static boolean e() {
        if (Build.VERSION.SDK_INT < 33 || !a("UpsideDownCake", Build.VERSION.CODENAME)) {
            return false;
        }
        return true;
    }
}
