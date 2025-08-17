package com.chartboost.sdk.impl;

import android.os.Handler;
import b0.e;
import b0.f;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

public final class cc implements bc {

    /* renamed from: a  reason: collision with root package name */
    public final Handler f17379a;

    public cc(Handler handler) {
        Intrinsics.f(handler, "uiHandler");
        this.f17379a = handler;
    }

    public static final void b(Function0 function0) {
        Intrinsics.f(function0, "$tmp0");
        function0.invoke();
    }

    public static final void c(Function0 function0) {
        Intrinsics.f(function0, "$tmp0");
        function0.invoke();
    }

    public void a(Function0 function0) {
        Intrinsics.f(function0, "call");
        this.f17379a.post(new f(function0));
    }

    public void a(long j2, Function0 function0) {
        Intrinsics.f(function0, "call");
        this.f17379a.postDelayed(new e(function0), j2);
    }
}
