package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zze;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

public class zzdqh {
    protected final String zza = ((String) zzbcz.zzb.zze());
    protected final Map zzb = new HashMap();
    protected final Executor zzc;
    protected final zzbzw zzd;
    protected final boolean zze;
    private final zzfff zzf;
    private final boolean zzg;
    private final boolean zzh;

    protected zzdqh(Executor executor, zzbzw zzbzw, zzfff zzfff) {
        this.zzc = executor;
        this.zzd = zzbzw;
        this.zze = ((Boolean) zzba.zzc().zzb(zzbbm.zzbQ)).booleanValue();
        this.zzf = zzfff;
        this.zzg = ((Boolean) zzba.zzc().zzb(zzbbm.zzbT)).booleanValue();
        this.zzh = ((Boolean) zzba.zzc().zzb(zzbbm.zzgO)).booleanValue();
    }

    private final void zza(Map map, boolean z2) {
        if (!map.isEmpty()) {
            String zza2 = this.zzf.zza(map);
            zze.zza(zza2);
            boolean parseBoolean = Boolean.parseBoolean((String) map.get("scar"));
            if (!this.zze) {
                return;
            }
            if (z2 && !this.zzg) {
                return;
            }
            if (!parseBoolean || this.zzh) {
                this.zzc.execute(new zzdqg(this, zza2));
                return;
            }
            return;
        }
        zzbzr.zze("Empty paramMap.");
    }

    /* access modifiers changed from: protected */
    public final String zzb(Map map) {
        return this.zzf.zza(map);
    }

    public final ConcurrentHashMap zzc() {
        return new ConcurrentHashMap(this.zzb);
    }

    public final void zzd(Map map) {
        zza(map, true);
    }

    public final void zze(Map map) {
        zza(map, false);
    }
}
