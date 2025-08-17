package com.unity3d.scar.adapter.v1920.signals;

import android.content.Context;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.query.QueryInfo;
import com.unity3d.scar.adapter.common.DispatchGroup;
import com.unity3d.scar.adapter.common.signals.SignalCallbackListener;
import com.unity3d.scar.adapter.common.signals.SignalsCollectorBase;
import com.unity3d.scar.adapter.common.signals.SignalsResult;
import com.unity3d.scar.adapter.common.signals.SignalsStorage;

public class SignalsCollector extends SignalsCollectorBase {

    /* renamed from: a  reason: collision with root package name */
    private SignalsStorage<QueryInfo> f37099a;

    public SignalsCollector(SignalsStorage<QueryInfo> signalsStorage) {
        this.f37099a = signalsStorage;
    }

    public void c(Context context, boolean z2, DispatchGroup dispatchGroup, SignalsResult signalsResult) {
        e("GMA v1920 - SCAR signal retrieval required a placementId", dispatchGroup, signalsResult);
    }

    public void d(Context context, String str, boolean z2, DispatchGroup dispatchGroup, SignalsResult signalsResult) {
        AdFormat adFormat;
        AdRequest build = new AdRequest.Builder().build();
        if (z2) {
            adFormat = AdFormat.INTERSTITIAL;
        } else {
            adFormat = AdFormat.REWARDED;
        }
        QueryInfo.generate(context, adFormat, build, new QueryInfoCallback(str, new SignalCallbackListener(dispatchGroup, this.f37099a, signalsResult)));
    }
}
