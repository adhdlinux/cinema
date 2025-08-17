package com.unity3d.scar.adapter.v1920.scarads;

import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.unity3d.scar.adapter.common.IScarRewardedAdListenerWrapper;
import com.unity3d.scar.adapter.common.scarads.IScarLoadListener;

public class ScarRewardedAdListener {

    /* renamed from: a  reason: collision with root package name */
    private RewardedAd f37090a;

    /* renamed from: b  reason: collision with root package name */
    private IScarRewardedAdListenerWrapper f37091b;

    /* renamed from: c  reason: collision with root package name */
    private IScarLoadListener f37092c;

    /* renamed from: d  reason: collision with root package name */
    private RewardedAdLoadCallback f37093d = new RewardedAdLoadCallback() {
    };

    /* renamed from: e  reason: collision with root package name */
    private RewardedAdCallback f37094e = new RewardedAdCallback() {
    };

    public ScarRewardedAdListener(RewardedAd rewardedAd, IScarRewardedAdListenerWrapper iScarRewardedAdListenerWrapper) {
        this.f37090a = rewardedAd;
        this.f37091b = iScarRewardedAdListenerWrapper;
    }

    public RewardedAdCallback a() {
        return this.f37094e;
    }

    public RewardedAdLoadCallback b() {
        return this.f37093d;
    }

    public void c(IScarLoadListener iScarLoadListener) {
        this.f37092c = iScarLoadListener;
    }
}
