package com.google.android.gms.ads;

import com.google.android.gms.internal.ads.zzbsw;

public final /* synthetic */ class zzd implements Runnable {
    public final /* synthetic */ BaseAdView zza;

    public /* synthetic */ zzd(BaseAdView baseAdView) {
        this.zza = baseAdView;
    }

    public final void run() {
        BaseAdView baseAdView = this.zza;
        try {
            baseAdView.zza.zzn();
        } catch (IllegalStateException e2) {
            zzbsw.zza(baseAdView.getContext()).zzf(e2, "BaseAdView.pause");
        }
    }
}
