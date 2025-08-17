package com.unity3d.services.core.properties;

import com.unity3d.ads.IUnityAdsInitializationListener;
import com.unity3d.ads.UnityAds;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ IUnityAdsInitializationListener f37215b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ UnityAds.UnityAdsInitializationError f37216c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f37217d;

    public /* synthetic */ b(IUnityAdsInitializationListener iUnityAdsInitializationListener, UnityAds.UnityAdsInitializationError unityAdsInitializationError, String str) {
        this.f37215b = iUnityAdsInitializationListener;
        this.f37216c = unityAdsInitializationError;
        this.f37217d = str;
    }

    public final void run() {
        this.f37215b.onInitializationFailed(this.f37216c, this.f37217d);
    }
}
