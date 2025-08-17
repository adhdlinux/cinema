package j1;

import com.unity3d.ads.IUnityAdsTokenListener;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ IUnityAdsTokenListener f40238b;

    public /* synthetic */ a(IUnityAdsTokenListener iUnityAdsTokenListener) {
        this.f40238b = iUnityAdsTokenListener;
    }

    public final void run() {
        this.f40238b.onUnityAdsTokenReady((String) null);
    }
}
