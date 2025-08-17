package com.chartboost.sdk.impl;

import com.chartboost.sdk.internal.Libraries.CBUtility;
import com.chartboost.sdk.internal.Model.CBError;
import java.io.File;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

public final class id extends l2 {

    /* renamed from: k  reason: collision with root package name */
    public final r2 f17960k;

    /* renamed from: l  reason: collision with root package name */
    public final a f17961l;

    /* renamed from: m  reason: collision with root package name */
    public final String f17962m;

    public interface a {
        void a(String str, String str2);

        void a(String str, String str2, long j2, n0 n0Var);

        void a(String str, String str2, CBError cBError);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public id(r2 r2Var, File file, String str, a aVar, i9 i9Var, String str2) {
        super("GET", str, i9Var, file);
        Intrinsics.f(file, "outputFile");
        Intrinsics.f(str, "uri");
        Intrinsics.f(i9Var, "priority");
        Intrinsics.f(str2, "appId");
        this.f17960k = r2Var;
        this.f17961l = aVar;
        this.f17962m = str2;
        this.f18097i = 1;
    }

    public m2 a() {
        HashMap hashMap = new HashMap();
        hashMap.put("X-Chartboost-App", this.f17962m);
        String b2 = CBUtility.b();
        Intrinsics.e(b2, "getUserAgent()");
        hashMap.put("X-Chartboost-Client", b2);
        r2 r2Var = this.f17960k;
        hashMap.put("X-Chartboost-Reachability", String.valueOf(r2Var != null ? r2Var.c() : null));
        return new m2(hashMap, (byte[]) null, (String) null);
    }

    public void a(Object obj, p2 p2Var) {
        a aVar = this.f17961l;
        if (aVar != null) {
            String e2 = e();
            File file = this.f18093e;
            Intrinsics.c(file);
            String name = file.getName();
            Intrinsics.e(name, "outputFile!!.name");
            aVar.a(e2, name);
        }
    }

    public void a(CBError cBError, p2 p2Var) {
        a aVar = this.f17961l;
        if (aVar != null) {
            String e2 = e();
            File file = this.f18093e;
            Intrinsics.c(file);
            String name = file.getName();
            Intrinsics.e(name, "outputFile!!.name");
            aVar.a(e2, name, cBError);
        }
    }

    public void a(String str, long j2) {
        Intrinsics.f(str, "uri");
        a aVar = this.f17961l;
        if (aVar != null) {
            File file = this.f18093e;
            Intrinsics.c(file);
            String name = file.getName();
            Intrinsics.e(name, "outputFile!!.name");
            aVar.a(str, name, j2, (n0) null);
        }
    }
}
