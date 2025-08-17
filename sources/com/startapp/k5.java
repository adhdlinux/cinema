package com.startapp;

import android.content.Context;
import com.startapp.b6;
import com.startapp.sdk.adsbase.AdsCommonMetaData;
import com.startapp.sdk.adsbase.cache.CachedVideoAd;

public class k5 implements b6.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b6.b f34820a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CachedVideoAd f34821b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f34822c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ m5 f34823d;

    public k5(m5 m5Var, b6.b bVar, CachedVideoAd cachedVideoAd, Context context) {
        this.f34823d = m5Var;
        this.f34820a = bVar;
        this.f34821b = cachedVideoAd;
        this.f34822c = context;
    }

    public void a(String str) {
        b6.b bVar = this.f34820a;
        if (bVar != null) {
            bVar.a(str);
        }
        if (str != null) {
            this.f34821b.a(System.currentTimeMillis());
            this.f34821b.a(str);
            m5 m5Var = this.f34823d;
            Context context = this.f34822c;
            CachedVideoAd cachedVideoAd = this.f34821b;
            if (m5Var.f34900b.contains(cachedVideoAd)) {
                m5Var.f34900b.remove(cachedVideoAd);
            }
            m5Var.a(AdsCommonMetaData.f36186h.G().b() - 1);
            m5Var.f34900b.add(cachedVideoAd);
            ra.b(context, "CachedAds", m5Var.f34900b);
        }
    }
}
