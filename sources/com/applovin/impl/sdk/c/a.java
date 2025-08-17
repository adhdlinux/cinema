package com.applovin.impl.sdk.c;

import java.util.concurrent.TimeUnit;

public class a<T> extends b<T> {
    public static final b<Boolean> A;
    public static final b<Boolean> B;
    public static final b<Boolean> C;
    public static final b<Long> D = b.a("ad_expiration_ms", Long.valueOf(TimeUnit.HOURS.toMillis(4)));
    public static final b<Boolean> E;
    public static final b<Long> F = b.a("fullscreen_ad_displayed_timeout_ms", -1L);
    public static final b<Long> G = b.a("ad_hidden_timeout_ms", -1L);
    public static final b<Boolean> H;
    public static final b<Long> I;
    public static final b<Boolean> J;
    public static final b<Integer> K = b.a("mute_state", 2);
    public static final b<String> L = b.a("saf", "");
    public static final b<String> M = b.a("saui", "");
    public static final b<Integer> N = b.a("mra", -1);
    public static final b<String> O = b.a("mra_af", "INTER,REWARDED,REWARDED_INTER,BANNER,LEADER,MREC");
    public static final b<Boolean> P;
    public static final b<Boolean> Q;
    public static final b<Boolean> R;
    public static final b<Boolean> S;
    public static final b<Boolean> T;
    public static final b<Boolean> U;
    public static final b<Boolean> V;

    /* renamed from: a  reason: collision with root package name */
    public static final b<String> f15179a = b.a("afi", "");

    /* renamed from: b  reason: collision with root package name */
    public static final b<Long> f15180b;

    /* renamed from: c  reason: collision with root package name */
    public static final b<String> f15181c = b.a("mediation_endpoint", "https://ms.applovin.com/");

    /* renamed from: d  reason: collision with root package name */
    public static final b<String> f15182d = b.a("mediation_backup_endpoint", "https://ms.applvn.com/");

    /* renamed from: e  reason: collision with root package name */
    public static final b<Long> f15183e;

    /* renamed from: f  reason: collision with root package name */
    public static final b<Long> f15184f;

    /* renamed from: g  reason: collision with root package name */
    public static final b<Long> f15185g;

    /* renamed from: h  reason: collision with root package name */
    public static final b<Boolean> f15186h;

    /* renamed from: i  reason: collision with root package name */
    public static final b<String> f15187i = b.a("postback_macros", "{\"{MCODE}\":\"mcode\",\"{BCODE}\":\"bcode\",\"{ICODE}\":\"icode\",\"{SCODE}\":\"scode\"}");

    /* renamed from: j  reason: collision with root package name */
    public static final b<Boolean> f15188j;

    /* renamed from: k  reason: collision with root package name */
    public static final b<Long> f15189k;

    /* renamed from: l  reason: collision with root package name */
    public static final b<Long> f15190l;

    /* renamed from: m  reason: collision with root package name */
    public static final b<Long> f15191m;

    /* renamed from: n  reason: collision with root package name */
    public static final b<Long> f15192n;

    /* renamed from: o  reason: collision with root package name */
    public static final b<String> f15193o = b.a("ad_load_failure_refresh_ignore_error_codes", "204");

    /* renamed from: p  reason: collision with root package name */
    public static final b<Long> f15194p = b.a("refresh_ad_on_app_resume_elapsed_threshold_ms", 0L);

    /* renamed from: q  reason: collision with root package name */
    public static final b<Boolean> f15195q;

    /* renamed from: r  reason: collision with root package name */
    public static final b<Boolean> f15196r;

    /* renamed from: s  reason: collision with root package name */
    public static final b<Boolean> f15197s;

    /* renamed from: t  reason: collision with root package name */
    public static final b<Boolean> f15198t;

    /* renamed from: u  reason: collision with root package name */
    public static final b<Boolean> f15199u;

    /* renamed from: v  reason: collision with root package name */
    public static final b<Long> f15200v = b.a("fullscreen_display_delay_ms", 600L);

    /* renamed from: w  reason: collision with root package name */
    public static final b<Boolean> f15201w;

    /* renamed from: x  reason: collision with root package name */
    public static final b<Long> f15202x = b.a("ahdm", 500L);

    /* renamed from: y  reason: collision with root package name */
    public static final b<Long> f15203y = b.a("ad_view_refresh_precache_request_viewability_undesired_flags", 502L);

    /* renamed from: z  reason: collision with root package name */
    public static final b<Boolean> f15204z;

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        f15180b = b.a("afi_ms", Long.valueOf(timeUnit.toMillis(5)));
        f15183e = b.a("fetch_next_ad_retry_delay_ms", Long.valueOf(timeUnit.toMillis(2)));
        f15184f = b.a("fetch_next_ad_timeout_ms", Long.valueOf(timeUnit.toMillis(5)));
        f15185g = b.a("fetch_mediation_debugger_info_timeout_ms", Long.valueOf(timeUnit.toMillis(7)));
        Boolean bool = Boolean.TRUE;
        f15186h = b.a("auto_init_mediation_debugger", bool);
        Boolean bool2 = Boolean.FALSE;
        f15188j = b.a("persistent_mediated_postbacks", bool2);
        f15189k = b.a("max_signal_provider_latency_ms", Long.valueOf(timeUnit.toMillis(30)));
        f15190l = b.a("default_adapter_timeout_ms", Long.valueOf(timeUnit.toMillis(10)));
        f15191m = b.a("ad_refresh_ms", Long.valueOf(timeUnit.toMillis(30)));
        f15192n = b.a("ad_load_failure_refresh_ms", Long.valueOf(timeUnit.toMillis(30)));
        f15195q = b.a("refresh_ad_view_timer_responds_to_background", bool);
        f15196r = b.a("refresh_ad_view_timer_responds_to_store_kit", bool);
        f15197s = b.a("refresh_ad_view_timer_responds_to_window_visibility_changed", bool2);
        f15198t = b.a("avrsponse", bool2);
        f15199u = b.a("allow_pause_auto_refresh_immediately", bool2);
        f15201w = b.a("susaode", bool2);
        f15204z = b.a("ad_view_refresh_precache_request_enabled", bool);
        A = b.a("fullscreen_ads_block_publisher_load_if_another_showing", bool);
        B = b.a("fabsina", bool2);
        C = b.a("fabsiaif", bool2);
        E = b.a("saewib", bool2);
        H = b.a("schedule_ad_hidden_on_ad_dismiss", bool2);
        I = b.a("ad_hidden_on_ad_dismiss_callback_delay_ms", Long.valueOf(timeUnit.toMillis(1)));
        J = b.a("proe", bool2);
        P = b.a("pmp", bool2);
        Q = b.a("sai", bool2);
        R = b.a("init_adapter_for_sc", bool);
        S = b.a("init_adapter_for_al", bool);
        T = b.a("fadiafase", bool);
        U = b.a("fetch_mediated_ad_gzip", bool2);
        V = b.a("max_postback_gzip", bool2);
    }
}
