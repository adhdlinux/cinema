package androidx.core.os;

import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;

public final class ConfigurationCompat {

    static class Api24Impl {
        private Api24Impl() {
        }

        static LocaleList a(Configuration configuration) {
            return configuration.getLocales();
        }
    }

    private ConfigurationCompat() {
    }

    public static LocaleListCompat a(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 24) {
            return LocaleListCompat.i(Api24Impl.a(configuration));
        }
        return LocaleListCompat.a(configuration.locale);
    }
}
