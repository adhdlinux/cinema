package com.chartboost.sdk.impl;

import android.os.Build;
import android.os.Handler;
import b0.v;
import b0.w;
import b0.x;
import com.chartboost.sdk.ads.Ad;
import com.chartboost.sdk.ads.Rewarded;
import com.chartboost.sdk.callbacks.AdCallback;
import com.chartboost.sdk.callbacks.RewardedCallback;
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

public final class ha extends c {

    /* renamed from: l  reason: collision with root package name */
    public final y f17867l;

    /* renamed from: m  reason: collision with root package name */
    public final h0 f17868m;

    /* renamed from: n  reason: collision with root package name */
    public final Handler f17869n;

    public static final class a extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public static final a f17870b = new a();

        public a() {
            super(0);
        }

        /* renamed from: a */
        public final Integer invoke() {
            return Integer.valueOf(Build.VERSION.SDK_INT);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ha(y yVar, h0 h0Var, Handler handler, AtomicReference atomicReference, ScheduledExecutorService scheduledExecutorService, d dVar, ta taVar, q1 q1Var, a5 a5Var, Function0 function0, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(yVar, h0Var, handler, atomicReference, scheduledExecutorService, dVar, taVar, q1Var, a5Var, (i2 & 512) != 0 ? a.f17870b : function0);
    }

    public static final void c(RewardedCallback rewardedCallback, Rewarded rewarded) {
        Intrinsics.f(rewardedCallback, "$callback");
        Intrinsics.f(rewarded, "$ad");
        rewardedCallback.onAdShown(new ShowEvent((String) null, rewarded), new ShowError(ShowError.Code.NO_CACHED_AD, (Exception) null, 2, (DefaultConstructorMarker) null));
    }

    public final void a(Rewarded rewarded, RewardedCallback rewardedCallback) {
        Intrinsics.f(rewarded, "ad");
        Intrinsics.f(rewardedCallback, "callback");
        a(rewarded, rewardedCallback, (String) null);
    }

    public final void b(Rewarded rewarded, RewardedCallback rewardedCallback) {
        Intrinsics.f(rewarded, "ad");
        Intrinsics.f(rewardedCallback, "callback");
        if (g(rewarded.getLocation())) {
            this.f17869n.post(new v(rewardedCallback, rewarded));
            a((tb) tb.h.FINISH_FAILURE, "Invalid configuration. Check logs for more details.", (u) u.c.f18737g, rewarded.getLocation());
        } else if (!b()) {
            this.f17869n.post(new w(rewardedCallback, rewarded));
        } else {
            a((Ad) rewarded, (AdCallback) rewardedCallback);
        }
    }

    public final void a(Rewarded rewarded, RewardedCallback rewardedCallback, String str) {
        Intrinsics.f(rewarded, "ad");
        Intrinsics.f(rewardedCallback, "callback");
        if (g(rewarded.getLocation())) {
            this.f17869n.post(new x(rewardedCallback, rewarded));
            a((tb) tb.a.FINISH_FAILURE, "Invalid configuration. Check logs for more details.", (u) u.c.f18737g, rewarded.getLocation());
            return;
        }
        a(rewarded.getLocation(), (Ad) rewarded, (AdCallback) rewardedCallback, str);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ha(com.chartboost.sdk.impl.y r15, com.chartboost.sdk.impl.h0 r16, android.os.Handler r17, java.util.concurrent.atomic.AtomicReference r18, java.util.concurrent.ScheduledExecutorService r19, com.chartboost.sdk.impl.d r20, com.chartboost.sdk.impl.ta r21, com.chartboost.sdk.impl.q1 r22, com.chartboost.sdk.impl.a5 r23, kotlin.jvm.functions.Function0 r24) {
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
            r10.f17867l = r11
            r10.f17868m = r12
            r10.f17869n = r13
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.ha.<init>(com.chartboost.sdk.impl.y, com.chartboost.sdk.impl.h0, android.os.Handler, java.util.concurrent.atomic.AtomicReference, java.util.concurrent.ScheduledExecutorService, com.chartboost.sdk.impl.d, com.chartboost.sdk.impl.ta, com.chartboost.sdk.impl.q1, com.chartboost.sdk.impl.a5, kotlin.jvm.functions.Function0):void");
    }

    public static final void a(RewardedCallback rewardedCallback, Rewarded rewarded) {
        Intrinsics.f(rewardedCallback, "$callback");
        Intrinsics.f(rewarded, "$ad");
        rewardedCallback.onAdLoaded(new CacheEvent((String) null, rewarded), new CacheError(CacheError.Code.SESSION_NOT_STARTED, (Exception) null, 2, (DefaultConstructorMarker) null));
    }

    public static final void b(RewardedCallback rewardedCallback, Rewarded rewarded) {
        Intrinsics.f(rewardedCallback, "$callback");
        Intrinsics.f(rewarded, "$ad");
        rewardedCallback.onAdShown(new ShowEvent((String) null, rewarded), new ShowError(ShowError.Code.SESSION_NOT_STARTED, (Exception) null, 2, (DefaultConstructorMarker) null));
    }
}
