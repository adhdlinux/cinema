package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzbue;
import com.google.android.gms.internal.ads.zzduw;
import com.google.android.gms.internal.ads.zzfvj;
import com.google.android.gms.internal.ads.zzfwc;
import com.google.android.gms.internal.ads.zzfwm;
import java.util.concurrent.Executor;

public final class zzak implements zzfvj {
    private final Executor zza;
    private final zzduw zzb;

    public zzak(Executor executor, zzduw zzduw) {
        this.zza = executor;
        this.zzb = zzduw;
    }

    public final /* bridge */ /* synthetic */ zzfwm zza(Object obj) throws Exception {
        zzbue zzbue = (zzbue) obj;
        return zzfwc.zzm(this.zzb.zzb(zzbue), new zzaj(zzbue), this.zza);
    }
}
