package com.chartboost.sdk.impl;

import android.content.Context;
import android.util.Log;
import kotlin.jvm.internal.Intrinsics;

public final class g6 {

    /* renamed from: a  reason: collision with root package name */
    public final b6 f17745a;

    /* renamed from: b  reason: collision with root package name */
    public final w0 f17746b;

    /* renamed from: c  reason: collision with root package name */
    public final String f17747c;

    public g6(b6 b6Var, w0 w0Var, String str) {
        Intrinsics.f(b6Var, "googleAdvertisingId");
        Intrinsics.f(w0Var, "amazonAdvertisingId");
        Intrinsics.f(str, "manufacturer");
        this.f17745a = b6Var;
        this.f17746b = w0Var;
        this.f17747c = str;
    }

    public final u0 a() {
        try {
            if (b()) {
                return this.f17746b.b();
            }
            return this.f17745a.b();
        } catch (Exception e2) {
            String a2 = h6.f17834a;
            Log.e(a2, "getAdvertisingId error: " + e2);
            return new u0(yb.TRACKING_UNKNOWN, "");
        }
    }

    public final boolean b() {
        return StringsKt__StringsJVMKt.t("Amazon", this.f17747c, true);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ g6(com.chartboost.sdk.impl.b6 r1, com.chartboost.sdk.impl.w0 r2, java.lang.String r3, int r4, kotlin.jvm.internal.DefaultConstructorMarker r5) {
        /*
            r0 = this;
            r4 = r4 & 4
            if (r4 == 0) goto L_0x000b
            java.lang.String r3 = android.os.Build.MANUFACTURER
            java.lang.String r4 = "MANUFACTURER"
            kotlin.jvm.internal.Intrinsics.e(r3, r4)
        L_0x000b:
            r0.<init>(r1, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.g6.<init>(com.chartboost.sdk.impl.b6, com.chartboost.sdk.impl.w0, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String a(Context context, boolean z2) {
        Intrinsics.f(context, "context");
        String a2 = m4.a(context, z2);
        Intrinsics.e(a2, "getUniqueId(context, isTrackingLimited)");
        return a2;
    }
}
