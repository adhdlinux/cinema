package com.unity3d.services.core.properties;

import com.unity3d.ads.IUnityAdsInitializationListener;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ IUnityAdsInitializationListener f37214b;

    public /* synthetic */ a(IUnityAdsInitializationListener iUnityAdsInitializationListener) {
        this.f37214b = iUnityAdsInitializationListener;
    }

    public final void run() {
        this.f37214b.onInitializationComplete();
    }
}
