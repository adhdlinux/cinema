package com.google.android.gms.ads;

import com.google.android.gms.internal.ads.zzbsw;

public final /* synthetic */ class zze implements Runnable {
    public final /* synthetic */ BaseAdView zza;

    public /* synthetic */ zze(BaseAdView baseAdView) {
        this.zza = baseAdView;
    }

    public final void run() {
        BaseAdView baseAdView = this.zza;
        try {
            baseAdView.zza.zzk();
        } catch (IllegalStateException e2) {
            zzbsw.zza(baseAdView.getContext()).zzf(e2, "BaseAdView.destroy");
        }
    }
}
