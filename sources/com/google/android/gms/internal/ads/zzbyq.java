package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

final class zzbyq implements Runnable {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzcaj zzb;

    zzbyq(zzbyr zzbyr, Context context, zzcaj zzcaj) {
        this.zza = context;
        this.zzb = zzcaj;
    }

    public final void run() {
        try {
            this.zzb.zzd(AdvertisingIdClient.getAdvertisingIdInfo(this.zza));
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException | IllegalStateException e2) {
            this.zzb.zze(e2);
            zzbzr.zzh("Exception while getting advertising Id info", e2);
        }
    }
}
