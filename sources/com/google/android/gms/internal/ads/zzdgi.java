package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

public final class zzdgi implements zzgwe {
    private final zzgwr zza;
    private final zzgwr zzb;
    private final zzgwr zzc;
    private final zzgwr zzd;

    public zzdgi(zzgwr zzgwr, zzgwr zzgwr2, zzgwr zzgwr3, zzgwr zzgwr4) {
        this.zza = zzgwr;
        this.zzb = zzgwr2;
        this.zzc = zzgwr3;
        this.zzd = zzgwr4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcoh((Executor) this.zzb.zzb(), new zzcnt((Context) this.zzc.zzb(), (zzatw) this.zza.zzb()), (Clock) this.zzd.zzb());
    }
}
