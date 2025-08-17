package com.unity3d.services.ads.gmascar.managers;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BiddingBaseManager f37199b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f37200c;

    public /* synthetic */ a(BiddingBaseManager biddingBaseManager, String str) {
        this.f37199b = biddingBaseManager;
        this.f37200c = str;
    }

    public final void run() {
        this.f37199b.lambda$onUnityAdsTokenReady$0(this.f37200c);
    }
}
