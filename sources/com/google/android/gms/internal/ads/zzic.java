package com.google.android.gms.internal.ads;

import android.os.SystemClock;

public final class zzic {
    private final long zza;
    private final long zzb;
    private long zzc = -9223372036854775807L;
    private long zzd = -9223372036854775807L;
    private long zze = -9223372036854775807L;
    private long zzf = -9223372036854775807L;
    private long zzg = -9223372036854775807L;
    private long zzh = -9223372036854775807L;
    private float zzi = 1.03f;
    private float zzj = 0.97f;
    private float zzk = 1.0f;
    private long zzl = -9223372036854775807L;
    private long zzm = -9223372036854775807L;
    private long zzn = -9223372036854775807L;

    /* synthetic */ zzic(float f2, float f3, long j2, float f4, long j3, long j4, float f5, zzib zzib) {
        this.zza = j3;
        this.zzb = j4;
    }

    private static long zzf(long j2, long j3, float f2) {
        return (long) ((((float) j2) * 0.999f) + (((float) j3) * 9.999871E-4f));
    }

    private final void zzg() {
        long j2 = this.zzc;
        if (j2 != -9223372036854775807L) {
            long j3 = this.zzd;
            if (j3 != -9223372036854775807L) {
                j2 = j3;
            }
            long j4 = this.zzf;
            if (j4 != -9223372036854775807L && j2 < j4) {
                j2 = j4;
            }
            long j5 = this.zzg;
            if (j5 != -9223372036854775807L && j2 > j5) {
                j2 = j5;
            }
        } else {
            j2 = -9223372036854775807L;
        }
        if (this.zze != j2) {
            this.zze = j2;
            this.zzh = j2;
            this.zzm = -9223372036854775807L;
            this.zzn = -9223372036854775807L;
            this.zzl = -9223372036854775807L;
        }
    }

    public final float zza(long j2, long j3) {
        if (this.zzc == -9223372036854775807L) {
            return 1.0f;
        }
        long j4 = j2 - j3;
        long j5 = this.zzm;
        if (j5 == -9223372036854775807L) {
            this.zzm = j4;
            this.zzn = 0;
        } else {
            long max = Math.max(j4, zzf(j5, j4, 0.999f));
            this.zzm = max;
            this.zzn = zzf(this.zzn, Math.abs(j4 - max), 0.999f);
        }
        if (this.zzl != -9223372036854775807L && SystemClock.elapsedRealtime() - this.zzl < 1000) {
            return this.zzk;
        }
        this.zzl = SystemClock.elapsedRealtime();
        long j6 = this.zzm + (this.zzn * 3);
        if (this.zzh > j6) {
            float zzo = (float) zzfj.zzo(1000);
            long[] jArr = {j6, this.zze, this.zzh - (((long) ((this.zzk - 4.0f) * zzo)) + ((long) ((this.zzi - 4.0f) * zzo)))};
            for (int i2 = 1; i2 < 3; i2++) {
                long j7 = jArr[i2];
                if (j7 > j6) {
                    j6 = j7;
                }
            }
            this.zzh = j6;
        } else {
            j6 = Math.max(this.zzh, Math.min(j2 - ((long) (Math.max(0.0f, this.zzk - 4.0f) / 1.0E-7f)), j6));
            this.zzh = j6;
            long j8 = this.zzg;
            if (j8 != -9223372036854775807L && j6 > j8) {
                this.zzh = j8;
                j6 = j8;
            }
        }
        long j9 = j2 - j6;
        if (Math.abs(j9) < this.zza) {
            this.zzk = 1.0f;
            return 1.0f;
        }
        float max2 = Math.max(this.zzj, Math.min((((float) j9) * 1.0E-7f) + 1.0f, this.zzi));
        this.zzk = max2;
        return max2;
    }

    public final long zzb() {
        return this.zzh;
    }

    public final void zzc() {
        long j2 = this.zzh;
        if (j2 != -9223372036854775807L) {
            long j3 = j2 + this.zzb;
            this.zzh = j3;
            long j4 = this.zzg;
            if (j4 != -9223372036854775807L && j3 > j4) {
                this.zzh = j4;
            }
            this.zzl = -9223372036854775807L;
        }
    }

    public final void zzd(zzbf zzbf) {
        long j2 = zzbf.zzc;
        this.zzc = zzfj.zzo(-9223372036854775807L);
        this.zzf = zzfj.zzo(-9223372036854775807L);
        this.zzg = zzfj.zzo(-9223372036854775807L);
        this.zzj = 0.97f;
        this.zzi = 1.03f;
        zzg();
    }

    public final void zze(long j2) {
        this.zzd = j2;
        zzg();
    }
}
