package com.unity3d.services.ads.gmascar.managers;

import com.unity3d.ads.IUnityAdsTokenListener;

public class BiddingOnDemandManager extends BiddingBaseManager {
    public BiddingOnDemandManager(IUnityAdsTokenListener iUnityAdsTokenListener) {
        super(iUnityAdsTokenListener);
    }

    public void onUnityTokenSuccessfullyFetched() {
        permitSignalsUpload();
    }

    public void start() {
        fetchSignals();
    }
}
