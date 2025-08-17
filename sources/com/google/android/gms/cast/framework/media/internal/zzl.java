package com.google.android.gms.cast.framework.media.internal;

import android.graphics.Bitmap;

final class zzl implements zza {
    final /* synthetic */ zzn zza;
    final /* synthetic */ zzo zzb;

    zzl(zzo zzo, zzn zzn) {
        this.zzb = zzo;
        this.zza = zzn;
    }

    public final void zza(Bitmap bitmap) {
        zzn zzn = this.zza;
        zzn.zzb = bitmap;
        this.zzb.zzp = zzn;
        this.zzb.zzg();
    }
}
