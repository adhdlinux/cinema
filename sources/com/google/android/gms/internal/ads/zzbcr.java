package com.google.android.gms.internal.ads;

public class zzbcr {
    private final String zza;
    private final Object zzb;
    private final int zzc;

    protected zzbcr(String str, Object obj, int i2) {
        this.zza = str;
        this.zzb = obj;
        this.zzc = i2;
    }

    public static zzbcr zza(String str, double d2) {
        return new zzbcr(str, Double.valueOf(d2), 3);
    }

    public static zzbcr zzb(String str, long j2) {
        return new zzbcr(str, Long.valueOf(j2), 2);
    }

    public static zzbcr zzc(String str, String str2) {
        return new zzbcr(str, str2, 4);
    }

    public static zzbcr zzd(String str, boolean z2) {
        return new zzbcr(str, Boolean.valueOf(z2), 1);
    }

    public final Object zze() {
        zzbdu zza2 = zzbdw.zza();
        if (zza2 == null) {
            if (zzbdw.zzb() != null) {
                zzbdw.zzb().zza();
            }
            return this.zzb;
        }
        int i2 = this.zzc - 1;
        if (i2 == 0) {
            return zza2.zza(this.zza, ((Boolean) this.zzb).booleanValue());
        }
        if (i2 == 1) {
            return zza2.zzc(this.zza, ((Long) this.zzb).longValue());
        }
        if (i2 != 2) {
            return zza2.zzd(this.zza, (String) this.zzb);
        }
        return zza2.zzb(this.zza, ((Double) this.zzb).doubleValue());
    }
}
