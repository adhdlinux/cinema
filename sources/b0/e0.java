package b0;

import com.chartboost.sdk.ads.Banner;
import com.chartboost.sdk.callbacks.BannerCallback;
import com.chartboost.sdk.impl.p1;

public final /* synthetic */ class e0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BannerCallback f12705b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Banner f12706c;

    public /* synthetic */ e0(BannerCallback bannerCallback, Banner banner) {
        this.f12705b = bannerCallback;
        this.f12706c = banner;
    }

    public final void run() {
        p1.d(this.f12705b, this.f12706c);
    }
}
