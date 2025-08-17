package com.unity3d.scar.adapter.common;

public interface IScarAdListenerWrapper {
    void onAdClicked();

    void onAdClosed();

    void onAdFailedToLoad(int i2, String str);

    void onAdLoaded();

    void onAdOpened();
}
