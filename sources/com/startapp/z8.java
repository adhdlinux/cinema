package com.startapp;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.startapp.a9;
import com.startapp.c9;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeBase;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class z8 {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, z8> f36994a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public static final z8 f36995b;

    /* renamed from: c  reason: collision with root package name */
    public static final z8 f36996c;

    /* renamed from: d  reason: collision with root package name */
    public static final z8 f36997d;

    /* renamed from: e  reason: collision with root package name */
    public static final z8 f36998e;

    /* renamed from: f  reason: collision with root package name */
    public static final z8 f36999f;

    /* renamed from: g  reason: collision with root package name */
    public static final z8 f37000g;

    /* renamed from: h  reason: collision with root package name */
    public static final z8 f37001h;

    /* renamed from: i  reason: collision with root package name */
    public static final z8 f37002i;

    /* renamed from: j  reason: collision with root package name */
    public static final z8 f37003j;

    /* renamed from: k  reason: collision with root package name */
    public static final z8 f37004k;

    /* renamed from: l  reason: collision with root package name */
    public static final z8 f37005l;

    /* renamed from: m  reason: collision with root package name */
    public static final z8 f37006m;

    /* renamed from: n  reason: collision with root package name */
    public static final z8 f37007n;

    /* renamed from: o  reason: collision with root package name */
    public final String f37008o;

    /* renamed from: p  reason: collision with root package name */
    public final a9 f37009p;

    static {
        a9.a aVar = new a9.a();
        aVar.f34202b = 23;
        aVar.f34203c = 50;
        aVar.f34204d = true;
        c9.a aVar2 = new c9.a();
        String[] strArr = {MobileAdsBridgeBase.initializeMethodName};
        List list = aVar2.f34295a;
        if (list == null) {
            list = new ArrayList();
            aVar2.f34295a = list;
        }
        c9.a a2 = aVar2.a(strArr, list).a(AppMeasurementSdk.ConditionalUserProperty.VALUE);
        a2.f34298d = "8h";
        a9.a a3 = aVar.a(new c9(a2));
        c9.a a4 = new c9.a().a(AppMeasurementSdk.ConditionalUserProperty.VALUE, "details");
        a4.f34298d = "30m";
        a9.a a5 = a3.a(new c9(a4));
        c9.a a6 = new c9.a().a(AppMeasurementSdk.ConditionalUserProperty.VALUE);
        a6.f34298d = "10s";
        a9.a a7 = a5.a(new c9(a6));
        a7.f34205e = "2h";
        a7.f34206f = "2s";
        f36995b = new z8("general", new a9(a7));
        a9.a aVar3 = new a9.a();
        aVar3.f34202b = 17;
        aVar3.f34203c = 20;
        aVar3.f34204d = true;
        c9.a aVar4 = new c9.a();
        String[] strArr2 = {"fake_click"};
        List list2 = aVar4.f34296b;
        if (list2 == null) {
            list2 = new ArrayList();
            aVar4.f34296b = list2;
        }
        c9.a a8 = aVar4.a(strArr2, list2).a("appActivity", AppMeasurementSdk.ConditionalUserProperty.VALUE, "details");
        a8.f34298d = "30m";
        a9.a a9 = aVar3.a(new c9(a8));
        c9.a aVar5 = new c9.a();
        String[] strArr3 = {"fake_click"};
        List list3 = aVar5.f34296b;
        if (list3 == null) {
            list3 = new ArrayList();
            aVar5.f34296b = list3;
        }
        c9.a a10 = aVar5.a(strArr3, list3).a("appActivity", AppMeasurementSdk.ConditionalUserProperty.VALUE);
        a10.f34298d = "10s";
        a9.a a11 = a9.a(new c9(a10));
        a11.f34205e = "4h";
        a11.f34206f = "5s";
        f36996c = new z8(MRAIDPresenter.ERROR, new a9(a11));
        a9.a aVar6 = new a9.a();
        aVar6.f34201a = 0.0d;
        aVar6.f34202b = 17;
        aVar6.f34203c = 30;
        aVar6.f34204d = true;
        c9.a a12 = new c9.a().a("appActivity", AppMeasurementSdk.ConditionalUserProperty.VALUE, "details");
        a12.f34298d = "12h";
        a9.a a13 = aVar6.a(new c9(a12));
        c9.a a14 = new c9.a().a("appActivity", AppMeasurementSdk.ConditionalUserProperty.VALUE);
        a14.f34298d = "1h";
        a9.a a15 = a13.a(new c9(a14));
        a15.f34205e = "1d";
        a15.f34206f = "5s";
        a9 a9Var = new a9(a15);
        f36997d = new z8("exception", a9Var);
        f36998e = new z8("exception_nt", a9Var);
        a9.a aVar7 = new a9.a();
        aVar7.f34202b = 17;
        aVar7.f34203c = 40;
        aVar7.f34204d = true;
        c9.a a16 = new c9.a().a(AppMeasurementSdk.ConditionalUserProperty.VALUE, "details");
        a16.f34298d = "1h";
        a9.a a17 = aVar7.a(new c9(a16));
        a17.f34205e = "2d";
        a17.f34206f = "5s";
        f36999f = new z8("exception_fatal", new a9(a17));
        f37000g = new z8("anr", a9Var);
        a9.a aVar8 = new a9.a();
        aVar8.f34201a = 0.0d;
        aVar8.f34202b = 17;
        aVar8.f34203c = 10;
        aVar8.f34204d = false;
        aVar8.f34206f = "10s";
        f37001h = new z8("netdiag", new a9(aVar8));
        a9.a aVar9 = new a9.a();
        aVar9.f34202b = 3071;
        aVar9.f34203c = 90;
        aVar9.f34204d = true;
        c9.a a18 = new c9.a().a("service");
        a18.f34298d = "1m";
        a9.a a19 = aVar9.a(new c9(a18));
        a19.f34205e = "1h";
        f37002i = new z8("periodic", new a9(a19));
        a9.a aVar10 = new a9.a();
        aVar10.f34201a = 0.0d;
        aVar10.f34202b = 17;
        aVar10.f34203c = 60;
        aVar10.f34204d = true;
        aVar10.f34205e = "1d";
        aVar10.f34206f = "5s";
        f37003j = new z8("success_smart_redirect_hop_info", new a9(aVar10));
        a9.a aVar11 = new a9.a();
        aVar11.f34202b = 17;
        aVar11.f34203c = 70;
        aVar11.f34204d = false;
        f37004k = new z8("triggeredLink", new a9(aVar11));
        a9.a aVar12 = new a9.a();
        aVar12.f34202b = 23;
        aVar12.f34203c = 80;
        aVar12.f34204d = true;
        aVar12.f34205e = "1d";
        f37005l = new z8("ct", new a9(aVar12));
        a9.a aVar13 = new a9.a();
        aVar13.f34202b = 23;
        aVar13.f34203c = 80;
        aVar13.f34204d = true;
        aVar13.f34205e = "1d";
        f37006m = new z8("lt", new a9(aVar13));
        a9.a aVar14 = new a9.a();
        aVar14.f34202b = 23;
        aVar14.f34203c = 80;
        aVar14.f34204d = true;
        aVar14.f34205e = "1d";
        f37007n = new z8("nir", new a9(aVar14));
    }

    public z8(String str, a9 a9Var) {
        this.f37008o = str;
        this.f37009p = a9Var;
        f36994a.put(str, this);
    }

    public String a() {
        return this.f37008o;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || z8.class != obj.getClass()) {
            return false;
        }
        return lb.a(this.f37008o, ((z8) obj).f37008o);
    }

    public int hashCode() {
        return this.f37008o.hashCode();
    }

    public String toString() {
        return this.f37008o;
    }

    public static z8 a(String str) {
        return f36994a.get(str);
    }
}
