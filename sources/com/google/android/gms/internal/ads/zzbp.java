package com.google.android.gms.internal.ads;

public final class zzbp {
    public static final zzbp zza = new zzar().zzc();
    public static final zzn zzb = zzao.zza;
    private static final String zzk = Integer.toString(0, 36);
    private static final String zzl = Integer.toString(1, 36);
    private static final String zzm = Integer.toString(2, 36);
    private static final String zzn = Integer.toString(3, 36);
    private static final String zzo = Integer.toString(4, 36);
    private static final String zzp = Integer.toString(5, 36);
    public final String zzc;
    public final zzbi zzd;
    @Deprecated
    public final zzbi zze;
    public final zzbf zzf;
    public final zzbv zzg;
    public final zzav zzh;
    @Deprecated
    public final zzax zzi;
    public final zzbl zzj;

    /* synthetic */ zzbp(String str, zzax zzax, zzbi zzbi, zzbf zzbf, zzbv zzbv, zzbl zzbl, zzbo zzbo) {
        this.zzc = str;
        this.zzd = zzbi;
        this.zze = zzbi;
        this.zzf = zzbf;
        this.zzg = zzbv;
        this.zzh = zzax;
        this.zzi = zzax;
        this.zzj = zzbl;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbp)) {
            return false;
        }
        zzbp zzbp = (zzbp) obj;
        if (!zzfj.zzC(this.zzc, zzbp.zzc) || !this.zzh.equals(zzbp.zzh) || !zzfj.zzC(this.zzd, zzbp.zzd) || !zzfj.zzC(this.zzf, zzbp.zzf) || !zzfj.zzC(this.zzg, zzbp.zzg) || !zzfj.zzC(this.zzj, zzbp.zzj)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int i2;
        int hashCode = this.zzc.hashCode() * 31;
        zzbi zzbi = this.zzd;
        if (zzbi != null) {
            i2 = zzbi.hashCode();
        } else {
            i2 = 0;
        }
        return (((((((hashCode + i2) * 31) + this.zzf.hashCode()) * 31) + this.zzh.hashCode()) * 31) + this.zzg.hashCode()) * 31;
    }
}
