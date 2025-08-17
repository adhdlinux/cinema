package com.chartboost.sdk.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.util.Log;
import b0.n0;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.chartboost.sdk.callbacks.StartCallback;
import com.chartboost.sdk.events.StartError;
import com.chartboost.sdk.impl.xc;
import com.chartboost.sdk.privacy.model.COPPA;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

public final class qa implements y3 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f18442a;

    /* renamed from: b  reason: collision with root package name */
    public final SharedPreferences f18443b;

    /* renamed from: c  reason: collision with root package name */
    public final Handler f18444c;

    /* renamed from: d  reason: collision with root package name */
    public final j9 f18445d;

    /* renamed from: e  reason: collision with root package name */
    public final AtomicReference f18446e;

    /* renamed from: f  reason: collision with root package name */
    public final h9 f18447f;

    /* renamed from: g  reason: collision with root package name */
    public final s4 f18448g;

    /* renamed from: h  reason: collision with root package name */
    public final ta f18449h;

    /* renamed from: i  reason: collision with root package name */
    public final vc f18450i;

    /* renamed from: j  reason: collision with root package name */
    public final Lazy f18451j;

    /* renamed from: k  reason: collision with root package name */
    public final p7 f18452k;

    /* renamed from: l  reason: collision with root package name */
    public final o7 f18453l;

    /* renamed from: m  reason: collision with root package name */
    public final r2 f18454m;

    /* renamed from: n  reason: collision with root package name */
    public final o9 f18455n;

    /* renamed from: o  reason: collision with root package name */
    public final b2 f18456o;

    /* renamed from: p  reason: collision with root package name */
    public final q8 f18457p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f18458q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f18459r = true;

    /* renamed from: s  reason: collision with root package name */
    public final ConcurrentLinkedQueue f18460s = new ConcurrentLinkedQueue();

    /* renamed from: t  reason: collision with root package name */
    public boolean f18461t;

    public qa(Context context, SharedPreferences sharedPreferences, Handler handler, j9 j9Var, AtomicReference atomicReference, h9 h9Var, s4 s4Var, ta taVar, vc vcVar, Lazy lazy, p7 p7Var, o7 o7Var, r2 r2Var, o9 o9Var, b2 b2Var, q8 q8Var) {
        Context context2 = context;
        SharedPreferences sharedPreferences2 = sharedPreferences;
        Handler handler2 = handler;
        j9 j9Var2 = j9Var;
        AtomicReference atomicReference2 = atomicReference;
        h9 h9Var2 = h9Var;
        s4 s4Var2 = s4Var;
        ta taVar2 = taVar;
        vc vcVar2 = vcVar;
        Lazy lazy2 = lazy;
        p7 p7Var2 = p7Var;
        o7 o7Var2 = o7Var;
        r2 r2Var2 = r2Var;
        o9 o9Var2 = o9Var;
        Intrinsics.f(context2, "context");
        Intrinsics.f(sharedPreferences2, "sharedPreferences");
        Intrinsics.f(handler2, "uiHandler");
        Intrinsics.f(j9Var2, "privacyApi");
        Intrinsics.f(atomicReference2, "sdkConfig");
        Intrinsics.f(h9Var2, "prefetcher");
        Intrinsics.f(s4Var2, "downloader");
        Intrinsics.f(taVar2, "session");
        Intrinsics.f(vcVar2, "videoCachePolicy");
        Intrinsics.f(lazy2, "videoRepository");
        Intrinsics.f(p7Var2, "initInstallRequest");
        Intrinsics.f(o7Var2, "initConfigRequest");
        Intrinsics.f(r2Var2, "reachability");
        Intrinsics.f(o9Var2, "providerInstallerHelper");
        Intrinsics.f(b2Var, InterpolationAnimatedNode.EXTRAPOLATE_TYPE_IDENTITY);
        q8 q8Var2 = q8Var;
        Intrinsics.f(q8Var2, "openMeasurementManager");
        this.f18442a = context2;
        this.f18443b = sharedPreferences2;
        this.f18444c = handler2;
        this.f18445d = j9Var2;
        this.f18446e = atomicReference2;
        this.f18447f = h9Var2;
        this.f18448g = s4Var2;
        this.f18449h = taVar2;
        this.f18450i = vcVar2;
        this.f18451j = lazy2;
        this.f18452k = p7Var2;
        this.f18453l = o7Var2;
        this.f18454m = r2Var2;
        this.f18455n = o9Var2;
        this.f18456o = b2Var;
        this.f18457p = q8Var2;
    }

    public final synchronized void a(String str, String str2, StartCallback startCallback) {
        Intrinsics.f(str, "appId");
        Intrinsics.f(str2, "appSignature");
        Intrinsics.f(startCallback, "onStarted");
        try {
            d5.f17421b.a();
            this.f18460s.add(new AtomicReference(startCallback));
            if (this.f18461t) {
                String a2 = ra.f18520a;
                Intrinsics.e(a2, "TAG");
                w7.c(a2, "Initialization already in progress");
                return;
            }
            if (this.f18449h.c() > 1) {
                this.f18459r = false;
            }
            this.f18461t = true;
            n();
            if (this.f18458q) {
                g();
            } else {
                a(str, str2);
            }
            b();
        } catch (Exception e2) {
            String a3 = ra.f18520a;
            Intrinsics.e(a3, "TAG");
            w7.b(a3, "Cannot initialize Chartboost sdk due to internal error " + e2);
            a(new StartError(StartError.Code.INTERNAL, e2));
        }
        return;
    }

    public final void b() {
        if (this.f18445d.a(COPPA.COPPA_STANDARD) == null && !this.f18458q) {
            Log.w(ra.f18520a, "COPPA is not set. If this app is child directed, please use ´addDataUseConsent(android.content.Context, com.chartboost.sdk.Privacy.model.COPPA)´ to set the correct value.");
        }
    }

    public final void c(JSONObject jSONObject) {
        if (jSONObject != null && u1.a(this.f18446e, jSONObject)) {
            this.f18443b.edit().putString("config", jSONObject.toString()).apply();
        }
    }

    public final boolean d() {
        String h2 = h();
        return h2 != null && h2.length() > 0;
    }

    public final boolean e() {
        return this.f18458q;
    }

    public final void f() {
        if (this.f18446e.get() != null && ((pa) this.f18446e.get()).f() != null) {
            String a2 = ra.f18520a;
            Intrinsics.e(a2, "TAG");
            String f2 = ((pa) this.f18446e.get()).f();
            Intrinsics.e(f2, "sdkConfig.get().publisherWarning");
            w7.e(a2, f2);
        }
    }

    public final void g() {
        a((StartError) null);
        this.f18458q = true;
        i();
    }

    public final String h() {
        return this.f18443b.getString("config", "");
    }

    public final void i() {
        this.f18453l.a(this);
    }

    public final void j() {
        f();
        pa paVar = (pa) this.f18446e.get();
        if (paVar != null) {
            this.f18445d.a(paVar.C);
        }
        this.f18452k.a();
        l();
    }

    public final void k() {
        if (la.f18112a.g()) {
            String h2 = h();
            String str = JsonUtils.EMPTY_JSON;
            if (h2 == null) {
                h2 = str;
            }
            if (h2.length() != 0) {
                str = h2;
            }
            b(new JSONObject(str));
        }
    }

    public final void l() {
        this.f18447f.b();
    }

    public final void m() {
        if (!this.f18458q) {
            a((StartError) null);
            this.f18458q = true;
        }
    }

    public final void n() {
        if (this.f18449h.e() == null) {
            this.f18449h.a();
            String a2 = ra.f18520a;
            Intrinsics.e(a2, "TAG");
            w7.c(a2, "Current session count: " + this.f18449h.c());
        }
    }

    public final void o() {
        ob g2 = ((pa) this.f18446e.get()).g();
        if (g2 != null) {
            lc.f18142b.refresh(g2);
        }
    }

    public final void p() {
        xc c2 = ((pa) this.f18446e.get()).c();
        if (c2 != null) {
            this.f18450i.c(c2.b());
            this.f18450i.b(c2.c());
            this.f18450i.c(c2.d());
            this.f18450i.d(c2.e());
            this.f18450i.e((long) c2.d());
            this.f18450i.f(c2.g());
            this.f18450i.a(c2.a());
        }
        ((dd) this.f18451j.getValue()).a(this.f18442a);
    }

    public final void b(JSONObject jSONObject) {
        if (la.f18112a.g()) {
            xc.b h2 = new pa(jSONObject).c().h();
            la.a("Video player: " + h2);
        }
    }

    public final void c() {
        this.f18457p.e();
        o();
        p();
        j();
        m();
        this.f18459r = false;
    }

    public final void a(String str, String str2) {
        if (!u1.a(this.f18442a)) {
            String a2 = ra.f18520a;
            Intrinsics.e(a2, "TAG");
            w7.b(a2, "Permissions not set correctly");
            a(new StartError(StartError.Code.INVALID_CREDENTIALS, new Exception("Permissions not set correctly")));
        } else if (str.length() != 0 && str2.length() != 0 && str.length() == 24 && str2.length() == 40 && ra.f18521b.g(str) && ra.f18521b.g(str2)) {
            this.f18455n.a();
            this.f18448g.b();
            if (d()) {
                g();
            } else {
                i();
            }
        } else {
            String a3 = ra.f18520a;
            Intrinsics.e(a3, "TAG");
            w7.b(a3, "AppId or AppSignature is invalid. Please pass a valid id's");
            a(new StartError(StartError.Code.INVALID_CREDENTIALS, new Exception("AppId or AppSignature is invalid. Please pass a valid id's")));
        }
    }

    public final void a(StartError startError) {
        a();
        while (true) {
            AtomicReference atomicReference = (AtomicReference) this.f18460s.poll();
            StartCallback startCallback = atomicReference != null ? (StartCallback) atomicReference.get() : null;
            if (startCallback == null) {
                this.f18461t = false;
                return;
            }
            this.f18444c.post(new n0(startCallback, startError));
        }
    }

    public static final void a(StartCallback startCallback, StartError startError) {
        Intrinsics.f(startCallback, "$callback");
        startCallback.onStartCompleted(startError);
    }

    public final void a() {
        if (la.f18112a.g()) {
            i6 h2 = this.f18456o.h();
            la.a("SetId: " + h2.c() + " scope:" + h2.d() + " Tracking state: " + h2.e() + " Identifiers: " + h2.b());
        }
    }

    public void a(JSONObject jSONObject) {
        Intrinsics.f(jSONObject, "configJson");
        c(jSONObject);
        c();
        b(jSONObject);
    }

    public void a(String str) {
        StartError startError;
        Intrinsics.f(str, "errorMsg");
        if (this.f18459r) {
            if (this.f18454m.e()) {
                startError = new StartError(StartError.Code.SERVER_ERROR, new Exception(str));
            } else {
                startError = new StartError(StartError.Code.NETWORK_FAILURE, new Exception(str));
            }
            a(startError);
        } else {
            c();
        }
        k();
    }
}
