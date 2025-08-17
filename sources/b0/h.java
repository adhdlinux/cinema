package b0;

import com.chartboost.sdk.ads.Ad;
import com.chartboost.sdk.callbacks.AdCallback;
import com.chartboost.sdk.impl.d;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Ad f12717b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AdCallback f12718c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f12719d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ d f12720e;

    public /* synthetic */ h(Ad ad, AdCallback adCallback, String str, d dVar) {
        this.f12717b = ad;
        this.f12718c = adCallback;
        this.f12719d = str;
        this.f12720e = dVar;
    }

    public final void run() {
        d.b(this.f12717b, this.f12718c, this.f12719d, this.f12720e);
    }
}
