package com.google.android.gms.internal.ads;

final class zzkn {
    public final zzto zza;
    public final long zzb;
    public final long zzc;
    public final long zzd;
    public final long zze;
    public final boolean zzf;
    public final boolean zzg;
    public final boolean zzh;
    public final boolean zzi;

    zzkn(zzto zzto, long j2, long j3, long j4, long j5, boolean z2, boolean z3, boolean z4, boolean z5) {
        boolean z6;
        boolean z7 = true;
        if (!z5 || z3) {
            z6 = true;
        } else {
            z6 = false;
        }
        zzdy.zzd(z6);
        if (z4 && !z3) {
            z7 = false;
        }
        zzdy.zzd(z7);
        this.zza = zzto;
        this.zzb = j2;
        this.zzc = j3;
        this.zzd = j4;
        this.zze = j5;
        this.zzf = false;
        this.zzg = z3;
        this.zzh = z4;
        this.zzi = z5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzkn.class == obj.getClass()) {
            zzkn zzkn = (zzkn) obj;
            if (this.zzb == zzkn.zzb && this.zzc == zzkn.zzc && this.zzd == zzkn.zzd && this.zze == zzkn.zze && this.zzg == zzkn.zzg && this.zzh == zzkn.zzh && this.zzi == zzkn.zzi && zzfj.zzC(this.zza, zzkn.zza)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        int i2 = (int) this.zzb;
        int i3 = (int) this.zzc;
        return ((((((((((((((this.zza.hashCode() + 527) * 31) + i2) * 31) + i3) * 31) + ((int) this.zzd)) * 31) + ((int) this.zze)) * 961) + (this.zzg ? 1 : 0)) * 31) + (this.zzh ? 1 : 0)) * 31) + (this.zzi ? 1 : 0);
    }

    public final zzkn zza(long j2) {
        if (j2 == this.zzc) {
            return this;
        }
        return new zzkn(this.zza, this.zzb, j2, this.zzd, this.zze, false, this.zzg, this.zzh, this.zzi);
    }

    public final zzkn zzb(long j2) {
        if (j2 == this.zzb) {
            return this;
        }
        return new zzkn(this.zza, j2, this.zzc, this.zzd, this.zze, false, this.zzg, this.zzh, this.zzi);
    }
}
