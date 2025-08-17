package com.chartboost.sdk.impl;

import com.chartboost.sdk.internal.Libraries.CBUtility;
import com.chartboost.sdk.internal.Model.CBError;
import java.io.File;
import java.util.HashMap;

public class l1 extends l2 {

    /* renamed from: k  reason: collision with root package name */
    public final s4 f18084k;

    /* renamed from: l  reason: collision with root package name */
    public final r2 f18085l;

    /* renamed from: m  reason: collision with root package name */
    public final k1 f18086m;

    /* renamed from: n  reason: collision with root package name */
    public String f18087n;

    public l1(s4 s4Var, r2 r2Var, k1 k1Var, File file, String str) {
        super("GET", k1Var.f18005e, i9.NORMAL, file);
        this.f18097i = 1;
        this.f18084k = s4Var;
        this.f18085l = r2Var;
        this.f18086m = k1Var;
        this.f18087n = str;
    }

    public m2 a() {
        HashMap hashMap = new HashMap();
        hashMap.put("X-Chartboost-App", this.f18087n);
        hashMap.put("X-Chartboost-Client", CBUtility.b());
        hashMap.put("X-Chartboost-Reachability", Integer.toString(this.f18085l.c().b()));
        return new m2(hashMap, (byte[]) null, (String) null);
    }

    public void a(Void voidR, p2 p2Var) {
        this.f18084k.a(this, (CBError) null, (p2) null);
    }

    public void a(CBError cBError, p2 p2Var) {
        this.f18084k.a(this, cBError, p2Var);
    }
}
