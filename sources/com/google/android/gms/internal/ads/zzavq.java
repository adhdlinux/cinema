package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.internal.client.zze;

public final class zzavq extends zzavz {
    private FullScreenContentCallback zza;

    public final void zzb() {
        FullScreenContentCallback fullScreenContentCallback = this.zza;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.onAdClicked();
        }
    }

    public final void zzc() {
        FullScreenContentCallback fullScreenContentCallback = this.zza;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.onAdDismissedFullScreenContent();
        }
    }

    public final void zzd(zze zze) {
        FullScreenContentCallback fullScreenContentCallback = this.zza;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.onAdFailedToShowFullScreenContent(zze.zza());
        }
    }

    public final void zze() {
        FullScreenContentCallback fullScreenContentCallback = this.zza;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.onAdImpression();
        }
    }

    public final void zzf() {
        FullScreenContentCallback fullScreenContentCallback = this.zza;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.onAdShowedFullScreenContent();
        }
    }

    public final void zzg(FullScreenContentCallback fullScreenContentCallback) {
        this.zza = fullScreenContentCallback;
    }
}
