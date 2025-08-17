package com.google.android.gms.ads;

public abstract class AdLoadCallback<AdT> {
    public void onAdFailedToLoad(LoadAdError loadAdError) {
    }

    public void onAdLoaded(AdT adt) {
    }
}
