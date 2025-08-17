package com.startapp;

import android.content.Context;
import com.startapp.ic;
import com.startapp.sdk.ads.banner.BannerMetaData;
import com.startapp.sdk.ads.splash.SplashMetaData;
import com.startapp.sdk.adsbase.AdsCommonMetaData;
import com.startapp.sdk.adsbase.AdsConstants;
import com.startapp.sdk.adsbase.adinformation.AdInformationMetaData;
import com.startapp.sdk.adsbase.cache.CacheMetaData;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.sdk.adsbase.remoteconfig.MetaDataRequest;
import com.startapp.sdk.components.ComponentLocator;
import java.util.Collections;
import java.util.List;

public class ba {

    /* renamed from: a  reason: collision with root package name */
    public final Context f34249a;

    /* renamed from: b  reason: collision with root package name */
    public final AdPreferences f34250b;

    /* renamed from: c  reason: collision with root package name */
    public final MetaDataRequest.RequestReason f34251c;

    /* renamed from: d  reason: collision with root package name */
    public MetaData f34252d = null;

    /* renamed from: e  reason: collision with root package name */
    public BannerMetaData f34253e = null;

    /* renamed from: f  reason: collision with root package name */
    public SplashMetaData f34254f = null;

    /* renamed from: g  reason: collision with root package name */
    public CacheMetaData f34255g = null;

    /* renamed from: h  reason: collision with root package name */
    public AdInformationMetaData f34256h = null;

    /* renamed from: i  reason: collision with root package name */
    public AdsCommonMetaData f34257i = null;

    /* renamed from: j  reason: collision with root package name */
    public boolean f34258j = false;

    /* renamed from: k  reason: collision with root package name */
    public boolean f34259k = false;

