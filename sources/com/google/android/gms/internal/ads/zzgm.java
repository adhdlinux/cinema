package com.google.android.gms.internal.ads;

public final class zzgm implements zzgd {
    private final zzha zza = new zzha();
    private zzhg zzb;
    private String zzc;
    private int zzd = 8000;
    private int zze = 8000;
    private boolean zzf;

    public final zzgm zzb(boolean z2) {
        this.zzf = true;
        return this;
    }

    public final zzgm zzc(int i2) {
        this.zzd = i2;
        return this;
    }

    public final zzgm zzd(int i2) {
        this.zze = i2;
        return this;
    }

    public final zzgm zze(zzhg zzhg) {
        this.zzb = zzhg;
        return this;
    }

    public final zzgm zzf(String str) {
        this.zzc = str;
        return this;
    }

    /* renamed from: zzg */
    public final zzgr zza() {
        zzgr zzgr = new zzgr(this.zzc, this.zzd, this.zze, this.zzf, this.zza, (zzfpi) null, false, (zzgq) null);
        zzhg zzhg = this.zzb;
        if (zzhg != null) {
            zzgr.zzf(zzhg);
        }
        return zzgr;
    }
}
