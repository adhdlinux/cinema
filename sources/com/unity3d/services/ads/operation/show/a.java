package com.unity3d.services.ads.operation.show;

import com.unity3d.ads.UnityAds;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ShowOperationState f37205b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ UnityAds.UnityAdsShowCompletionState f37206c;

    public /* synthetic */ a(ShowOperationState showOperationState, UnityAds.UnityAdsShowCompletionState unityAdsShowCompletionState) {
        this.f37205b = showOperationState;
        this.f37206c = unityAdsShowCompletionState;
    }

    public final void run() {
        this.f37205b.lambda$onUnityAdsShowComplete$3(this.f37206c);
    }
}
