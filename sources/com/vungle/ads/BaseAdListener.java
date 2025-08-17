package com.vungle.ads;

public interface BaseAdListener {
    void onAdClicked(BaseAd baseAd);

    void onAdEnd(BaseAd baseAd);

    void onAdFailedToLoad(BaseAd baseAd, VungleError vungleError);

    void onAdFailedToPlay(BaseAd baseAd, VungleError vungleError);

    void onAdImpression(BaseAd baseAd);

    void onAdLeftApplication(BaseAd baseAd);

    void onAdLoaded(BaseAd baseAd);

    void onAdStart(BaseAd baseAd);
}
