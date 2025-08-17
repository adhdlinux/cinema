package com.applovin.impl.mediation.ads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.applovin.impl.mediation.MaxErrorImpl;
import com.applovin.impl.mediation.MediationServiceImpl;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.sdk.aa;
import com.applovin.impl.sdk.d;
import com.applovin.impl.sdk.e;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.utils.j;
import com.applovin.impl.sdk.utils.q;
import com.applovin.impl.sdk.v;
import com.applovin.impl.sdk.z;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.ads.MaxAdView;
import com.applovin.sdk.AppLovinSdkUtils;
import com.facebook.common.time.Clock;
import java.util.Locale;
import java.util.UUID;

public class MaxAdViewImpl extends a implements aa.a, d.a, e.a {
    private boolean A;
    private boolean B;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f14242a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final MaxAdView f14243b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final String f14244c = UUID.randomUUID().toString().toLowerCase(Locale.US);
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final View f14245d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public long f14246e = Clock.MAX_TIME;

    /* renamed from: f  reason: collision with root package name */
    private com.applovin.impl.mediation.a.b f14247f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public String f14248g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public String f14249h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public String f14250i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public String f14251j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public final a f14252k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public final c f14253l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public final d f14254m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public final z f14255n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public final aa f14256o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public final Object f14257p = new Object();
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public com.applovin.impl.mediation.a.b f14258q = null;

    /* renamed from: r  reason: collision with root package name */
    private boolean f14259r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public boolean f14260s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f14261t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f14262u;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public boolean f14263v = false;

    /* renamed from: w  reason: collision with root package name */
    private boolean f14264w;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public boolean f14265x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f14266y;
    /* access modifiers changed from: private */

    /* renamed from: z  reason: collision with root package name */
    public boolean f14267z;

    private class a extends b {
        private a() {
            super();
        }

        public void onAdLoadFailed(String str, MaxError maxError) {
            if (v.a()) {
                MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                v vVar = maxAdViewImpl.logger;
                String str2 = maxAdViewImpl.tag;
                vVar.b(str2, "Calling ad load failed callback for publisher: " + MaxAdViewImpl.this.adListener);
            }
            j.a(MaxAdViewImpl.this.adListener, str, maxError, true);
            MaxAdViewImpl.this.a(maxError);
        }

        public void onAdLoaded(MaxAd maxAd) {
            if (MaxAdViewImpl.this.f14263v) {
                if (v.a()) {
                    MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                    v vVar = maxAdViewImpl.logger;
                    String str = maxAdViewImpl.tag;
                    vVar.b(str, "Precache ad with ad unit ID '" + MaxAdViewImpl.this.adUnitId + "' loaded after MaxAdView was destroyed. Destroying the ad.");
                }
                MaxAdViewImpl.this.sdk.E().destroyAd(maxAd);
                return;
            }
            com.applovin.impl.mediation.a.b bVar = (com.applovin.impl.mediation.a.b) maxAd;
            bVar.d(MaxAdViewImpl.this.f14250i);
            bVar.e(MaxAdViewImpl.this.f14251j);
            if (bVar.w() != null) {
                MaxAdViewImpl.this.a(bVar);
                if (bVar.y()) {
                    long z2 = bVar.z();
                    if (v.a()) {
                        v A = MaxAdViewImpl.this.sdk.A();
                        String str2 = MaxAdViewImpl.this.tag;
                        A.b(str2, "Scheduling banner ad refresh " + z2 + " milliseconds from now for '" + MaxAdViewImpl.this.adUnitId + "'...");
                    }
                    MaxAdViewImpl.this.f14254m.a(z2);
                    if (MaxAdViewImpl.this.f14254m.f() || MaxAdViewImpl.this.f14260s) {
                        if (v.a()) {
                            MaxAdViewImpl maxAdViewImpl2 = MaxAdViewImpl.this;
                            maxAdViewImpl2.logger.b(maxAdViewImpl2.tag, "Pausing ad refresh for publisher");
                        }
                        MaxAdViewImpl.this.f14254m.d();
                    }
                }
                if (v.a()) {
                    MaxAdViewImpl maxAdViewImpl3 = MaxAdViewImpl.this;
                    v vVar2 = maxAdViewImpl3.logger;
                    String str3 = maxAdViewImpl3.tag;
                    vVar2.b(str3, "Calling ad load success callback for publisher: " + MaxAdViewImpl.this.adListener);
                }
                j.a(MaxAdViewImpl.this.adListener, maxAd, true);
                return;
            }
            MaxAdViewImpl.this.sdk.E().destroyAd(bVar);
            onAdLoadFailed(bVar.getAdUnitId(), new MaxErrorImpl(-5001, "Ad view not fully loaded"));
        }
    }

    private abstract class b implements a.C0011a, MaxAdListener, MaxAdRevenueListener, MaxAdViewAdListener {

        /* renamed from: a  reason: collision with root package name */
        private boolean f14275a;

        private b() {
        }

        public void onAdClicked(MaxAd maxAd) {
            if (maxAd.equals(MaxAdViewImpl.this.f14258q)) {
                j.d(MaxAdViewImpl.this.adListener, maxAd, true);
            }
        }

