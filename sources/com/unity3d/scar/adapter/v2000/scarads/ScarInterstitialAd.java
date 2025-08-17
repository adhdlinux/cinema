package com.unity3d.scar.adapter.v2000.scarads;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.query.QueryInfo;
import com.unity3d.scar.adapter.common.GMAAdsError;
import com.unity3d.scar.adapter.common.IAdsErrorHandler;
import com.unity3d.scar.adapter.common.IScarInterstitialAdListenerWrapper;
import com.unity3d.scar.adapter.common.scarads.IScarLoadListener;
import com.unity3d.scar.adapter.common.scarads.ScarAdMetadata;

public class ScarInterstitialAd extends ScarAdBase<InterstitialAd> {
    public ScarInterstitialAd(Context context, QueryInfo queryInfo, ScarAdMetadata scarAdMetadata, IAdsErrorHandler iAdsErrorHandler, IScarInterstitialAdListenerWrapper iScarInterstitialAdListenerWrapper) {
        super(context, scarAdMetadata, queryInfo, iAdsErrorHandler);
        this.f37145e = new ScarInterstitialAdListener(iScarInterstitialAdListenerWrapper, this);
    }

    public void a(Activity activity) {
        T t2 = this.f37141a;
        if (t2 != null) {
            ((InterstitialAd) t2).show(activity);
        } else {
            this.f37146f.handleError(GMAAdsError.a(this.f37143c));
        }
    }

    /* access modifiers changed from: protected */
    public void c(AdRequest adRequest, IScarLoadListener iScarLoadListener) {
        InterstitialAd.load(this.f37142b, this.f37143c.b(), adRequest, ((ScarInterstitialAdListener) this.f37145e).e());
    }
}
