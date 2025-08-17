package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zze;

public final class zzffk implements zzdcd, zzcvw, zzdch {
    private final zzffy zza;
    private final zzffn zzb;

    zzffk(Context context, zzffy zzffy) {
        this.zza = zzffy;
        this.zzb = zzffm.zza(context, 13);
    }

    public final void zza() {
    }

    public final void zzb() {
        if (((Boolean) zzbcy.zzd.zze()).booleanValue()) {
            zzffy zzffy = this.zza;
            zzffn zzffn = this.zzb;
            zzffn.zzf(true);
            zzffy.zza(zzffn);
        }
    }

    public final void zzf() {
    }

    public final void zzg() {
        if (((Boolean) zzbcy.zzd.zze()).booleanValue()) {
            this.zzb.zzh();
        }
    }

    public final void zzk(zze zze) {
        if (((Boolean) zzbcy.zzd.zze()).booleanValue()) {
            zzffy zzffy = this.zza;
            zzffn zzffn = this.zzb;
            zzffn.zzc(zze.zza().toString());
            zzffn.zzf(false);
            zzffy.zza(zzffn);
        }
    }
}
