package com.chartboost.sdk.impl;

import android.content.Context;
import android.view.View;
import android.webkit.WebChromeClient;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

public abstract class ia extends s3 {

    public static final class a extends Lambda implements Function1 {

        /* renamed from: b  reason: collision with root package name */
        public static final a f17939b = new a();

        public a() {
            super(1);
        }

        /* renamed from: a */
        public final z2 invoke(Context context) {
            Intrinsics.f(context, "it");
            return new z2(context);
        }
    }

    public static final class b extends Lambda implements Function1 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c8 f17940b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ nd f17941c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(c8 c8Var, nd ndVar) {
            super(1);
            this.f17940b = c8Var;
            this.f17941c = ndVar;
        }

        /* renamed from: a */
        public final WebChromeClient invoke(View view) {
            Intrinsics.f(view, "container");
            return new u2(view, this.f17940b, this.f17941c);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ia(android.content.Context r12, java.lang.String r13, com.chartboost.sdk.impl.f4 r14, java.lang.String r15, com.chartboost.sdk.impl.c8 r16, com.chartboost.sdk.impl.nd r17, com.chartboost.sdk.impl.z4 r18, kotlin.jvm.functions.Function1 r19, int r20, kotlin.jvm.internal.DefaultConstructorMarker r21) {
        /*
            r11 = this;
            r0 = r20
            r1 = r0 & 32
            if (r1 == 0) goto L_0x000d
            com.chartboost.sdk.impl.nd r1 = new com.chartboost.sdk.impl.nd
            r1.<init>()
            r8 = r1
            goto L_0x000f
        L_0x000d:
            r8 = r17
        L_0x000f:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0017
            com.chartboost.sdk.impl.ia$a r0 = com.chartboost.sdk.impl.ia.a.f17939b
            r10 = r0
            goto L_0x0019
        L_0x0017:
            r10 = r19
        L_0x0019:
            r2 = r11
            r3 = r12
            r4 = r13
            r5 = r14
            r6 = r15
            r7 = r16
            r9 = r18
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.ia.<init>(android.content.Context, java.lang.String, com.chartboost.sdk.impl.f4, java.lang.String, com.chartboost.sdk.impl.c8, com.chartboost.sdk.impl.nd, com.chartboost.sdk.impl.z4, kotlin.jvm.functions.Function1, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ia(android.content.Context r15, java.lang.String r16, com.chartboost.sdk.impl.f4 r17, java.lang.String r18, com.chartboost.sdk.impl.c8 r19, com.chartboost.sdk.impl.nd r20, com.chartboost.sdk.impl.z4 r21, kotlin.jvm.functions.Function1 r22) {
        /*
            r14 = this;
            r0 = r19
            r1 = r20
            java.lang.String r2 = "context"
            r4 = r15
            kotlin.jvm.internal.Intrinsics.f(r15, r2)
            java.lang.String r2 = "html"
            r5 = r16
            kotlin.jvm.internal.Intrinsics.f(r5, r2)
            java.lang.String r2 = "callback"
            r6 = r17
            kotlin.jvm.internal.Intrinsics.f(r6, r2)
            java.lang.String r2 = "nativeBridgeCommand"
            kotlin.jvm.internal.Intrinsics.f(r0, r2)
            java.lang.String r2 = "webViewCorsErrorHandler"
            kotlin.jvm.internal.Intrinsics.f(r1, r2)
            java.lang.String r2 = "eventTracker"
            r8 = r21
            kotlin.jvm.internal.Intrinsics.f(r8, r2)
            java.lang.String r2 = "cbWebViewFactory"
            r9 = r22
            kotlin.jvm.internal.Intrinsics.f(r9, r2)
            com.chartboost.sdk.impl.ia$b r10 = new com.chartboost.sdk.impl.ia$b
            r10.<init>(r0, r1)
            r11 = 0
            r12 = 128(0x80, float:1.794E-43)
            r13 = 0
            r3 = r14
            r7 = r18
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.ia.<init>(android.content.Context, java.lang.String, com.chartboost.sdk.impl.f4, java.lang.String, com.chartboost.sdk.impl.c8, com.chartboost.sdk.impl.nd, com.chartboost.sdk.impl.z4, kotlin.jvm.functions.Function1):void");
    }
}
