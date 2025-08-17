package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import java.util.Map;
import java.util.concurrent.Executor;

@Deprecated
public final class zzdqa {
    /* access modifiers changed from: private */
    public final zzdqf zza;
    /* access modifiers changed from: private */
    public final Executor zzb;
    /* access modifiers changed from: private */
    public final Map zzc;

    public zzdqa(zzdqf zzdqf, Executor executor) {
        this.zza = zzdqf;
        this.zzc = zzdqf.zza();
        this.zzb = executor;
    }

    public final zzdpz zza() {
        zzdpz zzdpz = new zzdpz(this);
        zzdpz unused = zzdpz.zzb.putAll(zzdpz.zza.zzc);
        return zzdpz;
    }

    public final void zze() {
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzjZ)).booleanValue()) {
            zzdpz zza2 = zza();
            zza2.zzb("action", "pecr");
            zza2.zzg();
        }
    }
}
