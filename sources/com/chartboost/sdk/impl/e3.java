package com.chartboost.sdk.impl;

import android.content.Context;
import android.util.Log;
import b0.o;
import com.chartboost.sdk.callbacks.StartCallback;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.jvm.internal.Intrinsics;

public final class e3 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f17589a;

    /* renamed from: b  reason: collision with root package name */
    public final ScheduledExecutorService f17590b;

    /* renamed from: c  reason: collision with root package name */
    public final qa f17591c;

    /* renamed from: d  reason: collision with root package name */
    public final s1 f17592d;

    /* renamed from: e  reason: collision with root package name */
    public final b2 f17593e;

    public e3(Context context, ScheduledExecutorService scheduledExecutorService, qa qaVar, s1 s1Var, b2 b2Var) {
        Intrinsics.f(context, "context");
        Intrinsics.f(scheduledExecutorService, "backgroundExecutor");
        Intrinsics.f(qaVar, "sdkInitializer");
        Intrinsics.f(s1Var, "tokenGenerator");
        Intrinsics.f(b2Var, InterpolationAnimatedNode.EXTRAPOLATE_TYPE_IDENTITY);
        this.f17589a = context;
        this.f17590b = scheduledExecutorService;
        this.f17591c = qaVar;
        this.f17592d = s1Var;
        this.f17593e = b2Var;
    }

    public final void a(String str, String str2, StartCallback startCallback) {
        Intrinsics.f(str, "appId");
        Intrinsics.f(str2, "appSignature");
        Intrinsics.f(startCallback, "onStarted");
        this.f17590b.execute(new o(this, str, str2, startCallback));
    }

    public final void b() {
        try {
            Thread.sleep(100);
            this.f17593e.h();
        } catch (Exception e2) {
            Log.d("ChartboostApi", "startIdentity error " + e2);
        }
    }

    public static final void a(e3 e3Var, String str, String str2, StartCallback startCallback) {
        Intrinsics.f(e3Var, "this$0");
        Intrinsics.f(str, "$appId");
        Intrinsics.f(str2, "$appSignature");
        Intrinsics.f(startCallback, "$onStarted");
        e3Var.b();
        lc.f18142b.a(e3Var.f17589a);
        e3Var.f17591c.a(str, str2, startCallback);
    }

    public final String a() {
        return this.f17592d.a();
    }
}
