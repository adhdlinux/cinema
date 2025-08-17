package com.chartboost.sdk.impl;

import android.os.Build;
import android.os.Handler;
import b0.o0;
import b0.p0;
import b0.q0;
import com.chartboost.sdk.ads.Ad;
import com.chartboost.sdk.ads.Interstitial;
import com.chartboost.sdk.callbacks.AdCallback;
import com.chartboost.sdk.callbacks.InterstitialCallback;
import com.chartboost.sdk.events.CacheError;
import com.chartboost.sdk.events.CacheEvent;
import com.chartboost.sdk.events.ShowError;
import com.chartboost.sdk.events.ShowEvent;
import com.chartboost.sdk.impl.tb;
import com.chartboost.sdk.impl.u;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

public final class t7 extends c {

    /* renamed from: l  reason: collision with root package name */
    public final y f18631l;

    /* renamed from: m  reason: collision with root package name */
    public final h0 f18632m;

    /* renamed from: n  reason: collision with root package name */
    public final Handler f18633n;

    public static final class a extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public static final a f18634b = new a();

        public a() {
            super(0);
        }

        /* renamed from: a */
        public final Integer invoke() {
            return Integer.valueOf(Build.VERSION.SDK_INT);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ t7(y yVar, h0 h0Var, Handler handler, AtomicReference atomicReference, ScheduledExecutorService scheduledExecutorService, d dVar, ta taVar, q1 q1Var, a5 a5Var, Function0 function0, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(yVar, h0Var, handler, atomicReference, scheduledExecutorService, dVar, taVar, q1Var, a5Var, (i2 & 512) != 0 ? a.f18634b : function0);
    }

    public static final void c(InterstitialCallback interstitialCallback, Interstitial interstitial) {
        Intrinsics.f(interstitialCallback, "$callback");
        Intrinsics.f(interstitial, "$ad");
        interstitialCallback.onAdShown(new ShowEvent((String) null, interstitial), new ShowError(ShowError.Code.NO_CACHED_AD, (Exception) null, 2, (DefaultConstructorMarker) null));
    }

    public final void a(Interstitial interstitial, InterstitialCallback interstitialCallback) {
        Intrinsics.f(interstitial, "ad");
        Intrinsics.f(interstitialCallback, "callback");
        a(interstitial, interstitialCallback, (String) null);
    }

    public final void b(Interstitial interstitial, InterstitialCallback interstitialCallback) {
        Intrinsics.f(interstitial, "ad");
        Intrinsics.f(interstitialCallback, "callback");
        if (g(interstitial.getLocation())) {
            this.f18633n.post(new o0(interstitialCallback, interstitial));
            a((tb) tb.h.FINISH_FAILURE, "Invalid configuration. Check logs for more details.", (u) u.b.f18736g, interstitial.getLocation());
        } else if (!b()) {
            this.f18633n.post(new p0(interstitialCallback, interstitial));
        } else {
            a((Ad) interstitial, (AdCallback) interstitialCallback);
        }
    }

    public final void a(Interstitial interstitial, InterstitialCallback interstitialCallback, String str) {
        Intrinsics.f(interstitial, "ad");
        Intrinsics.f(interstitialCallback, "callback");
        if (g(interstitial.getLocation())) {
            this.f18633n.post(new q0(interstitialCallback, interstitial));
            a((tb) tb.a.FINISH_FAILURE, "Invalid configuration. Check logs for more details.", (u) u.b.f18736g, interstitial.getLocation());
            return;
        }
        a(interstitial.getLocation(), (Ad) interstitial, (AdCallback) interstitialCallback, str);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public t7(com.chartboost.sdk.impl.y r15, com.chartboost.sdk.impl.h0 r16, android.os.Handler r17, java.util.concurrent.atomic.AtomicReference r18, java.util.concurrent.ScheduledExecutorService r19, com.chartboost.sdk.impl.d r20, com.chartboost.sdk.impl.ta r21, com.chartboost.sdk.impl.q1 r22, com.chartboost.sdk.impl.a5 r23, kotlin.jvm.functions.Function0 r24) {
        /*
            r14 = this;
            r10 = r14
            r11 = r15
            r12 = r16
            r13 = r17
            java.lang.String r0 = "adUnitLoader"
            kotlin.jvm.internal.Intrinsics.f(r15, r0)
            java.lang.String r0 = "adUnitRenderer"
            kotlin.jvm.internal.Intrinsics.f(r12, r0)
            java.lang.String r0 = "uiHandler"
            kotlin.jvm.internal.Intrinsics.f(r13, r0)
            java.lang.String r0 = "sdkConfig"
            r3 = r18
            kotlin.jvm.internal.Intrinsics.f(r3, r0)
            java.lang.String r0 = "backgroundExecutorService"
            r4 = r19
            kotlin.jvm.internal.Intrinsics.f(r4, r0)
            java.lang.String r0 = "adApiCallbackSender"
            r5 = r20
            kotlin.jvm.internal.Intrinsics.f(r5, r0)
            java.lang.String r0 = "session"
            r6 = r21
            kotlin.jvm.internal.Intrinsics.f(r6, r0)
            java.lang.String r0 = "base64Wrapper"
            r7 = r22
            kotlin.jvm.internal.Intrinsics.f(r7, r0)
            java.lang.String r0 = "eventTracker"
            r8 = r23
            kotlin.jvm.internal.Intrinsics.f(r8, r0)
            java.lang.String r0 = "androidVersion"
            r9 = r24
            kotlin.jvm.internal.Intrinsics.f(r9, r0)
            r0 = r14
            r1 = r15
            r2 = r16
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r10.f18631l = r11
            r10.f18632m = r12
            r10.f18633n = r13
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.t7.<init>(com.chartboost.sdk.impl.y, com.chartboost.sdk.impl.h0, android.os.Handler, java.util.concurrent.atomic.AtomicReference, java.util.concurrent.ScheduledExecutorService, com.chartboost.sdk.impl.d, com.chartboost.sdk.impl.ta, com.chartboost.sdk.impl.q1, com.chartboost.sdk.impl.a5, kotlin.jvm.functions.Function0):void");
    }

    public static final void a(InterstitialCallback interstitialCallback, Interstitial interstitial) {
        Intrinsics.f(interstitialCallback, "$callback");
        Intrinsics.f(interstitial, "$ad");
        interstitialCallback.onAdLoaded(new CacheEvent((String) null, interstitial), new CacheError(CacheError.Code.SESSION_NOT_STARTED, (Exception) null, 2, (DefaultConstructorMarker) null));
    }

    public static final void b(InterstitialCallback interstitialCallback, Interstitial interstitial) {
        Intrinsics.f(interstitialCallback, "$callback");
        Intrinsics.f(interstitial, "$ad");
        interstitialCallback.onAdShown(new ShowEvent((String) null, interstitial), new ShowError(ShowError.Code.SESSION_NOT_STARTED, (Exception) null, 2, (DefaultConstructorMarker) null));
    }
}
