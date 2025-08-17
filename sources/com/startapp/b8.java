package com.startapp;

import android.content.Context;
import com.startapp.sdk.adsbase.cache.CacheKey;
import com.startapp.sdk.adsbase.cache.DiskAdCacheManager$DiskCacheKey;
import com.startapp.sdk.adsbase.cache.DiskAdCacheManager$DiskCachedAd;
import com.startapp.sdk.adsbase.model.AdPreferences;
import java.io.Serializable;
import java.util.Map;

public class b8 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f34245a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d8 f34246b;

    public b8(d8 d8Var, Context context) {
        this.f34246b = d8Var;
        this.f34245a = context;
    }

    public void run() {
        Context context;
        try {
            ra.a(this.f34245a, p.d());
            ra.a(this.f34245a, p.c());
            CacheKey cacheKey = null;
            for (Map.Entry next : this.f34246b.f34355b.entrySet()) {
                CacheKey cacheKey2 = (CacheKey) next.getKey();
                if (cacheKey2.a() == AdPreferences.Placement.INAPP_SPLASH) {
                    cacheKey = cacheKey2;
                } else {
                    j8 j8Var = (j8) next.getValue();
                    context = this.f34245a;
                    AdPreferences.Placement a2 = cacheKey2.a();
                    AdPreferences adPreferences = j8Var.f34746d;
                    String b2 = this.f34246b.b(cacheKey2);
                    int i2 = j8Var.f34755m;
                    DiskAdCacheManager$DiskCacheKey diskAdCacheManager$DiskCacheKey = new DiskAdCacheManager$DiskCacheKey(a2, adPreferences);
                    diskAdCacheManager$DiskCacheKey.a(i2);
                    String d2 = p.d();
                    if (b2 != null) {
                        ra.a(ra.b(context, d2), b2, (Serializable) diskAdCacheManager$DiskCacheKey);
                    }
                    Context context2 = this.f34245a;
                    String b3 = this.f34246b.b(cacheKey2);
                    DiskAdCacheManager$DiskCachedAd diskAdCacheManager$DiskCachedAd = new DiskAdCacheManager$DiskCachedAd(j8Var.f34747e);
                    String c2 = p.c();
                    if (b3 != null) {
                        try {
                            ra.a(ra.b(context2, c2), b3, (Serializable) diskAdCacheManager$DiskCachedAd);
                        } catch (Throwable th) {
                            if (ra.a(4)) {
                                y8.a(context2, th);
                            }
                        }
                    }
                }
            }
            if (cacheKey != null) {
                this.f34246b.f34355b.remove(cacheKey);
            }
        } catch (Throwable th2) {
            y8.a(this.f34245a, th2);
        }
    }
}
