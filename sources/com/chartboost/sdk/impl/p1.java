package com.chartboost.sdk.impl;

import android.os.Build;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import b0.d0;
import b0.e0;
import b0.f0;
import b0.g0;
import b0.h0;
import com.chartboost.sdk.ads.Ad;
import com.chartboost.sdk.ads.Banner;
import com.chartboost.sdk.callbacks.AdCallback;
import com.chartboost.sdk.callbacks.BannerCallback;
import com.chartboost.sdk.events.CacheError;
import com.chartboost.sdk.events.CacheEvent;
import com.chartboost.sdk.events.ShowError;
import com.chartboost.sdk.events.ShowEvent;
import com.chartboost.sdk.impl.pa;
import com.chartboost.sdk.impl.tb;
import com.chartboost.sdk.impl.u;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

public final class p1 extends c {

    /* renamed from: l  reason: collision with root package name */
    public final y f18323l;

    /* renamed from: m  reason: collision with root package name */
    public final h0 f18324m;

    /* renamed from: n  reason: collision with root package name */
    public final Handler f18325n;

    /* renamed from: o  reason: collision with root package name */
    public final AtomicReference f18326o;

    public static final class a extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public static final a f18327b = new a();

        public a() {
            super(0);
        }

        /* renamed from: a */
        public final Integer invoke() {
            return Integer.valueOf(Build.VERSION.SDK_INT);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ p1(y yVar, h0 h0Var, Handler handler, AtomicReference atomicReference, ScheduledExecutorService scheduledExecutorService, d dVar, ta taVar, q1 q1Var, a5 a5Var, Function0 function0, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(yVar, h0Var, handler, atomicReference, scheduledExecutorService, dVar, taVar, q1Var, a5Var, (i2 & 512) != 0 ? a.f18327b : function0);
    }

    public static final void b(BannerCallback bannerCallback, Banner banner) {
        Intrinsics.f(bannerCallback, "$callback");
        Intrinsics.f(banner, "$ad");
        bannerCallback.onAdLoaded(new CacheEvent((String) null, banner), new CacheError(CacheError.Code.BANNER_DISABLED, (Exception) null, 2, (DefaultConstructorMarker) null));
    }

    public static final void c(BannerCallback bannerCallback, Banner banner) {
        Intrinsics.f(bannerCallback, "$callback");
        Intrinsics.f(banner, "$ad");
        bannerCallback.onAdShown(new ShowEvent((String) null, banner), new ShowError(ShowError.Code.SESSION_NOT_STARTED, (Exception) null, 2, (DefaultConstructorMarker) null));
    }

    public static final void d(BannerCallback bannerCallback, Banner banner) {
        Intrinsics.f(bannerCallback, "$callback");
        Intrinsics.f(banner, "$ad");
        bannerCallback.onAdShown(new ShowEvent((String) null, banner), new ShowError(ShowError.Code.BANNER_DISABLED, (Exception) null, 2, (DefaultConstructorMarker) null));
    }

    public static final void e(BannerCallback bannerCallback, Banner banner) {
        Intrinsics.f(bannerCallback, "$callback");
        Intrinsics.f(banner, "$ad");
        bannerCallback.onAdShown(new ShowEvent((String) null, banner), new ShowError(ShowError.Code.NO_CACHED_AD, (Exception) null, 2, (DefaultConstructorMarker) null));
    }

    public final void a(Banner banner, BannerCallback bannerCallback) {
        Intrinsics.f(banner, "ad");
        Intrinsics.f(bannerCallback, "callback");
        a(banner, bannerCallback, (String) null);
    }

    public void a(String str) {
    }

    public final void a(Banner banner, BannerCallback bannerCallback, String str) {
        Intrinsics.f(banner, "ad");
        Intrinsics.f(bannerCallback, "callback");
        if (g(banner.getLocation())) {
            this.f18325n.post(new g0(bannerCallback, banner));
            a((tb) tb.a.FINISH_FAILURE, "Invalid configuration. Check logs for more details.", (u) u.a.f18735g, banner.getLocation());
        } else if (!e()) {
            this.f18325n.post(new h0(bannerCallback, banner));
        } else {
            a(banner.getLocation(), (Ad) banner, (AdCallback) bannerCallback, str);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public p1(com.chartboost.sdk.impl.y r16, com.chartboost.sdk.impl.h0 r17, android.os.Handler r18, java.util.concurrent.atomic.AtomicReference r19, java.util.concurrent.ScheduledExecutorService r20, com.chartboost.sdk.impl.d r21, com.chartboost.sdk.impl.ta r22, com.chartboost.sdk.impl.q1 r23, com.chartboost.sdk.impl.a5 r24, kotlin.jvm.functions.Function0 r25) {
        /*
            r15 = this;
            r10 = r15
            r11 = r16
            r12 = r17
            r13 = r18
            r14 = r19
            java.lang.String r0 = "adUnitLoader"
            kotlin.jvm.internal.Intrinsics.f(r11, r0)
            java.lang.String r0 = "adUnitRenderer"
            kotlin.jvm.internal.Intrinsics.f(r12, r0)
            java.lang.String r0 = "uiHandler"
            kotlin.jvm.internal.Intrinsics.f(r13, r0)
            java.lang.String r0 = "sdkConfig"
            kotlin.jvm.internal.Intrinsics.f(r14, r0)
            java.lang.String r0 = "backgroundExecutor"
            r4 = r20
            kotlin.jvm.internal.Intrinsics.f(r4, r0)
            java.lang.String r0 = "adApiCallbackSender"
            r5 = r21
            kotlin.jvm.internal.Intrinsics.f(r5, r0)
            java.lang.String r0 = "session"
            r6 = r22
            kotlin.jvm.internal.Intrinsics.f(r6, r0)
            java.lang.String r0 = "base64Wrapper"
            r7 = r23
            kotlin.jvm.internal.Intrinsics.f(r7, r0)
            java.lang.String r0 = "eventTracker"
            r8 = r24
            kotlin.jvm.internal.Intrinsics.f(r8, r0)
            java.lang.String r0 = "androidVersion"
            r9 = r25
            kotlin.jvm.internal.Intrinsics.f(r9, r0)
            r0 = r15
            r1 = r16
            r2 = r17
            r3 = r19
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r10.f18323l = r11
            r10.f18324m = r12
            r10.f18325n = r13
            r10.f18326o = r14
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.p1.<init>(com.chartboost.sdk.impl.y, com.chartboost.sdk.impl.h0, android.os.Handler, java.util.concurrent.atomic.AtomicReference, java.util.concurrent.ScheduledExecutorService, com.chartboost.sdk.impl.d, com.chartboost.sdk.impl.ta, com.chartboost.sdk.impl.q1, com.chartboost.sdk.impl.a5, kotlin.jvm.functions.Function0):void");
    }

    public final void b(Banner banner, BannerCallback bannerCallback) {
        Intrinsics.f(banner, "ad");
        Intrinsics.f(bannerCallback, "callback");
        if (g(banner.getLocation())) {
            this.f18325n.post(new d0(bannerCallback, banner));
            a((tb) tb.h.FINISH_FAILURE, "Invalid configuration. Check logs for more details.", (u) u.a.f18735g, banner.getLocation());
        } else if (!e()) {
            this.f18325n.post(new e0(bannerCallback, banner));
        } else if (!b()) {
            this.f18325n.post(new f0(bannerCallback, banner));
        } else {
            a((Ad) banner, (AdCallback) bannerCallback);
        }
    }

    public final void d() {
        this.f18324m.E();
        this.f18323l.b();
    }

    public final boolean e() {
        pa.a a2;
        pa paVar = (pa) this.f18326o.get();
        if (paVar == null || (a2 = paVar.a()) == null) {
            return true;
        }
        return a2.a();
    }

    public static final void a(BannerCallback bannerCallback, Banner banner) {
        Intrinsics.f(bannerCallback, "$callback");
        Intrinsics.f(banner, "$ad");
        bannerCallback.onAdLoaded(new CacheEvent((String) null, banner), new CacheError(CacheError.Code.SESSION_NOT_STARTED, (Exception) null, 2, (DefaultConstructorMarker) null));
    }

    public final void a(Banner banner) {
        Intrinsics.f(banner, "banner");
        if (banner.getLayoutParams() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 1;
            banner.setLayoutParams(layoutParams);
        }
        DisplayMetrics displayMetrics = banner.getResources().getDisplayMetrics();
        ViewGroup.LayoutParams layoutParams2 = banner.getLayoutParams();
        int bannerWidth = banner.getBannerWidth();
        Intrinsics.e(displayMetrics, "metrics");
        layoutParams2.width = (int) a(bannerWidth, displayMetrics);
        banner.getLayoutParams().height = (int) a(banner.getBannerHeight(), displayMetrics);
    }

    public final float a(int i2, DisplayMetrics displayMetrics) {
        return TypedValue.applyDimension(1, (float) i2, displayMetrics);
    }
}
