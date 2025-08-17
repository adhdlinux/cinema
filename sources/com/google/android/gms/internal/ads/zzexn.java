package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zze;

public final /* synthetic */ class zzexn implements Runnable {
    public final /* synthetic */ zzexp zza;
    public final /* synthetic */ zze zzb;

    public /* synthetic */ zzexn(zzexp zzexp, zze zze) {
        this.zza = zzexp;
        this.zzb = zze;
    }

    public final void run() {
        zzexp zzexp = this.zza;
        zzexp.zze.zzd.zza(this.zzb);
    }
}
