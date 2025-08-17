package b0;

import com.chartboost.sdk.ads.Ad;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Ad f12696b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ com.chartboost.sdk.impl.c f12697c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f12698d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f12699e;

    public /* synthetic */ c(Ad ad, com.chartboost.sdk.impl.c cVar, String str, String str2) {
        this.f12696b = ad;
        this.f12697c = cVar;
        this.f12698d = str;
        this.f12699e = str2;
    }

    public final void run() {
        com.chartboost.sdk.impl.c.a(this.f12696b, this.f12697c, this.f12698d, this.f12699e);
    }
}
