package com.google.android.gms.internal.ads;

import com.facebook.common.time.Clock;

public final class zzfh {
    private long zza;
    private long zzb;
    private long zzc;
    private final ThreadLocal zzd = new ThreadLocal();

    public zzfh(long j2) {
        zzf(0);
    }

    public final synchronized long zza(long j2) {
        if (this.zzb == -9223372036854775807L) {
            long j3 = this.zza;
            if (j3 == 9223372036854775806L) {
                Long l2 = (Long) this.zzd.get();
                l2.getClass();
                j3 = l2.longValue();
            }
            this.zzb = j3 - j2;
            notifyAll();
        }
        this.zzc = j2;
        return j2 + this.zzb;
    }

    public final synchronized long zzb(long j2) {
        if (j2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long j3 = this.zzc;
        if (j3 != -9223372036854775807L) {
            long j4 = (j3 * 90000) / 1000000;
            long j5 = (4294967296L + j4) / 8589934592L;
            long j6 = ((-1 + j5) * 8589934592L) + j2;
            j2 += j5 * 8589934592L;
            if (Math.abs(j6 - j4) < Math.abs(j2 - j4)) {
                j2 = j6;
            }
        }
        return zza((j2 * 1000000) / 90000);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0019, code lost:
        return -9223372036854775807L;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized long zzc() {
        /*
            r5 = this;
            monitor-enter(r5)
            long r0 = r5.zza     // Catch:{ all -> 0x001f }
            r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x0018
            r2 = 9223372036854775806(0x7ffffffffffffffe, double:NaN)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x0016
            goto L_0x0018
        L_0x0016:
            monitor-exit(r5)
            return r0
        L_0x0018:
            monitor-exit(r5)
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            return r0
        L_0x001f:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfh.zzc():long");
    }

    public final synchronized long zzd() {
        long j2;
        j2 = this.zzc;
        return j2 != -9223372036854775807L ? j2 + this.zzb : zzc();
    }

    public final synchronized long zze() {
        return this.zzb;
    }

    public final synchronized void zzf(long j2) {
        this.zza = j2;
        this.zzb = j2 == Clock.MAX_TIME ? 0 : -9223372036854775807L;
        this.zzc = -9223372036854775807L;
    }
}
