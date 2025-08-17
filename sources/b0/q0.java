package b0;

import com.chartboost.sdk.ads.Interstitial;
import com.chartboost.sdk.callbacks.InterstitialCallback;
import com.chartboost.sdk.impl.t7;

public final /* synthetic */ class q0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ InterstitialCallback f12760b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Interstitial f12761c;

    public /* synthetic */ q0(InterstitialCallback interstitialCallback, Interstitial interstitial) {
        this.f12760b = interstitialCallback;
        this.f12761c = interstitial;
    }

    public final void run() {
        t7.a(this.f12760b, this.f12761c);
    }
}
