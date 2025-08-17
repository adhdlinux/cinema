package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

public final /* synthetic */ class zzbxr implements Callable {
    public final /* synthetic */ zzbxw zza;
    public final /* synthetic */ Context zzb;

    public /* synthetic */ zzbxr(zzbxw zzbxw, Context context) {
        this.zza = zzbxw;
        this.zzb = context;
    }

    public final Object call() {
        return this.zza.zzg(this.zzb);
    }
}
