package com.applovin.impl.sdk.d;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;

public class f {

    /* renamed from: a  reason: collision with root package name */
    public static final f f15302a = a("ad_req");

    /* renamed from: b  reason: collision with root package name */
    public static final f f15303b = a("ad_imp");

    /* renamed from: c  reason: collision with root package name */
    public static final f f15304c = a("ad_session_start");

    /* renamed from: d  reason: collision with root package name */
    public static final f f15305d = a("ad_imp_session");

    /* renamed from: e  reason: collision with root package name */
    public static final f f15306e = a("cached_files_expired");

    /* renamed from: f  reason: collision with root package name */
    public static final f f15307f = a("cache_drop_count");

    /* renamed from: g  reason: collision with root package name */
    public static final f f15308g = a("sdk_reset_state_count", true);

    /* renamed from: h  reason: collision with root package name */
    public static final f f15309h = a("ad_response_process_failures", true);

    /* renamed from: i  reason: collision with root package name */
    public static final f f15310i = a("response_process_failures", true);

    /* renamed from: j  reason: collision with root package name */
    public static final f f15311j = a("incent_failed_to_display_count", true);

    /* renamed from: k  reason: collision with root package name */
    public static final f f15312k = a("app_paused_and_resumed");

    /* renamed from: l  reason: collision with root package name */
    public static final f f15313l = a("ad_rendered_with_mismatched_sdk_key", true);

    /* renamed from: m  reason: collision with root package name */
    public static final f f15314m = a("ad_shown_outside_app_count");

    /* renamed from: n  reason: collision with root package name */
    public static final f f15315n = a("med_ad_req");

    /* renamed from: o  reason: collision with root package name */
    public static final f f15316o = a("med_ad_response_process_failures", true);

    /* renamed from: p  reason: collision with root package name */
    public static final f f15317p = a("med_waterfall_ad_no_fill", true);

    /* renamed from: q  reason: collision with root package name */
    public static final f f15318q = a("med_waterfall_ad_adapter_load_failed", true);

    /* renamed from: r  reason: collision with root package name */
    public static final f f15319r = a("med_waterfall_ad_invalid_response", true);

    /* renamed from: s  reason: collision with root package name */
    private static final Set<String> f15320s = new HashSet(32);

    /* renamed from: u  reason: collision with root package name */
    private static final Set<f> f15321u = new HashSet(16);

    /* renamed from: t  reason: collision with root package name */
    private final String f15322t;

    static {
        a("fullscreen_ad_nil_vc_count");
        a("applovin_bundle_missing");
    }

    private f(String str) {
        this.f15322t = str;
    }

    private static f a(String str) {
        return a(str, false);
    }

    private static f a(String str, boolean z2) {
        if (!TextUtils.isEmpty(str)) {
            Set<String> set = f15320s;
            if (!set.contains(str)) {
                set.add(str);
                f fVar = new f(str);
                if (z2) {
                    f15321u.add(fVar);
                }
                return fVar;
            }
            throw new IllegalArgumentException("Key has already been used: " + str);
        }
        throw new IllegalArgumentException("No key name specified");
    }
}
