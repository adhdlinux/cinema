package com.unity3d.services.ads.operation.show;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ShowOperationState f37208b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f37209c;

    public /* synthetic */ c(ShowOperationState showOperationState, String str) {
        this.f37208b = showOperationState;
        this.f37209c = str;
    }

    public final void run() {
        this.f37208b.lambda$onUnityAdsShowStart$2(this.f37209c);
    }
}
