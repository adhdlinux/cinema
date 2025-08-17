package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzcul;
import com.google.android.gms.internal.ads.zzfef;
import com.google.android.gms.internal.ads.zzfel;
import com.google.android.gms.internal.ads.zzgwe;
import com.google.android.gms.internal.ads.zzgwr;
import java.util.concurrent.TimeUnit;

public final class zzai implements zzgwe {
    private final zzgwr zza;
    private final zzgwr zzb;
    private final zzgwr zzc;

    public zzai(zzgwr zzgwr, zzgwr zzgwr2, zzgwr zzgwr3) {
        this.zza = zzgwr;
        this.zzb = zzgwr2;
        this.zzc = zzgwr3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return ((zzfel) this.zza.zzb()).zzb(zzfef.GENERATE_SIGNALS, ((zzcul) this.zzc).zzb().zzc()).zzf(((zzal) this.zzb).zzb()).zzi((long) ((Integer) zzba.zzc().zzb(zzbbm.zzfm)).intValue(), TimeUnit.SECONDS).zza();
    }
}
