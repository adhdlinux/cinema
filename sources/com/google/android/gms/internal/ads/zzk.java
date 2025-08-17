package com.google.android.gms.internal.ads;

public final class zzk {
    public static final zzk zza = new zzk(0, 0, 1, 1, 0, (zzj) null);
    public static final zzn zzb = zze.zza;
    private static final String zzd = Integer.toString(0, 36);
    private static final String zze = Integer.toString(1, 36);
    private static final String zzf = Integer.toString(2, 36);
    private static final String zzg = Integer.toString(3, 36);
    private static final String zzh = Integer.toString(4, 36);
    public final int zzc = 1;
    private zzi zzi;

    /* synthetic */ zzk(int i2, int i3, int i4, int i5, int i6, zzj zzj) {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzk.class != obj.getClass()) {
            return false;
        }
        zzk zzk = (zzk) obj;
        return true;
    }

    public final int hashCode() {
        return 486696559;
    }

    public final zzi zza() {
        if (this.zzi == null) {
            this.zzi = new zzi(this, (zzh) null);
        }
        return this.zzi;
    }
}
