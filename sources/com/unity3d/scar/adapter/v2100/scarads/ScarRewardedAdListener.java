package com.unity3d.scar.adapter.v2100.scarads;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.unity3d.scar.adapter.common.IScarRewardedAdListenerWrapper;
import com.unity3d.scar.adapter.common.scarads.IScarLoadListener;

public class ScarRewardedAdListener extends ScarAdListener {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final ScarRewardedAd f37188b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final IScarRewardedAdListenerWrapper f37189c;

    /* renamed from: d  reason: collision with root package name */
    private final RewardedAdLoadCallback f37190d = new RewardedAdLoadCallback() {
        /* renamed from: a */
        public void onAdLoaded(RewardedAd rewardedAd) {
            super.onAdLoaded(rewardedAd);
            ScarRewardedAdListener.this.f37189c.onAdLoaded();
            rewardedAd.setFullScreenContentCallback(ScarRewardedAdListener.this.f37192f);
            ScarRewardedAdListener.this.f37188b.d(rewardedAd);
            IScarLoadListener iScarLoadListener = ScarRewardedAdListener.this.f37181a;
            if (iScarLoadListener != null) {
                iScarLoadListener.onAdLoaded();
            }
        }

        public void onAdFailedToLoad(LoadAdError loadAdError) {
            super.onAdFailedToLoad(loadAdError);
            ScarRewardedAdListener.this.f37189c.onAdFailedToLoad(loadAdError.getCode(), loadAdError.toString());
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private final OnUserEarnedRewardListener f37191e = new OnUserEarnedRewardListener() {
        public void onUserEarnedReward(RewardItem rewardItem) {
            ScarRewardedAdListener.this.f37189c.onUserEarnedReward();
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final FullScreenContentCallback f37192f = new FullScreenContentCallback() {
        public void onAdClicked() {
            super.onAdClicked();
            ScarRewardedAdListener.this.f37189c.onAdClicked();
        }

        public void onAdDismissedFullScreenContent() {
            super.onAdDismissedFullScreenContent();
            ScarRewardedAdListener.this.f37189c.onAdClosed();
        }

        public void onAdFailedToShowFullScreenContent(AdError adError) {
            super.onAdFailedToShowFullScreenContent(adError);
            ScarRewardedAdListener.this.f37189c.onAdFailedToShow(adError.getCode(), adError.toString());
        }

        public void onAdImpression() {
            super.onAdImpression();
            ScarRewardedAdListener.this.f37189c.onAdImpression();
        }

        public void onAdShowedFullScreenContent() {
            super.onAdShowedFullScreenContent();
            ScarRewardedAdListener.this.f37189c.onAdOpened();
        }
    };

    public ScarRewardedAdListener(IScarRewardedAdListenerWrapper iScarRewardedAdListenerWrapper, ScarRewardedAd scarRewardedAd) {
        this.f37189c = iScarRewardedAdListenerWrapper;
        this.f37188b = scarRewardedAd;
    }

    public RewardedAdLoadCallback e() {
        return this.f37190d;
    }

    public OnUserEarnedRewardListener f() {
        return this.f37191e;
    }
}
