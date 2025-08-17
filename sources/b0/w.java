package b0;

import com.chartboost.sdk.ads.Rewarded;
import com.chartboost.sdk.callbacks.RewardedCallback;
import com.chartboost.sdk.impl.ha;

public final /* synthetic */ class w implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RewardedCallback f12771b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Rewarded f12772c;

    public /* synthetic */ w(RewardedCallback rewardedCallback, Rewarded rewarded) {
        this.f12771b = rewardedCallback;
        this.f12772c = rewarded;
    }

    public final void run() {
        ha.c(this.f12771b, this.f12772c);
    }
}
