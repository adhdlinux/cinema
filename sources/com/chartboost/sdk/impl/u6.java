package com.chartboost.sdk.impl;

import com.chartboost.sdk.impl.u;
import com.google.android.gms.ads.OutOfContextTestingActivity;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

public final class u6 implements t6 {

    /* renamed from: a  reason: collision with root package name */
    public final v f18765a;

    /* renamed from: b  reason: collision with root package name */
    public final u f18766b;

    /* renamed from: c  reason: collision with root package name */
    public final v3 f18767c;

    /* renamed from: d  reason: collision with root package name */
    public final k0 f18768d;

    public static final class a implements w3 {
        public void a(JSONObject jSONObject) {
            String a2 = v6.f18849a;
            Intrinsics.e(a2, "TAG");
            w7.c(a2, "onCompleteRequestSuccess " + jSONObject);
        }

        public void a(String str) {
            String a2 = v6.f18849a;
            Intrinsics.e(a2, "TAG");
            w7.c(a2, "onCompleteRequestFailure " + str);
        }
    }

    public u6(v vVar, u uVar, v3 v3Var, k0 k0Var) {
        Intrinsics.f(vVar, OutOfContextTestingActivity.AD_UNIT_KEY);
        Intrinsics.f(uVar, "adType");
        Intrinsics.f(v3Var, "completeRequest");
        Intrinsics.f(k0Var, "adUnitRendererImpressionCallback");
        this.f18765a = vVar;
        this.f18766b = uVar;
        this.f18767c = v3Var;
        this.f18768d = k0Var;
    }

    public void a(String str, Float f2, Float f3) {
        Intrinsics.f(str, "location");
        this.f18767c.a((w3) new a(), new u3(str, this.f18765a.a(), this.f18765a.g(), this.f18765a.v(), this.f18765a.w(), f2, f3));
    }

    public void c() {
        u uVar = this.f18766b;
        if (uVar == u.b.f18736g) {
            String a2 = v6.f18849a;
            Intrinsics.e(a2, "TAG");
            w7.c(a2, "didCompleteInterstitial delegate used to be sent here");
        } else if (uVar == u.c.f18737g) {
            this.f18768d.a(this.f18765a.m(), this.f18765a.v());
        }
    }
}
