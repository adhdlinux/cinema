package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class zzdqd implements zzfem {
    private final Map zza = new HashMap();
    private final zzdpv zzb;
    private final Clock zzc;
    private final Map zzd = new HashMap();

    public zzdqd(zzdpv zzdpv, Set set, Clock clock) {
        this.zzb = zzdpv;
        Iterator it2 = set.iterator();
        while (it2.hasNext()) {
            zzdqc zzdqc = (zzdqc) it2.next();
            this.zzd.put(zzdqc.zzc, zzdqc);
        }
        this.zzc = clock;
    }

    private final void zze(zzfef zzfef, boolean z2) {
        String str;
        zzfef zzb2 = ((zzdqc) this.zzd.get(zzfef)).zzb;
        if (this.zza.containsKey(zzb2)) {
            if (true != z2) {
                str = "f.";
            } else {
                str = "s.";
            }
            long elapsedRealtime = this.zzc.elapsedRealtime() - ((Long) this.zza.get(zzb2)).longValue();
            this.zzb.zza().put("label.".concat(((zzdqc) this.zzd.get(zzfef)).zza), str.concat(String.valueOf(Long.toString(elapsedRealtime))));
        }
    }

    public final void zzbB(zzfef zzfef, String str) {
    }

    public final void zzbC(zzfef zzfef, String str, Throwable th) {
        if (this.zza.containsKey(zzfef)) {
            this.zzb.zza().put("task.".concat(String.valueOf(str)), "f.".concat(String.valueOf(Long.toString(this.zzc.elapsedRealtime() - ((Long) this.zza.get(zzfef)).longValue()))));
        }
        if (this.zzd.containsKey(zzfef)) {
            zze(zzfef, false);
        }
    }

    public final void zzc(zzfef zzfef, String str) {
        this.zza.put(zzfef, Long.valueOf(this.zzc.elapsedRealtime()));
    }

    public final void zzd(zzfef zzfef, String str) {
        if (this.zza.containsKey(zzfef)) {
            long elapsedRealtime = this.zzc.elapsedRealtime() - ((Long) this.zza.get(zzfef)).longValue();
            this.zzb.zza().put("task.".concat(String.valueOf(str)), "s.".concat(String.valueOf(Long.toString(elapsedRealtime))));
        }
        if (this.zzd.containsKey(zzfef)) {
            zze(zzfef, true);
        }
    }
}
