package com.google.android.gms.internal.ads;

import com.facebook.common.time.Clock;

public final class zzsy implements zzvh {
    protected final zzvh[] zza;

    public zzsy(zzvh[] zzvhArr) {
        this.zza = zzvhArr;
    }

    public final long zzb() {
        long j2 = Long.MAX_VALUE;
        for (zzvh zzb : this.zza) {
            long zzb2 = zzb.zzb();
            if (zzb2 != Long.MIN_VALUE) {
                j2 = Math.min(j2, zzb2);
            }
        }
        if (j2 == Clock.MAX_TIME) {
            return Long.MIN_VALUE;
        }
        return j2;
    }

    public final long zzc() {
        long j2 = Long.MAX_VALUE;
        for (zzvh zzc : this.zza) {
            long zzc2 = zzc.zzc();
            if (zzc2 != Long.MIN_VALUE) {
                j2 = Math.min(j2, zzc2);
            }
        }
        if (j2 == Clock.MAX_TIME) {
            return Long.MIN_VALUE;
        }
        return j2;
    }

    public final void zzm(long j2) {
        for (zzvh zzm : this.zza) {
            zzm.zzm(j2);
        }
    }

    public final boolean zzo(long j2) {
        boolean z2;
        long j3 = j2;
        boolean z3 = false;
        while (true) {
            long zzc = zzc();
            if (zzc == Long.MIN_VALUE) {
                break;
            }
            boolean z4 = false;
            for (zzvh zzvh : this.zza) {
                long zzc2 = zzvh.zzc();
                if (zzc2 == Long.MIN_VALUE || zzc2 > j3) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (zzc2 == zzc || z2) {
                    z4 |= zzvh.zzo(j3);
                }
            }
            z3 |= z4;
            if (!z4) {
                break;
            }
        }
        return z3;
    }

    public final boolean zzp() {
        for (zzvh zzp : this.zza) {
            if (zzp.zzp()) {
                return true;
            }
        }
        return false;
    }
}
