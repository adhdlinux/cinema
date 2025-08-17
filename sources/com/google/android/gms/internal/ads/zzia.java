package com.google.android.gms.internal.ads;

public final class zzia {
    public final String zza;
    public final zzam zzb;
    public final zzam zzc;
    public final int zzd;
    public final int zze;

    public zzia(String str, zzam zzam, zzam zzam2, int i2, int i3) {
        boolean z2 = true;
        if (i2 != 0) {
            if (i3 == 0) {
                i3 = 0;
            } else {
                z2 = false;
            }
        }
        zzdy.zzd(z2);
        zzdy.zzc(str);
        this.zza = str;
        zzam.getClass();
        this.zzb = zzam;
        zzam2.getClass();
        this.zzc = zzam2;
        this.zzd = i2;
        this.zze = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzia.class == obj.getClass()) {
            zzia zzia = (zzia) obj;
            if (this.zzd != zzia.zzd || this.zze != zzia.zze || !this.zza.equals(zzia.zza) || !this.zzb.equals(zzia.zzb) || !this.zzc.equals(zzia.zzc)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((this.zzd + 527) * 31) + this.zze) * 31) + this.zza.hashCode()) * 31) + this.zzb.hashCode()) * 31) + this.zzc.hashCode();
    }
}
