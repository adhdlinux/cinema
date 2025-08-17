package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;

final class zzdlw implements zzbij {
    final /* synthetic */ zzdlx zza;
    private final WeakReference zzb;
    private final String zzc;
    private final zzbij zzd;

    /* synthetic */ zzdlw(zzdlx zzdlx, WeakReference weakReference, String str, zzbij zzbij, zzdlv zzdlv) {
        this.zza = zzdlx;
        this.zzb = weakReference;
        this.zzc = str;
        this.zzd = zzbij;
    }

    public final void zza(Object obj, Map map) {
        Object obj2 = this.zzb.get();
        if (obj2 == null) {
            this.zza.zzk(this.zzc, this);
        } else {
            this.zzd.zza(obj2, map);
        }
    }
}
