package com.google.android.gms.internal.ads;

import java.util.Iterator;

public final /* synthetic */ class zzewd implements zzfvj {
    public final /* synthetic */ zzewf zza;
    public final /* synthetic */ zzfcd zzb;
    public final /* synthetic */ zzcsk zzc;

    public /* synthetic */ zzewd(zzewf zzewf, zzfcd zzfcd, zzcsk zzcsk) {
        this.zza = zzewf;
        this.zzb = zzfcd;
        this.zzc = zzcsk;
    }

    public final zzfwm zza(Object obj) {
        zzfcd zzfcd = this.zzb;
        zzcsk zzcsk = this.zzc;
        zzezz zzezz = (zzezz) obj;
        zzfcd.zzb = zzezz;
        Iterator it2 = zzezz.zzb.zza.iterator();
        boolean z2 = false;
        loop0:
        while (true) {
            if (it2.hasNext()) {
                Iterator it3 = ((zzezn) it2.next()).zza.iterator();
                while (true) {
                    if (it3.hasNext()) {
                        if (!((String) it3.next()).contains("FirstPartyRenderer")) {
                            break loop0;
                        }
                        z2 = true;
                    }
                }
            } else if (z2) {
                return zzcsk.zzi(zzfwc.zzh(zzezz));
            }
        }
        return zzfwc.zzh((Object) null);
    }
}
