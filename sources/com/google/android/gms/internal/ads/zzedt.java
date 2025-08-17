package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

public final /* synthetic */ class zzedt implements Callable {
    public final /* synthetic */ zzedw zza;
    public final /* synthetic */ zzezz zzb;
    public final /* synthetic */ zzezn zzc;

    public /* synthetic */ zzedt(zzedw zzedw, zzezz zzezz, zzezn zzezn) {
        this.zza = zzedw;
        this.zzb = zzezz;
        this.zzc = zzezn;
    }

    public final Object call() {
        return this.zza.zzc(this.zzb, this.zzc);
    }
}
