package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.AdError;

public interface MediationAppOpenAdCallback extends MediationAdCallback {
    void onAdFailedToShow(AdError adError);
}
