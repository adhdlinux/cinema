package b0;

import com.chartboost.sdk.ads.Ad;
import com.chartboost.sdk.callbacks.AdCallback;
import com.chartboost.sdk.events.ClickError;
import com.chartboost.sdk.impl.d;

public final /* synthetic */ class k implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Ad f12732b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AdCallback f12733c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f12734d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ClickError f12735e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ d f12736f;

    public /* synthetic */ k(Ad ad, AdCallback adCallback, String str, ClickError clickError, d dVar) {
        this.f12732b = ad;
        this.f12733c = adCallback;
        this.f12734d = str;
        this.f12735e = clickError;
        this.f12736f = dVar;
    }

    public final void run() {
        d.a(this.f12732b, this.f12733c, this.f12734d, this.f12735e, this.f12736f);
    }
}
