package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.concurrent.Executor;

public final class zzdks {
    private final Executor zza;
    private final zzcoh zzb;
    private final zzdco zzc;

    zzdks(Executor executor, zzcoh zzcoh, zzdco zzdco) {
        this.zza = executor;
        this.zzc = zzdco;
        this.zzb = zzcoh;
    }

    public final void zza(zzcez zzcez) {
        if (zzcez != null) {
            this.zzc.zza(zzcez.zzF());
            this.zzc.zzm(new zzdko(zzcez), this.zza);
            this.zzc.zzm(new zzdkp(zzcez), this.zza);
            this.zzc.zzm(this.zzb, this.zza);
            this.zzb.zzf(zzcez);
            zzcez.zzad("/trackActiveViewUnit", new zzdkq(this));
            zzcez.zzad("/untrackActiveViewUnit", new zzdkr(this));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(zzcez zzcez, Map map) {
        this.zzb.zzb();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzcez zzcez, Map map) {
        this.zzb.zza();
    }
}
