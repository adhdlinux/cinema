package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;
import java.util.concurrent.Callable;

public final /* synthetic */ class zzemz implements Callable {
    public final /* synthetic */ zzena zza;

    public /* synthetic */ zzemz(zzena zzena) {
        this.zza = zzena;
    }

    public final Object call() {
        return new zzenb(Long.valueOf(zzt.zzB().currentTimeMillis() - zzt.zzo().zzh().zzh().zza()).longValue());
    }
}
