package b0;

import com.chartboost.sdk.ads.Banner;
import com.chartboost.sdk.callbacks.BannerCallback;
import com.chartboost.sdk.impl.p1;

public final /* synthetic */ class g0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BannerCallback f12715b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Banner f12716c;

    public /* synthetic */ g0(BannerCallback bannerCallback, Banner banner) {
        this.f12715b = bannerCallback;
        this.f12716c = banner;
    }

    public final void run() {
        p1.a(this.f12715b, this.f12716c);
    }
}
