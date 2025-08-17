package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class zzdzk implements zzfem {
    private final Map zza = new HashMap();
    private final Map zzb = new HashMap();
    private final zzfeu zzc;

    public zzdzk(Set set, zzfeu zzfeu) {
        this.zzc = zzfeu;
        Iterator it2 = set.iterator();
        while (it2.hasNext()) {
            zzdzj zzdzj = (zzdzj) it2.next();
            this.zza.put(zzdzj.zzb, zzdzj.zza);
            this.zzb.put(zzdzj.zzc, zzdzj.zza);
        }
    }

    public final void zzbB(zzfef zzfef, String str) {
    }

    public final void zzbC(zzfef zzfef, String str, Throwable th) {
        this.zzc.zze("task.".concat(String.valueOf(str)), "f.");
        if (this.zzb.containsKey(zzfef)) {
            this.zzc.zze("label.".concat(String.valueOf((String) this.zzb.get(zzfef))), "f.");
        }
    }

    public final void zzc(zzfef zzfef, String str) {
        this.zzc.zzd("task.".concat(String.valueOf(str)));
        if (this.zza.containsKey(zzfef)) {
            this.zzc.zzd("label.".concat(String.valueOf((String) this.zza.get(zzfef))));
        }
    }

    public final void zzd(zzfef zzfef, String str) {
        this.zzc.zze("task.".concat(String.valueOf(str)), "s.");
        if (this.zzb.containsKey(zzfef)) {
            this.zzc.zze("label.".concat(String.valueOf((String) this.zzb.get(zzfef))), "s.");
        }
    }
}
