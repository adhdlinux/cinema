package com.startapp;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.cache.DiskAdCacheManager$DiskCachedAd;

public final class m8 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f34906a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f34907b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AdEventListener f34908c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ o8 f34909d;

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DiskAdCacheManager$DiskCachedAd f34910a;

        public a(DiskAdCacheManager$DiskCachedAd diskAdCacheManager$DiskCachedAd) {
            this.f34910a = diskAdCacheManager$DiskCachedAd;
        }

        public void run() {
            try {
                DiskAdCacheManager$DiskCachedAd diskAdCacheManager$DiskCachedAd = this.f34910a;
                if (diskAdCacheManager$DiskCachedAd == null) {
                    m8 m8Var = m8.this;
                    p.a(m8Var.f34906a, m8Var.f34908c, (Ad) null);
                    return;
                }
                if (diskAdCacheManager$DiskCachedAd.a() != null) {
                    if (this.f34910a.a().isReady()) {
                        if (this.f34910a.a().d()) {
                            m8 m8Var2 = m8.this;
                            p.a(m8Var2.f34906a, m8Var2.f34908c, (Ad) null);
                            return;
                        }
                        m8 m8Var3 = m8.this;
                        p.a(m8Var3.f34906a, this.f34910a, m8Var3.f34909d, m8Var3.f34908c);
                        return;
                    }
                }
                m8 m8Var4 = m8.this;
                p.a(m8Var4.f34906a, m8Var4.f34908c, (Ad) null);
            } catch (Throwable th) {
                y8.a(m8.this.f34906a, th);
                m8 m8Var5 = m8.this;
                p.a(m8Var5.f34906a, m8Var5.f34908c, (Ad) null);
            }
        }
    }

    public m8(Context context, String str, AdEventListener adEventListener, o8 o8Var) {
        this.f34906a = context;
        this.f34907b = str;
        this.f34908c = adEventListener;
        this.f34909d = o8Var;
    }

    public void run() {
        Context context;
        Object obj;
        try {
            context = this.f34906a;
            String c2 = p.c();
            String str = this.f34907b;
            if (str != null) {
                obj = ra.a(ra.b(context, c2), str);
                new Handler(Looper.getMainLooper()).post(new a((DiskAdCacheManager$DiskCachedAd) obj));
            }
        } catch (Throwable th) {
            y8.a(this.f34906a, th);
            p.a(this.f34906a, this.f34908c, (Ad) null);
            return;
        }
        obj = null;
        new Handler(Looper.getMainLooper()).post(new a((DiskAdCacheManager$DiskCachedAd) obj));
    }
}
