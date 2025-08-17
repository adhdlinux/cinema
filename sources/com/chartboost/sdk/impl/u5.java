package com.chartboost.sdk.impl;

import java.io.File;
import kotlin.jvm.internal.Intrinsics;

public final class u5 {

    /* renamed from: a  reason: collision with root package name */
    public final m5 f18764a;

    public u5(m5 m5Var) {
        Intrinsics.f(m5Var, "fileCaching");
        this.f18764a = m5Var;
    }

    public final File a(q4 q4Var) {
        return r4.a(q4Var, this.f18764a.c());
    }

    public final File b(q4 q4Var) {
        return r4.a(q4Var, this.f18764a.a());
    }

    public final void c(q4 q4Var) {
        Intrinsics.f(q4Var, "download");
        if (la.f18112a.g()) {
            b(q4Var).createNewFile();
        }
    }

    public final void d(q4 q4Var) {
        Intrinsics.f(q4Var, "download");
        if (la.f18112a.g()) {
            a(q4Var).delete();
            b(q4Var).delete();
        }
    }

    public final void e(q4 q4Var) {
        Intrinsics.f(q4Var, "download");
        if (la.f18112a.g()) {
            b(q4Var).delete();
            a(q4Var).createNewFile();
        }
    }
}
