package com.google.android.gms.ads.mediation.rtb;

import com.google.android.gms.ads.AdError;

public interface SignalCallbacks {
    void onFailure(AdError adError);

    @Deprecated
    void onFailure(String str);

    void onSuccess(String str);
}
