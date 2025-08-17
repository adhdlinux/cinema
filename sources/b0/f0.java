package b0;

import com.chartboost.sdk.ads.Banner;
import com.chartboost.sdk.callbacks.BannerCallback;
import com.chartboost.sdk.impl.p1;

public final /* synthetic */ class f0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BannerCallback f12708b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Banner f12709c;

    public /* synthetic */ f0(BannerCallback bannerCallback, Banner banner) {
        this.f12708b = bannerCallback;
        this.f12709c = banner;
    }

    public final void run() {
        p1.e(this.f12708b, this.f12709c);
    }
}
