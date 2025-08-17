package com.startapp;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.startapp.d8;
import com.startapp.sdk.adsbase.StartAppAd;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.cache.DiskAdCacheManager$DiskCacheKey;
import java.util.List;

public final class l8 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f34865a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ p8 f34866b;

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f34867a;

        public a(List list) {
            this.f34867a = list;
        }

        public void run() {
            p8 p8Var = l8.this.f34866b;
            List<DiskAdCacheManager$DiskCacheKey> list = this.f34867a;
            y7 y7Var = (y7) p8Var;
            y7Var.getClass();
            if (list != null) {
                try {
                    for (DiskAdCacheManager$DiskCacheKey diskAdCacheManager$DiskCacheKey : list) {
                        if (y7Var.f36950b.a(diskAdCacheManager$DiskCacheKey.placement)) {
                            y7Var.f36950b.a(y7Var.f36949a, (StartAppAd) null, diskAdCacheManager$DiskCacheKey.placement, diskAdCacheManager$DiskCacheKey.adPreferences, (AdEventListener) null, true, diskAdCacheManager$DiskCacheKey.a());
                        }
                    }
                } catch (Throwable th) {
                    y8.a(y7Var.f36949a, th);
                }
            }
            d8 d8Var = y7Var.f36950b;
            Context context = y7Var.f36949a;
            d8Var.f34358e = false;
            for (d8.a next : d8Var.f34359f) {
                if (d8Var.a(next.f34363b)) {
                    d8Var.a(context, next.f34362a, next.f34363b, next.f34364c, next.f34365d, false, 0);
                }
            }
            d8Var.f34359f.clear();
        }
    }

    public l8(Context context, p8 p8Var) {
        this.f34865a = context;
        this.f34866b = p8Var;
    }

    public void run() {
        try {
            new Handler(Looper.getMainLooper()).post(new a(ra.d(this.f34865a, p.d())));
        } catch (Throwable th) {
            y8.a(this.f34865a, th);
        }
    }
}
