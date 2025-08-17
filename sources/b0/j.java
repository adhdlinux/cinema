package b0;

import com.chartboost.sdk.ads.Ad;
import com.chartboost.sdk.callbacks.AdCallback;
import com.chartboost.sdk.impl.d;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Ad f12727b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AdCallback f12728c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f12729d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ d f12730e;

    public /* synthetic */ j(Ad ad, AdCallback adCallback, String str, d dVar) {
        this.f12727b = ad;
        this.f12728c = adCallback;
        this.f12729d = str;
        this.f12730e = dVar;
    }

    public final void run() {
        d.a(this.f12727b, this.f12728c, this.f12729d, this.f12730e);
    }
}
