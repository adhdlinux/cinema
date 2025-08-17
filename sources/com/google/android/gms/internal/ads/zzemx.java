package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

final class zzemx {
    public final zzfwm zza;
    private final long zzb;
    private final Clock zzc;

    public zzemx(zzfwm zzfwm, long j2, Clock clock) {
        this.zza = zzfwm;
        this.zzc = clock;
        this.zzb = clock.elapsedRealtime() + j2;
    }

    public final boolean zza() {
        return this.zzb < this.zzc.elapsedRealtime();
    }
}
