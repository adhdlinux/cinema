package com.applovin.impl.mediation.debugger.b.b;

import android.content.Context;
import com.applovin.impl.sdk.utils.g;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private final String f14556a;

    /* renamed from: b  reason: collision with root package name */
    private final String f14557b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f14558c;

    d(String str, String str2, Context context) {
        this.f14556a = str.replace("android.permission.", "");
        this.f14557b = str2;
        this.f14558c = g.a(str, context);
    }

    public String a() {
        return this.f14556a;
    }

    public String b() {
        return this.f14557b;
    }

    public boolean c() {
        return this.f14558c;
    }
}
