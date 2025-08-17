package com.applovin.impl.sdk.utils;

import android.os.Bundle;
import android.text.TextUtils;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.c.d;
import com.applovin.impl.sdk.c.e;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.v;

public final class p {

    /* renamed from: a  reason: collision with root package name */
    private final m f15912a;

    /* renamed from: b  reason: collision with root package name */
    private String f15913b;

    /* renamed from: c  reason: collision with root package name */
    private final String f15914c;

    /* renamed from: d  reason: collision with root package name */
    private final String f15915d;

    public p(m mVar) {
        this.f15912a = mVar;
        this.f15914c = a(d.f15221g, (String) e.b(d.f15220f, null, mVar.L()));
        this.f15915d = a(d.f15222h, (String) mVar.a(b.X));
        a(d());
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [com.applovin.impl.sdk.c.d, com.applovin.impl.sdk.c.d<java.lang.String>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String a(com.applovin.impl.sdk.c.d<java.lang.String> r3, java.lang.String r4) {
        /*
            r2 = this;
            com.applovin.impl.sdk.m r0 = r2.f15912a
            android.content.Context r0 = r0.L()
            r1 = 0
            java.lang.Object r0 = com.applovin.impl.sdk.c.e.b(r3, r1, (android.content.Context) r0)
            java.lang.String r0 = (java.lang.String) r0
            boolean r1 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r0)
            if (r1 == 0) goto L_0x0014
            return r0
        L_0x0014:
            boolean r0 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r4)
            if (r0 == 0) goto L_0x001b
            goto L_0x0029
        L_0x001b:
            java.util.UUID r4 = java.util.UUID.randomUUID()
            java.lang.String r4 = r4.toString()
            java.util.Locale r0 = java.util.Locale.US
            java.lang.String r4 = r4.toLowerCase(r0)
        L_0x0029:
            com.applovin.impl.sdk.m r0 = r2.f15912a
            android.content.Context r0 = r0.L()
            com.applovin.impl.sdk.c.e.a(r3, r4, (android.content.Context) r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.utils.p.a(com.applovin.impl.sdk.c.d, java.lang.String):java.lang.String");
    }

    public static String a(m mVar) {
        d dVar = d.f15223i;
        String str = (String) mVar.a(dVar);
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String valueOf = String.valueOf(((int) (Math.random() * 100.0d)) + 1);
        mVar.a(dVar, valueOf);
        return valueOf;
    }

    private String d() {
        if (!((Boolean) this.f15912a.a(b.dy)).booleanValue()) {
            this.f15912a.b(d.f15219e);
        }
        String str = (String) this.f15912a.a(d.f15219e);
        if (!StringUtils.isValidString(str)) {
            return null;
        }
        if (v.a()) {
            v A = this.f15912a.A();
            A.b("AppLovinSdk", "Using identifier (" + str + ") from previous session");
        }
        return str;
    }

    public String a() {
        return this.f15913b;
    }

    public void a(String str) {
        if (((Boolean) this.f15912a.a(b.dy)).booleanValue()) {
            this.f15912a.a(d.f15219e, str);
        }
        this.f15913b = str;
        Bundle bundle = new Bundle(2);
        bundle.putString("user_id", StringUtils.emptyIfNull(str));
        bundle.putString("applovin_random_token", c());
        this.f15912a.ag().a(bundle, "user_info");
    }

    public String b() {
        return this.f15914c;
    }

    public String c() {
        return this.f15915d;
    }
}
