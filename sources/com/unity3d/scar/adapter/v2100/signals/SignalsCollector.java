package com.unity3d.scar.adapter.v2100.signals;

import android.content.Context;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.query.QueryInfo;
import com.unity3d.scar.adapter.common.DispatchGroup;
import com.unity3d.scar.adapter.common.signals.SignalCallbackListener;
import com.unity3d.scar.adapter.common.signals.SignalsCollectorBase;
import com.unity3d.scar.adapter.common.signals.SignalsResult;
import com.unity3d.scar.adapter.v2100.requests.AdRequestFactory;

public class SignalsCollector extends SignalsCollectorBase {

    /* renamed from: a  reason: collision with root package name */
    private AdRequestFactory f37198a;

    public SignalsCollector(AdRequestFactory adRequestFactory) {
        this.f37198a = adRequestFactory;
    }

    public void c(Context context, boolean z2, DispatchGroup dispatchGroup, SignalsResult signalsResult) {
        String str;
        if (z2) {
            str = "gmaScarBiddingInterstitialSignal";
        } else {
            str = "gmaScarBiddingRewardedSignal";
        }
        d(context, str, z2, dispatchGroup, signalsResult);
    }

    public void d(Context context, String str, boolean z2, DispatchGroup dispatchGroup, SignalsResult signalsResult) {
        AdFormat adFormat;
        AdRequest a2 = this.f37198a.a();
        if (z2) {
            adFormat = AdFormat.INTERSTITIAL;
        } else {
            adFormat = AdFormat.REWARDED;
        }
        QueryInfo.generate(context, adFormat, a2, new QueryInfoCallback(str, new SignalCallbackListener(dispatchGroup, signalsResult)));
    }
}
