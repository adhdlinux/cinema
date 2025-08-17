package com.unity3d.scar.adapter.v1920;

import android.content.Context;
import com.google.android.gms.ads.query.QueryInfo;
import com.unity3d.scar.adapter.common.IAdsErrorHandler;
import com.unity3d.scar.adapter.common.IScarInterstitialAdListenerWrapper;
import com.unity3d.scar.adapter.common.IScarRewardedAdListenerWrapper;
import com.unity3d.scar.adapter.common.ScarAdapterBase;
import com.unity3d.scar.adapter.common.Utils;
import com.unity3d.scar.adapter.common.WebViewAdsError;
import com.unity3d.scar.adapter.common.scarads.IScarLoadListener;
import com.unity3d.scar.adapter.common.scarads.ScarAdMetadata;
import com.unity3d.scar.adapter.common.signals.SignalsStorage;
import com.unity3d.scar.adapter.v1920.scarads.ScarInterstitialAd;
import com.unity3d.scar.adapter.v1920.scarads.ScarRewardedAd;
import com.unity3d.scar.adapter.v1920.signals.SignalsCollector;

public class ScarAdapter extends ScarAdapterBase {

    /* renamed from: e  reason: collision with root package name */
    private SignalsStorage<QueryInfo> f37068e;

    public ScarAdapter(IAdsErrorHandler<WebViewAdsError> iAdsErrorHandler) {
        super(iAdsErrorHandler);
        SignalsStorage<QueryInfo> signalsStorage = new SignalsStorage<>();
        this.f37068e = signalsStorage;
        this.f37044a = new SignalsCollector(signalsStorage);
    }

    public void d(Context context, final ScarAdMetadata scarAdMetadata, IScarRewardedAdListenerWrapper iScarRewardedAdListenerWrapper) {
        final ScarRewardedAd scarRewardedAd = new ScarRewardedAd(context, this.f37068e.a(scarAdMetadata.c()), scarAdMetadata, this.f37047d, iScarRewardedAdListenerWrapper);
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
        final ScarInterstitialAd scarInterstitialAd = new ScarInterstitialAd(context, this.f37068e.a(scarAdMetadata.c()), scarAdMetadata, this.f37047d, iScarInterstitialAdListenerWrapper);
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
