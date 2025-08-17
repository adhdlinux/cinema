package com.vungle.ads.internal.util;

import android.webkit.URLUtil;

public final class Utils {
    public static final Utils INSTANCE = new Utils();

    private Utils() {
    }

    public final boolean isUrlValid(String str) {
        if (!(str == null || str.length() == 0)) {
            return URLUtil.isHttpsUrl(str) || URLUtil.isHttpUrl(str);
        }
        return false;
    }
}
