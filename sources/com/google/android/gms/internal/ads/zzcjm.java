package com.google.android.gms.internal.ads;

public final class zzcjm {
    private zzcgx zza;
    private zzckz zzb;
    private zzfep zzc;
    private zzcll zzd;
    private zzfbj zze;

    private zzcjm() {
    }

    /* synthetic */ zzcjm(zzcjl zzcjl) {
    }

    public final zzcgu zza() {
        zzgwm.zzc(this.zza, zzcgx.class);
        zzgwm.zzc(this.zzb, zzckz.class);
        if (this.zzc == null) {
            this.zzc = new zzfep();
        }
        if (this.zzd == null) {
            this.zzd = new zzcll();
        }
        if (this.zze == null) {
            this.zze = new zzfbj();
        }
        return new zzciq(this.zza, this.zzb, this.zzc, this.zzd, this.zze, (zzcip) null);
    }

    public final zzcjm zzb(zzcgx zzcgx) {
        this.zza = zzcgx;
        return this;
    }

    public final zzcjm zzc(zzckz zzckz) {
        this.zzb = zzckz;
        return this;
    }
}
