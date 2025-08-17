package b0;

import com.chartboost.sdk.ads.Interstitial;
import com.chartboost.sdk.callbacks.InterstitialCallback;
import com.chartboost.sdk.impl.t7;

public final /* synthetic */ class o0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ InterstitialCallback f12755b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Interstitial f12756c;

    public /* synthetic */ o0(InterstitialCallback interstitialCallback, Interstitial interstitial) {
        this.f12755b = interstitialCallback;
        this.f12756c = interstitial;
    }

    public final void run() {
        t7.b(this.f12755b, this.f12756c);
    }
}
