package com.google.android.gms.internal.ads;

import android.util.Pair;

final class zzafu implements zzafz {
    private final long[] zza;
    private final long[] zzb;
    private final long zzc;

    private zzafu(long[] jArr, long[] jArr2, long j2) {
        this.zza = jArr;
        this.zzb = jArr2;
        this.zzc = j2 == -9223372036854775807L ? zzfj.zzo(jArr2[jArr2.length - 1]) : j2;
    }

    public static zzafu zza(long j2, zzaer zzaer, long j3) {
        int length = zzaer.zzd.length;
        int i2 = length + 1;
        long[] jArr = new long[i2];
        long[] jArr2 = new long[i2];
        jArr[0] = j2;
        long j4 = 0;
        jArr2[0] = 0;
        for (int i3 = 1; i3 <= length; i3++) {
            int i4 = i3 - 1;
            j2 += (long) (zzaer.zzb + zzaer.zzd[i4]);
            j4 += (long) (zzaer.zzc + zzaer.zze[i4]);
            jArr[i3] = j2;
            jArr2[i3] = j4;
        }
        return new zzafu(jArr, jArr2, j3);
    }

    private static Pair zzd(long j2, long[] jArr, long[] jArr2) {
        double d2;
        int zzc2 = zzfj.zzc(jArr, j2, true, true);
        long j3 = jArr[zzc2];
        long j4 = jArr2[zzc2];
        int i2 = zzc2 + 1;
        if (i2 == jArr.length) {
            return Pair.create(Long.valueOf(j3), Long.valueOf(j4));
        }
        long j5 = jArr[i2];
        long j6 = jArr2[i2];
        if (j5 == j3) {
            d2 = 0.0d;
        } else {
            d2 = (((double) j2) - ((double) j3)) / ((double) (j5 - j3));
        }
        return Pair.create(Long.valueOf(j2), Long.valueOf(((long) (d2 * ((double) (j6 - j4)))) + j4));
    }

    public final long zzb() {
        return -1;
    }

    public final long zzc(long j2) {
        return zzfj.zzo(((Long) zzd(j2, this.zza, this.zzb).second).longValue());
    }

    public final long zze() {
        return this.zzc;
    }

    public final zzabt zzg(long j2) {
        Pair zzd = zzd(zzfj.zzq(Math.max(0, Math.min(j2, this.zzc))), this.zzb, this.zza);
        zzabw zzabw = new zzabw(zzfj.zzo(((Long) zzd.first).longValue()), ((Long) zzd.second).longValue());
        return new zzabt(zzabw, zzabw);
    }

    public final boolean zzh() {
        return true;
    }
}
