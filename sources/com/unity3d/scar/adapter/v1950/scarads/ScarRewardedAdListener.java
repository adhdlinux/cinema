package com.unity3d.scar.adapter.v1950.scarads;

import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.unity3d.scar.adapter.common.IScarRewardedAdListenerWrapper;
import com.unity3d.scar.adapter.common.scarads.IScarLoadListener;

public class ScarRewardedAdListener {

    /* renamed from: a  reason: collision with root package name */
    private RewardedAd f37122a;

    /* renamed from: b  reason: collision with root package name */
    private IScarRewardedAdListenerWrapper f37123b;

    /* renamed from: c  reason: collision with root package name */
    private IScarLoadListener f37124c;

    /* renamed from: d  reason: collision with root package name */
    private RewardedAdLoadCallback f37125d = new RewardedAdLoadCallback() {
    };

    /* renamed from: e  reason: collision with root package name */
    private RewardedAdCallback f37126e = new RewardedAdCallback() {
    };

    public ScarRewardedAdListener(RewardedAd rewardedAd, IScarRewardedAdListenerWrapper iScarRewardedAdListenerWrapper) {
        this.f37122a = rewardedAd;
        this.f37123b = iScarRewardedAdListenerWrapper;
    }

    public RewardedAdCallback a() {
        return this.f37126e;
    }

    public RewardedAdLoadCallback b() {
        return this.f37125d;
    }

    public void c(IScarLoadListener iScarLoadListener) {
        this.f37124c = iScarLoadListener;
    }
}
