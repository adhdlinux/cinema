package com.chartboost.sdk.impl;

import android.os.Build;
import com.chartboost.sdk.Mediation;
import com.chartboost.sdk.impl.l;
import com.chartboost.sdk.impl.tb;
import com.chartboost.sdk.internal.Model.CBError;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONException;
import org.json.JSONObject;

public final class b9 implements l, a5 {

    /* renamed from: a  reason: collision with root package name */
    public final u f17294a;

    /* renamed from: b  reason: collision with root package name */
    public final s4 f17295b;

    /* renamed from: c  reason: collision with root package name */
    public final x8 f17296c;

    /* renamed from: d  reason: collision with root package name */
    public final Function1 f17297d;

    /* renamed from: e  reason: collision with root package name */
    public final Function0 f17298e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ a5 f17299f;

    public /* synthetic */ class a extends FunctionReferenceImpl implements Function1 {

        /* renamed from: b  reason: collision with root package name */
        public static final a f17300b = new a();

        public a() {
            super(1, JSONObject.class, "<init>", "<init>(Ljava/lang/String;)V", 0);
        }

        /* renamed from: a */
        public final JSONObject invoke(String str) {
            return new JSONObject(str);
        }
    }

    public static final class b extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public static final b f17301b = new b();

        public b() {
            super(0);
        }

