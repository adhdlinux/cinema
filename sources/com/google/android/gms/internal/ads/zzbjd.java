package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.h5.OnH5AdsEventListener;

public final class zzbjd extends zzbjf {
    private final OnH5AdsEventListener zza;

    public zzbjd(OnH5AdsEventListener onH5AdsEventListener) {
        this.zza = onH5AdsEventListener;
    }

    public final void zzb(String str) {
        this.zza.onH5AdsEvent(str);
    }
}
