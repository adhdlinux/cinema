package com.google.android.gms.internal.ads;

public final class zzewt implements zzexe {
    private zzcun zza;

    /* renamed from: zza */
    public final synchronized zzcun zzd() {
        return this.zza;
    }

    public final synchronized zzfwm zzb(zzexf zzexf, zzexd zzexd, zzcun zzcun) {
        zzcsk zzb;
        if (zzcun != null) {
            this.zza = zzcun;
        } else {
            this.zza = (zzcun) zzexd.zza(zzexf.zzb).zzh();
        }
        zzb = this.zza.zzb();
        return zzb.zzi(zzb.zzj());
    }

    public final /* bridge */ /* synthetic */ zzfwm zzc(zzexf zzexf, zzexd zzexd, Object obj) {
        return zzb(zzexf, zzexd, (zzcun) null);
    }
}
