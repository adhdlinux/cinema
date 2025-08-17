package com.vungle.ads.internal.locale;

import java.util.Locale;
import java.util.TimeZone;
import kotlin.jvm.internal.Intrinsics;

public final class SystemLocaleInfo implements LocaleInfo {
    public String getLanguage() {
        String language = Locale.getDefault().getLanguage();
        Intrinsics.e(language, "getDefault().language");
        return language;
    }

    public String getTimeZoneId() {
        String id = TimeZone.getDefault().getID();
        Intrinsics.e(id, "getDefault().id");
        return id;
    }
}
