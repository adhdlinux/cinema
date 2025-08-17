package com.google.android.gms.internal.ads;

import android.view.View;

public abstract class zzfgw {
    public static zzfgw zza(zzfgx zzfgx, zzfgy zzfgy) {
        if (zzfgu.zzb()) {
            return new zzfha(zzfgx, zzfgy);
        }
        throw new IllegalStateException("Method called before OM SDK activation");
    }

    public abstract void zzb(View view, zzfhc zzfhc, String str);

    public abstract void zzc();

    public abstract void zzd(View view);

    public abstract void zze();
}
