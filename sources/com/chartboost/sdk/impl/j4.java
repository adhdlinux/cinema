package com.chartboost.sdk.impl;

import android.content.Context;
import android.content.pm.PackageManager;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class j4 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f17970a;

    /* renamed from: b  reason: collision with root package name */
    public final n4 f17971b;

    /* renamed from: c  reason: collision with root package name */
    public final l4 f17972c;

    public j4(Context context, n4 n4Var, l4 l4Var) {
        Intrinsics.f(context, "context");
        Intrinsics.f(n4Var, "displayMeasurement");
        Intrinsics.f(l4Var, "deviceFieldsWrapper");
        this.f17970a = context;
        this.f17971b = n4Var;
        this.f17972c = l4Var;
    }

    public final i4 a() {
        try {
            o4 a2 = this.f17971b.a();
            o4 d2 = this.f17971b.d();
            String packageName = this.f17970a.getPackageName();
            int b2 = a2.b();
            int a3 = a2.a();
            int b3 = d2.b();
            int a4 = d2.a();
            float b4 = this.f17971b.b();
            String valueOf = String.valueOf(this.f17971b.c());
            int a5 = this.f17972c.a();
            String b5 = this.f17972c.b();
            PackageManager packageManager = this.f17970a.getPackageManager();
            Intrinsics.e(packageManager, "context.packageManager");
            Intrinsics.e(packageName, "packageName");
            return new i4(b2, a3, b3, a4, b4, valueOf, a5, b5, packageName, r5.getPackageVersionName(packageManager, packageName), this.f17972c.c());
        } catch (Exception e2) {
            w7.a("toDeviceBodyFields", "Cannot create device body", e2);
            return new i4(0, 0, 0, 0, 0.0f, (String) null, 0, (String) null, (String) null, (String) null, false, 2047, (DefaultConstructorMarker) null);
        }
    }
}
