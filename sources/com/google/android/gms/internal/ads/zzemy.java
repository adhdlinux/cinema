package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.atomic.AtomicReference;

public final class zzemy implements zzeqy {
    private final AtomicReference zza = new AtomicReference();
    private final Clock zzb;
    private final zzeqy zzc;
    private final long zzd;

    public zzemy(zzeqy zzeqy, long j2, Clock clock) {
        this.zzb = clock;
        this.zzc = zzeqy;
        this.zzd = j2;
    }

    public final int zza() {
        return 16;
    }

    public final zzfwm zzb() {
        zzemx zzemx = (zzemx) this.zza.get();
        if (zzemx == null || zzemx.zza()) {
            zzemx = new zzemx(this.zzc.zzb(), this.zzd, this.zzb);
            this.zza.set(zzemx);
        }
        return zzemx.zza;
    }
}
