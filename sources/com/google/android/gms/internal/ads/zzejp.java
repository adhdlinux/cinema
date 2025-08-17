package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzdg;
import com.google.android.gms.ads.internal.client.zzs;
import java.util.concurrent.atomic.AtomicReference;

public final class zzejp implements zzcxr {
    private final AtomicReference zza = new AtomicReference();

    public final void zza(zzdg zzdg) {
        this.zza.set(zzdg);
    }

    public final void zzh(zzs zzs) {
        zzews.zza(this.zza, new zzejo(zzs));
    }
}
