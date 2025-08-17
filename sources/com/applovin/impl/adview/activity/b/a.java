package com.applovin.impl.adview.activity.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.impl.adview.i;
import com.applovin.impl.adview.n;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.b.b;
import com.applovin.impl.sdk.d.d;
import com.applovin.impl.sdk.e.o;
import com.applovin.impl.sdk.e.z;
import com.applovin.impl.sdk.h;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.AppKilledService;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.utils.j;
import com.applovin.impl.sdk.utils.o;
import com.applovin.impl.sdk.utils.q;
import com.applovin.impl.sdk.v;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class a implements b.a {
    /* access modifiers changed from: private */
    public int A = 0;
    /* access modifiers changed from: private */
    public final ArrayList<Long> B = new ArrayList<>();

    /* renamed from: a  reason: collision with root package name */
    protected final e f13883a;

    /* renamed from: b  reason: collision with root package name */
    protected final m f13884b;

    /* renamed from: c  reason: collision with root package name */
    protected final v f13885c;

    /* renamed from: d  reason: collision with root package name */
    protected final d f13886d;

    /* renamed from: e  reason: collision with root package name */
    protected Activity f13887e;

    /* renamed from: f  reason: collision with root package name */
    protected AppLovinAdView f13888f;

    /* renamed from: g  reason: collision with root package name */
    protected final com.applovin.impl.adview.m f13889g;

    /* renamed from: h  reason: collision with root package name */
    protected final long f13890h = SystemClock.elapsedRealtime();

    /* renamed from: i  reason: collision with root package name */
    protected long f13891i = -1;

    /* renamed from: j  reason: collision with root package name */
    protected int f13892j = 0;

    /* renamed from: k  reason: collision with root package name */
    protected int f13893k = 0;

    /* renamed from: l  reason: collision with root package name */
    protected int f13894l = h.f15469a;

    /* renamed from: m  reason: collision with root package name */
    protected boolean f13895m;

    /* renamed from: n  reason: collision with root package name */
    protected AppLovinAdClickListener f13896n;

    /* renamed from: o  reason: collision with root package name */
    protected AppLovinAdDisplayListener f13897o;

    /* renamed from: p  reason: collision with root package name */
    protected AppLovinAdVideoPlaybackListener f13898p;

    /* renamed from: q  reason: collision with root package name */
    protected final com.applovin.impl.sdk.b.b f13899q;

    /* renamed from: r  reason: collision with root package name */
    protected o f13900r;

    /* renamed from: s  reason: collision with root package name */
    private final Handler f13901s = new Handler(Looper.getMainLooper());

    /* renamed from: t  reason: collision with root package name */
    private final com.applovin.impl.sdk.utils.a f13902t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public final AppLovinBroadcastManager.Receiver f13903u;

    /* renamed from: v  reason: collision with root package name */
    private final h.a f13904v;

    /* renamed from: w  reason: collision with root package name */
    private final AtomicBoolean f13905w = new AtomicBoolean();
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public final AtomicBoolean f13906x = new AtomicBoolean();

    /* renamed from: y  reason: collision with root package name */
    private long f13907y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f13908z;

    /* renamed from: com.applovin.impl.adview.activity.b.a$a  reason: collision with other inner class name */
    public interface C0008a {
        void a(a aVar);

        void a(String str, Throwable th);
    }

    private class b implements View.OnClickListener, AppLovinAdClickListener {
        private b() {
        }

        public void adClicked(AppLovinAd appLovinAd) {
            if (v.a()) {
                a.this.f13885c.b("AppLovinFullscreenActivity", "Clicking through graphic");
            }
            j.a(a.this.f13896n, appLovinAd);
            a.this.f13886d.b();
            a.this.f13893k++;
        }

        public void onClick(View view) {
            a aVar = a.this;
            if (view == aVar.f13889g && ((Boolean) aVar.f13884b.a(com.applovin.impl.sdk.c.b.cn)).booleanValue()) {
                a.c(a.this);
                if (a.this.f13883a.V()) {
                    a aVar2 = a.this;
                    aVar2.b("javascript:al_onCloseButtonTapped(" + a.this.A + "," + a.this.f13892j + "," + a.this.f13893k + ");");
                }
                List<Integer> t2 = a.this.f13883a.t();
                if (v.a()) {
                    v vVar = a.this.f13885c;
                    vVar.b("AppLovinFullscreenActivity", "Handling close button tap " + a.this.A + " with multi close delay: " + t2);
                }
                if (t2 == null || t2.size() <= a.this.A) {
                    a.this.h();
                    return;
                }
                a.this.B.add(Long.valueOf(SystemClock.elapsedRealtime() - a.this.f13891i));
                List<i.a> v2 = a.this.f13883a.v();
                if (v2 != null && v2.size() > a.this.A) {
                    a aVar3 = a.this;
                    aVar3.f13889g.a(v2.get(aVar3.A));
                }
                if (v.a()) {
                    v vVar2 = a.this.f13885c;
                    vVar2.b("AppLovinFullscreenActivity", "Scheduling next close button with delay: " + t2.get(a.this.A));
                }
                a.this.f13889g.setVisibility(8);
                a aVar4 = a.this;
                aVar4.a(aVar4.f13889g, (long) t2.get(aVar4.A).intValue(), new Runnable() {
                    public void run() {
                        a.this.f13891i = SystemClock.elapsedRealtime();
                    }
                });
            } else if (v.a()) {
                v vVar3 = a.this.f13885c;
                vVar3.e("AppLovinFullscreenActivity", "Unhandled click on widget: " + view);
            }
        }
    }

    a(final e eVar, Activity activity, final m mVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        this.f13883a = eVar;
        this.f13884b = mVar;
        this.f13885c = mVar.A();
        this.f13887e = activity;
        this.f13896n = appLovinAdClickListener;
        this.f13897o = appLovinAdDisplayListener;
        this.f13898p = appLovinAdVideoPlaybackListener;
        com.applovin.impl.sdk.b.b bVar = new com.applovin.impl.sdk.b.b(activity, mVar);
        this.f13899q = bVar;
        bVar.a((b.a) this);
        d dVar = new d(eVar, mVar);
        this.f13886d = dVar;
        b bVar2 = new b();
        n nVar = new n(mVar.Y(), AppLovinAdSize.INTERSTITIAL, activity);
        this.f13888f = nVar;
        nVar.setAdClickListener(bVar2);
        this.f13888f.setAdDisplayListener(new AppLovinAdDisplayListener() {
            public void adDisplayed(AppLovinAd appLovinAd) {
                if (v.a()) {
                    a.this.f13885c.b("AppLovinFullscreenActivity", "Web content rendered");
                }
            }

            public void adHidden(AppLovinAd appLovinAd) {
                if (v.a()) {
                    a.this.f13885c.b("AppLovinFullscreenActivity", "Closing from WebView");
                }
                a.this.h();
            }
        });
        this.f13888f.getController().a(dVar);
        mVar.u().trackImpression(eVar);
        List<Integer> t2 = eVar.t();
        if (eVar.s() >= 0 || t2 != null) {
            com.applovin.impl.adview.m mVar2 = new com.applovin.impl.adview.m(eVar.u(), activity);
            this.f13889g = mVar2;
            mVar2.setVisibility(8);
            mVar2.setOnClickListener(bVar2);
        } else {
            this.f13889g = null;
        }
        if (((Boolean) mVar.a(com.applovin.impl.sdk.c.b.cp)).booleanValue()) {
            this.f13903u = new AppLovinBroadcastManager.Receiver() {
                public void onReceive(Context context, Intent intent, Map<String, Object> map) {
                    mVar.u().trackAppKilled(eVar);
                    mVar.aj().unregisterReceiver(this);
                }
            };
        } else {
            this.f13903u = null;
        }
        if (eVar.al()) {
            this.f13904v = new h.a() {
                public void a(int i2) {
                    String str;
                    a aVar = a.this;
                    if (aVar.f13894l != h.f15469a) {
                        aVar.f13895m = true;
                    }
                    com.applovin.impl.adview.d s2 = aVar.f13888f.getController().s();
                    if (!h.a(i2) || h.a(a.this.f13894l)) {
                        if (i2 == 2) {
                            str = "javascript:al_muteSwitchOff();";
                        }
                        a.this.f13894l = i2;
                    }
                    str = "javascript:al_muteSwitchOn();";
                    s2.a(str);
                    a.this.f13894l = i2;
                }
            };
        } else {
            this.f13904v = null;
        }
        if (((Boolean) mVar.a(com.applovin.impl.sdk.c.b.eC)).booleanValue()) {
            this.f13902t = new com.applovin.impl.sdk.utils.a() {
                public void onActivityCreated(Activity activity, Bundle bundle) {
                    if (!a.this.f13906x.get()) {
                        if (activity.getClass().getName().equals(Utils.retrieveLauncherActivityFullyQualifiedName(activity.getApplicationContext()))) {
                            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                                public void run() {
                                    v.i("AppLovinFullscreenActivity", "Dismissing on-screen ad due to app relaunched via launcher.");
                                    try {
                                        a.this.h();
                                    } catch (Throwable unused) {
                                    }
                                }
                            });
                        }
                    }
                }
            };
        } else {
            this.f13902t = null;
        }
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [com.applovin.impl.adview.activity.b.a] */
    /* JADX WARNING: type inference failed for: r1v27, types: [com.applovin.impl.adview.activity.b.b] */
    /* JADX WARNING: type inference failed for: r1v28, types: [com.applovin.impl.adview.activity.b.f] */
    /* JADX WARNING: type inference failed for: r1v29, types: [com.applovin.impl.adview.activity.b.f] */
    /* JADX WARNING: type inference failed for: r1v30, types: [com.applovin.impl.adview.activity.b.e] */
    /* JADX WARNING: type inference failed for: r1v31, types: [com.applovin.impl.adview.activity.b.g] */
    /* JADX WARNING: type inference failed for: r1v32, types: [com.applovin.impl.adview.activity.b.d] */
    /* JADX WARNING: type inference failed for: r1v33, types: [com.applovin.impl.adview.activity.b.d] */
    /* JADX WARNING: type inference failed for: r1v34, types: [com.applovin.impl.adview.activity.b.c] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(com.applovin.impl.sdk.ad.e r15, com.applovin.sdk.AppLovinAdClickListener r16, com.applovin.sdk.AppLovinAdDisplayListener r17, com.applovin.sdk.AppLovinAdVideoPlaybackListener r18, com.applovin.impl.sdk.m r19, android.app.Activity r20, com.applovin.impl.adview.activity.b.a.C0008a r21) {
        /*
            r8 = r19
            r9 = r21
            boolean r0 = r15.aH()
            if (r0 == 0) goto L_0x0012
            boolean r0 = com.applovin.impl.sdk.utils.Utils.checkExoPlayerEligibility(r19)
            if (r0 == 0) goto L_0x0012
            r0 = 1
            goto L_0x0013
        L_0x0012:
            r0 = 0
        L_0x0013:
            r10 = r15
            boolean r1 = r10 instanceof com.applovin.impl.a.a
            java.lang.String r11 = "Failed to create ExoPlayer presenter to show the ad. Falling back to using native media player presenter."
            java.lang.String r12 = "AppLovinFullscreenActivity"
            java.lang.String r13 = " and throwable: "
            if (r1 == 0) goto L_0x00a9
            java.lang.String r14 = "Failed to create FullscreenVastVideoAdPresenter with sdk: "
            if (r0 == 0) goto L_0x0078
            com.applovin.impl.adview.activity.b.c r0 = new com.applovin.impl.adview.activity.b.c     // Catch:{ all -> 0x0035 }
            r1 = r0
            r2 = r15
            r3 = r20
            r4 = r19
            r5 = r16
            r6 = r17
            r7 = r18
            r1.<init>(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0035 }
            goto L_0x0184
        L_0x0035:
            r0 = move-exception
            boolean r1 = com.applovin.impl.sdk.v.a()
            if (r1 == 0) goto L_0x0043
            com.applovin.impl.sdk.v r1 = r19.A()
            r1.a((java.lang.String) r12, (java.lang.String) r11, (java.lang.Throwable) r0)
        L_0x0043:
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            com.applovin.impl.sdk.utils.Utils.isExoPlayerEligible = r0
            com.applovin.impl.adview.activity.b.d r0 = new com.applovin.impl.adview.activity.b.d     // Catch:{ all -> 0x005a }
            r1 = r0
            r2 = r15
            r3 = r20
            r4 = r19
            r5 = r16
            r6 = r17
            r7 = r18
            r1.<init>(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x005a }
            goto L_0x0184
        L_0x005a:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r14)
            r1.append(r8)
            r1.append(r13)
            java.lang.String r2 = r0.getMessage()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r9.a(r1, r0)
            return
        L_0x0078:
            com.applovin.impl.adview.activity.b.d r0 = new com.applovin.impl.adview.activity.b.d     // Catch:{ all -> 0x008b }
            r1 = r0
            r2 = r15
            r3 = r20
            r4 = r19
            r5 = r16
            r6 = r17
            r7 = r18
            r1.<init>(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x008b }
            goto L_0x0184
        L_0x008b:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r14)
            r1.append(r8)
            r1.append(r13)
            java.lang.String r2 = r0.getMessage()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r9.a(r1, r0)
            return
        L_0x00a9:
            boolean r1 = r15.hasVideoUrl()
            if (r1 == 0) goto L_0x0173
            boolean r1 = r15.aK()
            if (r1 == 0) goto L_0x00e8
            com.applovin.impl.adview.activity.b.g r0 = new com.applovin.impl.adview.activity.b.g     // Catch:{ all -> 0x00c8 }
            r1 = r0
            r2 = r15
            r3 = r20
            r4 = r19
            r5 = r16
            r6 = r17
            r7 = r18
            r1.<init>(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x00c8 }
            goto L_0x0184
        L_0x00c8:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to create FullscreenWebVideoAdPresenter with sdk: "
            r1.append(r2)
            r1.append(r8)
            r1.append(r13)
            java.lang.String r2 = r0.getMessage()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r9.a(r1, r0)
            return
        L_0x00e8:
            if (r0 == 0) goto L_0x0141
            com.applovin.impl.adview.activity.b.e r0 = new com.applovin.impl.adview.activity.b.e     // Catch:{ all -> 0x00fd }
            r1 = r0
            r2 = r15
            r3 = r20
            r4 = r19
            r5 = r16
            r6 = r17
            r7 = r18
            r1.<init>(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x00fd }
            goto L_0x0184
        L_0x00fd:
            r0 = move-exception
            boolean r1 = com.applovin.impl.sdk.v.a()
            if (r1 == 0) goto L_0x010b
            com.applovin.impl.sdk.v r1 = r19.A()
            r1.a((java.lang.String) r12, (java.lang.String) r11, (java.lang.Throwable) r0)
        L_0x010b:
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            com.applovin.impl.sdk.utils.Utils.isExoPlayerEligible = r0
            com.applovin.impl.adview.activity.b.f r0 = new com.applovin.impl.adview.activity.b.f     // Catch:{ all -> 0x0121 }
            r1 = r0
            r2 = r15
            r3 = r20
            r4 = r19
            r5 = r16
            r6 = r17
            r7 = r18
            r1.<init>(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0121 }
            goto L_0x0184
        L_0x0121:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to create FullscreenVideoAdExoPlayerPresenter with sdk: "
            r1.append(r2)
            r1.append(r8)
            r1.append(r13)
            java.lang.String r2 = r0.getMessage()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r9.a(r1, r0)
            return
        L_0x0141:
            com.applovin.impl.adview.activity.b.f r0 = new com.applovin.impl.adview.activity.b.f     // Catch:{ all -> 0x0153 }
            r1 = r0
            r2 = r15
            r3 = r20
            r4 = r19
            r5 = r16
            r6 = r17
            r7 = r18
            r1.<init>(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0153 }
            goto L_0x0184
        L_0x0153:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to create FullscreenVideoAdPresenter with sdk: "
            r1.append(r2)
            r1.append(r8)
            r1.append(r13)
            java.lang.String r2 = r0.getMessage()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r9.a(r1, r0)
            return
        L_0x0173:
            com.applovin.impl.adview.activity.b.b r0 = new com.applovin.impl.adview.activity.b.b     // Catch:{ all -> 0x018b }
            r1 = r0
            r2 = r15
            r3 = r20
            r4 = r19
            r5 = r16
            r6 = r17
            r7 = r18
            r1.<init>(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x018b }
        L_0x0184:
            r0.c()
            r9.a(r0)
            return
        L_0x018b:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to create FullscreenGraphicAdPresenter with sdk: "
            r1.append(r2)
            r1.append(r8)
            r1.append(r13)
            java.lang.String r2 = r0.getMessage()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r9.a(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.adview.activity.b.a.a(com.applovin.impl.sdk.ad.e, com.applovin.sdk.AppLovinAdClickListener, com.applovin.sdk.AppLovinAdDisplayListener, com.applovin.sdk.AppLovinAdVideoPlaybackListener, com.applovin.impl.sdk.m, android.app.Activity, com.applovin.impl.adview.activity.b.a$a):void");
    }

    static /* synthetic */ int c(a aVar) {
        int i2 = aVar.A;
        aVar.A = i2 + 1;
        return i2;
    }

    private void c() {
        if (this.f13903u != null) {
            this.f13884b.aj().registerReceiver(this.f13903u, new IntentFilter(AppKilledService.ACTION_APP_KILLED));
        }
        if (this.f13904v != null) {
            this.f13884b.ai().a(this.f13904v);
        }
        if (this.f13902t != null) {
            this.f13884b.af().a(this.f13902t);
        }
    }

    public void a(int i2, KeyEvent keyEvent) {
        if (this.f13885c != null && v.a()) {
            v vVar = this.f13885c;
            vVar.c("AppLovinFullscreenActivity", "onKeyDown(int, KeyEvent) -  " + i2 + ", " + keyEvent);
        }
    }

    /* access modifiers changed from: protected */
    public void a(int i2, boolean z2, boolean z3, long j2) {
        int i3 = i2;
        if (this.f13905w.compareAndSet(false, true)) {
            if (this.f13883a.hasVideoUrl() || t()) {
                j.a(this.f13898p, (AppLovinAd) this.f13883a, (double) i3, z3);
            }
            if (this.f13883a.hasVideoUrl()) {
                this.f13886d.c((long) i3);
            }
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.f13890h;
            this.f13884b.u().trackVideoEnd(this.f13883a, TimeUnit.MILLISECONDS.toSeconds(elapsedRealtime), i2, z2);
            long j3 = -1;
            if (this.f13891i != -1) {
                j3 = SystemClock.elapsedRealtime() - this.f13891i;
            }
            this.f13884b.u().trackFullScreenAdClosed(this.f13883a, j3, this.B, j2, this.f13895m, this.f13894l);
            if (v.a()) {
                v vVar = this.f13885c;
                vVar.b("AppLovinFullscreenActivity", "Video ad ended at percent: " + i3 + "%, elapsedTime: " + elapsedRealtime + "ms, skipTimeMillis: " + j2 + "ms, closeTimeMillis: " + j3 + "ms");
            }
        }
    }

    public abstract void a(long j2);

    public void a(Configuration configuration) {
        if (v.a()) {
            v vVar = this.f13885c;
            vVar.c("AppLovinFullscreenActivity", "onConfigurationChanged(Configuration) -  " + configuration);
        }
    }

    public abstract void a(ViewGroup viewGroup);

    /* access modifiers changed from: protected */
    public void a(final com.applovin.impl.adview.m mVar, long j2, final Runnable runnable) {
        if (j2 < ((Long) this.f13884b.a(com.applovin.impl.sdk.c.b.cm)).longValue()) {
            this.f13884b.S().a(new z(this.f13884b, new Runnable() {
                public void run() {
                    AppLovinSdkUtils.runOnUiThread(new Runnable() {
                        public void run() {
                            q.a((View) mVar, 400, (Runnable) new Runnable() {
                                public void run() {
                                    mVar.bringToFront();
                                    runnable.run();
                                }
                            });
                        }
                    });
                }
            }), o.a.MAIN, TimeUnit.SECONDS.toMillis(j2), true);
        }
    }

    /* access modifiers changed from: protected */
    public void a(Runnable runnable, long j2) {
        AppLovinSdkUtils.runOnUiThreadDelayed(runnable, j2, this.f13901s);
    }

    /* access modifiers changed from: protected */
    public void a(String str) {
        if (this.f13883a.W()) {
            a(str, 0);
        }
    }

    /* access modifiers changed from: protected */
    public void a(final String str, long j2) {
        if (j2 >= 0) {
            a((Runnable) new Runnable() {
                public void run() {
                    AppLovinAdView appLovinAdView;
                    com.applovin.impl.adview.d s2;
                    if (StringUtils.isValidString(str) && (appLovinAdView = a.this.f13888f) != null && (s2 = appLovinAdView.getController().s()) != null) {
                        s2.a(str);
                    }
                }
            }, j2);
        }
    }

    /* access modifiers changed from: protected */
    public void a(boolean z2) {
        List<Uri> checkCachedResourcesExist = Utils.checkCachedResourcesExist(z2, this.f13883a, this.f13884b, this.f13887e);
        if (checkCachedResourcesExist.isEmpty()) {
            return;
        }
        if (!((Boolean) this.f13884b.a(com.applovin.impl.sdk.c.b.eG)).booleanValue()) {
            this.f13883a.a();
            return;
        }
        throw new IllegalStateException("Missing cached resource(s): " + checkCachedResourcesExist);
    }

    /* access modifiers changed from: protected */
    public void a(boolean z2, long j2) {
        if (this.f13883a.U()) {
            a(z2 ? "javascript:al_mute();" : "javascript:al_unmute();", j2);
        }
    }

    /* access modifiers changed from: protected */
    public void b(long j2) {
        if (v.a()) {
            v vVar = this.f13885c;
            vVar.b("AppLovinFullscreenActivity", "Scheduling report reward in " + TimeUnit.MILLISECONDS.toSeconds(j2) + " seconds...");
        }
        this.f13900r = com.applovin.impl.sdk.utils.o.a(j2, this.f13884b, new Runnable() {
            public void run() {
                if (!a.this.f13883a.ag().getAndSet(true)) {
                    a aVar = a.this;
                    a.this.f13884b.S().a((com.applovin.impl.sdk.e.a) new com.applovin.impl.sdk.e.v(aVar.f13883a, aVar.f13884b), o.a.REWARD);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void b(String str) {
        a(str, 0);
    }

    /* access modifiers changed from: protected */
    public void b(boolean z2) {
        a(z2, ((Long) this.f13884b.a(com.applovin.impl.sdk.c.b.cC)).longValue());
        j.a(this.f13897o, (AppLovinAd) this.f13883a);
        this.f13884b.ae().a((Object) this.f13883a);
        this.f13884b.ak().a((Object) this.f13883a);
        if (this.f13883a.hasVideoUrl() || t()) {
            j.a(this.f13898p, (AppLovinAd) this.f13883a);
        }
        new com.applovin.impl.adview.activity.b(this.f13887e).a(this.f13883a);
        this.f13886d.a();
        this.f13883a.setHasShown(true);
    }

    public void c(boolean z2) {
        if (v.a()) {
            v vVar = this.f13885c;
            vVar.c("AppLovinFullscreenActivity", "onWindowFocusChanged(boolean) - " + z2);
        }
        a("javascript:al_onWindowFocusChanged( " + z2 + " );");
    }

    public abstract void d();

    public abstract void e();

    public void f() {
        if (v.a()) {
            this.f13885c.c("AppLovinFullscreenActivity", "onResume()");
        }
        this.f13886d.d(SystemClock.elapsedRealtime() - this.f13907y);
        a("javascript:al_onAppResumed();");
        q();
        if (this.f13899q.c()) {
            this.f13899q.a();
        }
    }

    public void g() {
        if (v.a()) {
            this.f13885c.c("AppLovinFullscreenActivity", "onPause()");
        }
        this.f13907y = SystemClock.elapsedRealtime();
        a("javascript:al_onAppPaused();");
        if (this.f13899q.c()) {
            this.f13899q.a();
        }
        p();
    }

    public void h() {
        this.f13908z = true;
        if (v.a()) {
            this.f13885c.c("AppLovinFullscreenActivity", "dismiss()");
        }
        e eVar = this.f13883a;
        if (eVar != null) {
            eVar.o().e();
        }
        this.f13901s.removeCallbacksAndMessages((Object) null);
        a("javascript:al_onPoststitialDismiss();", (long) this.f13883a.T());
        n();
        this.f13886d.c();
        if (this.f13903u != null) {
            com.applovin.impl.sdk.utils.o.a(TimeUnit.SECONDS.toMillis(2), this.f13884b, new Runnable() {
                public void run() {
                    a.this.f13887e.stopService(new Intent(a.this.f13887e.getApplicationContext(), AppKilledService.class));
                    a.this.f13884b.aj().unregisterReceiver(a.this.f13903u);
                }
            });
        }
        if (this.f13904v != null) {
            this.f13884b.ai().b(this.f13904v);
        }
        if (this.f13902t != null) {
            this.f13884b.af().b(this.f13902t);
        }
        if (o()) {
            this.f13887e.finish();
            return;
        }
        if (v.a()) {
            this.f13884b.A().b("AppLovinFullscreenActivity", "Fullscreen ad shown in container view dismissed, destroying the presenter.");
        }
        k();
    }

    public boolean i() {
        return this.f13908z;
    }

    public void j() {
        if (v.a()) {
            this.f13885c.c("AppLovinFullscreenActivity", "onStop()");
        }
    }

    public void k() {
        AppLovinAdView appLovinAdView = this.f13888f;
        if (appLovinAdView != null) {
            ViewParent parent = appLovinAdView.getParent();
            this.f13888f.destroy();
            this.f13888f = null;
            if ((parent instanceof ViewGroup) && o()) {
                ((ViewGroup) parent).removeAllViews();
            }
        }
        m();
        n();
        this.f13896n = null;
        this.f13897o = null;
        this.f13898p = null;
        this.f13887e = null;
    }

    public void l() {
        if (v.a()) {
            this.f13885c.c("AppLovinFullscreenActivity", "onBackPressed()");
        }
        if (this.f13883a.V()) {
            b("javascript:onBackPressed();");
        }
    }

    /* access modifiers changed from: protected */
    public abstract void m();

    /* access modifiers changed from: protected */
    public void n() {
        if (this.f13906x.compareAndSet(false, true)) {
            j.b(this.f13897o, (AppLovinAd) this.f13883a);
            this.f13884b.ae().b((Object) this.f13883a);
            this.f13884b.ak().a();
        }
    }

    /* access modifiers changed from: protected */
    public boolean o() {
        return this.f13887e instanceof AppLovinFullscreenActivity;
    }

    /* access modifiers changed from: protected */
    public void p() {
        com.applovin.impl.sdk.utils.o oVar = this.f13900r;
        if (oVar != null) {
            oVar.b();
        }
    }

    /* access modifiers changed from: protected */
    public void q() {
        com.applovin.impl.sdk.utils.o oVar = this.f13900r;
        if (oVar != null) {
            oVar.c();
        }
    }

    /* access modifiers changed from: protected */
    public abstract boolean r();

    /* access modifiers changed from: protected */
    public abstract boolean s();

    /* access modifiers changed from: protected */
    public boolean t() {
        return AppLovinAdType.INCENTIVIZED == this.f13883a.getType() || AppLovinAdType.AUTO_INCENTIVIZED == this.f13883a.getType();
    }

    /* access modifiers changed from: protected */
    public abstract void u();
}
