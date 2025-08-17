package com.applovin.impl.sdk.d;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;

public class b {
    public static final b A = a("wvhec", "WEB_VIEW_HTTP_ERROR_COUNT");
    public static final b B = a("wvrec", "WEB_VIEW_RENDER_ERROR_COUNT");
    public static final b C = a("wvsem", "WEB_VIEW_SSL_ERROR_MESSAGES");
    public static final b D = a("wvruc", "WEB_VIEW_RENDERER_UNRESPONSIVE_COUNT");
    private static final Set<String> G = new HashSet(32);

    /* renamed from: a  reason: collision with root package name */
    public static final b f15257a = a("sas", "AD_SOURCE");

    /* renamed from: b  reason: collision with root package name */
    public static final b f15258b = a("srt", "AD_RENDER_TIME");

    /* renamed from: c  reason: collision with root package name */
    public static final b f15259c = a("sft", "AD_FETCH_TIME");

    /* renamed from: d  reason: collision with root package name */
    public static final b f15260d = a("sfs", "AD_FETCH_SIZE");

    /* renamed from: e  reason: collision with root package name */
    public static final b f15261e = a("sadb", "AD_DOWNLOADED_BYTES");

    /* renamed from: f  reason: collision with root package name */
    public static final b f15262f = a("sacb", "AD_CACHED_BYTES");

    /* renamed from: g  reason: collision with root package name */
    public static final b f15263g = a("stdl", "TIME_TO_DISPLAY_FROM_LOAD");

    /* renamed from: h  reason: collision with root package name */
    public static final b f15264h = a("stdi", "TIME_TO_DISPLAY_FROM_INIT");

    /* renamed from: i  reason: collision with root package name */
    public static final b f15265i = a("snas", "AD_NUMBER_IN_SESSION");

    /* renamed from: j  reason: collision with root package name */
    public static final b f15266j = a("snat", "AD_NUMBER_TOTAL");

    /* renamed from: k  reason: collision with root package name */
    public static final b f15267k = a("stah", "TIME_AD_HIDDEN_FROM_SHOW");

    /* renamed from: l  reason: collision with root package name */
    public static final b f15268l = a("stas", "TIME_TO_SKIP_FROM_SHOW");

    /* renamed from: m  reason: collision with root package name */
    public static final b f15269m = a("stac", "TIME_TO_CLICK_FROM_SHOW");

    /* renamed from: n  reason: collision with root package name */
    public static final b f15270n = a("stbe", "TIME_TO_EXPAND_FROM_SHOW");

    /* renamed from: o  reason: collision with root package name */
    public static final b f15271o = a("stbc", "TIME_TO_CONTRACT_FROM_SHOW");

    /* renamed from: p  reason: collision with root package name */
    public static final b f15272p = a("saan", "AD_SHOWN_WITH_ACTIVE_NETWORK");

    /* renamed from: q  reason: collision with root package name */
    public static final b f15273q = a("suvs", "INTERSTITIAL_USED_VIDEO_STREAM");

    /* renamed from: r  reason: collision with root package name */
    public static final b f15274r = a("sugs", "AD_USED_GRAPHIC_STREAM");

    /* renamed from: s  reason: collision with root package name */
    public static final b f15275s = a("svpv", "INTERSTITIAL_VIDEO_PERCENT_VIEWED");

    /* renamed from: t  reason: collision with root package name */
    public static final b f15276t = a("stpd", "INTERSTITIAL_PAUSED_DURATION");

    /* renamed from: u  reason: collision with root package name */
    public static final b f15277u = a("shsc", "HTML_RESOURCE_CACHE_SUCCESS_COUNT");

    /* renamed from: v  reason: collision with root package name */
    public static final b f15278v = a("shfc", "HTML_RESOURCE_CACHE_FAILURE_COUNT");

    /* renamed from: w  reason: collision with root package name */
    public static final b f15279w = a("schc", "AD_CANCELLED_HTML_CACHING");

    /* renamed from: x  reason: collision with root package name */
    public static final b f15280x = a("smwm", "AD_SHOWN_IN_MULTIWINDOW_MODE");

    /* renamed from: y  reason: collision with root package name */
    public static final b f15281y = a("vssc", "VIDEO_STREAM_STALLED_COUNT");

    /* renamed from: z  reason: collision with root package name */
    public static final b f15282z = a("wvem", "WEB_VIEW_ERROR_MESSAGES");
    private final String E;
    private final String F;

    static {
        a("sisw", "IS_STREAMING_WEBKIT");
        a("surw", "UNABLE_TO_RETRIEVE_WEBKIT_HTML_STRING");
        a("surp", "UNABLE_TO_PERSIST_WEBKIT_HTML_PLACEMENT_REPLACED_STRING");
        a("swhp", "SUCCESSFULLY_PERSISTED_WEBKIT_HTML_STRING");
        a("skr", "STOREKIT_REDIRECTED");
        a("sklf", "STOREKIT_LOAD_FAILURE");
        a("skps", "STOREKIT_PRELOAD_SKIPPED");
    }

    private b(String str, String str2) {
        this.E = str;
        this.F = str2;
    }

    private static b a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            Set<String> set = G;
            if (set.contains(str)) {
                throw new IllegalArgumentException("Key has already been used: " + str);
            } else if (!TextUtils.isEmpty(str2)) {
                set.add(str);
                return new b(str, str2);
            } else {
                throw new IllegalArgumentException("No debug name specified");
            }
        } else {
            throw new IllegalArgumentException("No key name specified");
        }
    }
}
