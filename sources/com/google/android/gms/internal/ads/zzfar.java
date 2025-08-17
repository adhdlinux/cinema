package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;
import java.util.Iterator;
import java.util.List;

public final class zzfar {
    private final zzezn zza;
    private final zzezq zzb;
    private final zzeba zzc;
    private final zzfgr zzd;
    private final zzffy zze;

    public zzfar(zzeba zzeba, zzfgr zzfgr, zzezn zzezn, zzezq zzezq, zzffy zzffy) {
        this.zza = zzezn;
        this.zzb = zzezq;
        this.zzc = zzeba;
        this.zzd = zzfgr;
        this.zze = zzffy;
    }

    public final void zza(List list) {
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            zzb((String) it2.next(), 2);
        }
    }

    public final void zzb(String str, int i2) {
        if (!this.zza.zzaj) {
            this.zzd.zzc(str, this.zze);
            return;
        }
        this.zzc.zzd(new zzebc(zzt.zzB().currentTimeMillis(), this.zzb.zzb, str, i2));
    }

    public final void zzc(List list, int i2) {
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            zzb((String) it2.next(), i2);
        }
    }
}
