package com.google.android.gms.internal.ads;

public final class zzct {
    public static final zzn zza = zzcs.zza;
    private static final String zzh = Integer.toString(0, 36);
    private static final String zzi = Integer.toString(1, 36);
    private static final String zzj = Integer.toString(2, 36);
    private static final String zzk = Integer.toString(3, 36);
    private static final String zzl = Integer.toString(4, 36);
    public Object zzb;
    public Object zzc;
    public int zzd;
    public long zze;
    public long zzf;
    public boolean zzg;
    private zzd zzm = zzd.zza;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzct.class.equals(obj.getClass())) {
            zzct zzct = (zzct) obj;
            if (!zzfj.zzC(this.zzb, zzct.zzb) || !zzfj.zzC(this.zzc, zzct.zzc) || this.zzd != zzct.zzd || this.zze != zzct.zze || this.zzg != zzct.zzg || !zzfj.zzC(this.zzm, zzct.zzm)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i2;
        Object obj = this.zzb;
        int i3 = 0;
        if (obj == null) {
            i2 = 0;
        } else {
            i2 = obj.hashCode();
        }
        Object obj2 = this.zzc;
        if (obj2 != null) {
            i3 = obj2.hashCode();
        }
        int i4 = ((((i2 + 217) * 31) + i3) * 31) + this.zzd;
        long j2 = this.zze;
        return (((((i4 * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 961) + (this.zzg ? 1 : 0)) * 31) + this.zzm.hashCode();
    }

    public final int zza(int i2) {
        return this.zzm.zza(i2).zzc;
    }

    public final int zzb() {
        int i2 = this.zzm.zzc;
        return 0;
    }

    public final int zzc(long j2) {
        return -1;
    }

    public final int zzd(long j2) {
        this.zzm.zzb(-1);
        return -1;
    }

    public final int zze(int i2) {
        return this.zzm.zza(i2).zza(-1);
    }

    public final int zzf(int i2, int i3) {
        return this.zzm.zza(i2).zza(i3);
    }

    public final int zzg() {
        int i2 = this.zzm.zze;
        return 0;
    }

    public final long zzh(int i2, int i3) {
        zzc zza2 = this.zzm.zza(i2);
        if (zza2.zzc != -1) {
            return zza2.zzf[i3];
        }
        return -9223372036854775807L;
    }

    public final long zzi(int i2) {
        long j2 = this.zzm.zza(i2).zzb;
        return 0;
    }

    public final long zzj() {
        long j2 = this.zzm.zzd;
        return 0;
    }

    public final long zzk(int i2) {
        long j2 = this.zzm.zza(i2).zzg;
        return 0;
    }

    public final zzct zzl(Object obj, Object obj2, int i2, long j2, long j3, zzd zzd2, boolean z2) {
        this.zzb = obj;
        this.zzc = obj2;
        this.zzd = 0;
        this.zze = j2;
        this.zzf = 0;
        this.zzm = zzd2;
        this.zzg = z2;
        return this;
    }

    public final boolean zzm(int i2) {
        zzb();
        if (i2 != -1) {
            return false;
        }
        this.zzm.zzb(-1);
        return false;
    }

    public final boolean zzn(int i2) {
        boolean z2 = this.zzm.zza(i2).zzh;
        return false;
    }
}
