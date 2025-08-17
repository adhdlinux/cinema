package com.startapp;

import android.app.Activity;
import android.content.Context;
import com.facebook.common.time.Clock;
import com.startapp.j8;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.AdsCommonMetaData;
import com.startapp.sdk.adsbase.AdsConstants;
import com.startapp.sdk.adsbase.StartAppAd;
import com.startapp.sdk.adsbase.StartAppSDKInternal;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.cache.CacheKey;
import com.startapp.sdk.adsbase.cache.CacheMetaData;
import com.startapp.sdk.adsbase.model.AdPreferences;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class d8 {

    /* renamed from: a  reason: collision with root package name */
    public static d8 f34354a = new d8();

    /* renamed from: b  reason: collision with root package name */
    public final Map<CacheKey, j8> f34355b = new ConcurrentHashMap();

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f34356c = new WeakHashMap();

    /* renamed from: d  reason: collision with root package name */
    public boolean f34357d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f34358e = false;

    /* renamed from: f  reason: collision with root package name */
    public Queue<a> f34359f = new ConcurrentLinkedQueue();

    /* renamed from: g  reason: collision with root package name */
    public j8.b f34360g;

    /* renamed from: h  reason: collision with root package name */
    public Context f34361h;

    public class a {

        /* renamed from: a  reason: collision with root package name */
        public StartAppAd f34362a;

        /* renamed from: b  reason: collision with root package name */
        public AdPreferences.Placement f34363b;

        /* renamed from: c  reason: collision with root package name */
        public AdPreferences f34364c;

        /* renamed from: d  reason: collision with root package name */
        public AdEventListener f34365d;

        public a(d8 d8Var, StartAppAd startAppAd, AdPreferences.Placement placement, AdPreferences adPreferences, AdEventListener adEventListener) {
            this.f34362a = startAppAd;
            this.f34363b = placement;
            this.f34364c = adPreferences;
            this.f34365d = adEventListener;
        }
    }

    public CacheKey a(Context context, StartAppAd startAppAd, StartAppAd.AdMode adMode, AdPreferences adPreferences, AdEventListener adEventListener) {
        AdPreferences.Placement placement;
        if (adPreferences == null) {
            adPreferences = new AdPreferences();
        }
        AdPreferences adPreferences2 = adPreferences;
        int ordinal = adMode.ordinal();
        if (ordinal != 0) {
            if (ordinal != 1) {
                if (ordinal == 2) {
                    Map<Activity, Integer> map = lb.f34876a;
                    placement = AdPreferences.Placement.INAPP_OFFER_WALL;
                } else if (!(ordinal == 3 || ordinal == 4 || ordinal == 5)) {
                    placement = AdPreferences.Placement.INAPP_FULL_SCREEN;
                }
            }
            placement = AdPreferences.Placement.INAPP_OVERLAY;
        } else {
            Map<Activity, Integer> map2 = lb.f34876a;
            if (new Random().nextInt(100) < AdsCommonMetaData.f36186h.i()) {
                if ((new Random().nextInt(100) < AdsCommonMetaData.f36186h.j() || adPreferences2.isForceFullpage()) && !adPreferences2.isForceOverlay()) {
                    placement = AdPreferences.Placement.INAPP_FULL_SCREEN;
                } else {
                    placement = AdPreferences.Placement.INAPP_OVERLAY;
                }
            } else {
                placement = AdPreferences.Placement.INAPP_FULL_SCREEN;
            }
        }
        AdPreferences.Placement placement2 = placement;
        if (adMode.equals(StartAppAd.AdMode.REWARDED_VIDEO)) {
            adPreferences2.setType(Ad.AdType.REWARDED_VIDEO);
        } else if (adMode.equals(StartAppAd.AdMode.VIDEO)) {
            adPreferences2.setType(Ad.AdType.VIDEO);
        }
        return a(context, startAppAd, placement2, adPreferences2, adEventListener, false, 0);
    }

    public String b(CacheKey cacheKey) {
        return String.valueOf(cacheKey.hashCode()).replace('-', '_');
    }

    public v6 c(CacheKey cacheKey) {
        j8 j8Var;
        if (cacheKey == null || (j8Var = this.f34355b.get(cacheKey)) == null || !j8Var.c()) {
            return null;
        }
        v6 v6Var = j8Var.f34747e;
        j8Var.f34755m = 0;
        j8Var.f34757o = null;
        if (!AdsConstants.f36193g.booleanValue() && j8Var.f34756n) {
            j8Var.a((StartAppAd) null, (AdEventListener) null, true, true);
        } else if (!j8Var.f34756n) {
            j8.b bVar = j8Var.f34758p;
            if (bVar != null) {
                ((c8) bVar).a(j8Var);
            }
            g8 g8Var = j8Var.f34752j;
            if (g8Var != null) {
                g8Var.e();
            }
        }
        return v6Var;
    }

    public void b(AdPreferences.Placement placement) {
        synchronized (this.f34355b) {
            Iterator<Map.Entry<CacheKey, j8>> it2 = this.f34355b.entrySet().iterator();
            while (it2.hasNext()) {
                if (((CacheKey) it2.next().getKey()).a() == placement) {
                    it2.remove();
                }
            }
        }
    }

    public v6 a(CacheKey cacheKey) {
        j8 j8Var = cacheKey != null ? this.f34355b.get(cacheKey) : null;
        if (j8Var != null) {
            return j8Var.f34747e;
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0050 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(boolean r7) {
        /*
            r6 = this;
            java.util.Map<com.startapp.sdk.adsbase.cache.CacheKey, com.startapp.j8> r0 = r6.f34355b
            java.util.Collection r0 = r0.values()
            java.util.Iterator r0 = r0.iterator()
        L_0x000a:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0053
            java.lang.Object r1 = r0.next()
            com.startapp.j8 r1 = (com.startapp.j8) r1
            com.startapp.v6 r2 = r1.f34747e
            r3 = 0
            r4 = 0
            if (r2 == 0) goto L_0x003c
            java.util.Map<android.app.Activity, java.lang.Integer> r5 = com.startapp.lb.f34876a
            boolean r2 = r2 instanceof com.startapp.sdk.ads.interstitials.ReturnAd
            if (r2 == 0) goto L_0x003c
            if (r7 != 0) goto L_0x003c
            com.startapp.sdk.adsbase.cache.CacheMetaData r2 = com.startapp.sdk.adsbase.cache.CacheMetaData.f36308a
            com.startapp.sdk.adsbase.cache.ACMConfig r2 = r2.a()
            boolean r2 = r2.g()
            if (r2 != 0) goto L_0x0047
            com.startapp.g8 r2 = r1.f34752j
            android.os.Handler r5 = r2.f34520b
            if (r5 == 0) goto L_0x0039
            r5.removeCallbacksAndMessages(r3)
        L_0x0039:
            r2.f34522d = r4
            goto L_0x0047
        L_0x003c:
            com.startapp.g8 r2 = r1.f34752j
            android.os.Handler r5 = r2.f34520b
            if (r5 == 0) goto L_0x0045
            r5.removeCallbacksAndMessages(r3)
        L_0x0045:
            r2.f34522d = r4
        L_0x0047:
            com.startapp.e8 r1 = r1.f34753k
            android.os.Handler r2 = r1.f34520b
            if (r2 == 0) goto L_0x0050
            r2.removeCallbacksAndMessages(r3)
        L_0x0050:
            r1.f34522d = r4
            goto L_0x000a
        L_0x0053:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.d8.a(boolean):void");
    }

    public CacheKey a(Context context, StartAppAd startAppAd, AdPreferences.Placement placement, AdPreferences adPreferences, AdEventListener adEventListener) {
        return a(context, (StartAppAd) null, placement, adPreferences, (AdEventListener) null, false, 0);
    }

    public CacheKey a(Context context, StartAppAd startAppAd, AdPreferences.Placement placement, AdPreferences adPreferences, AdEventListener adEventListener, boolean z2, int i2) {
        j8 j8Var;
        this.f34361h = ia.b(context);
        if (adPreferences == null) {
            adPreferences = new AdPreferences();
        }
        AdPreferences adPreferences2 = adPreferences;
        CacheKey cacheKey = new CacheKey(placement, adPreferences2);
        if (!this.f34358e || z2) {
            AdPreferences adPreferences3 = new AdPreferences(adPreferences2);
            synchronized (this.f34355b) {
                j8Var = this.f34355b.get(cacheKey);
                if (j8Var == null) {
                    if (placement.ordinal() != 3) {
                        j8Var = new j8(this.f34361h, placement, adPreferences3);
                    } else {
                        j8Var = new j8(this.f34361h, placement, adPreferences3);
                        j8Var.f34756n = false;
                    }
                    if (this.f34360g == null) {
                        this.f34360g = new c8(this);
                    }
                    j8Var.f34758p = this.f34360g;
                    if (z2) {
                        j8Var.f34750h = b(cacheKey);
                        j8Var.f34751i = true;
                        j8Var.f34755m = i2;
                    }
                    a(cacheKey, j8Var, this.f34361h);
                } else {
                    j8Var.f34746d = adPreferences3;
                }
            }
            j8Var.a(startAppAd, adEventListener, false, true);
            return cacheKey;
        }
        this.f34359f.add(new a(this, startAppAd, placement, adPreferences2, adEventListener));
        return cacheKey;
    }

    public final void a(CacheKey cacheKey, j8 j8Var, Context context) {
        synchronized (this.f34355b) {
            int d2 = CacheMetaData.f36308a.a().d();
            if (d2 != 0 && this.f34355b.size() >= d2) {
                long j2 = Clock.MAX_TIME;
                CacheKey cacheKey2 = null;
                for (CacheKey next : this.f34355b.keySet()) {
                    j8 j8Var2 = this.f34355b.get(next);
                    if (j8Var2.f34743a == j8Var.f34743a) {
                        long j3 = j8Var2.f34749g;
                        if (j3 < j2) {
                            cacheKey2 = next;
                            j2 = j3;
                        }
                    }
                }
                if (cacheKey2 != null) {
                    this.f34355b.remove(cacheKey2);
                }
            }
            this.f34355b.put(cacheKey, j8Var);
            if (Math.random() * 100.0d < ((double) CacheMetaData.f36308a.c())) {
                y8 y8Var = new y8(z8.f36995b);
                y8Var.f36954d = "Cache Size";
                y8Var.f36955e = String.valueOf(this.f34355b.size());
                y8Var.a(context);
            }
        }
    }

    public boolean a(AdPreferences.Placement placement) {
        int ordinal = placement.ordinal();
        if (ordinal == 3) {
            String str = StartAppSDKInternal.f36218a;
            if (!(!StartAppSDKInternal.c.f36252a.f36242y) || AdsCommonMetaData.f36186h.L()) {
                return false;
            }
            return true;
        } else if (ordinal != 7) {
            return true;
        } else {
            String str2 = StartAppSDKInternal.f36218a;
            if (!StartAppSDKInternal.c.f36252a.f36240w || AdsCommonMetaData.f36186h.K()) {
                return false;
            }
            return true;
        }
    }

    public String a(StartAppAd.AdMode adMode) {
        if (adMode == null) {
            return null;
        }
        return "autoLoadNotShownAdPrefix" + adMode.name();
    }
}
