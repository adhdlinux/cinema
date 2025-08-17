package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.nativead.NativeAd;

public final class zzbrj extends zzbgk {
    private final NativeAd.UnconfirmedClickListener zza;

    public zzbrj(NativeAd.UnconfirmedClickListener unconfirmedClickListener) {
        this.zza = unconfirmedClickListener;
    }

    public final void zze() {
        this.zza.onUnconfirmedClickCancelled();
    }

    public final void zzf(String str) {
        this.zza.onUnconfirmedClickReceived(str);
    }
}
