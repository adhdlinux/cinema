package com.applovin.impl.mediation.ads;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.applovin.impl.mediation.MaxErrorImpl;
import com.applovin.impl.mediation.MediationServiceImpl;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.sdk.b;
import com.applovin.impl.sdk.e;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.utils.h;
import com.applovin.impl.sdk.utils.j;
import com.applovin.impl.sdk.v;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.MaxRewardedAdListener;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class MaxFullscreenAdImpl extends a implements b.a, e.a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final a f14278a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final com.applovin.impl.sdk.b f14279b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final com.applovin.impl.mediation.b f14280c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final Object f14281d = new Object();
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public com.applovin.impl.mediation.a.c f14282e = null;

    /* renamed from: f  reason: collision with root package name */
    private c f14283f = c.IDLE;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final AtomicBoolean f14284g = new AtomicBoolean();
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public boolean f14285h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public boolean f14286i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public WeakReference<Activity> f14287j = new WeakReference<>((Object) null);
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public WeakReference<ViewGroup> f14288k = new WeakReference<>((Object) null);
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public WeakReference<Lifecycle> f14289l = new WeakReference<>((Object) null);
    protected final b listenerWrapper;

    public interface a {
        Activity getActivity();
    }

    private class b implements a.C0011a, MaxAdListener, MaxAdRevenueListener, MaxRewardedAdListener {
        private b() {
        }

        public void onAdClicked(MaxAd maxAd) {
            j.d(MaxFullscreenAdImpl.this.adListener, maxAd, true);
        }

        public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
            final boolean e2 = MaxFullscreenAdImpl.this.f14286i;
            boolean unused = MaxFullscreenAdImpl.this.f14286i = false;
            final com.applovin.impl.mediation.a.c cVar = (com.applovin.impl.mediation.a.c) maxAd;
            final MaxAd maxAd2 = maxAd;
            final MaxError maxError2 = maxError;
            MaxFullscreenAdImpl.this.a(c.IDLE, (Runnable) new Runnable() {
                public void run() {
                    MaxFullscreenAdImpl.this.a(maxAd2);
                    if (e2 || !cVar.B() || !MaxFullscreenAdImpl.this.sdk.I().a(MaxFullscreenAdImpl.this.adUnitId)) {
                        j.a(MaxFullscreenAdImpl.this.adListener, maxAd2, maxError2, true);
                    } else {
                        AppLovinSdkUtils.runOnUiThread(true, new Runnable() {
                            public void run() {
                                boolean unused = MaxFullscreenAdImpl.this.f14286i = true;
                                MaxFullscreenAdImpl maxFullscreenAdImpl = MaxFullscreenAdImpl.this;
                                maxFullscreenAdImpl.loadAd(maxFullscreenAdImpl.f14278a.getActivity());
                            }
                        });
                    }
                }
            });
        }

        public void onAdDisplayed(MaxAd maxAd) {
            boolean unused = MaxFullscreenAdImpl.this.f14286i = false;
            MaxFullscreenAdImpl.this.f14279b.a();
            j.b(MaxFullscreenAdImpl.this.adListener, maxAd, true);
        }

        public void onAdHidden(final MaxAd maxAd) {
            boolean unused = MaxFullscreenAdImpl.this.f14286i = false;
            MaxFullscreenAdImpl.this.f14280c.a(maxAd);
            MaxFullscreenAdImpl.this.a(c.IDLE, (Runnable) new Runnable() {
                public void run() {
                    MaxFullscreenAdImpl.this.a(maxAd);
                    j.c(MaxFullscreenAdImpl.this.adListener, maxAd, true);
                }
            });
        }

        public void onAdLoadFailed(final String str, final MaxError maxError) {
            MaxFullscreenAdImpl.this.b();
            MaxFullscreenAdImpl.this.a(c.IDLE, (Runnable) new Runnable() {
                public void run() {
                    j.a(MaxFullscreenAdImpl.this.adListener, str, maxError, true);
                }
            });
        }

        public void onAdLoaded(final MaxAd maxAd) {
            MaxFullscreenAdImpl.this.a((com.applovin.impl.mediation.a.c) maxAd);
            if (MaxFullscreenAdImpl.this.f14284g.compareAndSet(true, false)) {
                MaxFullscreenAdImpl.this.extraParameters.remove("expired_ad_ad_unit_id");
            } else {
                MaxFullscreenAdImpl.this.a(c.READY, (Runnable) new Runnable() {
                    public void run() {
                        if (MaxFullscreenAdImpl.this.f14286i) {
                            Activity activity = (Activity) MaxFullscreenAdImpl.this.f14287j.get();
                            if (activity == null) {
                                activity = MaxFullscreenAdImpl.this.sdk.an();
                            }
                            Activity activity2 = activity;
                            if (MaxFullscreenAdImpl.this.f14285h) {
                                MaxFullscreenAdImpl maxFullscreenAdImpl = MaxFullscreenAdImpl.this;
                                maxFullscreenAdImpl.showAd(maxFullscreenAdImpl.f14282e.getPlacement(), MaxFullscreenAdImpl.this.f14282e.Z(), (ViewGroup) MaxFullscreenAdImpl.this.f14288k.get(), (Lifecycle) MaxFullscreenAdImpl.this.f14289l.get(), activity2);
                                return;
                            }
                            MaxFullscreenAdImpl maxFullscreenAdImpl2 = MaxFullscreenAdImpl.this;
                            maxFullscreenAdImpl2.showAd(maxFullscreenAdImpl2.f14282e.getPlacement(), MaxFullscreenAdImpl.this.f14282e.Z(), activity2);
                            return;
                        }
                        j.a(MaxFullscreenAdImpl.this.adListener, maxAd, true);
                    }
                });
            }
        }

        public void onAdRevenuePaid(MaxAd maxAd) {
            j.a(MaxFullscreenAdImpl.this.revenueListener, maxAd);
        }

        public void onRewardedVideoCompleted(MaxAd maxAd) {
            j.f(MaxFullscreenAdImpl.this.adListener, maxAd, true);
        }

        public void onRewardedVideoStarted(MaxAd maxAd) {
            j.e(MaxFullscreenAdImpl.this.adListener, maxAd, true);
        }

        public void onUserRewarded(MaxAd maxAd, MaxReward maxReward) {
            j.a(MaxFullscreenAdImpl.this.adListener, maxAd, maxReward, true);
        }
    }

    public enum c {
        IDLE,
        LOADING,
        READY,
        SHOWING,
        DESTROYED
    }

    public MaxFullscreenAdImpl(String str, MaxAdFormat maxAdFormat, a aVar, String str2, m mVar) {
        super(str, maxAdFormat, str2, mVar);
        this.f14278a = aVar;
        b bVar = new b();
        this.listenerWrapper = bVar;
        this.f14279b = new com.applovin.impl.sdk.b(mVar, this);
        this.f14280c = new com.applovin.impl.mediation.b(mVar, bVar);
        mVar.B().a((e.a) this);
        if (v.a()) {
            v.f(str2, "Created new " + str2 + " (" + this + ")");
        }
    }

    private void a() {
        com.applovin.impl.mediation.a.c cVar;
        synchronized (this.f14281d) {
            cVar = this.f14282e;
            this.f14282e = null;
        }
        this.sdk.E().destroyAd(cVar);
    }

    /* access modifiers changed from: private */
    public void a(com.applovin.impl.mediation.a.c cVar) {
        long u2 = cVar.u() - (SystemClock.elapsedRealtime() - cVar.q());
        if (u2 > TimeUnit.SECONDS.toMillis(2)) {
            this.f14282e = cVar;
            if (v.a()) {
                v vVar = this.logger;
                String str = this.tag;
                vVar.b(str, "Handle ad loaded for regular ad: " + cVar);
                v vVar2 = this.logger;
                String str2 = this.tag;
                vVar2.b(str2, "Scheduling ad expiration " + TimeUnit.MILLISECONDS.toSeconds(u2) + " seconds from now for " + getAdUnitId() + "...");
            }
            this.f14279b.a(u2);
            return;
        }
        if (v.a()) {
            this.logger.b(this.tag, "Loaded an expired ad, running expire logic...");
        }
        onAdExpired();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x019a  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x016a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.c r9, java.lang.Runnable r10) {
        /*
            r8 = this;
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = r8.f14283f
            java.lang.Object r1 = r8.f14281d
            monitor-enter(r1)
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r2 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.c.IDLE     // Catch:{ all -> 0x01cb }
            r3 = 1
            r4 = 0
            if (r0 != r2) goto L_0x0045
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.c.LOADING     // Catch:{ all -> 0x01cb }
            if (r9 != r0) goto L_0x0011
            goto L_0x0168
        L_0x0011:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.c.DESTROYED     // Catch:{ all -> 0x01cb }
            if (r9 != r0) goto L_0x0017
            goto L_0x0168
        L_0x0017:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.c.SHOWING     // Catch:{ all -> 0x01cb }
            if (r9 != r0) goto L_0x0026
            boolean r0 = com.applovin.impl.sdk.v.a()     // Catch:{ all -> 0x01cb }
            if (r0 == 0) goto L_0x005c
            java.lang.String r0 = r8.tag     // Catch:{ all -> 0x01cb }
            java.lang.String r2 = "No ad is loading or loaded"
            goto L_0x0059
        L_0x0026:
            boolean r0 = com.applovin.impl.sdk.v.a()     // Catch:{ all -> 0x01cb }
            if (r0 == 0) goto L_0x005c
            com.applovin.impl.sdk.v r0 = r8.logger     // Catch:{ all -> 0x01cb }
            java.lang.String r2 = r8.tag     // Catch:{ all -> 0x01cb }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x01cb }
            r3.<init>()     // Catch:{ all -> 0x01cb }
            java.lang.String r5 = "Unable to transition to: "
            r3.append(r5)     // Catch:{ all -> 0x01cb }
            r3.append(r9)     // Catch:{ all -> 0x01cb }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x01cb }
        L_0x0041:
            r0.e(r2, r3)     // Catch:{ all -> 0x01cb }
            goto L_0x005c
        L_0x0045:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r5 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.c.LOADING     // Catch:{ all -> 0x01cb }
            if (r0 != r5) goto L_0x0096
            if (r9 != r2) goto L_0x004d
            goto L_0x0168
        L_0x004d:
            if (r9 != r5) goto L_0x005f
            boolean r0 = com.applovin.impl.sdk.v.a()     // Catch:{ all -> 0x01cb }
            if (r0 == 0) goto L_0x005c
            java.lang.String r0 = r8.tag     // Catch:{ all -> 0x01cb }
            java.lang.String r2 = "An ad is already loading"
        L_0x0059:
            com.applovin.impl.sdk.v.i(r0, r2)     // Catch:{ all -> 0x01cb }
        L_0x005c:
            r3 = 0
            goto L_0x0168
        L_0x005f:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.c.READY     // Catch:{ all -> 0x01cb }
            if (r9 != r0) goto L_0x0065
            goto L_0x0168
        L_0x0065:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.c.SHOWING     // Catch:{ all -> 0x01cb }
            if (r9 != r0) goto L_0x0074
            boolean r0 = com.applovin.impl.sdk.v.a()     // Catch:{ all -> 0x01cb }
            if (r0 == 0) goto L_0x005c
            java.lang.String r0 = r8.tag     // Catch:{ all -> 0x01cb }
            java.lang.String r2 = "An ad is not ready to be shown yet"
            goto L_0x0059
        L_0x0074:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.c.DESTROYED     // Catch:{ all -> 0x01cb }
            if (r9 != r0) goto L_0x007a
            goto L_0x0168
        L_0x007a:
            boolean r0 = com.applovin.impl.sdk.v.a()     // Catch:{ all -> 0x01cb }
            if (r0 == 0) goto L_0x005c
            com.applovin.impl.sdk.v r0 = r8.logger     // Catch:{ all -> 0x01cb }
            java.lang.String r2 = r8.tag     // Catch:{ all -> 0x01cb }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x01cb }
            r3.<init>()     // Catch:{ all -> 0x01cb }
            java.lang.String r5 = "Unable to transition to: "
            r3.append(r5)     // Catch:{ all -> 0x01cb }
            r3.append(r9)     // Catch:{ all -> 0x01cb }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x01cb }
            goto L_0x0041
        L_0x0096:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r6 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.c.READY     // Catch:{ all -> 0x01cb }
            if (r0 != r6) goto L_0x00e3
            if (r9 != r2) goto L_0x009e
            goto L_0x0168
        L_0x009e:
            if (r9 != r5) goto L_0x00ab
            boolean r0 = com.applovin.impl.sdk.v.a()     // Catch:{ all -> 0x01cb }
            if (r0 == 0) goto L_0x005c
            java.lang.String r0 = r8.tag     // Catch:{ all -> 0x01cb }
            java.lang.String r2 = "An ad is already loaded"
            goto L_0x0059
        L_0x00ab:
            if (r9 != r6) goto L_0x00ba
            boolean r0 = com.applovin.impl.sdk.v.a()     // Catch:{ all -> 0x01cb }
            if (r0 == 0) goto L_0x005c
            com.applovin.impl.sdk.v r0 = r8.logger     // Catch:{ all -> 0x01cb }
            java.lang.String r2 = r8.tag     // Catch:{ all -> 0x01cb }
            java.lang.String r3 = "An ad is already marked as ready"
            goto L_0x0041
        L_0x00ba:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.c.SHOWING     // Catch:{ all -> 0x01cb }
            if (r9 != r0) goto L_0x00c0
            goto L_0x0168
        L_0x00c0:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.c.DESTROYED     // Catch:{ all -> 0x01cb }
            if (r9 != r0) goto L_0x00c6
            goto L_0x0168
        L_0x00c6:
            boolean r0 = com.applovin.impl.sdk.v.a()     // Catch:{ all -> 0x01cb }
            if (r0 == 0) goto L_0x005c
            com.applovin.impl.sdk.v r0 = r8.logger     // Catch:{ all -> 0x01cb }
            java.lang.String r2 = r8.tag     // Catch:{ all -> 0x01cb }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x01cb }
            r3.<init>()     // Catch:{ all -> 0x01cb }
            java.lang.String r5 = "Unable to transition to: "
            r3.append(r5)     // Catch:{ all -> 0x01cb }
            r3.append(r9)     // Catch:{ all -> 0x01cb }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x01cb }
            goto L_0x0041
        L_0x00e3:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r7 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.c.SHOWING     // Catch:{ all -> 0x01cb }
            if (r0 != r7) goto L_0x0139
            if (r9 != r2) goto L_0x00eb
            goto L_0x0168
        L_0x00eb:
            if (r9 != r5) goto L_0x00f9
            boolean r0 = com.applovin.impl.sdk.v.a()     // Catch:{ all -> 0x01cb }
            if (r0 == 0) goto L_0x005c
            java.lang.String r0 = r8.tag     // Catch:{ all -> 0x01cb }
            java.lang.String r2 = "Can not load another ad while the ad is showing"
            goto L_0x0059
        L_0x00f9:
            if (r9 != r6) goto L_0x0109
            boolean r0 = com.applovin.impl.sdk.v.a()     // Catch:{ all -> 0x01cb }
            if (r0 == 0) goto L_0x005c
            com.applovin.impl.sdk.v r0 = r8.logger     // Catch:{ all -> 0x01cb }
            java.lang.String r2 = r8.tag     // Catch:{ all -> 0x01cb }
            java.lang.String r3 = "An ad is already showing, ignoring"
            goto L_0x0041
        L_0x0109:
            if (r9 != r7) goto L_0x0117
            boolean r0 = com.applovin.impl.sdk.v.a()     // Catch:{ all -> 0x01cb }
            if (r0 == 0) goto L_0x005c
            java.lang.String r0 = r8.tag     // Catch:{ all -> 0x01cb }
            java.lang.String r2 = "The ad is already showing, not showing another one"
            goto L_0x0059
        L_0x0117:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.c.DESTROYED     // Catch:{ all -> 0x01cb }
            if (r9 != r0) goto L_0x011c
            goto L_0x0168
        L_0x011c:
            boolean r0 = com.applovin.impl.sdk.v.a()     // Catch:{ all -> 0x01cb }
            if (r0 == 0) goto L_0x005c
            com.applovin.impl.sdk.v r0 = r8.logger     // Catch:{ all -> 0x01cb }
            java.lang.String r2 = r8.tag     // Catch:{ all -> 0x01cb }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x01cb }
            r3.<init>()     // Catch:{ all -> 0x01cb }
            java.lang.String r5 = "Unable to transition to: "
            r3.append(r5)     // Catch:{ all -> 0x01cb }
            r3.append(r9)     // Catch:{ all -> 0x01cb }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x01cb }
            goto L_0x0041
        L_0x0139:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r2 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.c.DESTROYED     // Catch:{ all -> 0x01cb }
            if (r0 != r2) goto L_0x0149
            boolean r0 = com.applovin.impl.sdk.v.a()     // Catch:{ all -> 0x01cb }
            if (r0 == 0) goto L_0x005c
            java.lang.String r0 = r8.tag     // Catch:{ all -> 0x01cb }
            java.lang.String r2 = "No operations are allowed on a destroyed instance"
            goto L_0x0059
        L_0x0149:
            boolean r0 = com.applovin.impl.sdk.v.a()     // Catch:{ all -> 0x01cb }
            if (r0 == 0) goto L_0x005c
            com.applovin.impl.sdk.v r0 = r8.logger     // Catch:{ all -> 0x01cb }
            java.lang.String r2 = r8.tag     // Catch:{ all -> 0x01cb }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x01cb }
            r3.<init>()     // Catch:{ all -> 0x01cb }
            java.lang.String r5 = "Unknown state: "
            r3.append(r5)     // Catch:{ all -> 0x01cb }
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r5 = r8.f14283f     // Catch:{ all -> 0x01cb }
            r3.append(r5)     // Catch:{ all -> 0x01cb }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x01cb }
            goto L_0x0041
        L_0x0168:
            if (r3 == 0) goto L_0x019a
            boolean r0 = com.applovin.impl.sdk.v.a()     // Catch:{ all -> 0x01cb }
            if (r0 == 0) goto L_0x0197
            com.applovin.impl.sdk.v r0 = r8.logger     // Catch:{ all -> 0x01cb }
            java.lang.String r2 = r8.tag     // Catch:{ all -> 0x01cb }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x01cb }
            r4.<init>()     // Catch:{ all -> 0x01cb }
            java.lang.String r5 = "Transitioning from "
            r4.append(r5)     // Catch:{ all -> 0x01cb }
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r5 = r8.f14283f     // Catch:{ all -> 0x01cb }
            r4.append(r5)     // Catch:{ all -> 0x01cb }
            java.lang.String r5 = " to "
            r4.append(r5)     // Catch:{ all -> 0x01cb }
            r4.append(r9)     // Catch:{ all -> 0x01cb }
            java.lang.String r5 = "..."
            r4.append(r5)     // Catch:{ all -> 0x01cb }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x01cb }
            r0.b(r2, r4)     // Catch:{ all -> 0x01cb }
        L_0x0197:
            r8.f14283f = r9     // Catch:{ all -> 0x01cb }
            goto L_0x01c2
        L_0x019a:
            boolean r0 = com.applovin.impl.sdk.v.a()     // Catch:{ all -> 0x01cb }
            if (r0 == 0) goto L_0x01c2
            com.applovin.impl.sdk.v r0 = r8.logger     // Catch:{ all -> 0x01cb }
            java.lang.String r2 = r8.tag     // Catch:{ all -> 0x01cb }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x01cb }
            r4.<init>()     // Catch:{ all -> 0x01cb }
            java.lang.String r5 = "Not allowed transition from "
            r4.append(r5)     // Catch:{ all -> 0x01cb }
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r5 = r8.f14283f     // Catch:{ all -> 0x01cb }
            r4.append(r5)     // Catch:{ all -> 0x01cb }
            java.lang.String r5 = " to "
            r4.append(r5)     // Catch:{ all -> 0x01cb }
            r4.append(r9)     // Catch:{ all -> 0x01cb }
            java.lang.String r9 = r4.toString()     // Catch:{ all -> 0x01cb }
            r0.d(r2, r9)     // Catch:{ all -> 0x01cb }
        L_0x01c2:
            monitor-exit(r1)     // Catch:{ all -> 0x01cb }
            if (r3 == 0) goto L_0x01ca
            if (r10 == 0) goto L_0x01ca
            r10.run()
        L_0x01ca:
            return
        L_0x01cb:
            r9 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x01cb }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.a(com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c, java.lang.Runnable):void");
    }

    /* access modifiers changed from: private */
    public void a(MaxAd maxAd) {
        this.f14279b.a();
        a();
        this.sdk.F().b((com.applovin.impl.mediation.a.a) maxAd);
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2) {
        this.f14280c.b(this.f14282e);
        this.f14282e.d(str);
        this.f14282e.e(str2);
        if (v.a()) {
            v vVar = this.logger;
            String str3 = this.tag;
            vVar.b(str3, "Showing ad for '" + this.adUnitId + "'; loaded ad: " + this.f14282e + "...");
        }
        a(this.f14282e);
    }

    private boolean a(Activity activity) {
        if (activity == null) {
            throw new IllegalArgumentException("Attempting to show ad without a valid activity.");
        } else if (!isReady()) {
            String str = "Attempting to show ad before it is ready - please check ad readiness using " + this.tag + "#isReady()";
            if (v.a()) {
                v.i(this.tag, str);
            }
            j.a(this.adListener, (MaxAd) this.f14282e, (MaxError) new MaxErrorImpl(-24, str), true);
            return false;
        } else {
            if (Utils.getAlwaysFinishActivitiesSetting(activity) != 0 && this.sdk.p().shouldFailAdDisplayIfDontKeepActivitiesIsEnabled()) {
                if (Utils.isPubInDebugMode(activity, this.sdk)) {
                    throw new IllegalStateException("Ad failed to display! Please disable the \"Don't Keep Activities\" setting in your developer settings!");
                } else if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.a.T)).booleanValue()) {
                    if (v.a()) {
                        v.i(this.tag, "Ad failed to display! Please disable the \"Don't Keep Activities\" setting in your developer settings!");
                    }
                    j.a(this.adListener, (MaxAd) this.f14282e, (MaxError) new MaxErrorImpl(-5602, "Ad failed to display! Please disable the \"Don't Keep Activities\" setting in your developer settings!"), true);
                    return false;
                }
            }
            if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.a.A)).booleanValue() && (this.sdk.ae().a() || this.sdk.ae().b())) {
                if (v.a()) {
                    v.i(this.tag, "Attempting to show ad when another fullscreen ad is already showing");
                }
                j.a(this.adListener, (MaxAd) this.f14282e, (MaxError) new MaxErrorImpl(-23, "Attempting to show ad when another fullscreen ad is already showing"), true);
                return false;
            } else if (!((Boolean) this.sdk.a(com.applovin.impl.sdk.c.a.B)).booleanValue() || h.a((Context) activity)) {
                String str2 = this.sdk.p().getExtraParameters().get("fullscreen_ads_block_showing_if_activity_is_finishing");
                if ((!(StringUtils.isValidString(str2) && Boolean.valueOf(str2).booleanValue()) && !((Boolean) this.sdk.a(com.applovin.impl.sdk.c.a.C)).booleanValue()) || !activity.isFinishing()) {
                    return true;
                }
                if (v.a()) {
                    v.i(this.tag, "Attempting to show ad when activity is finishing");
                }
                j.a(this.adListener, (MaxAd) this.f14282e, (MaxError) new MaxErrorImpl(-5601, "Attempting to show ad when activity is finishing"), true);
                return false;
            } else {
                if (v.a()) {
                    v.i(this.tag, "Attempting to show ad with no internet connection");
                }
                j.a(this.adListener, (MaxAd) this.f14282e, (MaxError) new MaxErrorImpl(-1009), true);
                return false;
            }
        }
    }

    /* access modifiers changed from: private */
    public void b() {
        com.applovin.impl.mediation.a.c cVar;
        if (this.f14284g.compareAndSet(true, false)) {
            synchronized (this.f14281d) {
                cVar = this.f14282e;
                this.f14282e = null;
            }
            this.sdk.E().destroyAd(cVar);
            this.extraParameters.remove("expired_ad_ad_unit_id");
        }
    }

    public void destroy() {
        a(c.DESTROYED, (Runnable) new Runnable() {
            public void run() {
                synchronized (MaxFullscreenAdImpl.this.f14281d) {
                    if (MaxFullscreenAdImpl.this.f14282e != null) {
                        if (v.a()) {
                            MaxFullscreenAdImpl maxFullscreenAdImpl = MaxFullscreenAdImpl.this;
                            v vVar = maxFullscreenAdImpl.logger;
                            String str = maxFullscreenAdImpl.tag;
                            vVar.b(str, "Destroying ad for '" + MaxFullscreenAdImpl.this.adUnitId + "'; current ad: " + MaxFullscreenAdImpl.this.f14282e + "...");
                        }
                        MaxFullscreenAdImpl.this.sdk.E().destroyAd(MaxFullscreenAdImpl.this.f14282e);
                    }
                }
                MaxFullscreenAdImpl.this.sdk.B().b((e.a) MaxFullscreenAdImpl.this);
                MaxFullscreenAdImpl.super.destroy();
            }
        });
    }

    public boolean isReady() {
        boolean z2;
        synchronized (this.f14281d) {
            com.applovin.impl.mediation.a.c cVar = this.f14282e;
            z2 = cVar != null && cVar.e() && this.f14283f == c.READY;
        }
        return z2;
    }

    public void loadAd(final Activity activity) {
        if (v.a()) {
            v vVar = this.logger;
            String str = this.tag;
            vVar.b(str, "Loading ad for '" + this.adUnitId + "'...");
        }
        if (isReady()) {
            if (v.a()) {
                v vVar2 = this.logger;
                String str2 = this.tag;
                vVar2.b(str2, "An ad is already loaded for '" + this.adUnitId + "'");
            }
            j.a(this.adListener, (MaxAd) this.f14282e, true);
            return;
        }
        a(c.LOADING, (Runnable) new Runnable() {
            public void run() {
                Context context = activity;
                if (context == null) {
                    context = MaxFullscreenAdImpl.this.sdk.an() != null ? MaxFullscreenAdImpl.this.sdk.an() : MaxFullscreenAdImpl.this.sdk.L();
                }
                Context context2 = context;
                MediationServiceImpl E = MaxFullscreenAdImpl.this.sdk.E();
                MaxFullscreenAdImpl maxFullscreenAdImpl = MaxFullscreenAdImpl.this;
                E.loadAd(maxFullscreenAdImpl.adUnitId, (String) null, maxFullscreenAdImpl.adFormat, maxFullscreenAdImpl.localExtraParameters, maxFullscreenAdImpl.extraParameters, context2, maxFullscreenAdImpl.listenerWrapper);
            }
        });
    }

    public void onAdExpired() {
        if (v.a()) {
            v vVar = this.logger;
            String str = this.tag;
            vVar.b(str, "Ad expired " + getAdUnitId());
        }
        this.f14284g.set(true);
        Activity activity = this.f14278a.getActivity();
        if (activity == null && (activity = this.sdk.af().a()) == null) {
            b();
            this.listenerWrapper.onAdLoadFailed(this.adUnitId, MaxAdapterError.MISSING_ACTIVITY);
            return;
        }
        this.extraParameters.put("expired_ad_ad_unit_id", getAdUnitId());
        this.sdk.E().loadAd(this.adUnitId, (String) null, this.adFormat, this.localExtraParameters, this.extraParameters, activity, this.listenerWrapper);
    }

    public void onCreativeIdGenerated(String str, String str2) {
        com.applovin.impl.mediation.a.c cVar = this.f14282e;
        if (cVar != null && cVar.f().equalsIgnoreCase(str)) {
            j.a(this.adReviewListener, str2, (MaxAd) this.f14282e);
        }
    }

    public void showAd(final String str, final String str2, final Activity activity) {
        if (activity == null) {
            activity = this.sdk.an();
        }
        if (a(activity)) {
            a(c.SHOWING, (Runnable) new Runnable() {
                public void run() {
                    MaxFullscreenAdImpl.this.a(str, str2);
                    boolean unused = MaxFullscreenAdImpl.this.f14285h = false;
                    WeakReference unused2 = MaxFullscreenAdImpl.this.f14287j = new WeakReference(activity);
                    MaxFullscreenAdImpl.this.sdk.E().showFullscreenAd(MaxFullscreenAdImpl.this.f14282e, activity, MaxFullscreenAdImpl.this.listenerWrapper);
                }
            });
        }
    }

    public void showAd(String str, String str2, ViewGroup viewGroup, Lifecycle lifecycle, Activity activity) {
        if (viewGroup == null || lifecycle == null) {
            if (v.a()) {
                v.i(this.tag, "Attempting to show ad with null containerView or lifecycle.");
            }
            j.a(this.adListener, (MaxAd) this.f14282e, (MaxError) new MaxErrorImpl(-1, "Attempting to show ad with null containerView or lifecycle."), true);
            return;
        }
        if (activity == null) {
            activity = this.sdk.an();
        }
        final Activity activity2 = activity;
        if (a(activity2)) {
            final String str3 = str;
            final String str4 = str2;
            final ViewGroup viewGroup2 = viewGroup;
            final Lifecycle lifecycle2 = lifecycle;
            a(c.SHOWING, (Runnable) new Runnable() {
                public void run() {
                    MaxFullscreenAdImpl.this.a(str3, str4);
                    boolean unused = MaxFullscreenAdImpl.this.f14285h = true;
                    WeakReference unused2 = MaxFullscreenAdImpl.this.f14287j = new WeakReference(activity2);
                    WeakReference unused3 = MaxFullscreenAdImpl.this.f14288k = new WeakReference(viewGroup2);
                    WeakReference unused4 = MaxFullscreenAdImpl.this.f14289l = new WeakReference(lifecycle2);
                    MaxFullscreenAdImpl.this.sdk.E().showFullscreenAd(MaxFullscreenAdImpl.this.f14282e, viewGroup2, lifecycle2, activity2, MaxFullscreenAdImpl.this.listenerWrapper);
                }
            });
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.tag);
        sb.append("{adUnitId='");
        sb.append(this.adUnitId);
        sb.append('\'');
        sb.append(", adListener=");
        Object obj = this.adListener;
        if (obj == this.f14278a) {
            obj = "this";
        }
        sb.append(obj);
        sb.append(", revenueListener=");
        sb.append(this.revenueListener);
        sb.append(", isReady=");
        sb.append(isReady());
        sb.append('}');
        return sb.toString();
    }
}
