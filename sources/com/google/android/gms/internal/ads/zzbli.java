package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Predicate;

public final /* synthetic */ class zzbli implements Predicate {
    public final /* synthetic */ zzbij zza;

    public /* synthetic */ zzbli(zzbij zzbij) {
        this.zza = zzbij;
    }

    public final boolean apply(Object obj) {
        zzbij zzbij = this.zza;
        zzbij zzbij2 = (zzbij) obj;
        if (!(zzbij2 instanceof zzbln) || !((zzbln) zzbij2).zzb.equals(zzbij)) {
            return false;
        }
        return true;
    }
}
