package androidx.appcompat.app;

import androidx.core.os.LocaleListCompat;
import java.util.LinkedHashSet;
import java.util.Locale;

final class LocaleOverlayHelper {
    private LocaleOverlayHelper() {
    }

    private static LocaleListCompat a(LocaleListCompat localeListCompat, LocaleListCompat localeListCompat2) {
        Locale locale;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (int i2 = 0; i2 < localeListCompat.g() + localeListCompat2.g(); i2++) {
            if (i2 < localeListCompat.g()) {
                locale = localeListCompat.d(i2);
            } else {
                locale = localeListCompat2.d(i2 - localeListCompat.g());
            }
            if (locale != null) {
                linkedHashSet.add(locale);
            }
        }
        return LocaleListCompat.a((Locale[]) linkedHashSet.toArray(new Locale[linkedHashSet.size()]));
    }

    static LocaleListCompat b(LocaleListCompat localeListCompat, LocaleListCompat localeListCompat2) {
        if (localeListCompat == null || localeListCompat.f()) {
            return LocaleListCompat.e();
        }
        return a(localeListCompat, localeListCompat2);
    }
}
