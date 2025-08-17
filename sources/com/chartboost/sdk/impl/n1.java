package com.chartboost.sdk.impl;

import android.os.Handler;
import b0.a0;
import com.chartboost.sdk.Mediation;
import com.chartboost.sdk.impl.tb;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

public final class n1 implements m1 {

    /* renamed from: a  reason: collision with root package name */
    public final s4 f18209a;

    /* renamed from: b  reason: collision with root package name */
    public final gb f18210b;

    /* renamed from: c  reason: collision with root package name */
    public final dd f18211c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f18212d;

    /* renamed from: e  reason: collision with root package name */
    public u f18213e;

    /* renamed from: f  reason: collision with root package name */
    public final Mediation f18214f;

    public n1(s4 s4Var, gb gbVar, dd ddVar, Handler handler, u uVar, Mediation mediation) {
        Intrinsics.f(s4Var, "downloader");
        Intrinsics.f(gbVar, "timeSource");
        Intrinsics.f(ddVar, "videoRepository");
        Intrinsics.f(handler, "uiHandler");
        Intrinsics.f(uVar, "adType");
        this.f18209a = s4Var;
        this.f18210b = gbVar;
        this.f18211c = ddVar;
        this.f18212d = handler;
        this.f18213e = uVar;
        this.f18214f = mediation;
    }

    public void a(b1 b1Var, String str, i1 i1Var, a0 a0Var) {
        Intrinsics.f(b1Var, "appRequest");
        Intrinsics.f(str, "adTypeTraitsName");
        Intrinsics.f(i1Var, "assetDownloadedCallback");
        Intrinsics.f(a0Var, "adUnitLoaderCallback");
        v a2 = b1Var.a();
        if (a2 != null) {
            a0 a0Var2 = new a0(this, b1Var, a2, a0Var, i1Var);
            this.f18209a.c();
            this.f18209a.a(i9.NORMAL, a2.d(), new AtomicInteger(), (g1) t5.a().a(a0Var2), str);
        }
    }

    public static final void a(n1 n1Var, b1 b1Var, v vVar, a0 a0Var, i1 i1Var, boolean z2) {
        j1 j1Var;
        Intrinsics.f(n1Var, "this$0");
        Intrinsics.f(b1Var, "$appRequest");
        Intrinsics.f(vVar, "$adUnit");
        Intrinsics.f(a0Var, "$adUnitLoaderCallback");
        Intrinsics.f(i1Var, "$assetDownloadedCallback");
        if (z2) {
            j1Var = n1Var.a(b1Var, vVar, a0Var);
        } else if (!z2) {
            j1Var = j1.FAILURE;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        i1Var.a(b1Var, j1Var);
    }

    public final j1 a(b1 b1Var, v vVar, a0 a0Var) {
        a0Var.a(b1Var, tb.a.FINISH_SUCCESS);
        if (!vVar.D()) {
            return j1.READY_TO_SHOW;
        }
        if (!this.f18211c.a(vVar.B())) {
            this.f18211c.a(vVar.C(), vVar.B(), false, (n0) null);
        }
        return j1.SUCCESS;
    }
}
