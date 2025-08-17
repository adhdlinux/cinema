package com.unity3d.scar.adapter.common;

public interface IScarRewardedAdListenerWrapper extends IScarAdListenerWrapper {
    void onAdFailedToShow(int i2, String str);

    void onAdImpression();

    void onUserEarnedReward();
}
