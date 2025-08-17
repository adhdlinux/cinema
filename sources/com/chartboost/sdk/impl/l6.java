package com.chartboost.sdk.impl;

import android.app.Activity;
import com.chartboost.sdk.internal.Libraries.CBUtility;
import com.chartboost.sdk.internal.Model.CBError;
import kotlin.jvm.internal.Intrinsics;

public final class l6 implements b {

    /* renamed from: a  reason: collision with root package name */
    public final j6 f18109a;

    /* renamed from: b  reason: collision with root package name */
    public final x9 f18110b;

    public l6(j6 j6Var, x9 x9Var) {
        Intrinsics.f(j6Var, "view");
        Intrinsics.f(x9Var, "rendererActivityBridge");
        this.f18109a = j6Var;
        this.f18110b = x9Var;
    }

    public void a(kd kdVar) {
        Intrinsics.f(kdVar, "viewBase");
        this.f18109a.a(kdVar);
    }

    public boolean b() {
        try {
            return this.f18110b.d();
        } catch (Exception e2) {
            String a2 = m6.f18190a;
            Intrinsics.e(a2, "TAG");
            w7.b(a2, "onBackPressed: " + e2);
            return false;
        }
    }

    public void c() {
        try {
            this.f18110b.c();
        } catch (Exception e2) {
            String a2 = m6.f18190a;
            Intrinsics.e(a2, "TAG");
            w7.a(a2, "Cannot perform onStop: " + e2);
        }
    }

    public void d() {
        this.f18110b.a(this, this.f18109a.b());
        this.f18109a.d();
    }

    public void e() {
        try {
            this.f18110b.h();
        } catch (Exception e2) {
            String a2 = m6.f18190a;
            Intrinsics.e(a2, "TAG");
            w7.a(a2, "Cannot perform onStop: " + e2);
        }
    }

    public void f() {
        try {
            this.f18110b.f();
        } catch (Exception e2) {
            String a2 = m6.f18190a;
            Intrinsics.e(a2, "TAG");
            w7.a(a2, "Cannot perform onPause: " + e2);
        }
        try {
            CBUtility.b(this.f18109a.b(), this.f18110b.e());
        } catch (Exception e3) {
            String a3 = m6.f18190a;
            Intrinsics.e(a3, "TAG");
            w7.a(a3, "Cannot lock the orientation in activity: " + e3);
        }
    }

    public void g() {
        try {
            this.f18110b.a(this, this.f18109a.b());
        } catch (Exception e2) {
            String a2 = m6.f18190a;
            Intrinsics.e(a2, "TAG");
            w7.a(a2, "Cannot setActivityRendererInterface: " + e2);
        }
        try {
            this.f18110b.b();
        } catch (Exception e3) {
            String a3 = m6.f18190a;
            Intrinsics.e(a3, "TAG");
            w7.a(a3, "Cannot perform onResume: " + e3);
        }
        this.f18109a.d();
        try {
            CBUtility.a((Activity) this.f18109a.b(), this.f18110b.e());
        } catch (Exception e4) {
            String a4 = m6.f18190a;
            Intrinsics.e(a4, "TAG");
            w7.a(a4, "Cannot lock the orientation in activity: " + e4);
        }
    }

    public void h() {
        try {
            this.f18110b.g();
        } catch (Exception e2) {
            String a2 = m6.f18190a;
            Intrinsics.e(a2, "TAG");
            w7.a(a2, "Cannot perform onResume: " + e2);
        }
    }

    public void i() {
        try {
            if (!this.f18109a.c()) {
                String a2 = m6.f18190a;
                Intrinsics.e(a2, "TAG");
                w7.b(a2, "The activity passed down is not hardware accelerated, so Chartboost cannot show ads");
                this.f18110b.a(CBError.CBImpressionError.HARDWARE_ACCELERATION_DISABLED);
                this.f18109a.a();
            }
        } catch (Exception e2) {
            String a3 = m6.f18190a;
            Intrinsics.e(a3, "TAG");
            w7.b(a3, "onAttachedToWindow: " + e2);
        }
    }

    public void a() {
        this.f18109a.a();
    }
}
