package com.chartboost.sdk.impl;

import android.content.Context;
import android.content.SharedPreferences;
import com.chartboost.sdk.Mediation;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.Intrinsics;

public final class da implements ca {

    /* renamed from: a  reason: collision with root package name */
    public final Context f17453a;

    /* renamed from: b  reason: collision with root package name */
    public final b2 f17454b;

    /* renamed from: c  reason: collision with root package name */
    public final r2 f17455c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicReference f17456d;

    /* renamed from: e  reason: collision with root package name */
    public final SharedPreferences f17457e;

    /* renamed from: f  reason: collision with root package name */
    public final gb f17458f;

    /* renamed from: g  reason: collision with root package name */
    public final c3 f17459g;

    /* renamed from: h  reason: collision with root package name */
    public final ta f17460h;

    /* renamed from: i  reason: collision with root package name */
    public final j9 f17461i;

    /* renamed from: j  reason: collision with root package name */
    public final Mediation f17462j;

    /* renamed from: k  reason: collision with root package name */
    public final j4 f17463k;

    public da(Context context, b2 b2Var, r2 r2Var, AtomicReference atomicReference, SharedPreferences sharedPreferences, gb gbVar, c3 c3Var, ta taVar, j9 j9Var, Mediation mediation, j4 j4Var) {
        Intrinsics.f(context, "context");
        Intrinsics.f(b2Var, InterpolationAnimatedNode.EXTRAPOLATE_TYPE_IDENTITY);
        Intrinsics.f(r2Var, "reachability");
        Intrinsics.f(atomicReference, "sdkConfig");
        Intrinsics.f(sharedPreferences, "sharedPreferences");
        Intrinsics.f(gbVar, "timeSource");
        Intrinsics.f(c3Var, "carrierBuilder");
        Intrinsics.f(taVar, "session");
        Intrinsics.f(j9Var, "privacyApi");
        Intrinsics.f(j4Var, "deviceBodyFieldsFactory");
        this.f17453a = context;
        this.f17454b = b2Var;
        this.f17455c = r2Var;
        this.f17456d = atomicReference;
        this.f17457e = sharedPreferences;
        this.f17458f = gbVar;
        this.f17459g = c3Var;
        this.f17460h = taVar;
        this.f17461i = j9Var;
        this.f17462j = mediation;
        this.f17463k = j4Var;
    }

    public ea a() {
        z7 z7Var;
        i3 i3Var = i3.f17882b;
        String b2 = i3Var.b();
        String c2 = i3Var.c();
        i6 h2 = this.f17454b.h();
        t9 reachabilityBodyFields = r5.toReachabilityBodyFields(this.f17455c);
        b3 a2 = this.f17459g.a(this.f17453a);
        ua h3 = this.f17460h.h();
        hb bodyFields = r5.toBodyFields(this.f17458f);
        k9 g2 = this.f17461i.g();
        z3 j2 = ((pa) this.f17456d.get()).j();
        i4 a3 = this.f17463k.a();
        Mediation mediation = this.f17462j;
        if (mediation != null) {
            z7Var = mediation.toMediationBodyFields();
        } else {
            z7Var = null;
        }
        return new ea(b2, c2, h2, reachabilityBodyFields, a2, h3, bodyFields, g2, j2, a3, z7Var);
    }
}
