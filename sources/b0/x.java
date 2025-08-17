package b0;

import com.chartboost.sdk.ads.Rewarded;
import com.chartboost.sdk.callbacks.RewardedCallback;
import com.chartboost.sdk.impl.ha;

public final /* synthetic */ class x implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RewardedCallback f12773b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Rewarded f12774c;

    public /* synthetic */ x(RewardedCallback rewardedCallback, Rewarded rewarded) {
        this.f12773b = rewardedCallback;
        this.f12774c = rewarded;
    }

    public final void run() {
        ha.a(this.f12773b, this.f12774c);
    }
}
