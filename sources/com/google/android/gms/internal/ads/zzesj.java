package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzesj implements zzeqy {
    private final Context zza;
    private final String zzb;
    private final zzfwn zzc;

    public zzesj(zzbug zzbug, Context context, String str, zzfwn zzfwn) {
        this.zza = context;
        this.zzb = str;
        this.zzc = zzfwn;
    }

    public final int zza() {
        return 42;
    }

    public final zzfwm zzb() {
        return this.zzc.zzb(new zzesi(this));
    }
}
