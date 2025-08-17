package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzm;
import com.google.android.gms.ads.internal.zzt;

final class zzbqk implements Runnable {
    final /* synthetic */ AdOverlayInfoParcel zza;
    final /* synthetic */ zzbql zzb;

    zzbqk(zzbql zzbql, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.zzb = zzbql;
        this.zza = adOverlayInfoParcel;
    }

    public final void run() {
        zzt.zzi();
        zzm.zza(this.zzb.zza, this.zza, true);
    }
}
