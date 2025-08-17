package com.chartboost.sdk.impl;

import android.content.Context;
import android.view.View;
import com.chartboost.sdk.impl.ld;
import com.chartboost.sdk.impl.t8;
import com.unity3d.services.core.request.metrics.AdOperationMetric;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

public final class n8 implements p8 {

    /* renamed from: a  reason: collision with root package name */
    public final q8 f18254a;

    /* renamed from: b  reason: collision with root package name */
    public final t8 f18255b;

    /* renamed from: c  reason: collision with root package name */
    public v8 f18256c;

    /* renamed from: d  reason: collision with root package name */
    public ld f18257d;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f18258a;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.chartboost.sdk.impl.r9[] r0 = com.chartboost.sdk.impl.r9.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.chartboost.sdk.impl.r9 r1 = com.chartboost.sdk.impl.r9.FIRST     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.chartboost.sdk.impl.r9 r1 = com.chartboost.sdk.impl.r9.MIDDLE     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.chartboost.sdk.impl.r9 r1 = com.chartboost.sdk.impl.r9.THIRD     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                f18258a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.n8.a.<clinit>():void");
        }
    }

    public n8(q8 q8Var, t8 t8Var) {
        Intrinsics.f(q8Var, "openMeasurementManager");
        Intrinsics.f(t8Var, "openMeasurementSessionBuilder");
        this.f18254a = q8Var;
        this.f18255b = t8Var;
    }

    public final void a(Context context, View view, View view2, ld.b bVar) {
        Intrinsics.f(context, "context");
        Intrinsics.f(view, "trackedView");
        Intrinsics.f(view2, "rootView");
        Intrinsics.f(bVar, "visibilityTrackerListener");
        g();
        j8 b2 = this.f18254a.b();
        ld ldVar = new ld(context, view, view2, b2.a(), b2.b(), b2.f(), b2.c());
        ldVar.a(bVar);
        ldVar.h();
        this.f18257d = ldVar;
    }

    public void b() {
        Unit unit;
        v8 v8Var = this.f18256c;
        if (v8Var != null) {
            v8Var.i();
            unit = Unit.f40298a;
        } else {
            unit = null;
        }
        if (unit == null) {
            String a2 = o8.f18295a;
            Intrinsics.e(a2, "TAG");
            w7.a(a2, "onImpressionNotifyVideoResumed missing om tracker");
        }
    }

    public void c() {
        Unit unit;
        v8 v8Var = this.f18256c;
        if (v8Var != null) {
            v8Var.h();
            unit = Unit.f40298a;
        } else {
            unit = null;
        }
        if (unit == null) {
            String a2 = o8.f18295a;
            Intrinsics.e(a2, "TAG");
            w7.a(a2, "onImpressionNotifyVideoPaused missing om tracker");
        }
    }

    public void d() {
        Unit unit;
        v8 v8Var = this.f18256c;
        if (v8Var != null) {
            v8Var.l();
            unit = Unit.f40298a;
        } else {
            unit = null;
        }
        if (unit == null) {
            String a2 = o8.f18295a;
            Intrinsics.e(a2, "TAG");
            w7.a(a2, "onImpressionNotifyClick missing om tracker");
        }
    }

    public void e() {
        Unit unit;
        v8 v8Var = this.f18256c;
        if (v8Var != null) {
            v8Var.n();
            unit = Unit.f40298a;
        } else {
            unit = null;
        }
        if (unit == null) {
            String a2 = o8.f18295a;
            Intrinsics.e(a2, "TAG");
            w7.a(a2, "onImpressionDestroyWebview missing om tracker");
        }
        this.f18256c = null;
    }

    public void f() {
        Unit unit;
        v8 v8Var = this.f18256c;
        if (v8Var != null) {
            v8Var.j();
            unit = Unit.f40298a;
        } else {
            unit = null;
        }
        if (unit == null) {
            String a2 = o8.f18295a;
            Intrinsics.e(a2, "TAG");
            w7.a(a2, "onImpressionNotifyVideoSkipped missing om tracker");
        }
    }

    public final void g() {
        ld ldVar = this.f18257d;
        if (ldVar != null) {
            ldVar.b();
        }
        this.f18257d = null;
    }

    public final boolean h() {
        return this.f18254a.g();
    }

    public final void i() {
        Unit unit;
        v8 v8Var = this.f18256c;
        if (v8Var != null) {
            v8Var.a();
            unit = Unit.f40298a;
        } else {
            unit = null;
        }
        if (unit == null) {
            String a2 = o8.f18295a;
            Intrinsics.e(a2, "TAG");
            w7.a(a2, "signalImpressionEvent missing om tracker");
        }
    }

    public final void j() {
        Unit unit;
        v8 v8Var = this.f18256c;
        if (v8Var != null) {
            v8Var.m();
            v8Var.b();
            unit = Unit.f40298a;
        } else {
            unit = null;
        }
        if (unit == null) {
            String a2 = o8.f18295a;
            Intrinsics.e(a2, "TAG");
            w7.a(a2, "startAndLoadSession missing tracker");
        }
    }

    public final void k() {
        v8 v8Var = this.f18256c;
        if (v8Var != null) {
            v8Var.n();
        }
        this.f18256c = null;
    }

    public final void b(y7 y7Var, z2 z2Var, List list) {
        this.f18254a.e();
        k();
        t8.a a2 = this.f18255b.a(z2Var, y7Var, this.f18254a.c(), this.f18254a.a(), list, this.f18254a.h(), this.f18254a.d());
        if (a2 != null) {
            this.f18256c = new v8(a2, this.f18254a.g());
        }
        j();
    }

    public void a(y7 y7Var, z2 z2Var, List list) {
        Intrinsics.f(y7Var, "mtype");
        Intrinsics.f(z2Var, "webview");
        Intrinsics.f(list, "verificationScriptResourcesList");
        try {
            b(y7Var, z2Var, list);
        } catch (Exception e2) {
            String a2 = o8.f18295a;
            Intrinsics.e(a2, "TAG");
            w7.a(a2, "OMSDK Session error: " + e2);
        }
    }

    public void a(View view) {
        Intrinsics.f(view, "obstructionView");
        v8 v8Var = this.f18256c;
        if (v8Var != null) {
            v8Var.a(view);
        }
    }

    public void a(float f2, float f3) {
        Unit unit;
        v8 v8Var = this.f18256c;
        if (v8Var != null) {
            v8Var.a(f2, f3);
            unit = Unit.f40298a;
        } else {
            unit = null;
        }
        if (unit == null) {
            String a2 = o8.f18295a;
            Intrinsics.e(a2, "TAG");
            w7.a(a2, "onImpressionNotifyVideoStarted missing om tracker");
        }
    }

    public void a(r9 r9Var) {
        Unit unit;
        Intrinsics.f(r9Var, "quartile");
        v8 v8Var = this.f18256c;
        if (v8Var != null) {
            int i2 = a.f18258a[r9Var.ordinal()];
            if (i2 == 1) {
                v8Var.f();
            } else if (i2 == 2) {
                v8Var.g();
            } else if (i2 == 3) {
                v8Var.k();
            }
            unit = Unit.f40298a;
        } else {
            unit = null;
        }
        if (unit == null) {
            String a2 = o8.f18295a;
            Intrinsics.e(a2, "TAG");
            w7.a(a2, "onImpressionNotifyVideoProgress missing om tracker");
        }
    }

    public void a() {
        Unit unit;
        v8 v8Var = this.f18256c;
        if (v8Var != null) {
            v8Var.e();
            unit = Unit.f40298a;
        } else {
            unit = null;
        }
        if (unit == null) {
            String a2 = o8.f18295a;
            Intrinsics.e(a2, "TAG");
            w7.a(a2, "onImpressionNotifyVideoComplete missing om tracker");
        }
    }

    public void a(boolean z2) {
        Unit unit;
        v8 v8Var = this.f18256c;
        if (v8Var != null) {
            if (z2) {
                v8Var.d();
            } else {
                v8Var.c();
            }
            unit = Unit.f40298a;
        } else {
            unit = null;
        }
        if (unit == null) {
            String a2 = o8.f18295a;
            Intrinsics.e(a2, "TAG");
            w7.a(a2, "onImpressionNotifyVideoBuffer missing om tracker");
        }
    }

    public void a(float f2) {
        Unit unit;
        v8 v8Var = this.f18256c;
        if (v8Var != null) {
            v8Var.a(f2);
            unit = Unit.f40298a;
        } else {
            unit = null;
        }
        if (unit == null) {
            String a2 = o8.f18295a;
            Intrinsics.e(a2, "TAG");
            w7.a(a2, "onImpressionNotifyVolumeChanged missing om tracker");
        }
    }

    public void a(f9 f9Var) {
        Unit unit;
        Intrinsics.f(f9Var, AdOperationMetric.INIT_STATE);
        v8 v8Var = this.f18256c;
        if (v8Var != null) {
            v8Var.a(f9Var);
            unit = Unit.f40298a;
        } else {
            unit = null;
        }
        if (unit == null) {
            String a2 = o8.f18295a;
            Intrinsics.e(a2, "TAG");
            w7.a(a2, "onImpressionNotifyStateChanged missing om tracker");
        }
    }
}
