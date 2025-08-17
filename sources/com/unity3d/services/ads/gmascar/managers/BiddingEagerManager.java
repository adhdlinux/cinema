package com.unity3d.services.ads.gmascar.managers;

import com.unity3d.ads.IUnityAdsTokenListener;

public class BiddingEagerManager extends BiddingBaseManager {
    public BiddingEagerManager(IUnityAdsTokenListener iUnityAdsTokenListener) {
        super(iUnityAdsTokenListener);
    }

    public void onUnityTokenSuccessfullyFetched() {
    }

    public void start() {
        permitSignalsUpload();
        fetchSignals();
    }
}
