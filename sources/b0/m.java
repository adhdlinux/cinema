package b0;

import com.chartboost.sdk.ads.Ad;
import com.chartboost.sdk.callbacks.AdCallback;
import com.chartboost.sdk.impl.d;

public final /* synthetic */ class m implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AdCallback f12744b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Ad f12745c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f12746d;

    public /* synthetic */ m(AdCallback adCallback, Ad ad, String str) {
        this.f12744b = adCallback;
        this.f12745c = ad;
        this.f12746d = str;
    }

    public final void run() {
        d.a(this.f12744b, this.f12745c, this.f12746d);
    }
}
