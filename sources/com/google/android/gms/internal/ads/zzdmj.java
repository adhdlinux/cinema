package com.google.android.gms.internal.ads;

public final class zzdmj implements zzbiy {
    private final zzcwn zza;
    private final zzbvg zzb;
    private final String zzc;
    private final String zzd;

    public zzdmj(zzcwn zzcwn, zzezn zzezn) {
        this.zza = zzcwn;
        this.zzb = zzezn.zzm;
        this.zzc = zzezn.zzk;
        this.zzd = zzezn.zzl;
    }

    public final void zza(zzbvg zzbvg) {
        int i2;
        String str;
        zzbvg zzbvg2 = this.zzb;
        if (zzbvg2 != null) {
            zzbvg = zzbvg2;
        }
        if (zzbvg != null) {
            str = zzbvg.zza;
            i2 = zzbvg.zzb;
        } else {
            i2 = 1;
            str = "";
        }
        this.zza.zzd(new zzbur(str, i2), this.zzc, this.zzd);
    }

    public final void zzb() {
        this.zza.zze();
    }

    public final void zzc() {
        this.zza.zzf();
    }
}
