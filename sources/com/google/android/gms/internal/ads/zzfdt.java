package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Callable;

public final class zzfdt {
    final /* synthetic */ zzfed zza;
    private final Object zzb;
    private final List zzc;

    /* synthetic */ zzfdt(zzfed zzfed, Object obj, List list, zzfds zzfds) {
        this.zza = zzfed;
        this.zzb = obj;
        this.zzc = list;
    }

    public final zzfec zza(Callable callable) {
        zzfwb zzb2 = zzfwc.zzb(this.zzc);
        zzfwm zza2 = zzb2.zza(zzfdr.zza, zzcae.zzf);
        zzfed zzfed = this.zza;
        return new zzfec(zzfed, this.zzb, (String) null, zza2, this.zzc, zzb2.zza(callable, zzfed.zzb), (zzfeb) null);
    }
}
