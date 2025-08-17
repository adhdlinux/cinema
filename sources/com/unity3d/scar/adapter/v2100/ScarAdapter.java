package com.unity3d.scar.adapter.v2100;

import android.content.Context;
import com.unity3d.scar.adapter.common.IAdsErrorHandler;
import com.unity3d.scar.adapter.common.IScarInterstitialAdListenerWrapper;
import com.unity3d.scar.adapter.common.IScarRewardedAdListenerWrapper;
import com.unity3d.scar.adapter.common.ScarAdapterBase;
import com.unity3d.scar.adapter.common.Utils;
import com.unity3d.scar.adapter.common.WebViewAdsError;
import com.unity3d.scar.adapter.common.requests.RequestExtras;
import com.unity3d.scar.adapter.common.scarads.IScarLoadListener;
import com.unity3d.scar.adapter.common.scarads.ScarAdMetadata;
import com.unity3d.scar.adapter.v2100.requests.AdRequestFactory;
import com.unity3d.scar.adapter.v2100.scarads.ScarInterstitialAd;
import com.unity3d.scar.adapter.v2100.scarads.ScarRewardedAd;
import com.unity3d.scar.adapter.v2100.signals.SignalsCollector;

public class ScarAdapter extends ScarAdapterBase {

    /* renamed from: e  reason: collision with root package name */
    private AdRequestFactory f37165e;

    public ScarAdapter(IAdsErrorHandler<WebViewAdsError> iAdsErrorHandler, String str) {
        super(iAdsErrorHandler);
        AdRequestFactory adRequestFactory = new AdRequestFactory(new RequestExtras(str));
        this.f37165e = adRequestFactory;
        this.f37044a = new SignalsCollector(adRequestFactory);
    }

    public void d(Context context, final ScarAdMetadata scarAdMetadata, IScarRewardedAdListenerWrapper iScarRewardedAdListenerWrapper) {
        final ScarRewardedAd scarRewardedAd = new ScarRewardedAd(context, this.f37165e, scarAdMetadata, this.f37047d, iScarRewardedAdListenerWrapper);
        Utils.a(new Runnable() {
            public void run() {
                scarRewardedAd.b(new IScarLoadListener() {
                    public void onAdLoaded() {
                        ScarAdapter.this.f37045b.put(scarAdMetadata.c(), scarRewardedAd);
                    }
                });
            }
        });
    }

    public void e(Context context, final ScarAdMetadata scarAdMetadata, IScarInterstitialAdListenerWrapper iScarInterstitialAdListenerWrapper) {
        final ScarInterstitialAd scarInterstitialAd = new ScarInterstitialAd(context, this.f37165e, scarAdMetadata, this.f37047d, iScarInterstitialAdListenerWrapper);
        Utils.a(new Runnable() {
            public void run() {
                scarInterstitialAd.b(new IScarLoadListener() {
                    public void onAdLoaded() {
                        ScarAdapter.this.f37045b.put(scarAdMetadata.c(), scarInterstitialAd);
                    }
                });
            }
        });
    }
}
