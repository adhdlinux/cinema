package com.chartboost.sdk.impl;

import android.content.Context;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

public final class b8 extends ia {

    public static final class a extends Lambda implements Function1 {

        /* renamed from: b  reason: collision with root package name */
        public static final a f17293b = new a();

        public a() {
            super(1);
        }

        /* renamed from: a */
        public final z2 invoke(Context context) {
            Intrinsics.f(context, "it");
            return new z2(context);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b8(Context context, String str, f4 f4Var, String str2, c8 c8Var, z4 z4Var, Function1 function1, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, f4Var, str2, c8Var, z4Var, (i2 & 64) != 0 ? a.f17293b : function1);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public b8(android.content.Context r14, java.lang.String r15, com.chartboost.sdk.impl.f4 r16, java.lang.String r17, com.chartboost.sdk.impl.c8 r18, com.chartboost.sdk.impl.z4 r19, kotlin.jvm.functions.Function1 r20) {
        /*
            r13 = this;
            java.lang.String r0 = "context"
            r2 = r14
            kotlin.jvm.internal.Intrinsics.f(r14, r0)
            java.lang.String r0 = "html"
            r3 = r15
            kotlin.jvm.internal.Intrinsics.f(r15, r0)
            java.lang.String r0 = "callback"
            r12 = r16
            kotlin.jvm.internal.Intrinsics.f(r12, r0)
            java.lang.String r0 = "nativeBridgeCommand"
            r6 = r18
            kotlin.jvm.internal.Intrinsics.f(r6, r0)
            java.lang.String r0 = "eventTracker"
            r8 = r19
            kotlin.jvm.internal.Intrinsics.f(r8, r0)
            java.lang.String r0 = "cbWebViewFactory"
            r9 = r20
            kotlin.jvm.internal.Intrinsics.f(r9, r0)
            r7 = 0
            r10 = 32
            r11 = 0
            r1 = r13
            r4 = r16
            r5 = r17
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            android.widget.RelativeLayout r0 = r13.getWebViewContainer()
            r13.addView(r0)
            r16.a()
            r16.b()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.b8.<init>(android.content.Context, java.lang.String, com.chartboost.sdk.impl.f4, java.lang.String, com.chartboost.sdk.impl.c8, com.chartboost.sdk.impl.z4, kotlin.jvm.functions.Function1):void");
    }
}
