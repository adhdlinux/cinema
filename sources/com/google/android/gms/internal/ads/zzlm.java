package com.google.android.gms.internal.ads;

import com.facebook.common.time.Clock;

public final class zzlm {
    public static final zzlm zza;
    public static final zzlm zzb = new zzlm(Clock.MAX_TIME, Clock.MAX_TIME);
    public static final zzlm zzc = new zzlm(Clock.MAX_TIME, 0);
    public static final zzlm zzd = new zzlm(0, Clock.MAX_TIME);
    public static final zzlm zze;
    public final long zzf;
    public final long zzg;

    static {
        zzlm zzlm = new zzlm(0, 0);
        zza = zzlm;
        zze = zzlm;
    }

    public zzlm(long j2, long j3) {
        boolean z2;
        boolean z3 = true;
        if (j2 >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        zzdy.zzd(z2);
        zzdy.zzd(j3 < 0 ? false : z3);
        this.zzf = j2;
        this.zzg = j3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzlm.class == obj.getClass()) {
            zzlm zzlm = (zzlm) obj;
            return this.zzf == zzlm.zzf && this.zzg == zzlm.zzg;
        }
    }

    public final int hashCode() {
        return (((int) this.zzf) * 31) + ((int) this.zzg);
    }
}
