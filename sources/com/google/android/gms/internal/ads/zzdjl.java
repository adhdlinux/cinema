package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzbo;
import com.google.android.gms.common.util.Clock;

public final class zzdjl implements zzgwe {
    private final zzgwr zza;
    private final zzgwr zzb;
    private final zzgwr zzc;

    public zzdjl(zzgwr zzgwr, zzgwr zzgwr2, zzgwr zzgwr3) {
        this.zza = zzgwr;
        this.zzb = zzgwr2;
        this.zzc = zzgwr3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfwn zzfwn = zzcae.zza;
        zzgwm.zzb(zzfwn);
        return new zzdjk((zzbo) this.zza.zzb(), (Clock) this.zzb.zzb(), zzfwn);
    }
}
