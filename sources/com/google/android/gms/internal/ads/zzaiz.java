package com.google.android.gms.internal.ads;

public final class zzaiz implements zzaji {
    private zzam zza;
    private zzfh zzb;
    private zzabz zzc;

    public zzaiz(String str) {
        zzak zzak = new zzak();
        zzak.zzS(str);
        this.zza = zzak.zzY();
    }

    public final void zza(zzfa zzfa) {
        zzdy.zzb(this.zzb);
        int i2 = zzfj.zza;
        long zzd = this.zzb.zzd();
        long zze = this.zzb.zze();
        if (zzd != -9223372036854775807L && zze != -9223372036854775807L) {
            zzam zzam = this.zza;
            if (zze != zzam.zzq) {
                zzak zzb2 = zzam.zzb();
                zzb2.zzW(zze);
                zzam zzY = zzb2.zzY();
                this.zza = zzY;
                this.zzc.zzk(zzY);
            }
            int zza2 = zzfa.zza();
            this.zzc.zzq(zzfa, zza2);
            this.zzc.zzs(zzd, 1, zza2, 0, (zzaby) null);
        }
    }

    public final void zzb(zzfh zzfh, zzaaz zzaaz, zzajv zzajv) {
        this.zzb = zzfh;
        zzajv.zzc();
        zzabz zzv = zzaaz.zzv(zzajv.zza(), 5);
        this.zzc = zzv;
        zzv.zzk(this.zza);
    }
}
