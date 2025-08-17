package com.unity3d.scar.adapter.v2100.scarads;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.unity3d.scar.adapter.common.GMAAdsError;
import com.unity3d.scar.adapter.common.IAdsErrorHandler;
import com.unity3d.scar.adapter.common.IScarInterstitialAdListenerWrapper;
import com.unity3d.scar.adapter.common.scarads.IScarLoadListener;
import com.unity3d.scar.adapter.common.scarads.ScarAdMetadata;
import com.unity3d.scar.adapter.v2100.requests.AdRequestFactory;

public class ScarInterstitialAd extends ScarAdBase<InterstitialAd> {
    public ScarInterstitialAd(Context context, AdRequestFactory adRequestFactory, ScarAdMetadata scarAdMetadata, IAdsErrorHandler iAdsErrorHandler, IScarInterstitialAdListenerWrapper iScarInterstitialAdListenerWrapper) {
        super(context, scarAdMetadata, adRequestFactory, iAdsErrorHandler);
        this.f37179e = new ScarInterstitialAdListener(iScarInterstitialAdListenerWrapper, this);
    }

    public void a(Activity activity) {
        T t2 = this.f37175a;
        if (t2 != null) {
            ((InterstitialAd) t2).show(activity);
        } else {
            this.f37180f.handleError(GMAAdsError.a(this.f37177c));
        }
    }

    /* access modifiers changed from: protected */
    public void c(AdRequest adRequest, IScarLoadListener iScarLoadListener) {
        InterstitialAd.load(this.f37176b, this.f37177c.b(), adRequest, ((ScarInterstitialAdListener) this.f37179e).e());
    }
}
