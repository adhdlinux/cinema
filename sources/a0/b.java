package a0;

import com.chartboost.sdk.ads.Interstitial;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f5b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Interstitial f6c;

    public /* synthetic */ b(boolean z2, Interstitial interstitial) {
        this.f5b = z2;
        this.f6c = interstitial;
    }

    public final void run() {
        Interstitial.postSessionNotStartedInMainThread$lambda$0(this.f5b, this.f6c);
    }
}
