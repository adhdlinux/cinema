package com.facebook.ads;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.CookieManager;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.internal.a;
import com.facebook.ads.internal.adapters.y;
import com.facebook.ads.internal.d.b;
import com.facebook.ads.internal.protocol.d;
import com.facebook.ads.internal.protocol.f;
import java.util.ArrayList;
import java.util.List;

public class NativeAdsManager {

    /* renamed from: a  reason: collision with root package name */
    private static final String f19535a = "NativeAdsManager";

    /* renamed from: b  reason: collision with root package name */
    private static final d f19536b = d.ADS;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final Context f19537c;

    /* renamed from: d  reason: collision with root package name */
    private final String f19538d;

    /* renamed from: e  reason: collision with root package name */
    private final int f19539e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final List<NativeAd> f19540f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public int f19541g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public Listener f19542h;

    /* renamed from: i  reason: collision with root package name */
    private a f19543i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f19544j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public boolean f19545k;

    public interface Listener {
        void onAdError(AdError adError);

        void onAdsLoaded();
    }

    public NativeAdsManager(Context context, String str, int i2) {
        if (context != null) {
            this.f19537c = context;
            this.f19538d = str;
            this.f19539e = Math.max(i2, 0);
            this.f19540f = new ArrayList(i2);
            this.f19541g = -1;
            this.f19545k = false;
            this.f19544j = false;
            try {
                CookieManager.getInstance();
            } catch (Exception e2) {
                Log.w(f19535a, "Failed to initialize CookieManager.", e2);
            }
        } else {
            throw new IllegalArgumentException("context can not be null");
        }
    }

    public void disableAutoRefresh() {
        this.f19544j = true;
        a aVar = this.f19543i;
        if (aVar != null) {
            aVar.c();
        }
    }

    public int getUniqueNativeAdCount() {
        return this.f19540f.size();
    }

    public boolean isLoaded() {
        return this.f19545k;
    }

    public void loadAds() {
        loadAds(NativeAdBase.MediaCacheFlag.ALL);
    }

    public void loadAds(final NativeAdBase.MediaCacheFlag mediaCacheFlag) {
        f fVar = f.NATIVE_UNKNOWN;
        int i2 = this.f19539e;
        a aVar = this.f19543i;
        if (aVar != null) {
            aVar.b();
        }
        a aVar2 = new a(this.f19537c, this.f19538d, fVar, (AdSize) null, f19536b, i2);
        this.f19543i = aVar2;
        if (this.f19544j) {
            aVar2.c();
        }
        this.f19543i.a((a.C0029a) new a.C0029a() {
            public void a(com.facebook.ads.internal.protocol.a aVar) {
                if (NativeAdsManager.this.f19542h != null) {
                    NativeAdsManager.this.f19542h.onAdError(AdError.getAdErrorFromWrapper(aVar));
                }
            }

            public void a(final List<y> list) {
                b bVar = new b(NativeAdsManager.this.f19537c);
                for (y next : list) {
                    if (mediaCacheFlag.equals(NativeAdBase.MediaCacheFlag.ALL)) {
                        if (next.k() != null) {
                            bVar.a(next.k().a(), next.k().c(), next.k().b());
                        }
                        if (next.l() != null) {
                            bVar.a(next.l().a(), next.l().c(), next.l().b());
                        }
                        if (!TextUtils.isEmpty(next.A())) {
                            bVar.a(next.A());
                        }
                    }
                }
                bVar.a((com.facebook.ads.internal.d.a) new com.facebook.ads.internal.d.a() {
                    private void c() {
                        boolean unused = NativeAdsManager.this.f19545k = true;
                        NativeAdsManager.this.f19540f.clear();
                        int unused2 = NativeAdsManager.this.f19541g = 0;
                        for (y nativeAd : list) {
                            NativeAdsManager.this.f19540f.add(new NativeAd(NativeAdsManager.this.f19537c, nativeAd, (com.facebook.ads.internal.h.d) null));
                        }
                        if (NativeAdsManager.this.f19542h != null) {
                            NativeAdsManager.this.f19542h.onAdsLoaded();
                        }
                    }

                    public void a() {
                        c();
                    }

                    public void b() {
                        c();
                    }
                });
            }
        });
        this.f19543i.a();
    }

    public NativeAd nextNativeAd() {
        if (this.f19540f.size() == 0) {
            return null;
        }
        int i2 = this.f19541g;
        this.f19541g = i2 + 1;
        List<NativeAd> list = this.f19540f;
        NativeAd nativeAd = list.get(i2 % list.size());
        return i2 >= this.f19540f.size() ? new NativeAd((NativeAdBase) nativeAd) : nativeAd;
    }

    public void setListener(Listener listener) {
        this.f19542h = listener;
    }
}
