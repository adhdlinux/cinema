package com.chartboost.sdk.impl;

import kotlin.jvm.internal.DefaultConstructorMarker;

public abstract class u {

    /* renamed from: a  reason: collision with root package name */
    public final String f18729a;

    /* renamed from: b  reason: collision with root package name */
    public final String f18730b;

    /* renamed from: c  reason: collision with root package name */
    public final String f18731c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f18732d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f18733e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f18734f;

    public static final class a extends u {

        /* renamed from: g  reason: collision with root package name */
        public static final a f18735g = new a();

        public a() {
            super("Banner", "/auction/sdk/banner", "/banner/show", true, false, 16, (DefaultConstructorMarker) null);
        }
    }

    public static final class b extends u {

        /* renamed from: g  reason: collision with root package name */
        public static final b f18736g = new b();

        public b() {
            super("Interstitial", "webview/%s/interstitial/get", "/interstitial/show", false, false, 24, (DefaultConstructorMarker) null);
        }
    }

    public static final class c extends u {

        /* renamed from: g  reason: collision with root package name */
        public static final c f18737g = new c();

        public c() {
            super("Rewarded", "webview/%s/reward/get", "/reward/show", false, false, 8, (DefaultConstructorMarker) null);
        }
    }

    public /* synthetic */ u(String str, String str2, String str3, boolean z2, boolean z3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, z2, z3);
    }

    public final boolean a() {
        return this.f18733e;
    }

    public final String b() {
        return this.f18729a;
    }

    public final boolean c() {
        return this.f18732d;
    }

    public final String d() {
        return this.f18731c;
    }

    public final String e() {
        return this.f18730b;
    }

    public final boolean f() {
        return this.f18734f;
    }

    public u(String str, String str2, String str3, boolean z2, boolean z3) {
        this.f18729a = str;
        this.f18730b = str2;
        this.f18731c = str3;
        this.f18732d = z2;
        this.f18733e = z3;
        this.f18734f = !z2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ u(String str, String str2, String str3, boolean z2, boolean z3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i2 & 8) != 0 ? false : z2, (i2 & 16) != 0 ? true : z3, (DefaultConstructorMarker) null);
    }
}
