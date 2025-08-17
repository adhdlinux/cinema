package com.unity3d.scar.adapter.v1920.scarads;

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
    private RewardedAd f37088e;

    /* renamed from: f  reason: collision with root package name */
    private ScarRewardedAdListener f37089f;

    public ScarRewardedAd(Context context, QueryInfo queryInfo, ScarAdMetadata scarAdMetadata, IAdsErrorHandler iAdsErrorHandler, IScarRewardedAdListenerWrapper iScarRewardedAdListenerWrapper) {
        super(context, scarAdMetadata, queryInfo, iAdsErrorHandler);
        RewardedAd rewardedAd = new RewardedAd(this.f37077a, this.f37078b.b());
        this.f37088e = rewardedAd;
        this.f37089f = new ScarRewardedAdListener(rewardedAd, iScarRewardedAdListenerWrapper);
    }

    public void a(Activity activity) {
        if (this.f37088e.isLoaded()) {
            this.f37088e.show(activity, this.f37089f.a());
        } else {
            this.f37080d.handleError(GMAAdsError.a(this.f37078b));
        }
    }

    public void c(IScarLoadListener iScarLoadListener, AdRequest adRequest) {
        this.f37089f.c(iScarLoadListener);
        this.f37088e.loadAd(adRequest, this.f37089f.b());
    }
}
