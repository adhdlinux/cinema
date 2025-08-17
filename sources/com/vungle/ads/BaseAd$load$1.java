package com.vungle.ads;

import com.vungle.ads.internal.load.AdLoaderCallback;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import kotlin.jvm.internal.Intrinsics;

public final class BaseAd$load$1 implements AdLoaderCallback {
    final /* synthetic */ String $adMarkup;
    final /* synthetic */ BaseAd this$0;

    BaseAd$load$1(BaseAd baseAd, String str) {
        this.this$0 = baseAd;
        this.$adMarkup = str;
    }

    public void onFailure(VungleError vungleError) {
        Intrinsics.f(vungleError, MRAIDPresenter.ERROR);
        BaseAd baseAd = this.this$0;
        baseAd.onLoadFailure$vungle_ads_release(baseAd, vungleError);
    }

    public void onSuccess(AdPayload adPayload) {
        Intrinsics.f(adPayload, "advertisement");
        this.this$0.onAdLoaded$vungle_ads_release(adPayload);
        BaseAd baseAd = this.this$0;
        baseAd.onLoadSuccess$vungle_ads_release(baseAd, this.$adMarkup);
    }
}
