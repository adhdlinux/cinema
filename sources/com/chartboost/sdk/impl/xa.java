package com.chartboost.sdk.impl;

import com.chartboost.sdk.Mediation;
import kotlin.jvm.internal.Intrinsics;

public final class xa {

    /* renamed from: a  reason: collision with root package name */
    public final String f18977a;

    /* renamed from: b  reason: collision with root package name */
    public final String f18978b;

    /* renamed from: c  reason: collision with root package name */
    public final int f18979c;

    /* renamed from: d  reason: collision with root package name */
    public final String f18980d;

    /* renamed from: e  reason: collision with root package name */
    public final Mediation f18981e;

    public xa(String str, String str2, int i2, String str3, Mediation mediation) {
        Intrinsics.f(str2, "location");
        Intrinsics.f(str3, "adTypeName");
        this.f18977a = str;
        this.f18978b = str2;
        this.f18979c = i2;
        this.f18980d = str3;
        this.f18981e = mediation;
    }

    public final String a() {
        return this.f18977a;
    }

    public final String b() {
        return this.f18980d;
    }

    public final String c() {
        return this.f18978b;
    }

    public final Mediation d() {
        return this.f18981e;
    }

    public final int e() {
        return this.f18979c;
    }
}
