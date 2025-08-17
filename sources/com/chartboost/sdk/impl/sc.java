package com.chartboost.sdk.impl;

import android.content.Context;
import android.view.SurfaceView;
import android.widget.FrameLayout;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

public final class sc extends ia {

    /* renamed from: f  reason: collision with root package name */
    public SurfaceView f18600f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f18601g;

    public static final class a extends Lambda implements Function1 {

        /* renamed from: b  reason: collision with root package name */
        public static final a f18602b = new a();

        public a() {
            super(1);
        }

        /* renamed from: a */
        public final z2 invoke(Context context) {
            Intrinsics.f(context, "it");
            return new z2(context);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ sc(android.content.Context r13, java.lang.String r14, com.chartboost.sdk.impl.f4 r15, com.chartboost.sdk.impl.c8 r16, java.lang.String r17, android.view.SurfaceView r18, android.widget.FrameLayout r19, com.chartboost.sdk.impl.z4 r20, kotlin.jvm.functions.Function1 r21, int r22, kotlin.jvm.internal.DefaultConstructorMarker r23) {
        /*
            r12 = this;
            r0 = r22
            r1 = r0 & 64
            if (r1 == 0) goto L_0x000e
            android.widget.FrameLayout r1 = new android.widget.FrameLayout
            r3 = r13
            r1.<init>(r13)
            r9 = r1
            goto L_0x0011
        L_0x000e:
            r3 = r13
            r9 = r19
        L_0x0011:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0019
            com.chartboost.sdk.impl.sc$a r0 = com.chartboost.sdk.impl.sc.a.f18602b
            r11 = r0
            goto L_0x001b
        L_0x0019:
            r11 = r21
        L_0x001b:
            r2 = r12
            r3 = r13
            r4 = r14
            r5 = r15
            r6 = r16
            r7 = r17
            r8 = r18
            r10 = r20
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.sc.<init>(android.content.Context, java.lang.String, com.chartboost.sdk.impl.f4, com.chartboost.sdk.impl.c8, java.lang.String, android.view.SurfaceView, android.widget.FrameLayout, com.chartboost.sdk.impl.z4, kotlin.jvm.functions.Function1, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final void b() {
        SurfaceView surfaceView = this.f18600f;
        if (surfaceView != null) {
            surfaceView.setVisibility(8);
            this.f18601g.removeView(this.f18600f);
            removeView(this.f18601g);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public sc(android.content.Context r16, java.lang.String r17, com.chartboost.sdk.impl.f4 r18, com.chartboost.sdk.impl.c8 r19, java.lang.String r20, android.view.SurfaceView r21, android.widget.FrameLayout r22, com.chartboost.sdk.impl.z4 r23, kotlin.jvm.functions.Function1 r24) {
        /*
            r15 = this;
            r11 = r15
            r12 = r21
            r13 = r22
            java.lang.String r0 = "context"
            r1 = r16
            kotlin.jvm.internal.Intrinsics.f(r1, r0)
            java.lang.String r0 = "html"
            r2 = r17
            kotlin.jvm.internal.Intrinsics.f(r2, r0)
            java.lang.String r0 = "callback"
            r14 = r18
            kotlin.jvm.internal.Intrinsics.f(r14, r0)
            java.lang.String r0 = "nativeBridgeCommand"
            r5 = r19
            kotlin.jvm.internal.Intrinsics.f(r5, r0)
            java.lang.String r0 = "videoBackground"
            kotlin.jvm.internal.Intrinsics.f(r13, r0)
            java.lang.String r0 = "eventTracker"
            r7 = r23
            kotlin.jvm.internal.Intrinsics.f(r7, r0)
            java.lang.String r0 = "cbWebViewFactory"
            r8 = r24
            kotlin.jvm.internal.Intrinsics.f(r8, r0)
            r6 = 0
            r9 = 32
            r10 = 0
            r0 = r15
            r3 = r18
            r4 = r20
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r11.f18600f = r12
            r11.f18601g = r13
            if (r12 == 0) goto L_0x006e
            android.widget.FrameLayout$LayoutParams r0 = new android.widget.FrameLayout$LayoutParams
            r1 = -1
            r0.<init>(r1, r1)
            r13.setLayoutParams(r0)
            r0 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r13.setBackgroundColor(r0)
            android.widget.FrameLayout r0 = r11.f18601g
            r15.addView(r0)
            android.widget.FrameLayout r0 = r11.f18601g
            android.view.SurfaceView r1 = r11.f18600f
            r0.addView(r1)
            android.widget.RelativeLayout r0 = r15.getWebViewContainer()
            r15.addView(r0)
            r18.a()
            r18.b()
            return
        L_0x006e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "SurfaceView is not ready. Cannot display video."
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.sc.<init>(android.content.Context, java.lang.String, com.chartboost.sdk.impl.f4, com.chartboost.sdk.impl.c8, java.lang.String, android.view.SurfaceView, android.widget.FrameLayout, com.chartboost.sdk.impl.z4, kotlin.jvm.functions.Function1):void");
    }
}
