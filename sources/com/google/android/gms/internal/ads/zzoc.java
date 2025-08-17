package com.google.android.gms.internal.ads;

import android.media.metrics.LogSessionId;

public final class zzoc {
    public static final zzoc zza = (zzfj.zza < 31 ? new zzoc() : new zzoc(zzob.zza));
    private final zzob zzb;

    public zzoc() {
        this.zzb = null;
        zzdy.zzf(zzfj.zza < 31);
    }

    private zzoc(zzob zzob) {
        this.zzb = zzob;
    }

    public final LogSessionId zza() {
        zzob zzob = this.zzb;
        zzob.getClass();
        return zzob.zzb;
    }

    public zzoc(LogSessionId logSessionId) {
        this.zzb = new zzob(logSessionId);
    }
}
