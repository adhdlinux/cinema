package com.vungle.ads.internal;

import com.vungle.ads.VungleError;
import com.vungle.ads.internal.AdInternal;
import com.vungle.ads.internal.presenter.AdPlayCallback;
import com.vungle.ads.internal.presenter.AdPlayCallbackWrapper;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import kotlin.jvm.internal.Intrinsics;

public final class BannerAdInternal$wrapCallback$1 extends AdPlayCallbackWrapper {
    final /* synthetic */ BannerAdInternal this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BannerAdInternal$wrapCallback$1(AdPlayCallback adPlayCallback, BannerAdInternal bannerAdInternal) {
        super(adPlayCallback);
        this.this$0 = bannerAdInternal;
    }

    public void onAdEnd(String str) {
        this.this$0.setAdState(AdInternal.AdState.FINISHED);
        super.onAdEnd(str);
    }

    public void onAdStart(String str) {
        this.this$0.setAdState(AdInternal.AdState.PLAYING);
        super.onAdStart(str);
    }

    public void onFailure(VungleError vungleError) {
        Intrinsics.f(vungleError, MRAIDPresenter.ERROR);
        this.this$0.setAdState(AdInternal.AdState.ERROR);
        super.onFailure(vungleError);
    }
}
