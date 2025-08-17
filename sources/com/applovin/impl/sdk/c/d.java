package com.applovin.impl.sdk.c;

import java.util.HashSet;

public class d<T> {
    public static final d<String> A;
    public static final d<String> B;
    public static final d<Boolean> C;

    /* renamed from: a  reason: collision with root package name */
    public static final d<String> f15215a;

    /* renamed from: b  reason: collision with root package name */
    public static final d<Boolean> f15216b;

    /* renamed from: c  reason: collision with root package name */
    public static final d<String> f15217c;

    /* renamed from: d  reason: collision with root package name */
    public static final d<Long> f15218d = new d<>("com.applovin.sdk.install_date", Long.class);

    /* renamed from: e  reason: collision with root package name */
    public static final d<String> f15219e;

    /* renamed from: f  reason: collision with root package name */
    public static final d<String> f15220f;

    /* renamed from: g  reason: collision with root package name */
    public static final d<String> f15221g;

    /* renamed from: h  reason: collision with root package name */
    public static final d<String> f15222h;

    /* renamed from: i  reason: collision with root package name */
    public static final d<String> f15223i;

    /* renamed from: j  reason: collision with root package name */
    public static final d<String> f15224j;

    /* renamed from: k  reason: collision with root package name */
    public static final d<Boolean> f15225k;

    /* renamed from: l  reason: collision with root package name */
    public static final d<Boolean> f15226l;

    /* renamed from: m  reason: collision with root package name */
    public static final d<Boolean> f15227m;

    /* renamed from: n  reason: collision with root package name */
    public static final d<String> f15228n;

    /* renamed from: o  reason: collision with root package name */
    public static final d<?> f15229o = new d<>("IABTCF_gdprApplies", Object.class);

    /* renamed from: p  reason: collision with root package name */
    public static final d<HashSet> f15230p;

    /* renamed from: q  reason: collision with root package name */
    public static final d<String> f15231q;

    /* renamed from: r  reason: collision with root package name */
    public static final d<HashSet> f15232r;

    /* renamed from: s  reason: collision with root package name */
    public static final d<String> f15233s;

    /* renamed from: t  reason: collision with root package name */
    public static final d<String> f15234t;

    /* renamed from: u  reason: collision with root package name */
    public static final d<HashSet> f15235u;

    /* renamed from: v  reason: collision with root package name */
    public static final d<Integer> f15236v = new d<>("com.applovin.sdk.last_video_position", Integer.class);

    /* renamed from: w  reason: collision with root package name */
    public static final d<Boolean> f15237w;

    /* renamed from: x  reason: collision with root package name */
    public static final d<String> f15238x;

    /* renamed from: y  reason: collision with root package name */
    public static final d<String> f15239y;

    /* renamed from: z  reason: collision with root package name */
    public static final d<String> f15240z;
    private final String D;
    private final Class<T> E;

    static {
        Class<String> cls = String.class;
        f15215a = new d<>("com.applovin.sdk.impl.isFirstRun", cls);
        Class<Boolean> cls2 = Boolean.class;
        f15216b = new d<>("com.applovin.sdk.launched_before", cls2);
        f15217c = new d<>("com.applovin.sdk.latest_installed_version", cls);
        f15219e = new d<>("com.applovin.sdk.user_id", cls);
        f15220f = new d<>("com.applovin.sdk.compass_id", cls);
        f15221g = new d<>("com.applovin.sdk.compass_random_token", cls);
        f15222h = new d<>("com.applovin.sdk.applovin_random_token", cls);
        f15223i = new d<>("com.applovin.sdk.device_test_group", cls);
        f15224j = new d<>("com.applovin.sdk.variables", cls);
        f15225k = new d<>("com.applovin.sdk.compliance.has_user_consent", cls2);
        f15226l = new d<>("com.applovin.sdk.compliance.is_age_restricted_user", cls2);
        f15227m = new d<>("com.applovin.sdk.compliance.is_do_not_sell", cls2);
        f15228n = new d<>("IABTCF_TCString", cls);
        Class<HashSet> cls3 = HashSet.class;
        f15230p = new d<>("com.applovin.sdk.impl.postbackQueue.key", cls3);
        f15231q = new d<>("com.applovin.sdk.stats", cls);
        f15232r = new d<>("com.applovin.sdk.task.stats", cls3);
        f15233s = new d<>("com.applovin.sdk.network_response_code_mapping", cls);
        f15234t = new d<>("com.applovin.sdk.event_tracking.super_properties", cls);
        f15235u = new d<>("com.applovin.sdk.ad.stats", cls3);
        f15237w = new d<>("com.applovin.sdk.should_resume_video", cls2);
        f15238x = new d<>("com.applovin.sdk.mediation.signal_providers", cls);
        f15239y = new d<>("com.applovin.sdk.mediation.auto_init_adapters", cls);
        f15240z = new d<>("com.applovin.sdk.persisted_data", cls);
        A = new d<>("com.applovin.sdk.mediation_provider", cls);
        B = new d<>("com.applovin.sdk.mediation.test_mode_network", cls);
        C = new d<>("com.applovin.sdk.mediation.test_mode_enabled", cls2);
    }

    public d(String str, Class<T> cls) {
        this.D = str;
        this.E = cls;
    }

    public String a() {
        return this.D;
    }

    public Class<T> b() {
        return this.E;
    }

    public String toString() {
        return "Key{name='" + this.D + '\'' + ", type=" + this.E + '}';
    }
}
