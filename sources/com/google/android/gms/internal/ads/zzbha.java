package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.UnifiedNativeAd;

public final class zzbha extends zzbgk {
    private final UnifiedNativeAd.UnconfirmedClickListener zza;

    public zzbha(UnifiedNativeAd.UnconfirmedClickListener unconfirmedClickListener) {
        this.zza = unconfirmedClickListener;
    }

    public final void zze() {
        this.zza.onUnconfirmedClickCancelled();
    }

    public final void zzf(String str) {
        this.zza.onUnconfirmedClickReceived(str);
    }
}
