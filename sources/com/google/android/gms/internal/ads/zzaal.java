package com.google.android.gms.internal.ads;

public class zzaal implements zzabv {
    private final long zza;
    private final long zzb;
    private final int zzc;
    private final long zzd;
    private final int zze;
    private final long zzf;

    public zzaal(long j2, long j3, int i2, int i3, boolean z2) {
        long zzb2;
        this.zza = j2;
        this.zzb = j3;
        this.zzc = i3 == -1 ? 1 : i3;
        this.zze = i2;
        if (j2 == -1) {
            this.zzd = -1;
            zzb2 = -9223372036854775807L;
        } else {
            this.zzd = j2 - j3;
            zzb2 = zzb(j2, j3, i2);
        }
        this.zzf = zzb2;
    }

    private static long zzb(long j2, long j3, int i2) {
        return (Math.max(0, j2 - j3) * 8000000) / ((long) i2);
    }

    public final long zza(long j2) {
        return zzb(j2, this.zzb, this.zze);
    }

    public final long zze() {
        return this.zzf;
    }

    public final zzabt zzg(long j2) {
        long j3 = this.zzd;
        int i2 = (j3 > -1 ? 1 : (j3 == -1 ? 0 : -1));
        if (i2 != 0) {
            long j4 = (long) this.zzc;
            long j5 = (((((long) this.zze) * j2) / 8000000) / j4) * j4;
            if (i2 != 0) {
                j5 = Math.min(j5, j3 - j4);
            }
            long max = this.zzb + Math.max(j5, 0);
            long zza2 = zza(max);
            zzabw zzabw = new zzabw(zza2, max);
            if (this.zzd != -1 && zza2 < j2) {
                long j6 = max + ((long) this.zzc);
                if (j6 < this.zza) {
                    return new zzabt(zzabw, new zzabw(zza(j6), j6));
                }
            }
            return new zzabt(zzabw, zzabw);
        }
        zzabw zzabw2 = new zzabw(0, this.zzb);
        return new zzabt(zzabw2, zzabw2);
    }

    public final boolean zzh() {
        return this.zzd != -1;
    }
}
