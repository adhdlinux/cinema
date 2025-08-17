package com.chartboost.sdk.impl;

import com.chartboost.sdk.Mediation;
import com.chartboost.sdk.impl.tb;
import com.chartboost.sdk.internal.Model.CBError;
import com.chartboost.sdk.view.CBImpressionActivity;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class y9 implements x9, a5 {

    /* renamed from: a  reason: collision with root package name */
    public final k6 f19092a;

    /* renamed from: b  reason: collision with root package name */
    public final AtomicReference f19093b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ a5 f19094c;

    /* renamed from: d  reason: collision with root package name */
    public WeakReference f19095d;

    /* renamed from: e  reason: collision with root package name */
    public WeakReference f19096e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f19097f;

    public y9(k6 k6Var, AtomicReference atomicReference, a5 a5Var) {
        Intrinsics.f(k6Var, "impressionActivityIntentWrapper");
        Intrinsics.f(atomicReference, "sdkConfigurationRef");
        Intrinsics.f(a5Var, "eventTracker");
        this.f19092a = k6Var;
        this.f19093b = atomicReference;
        this.f19094c = a5Var;
    }

    public void a(b bVar, CBImpressionActivity cBImpressionActivity) {
        i0 i0Var;
        Intrinsics.f(bVar, "activityInterface");
        Intrinsics.f(cBImpressionActivity, "activity");
        this.f19095d = new WeakReference(bVar);
        WeakReference weakReference = this.f19096e;
        if (weakReference != null && (i0Var = (i0) weakReference.get()) != null) {
            i0Var.a(cBImpressionActivity);
        }
    }

    public void b() {
        Unit unit;
        i0 i0Var;
        WeakReference weakReference = this.f19096e;
        if (weakReference == null || (i0Var = (i0) weakReference.get()) == null) {
            unit = null;
        } else {
            i0Var.A();
            unit = Unit.f40298a;
        }
        if (unit == null) {
            String a2 = z9.f19137a;
            Intrinsics.e(a2, "TAG");
            w7.a(a2, "Bridge onResume missing callback to renderer");
        }
    }

    public void c() {
        i0 i0Var;
        WeakReference weakReference = this.f19096e;
        if (weakReference != null && (i0Var = (i0) weakReference.get()) != null) {
            i0Var.c();
        }
    }

    public void clear(String str, String str2) {
        Intrinsics.f(str, "type");
        Intrinsics.f(str2, "location");
        this.f19094c.clear(str, str2);
    }

    public qb clearFromStorage(qb qbVar) {
        Intrinsics.f(qbVar, "<this>");
        return this.f19094c.clearFromStorage(qbVar);
    }

    public boolean d() {
        i0 i0Var;
        WeakReference weakReference = this.f19096e;
        if (weakReference == null || (i0Var = (i0) weakReference.get()) == null) {
            return false;
        }
        return i0Var.d();
    }

    public pa e() {
        return (pa) this.f19093b.get();
    }

    public void f() {
        Unit unit;
        i0 i0Var;
        WeakReference weakReference = this.f19096e;
        if (weakReference == null || (i0Var = (i0) weakReference.get()) == null) {
            unit = null;
        } else {
            i0Var.s();
            unit = Unit.f40298a;
        }
        if (unit == null) {
            String a2 = z9.f19137a;
            Intrinsics.e(a2, "TAG");
            w7.a(a2, "Bridge onPause missing callback to renderer");
        }
    }

    public void g() {
        Unit unit;
        i0 i0Var;
        WeakReference weakReference = this.f19096e;
        if (weakReference == null || (i0Var = (i0) weakReference.get()) == null) {
            unit = null;
        } else {
            i0Var.y();
            unit = Unit.f40298a;
        }
        if (unit == null) {
            String a2 = z9.f19137a;
            Intrinsics.e(a2, "TAG");
            w7.a(a2, "Bridge onStart missing callback to renderer");
        }
    }

    public void h() {
        Unit unit;
        i0 i0Var;
        i();
        WeakReference weakReference = this.f19096e;
        if (weakReference == null || (i0Var = (i0) weakReference.get()) == null) {
            unit = null;
        } else {
            i0Var.q();
            unit = Unit.f40298a;
        }
        if (unit == null) {
            String a2 = z9.f19137a;
            Intrinsics.e(a2, "TAG");
            w7.a(a2, "Bridge onDestroy missing callback to renderer");
        }
        WeakReference weakReference2 = this.f19095d;
        if (weakReference2 != null) {
            weakReference2.clear();
        }
        WeakReference weakReference3 = this.f19096e;
        if (weakReference3 != null) {
            weakReference3.clear();
        }
    }

    public final void i() {
        if (!this.f19097f) {
            track((qb) new x4(tb.h.DISMISS_MISSING, "dismiss_missing happened due to sdk closure outside expected flow", (String) null, (String) null, (Mediation) null, 28, (DefaultConstructorMarker) null));
        }
    }

    public qb persist(qb qbVar) {
        Intrinsics.f(qbVar, "<this>");
        return this.f19094c.persist(qbVar);
    }

    public ob refresh(ob obVar) {
        Intrinsics.f(obVar, "<this>");
        return this.f19094c.refresh(obVar);
    }

    public ib store(ib ibVar) {
        Intrinsics.f(ibVar, "<this>");
        return this.f19094c.store(ibVar);
    }

    public qb track(qb qbVar) {
        Intrinsics.f(qbVar, "<this>");
        return this.f19094c.track(qbVar);
    }

    /* renamed from: clearFromStorage  reason: collision with other method in class */
    public void m86clearFromStorage(qb qbVar) {
        Intrinsics.f(qbVar, "event");
        this.f19094c.clearFromStorage(qbVar);
    }

    /* renamed from: persist  reason: collision with other method in class */
    public void m87persist(qb qbVar) {
        Intrinsics.f(qbVar, "event");
        this.f19094c.persist(qbVar);
    }

    /* renamed from: refresh  reason: collision with other method in class */
    public void m88refresh(ob obVar) {
        Intrinsics.f(obVar, "config");
        this.f19094c.refresh(obVar);
    }

    /* renamed from: store  reason: collision with other method in class */
    public void m89store(ib ibVar) {
        Intrinsics.f(ibVar, "ad");
        this.f19094c.store(ibVar);
    }

    /* renamed from: track  reason: collision with other method in class */
    public void m90track(qb qbVar) {
        Intrinsics.f(qbVar, "event");
        this.f19094c.track(qbVar);
    }

    public void a(kd kdVar) {
        Unit unit;
        b bVar;
        Intrinsics.f(kdVar, "viewBase");
        WeakReference weakReference = this.f19095d;
        if (weakReference == null || (bVar = (b) weakReference.get()) == null) {
            unit = null;
        } else {
            bVar.a(kdVar);
            unit = Unit.f40298a;
        }
        if (unit == null) {
            String a2 = z9.f19137a;
            Intrinsics.e(a2, "TAG");
            w7.a(a2, "activityInterface is null");
        }
    }

    public void a(i0 i0Var) {
        Intrinsics.f(i0Var, "adUnitRendererActivityInterface");
        this.f19096e = new WeakReference(i0Var);
        try {
            k6 k6Var = this.f19092a;
            k6Var.a(k6Var.a());
        } catch (Exception e2) {
            String a2 = z9.f19137a;
            Intrinsics.e(a2, "TAG");
            w7.b(a2, "Please add CBImpressionActivity in AndroidManifest.xml following README.md instructions. " + e2);
            a(CBError.CBImpressionError.ACTIVITY_MISSING_IN_MANIFEST);
        }
    }

    public void a(CBError.CBImpressionError cBImpressionError) {
        i0 i0Var;
        Intrinsics.f(cBImpressionError, MRAIDPresenter.ERROR);
        WeakReference weakReference = this.f19096e;
        if (weakReference != null && (i0Var = (i0) weakReference.get()) != null) {
            i0Var.a(cBImpressionError);
        }
    }

    public void a() {
        b bVar;
        this.f19097f = true;
        WeakReference weakReference = this.f19095d;
        if (weakReference != null && (bVar = (b) weakReference.get()) != null) {
            bVar.a();
        }
    }
}
