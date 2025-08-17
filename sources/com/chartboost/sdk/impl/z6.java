package com.chartboost.sdk.impl;

import com.chartboost.sdk.Mediation;
import com.chartboost.sdk.impl.tb;
import com.google.android.gms.ads.OutOfContextTestingActivity;
import com.unity3d.services.core.request.metrics.AdOperationMetric;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class z6 implements b7, a5 {

    /* renamed from: a  reason: collision with root package name */
    public final v f19111a;

    /* renamed from: b  reason: collision with root package name */
    public final String f19112b;

    /* renamed from: c  reason: collision with root package name */
    public final u f19113c;

    /* renamed from: d  reason: collision with root package name */
    public final k0 f19114d;

    /* renamed from: e  reason: collision with root package name */
    public final e7 f19115e;

    /* renamed from: f  reason: collision with root package name */
    public final b1 f19116f;

    /* renamed from: g  reason: collision with root package name */
    public final s4 f19117g;

    /* renamed from: h  reason: collision with root package name */
    public final p8 f19118h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ a5 f19119i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f19120j = true;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f19121a;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                com.chartboost.sdk.impl.g7[] r0 = com.chartboost.sdk.impl.g7.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.chartboost.sdk.impl.g7 r1 = com.chartboost.sdk.impl.g7.DISPLAYED     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.chartboost.sdk.impl.g7 r1 = com.chartboost.sdk.impl.g7.LOADED     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                f19121a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.z6.a.<clinit>():void");
        }
    }

    public z6(v vVar, String str, u uVar, k0 k0Var, e7 e7Var, b1 b1Var, s4 s4Var, p8 p8Var, a5 a5Var) {
        Intrinsics.f(vVar, OutOfContextTestingActivity.AD_UNIT_KEY);
        Intrinsics.f(str, "location");
        Intrinsics.f(uVar, "adType");
        Intrinsics.f(k0Var, "adUnitRendererImpressionCallback");
        Intrinsics.f(e7Var, "impressionIntermediateCallback");
        Intrinsics.f(b1Var, "appRequest");
        Intrinsics.f(s4Var, "downloader");
        Intrinsics.f(p8Var, "openMeasurementImpressionCallback");
        Intrinsics.f(a5Var, "eventTracker");
        this.f19111a = vVar;
        this.f19112b = str;
        this.f19113c = uVar;
        this.f19114d = k0Var;
        this.f19115e = e7Var;
        this.f19116f = b1Var;
        this.f19117g = s4Var;
        this.f19118h = p8Var;
        this.f19119i = a5Var;
    }

    public void a(g7 g7Var) {
        Intrinsics.f(g7Var, AdOperationMetric.INIT_STATE);
        this.f19120j = true;
        this.f19118h.a(f9.NORMAL);
        int i2 = a.f19121a[g7Var.ordinal()];
        if (i2 == 1) {
            a();
        } else if (i2 == 2) {
            b();
            track((qb) new d4(tb.h.CLOSE_BEFORE_TEMPLATE_SHOW_ERROR, "onClose with state Loaded", this.f19113c.b(), this.f19112b, (Mediation) null, (ib) null, 48, (DefaultConstructorMarker) null));
        }
        this.f19114d.b(this.f19116f);
    }

    public final void b() {
        String a2 = a7.f17207a;
        Intrinsics.e(a2, "TAG");
        w7.c(a2, "Removing impression");
        this.f19115e.a(g7.NONE);
        this.f19115e.r();
        this.f19117g.c();
    }

    public void clear(String str, String str2) {
        Intrinsics.f(str, "type");
        Intrinsics.f(str2, "location");
        this.f19119i.clear(str, str2);
    }

    public qb clearFromStorage(qb qbVar) {
        Intrinsics.f(qbVar, "<this>");
        return this.f19119i.clearFromStorage(qbVar);
    }

    public void e() {
        this.f19114d.a(this.f19111a.m());
    }

    public void f(boolean z2) {
        this.f19120j = z2;
    }

    public qb persist(qb qbVar) {
        Intrinsics.f(qbVar, "<this>");
        return this.f19119i.persist(qbVar);
    }

    public ob refresh(ob obVar) {
        Intrinsics.f(obVar, "<this>");
        return this.f19119i.refresh(obVar);
    }

    public ib store(ib ibVar) {
        Intrinsics.f(ibVar, "<this>");
        return this.f19119i.store(ibVar);
    }

    public qb track(qb qbVar) {
        Intrinsics.f(qbVar, "<this>");
        return this.f19119i.track(qbVar);
    }

    /* renamed from: clearFromStorage  reason: collision with other method in class */
    public void m91clearFromStorage(qb qbVar) {
        Intrinsics.f(qbVar, "event");
        this.f19119i.clearFromStorage(qbVar);
    }

    /* renamed from: persist  reason: collision with other method in class */
    public void m92persist(qb qbVar) {
        Intrinsics.f(qbVar, "event");
        this.f19119i.persist(qbVar);
    }

    /* renamed from: refresh  reason: collision with other method in class */
    public void m93refresh(ob obVar) {
        Intrinsics.f(obVar, "config");
        this.f19119i.refresh(obVar);
    }

    /* renamed from: store  reason: collision with other method in class */
    public void m94store(ib ibVar) {
        Intrinsics.f(ibVar, "ad");
        this.f19119i.store(ibVar);
    }

    /* renamed from: track  reason: collision with other method in class */
    public void m95track(qb qbVar) {
        Intrinsics.f(qbVar, "event");
        this.f19119i.track(qbVar);
    }

    public final void a() {
        String a2 = a7.f17207a;
        Intrinsics.e(a2, "TAG");
        w7.c(a2, "Dismissing impression");
        this.f19115e.a(g7.DISMISSING);
        b();
    }
}
