package b0;

import com.chartboost.sdk.ads.Rewarded;
import com.chartboost.sdk.callbacks.RewardedCallback;
import com.chartboost.sdk.impl.ha;

public final /* synthetic */ class v implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RewardedCallback f12769b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Rewarded f12770c;

    public /* synthetic */ v(RewardedCallback rewardedCallback, Rewarded rewarded) {
        this.f12769b = rewardedCallback;
        this.f12770c = rewarded;
    }

    public final void run() {
        ha.b(this.f12769b, this.f12770c);
    }
}
