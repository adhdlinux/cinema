package com.chartboost.sdk.impl;

import android.content.Context;
import com.chartboost.sdk.Mediation;
import com.google.android.gms.ads.OutOfContextTestingActivity;
import com.google.ar.core.ImageMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;

public final class k7 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f18029a;

    /* renamed from: b  reason: collision with root package name */
    public final bc f18030b;

    /* renamed from: c  reason: collision with root package name */
    public final v5 f18031c;

    /* renamed from: d  reason: collision with root package name */
    public final w2 f18032d;

    /* renamed from: e  reason: collision with root package name */
    public final dd f18033e;

    /* renamed from: f  reason: collision with root package name */
    public final Mediation f18034f;

    /* renamed from: g  reason: collision with root package name */
    public final q2 f18035g;

    /* renamed from: h  reason: collision with root package name */
    public final p8 f18036h;

    /* renamed from: i  reason: collision with root package name */
    public final a5 f18037i;

    public k7(Context context, bc bcVar, v5 v5Var, w2 w2Var, dd ddVar, Mediation mediation, q2 q2Var, p8 p8Var, a5 a5Var) {
        Intrinsics.f(context, "context");
        Intrinsics.f(bcVar, "uiPoster");
        Intrinsics.f(v5Var, "fileCache");
        Intrinsics.f(w2Var, "templateProxy");
        Intrinsics.f(ddVar, "videoRepository");
        Intrinsics.f(q2Var, "networkService");
        Intrinsics.f(p8Var, "openMeasurementImpressionCallback");
        Intrinsics.f(a5Var, "eventTracker");
        this.f18029a = context;
        this.f18030b = bcVar;
        this.f18031c = v5Var;
        this.f18032d = w2Var;
        this.f18033e = ddVar;
        this.f18034f = mediation;
        this.f18035g = q2Var;
        this.f18036h = p8Var;
        this.f18037i = a5Var;
    }

    public final y2 a(String str, v vVar, String str2, String str3, k0 k0Var, d7 d7Var, od odVar, c8 c8Var) {
        Intrinsics.f(str, "location");
        Intrinsics.f(vVar, OutOfContextTestingActivity.AD_UNIT_KEY);
        Intrinsics.f(str2, "adTypeTraitsName");
        Intrinsics.f(str3, "html");
        Intrinsics.f(k0Var, "adUnitRendererImpressionCallback");
        Intrinsics.f(d7Var, "impressionInterface");
        Intrinsics.f(odVar, "webViewTimeoutInterface");
        Intrinsics.f(c8Var, "nativeBridgeCommand");
        if (vVar.C().length() > 0) {
            cd cdVar = r2;
            cd cdVar2 = new cd(this.f18029a, str, vVar.q(), str2, this.f18030b, this.f18031c, this.f18032d, this.f18033e, vVar.B(), this.f18034f, i3.f17882b.d().c(), this.f18035g, str3, this.f18036h, k0Var, d7Var, odVar, c8Var, this.f18037i, (Function1) null, ImageMetadata.LENS_APERTURE, (DefaultConstructorMarker) null);
            return cdVar;
        } else if (vVar.u() == aa.HTML) {
            z1 z1Var = r2;
            z1 z1Var2 = new z1(this.f18029a, str, vVar.q(), str2, this.f18031c, this.f18035g, this.f18030b, this.f18032d, this.f18034f, vVar.e(), vVar.j(), vVar.n(), this.f18036h, k0Var, d7Var, odVar, vVar.x(), this.f18037i, (CoroutineDispatcher) null, (Function1) null, 786432, (DefaultConstructorMarker) null);
            return z1Var;
        } else {
            return new j2(this.f18029a, str, vVar.q(), str2, this.f18031c, this.f18035g, this.f18030b, this.f18032d, this.f18034f, str3, this.f18036h, k0Var, d7Var, odVar, c8Var, this.f18037i);
        }
    }
}
