package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

@Deprecated
public final class zzdqf extends zzdqh {
    private final zzffd zzf;

    public zzdqf(Executor executor, zzbzw zzbzw, zzffd zzffd, zzfff zzfff) {
        super(executor, zzbzw, zzfff);
        this.zzf = zzffd;
        zzffd.zza(this.zzb);
    }

    public final Map zza() {
        return new HashMap(this.zzb);
    }
}