        /* renamed from: a */
        public final Integer invoke() {
            return Integer.valueOf(Build.VERSION.SDK_INT);
        }
    }

    public b9(u uVar, s4 s4Var, x8 x8Var, Function1 function1, Function0 function0, a5 a5Var) {
        Intrinsics.f(uVar, "adType");
        Intrinsics.f(s4Var, "downloader");
        Intrinsics.f(x8Var, "openRTBAdUnitParser");
        Intrinsics.f(function1, "jsonFactory");
        Intrinsics.f(function0, "androidVersion");
        Intrinsics.f(a5Var, "eventTracker");
        this.f17294a = uVar;
        this.f17295b = s4Var;
        this.f17296c = x8Var;
        this.f17297d = function1;
        this.f17298e = function0;
        this.f17299f = a5Var;
    }

    public String a(JSONObject jSONObject, String str, String str2) {
        return l.a.a(this, jSONObject, str, str2);
    }

    public final void b(Function1 function1, u7 u7Var) {
        tb.a aVar = tb.a.BID_RESPONSE_PARSING_ERROR;
        String d2 = u7Var.a().d();
        String c2 = u7Var.a().c();
        if (c2 == null) {
            c2 = "";
        }
        a(aVar, d2, c2, "Invalid bid response");
        function1.invoke(new v7(u7Var.a(), (v) null, new CBError(CBError.a.UNEXPECTED_RESPONSE, "Error parsing response"), 0, 0, 26, (DefaultConstructorMarker) null));
    }

    public final void c(Function1 function1, u7 u7Var) {
        b1 a2 = u7Var.a();
        CBError.a aVar = CBError.a.UNSUPPORTED_OS_VERSION;
        function1.invoke(new v7(a2, (v) null, new CBError(aVar, "Unsupported Android version " + Build.VERSION.SDK_INT), 0, 0, 26, (DefaultConstructorMarker) null));
    }

    public void clear(String str, String str2) {
        Intrinsics.f(str, "type");
        Intrinsics.f(str2, "location");
        this.f17299f.clear(str, str2);
    }

    public qb clearFromStorage(qb qbVar) {
        Intrinsics.f(qbVar, "<this>");
        return this.f17299f.clearFromStorage(qbVar);
    }

    public qb persist(qb qbVar) {
        Intrinsics.f(qbVar, "<this>");
        return this.f17299f.persist(qbVar);
    }

    public ob refresh(ob obVar) {
        Intrinsics.f(obVar, "<this>");
        return this.f17299f.refresh(obVar);
    }

    public ib store(ib ibVar) {
        Intrinsics.f(ibVar, "<this>");
        return this.f17299f.store(ibVar);
    }

    public qb track(qb qbVar) {
        Intrinsics.f(qbVar, "<this>");
        return this.f17299f.track(qbVar);
    }

    public void a(u7 u7Var, Function1 function1) {
        Intrinsics.f(u7Var, "params");
        Intrinsics.f(function1, "callback");
        if (((Number) this.f17298e.invoke()).intValue() < 21) {
            c(function1, u7Var);
        } else if (!a(u7Var)) {
            b(function1, u7Var);
        } else {
            try {
                String c2 = u7Var.a().c();
                a(u7Var, this.f17296c.a(this.f17294a, c2 != null ? (JSONObject) this.f17297d.invoke(c2) : null), function1);
            } catch (JSONException e2) {
                a(function1, u7Var, (Exception) e2);
            }
        }
    }

    /* renamed from: clearFromStorage  reason: collision with other method in class */
    public void m6clearFromStorage(qb qbVar) {
        Intrinsics.f(qbVar, "event");
        this.f17299f.clearFromStorage(qbVar);
    }

    /* renamed from: persist  reason: collision with other method in class */
    public void m7persist(qb qbVar) {
        Intrinsics.f(qbVar, "event");
        this.f17299f.persist(qbVar);
    }

    /* renamed from: refresh  reason: collision with other method in class */
    public void m8refresh(ob obVar) {
        Intrinsics.f(obVar, "config");
        this.f17299f.refresh(obVar);
    }

    /* renamed from: store  reason: collision with other method in class */
    public void m9store(ib ibVar) {
        Intrinsics.f(ibVar, "ad");
        this.f17299f.store(ibVar);
    }

    /* renamed from: track  reason: collision with other method in class */
    public void m10track(qb qbVar) {
        Intrinsics.f(qbVar, "event");
        this.f17299f.track(qbVar);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b9(u uVar, s4 s4Var, x8 x8Var, Function1 function1, Function0 function0, a5 a5Var, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(uVar, s4Var, x8Var, (i2 & 8) != 0 ? a.f17300b : function1, (i2 & 16) != 0 ? b.f17301b : function0, a5Var);
    }

    public final void a(Function1 function1, u7 u7Var, Exception exc) {
        tb.a aVar = tb.a.BID_RESPONSE_PARSING_ERROR;
        String d2 = u7Var.a().d();
        String c2 = u7Var.a().c();
        if (c2 == null) {
            c2 = "";
        }
        a(aVar, d2, c2, exc.toString());
        function1.invoke(new v7(u7Var.a(), (v) null, new CBError(CBError.a.INVALID_RESPONSE, "Error parsing response"), 0, 0, 26, (DefaultConstructorMarker) null));
    }

    public final void a(u7 u7Var, v vVar, Function1 function1) {
        a(this.f17295b, vVar, (g1) new b0.b(this, function1, u7Var, vVar));
    }

    public static final void a(b9 b9Var, Function1 function1, u7 u7Var, v vVar, boolean z2) {
        Intrinsics.f(b9Var, "this$0");
        Intrinsics.f(function1, "$callback");
        Intrinsics.f(u7Var, "$loaderParams");
        Intrinsics.f(vVar, "$openRTBAdUnit");
        if (z2) {
            b9Var.a(function1, u7Var, vVar);
        } else {
            b9Var.a(function1, u7Var);
        }
    }

    public final void a(Function1 function1, u7 u7Var, v vVar) {
        function1.invoke(new v7(u7Var.a(), vVar, (CBError) null, 0, 0, 24, (DefaultConstructorMarker) null));
    }

    public final void a(Function1 function1, u7 u7Var) {
        tb.a aVar = tb.a.ASSET_DOWNLOAD_ERROR;
        String d2 = u7Var.a().d();
        String c2 = u7Var.a().c();
        if (c2 == null) {
            c2 = "";
        }
        a(aVar, d2, c2, "ASSETS_DOWNLOAD_FAILURE");
        function1.invoke(new v7(u7Var.a(), (v) null, new CBError(CBError.a.INVALID_RESPONSE, "Error parsing response"), 0, 0, 26, (DefaultConstructorMarker) null));
    }

    public final void a(s4 s4Var, v vVar, g1 g1Var) {
        Map d2 = vVar.d();
        AtomicInteger atomicInteger = new AtomicInteger();
        s4Var.c();
        s4Var.a(i9.HIGH, d2, atomicInteger, g1Var, this.f17294a.b());
    }

    public final void a(tb tbVar, String str, String str2, String str3) {
        track((qb) new d4(tbVar, a(new JSONObject(), str3, str2), this.f17294a.b(), str, (Mediation) null, (ib) null, 48, (DefaultConstructorMarker) null));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000e, code lost:
        r2 = r2.a().c();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(com.chartboost.sdk.impl.u7 r2) {
        /*
            r1 = this;
            com.chartboost.sdk.impl.b1 r0 = r2.a()
            java.lang.String r0 = r0.d()
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x0020
            com.chartboost.sdk.impl.b1 r2 = r2.a()
            java.lang.String r2 = r2.c()
            if (r2 == 0) goto L_0x0020
            int r2 = r2.length()
            if (r2 <= 0) goto L_0x0020
            r2 = 1
            goto L_0x0021
        L_0x0020:
            r2 = 0
        L_0x0021:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.b9.a(com.chartboost.sdk.impl.u7):boolean");
    }
}
