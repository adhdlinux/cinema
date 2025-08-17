package com.facebook.ads.internal.o;

import com.facebook.ads.internal.h.c;

class f {

    /* renamed from: a  reason: collision with root package name */
    private final a f20435a;

    /* renamed from: b  reason: collision with root package name */
    private final c f20436b;

    /* renamed from: c  reason: collision with root package name */
    private final String f20437c;

    /* renamed from: d  reason: collision with root package name */
    private final String f20438d;

    /* renamed from: e  reason: collision with root package name */
    private final String f20439e;

    enum a {
        UNKNOWN,
        ERROR,
        ADS
    }

    f(a aVar) {
        this(aVar, (c) null, (String) null, (String) null, (String) null);
    }

    f(a aVar, c cVar, String str, String str2, String str3) {
        this.f20435a = aVar;
        this.f20436b = cVar;
        this.f20437c = str;
        this.f20438d = str2;
        this.f20439e = str3;
    }

    public c a() {
        return this.f20436b;
    }

    /* access modifiers changed from: package-private */
    public a b() {
        return this.f20435a;
    }

    /* access modifiers changed from: package-private */
    public String c() {
        return this.f20437c;
    }

    /* access modifiers changed from: package-private */
    public String d() {
        return this.f20438d;
    }

    /* access modifiers changed from: package-private */
    public String e() {
        return this.f20439e;
    }
}
