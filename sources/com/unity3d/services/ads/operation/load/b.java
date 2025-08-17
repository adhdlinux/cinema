package com.unity3d.services.ads.operation.load;

import com.unity3d.ads.UnityAds;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoadOperationState f37202b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ UnityAds.UnityAdsLoadError f37203c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f37204d;

    public /* synthetic */ b(LoadOperationState loadOperationState, UnityAds.UnityAdsLoadError unityAdsLoadError, String str) {
        this.f37202b = loadOperationState;
        this.f37203c = unityAdsLoadError;
        this.f37204d = str;
    }

    public final void run() {
        this.f37202b.lambda$onUnityAdsFailedToLoad$0(this.f37203c, this.f37204d);
    }
}
