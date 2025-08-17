package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Callable;

public final /* synthetic */ class zzera implements Callable {
    public final /* synthetic */ List zza;
    public final /* synthetic */ Object zzb;

    public /* synthetic */ zzera(List list, Object obj) {
        this.zza = list;
        this.zzb = obj;
    }

    public final Object call() {
        List<zzfwm> list = this.zza;
        Object obj = this.zzb;
        for (zzfwm zzfwm : list) {
            zzeqx zzeqx = (zzeqx) zzfwm.get();
            if (zzeqx != null) {
                zzeqx.zzh(obj);
            }
        }
        return obj;
    }
}
