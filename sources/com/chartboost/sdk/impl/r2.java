package com.chartboost.sdk.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

public final class r2 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f18508a;

    public r2(Context context) {
        Intrinsics.f(context, "context");
        this.f18508a = context;
    }

    public final int a() {
        return b4.f(this.f18508a);
    }

    public final String b() {
        return b4.g(this.f18508a).b();
    }

    public final a4 c() {
        a4 a4Var;
        Context context = this.f18508a;
        if (!b4.d(context)) {
            a4Var = a4.CONNECTION_ERROR;
        } else if (b4.e(context)) {
            a4Var = a4.CONNECTION_WIFI;
        } else if (b4.c(context)) {
            a4Var = a4.CONNECTION_MOBILE;
        } else {
            a4Var = a4.CONNECTION_UNKNOWN;
        }
        String a2 = s2.f18544a;
        Intrinsics.e(a2, "TAG");
        w7.a(a2, "NETWORK TYPE: " + a4Var);
        return a4Var;
    }

    public final boolean d() {
        return c() == a4.CONNECTION_MOBILE;
    }

    public final boolean e() {
        return b4.d(this.f18508a);
    }

    public final h8 f() {
        return b4.g(this.f18508a);
    }
}
