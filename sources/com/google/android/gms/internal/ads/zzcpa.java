package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.ScheduledExecutorService;

public final class zzcpa implements zzgwe {
    private final zzgwr zza;
    private final zzgwr zzb;

    public zzcpa(zzgwr zzgwr, zzgwr zzgwr2) {
        this.zza = zzgwr;
        this.zzb = zzgwr2;
    }

    /* renamed from: zza */
    public final zzcxv zzb() {
        return new zzcxv((ScheduledExecutorService) this.zza.zzb(), (Clock) this.zzb.zzb());
    }
}
