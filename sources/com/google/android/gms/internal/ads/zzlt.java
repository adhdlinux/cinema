package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzlt {
    public final long zza;
    public final zzcw zzb;
    public final int zzc;
    public final zzto zzd;
    public final long zze;
    public final zzcw zzf;
    public final int zzg;
    public final zzto zzh;
    public final long zzi;
    public final long zzj;

    public zzlt(long j2, zzcw zzcw, int i2, zzto zzto, long j3, zzcw zzcw2, int i3, zzto zzto2, long j4, long j5) {
        this.zza = j2;
        this.zzb = zzcw;
        this.zzc = i2;
        this.zzd = zzto;
        this.zze = j3;
        this.zzf = zzcw2;
        this.zzg = i3;
        this.zzh = zzto2;
        this.zzi = j4;
        this.zzj = j5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzlt.class == obj.getClass()) {
            zzlt zzlt = (zzlt) obj;
            if (this.zza == zzlt.zza && this.zzc == zzlt.zzc && this.zze == zzlt.zze && this.zzg == zzlt.zzg && this.zzi == zzlt.zzi && this.zzj == zzlt.zzj && zzfpc.zza(this.zzb, zzlt.zzb) && zzfpc.zza(this.zzd, zzlt.zzd) && zzfpc.zza(this.zzf, zzlt.zzf) && zzfpc.zza(this.zzh, zzlt.zzh)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.zza), this.zzb, Integer.valueOf(this.zzc), this.zzd, Long.valueOf(this.zze), this.zzf, Integer.valueOf(this.zzg), this.zzh, Long.valueOf(this.zzi), Long.valueOf(this.zzj)});
    }
}
