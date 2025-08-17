package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.common.util.Clock;

public final class zzbwx implements zzgwe {
    private final zzgwr zza;
    private final zzgwr zzb;
    private final zzgwr zzc;

    public zzbwx(zzgwr zzgwr, zzgwr zzgwr2, zzgwr zzgwr3) {
        this.zza = zzgwr;
        this.zzb = zzgwr2;
        this.zzc = zzgwr3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzbww((Clock) this.zza.zzb(), (zzg) this.zzb.zzb(), (zzbxw) this.zzc.zzb());
    }
}
