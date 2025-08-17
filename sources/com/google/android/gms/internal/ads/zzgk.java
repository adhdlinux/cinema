package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzgk implements zzgd {
    private final Context zza;
    private final zzgd zzb;

    public zzgk(Context context) {
        zzgm zzgm = new zzgm();
        this.zza = context.getApplicationContext();
        this.zzb = zzgm;
    }

    public final /* bridge */ /* synthetic */ zzge zza() {
        return new zzgl(this.zza, ((zzgm) this.zzb).zza());
    }
}
