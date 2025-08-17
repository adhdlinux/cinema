package com.google.android.gms.internal.ads;

import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.android.gms.common.util.Clock;

public final class zzenh implements zzgwe {
    private final zzgwr zza;
    private final zzgwr zzb;

    public zzenh(zzgwr zzgwr, zzgwr zzgwr2) {
        this.zza = zzgwr;
        this.zzb = zzgwr2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzemy(((zzemt) this.zza).zzb(), NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS, (Clock) this.zzb.zzb());
    }
}
