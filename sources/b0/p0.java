package b0;

import com.chartboost.sdk.ads.Interstitial;
import com.chartboost.sdk.callbacks.InterstitialCallback;
import com.chartboost.sdk.impl.t7;

public final /* synthetic */ class p0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ InterstitialCallback f12758b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Interstitial f12759c;

    public /* synthetic */ p0(InterstitialCallback interstitialCallback, Interstitial interstitial) {
        this.f12758b = interstitialCallback;
        this.f12759c = interstitial;
    }

    public final void run() {
        t7.c(this.f12758b, this.f12759c);
    }
}
