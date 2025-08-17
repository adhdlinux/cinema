package com.vungle.ads;

public interface RewardedAdListener extends FullscreenAdListener {
    /* synthetic */ void onAdClicked(BaseAd baseAd);

    /* synthetic */ void onAdEnd(BaseAd baseAd);

    /* synthetic */ void onAdFailedToLoad(BaseAd baseAd, VungleError vungleError);

    /* synthetic */ void onAdFailedToPlay(BaseAd baseAd, VungleError vungleError);

    /* synthetic */ void onAdImpression(BaseAd baseAd);

    /* synthetic */ void onAdLeftApplication(BaseAd baseAd);

    /* synthetic */ void onAdLoaded(BaseAd baseAd);

    void onAdRewarded(BaseAd baseAd);

    /* synthetic */ void onAdStart(BaseAd baseAd);
}
