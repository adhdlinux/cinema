package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzw;
import java.util.concurrent.Executor;

final class zzewj implements zzfcp {
    public final zzexd zza;
    public final zzexf zzb;
    public final zzl zzc;
    public final String zzd;
    public final Executor zze;
    public final zzw zzf;
    public final zzfce zzg;

    public zzewj(zzexd zzexd, zzexf zzexf, zzl zzl, String str, Executor executor, zzw zzw, zzfce zzfce) {
        this.zza = zzexd;
        this.zzb = zzexf;
        this.zzc = zzl;
        this.zzd = str;
        this.zze = executor;
        this.zzf = zzw;
        this.zzg = zzfce;
    }

    public final zzfce zza() {
        return this.zzg;
    }

    public final Executor zzb() {
        return this.zze;
    }
}
