package com.google.android.gms.internal.ads;

public final class zzbf {
    public static final zzbf zza = new zzbf(new zzbd());
    public static final zzn zzb = zzbc.zza;
    private static final String zzh = Integer.toString(0, 36);
    private static final String zzi = Integer.toString(1, 36);
    private static final String zzj = Integer.toString(2, 36);
    private static final String zzk = Integer.toString(3, 36);
    private static final String zzl = Integer.toString(4, 36);
    public final long zzc;
    public final long zzd;
    public final long zze;
    public final float zzf;
    public final float zzg;

    private zzbf(zzbd zzbd) {
        this.zzc = -9223372036854775807L;
        this.zzd = -9223372036854775807L;
        this.zze = -9223372036854775807L;
        this.zzf = -3.4028235E38f;
        this.zzg = -3.4028235E38f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbf)) {
            return false;
        }
        long j2 = ((zzbf) obj).zzc;
        return true;
    }

    public final int hashCode() {
        int i2 = (int) -9223372034707292159L;
        return (((((((i2 * 31) + i2) * 31) + i2) * 31) + Float.floatToIntBits(-3.4028235E38f)) * 31) + Float.floatToIntBits(-3.4028235E38f);
    }
}
