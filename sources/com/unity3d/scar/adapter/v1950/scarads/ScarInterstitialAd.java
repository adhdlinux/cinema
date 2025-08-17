package com.unity3d.scar.adapter.v1950.scarads;

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
    private InterstitialAd f37113e;

    /* renamed from: f  reason: collision with root package name */
    private ScarInterstitialAdListener f37114f;

    public ScarInterstitialAd(Context context, QueryInfo queryInfo, ScarAdMetadata scarAdMetadata, IAdsErrorHandler iAdsErrorHandler, IScarInterstitialAdListenerWrapper iScarInterstitialAdListenerWrapper) {
        super(context, scarAdMetadata, queryInfo, iAdsErrorHandler);
        InterstitialAd interstitialAd = new InterstitialAd(this.f37109a);
        this.f37113e = interstitialAd;
        interstitialAd.setAdUnitId(this.f37110b.b());
        this.f37114f = new ScarInterstitialAdListener(this.f37113e, iScarInterstitialAdListenerWrapper);
    }

    public void a(Activity activity) {
        if (this.f37113e.isLoaded()) {
            this.f37113e.show();
        } else {
            this.f37112d.handleError(GMAAdsError.a(this.f37110b));
        }
    }

    public void c(IScarLoadListener iScarLoadListener, AdRequest adRequest) {
        this.f37113e.setAdListener(this.f37114f.c());
        this.f37114f.d(iScarLoadListener);
        this.f37113e.loadAd(adRequest);
    }
}