    public ba(Context context, AdPreferences adPreferences, MetaDataRequest.RequestReason requestReason) {
        this.f34249a = context;
        this.f34250b = adPreferences;
        this.f34251c = requestReason;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:27|28|(22:34|35|36|(1:38)|42|43|44|(1:46)|50|51|52|(1:54)|58|59|60|(1:62)|66|67|68|(1:70)|74|75)|76|77) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:76:0x014e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Boolean a() {
        /*
            r5 = this;
            android.content.Context r0 = r5.f34249a     // Catch:{ all -> 0x0155 }
            com.startapp.sdk.components.ComponentLocator r0 = com.startapp.sdk.components.ComponentLocator.a((android.content.Context) r0)     // Catch:{ all -> 0x0155 }
            com.startapp.x6 r0 = r0.d()     // Catch:{ all -> 0x0155 }
            com.startapp.sdk.adsbase.remoteconfig.MetaDataRequest r1 = new com.startapp.sdk.adsbase.remoteconfig.MetaDataRequest     // Catch:{ all -> 0x0155 }
            android.content.Context r2 = r5.f34249a     // Catch:{ all -> 0x0155 }
            com.startapp.sdk.adsbase.remoteconfig.MetaDataRequest$RequestReason r3 = r5.f34251c     // Catch:{ all -> 0x0155 }
            r1.<init>(r2, r0, r3)     // Catch:{ all -> 0x0155 }
            android.content.Context r0 = r5.f34249a     // Catch:{ all -> 0x0155 }
            com.startapp.sdk.adsbase.model.AdPreferences r2 = r5.f34250b     // Catch:{ all -> 0x0155 }
            r1.a(r0, r2)     // Catch:{ all -> 0x0155 }
            android.content.Context r0 = r5.f34249a     // Catch:{ all -> 0x0155 }
            com.startapp.ic$a r0 = a(r0, r1)     // Catch:{ all -> 0x0155 }
            if (r0 != 0) goto L_0x0025
            java.lang.Boolean r0 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0155 }
            return r0
        L_0x0025:
            java.lang.String r0 = r0.f34700a     // Catch:{ all -> 0x0155 }
            if (r0 != 0) goto L_0x002c
            java.lang.Boolean r0 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0155 }
            return r0
        L_0x002c:
            java.lang.Class<com.startapp.sdk.adsbase.remoteconfig.MetaData> r1 = com.startapp.sdk.adsbase.remoteconfig.MetaData.class
            java.lang.Object r1 = com.startapp.lb.a((java.lang.String) r0, r1)     // Catch:{ all -> 0x0155 }
            com.startapp.sdk.adsbase.remoteconfig.MetaData r1 = (com.startapp.sdk.adsbase.remoteconfig.MetaData) r1     // Catch:{ all -> 0x0155 }
            r5.f34252d = r1     // Catch:{ all -> 0x0155 }
            java.lang.String r1 = r1.h()     // Catch:{ all -> 0x0155 }
            if (r1 == 0) goto L_0x006c
            android.content.Context r1 = r5.f34249a     // Catch:{ all -> 0x0155 }
            com.startapp.sdk.components.ComponentLocator r1 = com.startapp.sdk.components.ComponentLocator.a((android.content.Context) r1)     // Catch:{ all -> 0x0155 }
            com.startapp.p6 r1 = r1.c()     // Catch:{ all -> 0x0155 }
            com.startapp.sdk.adsbase.remoteconfig.MetaData r2 = r5.f34252d     // Catch:{ all -> 0x0155 }
            java.lang.String r2 = r2.h()     // Catch:{ all -> 0x0155 }
            r1.getClass()     // Catch:{ all -> 0x0155 }
            if (r2 == 0) goto L_0x0055
            java.lang.String r2 = r2.trim()     // Catch:{ all -> 0x0155 }
        L_0x0055:
            java.lang.Object r3 = r1.f35607a     // Catch:{ all -> 0x0155 }
            monitor-enter(r3)     // Catch:{ all -> 0x0155 }
            android.content.SharedPreferences r1 = r1.f35608b     // Catch:{ all -> 0x0069 }
            android.content.SharedPreferences$Editor r1 = r1.edit()     // Catch:{ all -> 0x0069 }
            java.lang.String r4 = "31721150b470a3b9"
            android.content.SharedPreferences$Editor r1 = r1.putString(r4, r2)     // Catch:{ all -> 0x0069 }
            r1.commit()     // Catch:{ all -> 0x0069 }
            monitor-exit(r3)     // Catch:{ all -> 0x0069 }
            goto L_0x006c
        L_0x0069:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0069 }
            throw r0     // Catch:{ all -> 0x0155 }
        L_0x006c:
            java.lang.Class<com.startapp.sdk.adsbase.AdsCommonMetaData> r1 = com.startapp.sdk.adsbase.AdsCommonMetaData.class
            java.lang.Object r1 = com.startapp.lb.a((java.lang.String) r0, r1)     // Catch:{ all -> 0x0155 }
            com.startapp.sdk.adsbase.AdsCommonMetaData r1 = (com.startapp.sdk.adsbase.AdsCommonMetaData) r1     // Catch:{ all -> 0x0155 }
            r5.f34257i = r1     // Catch:{ all -> 0x0155 }
            java.lang.Class<com.startapp.sdk.ads.banner.BannerMetaData> r1 = com.startapp.sdk.ads.banner.BannerMetaData.class
            java.lang.Object r1 = com.startapp.lb.a((java.lang.String) r0, r1)     // Catch:{ all -> 0x0155 }
            com.startapp.sdk.ads.banner.BannerMetaData r1 = (com.startapp.sdk.ads.banner.BannerMetaData) r1     // Catch:{ all -> 0x0155 }
            r5.f34253e = r1     // Catch:{ all -> 0x0155 }
            java.lang.Class<com.startapp.sdk.ads.splash.SplashMetaData> r1 = com.startapp.sdk.ads.splash.SplashMetaData.class
            java.lang.Object r1 = com.startapp.lb.a((java.lang.String) r0, r1)     // Catch:{ all -> 0x0155 }
            com.startapp.sdk.ads.splash.SplashMetaData r1 = (com.startapp.sdk.ads.splash.SplashMetaData) r1     // Catch:{ all -> 0x0155 }
            r5.f34254f = r1     // Catch:{ all -> 0x0155 }
            java.lang.Class<com.startapp.sdk.adsbase.cache.CacheMetaData> r1 = com.startapp.sdk.adsbase.cache.CacheMetaData.class
            java.lang.Object r1 = com.startapp.lb.a((java.lang.String) r0, r1)     // Catch:{ all -> 0x0155 }
            com.startapp.sdk.adsbase.cache.CacheMetaData r1 = (com.startapp.sdk.adsbase.cache.CacheMetaData) r1     // Catch:{ all -> 0x0155 }
            r5.f34255g = r1     // Catch:{ all -> 0x0155 }
            java.lang.Class<com.startapp.sdk.adsbase.adinformation.AdInformationMetaData> r1 = com.startapp.sdk.adsbase.adinformation.AdInformationMetaData.class
            java.lang.Object r0 = com.startapp.lb.a((java.lang.String) r0, r1)     // Catch:{ all -> 0x0155 }
            com.startapp.sdk.adsbase.adinformation.AdInformationMetaData r0 = (com.startapp.sdk.adsbase.adinformation.AdInformationMetaData) r0     // Catch:{ all -> 0x0155 }
            r5.f34256h = r0     // Catch:{ all -> 0x0155 }
            java.lang.Object r0 = com.startapp.sdk.adsbase.remoteconfig.MetaData.f36372a
            monitor-enter(r0)
            boolean r1 = r5.f34258j     // Catch:{ all -> 0x0152 }
            if (r1 != 0) goto L_0x014e
            com.startapp.sdk.adsbase.remoteconfig.MetaData r1 = r5.f34252d     // Catch:{ all -> 0x0152 }
            if (r1 == 0) goto L_0x014e
            android.content.Context r1 = r5.f34249a     // Catch:{ all -> 0x0152 }
            if (r1 == 0) goto L_0x014e
            r1 = 1
            com.startapp.sdk.adsbase.AdsCommonMetaData r2 = com.startapp.sdk.adsbase.AdsCommonMetaData.f36186h     // Catch:{ all -> 0x00c2 }
            com.startapp.sdk.adsbase.AdsCommonMetaData r3 = r5.f34257i     // Catch:{ all -> 0x00c2 }
            boolean r2 = com.startapp.lb.a(r2, r3)     // Catch:{ all -> 0x00c2 }
            if (r2 != 0) goto L_0x00c8
            r5.f34259k = r1     // Catch:{ all -> 0x00c2 }
            android.content.Context r2 = r5.f34249a     // Catch:{ all -> 0x00c2 }
            com.startapp.sdk.adsbase.AdsCommonMetaData r3 = r5.f34257i     // Catch:{ all -> 0x00c2 }
            com.startapp.sdk.adsbase.AdsCommonMetaData.a(r2, r3)     // Catch:{ all -> 0x00c2 }
            goto L_0x00c8
        L_0x00c2:
            r2 = move-exception
            android.content.Context r3 = r5.f34249a     // Catch:{ all -> 0x0152 }
            com.startapp.y8.a((android.content.Context) r3, (java.lang.Throwable) r2)     // Catch:{ all -> 0x0152 }
        L_0x00c8:
            java.util.Map<android.app.Activity, java.lang.Integer> r2 = com.startapp.lb.f34876a     // Catch:{ all -> 0x0152 }
            com.startapp.sdk.ads.banner.BannerMetaData r2 = com.startapp.sdk.ads.banner.BannerMetaData.f35889b     // Catch:{ all -> 0x00de }
            com.startapp.sdk.ads.banner.BannerMetaData r3 = r5.f34253e     // Catch:{ all -> 0x00de }
            boolean r2 = com.startapp.lb.a(r2, r3)     // Catch:{ all -> 0x00de }
            if (r2 != 0) goto L_0x00e4
            r5.f34259k = r1     // Catch:{ all -> 0x00de }
            android.content.Context r2 = r5.f34249a     // Catch:{ all -> 0x00de }
            com.startapp.sdk.ads.banner.BannerMetaData r3 = r5.f34253e     // Catch:{ all -> 0x00de }
            com.startapp.sdk.ads.banner.BannerMetaData.a(r2, r3)     // Catch:{ all -> 0x00de }
            goto L_0x00e4
        L_0x00de:
            r2 = move-exception
            android.content.Context r3 = r5.f34249a     // Catch:{ all -> 0x0152 }
            com.startapp.y8.a((android.content.Context) r3, (java.lang.Throwable) r2)     // Catch:{ all -> 0x0152 }
        L_0x00e4:
            java.util.Map<android.app.Activity, java.lang.Integer> r2 = com.startapp.lb.f34876a     // Catch:{ all -> 0x0152 }
            com.startapp.sdk.ads.splash.SplashMetaData r2 = r5.f34254f     // Catch:{ all -> 0x0152 }
            com.startapp.sdk.ads.splash.SplashConfig r2 = r2.a()     // Catch:{ all -> 0x0152 }
            android.content.Context r3 = r5.f34249a     // Catch:{ all -> 0x0152 }
            r2.setDefaults(r3)     // Catch:{ all -> 0x0152 }
            com.startapp.sdk.ads.splash.SplashMetaData r2 = com.startapp.sdk.ads.splash.SplashMetaData.f36048a     // Catch:{ all -> 0x0105 }
            com.startapp.sdk.ads.splash.SplashMetaData r3 = r5.f34254f     // Catch:{ all -> 0x0105 }
            boolean r2 = com.startapp.lb.a(r2, r3)     // Catch:{ all -> 0x0105 }
            if (r2 != 0) goto L_0x010b
            r5.f34259k = r1     // Catch:{ all -> 0x0105 }
            android.content.Context r2 = r5.f34249a     // Catch:{ all -> 0x0105 }
            com.startapp.sdk.ads.splash.SplashMetaData r3 = r5.f34254f     // Catch:{ all -> 0x0105 }
            com.startapp.sdk.ads.splash.SplashMetaData.a(r2, r3)     // Catch:{ all -> 0x0105 }
            goto L_0x010b
        L_0x0105:
            r2 = move-exception
            android.content.Context r3 = r5.f34249a     // Catch:{ all -> 0x0152 }
            com.startapp.y8.a((android.content.Context) r3, (java.lang.Throwable) r2)     // Catch:{ all -> 0x0152 }
        L_0x010b:
            java.util.Map<android.app.Activity, java.lang.Integer> r2 = com.startapp.lb.f34876a     // Catch:{ all -> 0x0152 }
            com.startapp.sdk.adsbase.cache.CacheMetaData r2 = com.startapp.sdk.adsbase.cache.CacheMetaData.f36308a     // Catch:{ all -> 0x0121 }
            com.startapp.sdk.adsbase.cache.CacheMetaData r3 = r5.f34255g     // Catch:{ all -> 0x0121 }
            boolean r2 = com.startapp.lb.a(r2, r3)     // Catch:{ all -> 0x0121 }
            if (r2 != 0) goto L_0x0127
            r5.f34259k = r1     // Catch:{ all -> 0x0121 }
            android.content.Context r2 = r5.f34249a     // Catch:{ all -> 0x0121 }
            com.startapp.sdk.adsbase.cache.CacheMetaData r3 = r5.f34255g     // Catch:{ all -> 0x0121 }
            com.startapp.sdk.adsbase.cache.CacheMetaData.a(r2, r3)     // Catch:{ all -> 0x0121 }
            goto L_0x0127
        L_0x0121:
            r2 = move-exception
            android.content.Context r3 = r5.f34249a     // Catch:{ all -> 0x0152 }
            com.startapp.y8.a((android.content.Context) r3, (java.lang.Throwable) r2)     // Catch:{ all -> 0x0152 }
        L_0x0127:
            java.util.Map<android.app.Activity, java.lang.Integer> r2 = com.startapp.lb.f34876a     // Catch:{ all -> 0x0152 }
            com.startapp.sdk.adsbase.adinformation.AdInformationMetaData r2 = com.startapp.sdk.adsbase.adinformation.AdInformationMetaData.f36260a     // Catch:{ all -> 0x013d }
            com.startapp.sdk.adsbase.adinformation.AdInformationMetaData r3 = r5.f34256h     // Catch:{ all -> 0x013d }
            boolean r2 = com.startapp.lb.a(r2, r3)     // Catch:{ all -> 0x013d }
            if (r2 != 0) goto L_0x0143
            r5.f34259k = r1     // Catch:{ all -> 0x013d }
            android.content.Context r1 = r5.f34249a     // Catch:{ all -> 0x013d }
            com.startapp.sdk.adsbase.adinformation.AdInformationMetaData r2 = r5.f34256h     // Catch:{ all -> 0x013d }
            com.startapp.sdk.adsbase.adinformation.AdInformationMetaData.a(r1, r2)     // Catch:{ all -> 0x013d }
            goto L_0x0143
        L_0x013d:
            r1 = move-exception
            android.content.Context r2 = r5.f34249a     // Catch:{ all -> 0x0152 }
            com.startapp.y8.a((android.content.Context) r2, (java.lang.Throwable) r1)     // Catch:{ all -> 0x0152 }
        L_0x0143:
            android.content.Context r1 = r5.f34249a     // Catch:{ Exception -> 0x014e }
            com.startapp.sdk.adsbase.remoteconfig.MetaData r2 = r5.f34252d     // Catch:{ Exception -> 0x014e }
            java.lang.String r2 = r2.f()     // Catch:{ Exception -> 0x014e }
            com.startapp.sdk.adsbase.remoteconfig.MetaData.a((android.content.Context) r1, (java.lang.String) r2)     // Catch:{ Exception -> 0x014e }
        L_0x014e:
            monitor-exit(r0)     // Catch:{ all -> 0x0152 }
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            return r0
        L_0x0152:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0152 }
            throw r1
        L_0x0155:
            r0 = move-exception
            android.content.Context r1 = r5.f34249a
            com.startapp.y8.a((android.content.Context) r1, (java.lang.Throwable) r0)
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.ba.a():java.lang.Boolean");
    }

    public void a(Boolean bool) {
        MetaData metaData;
        Context context;
        synchronized (MetaData.f36372a) {
            if (!this.f34258j) {
                if (!bool.booleanValue() || (metaData = this.f34252d) == null || (context = this.f34249a) == null) {
                    MetaData.a(this.f34251c);
                } else {
                    try {
                        MetaData.a(context, metaData, this.f34251c, this.f34259k);
                    } catch (Throwable th) {
                        y8.a(this.f34249a, th);
                    }
                }
            }
        }
    }

    public static ic.a a(Context context, MetaDataRequest metaDataRequest) {
        ic.a aVar;
        List<String> list = MetaData.f36379h.metaDataHosts;
        if (list == null || list.size() < 1) {
            list = MetaData.f36375d;
        }
        for (T t2 : Collections.unmodifiableList(list)) {
            w8 j2 = ComponentLocator.a(context).j();
            String str = t2 + AdsConstants.f36191e;
            j2.getClass();
            try {
                aVar = j2.a(str, metaDataRequest, (sa<String, Void>) null);
            } catch (Throwable th) {
                y8.a(j2.f36819a, th);
                aVar = null;
            }
            if (aVar == null) {
                if (!ComponentLocator.a(context).e().a()) {
                    break;
                }
            } else {
                return aVar;
            }
        }
        return null;
    }
}
