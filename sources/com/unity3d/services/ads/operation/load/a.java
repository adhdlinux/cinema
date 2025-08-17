package com.unity3d.services.ads.operation.load;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoadOperationState f37201b;

    public /* synthetic */ a(LoadOperationState loadOperationState) {
        this.f37201b = loadOperationState;
    }

    public final void run() {
        this.f37201b.lambda$onUnityAdsAdLoaded$1();
    }
}
