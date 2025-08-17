package com.unity3d.scar.adapter.v2100.scarads;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.unity3d.scar.adapter.common.GMAAdsError;
import com.unity3d.scar.adapter.common.IAdsErrorHandler;
import com.unity3d.scar.adapter.common.IScarRewardedAdListenerWrapper;
import com.unity3d.scar.adapter.common.scarads.IScarLoadListener;
import com.unity3d.scar.adapter.common.scarads.ScarAdMetadata;
import com.unity3d.scar.adapter.v2100.requests.AdRequestFactory;

public class ScarRewardedAd extends ScarAdBase<RewardedAd> {
    public ScarRewardedAd(Context context, AdRequestFactory adRequestFactory, ScarAdMetadata scarAdMetadata, IAdsErrorHandler iAdsErrorHandler, IScarRewardedAdListenerWrapper iScarRewardedAdListenerWrapper) {
        super(context, scarAdMetadata, adRequestFactory, iAdsErrorHandler);
        this.f37179e = new ScarRewardedAdListener(iScarRewardedAdListenerWrapper, this);
    }

    public void a(Activity activity) {
        T t2 = this.f37175a;
        if (t2 != null) {
            ((RewardedAd) t2).show(activity, ((ScarRewardedAdListener) this.f37179e).f());
        } else {
            this.f37180f.handleError(GMAAdsError.a(this.f37177c));
        }
    }

    /* access modifiers changed from: protected */
    public void c(AdRequest adRequest, IScarLoadListener iScarLoadListener) {
        RewardedAd.load(this.f37176b, this.f37177c.b(), adRequest, ((ScarRewardedAdListener) this.f37179e).e());
    }
}
