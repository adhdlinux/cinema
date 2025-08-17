package com.chartboost.sdk.impl;

import android.content.Context;
import com.chartboost.sdk.internal.Libraries.CBUtility;
import kotlin.jvm.internal.Intrinsics;

public final class l4 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f18103a;

    public l4(Context context) {
        Intrinsics.f(context, "context");
        this.f18103a = context;
    }

    public final int a() {
        Integer b2 = m4.b(this.f18103a);
        Intrinsics.e(b2, "getOpenRTBDeviceType(context)");
        return b2.intValue();
    }

    public final String b() {
        String d2 = m4.d(this.f18103a);
        Intrinsics.e(d2, "getType(context)");
        return d2;
    }

    public final boolean c() {
        return CBUtility.a(CBUtility.a(this.f18103a));
    }
}
