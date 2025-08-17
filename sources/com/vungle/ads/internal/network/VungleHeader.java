package com.vungle.ads.internal.network;

import android.os.Build;
import kotlin.jvm.internal.Intrinsics;

public final class VungleHeader {
    public static final VungleHeader INSTANCE;
    private static String headerUa;

    static {
        VungleHeader vungleHeader = new VungleHeader();
        INSTANCE = vungleHeader;
        headerUa = vungleHeader.defaultHeader();
    }

    private VungleHeader() {
    }

    private final String defaultHeader() {
        StringBuilder sb = new StringBuilder();
        sb.append(Intrinsics.a("Amazon", Build.MANUFACTURER) ? "VungleAmazon/" : "VungleDroid/");
        sb.append("7.4.3");
        return sb.toString();
    }

    public final String getHeaderUa() {
        return headerUa;
    }

    public final void reset() {
        headerUa = defaultHeader();
    }

    public final void setHeaderUa(String str) {
        Intrinsics.f(str, "<set-?>");
        headerUa = str;
    }
}
