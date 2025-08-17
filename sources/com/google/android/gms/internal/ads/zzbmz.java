package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzbb;

public final class zzbmz {
    static final zzbb zza = new zzbmx();
    static final zzbb zzb = new zzbmy();
    private final zzbml zzc;

    public zzbmz(Context context, zzbzx zzbzx, String str, zzfgb zzfgb) {
        this.zzc = new zzbml(context, zzbzx, str, zza, zzb, zzfgb);
    }

    public final zzbmp zza(String str, zzbms zzbms, zzbmr zzbmr) {
        return new zzbnd(this.zzc, str, zzbms, zzbmr);
    }

    public final zzbni zzb() {
        return new zzbni(this.zzc);
    }
}
