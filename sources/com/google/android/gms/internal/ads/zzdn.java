package com.google.android.gms.internal.ads;

public final class zzdn {
    public static final zzdn zza = new zzdn(0, 0, 0, 1.0f);
    public static final zzn zzb = zzdm.zza;
    private static final String zzg = Integer.toString(0, 36);
    private static final String zzh = Integer.toString(1, 36);
    private static final String zzi = Integer.toString(2, 36);
    private static final String zzj = Integer.toString(3, 36);
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final float zzf;

    public zzdn(int i2, int i3, int i4, float f2) {
        this.zzc = i2;
        this.zzd = i3;
        this.zze = i4;
        this.zzf = f2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzdn) {
            zzdn zzdn = (zzdn) obj;
            if (this.zzc == zzdn.zzc && this.zzd == zzdn.zzd && this.zze == zzdn.zze && this.zzf == zzdn.zzf) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return ((((((this.zzc + 217) * 31) + this.zzd) * 31) + this.zze) * 31) + Float.floatToRawIntBits(this.zzf);
    }
}
