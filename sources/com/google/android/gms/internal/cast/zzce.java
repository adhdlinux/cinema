package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.Cast;

final class zzce extends Cast.Listener {
    final /* synthetic */ zzcf zza;

    zzce(zzcf zzcf) {
        this.zza = zzcf;
    }

    public final void onVolumeChanged() {
        this.zza.zza();
    }
}
