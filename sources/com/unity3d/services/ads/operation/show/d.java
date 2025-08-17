package com.unity3d.services.ads.operation.show;

import com.unity3d.ads.UnityAds;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ShowOperationState f37210b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ UnityAds.UnityAdsShowError f37211c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f37212d;

    public /* synthetic */ d(ShowOperationState showOperationState, UnityAds.UnityAdsShowError unityAdsShowError, String str) {
        this.f37210b = showOperationState;
        this.f37211c = unityAdsShowError;
        this.f37212d = str;
    }

    public final void run() {
        this.f37210b.lambda$onUnityAdsShowFailure$0(this.f37211c, this.f37212d);
    }
}
