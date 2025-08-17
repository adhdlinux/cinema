package com.facebook.ads.internal.m;

import android.text.TextUtils;
import com.facebook.ads.internal.q.a.k;
import java.util.HashMap;
import java.util.Map;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final String f20246a;

    /* renamed from: b  reason: collision with root package name */
    private final double f20247b = (((double) System.currentTimeMillis()) / 1000.0d);

    /* renamed from: c  reason: collision with root package name */
    private final double f20248c;

    /* renamed from: d  reason: collision with root package name */
    private final String f20249d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<String, String> f20250e;

    /* renamed from: f  reason: collision with root package name */
    private final e f20251f;

    /* renamed from: g  reason: collision with root package name */
    private final f f20252g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f20253h;

    /* renamed from: com.facebook.ads.internal.m.a$a  reason: collision with other inner class name */
    public static class C0034a {

        /* renamed from: a  reason: collision with root package name */
        private String f20254a;

        /* renamed from: b  reason: collision with root package name */
        private double f20255b;

        /* renamed from: c  reason: collision with root package name */
        private String f20256c;

        /* renamed from: d  reason: collision with root package name */
        private Map<String, String> f20257d;

        /* renamed from: e  reason: collision with root package name */
        private e f20258e;

        /* renamed from: f  reason: collision with root package name */
        private f f20259f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f20260g;

        public C0034a a(double d2) {
            this.f20255b = d2;
            return this;
        }

        public C0034a a(e eVar) {
            this.f20258e = eVar;
            return this;
        }

        public C0034a a(f fVar) {
            this.f20259f = fVar;
            return this;
        }

        public C0034a a(String str) {
            this.f20254a = str;
            return this;
        }

        public C0034a a(Map<String, String> map) {
            this.f20257d = map;
            return this;
        }

        public C0034a a(boolean z2) {
            this.f20260g = z2;
            return this;
        }

        public a a() {
            return new a(this.f20254a, this.f20255b, this.f20256c, this.f20257d, this.f20258e, this.f20259f, this.f20260g);
        }

        public C0034a b(String str) {
            this.f20256c = str;
            return this;
        }
    }

    public a(String str, double d2, String str2, Map<String, String> map, e eVar, f fVar, boolean z2) {
        this.f20246a = str;
        this.f20248c = d2;
        this.f20249d = str2;
        this.f20251f = eVar;
        this.f20252g = fVar;
        this.f20253h = z2;
        HashMap hashMap = new HashMap();
        if (map != null && !map.isEmpty()) {
            hashMap.putAll(map);
        }
        if (f()) {
            hashMap.put("analog", k.a(com.facebook.ads.internal.g.a.a()));
        }
        this.f20250e = a(hashMap);
    }

    private static Map<String, String> a(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            String str = (String) next.getKey();
            String str2 = (String) next.getValue();
            if (str2 != null) {
                hashMap.put(str, str2);
            }
        }
        return hashMap;
    }

    public String a() {
        return this.f20246a;
    }

    public double b() {
        return this.f20247b;
    }

    public double c() {
        return this.f20248c;
    }

    public String d() {
        return this.f20249d;
    }

    public Map<String, String> e() {
        return this.f20250e;
    }

    /* access modifiers changed from: package-private */
    public final boolean f() {
        return this.f20251f == e.IMMEDIATE;
    }

    /* access modifiers changed from: package-private */
    public final boolean g() {
        return !TextUtils.isEmpty(this.f20246a);
    }

    public e h() {
        return this.f20251f;
    }

    public f i() {
        return this.f20252g;
    }
}
