package com.chartboost.sdk.impl;

import android.view.ViewGroup;
import com.chartboost.sdk.Mediation;
import com.chartboost.sdk.impl.tb;
import com.chartboost.sdk.impl.u;
import com.chartboost.sdk.internal.Model.CBError;
import com.facebook.hermes.intl.Constants;
import com.unity3d.services.core.device.MimeTypes;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class n6 implements a5 {

    /* renamed from: a  reason: collision with root package name */
    public final v5 f18226a;

    /* renamed from: b  reason: collision with root package name */
    public final s4 f18227b;

    /* renamed from: c  reason: collision with root package name */
    public final kc f18228c;

    /* renamed from: d  reason: collision with root package name */
    public final q7 f18229d;

    /* renamed from: e  reason: collision with root package name */
    public final u f18230e;

    /* renamed from: f  reason: collision with root package name */
    public final q2 f18231f;

    /* renamed from: g  reason: collision with root package name */
    public final ca f18232g;

    /* renamed from: h  reason: collision with root package name */
    public final Mediation f18233h;

    /* renamed from: i  reason: collision with root package name */
    public final q8 f18234i;

    /* renamed from: j  reason: collision with root package name */
    public final ja f18235j;

    /* renamed from: k  reason: collision with root package name */
    public final p8 f18236k;

    /* renamed from: l  reason: collision with root package name */
    public final Function2 f18237l;

    /* renamed from: m  reason: collision with root package name */
    public final a5 f18238m;

    public n6(v5 v5Var, s4 s4Var, kc kcVar, q7 q7Var, u uVar, q2 q2Var, ca caVar, Mediation mediation, q8 q8Var, ja jaVar, p8 p8Var, Function2 function2, a5 a5Var) {
        Intrinsics.f(v5Var, "fileCache");
        Intrinsics.f(s4Var, "downloader");
        Intrinsics.f(kcVar, "urlResolver");
        Intrinsics.f(q7Var, "intentResolver");
        Intrinsics.f(uVar, "adType");
        Intrinsics.f(q2Var, "networkService");
        Intrinsics.f(caVar, "requestBodyBuilder");
        Intrinsics.f(q8Var, "measurementManager");
        Intrinsics.f(jaVar, "sdkBiddingTemplateParser");
        Intrinsics.f(p8Var, "openMeasurementImpressionCallback");
        Intrinsics.f(function2, "impressionFactory");
        Intrinsics.f(a5Var, "eventTracker");
        this.f18226a = v5Var;
        this.f18227b = s4Var;
        this.f18228c = kcVar;
        this.f18229d = q7Var;
        this.f18230e = uVar;
        this.f18231f = q2Var;
        this.f18232g = caVar;
        this.f18233h = mediation;
        this.f18234i = q8Var;
        this.f18235j = jaVar;
        this.f18236k = p8Var;
        this.f18237l = function2;
        this.f18238m = a5Var;
    }

    public final c7 a(b1 b1Var, k0 k0Var, ViewGroup viewGroup, e7 e7Var, q6 q6Var, k7 k7Var, d7 d7Var, od odVar, c8 c8Var, eb ebVar) {
        eb ebVar2 = ebVar;
        Intrinsics.f(b1Var, "appRequest");
        Intrinsics.f(k0Var, "callback");
        Intrinsics.f(e7Var, "impressionIntermediateCallback");
        Intrinsics.f(q6Var, "impressionClickCallback");
        Intrinsics.f(k7Var, "viewProtocolBuilder");
        Intrinsics.f(d7Var, "impressionInterface");
        Intrinsics.f(odVar, "webViewTimeoutInterface");
        Intrinsics.f(c8Var, "nativeBridgeCommand");
        Intrinsics.f(ebVar2, "templateLoader");
        try {
            File a2 = this.f18226a.a().a();
            v a3 = b1Var.a();
            String d2 = b1Var.d();
            if (a3 == null) {
                return new c7((e2) null, CBError.CBImpressionError.PENDING_IMPRESSION_ERROR);
            }
            Intrinsics.e(a2, "baseDir");
            CBError.CBImpressionError a4 = a(a3, a2, d2);
            if (a4 != null) {
                return new c7((e2) null, a4);
            }
            String a5 = a(ebVar2, a3, a2, d2);
            if (a5 == null) {
                return new c7((e2) null, CBError.CBImpressionError.ERROR_LOADING_WEB_VIEW);
            }
            return new c7(a(b1Var, a3, d2, this.f18234i.a(a5), k0Var, viewGroup, e7Var, q6Var, k7Var, d7Var, odVar, c8Var), (CBError.CBImpressionError) null);
        } catch (Exception e2) {
            String a6 = o6.f18290a;
            Intrinsics.e(a6, "TAG");
            w7.a(a6, "showReady exception:", e2);
            return new c7((e2) null, CBError.CBImpressionError.INTERNAL);
        }
    }

    public void clear(String str, String str2) {
        Intrinsics.f(str, "type");
        Intrinsics.f(str2, "location");
        this.f18238m.clear(str, str2);
    }

    public qb clearFromStorage(qb qbVar) {
        Intrinsics.f(qbVar, "<this>");
        return this.f18238m.clearFromStorage(qbVar);
    }

    public qb persist(qb qbVar) {
        Intrinsics.f(qbVar, "<this>");
        return this.f18238m.persist(qbVar);
    }

    public ob refresh(ob obVar) {
        Intrinsics.f(obVar, "<this>");
        return this.f18238m.refresh(obVar);
    }

    public ib store(ib ibVar) {
        Intrinsics.f(ibVar, "<this>");
        return this.f18238m.store(ibVar);
    }

    public qb track(qb qbVar) {
        Intrinsics.f(qbVar, "<this>");
        return this.f18238m.track(qbVar);
    }

    /* renamed from: clearFromStorage  reason: collision with other method in class */
    public void m46clearFromStorage(qb qbVar) {
        Intrinsics.f(qbVar, "event");
        this.f18238m.clearFromStorage(qbVar);
    }

    /* renamed from: persist  reason: collision with other method in class */
    public void m47persist(qb qbVar) {
        Intrinsics.f(qbVar, "event");
        this.f18238m.persist(qbVar);
    }

    /* renamed from: refresh  reason: collision with other method in class */
    public void m48refresh(ob obVar) {
        Intrinsics.f(obVar, "config");
        this.f18238m.refresh(obVar);
    }

    /* renamed from: store  reason: collision with other method in class */
    public void m49store(ib ibVar) {
        Intrinsics.f(ibVar, "ad");
        this.f18238m.store(ibVar);
    }

    /* renamed from: track  reason: collision with other method in class */
    public void m50track(qb qbVar) {
        Intrinsics.f(qbVar, "event");
        this.f18238m.track(qbVar);
    }

    public final e2 a(b1 b1Var, v vVar, String str, String str2, k0 k0Var, ViewGroup viewGroup, e7 e7Var, q6 q6Var, k7 k7Var, d7 d7Var, od odVar, c8 c8Var) {
        f7 a2 = a(vVar.p(), this.f18230e);
        m3 m3Var = r1;
        m3 m3Var2 = new m3(this.f18231f, this.f18232g, this.f18238m);
        v3 v3Var = r1;
        v3 v3Var2 = new v3(this.f18231f, this.f18232g, this.f18238m);
        y2 a3 = k7Var.a(str, vVar, this.f18230e.b(), str2, k0Var, d7Var, odVar, c8Var);
        kc kcVar = this.f18228c;
        q7 q7Var = this.f18229d;
        q3 a4 = kb.a(this.f18230e.b(), str, this.f18233h, this.f18238m);
        p8 p8Var = this.f18236k;
        s4 s4Var = this.f18227b;
        u uVar = this.f18230e;
        return (e2) this.f18237l.invoke(new y6(kcVar, q7Var, m3Var, a4, v3Var, a2, p8Var, b1Var, s4Var, a3, vVar, uVar, str, e7Var, q6Var, k0Var, this.f18238m), viewGroup);
    }

    public final f7 a(String str, u uVar) {
        if (Intrinsics.a(uVar, u.b.f18736g)) {
            return a(str);
        }
        if (Intrinsics.a(uVar, u.c.f18737g)) {
            return f7.INTERSTITIAL_REWARD_VIDEO;
        }
        if (Intrinsics.a(uVar, u.a.f18735g)) {
            return f7.BANNER;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final f7 a(String str) {
        if (Intrinsics.a(str, MimeTypes.BASE_TYPE_VIDEO)) {
            return f7.INTERSTITIAL_VIDEO;
        }
        return f7.INTERSTITIAL;
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x001a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.chartboost.sdk.internal.Model.CBError.CBImpressionError a(com.chartboost.sdk.impl.v r4, java.io.File r5, java.lang.String r6) {
        /*
            r3 = this;
            java.util.Map r4 = r4.d()
            boolean r0 = r4.isEmpty()
            r1 = 0
            if (r0 == 0) goto L_0x000c
            return r1
        L_0x000c:
            java.util.Collection r4 = r4.values()
            java.util.Iterator r4 = r4.iterator()
        L_0x0014:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x005d
            java.lang.Object r0 = r4.next()
            com.chartboost.sdk.impl.f1 r0 = (com.chartboost.sdk.impl.f1) r0
            java.io.File r2 = r0.a((java.io.File) r5)
            if (r2 == 0) goto L_0x002c
            boolean r2 = r2.exists()
            if (r2 != 0) goto L_0x0014
        L_0x002c:
            java.lang.String r4 = com.chartboost.sdk.impl.o6.f18290a
            java.lang.String r5 = "TAG"
            kotlin.jvm.internal.Intrinsics.e(r4, r5)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r1 = "Asset does not exist: "
            r5.append(r1)
            java.lang.String r1 = r0.f17672b
            r5.append(r1)
            java.lang.String r5 = r5.toString()
            com.chartboost.sdk.impl.w7.b(r4, r5)
            java.lang.String r4 = r0.f17672b
            if (r4 != 0) goto L_0x0052
            java.lang.String r4 = ""
            goto L_0x0057
        L_0x0052:
            java.lang.String r5 = "asset.filename ?: \"\""
            kotlin.jvm.internal.Intrinsics.e(r4, r5)
        L_0x0057:
            r3.a((java.lang.String) r6, (java.lang.String) r4)
            com.chartboost.sdk.internal.Model.CBError$CBImpressionError r4 = com.chartboost.sdk.internal.Model.CBError.CBImpressionError.ASSET_MISSING
            return r4
        L_0x005d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.n6.a(com.chartboost.sdk.impl.v, java.io.File, java.lang.String):com.chartboost.sdk.internal.Model.CBError$CBImpressionError");
    }

    public final String a(eb ebVar, v vVar, File file, String str) {
        f1 f2 = vVar.f();
        String a2 = f2.a();
        if (a2 == null || a2.length() == 0) {
            String a3 = o6.f18290a;
            Intrinsics.e(a3, "TAG");
            w7.b(a3, "AdUnit does not have a template body");
            return null;
        }
        File a4 = f2.a(file);
        HashMap hashMap = new HashMap(vVar.s());
        if (vVar.z().length() > 0 && vVar.c().length() > 0) {
            ja jaVar = this.f18235j;
            Intrinsics.e(a4, "htmlFile");
            String a5 = jaVar.a(a4, vVar.z(), vVar.c());
            if (a5 != null) {
                return a5;
            }
        }
        if (vVar.C().length() == 0 || vVar.B().length() == 0) {
            hashMap.put("{% native_video_player %}", Constants.CASEFIRST_FALSE);
        } else {
            hashMap.put("{% native_video_player %}", "true");
        }
        for (Map.Entry entry : vVar.d().entrySet()) {
            hashMap.put(entry.getKey(), ((f1) entry.getValue()).f17672b);
        }
        Intrinsics.e(a4, "htmlFile");
        return ebVar.a(a4, hashMap, this.f18230e.b(), str);
    }

    public final void a(String str, String str2) {
        track((qb) new d4(tb.h.UNAVAILABLE_ASSET_ERROR, str2, this.f18230e.b(), str, this.f18233h, (ib) null, 32, (DefaultConstructorMarker) null));
    }
}
