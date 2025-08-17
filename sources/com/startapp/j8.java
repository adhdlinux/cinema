package com.startapp;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import com.startapp.sdk.ads.interstitials.OverlayAd;
import com.startapp.sdk.ads.interstitials.ReturnAd;
import com.startapp.sdk.ads.offerWall.offerWallHtml.OfferWallAd;
import com.startapp.sdk.ads.offerWall.offerWallJson.OfferWall3DAd;
import com.startapp.sdk.ads.splash.SplashAd;
import com.startapp.sdk.ads.video.VideoEnabledAd;
import com.startapp.sdk.adsbase.ActivityExtra;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.AdsCommonMetaData;
import com.startapp.sdk.adsbase.StartAppAd;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.cache.CachedAd$3;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.components.ComponentLocator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class j8 {

    /* renamed from: a  reason: collision with root package name */
    public final AdPreferences.Placement f34743a;

    /* renamed from: b  reason: collision with root package name */
    public Context f34744b;

    /* renamed from: c  reason: collision with root package name */
    public ActivityExtra f34745c;

    /* renamed from: d  reason: collision with root package name */
    public AdPreferences f34746d;

    /* renamed from: e  reason: collision with root package name */
    public v6 f34747e = null;

    /* renamed from: f  reason: collision with root package name */
    public AtomicBoolean f34748f = new AtomicBoolean(false);

    /* renamed from: g  reason: collision with root package name */
    public long f34749g;

    /* renamed from: h  reason: collision with root package name */
    public String f34750h = null;

    /* renamed from: i  reason: collision with root package name */
    public boolean f34751i = false;

    /* renamed from: j  reason: collision with root package name */
    public g8 f34752j = null;

    /* renamed from: k  reason: collision with root package name */
    public e8 f34753k = null;

    /* renamed from: l  reason: collision with root package name */
    public final Map<AdEventListener, List<StartAppAd>> f34754l = new ConcurrentHashMap();

    /* renamed from: m  reason: collision with root package name */
    public int f34755m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f34756n = true;

    /* renamed from: o  reason: collision with root package name */
    public Long f34757o;

    /* renamed from: p  reason: collision with root package name */
    public b f34758p;

    public class a implements AdEventListener {

        /* renamed from: a  reason: collision with root package name */
        public boolean f34759a = false;

        /* renamed from: b  reason: collision with root package name */
        public boolean f34760b = false;

        public a() {
        }

        public void onFailedToReceiveAd(Ad ad) {
            List<StartAppAd> a2;
            ConcurrentHashMap concurrentHashMap;
            ConcurrentHashMap concurrentHashMap2 = null;
            if (!this.f34760b) {
                synchronized (j8.this.f34754l) {
                    concurrentHashMap = new ConcurrentHashMap(j8.this.f34754l);
                    j8 j8Var = j8.this;
                    j8Var.f34747e = null;
                    j8Var.f34754l.clear();
                }
                concurrentHashMap2 = concurrentHashMap;
            }
            if (concurrentHashMap2 != null) {
                for (AdEventListener adEventListener : concurrentHashMap2.keySet()) {
                    if (!(adEventListener == null || (a2 = j8.this.a(concurrentHashMap2, adEventListener)) == null)) {
                        for (StartAppAd next : a2) {
                            if (ad != null) {
                                next.setErrorMessage(ad.getErrorMessage());
                            }
                            p.a(j8.this.f34744b, adEventListener, (Ad) next);
                        }
                    }
                }
            }
            this.f34760b = true;
            j8.this.f34753k.d();
            j8.this.f34752j.e();
            j8.this.f34748f.set(false);
        }

        public void onReceiveAd(Ad ad) {
            boolean z2;
            v6 v6Var = j8.this.f34747e;
            if (v6Var == null || !v6Var.a()) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (!this.f34759a && !z2) {
                this.f34759a = true;
                synchronized (j8.this.f34754l) {
                    for (AdEventListener next : j8.this.f34754l.keySet()) {
                        if (next != null) {
                            j8 j8Var = j8.this;
                            List<StartAppAd> a2 = j8Var.a(j8Var.f34754l, next);
                            if (a2 != null) {
                                for (StartAppAd errorMessage : a2) {
                                    errorMessage.setErrorMessage(ad.getErrorMessage());
                                    p.b(j8.this.f34744b, next, ad);
                                }
                            }
                        }
                    }
                    j8.this.f34754l.clear();
                }
            }
            j8.this.f34752j.d();
            j8.this.f34753k.f();
            j8.this.f34748f.set(false);
        }
    }

    public interface b {
    }

    public j8(Context context, AdPreferences.Placement placement, AdPreferences adPreferences) {
        this.f34743a = placement;
        this.f34746d = adPreferences;
        a(context);
        a();
    }

    public final void a(Context context) {
        if (context instanceof Activity) {
            this.f34744b = ia.b(context);
            this.f34745c = new ActivityExtra((Activity) context);
            return;
        }
        this.f34744b = context;
        this.f34745c = null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x004c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b() {
        /*
            r6 = this;
            boolean r0 = r6.c()
            if (r0 == 0) goto L_0x006c
            android.content.Context r0 = r6.f34744b
            com.startapp.v6 r1 = r6.f34747e
            com.startapp.sdk.adsbase.Ad r1 = (com.startapp.sdk.adsbase.Ad) r1
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0049
            java.util.HashSet r4 = new java.util.HashSet
            r4.<init>()
            boolean r5 = r1 instanceof com.startapp.sdk.adsbase.HtmlAd
            if (r5 == 0) goto L_0x0031
            com.startapp.sdk.adsbase.HtmlAd r1 = (com.startapp.sdk.adsbase.HtmlAd) r1
            java.lang.String r1 = r1.j()
            java.util.List r1 = com.startapp.p.a((java.lang.String) r1, (int) r3)
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.lang.Boolean r0 = com.startapp.p.a((android.content.Context) r0, (java.util.List<com.startapp.sdk.adsbase.apppresence.AppPresenceDetails>) r1, (int) r3, (java.util.Set<java.lang.String>) r4, (java.util.List<com.startapp.sdk.adsbase.apppresence.AppPresenceDetails>) r5)
            boolean r0 = r0.booleanValue()
            goto L_0x004a
        L_0x0031:
            boolean r5 = r1 instanceof com.startapp.sdk.adsbase.JsonAd
            if (r5 == 0) goto L_0x0049
            com.startapp.sdk.adsbase.JsonAd r1 = (com.startapp.sdk.adsbase.JsonAd) r1
            java.util.List r1 = r1.g()
            java.util.List r0 = com.startapp.p.a((android.content.Context) r0, (java.util.List<com.startapp.sdk.adsbase.model.AdDetails>) r1, (int) r3, (java.util.Set<java.lang.String>) r4, (boolean) r3)
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            int r0 = r0.size()
            if (r0 != 0) goto L_0x0049
            r0 = 1
            goto L_0x004a
        L_0x0049:
            r0 = 0
        L_0x004a:
            if (r0 != 0) goto L_0x0067
            com.startapp.v6 r0 = r6.f34747e
            if (r0 != 0) goto L_0x0052
            r0 = 0
            goto L_0x0056
        L_0x0052:
            boolean r0 = r0.d()
        L_0x0056:
            if (r0 == 0) goto L_0x0059
            goto L_0x0067
        L_0x0059:
            java.util.concurrent.atomic.AtomicBoolean r0 = r6.f34748f
            boolean r0 = r0.get()
            if (r0 != 0) goto L_0x0079
            com.startapp.g8 r0 = r6.f34752j
            r0.d()
            goto L_0x0079
        L_0x0067:
            r0 = 0
            r6.a(r0, r0, r2, r3)
            goto L_0x0079
        L_0x006c:
            java.util.concurrent.atomic.AtomicBoolean r0 = r6.f34748f
            boolean r0 = r0.get()
            if (r0 != 0) goto L_0x0079
            com.startapp.e8 r0 = r6.f34753k
            r0.d()
        L_0x0079:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.j8.b():void");
    }

    public boolean c() {
        v6 v6Var = this.f34747e;
        return v6Var != null && v6Var.isReady();
    }

    public final void a(boolean z2) {
        v6 v6Var;
        boolean z3;
        boolean z4 = false;
        if (z2) {
            Long h2 = AdsCommonMetaData.f36186h.h();
            if (h2 == null || this.f34757o == null || SystemClock.elapsedRealtime() - this.f34757o.longValue() >= h2.longValue()) {
                this.f34757o = Long.valueOf(SystemClock.elapsedRealtime());
                z3 = false;
            } else {
                p.a(this.f34744b, (AdEventListener) new a(), (Ad) new CachedAd$3(this, this.f34744b, this.f34743a));
                Context context = this.f34744b;
                lb.a(context, true, "Failed to load " + this.f34743a.name() + " ad: NO FILL", true);
                z3 = true;
            }
            if (z3) {
                return;
            }
        }
        int ordinal = this.f34743a.ordinal();
        if (ordinal == 0) {
            v6Var = new OverlayAd(this.f34744b);
        } else if (ordinal == 7) {
            v6Var = new ReturnAd(this.f34744b);
        } else if (ordinal == 2) {
            if (new Random().nextInt(100) < AdsCommonMetaData.f36186h.w()) {
                z4 = true;
            }
            boolean isForceOfferWall3D = this.f34746d.isForceOfferWall3D();
            boolean isForceOfferWall2D = true ^ this.f34746d.isForceOfferWall2D();
            Map<Activity, Integer> map = lb.f34876a;
            if ((z4 || isForceOfferWall3D) && isForceOfferWall2D) {
                v6Var = new OfferWall3DAd(this.f34744b);
            } else {
                v6Var = new OfferWallAd(this.f34744b);
            }
        } else if (ordinal == 3) {
            v6Var = new SplashAd(this.f34744b);
        } else if (ordinal != 4) {
            v6Var = new OverlayAd(this.f34744b);
        } else {
            Map<Activity, Integer> map2 = lb.f34876a;
            v6Var = new VideoEnabledAd(this.f34744b, AdPreferences.Placement.INAPP_OVERLAY);
        }
        this.f34747e = v6Var;
        v6Var.setActivityExtra(this.f34745c);
        this.f34746d.setAutoLoadAmount(this.f34755m);
        this.f34747e.load(this.f34746d, new a());
        this.f34749g = System.currentTimeMillis();
    }

    public final void b(boolean z2) {
        v6 v6Var = this.f34747e;
        if (v6Var != null) {
            v6Var.a(false);
        }
        if (this.f34751i && this.f34750h != null) {
            this.f34751i = false;
            h8 h8Var = new h8(this, new a(), z2);
            Context context = this.f34744b;
            ComponentLocator.a(context).h().execute(new m8(context, this.f34750h, h8Var, new i8(this)));
            return;
        }
        a(z2);
    }

    public final void a() {
        this.f34752j = new g8(this);
        this.f34753k = new e8(this);
    }

    public List<StartAppAd> a(Map<AdEventListener, List<StartAppAd>> map, AdEventListener adEventListener) {
        try {
            return map.get(adEventListener);
        } catch (Throwable th) {
            y8.a(this.f34744b, th);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x001f A[ADDED_TO_REGION, Catch:{ all -> 0x0036 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0055 A[ADDED_TO_REGION, Catch:{ all -> 0x0036 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.startapp.sdk.adsbase.StartAppAd r5, com.startapp.sdk.adsbase.adlisteners.AdEventListener r6, boolean r7, boolean r8) {
        /*
            r4 = this;
            java.util.Map<com.startapp.sdk.adsbase.adlisteners.AdEventListener, java.util.List<com.startapp.sdk.adsbase.StartAppAd>> r0 = r4.f34754l
            monitor-enter(r0)
            boolean r1 = r4.c()     // Catch:{ all -> 0x0060 }
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x001c
            com.startapp.v6 r1 = r4.f34747e     // Catch:{ all -> 0x0060 }
            if (r1 != 0) goto L_0x0011
            r1 = 0
            goto L_0x0015
        L_0x0011:
            boolean r1 = r1.d()     // Catch:{ all -> 0x0060 }
        L_0x0015:
            if (r1 != 0) goto L_0x001c
            if (r7 == 0) goto L_0x001a
            goto L_0x001c
        L_0x001a:
            r7 = 0
            goto L_0x001d
        L_0x001c:
            r7 = 1
        L_0x001d:
            if (r7 == 0) goto L_0x0055
            if (r5 == 0) goto L_0x003f
            if (r6 == 0) goto L_0x003f
            java.util.Map<com.startapp.sdk.adsbase.adlisteners.AdEventListener, java.util.List<com.startapp.sdk.adsbase.StartAppAd>> r7 = r4.f34754l     // Catch:{ all -> 0x0060 }
            java.util.List r7 = r4.a(r7, r6)     // Catch:{ all -> 0x0060 }
            if (r7 != 0) goto L_0x003c
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ all -> 0x0060 }
            r7.<init>()     // Catch:{ all -> 0x0060 }
            java.util.Map<com.startapp.sdk.adsbase.adlisteners.AdEventListener, java.util.List<com.startapp.sdk.adsbase.StartAppAd>> r1 = r4.f34754l     // Catch:{ all -> 0x0060 }
            r1.put(r6, r7)     // Catch:{ all -> 0x0036 }
            goto L_0x003c
        L_0x0036:
            r6 = move-exception
            android.content.Context r1 = r4.f34744b     // Catch:{ all -> 0x0060 }
            com.startapp.y8.a((android.content.Context) r1, (java.lang.Throwable) r6)     // Catch:{ all -> 0x0060 }
        L_0x003c:
            r7.add(r5)     // Catch:{ all -> 0x0060 }
        L_0x003f:
            java.util.concurrent.atomic.AtomicBoolean r5 = r4.f34748f     // Catch:{ all -> 0x0060 }
            boolean r5 = r5.compareAndSet(r3, r2)     // Catch:{ all -> 0x0060 }
            if (r5 == 0) goto L_0x005e
            com.startapp.g8 r5 = r4.f34752j     // Catch:{ all -> 0x0060 }
            r5.e()     // Catch:{ all -> 0x0060 }
            com.startapp.e8 r5 = r4.f34753k     // Catch:{ all -> 0x0060 }
            r5.e()     // Catch:{ all -> 0x0060 }
            r4.b(r8)     // Catch:{ all -> 0x0060 }
            goto L_0x005e
        L_0x0055:
            if (r5 == 0) goto L_0x005e
            if (r6 == 0) goto L_0x005e
            android.content.Context r7 = r4.f34744b     // Catch:{ all -> 0x0060 }
            com.startapp.p.b((android.content.Context) r7, (com.startapp.sdk.adsbase.adlisteners.AdEventListener) r6, (com.startapp.sdk.adsbase.Ad) r5)     // Catch:{ all -> 0x0060 }
        L_0x005e:
            monitor-exit(r0)     // Catch:{ all -> 0x0060 }
            return
        L_0x0060:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0060 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.j8.a(com.startapp.sdk.adsbase.StartAppAd, com.startapp.sdk.adsbase.adlisteners.AdEventListener, boolean, boolean):void");
    }
}
