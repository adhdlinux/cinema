package com.google.android.gms.ads.mediation.customevent;

import android.view.View;

@Deprecated
public interface CustomEventBannerListener extends CustomEventListener {
    void onAdLoaded(View view);
}
