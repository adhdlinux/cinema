package b0;

import com.chartboost.sdk.ads.Ad;
import com.chartboost.sdk.callbacks.AdCallback;
import com.chartboost.sdk.events.CacheError;
import com.chartboost.sdk.impl.d;

public final /* synthetic */ class l implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Ad f12738b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AdCallback f12739c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f12740d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ CacheError f12741e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ d f12742f;

    public /* synthetic */ l(Ad ad, AdCallback adCallback, String str, CacheError cacheError, d dVar) {
        this.f12738b = ad;
        this.f12739c = adCallback;
        this.f12740d = str;
        this.f12741e = cacheError;
        this.f12742f = dVar;
    }

    public final void run() {
        d.a(this.f12738b, this.f12739c, this.f12740d, this.f12741e, this.f12742f);
    }
}