        public void onAdCollapsed(MaxAd maxAd) {
            if (maxAd.equals(MaxAdViewImpl.this.f14258q)) {
                if ((MaxAdViewImpl.this.f14258q.A() || MaxAdViewImpl.this.f14267z) && this.f14275a) {
                    this.f14275a = false;
                    MaxAdViewImpl.this.startAutoRefresh();
                }
                j.h(MaxAdViewImpl.this.adListener, maxAd, true);
            }
        }

        public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
            if (maxAd.equals(MaxAdViewImpl.this.f14258q)) {
                j.a(MaxAdViewImpl.this.adListener, maxAd, maxError, true);
            }
        }

        public void onAdDisplayed(MaxAd maxAd) {
            if (maxAd.equals(MaxAdViewImpl.this.f14258q)) {
                j.b(MaxAdViewImpl.this.adListener, maxAd, true);
            }
        }

        public void onAdExpanded(MaxAd maxAd) {
            if (maxAd.equals(MaxAdViewImpl.this.f14258q)) {
                if ((MaxAdViewImpl.this.f14258q.A() || MaxAdViewImpl.this.f14267z) && !MaxAdViewImpl.this.f14254m.f()) {
                    this.f14275a = true;
                    MaxAdViewImpl.this.stopAutoRefresh();
                }
                j.g(MaxAdViewImpl.this.adListener, maxAd, true);
            }
        }

        public void onAdHidden(MaxAd maxAd) {
            if (maxAd.equals(MaxAdViewImpl.this.f14258q)) {
                j.c(MaxAdViewImpl.this.adListener, maxAd, true);
            }
        }

