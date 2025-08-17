package b0;

import com.chartboost.sdk.ads.Banner;
import com.chartboost.sdk.callbacks.BannerCallback;
import com.chartboost.sdk.impl.p1;

public final /* synthetic */ class d0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BannerCallback f12702b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Banner f12703c;

    public /* synthetic */ d0(BannerCallback bannerCallback, Banner banner) {
        this.f12702b = bannerCallback;
        this.f12703c = banner;
    }

    public final void run() {
        p1.c(this.f12702b, this.f12703c);
    }
}
