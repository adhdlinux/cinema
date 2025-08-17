package com.unity3d.scar.adapter.v2000.scarads;

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

public class ScarRewardedAd extends ScarAdBase<RewardedAd> {
    public ScarRewardedAd(Context context, QueryInfo queryInfo, ScarAdMetadata scarAdMetadata, IAdsErrorHandler iAdsErrorHandler, IScarRewardedAdListenerWrapper iScarRewardedAdListenerWrapper) {
        super(context, scarAdMetadata, queryInfo, iAdsErrorHandler);
        this.f37145e = new ScarRewardedAdListener(iScarRewardedAdListenerWrapper, this);
    }

    public void a(Activity activity) {
        T t2 = this.f37141a;
        if (t2 != null) {
            ((RewardedAd) t2).show(activity, ((ScarRewardedAdListener) this.f37145e).f());
        } else {
            this.f37146f.handleError(GMAAdsError.a(this.f37143c));
        }
    }

    /* access modifiers changed from: protected */
    public void c(AdRequest adRequest, IScarLoadListener iScarLoadListener) {
        RewardedAd.load(this.f37142b, this.f37143c.b(), adRequest, ((ScarRewardedAdListener) this.f37145e).e());
    }
}
