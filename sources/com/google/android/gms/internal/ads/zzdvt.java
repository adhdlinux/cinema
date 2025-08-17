package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;

final class zzdvt implements zzcyb {
    private final Context zza;
    private final zzbxw zzb;

    zzdvt(Context context, zzbxw zzbxw) {
        this.zza = context;
        this.zzb = zzbxw;
    }

    public final void zzb(zzezz zzezz) {
        if (!TextUtils.isEmpty(zzezz.zzb.zzb.zzd)) {
            this.zzb.zzp(this.zza, zzezz.zza.zza.zzd);
            this.zzb.zzl(this.zza, zzezz.zzb.zzb.zzd);
        }
    }

    public final void zzbA(zzbue zzbue) {
    }
}
