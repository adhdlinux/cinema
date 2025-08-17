package b0;

import com.chartboost.sdk.ads.Banner;
import com.chartboost.sdk.callbacks.BannerCallback;
import com.chartboost.sdk.impl.p1;

public final /* synthetic */ class h0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BannerCallback f12721b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Banner f12722c;

    public /* synthetic */ h0(BannerCallback bannerCallback, Banner banner) {
        this.f12721b = bannerCallback;
        this.f12722c = banner;
    }

    public final void run() {
        p1.b(this.f12721b, this.f12722c);
    }
}
