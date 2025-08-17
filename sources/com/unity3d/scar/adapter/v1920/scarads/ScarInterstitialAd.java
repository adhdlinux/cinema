package com.unity3d.scar.adapter.v1920.scarads;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.query.QueryInfo;
import com.unity3d.scar.adapter.common.GMAAdsError;
import com.unity3d.scar.adapter.common.IAdsErrorHandler;
import com.unity3d.scar.adapter.common.IScarInterstitialAdListenerWrapper;
import com.unity3d.scar.adapter.common.scarads.IScarLoadListener;
import com.unity3d.scar.adapter.common.scarads.ScarAdMetadata;

public class ScarInterstitialAd extends ScarAdBase {

    /* renamed from: e  reason: collision with root package name */
    private InterstitialAd f37081e;

    /* renamed from: f  reason: collision with root package name */
    private ScarInterstitialAdListener f37082f;

    public ScarInterstitialAd(Context context, QueryInfo queryInfo, ScarAdMetadata scarAdMetadata, IAdsErrorHandler iAdsErrorHandler, IScarInterstitialAdListenerWrapper iScarInterstitialAdListenerWrapper) {
        super(context, scarAdMetadata, queryInfo, iAdsErrorHandler);
        InterstitialAd interstitialAd = new InterstitialAd(this.f37077a);
        this.f37081e = interstitialAd;
        interstitialAd.setAdUnitId(this.f37078b.b());
        this.f37082f = new ScarInterstitialAdListener(this.f37081e, iScarInterstitialAdListenerWrapper);
    }

    public void a(Activity activity) {
        if (this.f37081e.isLoaded()) {
            this.f37081e.show();
        } else {
            this.f37080d.handleError(GMAAdsError.a(this.f37078b));
        }
    }

    public void c(IScarLoadListener iScarLoadListener, AdRequest adRequest) {
        this.f37081e.setAdListener(this.f37082f.c());
        this.f37082f.d(iScarLoadListener);
        this.f37081e.loadAd(adRequest);
    }
}
