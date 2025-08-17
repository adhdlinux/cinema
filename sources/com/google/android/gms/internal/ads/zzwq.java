package com.google.android.gms.internal.ads;

import android.media.Spatializer;

final class zzwq implements Spatializer.OnSpatializerStateChangedListener {
    final /* synthetic */ zzwy zza;

    zzwq(zzwr zzwr, zzwy zzwy) {
        this.zza = zzwy;
    }

    public final void onSpatializerAvailableChanged(Spatializer spatializer, boolean z2) {
        this.zza.zzu();
    }

    public final void onSpatializerEnabledChanged(Spatializer spatializer, boolean z2) {
        this.zza.zzu();
    }
}