        public void onAdRevenuePaid(MaxAd maxAd) {
            j.a(MaxAdViewImpl.this.revenueListener, maxAd, true);
        }
    }

    private class c extends b {
        private c() {
            super();
        }

        public void onAdLoadFailed(String str, MaxError maxError) {
            if (v.a()) {
                MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                v vVar = maxAdViewImpl.logger;
                String str2 = maxAdViewImpl.tag;
                vVar.b(str2, "Failed to precache ad for refresh with error code: " + maxError.getCode());
            }
            MaxAdViewImpl.this.a(maxError);
        }

        public void onAdLoaded(MaxAd maxAd) {
            if (MaxAdViewImpl.this.f14263v) {
                if (v.a()) {
                    MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                    v vVar = maxAdViewImpl.logger;
                    String str = maxAdViewImpl.tag;
                    vVar.b(str, "Ad with ad unit ID '" + MaxAdViewImpl.this.adUnitId + "' loaded after MaxAdView was destroyed. Destroying the ad.");
                }
                MaxAdViewImpl.this.sdk.E().destroyAd(maxAd);
                return;
            }
            if (v.a()) {
                MaxAdViewImpl maxAdViewImpl2 = MaxAdViewImpl.this;
                maxAdViewImpl2.logger.b(maxAdViewImpl2.tag, "Successfully pre-cached ad for refresh");
            }
            MaxAdViewImpl.this.a(maxAd);
        }
    }

    public MaxAdViewImpl(String str, MaxAdFormat maxAdFormat, MaxAdView maxAdView, View view, m mVar, Context context) {
        super(str, maxAdFormat, "MaxAdView", mVar);
        if (context != null) {
            this.f14242a = context.getApplicationContext();
            this.f14243b = maxAdView;
            this.f14245d = view;
            this.f14252k = new a();
            this.f14253l = new c();
            this.f14254m = new d(mVar, this);
            this.f14255n = new z(maxAdView, mVar);
            this.f14256o = new aa(maxAdView, mVar, this);
            mVar.B().a((e.a) this);
            if (v.a()) {
                v vVar = this.logger;
                String str2 = this.tag;
                vVar.b(str2, "Created new MaxAdView (" + this + ")");
                return;
            }
            return;
        }
        throw new IllegalArgumentException("No context specified");
    }

    /* access modifiers changed from: private */
    public void a() {
        com.applovin.impl.mediation.a.b bVar;
        MaxAdView maxAdView = this.f14243b;
        if (maxAdView != null) {
            com.applovin.impl.sdk.utils.b.a(maxAdView, this.f14245d);
        }
        this.f14256o.a();
        synchronized (this.f14257p) {
            bVar = this.f14258q;
        }
        if (bVar != null) {
            this.sdk.E().destroyAd(bVar);
        }
    }

    /* access modifiers changed from: private */
    public void a(long j2) {
        if (!Utils.bitMaskContainsFlag(j2, ((Long) this.sdk.a(com.applovin.impl.sdk.c.a.f15203y)).longValue()) || this.A) {
            if (v.a()) {
                this.logger.b(this.tag, "No undesired viewability flags matched or forcing pre-cache - scheduling viewability");
            }
            this.f14259r = false;
            b();
            return;
        }
        if (v.a()) {
            v vVar = this.logger;
            String str = this.tag;
            vVar.b(str, "Undesired flags matched - current: " + Long.toBinaryString(j2) + ", undesired: " + Long.toBinaryString(j2));
            this.logger.b(this.tag, "Waiting for refresh timer to manually fire request");
        }
        this.f14259r = true;
    }

    /* access modifiers changed from: private */
    public void a(View view, com.applovin.impl.mediation.a.b bVar) {
        int u2 = bVar.u();
        int v2 = bVar.v();
        int i2 = -1;
        int dpToPx = u2 == -1 ? -1 : AppLovinSdkUtils.dpToPx(view.getContext(), u2);
        if (v2 != -1) {
            i2 = AppLovinSdkUtils.dpToPx(view.getContext(), v2);
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(dpToPx, i2);
        } else {
            layoutParams.width = dpToPx;
            layoutParams.height = i2;
        }
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            if (v.a()) {
                this.logger.b(this.tag, "Pinning ad view to MAX ad view with width: " + dpToPx + " and height: " + i2 + ".");
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            for (int addRule : q.a(this.f14243b.getGravity(), 10, 14)) {
                layoutParams2.addRule(addRule);
            }
        }
        view.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: private */
    public void a(final com.applovin.impl.mediation.a.b bVar) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
                java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
                	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
                	at java.util.ArrayList.get(ArrayList.java:435)
                	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
                	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
                	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
                	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
                	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
                	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
                */
            public void run() {
                /*
                    r8 = this;
                    com.applovin.impl.mediation.a.b r0 = r2
                    android.view.View r0 = r0.w()
                    r1 = 0
                    if (r0 != 0) goto L_0x000c
                    java.lang.String r2 = "MaxAdView does not have a loaded ad view"
                    goto L_0x000d
                L_0x000c:
                    r2 = r1
                L_0x000d:
                    com.applovin.impl.mediation.ads.MaxAdViewImpl r3 = com.applovin.impl.mediation.ads.MaxAdViewImpl.this
                    com.applovin.mediation.ads.MaxAdView r3 = r3.f14243b
                    if (r3 != 0) goto L_0x0017
                    java.lang.String r2 = "MaxAdView does not have a parent view"
                L_0x0017:
                    if (r2 == 0) goto L_0x0038
                    boolean r0 = com.applovin.impl.sdk.v.a()
                    if (r0 == 0) goto L_0x0028
                    com.applovin.impl.mediation.ads.MaxAdViewImpl r0 = com.applovin.impl.mediation.ads.MaxAdViewImpl.this
                    com.applovin.impl.sdk.v r1 = r0.logger
                    java.lang.String r0 = r0.tag
                    r1.e(r0, r2)
                L_0x0028:
                    com.applovin.impl.mediation.MaxErrorImpl r0 = new com.applovin.impl.mediation.MaxErrorImpl
                    r1 = -1
                    r0.<init>(r1, r2)
                    com.applovin.impl.mediation.ads.MaxAdViewImpl r1 = com.applovin.impl.mediation.ads.MaxAdViewImpl.this
                    com.applovin.mediation.MaxAdListener r1 = r1.adListener
                    com.applovin.impl.mediation.a.b r2 = r2
                    com.applovin.impl.sdk.utils.j.a((com.applovin.mediation.MaxAdListener) r1, (com.applovin.mediation.MaxAd) r2, (com.applovin.mediation.MaxError) r0)
                    return
                L_0x0038:
                    com.applovin.impl.mediation.ads.MaxAdViewImpl r2 = com.applovin.impl.mediation.ads.MaxAdViewImpl.this
                    r2.a()
                    com.applovin.impl.mediation.ads.MaxAdViewImpl r2 = com.applovin.impl.mediation.ads.MaxAdViewImpl.this
                    com.applovin.impl.mediation.a.b r4 = r2
                    r2.a(r4)
                    com.applovin.impl.mediation.a.b r2 = r2
                    boolean r2 = r2.G()
                    if (r2 == 0) goto L_0x0057
                    com.applovin.impl.mediation.ads.MaxAdViewImpl r2 = com.applovin.impl.mediation.ads.MaxAdViewImpl.this
                    com.applovin.impl.sdk.aa r2 = r2.f14256o
                    com.applovin.impl.mediation.a.b r4 = r2
                    r2.a((com.applovin.impl.mediation.a.e) r4)
                L_0x0057:
                    r2 = 393216(0x60000, float:5.51013E-40)
                    r3.setDescendantFocusability(r2)
                    com.applovin.impl.mediation.a.b r2 = r2
                    long r4 = r2.B()
                    r6 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                    int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                    if (r2 == 0) goto L_0x007c
                    com.applovin.impl.mediation.ads.MaxAdViewImpl r2 = com.applovin.impl.mediation.ads.MaxAdViewImpl.this
                    android.view.View r2 = r2.f14245d
                    com.applovin.impl.mediation.a.b r4 = r2
                    long r4 = r4.B()
                L_0x0077:
                    int r5 = (int) r4
                    r2.setBackgroundColor(r5)
                    goto L_0x009d
                L_0x007c:
                    com.applovin.impl.mediation.ads.MaxAdViewImpl r2 = com.applovin.impl.mediation.ads.MaxAdViewImpl.this
                    long r4 = r2.f14246e
                    int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                    if (r2 == 0) goto L_0x0093
                    com.applovin.impl.mediation.ads.MaxAdViewImpl r2 = com.applovin.impl.mediation.ads.MaxAdViewImpl.this
                    android.view.View r2 = r2.f14245d
                    com.applovin.impl.mediation.ads.MaxAdViewImpl r4 = com.applovin.impl.mediation.ads.MaxAdViewImpl.this
                    long r4 = r4.f14246e
                    goto L_0x0077
                L_0x0093:
                    com.applovin.impl.mediation.ads.MaxAdViewImpl r2 = com.applovin.impl.mediation.ads.MaxAdViewImpl.this
                    android.view.View r2 = r2.f14245d
                    r4 = 0
                    r2.setBackgroundColor(r4)
                L_0x009d:
                    r3.addView(r0)
                    com.applovin.impl.mediation.ads.MaxAdViewImpl r2 = com.applovin.impl.mediation.ads.MaxAdViewImpl.this
                    com.applovin.impl.mediation.a.b r3 = r2
                    r2.a((android.view.View) r0, (com.applovin.impl.mediation.a.b) r3)
                    com.applovin.impl.mediation.ads.MaxAdViewImpl r0 = com.applovin.impl.mediation.ads.MaxAdViewImpl.this
                    com.applovin.impl.mediation.a.b r2 = r2
                    r0.b((com.applovin.impl.mediation.a.b) r2)
                    com.applovin.impl.mediation.ads.MaxAdViewImpl r0 = com.applovin.impl.mediation.ads.MaxAdViewImpl.this
                    java.lang.Object r0 = r0.f14257p
                    monitor-enter(r0)
                    com.applovin.impl.mediation.ads.MaxAdViewImpl r2 = com.applovin.impl.mediation.ads.MaxAdViewImpl.this     // Catch:{ all -> 0x012e }
                    com.applovin.impl.mediation.a.b r3 = r2     // Catch:{ all -> 0x012e }
                    com.applovin.impl.mediation.a.b unused = r2.f14258q = r3     // Catch:{ all -> 0x012e }
                    monitor-exit(r0)     // Catch:{ all -> 0x012e }
                    boolean r0 = com.applovin.impl.sdk.v.a()
                    if (r0 == 0) goto L_0x00ce
                    com.applovin.impl.mediation.ads.MaxAdViewImpl r0 = com.applovin.impl.mediation.ads.MaxAdViewImpl.this
                    com.applovin.impl.sdk.v r2 = r0.logger
                    java.lang.String r0 = r0.tag
                    java.lang.String r3 = "Scheduling impression for ad manually..."
                    r2.b(r0, r3)
                L_0x00ce:
                    com.applovin.impl.mediation.ads.MaxAdViewImpl r0 = com.applovin.impl.mediation.ads.MaxAdViewImpl.this
                    com.applovin.impl.sdk.m r0 = r0.sdk
                    com.applovin.impl.mediation.MediationServiceImpl r0 = r0.E()
                    com.applovin.impl.mediation.a.b r2 = r2
                    com.applovin.impl.mediation.ads.MaxAdViewImpl r3 = com.applovin.impl.mediation.ads.MaxAdViewImpl.this
                    com.applovin.impl.mediation.ads.MaxAdViewImpl$a r3 = r3.f14252k
                    r0.processRawAdImpressionPostback(r2, r3)
                    com.applovin.impl.mediation.ads.MaxAdViewImpl r0 = com.applovin.impl.mediation.ads.MaxAdViewImpl.this
                    com.applovin.impl.mediation.a.b r0 = r0.f14258q
                    java.lang.String r0 = r0.f()
                    com.applovin.impl.mediation.ads.MaxAdViewImpl r2 = com.applovin.impl.mediation.ads.MaxAdViewImpl.this
                    java.lang.String r2 = r2.f14249h
                    boolean r0 = r0.equalsIgnoreCase(r2)
                    if (r0 == 0) goto L_0x011f
                    com.applovin.impl.mediation.ads.MaxAdViewImpl r0 = com.applovin.impl.mediation.ads.MaxAdViewImpl.this
                    java.lang.String r0 = r0.f14248g
                    boolean r0 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r0)
                    if (r0 == 0) goto L_0x011f
                    com.applovin.impl.mediation.ads.MaxAdViewImpl r0 = com.applovin.impl.mediation.ads.MaxAdViewImpl.this
                    com.applovin.mediation.MaxAdReviewListener r2 = r0.adReviewListener
                    java.lang.String r0 = r0.f14248g
                    com.applovin.impl.mediation.ads.MaxAdViewImpl r3 = com.applovin.impl.mediation.ads.MaxAdViewImpl.this
                    com.applovin.impl.mediation.a.b r3 = r3.f14258q
                    r4 = 1
                    com.applovin.impl.sdk.utils.j.a((com.applovin.mediation.MaxAdReviewListener) r2, (java.lang.String) r0, (com.applovin.mediation.MaxAd) r3, (boolean) r4)
                    com.applovin.impl.mediation.ads.MaxAdViewImpl r0 = com.applovin.impl.mediation.ads.MaxAdViewImpl.this
                    java.lang.String unused = r0.f14249h = r1
                    com.applovin.impl.mediation.ads.MaxAdViewImpl r0 = com.applovin.impl.mediation.ads.MaxAdViewImpl.this
                    java.lang.String unused = r0.f14248g = r1
                L_0x011f:
                    com.applovin.impl.mediation.ads.MaxAdViewImpl$2$1 r0 = new com.applovin.impl.mediation.ads.MaxAdViewImpl$2$1
                    r0.<init>()
                    com.applovin.impl.mediation.a.b r1 = r2
                    long r1 = r1.x()
                    com.applovin.sdk.AppLovinSdkUtils.runOnUiThreadDelayed(r0, r1)
                    return
                L_0x012e:
                    r1 = move-exception
                    monitor-exit(r0)     // Catch:{ all -> 0x012e }
                    throw r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.mediation.ads.MaxAdViewImpl.AnonymousClass2.run():void");
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(com.applovin.impl.mediation.a.b bVar, long j2) {
        if (v.a()) {
            this.logger.b(this.tag, "Scheduling viewability impression for ad...");
        }
        this.sdk.E().processViewabilityAdImpressionPostback(bVar, j2, this.f14252k);
    }

    /* access modifiers changed from: private */
    public void a(final a.C0011a aVar) {
        if (!e()) {
            AppLovinSdkUtils.runOnUiThread(true, new Runnable() {
                public void run() {
                    if (MaxAdViewImpl.this.f14258q != null) {
                        long a2 = MaxAdViewImpl.this.f14255n.a(MaxAdViewImpl.this.f14258q);
                        MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                        maxAdViewImpl.extraParameters.put("visible_ad_ad_unit_id", maxAdViewImpl.f14258q.getAdUnitId());
                        MaxAdViewImpl.this.extraParameters.put("viewability_flags", Long.valueOf(a2));
                    } else {
                        MaxAdViewImpl.this.extraParameters.remove("visible_ad_ad_unit_id");
                        MaxAdViewImpl.this.extraParameters.remove("viewability_flags");
                    }
                    int pxToDp = AppLovinSdkUtils.pxToDp(MaxAdViewImpl.this.f14243b.getContext(), MaxAdViewImpl.this.f14243b.getWidth());
                    int pxToDp2 = AppLovinSdkUtils.pxToDp(MaxAdViewImpl.this.f14243b.getContext(), MaxAdViewImpl.this.f14243b.getHeight());
                    MaxAdViewImpl.this.extraParameters.put("viewport_width", Integer.valueOf(pxToDp));
                    MaxAdViewImpl.this.extraParameters.put("viewport_height", Integer.valueOf(pxToDp2));
                    MaxAdViewImpl maxAdViewImpl2 = MaxAdViewImpl.this;
                    maxAdViewImpl2.extraParameters.put("auto_refresh_stopped", Boolean.valueOf(maxAdViewImpl2.f14254m.f() || MaxAdViewImpl.this.f14260s));
                    MaxAdViewImpl maxAdViewImpl3 = MaxAdViewImpl.this;
                    maxAdViewImpl3.extraParameters.put("auto_retries_disabled", Boolean.valueOf(maxAdViewImpl3.f14265x));
                    if (v.a()) {
                        MaxAdViewImpl maxAdViewImpl4 = MaxAdViewImpl.this;
                        v vVar = maxAdViewImpl4.logger;
                        String str = maxAdViewImpl4.tag;
                        vVar.b(str, "Loading " + MaxAdViewImpl.this.adFormat.getLabel().toLowerCase(Locale.ENGLISH) + " ad for '" + MaxAdViewImpl.this.adUnitId + "' and notifying " + aVar + "...");
                    }
                    MediationServiceImpl E = MaxAdViewImpl.this.sdk.E();
                    MaxAdViewImpl maxAdViewImpl5 = MaxAdViewImpl.this;
                    String str2 = maxAdViewImpl5.adUnitId;
                    String g2 = maxAdViewImpl5.f14244c;
                    MaxAdViewImpl maxAdViewImpl6 = MaxAdViewImpl.this;
                    E.loadAd(str2, g2, maxAdViewImpl6.adFormat, maxAdViewImpl6.localExtraParameters, maxAdViewImpl6.extraParameters, maxAdViewImpl6.f14242a, aVar);
                }
            });
        } else if (v.a()) {
            v.i(this.tag, "Failed to load new ad - this instance is already destroyed");
        }
    }

    /* access modifiers changed from: private */
    public void a(MaxAd maxAd) {
        this.f14262u = false;
        if (this.f14261t) {
            this.f14261t = false;
            if (v.a()) {
                v vVar = this.logger;
                String str = this.tag;
                vVar.b(str, "Rendering precache request ad: " + maxAd.getAdUnitId() + "...");
            }
            this.f14252k.onAdLoaded(maxAd);
            return;
        }
        if (v.a()) {
            this.logger.b(this.tag, "Saving pre-cache ad...");
        }
        this.f14247f = (com.applovin.impl.mediation.a.b) maxAd;
    }

    /* access modifiers changed from: private */
    public void a(MaxError maxError) {
        if (this.sdk.b(com.applovin.impl.sdk.c.a.f15193o).contains(String.valueOf(maxError.getCode()))) {
            if (v.a()) {
                v A2 = this.sdk.A();
                String str = this.tag;
                A2.b(str, "Ignoring banner ad refresh for error code " + maxError.getCode());
            }
        } else if (this.f14260s || this.f14254m.f()) {
            if (this.f14262u) {
                this.logger.b(this.tag, "Refresh pre-cache failed when auto-refresh is stopped");
                this.f14262u = false;
            }
            if (this.f14261t) {
                this.logger.b(this.tag, "Refresh pre-cache failed - calling ad load failed callback for publisher");
                j.a(this.adListener, this.adUnitId, maxError);
            }
        } else {
            this.f14259r = true;
            this.f14262u = false;
            long longValue = ((Long) this.sdk.a(com.applovin.impl.sdk.c.a.f15192n)).longValue();
            if (longValue >= 0) {
                if (v.a()) {
                    v A3 = this.sdk.A();
                    String str2 = this.tag;
                    A3.b(str2, "Scheduling failed banner ad refresh " + longValue + " milliseconds from now for '" + this.adUnitId + "'...");
                }
                this.f14254m.a(longValue);
            }
        }
    }

    private void a(String str, String str2) {
        if ("allow_pause_auto_refresh_immediately".equalsIgnoreCase(str)) {
            if (v.a()) {
                v vVar = this.logger;
                String str3 = this.tag;
                vVar.b(str3, "Updated allow immediate auto-refresh pause and ad load to: " + str2);
            }
            this.f14264w = Boolean.parseBoolean(str2);
        } else if ("disable_auto_retries".equalsIgnoreCase(str)) {
            if (v.a()) {
                v vVar2 = this.logger;
                String str4 = this.tag;
                vVar2.b(str4, "Updated disable auto-retries to: " + str2);
            }
            this.f14265x = Boolean.parseBoolean(str2);
        } else if ("disable_precache".equalsIgnoreCase(str)) {
            if (v.a()) {
                v vVar3 = this.logger;
                String str5 = this.tag;
                vVar3.b(str5, "Updated precached disabled to: " + str2);
            }
            this.f14266y = Boolean.parseBoolean(str2);
        } else if ("should_stop_auto_refresh_on_ad_expand".equals(str)) {
            if (v.a()) {
                v vVar4 = this.logger;
                String str6 = this.tag;
                vVar4.b(str6, "Updated should stop auto-refresh on ad expand to: " + str2);
            }
            this.f14267z = Boolean.parseBoolean(str2);
        } else if ("force_precache".equals(str)) {
            if (v.a()) {
                v vVar5 = this.logger;
                String str7 = this.tag;
                vVar5.b(str7, "Updated force precache to: " + str2);
            }
            this.A = Boolean.parseBoolean(str2);
        } else if ("adaptive_banner".equalsIgnoreCase(str)) {
            if (v.a()) {
                v vVar6 = this.logger;
                String str8 = this.tag;
                vVar6.b(str8, "Updated is adaptive banner to: " + str2);
            }
            this.B = Boolean.parseBoolean(str2);
            setLocalExtraParameter(str, str2);
        }
    }

    private void b() {
        if (d()) {
            if (v.a()) {
                this.logger.b(this.tag, "Scheduling refresh precache request now");
            }
            this.f14262u = true;
            this.sdk.S().a((com.applovin.impl.sdk.e.a) new com.applovin.impl.sdk.e.z(this.sdk, new Runnable() {
                public void run() {
                    if (v.a()) {
                        MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                        maxAdViewImpl.logger.b(maxAdViewImpl.tag, "Loading ad for pre-cache request...");
                    }
                    MaxAdViewImpl maxAdViewImpl2 = MaxAdViewImpl.this;
                    maxAdViewImpl2.a((a.C0011a) maxAdViewImpl2.f14253l);
                }
            }), com.applovin.impl.mediation.d.c.a(this.adFormat));
        }
    }

    /* access modifiers changed from: private */
    public void b(com.applovin.impl.mediation.a.b bVar) {
        int height = this.f14243b.getHeight();
        int width = this.f14243b.getWidth();
        if (height > 0 || width > 0) {
            int pxToDp = AppLovinSdkUtils.pxToDp(this.f14242a, height);
            int pxToDp2 = AppLovinSdkUtils.pxToDp(this.f14242a, width);
            MaxAdFormat format = bVar.getFormat();
            int height2 = (this.B ? format.getAdaptiveSize(pxToDp2, this.f14242a) : format.getSize()).getHeight();
            int width2 = format.getSize().getWidth();
            if (!v.a()) {
                return;
            }
            if (pxToDp < height2 || pxToDp2 < width2) {
                StringBuilder sb = new StringBuilder();
                sb.append("\n**************************************************\n`MaxAdView` size ");
                sb.append(pxToDp2);
                sb.append("x");
                sb.append(pxToDp);
                sb.append(" dp smaller than required ");
                sb.append(this.B ? "adaptive " : "");
                sb.append("size: ");
                sb.append(width2);
                sb.append("x");
                sb.append(height2);
                sb.append(" dp\nSome mediated networks (e.g. Google Ad Manager) may not render correctly\n**************************************************\n");
                this.logger.e("AppLovinSdk", sb.toString());
            }
        }
    }

    private void c() {
        if (v.a()) {
            v vVar = this.logger;
            String str = this.tag;
            vVar.b(str, "Rendering for cached ad: " + this.f14247f + "...");
        }
        this.f14252k.onAdLoaded(this.f14247f);
        this.f14247f = null;
    }

    private boolean d() {
        if (this.f14266y) {
            return false;
        }
        return ((Boolean) this.sdk.a(com.applovin.impl.sdk.c.a.f15204z)).booleanValue();
    }

    private boolean e() {
        boolean z2;
        synchronized (this.f14257p) {
            z2 = this.f14263v;
        }
        return z2;
    }

    public void destroy() {
        a();
        if (this.f14247f != null) {
            this.sdk.E().destroyAd(this.f14247f);
        }
        synchronized (this.f14257p) {
            this.f14263v = true;
        }
        this.f14254m.c();
        this.sdk.B().b((e.a) this);
        super.destroy();
    }

    public MaxAdFormat getAdFormat() {
        return this.adFormat;
    }

    public String getPlacement() {
        return this.f14250i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00bb, code lost:
        if (com.applovin.impl.sdk.v.a() != false) goto L_0x00c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c2, code lost:
        if (com.applovin.impl.sdk.v.a() != false) goto L_0x00c4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void loadAd() {
        /*
            r5 = this;
            boolean r0 = com.applovin.impl.sdk.v.a()
            if (r0 == 0) goto L_0x002d
            com.applovin.impl.sdk.v r0 = r5.logger
            java.lang.String r1 = r5.tag
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = ""
            r2.append(r3)
            r2.append(r5)
            java.lang.String r3 = " Loading ad for "
            r2.append(r3)
            java.lang.String r3 = r5.adUnitId
            r2.append(r3)
            java.lang.String r3 = "..."
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.b(r1, r2)
        L_0x002d:
            boolean r0 = r5.f14264w
            r1 = 1
            if (r0 != 0) goto L_0x0045
            com.applovin.impl.sdk.m r0 = r5.sdk
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r2 = com.applovin.impl.sdk.c.a.f15199u
            java.lang.Object r0 = r0.a(r2)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0043
            goto L_0x0045
        L_0x0043:
            r0 = 0
            goto L_0x0046
        L_0x0045:
            r0 = 1
        L_0x0046:
            if (r0 == 0) goto L_0x0086
            com.applovin.impl.sdk.d r2 = r5.f14254m
            boolean r2 = r2.f()
            if (r2 != 0) goto L_0x0086
            com.applovin.impl.sdk.d r2 = r5.f14254m
            boolean r2 = r2.a()
            if (r2 == 0) goto L_0x0086
            boolean r0 = com.applovin.impl.sdk.v.a()
            if (r0 == 0) goto L_0x0085
            java.lang.String r0 = r5.tag
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unable to load a new ad. An ad refresh has already been scheduled in "
            r1.append(r2)
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MILLISECONDS
            com.applovin.impl.sdk.d r3 = r5.f14254m
            long r3 = r3.b()
            long r2 = r2.toSeconds(r3)
            r1.append(r2)
            java.lang.String r2 = " seconds."
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.applovin.impl.sdk.v.i(r0, r1)
        L_0x0085:
            return
        L_0x0086:
            java.lang.String r2 = "Loading ad..."
            if (r0 == 0) goto L_0x00be
            com.applovin.impl.mediation.a.b r0 = r5.f14247f
            if (r0 == 0) goto L_0x00a1
            boolean r0 = com.applovin.impl.sdk.v.a()
            if (r0 == 0) goto L_0x009d
            com.applovin.impl.sdk.v r0 = r5.logger
            java.lang.String r1 = r5.tag
            java.lang.String r2 = "Rendering cached ad"
            r0.b(r1, r2)
        L_0x009d:
            r5.c()
            goto L_0x00d0
        L_0x00a1:
            boolean r0 = r5.f14262u
            if (r0 == 0) goto L_0x00b7
            boolean r0 = com.applovin.impl.sdk.v.a()
            if (r0 == 0) goto L_0x00b4
            com.applovin.impl.sdk.v r0 = r5.logger
            java.lang.String r2 = r5.tag
            java.lang.String r3 = "Waiting for precache ad to load to render"
            r0.b(r2, r3)
        L_0x00b4:
            r5.f14261t = r1
            goto L_0x00d0
        L_0x00b7:
            boolean r0 = com.applovin.impl.sdk.v.a()
            if (r0 == 0) goto L_0x00cb
            goto L_0x00c4
        L_0x00be:
            boolean r0 = com.applovin.impl.sdk.v.a()
            if (r0 == 0) goto L_0x00cb
        L_0x00c4:
            com.applovin.impl.sdk.v r0 = r5.logger
            java.lang.String r1 = r5.tag
            r0.b(r1, r2)
        L_0x00cb:
            com.applovin.impl.mediation.ads.MaxAdViewImpl$a r0 = r5.f14252k
            r5.a((com.applovin.impl.mediation.ads.a.C0011a) r0)
        L_0x00d0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.mediation.ads.MaxAdViewImpl.loadAd():void");
    }

    public void onAdRefresh() {
        String str;
        String str2;
        v vVar;
        this.f14261t = false;
        if (this.f14247f != null) {
            c();
            return;
        }
        if (!d()) {
            if (v.a()) {
                vVar = this.logger;
                str2 = this.tag;
                str = "Refreshing ad from network...";
            }
            loadAd();
        } else if (this.f14259r) {
            if (v.a()) {
                vVar = this.logger;
                str2 = this.tag;
                str = "Refreshing ad from network due to viewability requirements not met for refresh request...";
            }
            loadAd();
        } else {
            if (v.a()) {
                this.logger.e(this.tag, "Ignoring attempt to refresh ad - either still waiting for precache or did not attempt request due to visibility requirement not met");
            }
            this.f14261t = true;
            return;
        }
        vVar.b(str2, str);
        loadAd();
    }

    public void onCreativeIdGenerated(String str, String str2) {
        com.applovin.impl.mediation.a.b bVar = this.f14258q;
        if (bVar == null || !bVar.f().equalsIgnoreCase(str)) {
            com.applovin.impl.mediation.a.b bVar2 = this.f14247f;
            if (bVar2 != null && bVar2.f().equalsIgnoreCase(str)) {
                this.f14249h = str;
                this.f14248g = str2;
                return;
            }
            return;
        }
        j.a(this.adReviewListener, str2, (MaxAd) this.f14258q);
    }

    public void onLogVisibilityImpression() {
        a(this.f14258q, this.f14255n.a(this.f14258q));
    }

    public void onWindowVisibilityChanged(int i2) {
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.a.f15197s)).booleanValue() && this.f14254m.a()) {
            if (q.a(i2)) {
                if (v.a()) {
                    this.logger.b(this.tag, "Ad view visible");
                }
                this.f14254m.h();
                return;
            }
            if (v.a()) {
                this.logger.b(this.tag, "Ad view hidden");
            }
            this.f14254m.g();
        }
    }

    public void setCustomData(String str) {
        if (this.f14258q != null) {
            String str2 = this.tag;
            v.i(str2, "Custom data for Ad Unit ID (" + this.adUnitId + ") was set after load was called. For the ads to be correctly attributed to this custom data, please set the custom data before loading the " + this.adFormat.getLabel() + ".");
        }
        Utils.maybeLogCustomDataSizeLimit(str, this.tag);
        this.f14251j = str;
    }

    public void setExtraParameter(String str, String str2) {
        super.setExtraParameter(str, str2);
        a(str, str2);
    }

    public void setPlacement(String str) {
        if (v.a() && this.f14258q != null) {
            String str2 = this.tag;
            v.i(str2, "Placement for Ad Unit ID (" + this.adUnitId + ") was set after load was called. For the ads to be correctly attributed to this placement, please set the placement before loading the " + this.adFormat.getLabel() + ".");
        }
        this.f14250i = str;
    }

    public void setPublisherBackgroundColor(int i2) {
        this.f14246e = (long) i2;
    }

    public void startAutoRefresh() {
        String str;
        String str2;
        v vVar;
        this.f14260s = false;
        if (this.f14254m.f()) {
            this.f14254m.e();
            if (v.a()) {
                vVar = this.logger;
                str2 = this.tag;
                str = "Resumed auto-refresh with remaining time: " + this.f14254m.b() + "ms";
            } else {
                return;
            }
        } else if (v.a()) {
            vVar = this.logger;
            str2 = this.tag;
            str = "Ignoring call to startAutoRefresh() - ad refresh is not paused";
        } else {
            return;
        }
        vVar.b(str2, str);
    }

    public void stopAutoRefresh() {
        if (this.f14258q != null) {
            if (v.a()) {
                v vVar = this.logger;
                String str = this.tag;
                vVar.b(str, "Pausing auto-refresh with remaining time: " + this.f14254m.b() + "ms");
            }
            this.f14254m.d();
        } else if (this.f14264w || ((Boolean) this.sdk.a(com.applovin.impl.sdk.c.a.f15199u)).booleanValue()) {
            this.f14260s = true;
        } else if (v.a()) {
            v.h(this.tag, "Stopping auto-refresh has no effect until after the first ad has been loaded.");
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MaxAdView{adUnitId='");
        sb.append(this.adUnitId);
        sb.append('\'');
        sb.append(", adListener=");
        Object obj = this.adListener;
        if (obj == this.f14243b) {
            obj = "this";
        }
        sb.append(obj);
        sb.append(", isDestroyed=");
        sb.append(e());
        sb.append('}');
        return sb.toString();
    }
}
