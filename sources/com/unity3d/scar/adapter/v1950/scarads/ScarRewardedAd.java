package com.unity3d.scar.adapter.v1950.scarads;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.unity3d.scar.adapter.common.GMAAdsError;
import com.unity3d.scar.adapter.common.IAdsErrorHandler;
import com.unity3d.scar.adapter.common.IScarRewardedAdListenerWrapper;
import com.unity3d.scar.adapter.common.scarads.IScarLoadListener;
import com.unity3d.scar.adapter.common.scarads.ScarAdMetadata;

public class ScarRewardedAd extends ScarAdBase {

    /* renamed from: e  reason: collision with root package name */
    private RewardedAd f37120e;

    /* renamed from: f  reason: collision with root package name */
    private ScarRewardedAdListener f37121f;

    public ScarRewardedAd(Context context, QueryInfo queryInfo, ScarAdMetadata scarAdMetadata, IAdsErrorHandler iAdsErrorHandler, IScarRewardedAdListenerWrapper iScarRewardedAdListenerWrapper) {
        super(context, scarAdMetadata, queryInfo, iAdsErrorHandler);
        RewardedAd rewardedAd = new RewardedAd(this.f37109a, this.f37110b.b());
        this.f37120e = rewardedAd;
        this.f37121f = new ScarRewardedAdListener(rewardedAd, iScarRewardedAdListenerWrapper);
    }

    public void a(Activity activity) {
        if (this.f37120e.isLoaded()) {
            this.f37120e.show(activity, this.f37121f.a());
        } else {
            this.f37112d.handleError(GMAAdsError.a(this.f37110b));
        }
    }

    public void c(IScarLoadListener iScarLoadListener, AdRequest adRequest) {
        this.f37121f.c(iScarLoadListener);
        this.f37120e.loadAd(adRequest, this.f37121f.b());
    }
}
